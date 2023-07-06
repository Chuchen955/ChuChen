<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ApplicationTest</title>
</head>
<body>
	<%
		String ses = "session";
		String app = "application";
		session.setAttribute("sess", ses);
		application.setAttribute("appli", app);
		// ？？不清楚session的范围，在另一个浏览器中打开session失效，
		// application 是所有浏览器页面嘛“？？
		
		response.sendRedirect("application2.jsp");
	%>
</body>
</html>