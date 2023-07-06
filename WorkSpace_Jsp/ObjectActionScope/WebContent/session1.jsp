<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SessionTest</title>
</head>
<body>
<%
	String req = "request";
	String ses = "session";
	request.setAttribute("reqname", req);
	session.setAttribute("sesname", ses);
	// 通过重定向测试出，session在同一次会话有效，而request在重定向的时候发出了新的请求，覆盖了第一次的请求，所以值为null
	response.sendRedirect("session2.jsp");
%>
</body>
</html>