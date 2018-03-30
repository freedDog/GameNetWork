package com.fg.gamenetwork.channel;

import com.fg.gamenetwork.codec.CustomLengthFieldBasedFrameDecoder;
import com.fg.gamenetwork.codec.CustomLengthFieldBasedFrameEncoder;
import com.fg.gamenetwork.handler.CustomInboundHandler;
import com.fg.gamenetwork.handler.CustomOutHandler;
import com.fg.gamenetwork.server.IServerScript;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
/**
 * 基于消息头长度来解析消息
 * @author JiangBangMing
 *
 * 2018年3月30日 下午2:51:17
 */
public class LengthBasedInitializer extends ChannelInitializer<Channel>{
	private IServerScript serverScript;
	public LengthBasedInitializer(IServerScript serverScript) {
		this.serverScript=serverScript;
	}
	@Override
	protected void initChannel(Channel ch) throws Exception {
		ChannelPipeline pipeline=ch.pipeline();
		pipeline.addLast("OutHandler",new CustomOutHandler());
		pipeline.addLast("encoder",new CustomLengthFieldBasedFrameEncoder());
		
		pipeline.addLast("decoder",new CustomLengthFieldBasedFrameDecoder());
		pipeline.addLast("InHandler",new CustomInboundHandler(this.serverScript));
	}

}
