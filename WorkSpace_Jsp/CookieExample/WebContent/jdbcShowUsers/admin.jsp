<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Show Users</title>
</head>
<body>
	<%	
		String uname = "";
		Cookie[] cookies =  request.getCookies();
		if(cookies!=null){
			for(Cookie cookie : cookies){
				if(cookie.getName().equals("uname")){
					uname = cookie.getValue();
				}
			}
		}
	%>
	<h1>您好，<%=uname %>欢迎您！</h1>
	<h2>已有的用户列表如下：</h2>
	<%
		String str = "hello world";
		session.setAttribute("msg", str);
		String getStr = (String)session.getAttribute("msg");
		out.print(getStr);
	%>
</body>
</html>