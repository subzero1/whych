package com.ivhhs.wechat.msg.Resp;

/**
 * 响应消息基类
 * 
 * @author ivhhs
 * @date 2014.10.16
 */
public class BaseMessage {
	// 接收方帐号（收到的OpenID）
	private String ToUserName;
	// 开发者微信号
	private String FromUserName;
	// 消息创建时间 （整型）
	private long CreateTime;
	// 消息类型（text/music/news）
	private String MsgType;
	// 位0x0001被标志时，星标刚收到的消息
	//private int funcFlag;

	public String getToUserName() {
		return ToUserName;
	}

	public void setToUserName(String ToUserName) {
		this.ToUserName = ToUserName;
	}

	public String getFromUserName() {
		return FromUserName;
	}

	public void setFromUserName(String FromUserName) {
		this.FromUserName = FromUserName;
	}

	public long getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(long CreateTime) {
		this.CreateTime = CreateTime;
	}

	public String getMsgType() {
		return MsgType;
	}

	public void setMsgType(String MsgType) {
		this.MsgType = MsgType;
	}  
	/*
	public int getFuncFlag() {
		return funcFlag;
	}

	public void setFuncFlag(int funcFlag) {
		this.funcFlag = funcFlag;
	}
	*/
}