package com.ivhhs.wechat.msg.Resp;

/**
 * ������Ϣ
 * 
 * @author ivhhs
 * @date 2014.10.16
 */
public class VoiceMessage extends BaseMessage {
	// ����
	private Voice voice;

	public Voice getVoice() {
		return voice;
	}

	public void setVoice(Voice voice) {
		this.voice = voice;
	}
}