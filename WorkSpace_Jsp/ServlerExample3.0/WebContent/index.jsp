<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- a标签默认以Get方式提交 -->
	<a href="WelcomeServlet">点我Get提交</a>
	<!-- form表单可以设置提交方式Get(是默认),Post方式自行修改 -->
	<form action="WelcomeServlet" method="post">
		<input type="submit" value="点我Post提交">
	</form>
</body>
</html>