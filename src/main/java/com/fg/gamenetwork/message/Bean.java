package com.fg.gamenetwork.message;

import io.netty.buffer.ByteBuf;

import java.io.UnsupportedEncodingException;

/**
 * 消息基础bean
 */
public abstract class Bean {
	/**
	 * 写数据
	 */
	public abstract boolean write(ByteBuf buf);
	/**
	 * 读数据
	 */
	public abstract boolean read(ByteBuf buf);

	protected void writeByteCheck(ByteBuf buf,byte value){
		if(value!=0){
			buf.writeByte(value);	
		}
	}
	protected void writeByte(ByteBuf buf,byte value){
		buf.writeByte(value);	
	}

	protected void writeShortCheck(ByteBuf buf,short value){
		if(value!=0){
			buf.writeShort(value);	
		}	
	}
	protected void writeShort(ByteBuf buf,short value){
		buf.writeShort(value);	
	}
	
	protected void writeIntCheck(ByteBuf buf,int value){
		if(value!=0){
			buf.writeInt(value);	
		}
	}	
	protected void writeInt(ByteBuf buf,int value){
		buf.writeInt(value);	
	}
	protected void writeLongCheck(ByteBuf buf,long value){
		if(value!=0){
			buf.writeLong(value);	
		}	
	}
	protected void writeLong(ByteBuf buf,long value){
		buf.writeLong(value);	
	}
	
	protected void writeStringCheck(ByteBuf buf,String value){
		if(value!=null&&!value.equals("")){
			try{
				byte[] bytes=value.getBytes("UTF-8");		
				buf.writeInt(bytes.length);
				buf.writeBytes(bytes);
			}catch(UnsupportedEncodingException e){
					
			}	
		}	
	}
	protected void writeString(ByteBuf buf,String value){
		if(null==value){
			buf.writeInt(0);
			return;	
		}	
		try{
			byte[] bytes=value.getBytes("UTF-8");
			buf.writeInt(bytes.length);
			buf.writeBytes(bytes);
		}catch(UnsupportedEncodingException e){
		
		}
	}
	
	protected void writeBytesCheck(ByteBuf buf,byte[] value){
		if(value!=null){
			buf.writeInt(value.length);
			buf.writeBytes(value);	
		}	
	}
	protected void writeBytes(ByteBuf buf,byte[] value){
		if(null==value){
			buf.writeInt(0);
			return;	
		}
		buf.writeInt(value.length);
		buf.writeBytes(value);
	}

	protected void writeBeanCheck(ByteBuf buf,Bean value){
		if(value!=null)	{
			value.write(buf);	
		}
	}
	protected void writeBean(ByteBuf buf,Bean value){
		value.write(buf);	
	}

	protected byte readByte(ByteBuf buf){
		return buf.readByte();	
	}
	protected short readShort(ByteBuf buf){
		return buf.readShort();	
	}
	protected int readInt(ByteBuf buf){
		return buf.readInt();	
	}
	protected long readLong(ByteBuf buf){
		return buf.readLong();	
	}
	protected String readString(ByteBuf buf){
		int length=buf.readInt();
		if(length<=0){
			return null;	
		}
		if(buf.readableBytes()<length){
			return null;	
		}
		byte[] bytes=new byte[length];
		buf.readBytes(bytes);
		try{
			return new String(bytes,"UTF-8");
		}catch(UnsupportedEncodingException e){
			return null;
		}
	}
	protected byte[] readBytes(ByteBuf buf){
		int length=buf.readInt();
		if(length<=0){
			return new byte[0];	
		}	
		byte[] bytes=new byte[length];
		buf.readBytes(bytes);
		return bytes;
	}
	protected Bean readBean(ByteBuf buf,Class<? extends Bean> clazz){
		try{
			Bean bean=(Bean)clazz.newInstance();
			bean.read(buf);
			return bean;
		}catch(IllegalAccessException e){
			return null;	
		}catch(InstantiationException e){
			return null;	
		}	
	
	}
}


