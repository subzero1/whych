package com.ivhhs.wechat.msg;

/**
 * mpnews��Ϣ��װ��
 * 
 * @author ivhhs
 * @date 2014.10.16
 */
public class Articles {
	private String thumb_media_id;// ͼ����Ϣ����ͼ��media_id,
									// �������ϴ���ý���ļ��ӿ��л�á��˴�thumb_media_id���ϴ��ӿڷ��ص�media_id
	private String author;// ͼ����Ϣ������
	private String content_source_url;// ͼ����Ϣ������Ķ�ԭ�ġ�֮���ҳ������
	private String Content;// ͼ����Ϣ�����ݣ�֧��html��ǩ
	private String digest;// ͼ����Ϣ������
	private String show_cover_pic;// �Ƿ���ʾ���棬1Ϊ��ʾ��0Ϊ����ʾ

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String Content) {
		this.Content = Content;
	}

	public String getContent_source_url() {
		return content_source_url;
	}

	public void setContent_source_url(String content_source_url) {
		this.content_source_url = content_source_url;
	}

	public String getDigest() {
		return digest;
	}

	public void setDigest(String digest) {
		this.digest = digest;
	}

	public String getShow_cover_pic() {
		return show_cover_pic;
	}

	public void setShow_cover_pic(String show_cover_pic) {
		this.show_cover_pic = show_cover_pic;
	}

	public String getThumb_media_id() {
		return thumb_media_id;
	}

	public void setThumb_media_id(String thumb_media_id) {
		this.thumb_media_id = thumb_media_id;
	}
}