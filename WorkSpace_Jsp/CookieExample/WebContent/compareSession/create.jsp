<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create</title>
</head>
<body>
	<%
		session.setAttribute("test", "Hello");
		// 这里用重定向，是将这一次的请求提交后，在定向新的界面，session的值已经存储	
		response.sendRedirect("getCookie.jsp");
		
		
		// 如果用转发，就是先转发页面，在发送请求，然后响应，而页面已经呈现完成，此时在地址栏在次进入getCookie就能看到上次的Cookie
		//request.getRequestDispatcher("getCookie.jsp").forward(request, response);
		
	%>
</body>
</html>