package com.fg.gamenetwork.codec;

import com.fg.gamenetwork.message.Message;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class MMessageTobyteEncoder extends MessageToByteEncoder<Message>{

	@Override
	protected void encode(ChannelHandlerContext ctx, Message msg, ByteBuf out) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
