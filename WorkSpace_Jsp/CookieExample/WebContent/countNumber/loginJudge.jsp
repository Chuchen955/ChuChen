<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>includeControl</title>
</head>
<body>
	<!-- 判断如果没有登录过的用户信息，那么就跳转到登录页面 -->
	<%
		String login = (String)session.getAttribute("login");
		if(login==null){
			response.sendRedirect("login.jsp");
			return;
		}
	%>
</body>
</html>