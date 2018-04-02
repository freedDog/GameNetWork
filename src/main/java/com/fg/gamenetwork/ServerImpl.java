package com.fg.gamenetwork;

import com.fg.gamenetwork.message.TestMessage;
import com.fg.gamenetwork.server.IServerScript;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

public class ServerImpl implements IServerScript{

	public void init() {
		// TODO Auto-generated method stub
		
	}

	public void doCommand(ChannelHandlerContext ctx, Object msg) {
		System.out.println("read message");
		ByteBuf in=(ByteBuf)msg;
		//打印接受到的消息
		System.out.println("Server received:"+in.readInt());
		//将消息返回给发送者，而不冲刷出站消息
//		ctx.pipeline().channel().write(7);
		TestMessage msgs=new TestMessage();
		ctx.write(msgs);
		
	}


	public void channelCreate(ChannelHandlerContext ctx) {
		// TODO Auto-generated method stub
		
	}


	public void channelUnregistered(ChannelHandlerContext ctx) {
		// TODO Auto-generated method stub
		
	}

	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
		
	}

	public void channelReadComplete(ChannelHandlerContext ctx) {
		// TODO Auto-generated method stub
		
	}

	public void channelActive(ChannelHandlerContext ctx) {
		// TODO Auto-generated method stub
		
	}

}
