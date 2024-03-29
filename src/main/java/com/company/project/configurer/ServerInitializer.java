package com.company.project.configurer;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;

public  class ServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
      ChannelPipeline pipeline = ch.pipeline();

      //���ݷְ��������ճ��
//      pipeline.addLast(new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE,0,4,0,4));
//      pipeline.addLast(new LengthFieldPrepender(4));
//
//      pipeline.addLast(new StringDecoder(CharsetUtil.UTF_8));
//      pipeline.addLast(new StringEncoder(CharsetUtil.UTF_8));
//      pipeline.addLast(new LineBasedFrameDecoder(1024));
//      pipeline.addLast(new StringDecoder());
      pipeline.addLast(new ServerHandler());


    }
}
