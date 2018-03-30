package com.fg.gamenetwork;

import java.net.InetSocketAddress;
import com.fg.gamenetwork.channel.LengthBasedInitializer;
import com.fg.gamenetwork.config.NetWorkServerConfig;
import com.fg.gamenetwork.server.IServerScript;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class EchoServer {
	private final NetWorkServerConfig serverConfig;
	public EchoServer(NetWorkServerConfig config) {
		this.serverConfig=config;
	}
	public static void main(String[] args) {
		NetWorkServerConfig config=new NetWorkServerConfig();
		config.setIp("192.168.4.94");
		config.setPort(9000);
		try {
			new EchoServer(config).start(new ServerImpl());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * @throws Exception
	 */
	public void start(IServerScript serverScript) throws Exception{
		EventLoopGroup group=new NioEventLoopGroup();
		try {
			ServerBootstrap b=new ServerBootstrap();
			b.group(group).channel(NioServerSocketChannel.class)
			.localAddress(new InetSocketAddress(serverConfig.getPort()))
			.childHandler(new LengthBasedInitializer(serverScript));
			ChannelFuture f=b.bind().sync();
			f.channel().closeFuture().sync();
		}finally {
			group.shutdownGracefully().sync();
		}
	}
}
