package com.ivhhs.wechat.msg.Resp;

import java.util.List;

/**
 * ͼ����Ϣ
 * 
 * @author ivhhs
 * @date 2014.10.16
 */
public class NewsMessage extends BaseMessage {
	// ͼ����Ϣ����������Ϊ10������
	private int articleCount;
	// ����ͼ����Ϣ��Ϣ��Ĭ�ϵ�һ��itemΪ��ͼ
	private List<Article> articles;

	public int getArticleCount() {
		return articleCount;
	}

	public void setArticleCount(int articleCount) {
		this.articleCount = articleCount;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
}