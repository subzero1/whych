package com.ivhhs.wechat.oauth2;

/**
 * OAuth2 servlet��
 * 
 * @author ivhhs
 * @date 2014.10.16
 */
import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ivhhs.wechat.ParamesAPI.ParamesAPI;
import com.ivhhs.wechat.ParamesAPI.WeixinUtil;
@WebServlet("/oauth2Servlet")
public class OAuth2Servlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String code = request.getParameter("code");
		if (!"authdeny".equals(code)) {
			String access_token = WeixinUtil.getAccessToken(ParamesAPI.corpId, ParamesAPI.secret).getToken();
			// agentid ��ת����ʱ���ڵ���ҵӦ��ID
			// ����Ա��ӵ��agent��ʹ��Ȩ�ޣ�agentid�������ת����ʱ���ڵ���ҵӦ��ID��ͬ
			String UserID = OAuth2Core.getUserID(access_token, code, "19");
			request.setAttribute("UserID", UserID);
		} else {
			out.print("��Ȩ��ȡʧ�ܣ�����Ϊʲô���Լ���ԭ�򡣡���");
		}
		// ��ת��index.jsp
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
