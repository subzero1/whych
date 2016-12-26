package com.ivhhs.wechat.contacts;

import com.ivhhs.wechat.ParamesAPI.ParamesAPI;
import com.ivhhs.wechat.ParamesAPI.WeixinUtil;

/**
 * ͨѶ¼��ǩ������
 * 
 * @author ivhhs
 * @date 2014.10.16
 */
public class Tag {
	// ������ǩ��ַ
	public static String CREATE_TAG_URL = "https://qyapi.weixin.qq.com/cgi-bin/tag/create?access_token=ACCESS_TOKEN";
	// ���±�ǩ��ַ
	public static String UPDATA_TAG_URL = "https://qyapi.weixin.qq.com/cgi-bin/tag/update?access_token=ACCESS_TOKEN";
	// ɾ����ǩ��ַ
	public static String DELETE_TAG_URL = "https://qyapi.weixin.qq.com/cgi-bin/tag/delete?access_token=ACCESS_TOKEN&tagid=ID";
	// ��ȡ��ǩ��Ա��ַ
	public static String GET_TAG_PERSON = "https://qyapi.weixin.qq.com/cgi-bin/tag/get?access_token=ACCESS_TOKEN&tagid=ID";
	// ���ӱ�ǩ��Ա��ַ
	public static String ADD_TAG_PERSON = "https://qyapi.weixin.qq.com/cgi-bin/tag/addtagusers?access_token=ACCESS_TOKEN";
	// ɾ����ǩ��Ա��ַ
	public static String DELETE_TAG_PERSON = "https://qyapi.weixin.qq.com/cgi-bin/tag/deltagusers?access_token=ACCESS_TOKEN";

	/**
	 * ������ǩ
	 * 
	 * @param tagname
	 *            ��ǩ���ơ�����Ϊ1~64���ַ�����ǩ����������ͬ��ı�ǩ������Ҳ������ȫ�ֱ�ǩ����
	 * */
	public static String create(String tagname) {
		String postData = "{\"tagname\": %s}";
		return String.format(postData, tagname);
	}

	/**
	 * ���±�ǩ����
	 * 
	 * @param tagid
	 *            ��ǩID
	 * @param tagname
	 *            ��ǩ���ơ��64���ַ�
	 * */
	public static String update(String tagid, String tagname) {
		String postData = "{\"tagid\": %s,\"tagname\": %s}";
		return String.format(postData, tagid, tagname);
	}

	/**
	 * ɾ����ǩ
	 * 
	 * @param tagid
	 *            ��ǩID
	 * */
	public static String delete(String tagid) {
		String delete_url = DELETE_TAG_URL.replace("ID", tagid);
		return delete_url;
	}

	/**
	 * ��ȡ��ǩ��Ա
	 * 
	 * @param tagid
	 *            ��ǩID
	 * */
	public static String getTagPerson(String tagid) {
		String get_tagperson_url = GET_TAG_PERSON.replace("ID", tagid);
		return get_tagperson_url;
	}

	/**
	 * ���ӱ�ǩ��Ա
	 * 
	 * @param tagid
	 *            ��ǩID
	 * @param userlist
	 *            ��ҵԱ��ID�б� ��ʽ��"userlist":[ "user1","user2"]
	 * */
	public static String addTagPerson(String tagid, String userlist) {
		String postData = "{\"tagid\": %s,\"userlist\":%s}";
		return String.format(postData, tagid, userlist);
	}

	/**
	 * ɾ����ǩ��Ա
	 * 
	 * @param tagid
	 *            ��ǩID
	 * @param userlist
	 *            ��ҵԱ��ID�б� ��ʽ��"userlist":[ "user1","user2"]
	 * */
	public static String deleteTagPerson(String tagid, String userlist) {
		String postData = "{\"tagid\": %s,\"userlist\":%s}";
		return String.format(postData, tagid, userlist);
	}

	// ʾ��
	public static void main(String[] args) {
		/**
		 * ������ǩʾ��
		 * */
		// ��ȡƾ֤
		String access_token = WeixinUtil.getAccessToken(ParamesAPI.corpId, ParamesAPI.secret).getToken();
		// ƴװ����
		String postData = create("�½���ǩ");
		// �ύ���ݣ���ȡ���
		int result = WeixinUtil.PostMessage(access_token, "POST", CREATE_TAG_URL, postData);
		// ��ӡ���
		if (0 == result) {
			System.out.println("�����ɹ�");
		} else {
			System.out.println("����ʧ��");
		}
	}

}
