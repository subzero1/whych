package com.ivhhs.wechat.msg.Resp;

/**
 * ��Ƶ��Ϣ
 * 
 * @author ivhhs
 * @date 2014.10.16
 */
public class VideoMessage extends BaseMessage {
	// ��Ƶ
	private Video video;

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}
}