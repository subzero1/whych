package com.ivhhs.wechat.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MessageServlet")
public class MessageServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("sssssssss");
	}
}
