package com.fg.gamenetwork.message;

import java.util.HashMap;

import com.fg.gamenetwork.command.Handler;

public  class MessagePool {
	private HashMap<Integer, Class<?>> messges=new HashMap<Integer, Class<?>>();
	private HashMap<Integer,Class<?>> handlers=new HashMap<Integer, Class<?>>();
	private static MessagePool messagePool;
	private MessagePool() {}
	public static MessagePool getInstance() {
		if(messagePool!=null) {
			messagePool=new MessagePool();
			messagePool.register(1000, TestMessage.class, null);
		}
		return messagePool;
	}
	/**
	 * 获取消息
	 * @param id
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public Message getMessage(int id) throws InstantiationException, IllegalAccessException {
		if(!this.messges.containsKey(id)) {
			return null;
		}
		return (Message)this.messges.get(id).newInstance();
	}
	/**
	 * 获取处理对象
	 * @param id
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public Handler getHandler(int id) throws InstantiationException, IllegalAccessException {
		if(!this.handlers.containsKey(id)) {
			return null;
		}
		return (Handler)this.handlers.get(id).newInstance();
	}
	/**
	 * 注册消息
	 * @param id
	 * @param messageClass
	 * @param handlerClass
	 */
	public void register(int id,Class<?> messageClass,Class<?> handlerClass) {
		if(messageClass!=null) {
			this.messges.put(id, messageClass);	
		}
		if(handlerClass!=null) {
			this.handlers.put(id, handlerClass);
		}
	}
}
