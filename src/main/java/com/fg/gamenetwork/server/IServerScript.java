package com.fg.gamenetwork.server;

import io.netty.channel.ChannelHandlerContext;

public interface IServerScript {
	/**
	 * 初始化
	 */
	public void init();
	/**
	 * 执行消息
	 */
	public void doCommand(ChannelHandlerContext ctx,Object msg);
	/**
	 * 创建连接
	 * @param ctx
	 */
	public void channelCreate(ChannelHandlerContext ctx);
	/**
	 * 关闭连接
	 * @param ctx
	 */
	public void channelUnregistered(ChannelHandlerContext ctx);
	/**
	 * 异常处理
	 */
	public void exceptionCaught(ChannelHandlerContext ctx,Throwable cause);
	/**
	 * 消息读取完毕
	 * @param ctx
	 */
	public void channelReadComplete(ChannelHandlerContext ctx);
	/**
	 * 激活
	 * @param ctx
	 */
	public void channelActive(ChannelHandlerContext ctx);
}
