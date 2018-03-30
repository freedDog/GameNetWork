package com.fg.gamenetwork.server;

public interface IServerScript {
	/**
	 * 初始化
	 */
	public void init();
	/**
	 * 执行消息
	 */
	public void doCommand();
	public void exceptionCaught();
}
