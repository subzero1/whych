package com.ivhhs.wechat.msg.Resp;

/**
 * ��Ƶ
 * 
 * @author ivhhs
 * @date 2014.10.16
 */
public class Video {
	// ý���ļ�id
	private String mediaId;
	// ����ͼ��ý��id
	private String thumbMediaId;

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public String getThumbMediaId() {
		return thumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId;
	}
}