package com.ivhhs.wechat.contacts;

import com.ivhhs.wechat.ParamesAPI.ParamesAPI;
import com.ivhhs.wechat.ParamesAPI.WeixinUtil;

/**
 * ͨѶ¼���Ź�����
 * 
 * @author ivhhs
 * @date 2014.10.16
 */
public class Group {

	// �������ŵ�ַ
	public static String CREATE_URL = "https://qyapi.weixin.qq.com/cgi-bin/department/create?access_token=ACCESS_TOKEN";
	// ���²��ŵ�ַ
	public static String UPDATE_URL = "https://qyapi.weixin.qq.com/cgi-bin/department/update?access_token=ACCESS_TOKEN";
	// ɾ�����ŵ�ַ
	public static String DELETE_URL = "https://qyapi.weixin.qq.com/cgi-bin/department/delete?access_token=ACCESS_TOKEN&id=ID";
	// ��ȡ�����б��ַ
	public static String GETLIST_URL = "https://qyapi.weixin.qq.com/cgi-bin/department/list?access_token=ACCESS_TOKEN";

	/**
	 * ��������
	 * 
	 * @param name
	 *            �������ơ���������Ϊ1~64���ַ�
	 * @param parentid
	 *            ���ײ���id��������idΪ1
	 * */
	public static String create(String name, String parentid) {
		String postData = "{\"name\": %s,\"parentid\": %s}";
		return String.format(postData, name, parentid);
	}

	/**
	 * ���²���
	 * 
	 * @param name
	 *            ���µĲ������ơ���������Ϊ0~64���ַ����޸Ĳ�������ʱָ���ò���
	 * @param id
	 *            ����id
	 * */
	public static String update(String name, String id) {
		String postData = "{\"id\": %s,\"name\": %s}";
		return String.format(postData, name, id);
	}

	/**
	 * ɾ������
	 * 
	 * @param id
	 *            ����id
	 * */
	public static String delete(String id) {
		String delete_url = DELETE_URL.replace("ID", id);
		return delete_url;
	}

	// ʾ��
	public static void main(String[] args) {
		/**
		 * ��������ʾ��
		 * */
		// ��ȡƾ֤
		String access_token = WeixinUtil.getAccessToken(ParamesAPI.corpId, ParamesAPI.secret).getToken();
		// ƴװ����
		String postData = create("�½�����", "2");
		// �ύ����,��ȡ���
		int result = WeixinUtil.PostMessage(access_token, "POST", CREATE_URL, postData);
		// ��ӡ���
		if (0 == result) {
			System.out.println("�����ɹ�");
		} else {
			System.out.println("����ʧ��");
		}
	}
}