package com.fg.gamenetwork.codec;

import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

public class MLengthFieldBasedFrameDecoder extends LengthFieldBasedFrameDecoder{

	public MLengthFieldBasedFrameDecoder(int maxFrameLength, int lengthFieldOffset, int lengthFieldLength) {
		super(maxFrameLength, lengthFieldOffset, lengthFieldLength);
	}

}
