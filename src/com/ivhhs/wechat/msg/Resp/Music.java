package com.ivhhs.wechat.msg.Resp;

/**
 * ����model
 * 
 * @author ivhhs
 * @date 2014.10.16
 */
public class Music {
	// ��������
	private String title;
	// ��������
	private String description;
	// ��������
	private String musicUrl;
	// �������������ӣ�WIFI��������ʹ�ø����Ӳ�������
	private String hqMusicUrl;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMusicUrl() {
		return musicUrl;
	}

	public void setMusicUrl(String musicUrl) {
		this.musicUrl = musicUrl;
	}

	public String getHQMusicUrl() {
		return hqMusicUrl;
	}

	public void setHQMusicUrl(String hqMusicUrl) {
		this.hqMusicUrl = hqMusicUrl;
	}
}