package com.ivhhs.wechat.msg.Resp;

/**
 * ͼ��model
 * 
 * @author ivhhs
 * @date 2014.10.16
 */
public class Article {
	// ͼ����Ϣ����
	private String title;
	// ͼ����Ϣ����
	private String description;
	// ͼƬ���ӣ�֧��JPG��PNG��ʽ���Ϻõ�Ч��Ϊ��ͼ640*320��Сͼ80*80������ͼƬ���ӵ�������Ҫ�뿪������д�Ļ��������е�Urlһ��
	private String picUrl;
	// ���ͼ����Ϣ��ת����
	private String url;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return null == description ? "" : description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPicUrl() {
		return null == picUrl ? "" : picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getUrl() {
		return null == url ? "" : url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}