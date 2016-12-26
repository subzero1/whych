package cn.com.pro;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class ClassSeesion  {

	public void moth(HttpServletRequest request)//作为参数传进来
	{
	HttpSession session = request.getSession();
  
	//读取session
	session.getAttribute("name");
	//保存session
	session.setAttribute("name", "value");
	//删除
	session.removeAttribute("name");
	}

}
