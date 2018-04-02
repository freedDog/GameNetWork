package com.fg.gamenetwork.message;

import io.netty.buffer.ByteBuf;

public class TestMessage extends Message{
	@Override
	public int getId() {
		return 1000;	
	}
	@Override
	public String getQueue() {
		return "";
	}
	@Override
	public long getSendId() {
		return System.currentTimeMillis();
	}
	@Override
	public int getSendTime() {
		return 0;
	}
	@Override
	public String getServer() {
		return "";
	}
	@Override
	public boolean read(ByteBuf  byteBuf) {
		return true;
	}
	@Override
	public boolean write(ByteBuf byteBuf) {
		this.writeInt(byteBuf, this.getId());
		this.writeLong(byteBuf, this.getSendId());
		return true;
	}
}

