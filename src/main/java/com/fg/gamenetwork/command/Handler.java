package com.fg.gamenetwork.command;

import com.fg.gamenetwork.message.Message;

public abstract class Handler implements ICommand {
	//消息体
	private Message message;
	//执行者
	private Object executor;
	//创建时间
	private long createTime;

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public Object getExecutor() {
		return executor;
	}

	public void setExecutor(Object executor) {
		this.executor = executor;
	}

	public long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}
}
