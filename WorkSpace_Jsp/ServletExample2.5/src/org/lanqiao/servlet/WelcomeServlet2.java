package org.lanqiao.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WelcomeServlet2 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			System.out.println("doget...�ڶ��δ�����������XML���½�Servlet�ļ���Eclipse���Զ�����XML");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			System.out.println("dopost...�ڶ��δ�����������XML���½�Servlet�ļ���Eclipse���Զ�����XML");
	}
}
