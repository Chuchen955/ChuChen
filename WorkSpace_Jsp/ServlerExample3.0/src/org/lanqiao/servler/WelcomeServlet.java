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
//loadOnStartup加载时启动Service的次序
@WebServlet(value="/WelcomeServlet",loadOnStartup=1)
public class WelcomeServlet extends HttpServlet {

	@Override
	public void init() throws ServletException {
		System.out.println("init..");//初次访问的时候初始化的信息(初始化)
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy..System");//关闭服务器的时候执行一次（卸载）
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("这里是3.0的doGet...");//访问一次执行一次
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("这里是3.0的doPost...");//访问一次执行一次

	}

}
