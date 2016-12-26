package com.ivhhs.wechat.msg.Resp;

/**
 * ”Ô“Ùœ˚œ¢
 * 
 * @author ivhhs
 * @date 2014.10.16
 */
public class VoiceMessage extends BaseMessage {
	// ”Ô“Ù
	private Voice voice;

	public Voice getVoice() {
		return voice;
	}

	public void setVoice(Voice voice) {
		this.voice = voice;
	}
}