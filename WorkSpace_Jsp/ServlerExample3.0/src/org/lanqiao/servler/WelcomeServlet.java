package org.lanqiao.servler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WelcomeServler
 */
//loadOnStartup����ʱ����Service�Ĵ���
@WebServlet(value="/WelcomeServlet",loadOnStartup=1)
public class WelcomeServlet extends HttpServlet {

	@Override
	public void init() throws ServletException {
		System.out.println("init..");//���η��ʵ�ʱ���ʼ������Ϣ(��ʼ��)
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy..System");//�رշ�������ʱ��ִ��һ�Σ�ж�أ�
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("������3.0��doGet...");//����һ��ִ��һ��
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("������3.0��doPost...");//����һ��ִ��һ��

	}

}
