package com.base.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class JsonUtil {
	public static void writeJson(Object object,HttpServletResponse response) {
		try {
	        response.setHeader("Content-type", "text/html;charset=UTF-8");  
			PrintWriter out = response.getWriter();
			Gson gson=new Gson();
			out.write(gson.toJson(object));
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
