package com.company.project.configurer;


import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class ServerListener {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String args[]) throws InterruptedException {
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();

        NioEventLoopGroup wokerGroup = new NioEventLoopGroup();

        try{

            ServerBootstrap bootstrap = new ServerBootstrap();

            bootstrap.group(bossGroup,wokerGroup)
                    .channel(NioServerSocketChannel.class)
                    
                    .childHandler(new ServerInitializer());
                    

            ChannelFuture channelFuture = bootstrap.bind(22222).sync();
            channelFuture.channel().closeFuture().sync();
            
           

        } finally {
            bossGroup.shutdownGracefully();
            wokerGroup.shutdownGracefully();
        }


	}
	

}
