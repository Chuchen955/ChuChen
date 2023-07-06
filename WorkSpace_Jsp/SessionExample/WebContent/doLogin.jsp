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
		request.setCharacterEncoding("UTF-8");	// 设置页面字符编码
	// 获取账号、密码
		String name = request.getParameter("username").trim();// trim()去掉字符串两头的所有空格
		String pwd = request.getParameter("pwd").trim();
	// 判断用户验证是否成功
		boolean valid = false;
		if("admin".equals(name) && "123456".equals(pwd)){
			valid = true;
			session.setAttribute("login", name);
			session.setMaxInactiveInterval(10);
		}
		if(valid){
			request.getRequestDispatcher("admin.jsp").forward(request, response);// 转发
		}else{
			response.sendRedirect("login.jsp");// 重定向
		}
	%>
</body>
</html>