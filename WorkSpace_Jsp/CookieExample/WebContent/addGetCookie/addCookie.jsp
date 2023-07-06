<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Cookie</title>
</head>
<body>
	<%
		// 将cookie的值存储，重定向验证是否存储成功
		response.addCookie(new Cookie("username","Jack"));
		response.addCookie(new Cookie("password","123456"));
		response.sendRedirect("getCookie.jsp");
	%>
</body>
</html>