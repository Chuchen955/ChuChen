<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login processing</title>
</head>
<body>
	<%
		Cookie unameCookie;
		Cookie upwdCookie;
	%>
	<%
		request.setCharacterEncoding("UTF-8");	// 设置页面字符编码
	// 获取账号、密码
		String name = request.getParameter("username");// trim()去掉字符串两头的所有空格
		String pwd = request.getParameter("pwd");
		
	// 判断用户验证是否成功
		if(name.equals("admin") && pwd.equals("123456")){
			unameCookie = new Cookie("uname",name);
			upwdCookie = new Cookie("upwd",pwd);
			unameCookie.setMaxAge(10);
			upwdCookie.setMaxAge(10);
			response.addCookie(unameCookie);
			response.addCookie(upwdCookie);
			response.sendRedirect("../cookieLogin/admin.jsp");// 转发
			//return;
		}else{
			request.getRequestDispatcher("../cookieLogin/login.jsp").forward(request,response);// 重定向
		}
	%>
</body>
</html>