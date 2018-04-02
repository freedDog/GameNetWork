package com.fg.gamenetwork;

import java.net.InetSocketAddress;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.CharsetUtil;

public class ClientBootstrap {
	public static void main(String[] args) {
		new ClientBootstrap().start();
	}
	public void start() {
		EventLoopGroup group=new NioEventLoopGroup();
		Bootstrap bootstrap=new Bootstrap();
		bootstrap.group(group).channel(NioSocketChannel.class)
		.remoteAddress(new InetSocketAddress("127.0.0.1",9000))
		.handler(new SimpleChannelInboundHandler<ByteBuf>() {

			@Override
			public void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
				System.out.println("client received:"+msg.readInt()+" id="+msg.readLong());
			}

			@Override
			public void channelActive(ChannelHandlerContext ctx) throws Exception {
				ByteBufAllocator allocator=ctx.alloc();
				ByteBuf buf=allocator.buffer();
				buf.writeInt(4);
				buf.writeInt(49);
				ctx.writeAndFlush(buf);
//				ctx.writeAndFlush("123456".getBytes());
			}
			
		});
		ChannelFuture f;
		try {
			f = bootstrap.connect().sync();
			f.addListener(new ChannelFutureListener() {
				public void operationComplete(ChannelFuture future) throws Exception {
					if(future.isSuccess()) {
						System.out.println("connection established");
					}else {
						System.out.println("connection attempt failed");
						future.cause().printStackTrace();
					}
				}
			});
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
