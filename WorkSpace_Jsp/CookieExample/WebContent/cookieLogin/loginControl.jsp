<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>includeControl</title>
</head>
<body>
	<%
	// 登录后重新开启一个浏览器窗口，直接访问管理员操作页面，进入了，这是不应该的，因为重新打开一个页面，就重新建立session域属性空间
		Cookie[] cs = request.getCookies();
		if(cs==null){
			response.sendRedirect("login.jsp");
			return;
		}
	%>
</body>
</html>