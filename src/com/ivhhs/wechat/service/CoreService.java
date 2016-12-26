package com.ivhhs.wechat.service;

import java.util.Date;
import java.util.Map;

import com.ivhhs.wechat.msg.MessageUtil;
import com.ivhhs.wechat.msg.Resp.TextMessage;

/**
 * ����Service��
 * 
 * @author ivhhs
 * @date 2014.10.16
 */
public class CoreService {

	/**
	 * ����΢�ŷ���������
	 * 
	 * @param request
	 * @return xml
	 */
	public static String processRequest(String request) {
		// xml��ʽ����Ϣ����
		String respXml = null;
		// Ĭ�Ϸ��ص��ı���Ϣ����
		String respContent = "δ֪����Ϣ���ͣ�";
		try {
			// ����parseXml��������������Ϣ
			Map<String, String> requestMap = MessageUtil.parseXml(request);
			// ���ͷ��ʺ�
			String fromUserName = requestMap.get("FromUserName");
			// ������΢�ź�
			String toUserName = requestMap.get("ToUserName");
			// ��Ϣ����
			String msgType = requestMap.get("MsgType");

			// �ظ��ı���Ϣ
			TextMessage textMessage = new TextMessage();
			textMessage.setToUserName(fromUserName);
			textMessage.setFromUserName(toUserName);
			textMessage.setCreateTime(new Date().getTime());
			textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);

			// �ı���Ϣ
			if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
				/*respXml ="<xml>\n" +
						"<ToUserName><![CDATA["+ requestMap.get("FromUserName")+"]]></ToUserName>\n" +
						"<FromUserName><![CDATA["+requestMap.get("ToUserName")+"]]></FromUserName>\n" +
						"<CreateTime>"+requestMap.get("CreateTime")+"</CreateTime>\n" +
						"<MsgType><![CDATA["+requestMap.get("MsgType")+"]]></MsgType>\n" +
						"<Content><![CDATA[this is test]]></Content>\n</xml>" ;
						*/
						respContent = "�����͵����ı���Ϣ��";
			}
			// ͼƬ��Ϣ
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
				/*respXml ="<xml>" +
						"<ToUserName><![CDATA["+ requestMap.get("FromUserName")+"]]></ToUserName>\n" +
						"<FromUserName><![CDATA["+requestMap.get("ToUserName")+"]]></FromUserName>\n" +
						"<CreateTime>"+requestMap.get("CreateTime")+"</CreateTime>\n" +
						"<MsgType><![CDATA["+requestMap.get("MsgType")+"]]></MsgType>\n" +
						"<Image><MediaId><![CDATA[media_id]]></MediaId></Image>\n" +
						"</xml>";*/
						respContent = "�����͵���ͼƬ��Ϣ��";
			}
			// ������Ϣ
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
				/*respXml ="<xml>" +
						"<ToUserName><![CDATA["+ requestMap.get("FromUserName")+"]]></ToUserName>\n" +
						"<FromUserName><![CDATA["+requestMap.get("ToUserName")+"]]></FromUserName>\n" +
						"<CreateTime>"+requestMap.get("CreateTime")+"</CreateTime>\n" +
						"<MsgType><![CDATA["+requestMap.get("MsgType")+"]]></MsgType>\n" +
						"<Voice><MediaId><![CDATA[media_id]]></MediaId></Voice>\n" +
						"</xml>";*/
				respContent = "�����͵���������Ϣ��";
			}
			// ��Ƶ��Ϣ
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VIDEO)) {
				/*respXml ="<xml>" +
						"<ToUserName><![CDATA["+ requestMap.get("FromUserName")+"]]></ToUserName>\n" +
						"<FromUserName><![CDATA["+requestMap.get("ToUserName")+"]]></FromUserName>\n" +
						"<CreateTime>"+requestMap.get("CreateTime")+"</CreateTime>\n" +
						"<MsgType><![CDATA["+requestMap.get("MsgType")+"]]></MsgType>\n" +
						"<MediaId><![CDATA[media_id]]></MediaId>\n" +
						"<Title><![CDATA[title]]></Title>\n" +
						"<Description><![CDATA[description]]></Description>\n" +
						"</xml>";*/
				respContent = "�����͵�����Ƶ��Ϣ��";
			}
			// ����λ����Ϣ
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
				respContent = "�����͵��ǵ���λ����Ϣ��";
			}
			// ������Ϣ
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
				respContent = "�����͵���������Ϣ��";
			}
			// �¼�����
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
				// �¼�����
				String eventType = requestMap.get("Event");
				// ��ע
				if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
					respContent = "лл���Ĺ�ע��";
				}
				// ȡ����ע
				else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
					// TODO ȡ�����ĺ��û��������յ������˺ŷ��͵���Ϣ����˲���Ҫ�ظ�
				}
				// ɨ���������ά��
				else if (eventType.equals(MessageUtil.EVENT_TYPE_SCAN)) {
					// TODO ����ɨ���������ά���¼�
				}
				// �ϱ�����λ��
				else if (eventType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
					// TODO �����ϱ�����λ���¼�
				}
				// �Զ���˵�
				else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
					// TODO ����˵�����¼�
					// �¼�KEYֵ���봴���Զ���˵�ʱָ����KEYֵ��Ӧ
					String eventKey = requestMap.get("EventKey");
					System.out.println("EventKey=" + eventKey);
					respContent = "����Ĳ˵�KEY:" + eventKey;
				}
			}
			// �����ı���Ϣ������
			
			textMessage.setContent(respContent);
			
			// ���ı���Ϣ����ת����xml
			respXml = MessageUtil.textMessageToXml(textMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return respXml;
	}

}
