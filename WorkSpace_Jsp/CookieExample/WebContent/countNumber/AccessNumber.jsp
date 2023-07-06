<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Access number</title>
</head>
<body>
<%-- 统计访问人数，只要经过控制页面，不论登录成功否，都记录 --%>
	<%
		Integer i = (Integer)application.getAttribute("count");
		out.print("统计访问量：目前有"+i+"个人访问过本网站");
	%>
</body>
</html>