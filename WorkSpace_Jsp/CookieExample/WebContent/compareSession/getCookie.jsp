<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Get Cookie</title>
</head>
<body>
	<%
		// session.getId()的值等于cookies[i].getValue()
		// 说明sessionid被保存在cookie中
		out.print("sessionId："+ session.getId());
		out.print("<br/>");
		Cookie[] cookies = request.getCookies();
		if(cookies != null){
			for(int i = 0; i<cookies.length;i++){
				out.print("cookie name："+ cookies[i].getName());
				out.print("<br/>");
				out.print("cookie value："+ cookies[i].getValue());
				out.print("<br/>");
			}
		}
	%>
</body>
</html>