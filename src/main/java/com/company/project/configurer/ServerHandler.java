package com.company.project.configurer;


import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class ServerHandler extends ChannelHandlerAdapter {
	@Override
	public void channelRead(ChannelHandlerContext ctx,Object msg)
	            throws Exception{
	        ByteBuf buf = (ByteBuf)msg;
	        byte[]req = new byte[buf.readableBytes()];
	        buf.readBytes(req);
	        String body = new String(req,"UTF-8");
	        System.out.println("the time server order : " + body);
	        
	        String asci = convertHexToString(body);
	        System.out.println("the asci order : " + asci);

	       
	        ctx.write("data received");
	    }
	@Override
	    public void channelReadComplete(ChannelHandlerContext ctx)throws Exception{
	        ctx.flush(); 
	    }

	    @Override
	    public void exceptionCaught(ChannelHandlerContext ctx,Throwable cause){
	        ctx.close();
	    }
	    
	   
	    
	    public String convertHexToString(String hex){

	  	  StringBuilder sb = new StringBuilder();
	  	  StringBuilder temp = new StringBuilder();

	  	  //49204c6f7665204a617661 split into two characters 49, 20, 4c...
	  	  for( int i=0; i<hex.length()-1; i+=2 ){

	  	      //grab the hex in pairs
	  	      String output = hex.substring(i, (i + 2));
	  	      //convert hex to decimal
	  	      int decimal = Integer.parseInt(output, 16);
	  	      //convert the decimal to character
	  	      sb.append((char)decimal);

	  	      temp.append(decimal);
	  	  }

	  	  return sb.toString();
	  	  }



}


