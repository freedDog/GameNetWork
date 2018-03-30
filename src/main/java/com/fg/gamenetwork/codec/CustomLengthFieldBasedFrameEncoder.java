package com.fg.gamenetwork.codec;

import com.fg.gamenetwork.message.Message;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class CustomLengthFieldBasedFrameEncoder extends MessageToByteEncoder<Integer>{

	@Override
	protected void encode(ChannelHandlerContext ctx, Integer msg, ByteBuf out) throws Exception {
		System.out.println("encode");
		out.writeInt(msg);
	}

}
