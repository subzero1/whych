package cn.com.pro;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class ClassSeesion  {

	public void moth(HttpServletRequest request)//��Ϊ����������
	{
	HttpSession session = request.getSession();
  
	//��ȡsession
	session.getAttribute("name");
	//����session
	session.setAttribute("name", "value");
	//ɾ��
	session.removeAttribute("name");
	}

}
