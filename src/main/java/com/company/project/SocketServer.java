package com.company.project;


import com.company.project.convert.HexConvert;
import com.company.project.convert.LoopResponse;
import com.company.project.model.Rawdata;
import com.company.project.service.RawdataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.util.Date;
import java.util.Set;

/**
 * nio socket服务端
 */
@Component
@Configuration
public class SocketServer implements ApplicationRunner {

    @Resource
    private RawdataService rawdataService;

    private Logger log = LoggerFactory.getLogger(getClass());

    //解码buffer
    private Charset cs = Charset.forName("UTF-8");
    //发送数据缓冲区
    private static ByteBuffer sBuffer = ByteBuffer.allocate(1024);
    //接受数据缓冲区
    private static ByteBuffer rBuffer = ByteBuffer.allocate(1024);
    //选择器（叫监听器更准确些吧应该）
    private static Selector selector;

    @Override
    public void run(ApplicationArguments var1) throws Exception {
        startSocketServer(6653);
    }


    /**
     * 启动socket服务，开启监听
     *
     * @param port
     * @throws IOException
     */
    public void startSocketServer(int port) {
        try {
            //打开通信信道
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            //设置为非阻塞
            serverSocketChannel.configureBlocking(false);
            //获取套接字
            ServerSocket serverSocket = serverSocketChannel.socket();
            //绑定端口号
            serverSocket.bind(new InetSocketAddress(port));
            //打开监听器
            selector = Selector.open();
            //将通信信道注册到监听器
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

            //监听器会一直监听，如果客户端有请求就会进入相应的事件处理
            while (true) {

                selector.select();//select方法会一直阻塞直到有相关事件发生或超时
                Set<SelectionKey> selectionKeys = selector.selectedKeys();//监听到的事件
                for (SelectionKey key : selectionKeys) {
                    handle(key);
                }
                selectionKeys.clear();//清除处理过的事件
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    /**
     * 处理不同的事件
     *
     * @param selectionKey
     * @throws IOException
     * @throws ParseException
     */
    private void handle(SelectionKey selectionKey) throws IOException, ParseException {
        ServerSocketChannel serverSocketChannel = null;
        SocketChannel socketChannel = null;
        String requestMsg = "";
        int count = 0;
        if (selectionKey.isAcceptable()) {
            //每有客户端连接，即注册通信信道为可读
            serverSocketChannel = (ServerSocketChannel) selectionKey.channel();
            socketChannel = serverSocketChannel.accept();
            socketChannel.configureBlocking(false);
            socketChannel.register(selector, SelectionKey.OP_READ);
        } else if (selectionKey.isReadable()) {

            socketChannel = (SocketChannel) selectionKey.channel();
            try {
                count = socketChannel.read(rBuffer);
            } catch (Exception e) {
                log.info(e.getMessage());
                selectionKey.cancel();
                return;
            }
            if (count <= 0) {
                selectionKey.cancel();
                return;
            }
            //读取数据

            rBuffer.flip();
            System.out.println("count:" + count);
            requestMsg = String.valueOf(cs.decode(rBuffer).array());
            log.info("接收的字符串" + requestMsg);
            System.out.println("#######:" + requestMsg.length());

            // requestMsg = requestMsg.replace(" ", "");
            byte[] bytes = decodeValue(rBuffer);
            String hex = HexConvert.bytesToHexString(bytes);

            //String hexString= new String(requestMsg.getBytes("UTF-8"));


            // requestMsg = HexConvert.convertStringToHex(requestMsg);
            System.out.println("转换后的格式" + hex);
            LoopResponse lr = null;
            if ("fffd".equals(requestMsg)) {
                log.info("输出内容:" + requestMsg);
            } else {
                try {
                    //requestMsg = requestMsg.replace(" ", "");// 去除空格

                    //byte[] data = HexConvert.hexStringToBytes(requestMsg);
                    // rBuffer.flip();
                    // byte[] data1 = decodeValue(rBuffer);
                    lr = new LoopResponse(bytes);

                    //TODO 存储
                    log.info("接到的内容:" + lr.toString());

                } catch (Exception e) {
                    e.printStackTrace();
                    log.info(e.getMessage());
                }
            }
            if (lr != null) {
                rawdataService.save(convertRawdata(lr));
            }


            //返回数据
	        /*
            sBuffer = ByteBuffer.allocate(responseMsg.getBytes("UTF-8").length);
            sBuffer.put(responseMsg.getBytes("UTF-8"));
            sBuffer.flip();
            */
            socketChannel.write(sBuffer);
//            socketChannel.close();
        }
    }

    public byte[] decodeValue(ByteBuffer bytes) {
        bytes.flip();
        int len = bytes.limit() - bytes.position();
        byte[] bytes1 = new byte[len];
        int i = 0;
        while (bytes.remaining() > 0) {
            byte b = bytes.get();
            bytes1[i++] = b;
        }

        //bytes.get(bytes1);
        return bytes1;
    }


    private Rawdata convertRawdata(LoopResponse lr) {
        Rawdata rawdata = new Rawdata();
        rawdata.setDate(new Date());
        rawdata.setBar(lr.getBarTrend());
        rawdata.setEt(lr.getDailyET());
        rawdata.setRain(lr.getDailyRain());
        rawdata.setDewpt(lr.getDewPoint());
        rawdata.setHeatIndex(lr.getHeatIndex());
        rawdata.setInHum(lr.getInsideHumidity());
        rawdata.setInTemp(lr.getInsideTemp());
        rawdata.setOuthum(lr.getOutsideHumidity());
        rawdata.setTempout(lr.getOutsideTemp());
        rawdata.setRainRate(lr.getRainRate());
        rawdata.setHiSolarRad(lr.getSolarRadiation());
        //rawdata.setRain(lr.getStormRain());
        rawdata.setThswIndex(lr.getThswIndex());
        rawdata.setUvIndex(lr.getUv());
        rawdata.setWindChill(lr.getWindChill());
        rawdata.setWindDir(lr.getWindDirection());
        rawdata.setWindSpeed(lr.getWindSpeed());
        return rawdata;
    }


}