package com.fg.gamenetwork.message;

import com.fg.gamenetwork.message.Bean;

/**
 * 消息基础类
 */
public abstract  class Message extends Bean{
	private long sendId;
	private int sendTime;
	
	public abstract int getId();
	
	public abstract String getQueue();

	public abstract String getServer();	

	public void setSendId(long sendId) {
			this.sendId = sendId;
	}

	public long getSendId() {
			return sendId;
	}

	public void setSendTime(int sendTime) {
			this.sendTime = sendTime;
	}

	public int getSendTime() {
			return sendTime;
	}
}

