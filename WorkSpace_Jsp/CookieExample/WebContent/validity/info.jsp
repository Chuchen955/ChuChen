<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Info</title>
</head>
<body>
	<%
		Cookie nc = new Cookie("info","ok");
		nc.setMaxAge(10);// 设置失效时间为60秒
		response.addCookie(nc);
		response.sendRedirect("showCookie.jsp");
	%>
</body>
</html>