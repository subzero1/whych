package com.ivhhs.wechat.msg.Resp;

/**
 * ��Ӧ��Ϣ����
 * 
 * @author ivhhs
 * @date 2014.10.16
 */
public class BaseMessage {
	// ���շ��ʺţ��յ���OpenID��
	private String ToUserName;
	// ������΢�ź�
	private String FromUserName;
	// ��Ϣ����ʱ�� �����ͣ�
	private long CreateTime;
	// ��Ϣ���ͣ�text/music/news��
	private String MsgType;
	// λ0x0001����־ʱ���Ǳ���յ�����Ϣ
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