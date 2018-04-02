package com.fg.gamenetwork.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

public class CustomLengthFieldBasedFrameDecoder extends LengthFieldBasedFrameDecoder{
	private final static int maxFrameLength=1024;
	private final static int lengthFieldOffset=0;
	private final static int lengthFieldLength=4;
	public CustomLengthFieldBasedFrameDecoder() {
		super(maxFrameLength, lengthFieldOffset, lengthFieldLength);
	}
	@Override
	protected Object decode(ChannelHandlerContext ctx, ByteBuf in) throws Exception {
		ByteBuf buf=(ByteBuf)super.decode(ctx, in);
		buf.readInt();
		return buf;
	}
	

}
