package com.ivhhs.wechat.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.ivhhs.wechat.ParamesAPI.ParamesAPI;
import com.ivhhs.wechat.ParamesAPI.WeixinUtil;
import com.ivhhs.wechat.contacts.Person;
import com.ivhhs.wechat.msg.Message;

@WebServlet("/SendMsgServlet")
public class SendMsgServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public SendMsgServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		// 璋冨彇鍑瘉
		String access_token = WeixinUtil.getAccessToken(ParamesAPI.corpId, ParamesAPI.secret).getToken();
		
		String RequURL=Person.GET_PERSON_URL;
		RequURL=RequURL.replace("ID", "linxiong").replace("ACCESS_TOKEN",access_token);
		String output="";
		System.out.println(RequURL);
		JSONObject json=WeixinUtil.httpRequest(RequURL, "GET", output);
		
		String POST_URL = "https://qyapi.weixin.qq.com/cgi-bin/message/send?access_token=ACCESS_TOKEN";
		String Result=Message.sendTextMsg("linxiong", "52","1", "19", "<a href='http://www.baidu.com'>杩涘叆鐧惧害</a>鎹㈣鐪嬬湅\n<a href='http://www.baidu.com'>鎹簡鍚�/a>\n杩樻病鏈�\n");
		System.out.println(Result);
		int result = WeixinUtil.PostMessage(access_token, "POST", POST_URL, Result);
		
		System.out.println(result);
		
		PrintWriter out = response.getWriter();
		out.println(json);
		out.flush();
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
