<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>requestTest</title>
</head>
<body>
	<%
		// 调取了requesttwo的内容显示成功，说明同一次请求的内容不同页面是可以调用的
		String name = "request";
		request.setAttribute("name", name);
		request.getRequestDispatcher("requesttwo.jsp").forward(request, response);
	%>
</body>
</html>