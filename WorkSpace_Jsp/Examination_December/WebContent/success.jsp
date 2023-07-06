<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Success</title>
</head>
<body>
	<table border="0" align="center">
		<tr>
			<td>用户：</td>
			<td>
				<%
					// 获取用户名
					String name = (String)session.getAttribute("uname");
					out.print(name);
				%>
			</td>
		</tr>
		<tr>
			<td>喜欢的水果为：</td>
			<td>
				<%
					// 获取复选框内容
					String fruits = (String)session.getAttribute("ufruit");
					out.print(fruits);
				%>
			</td>
		</tr>
	</table>
</body>
</html>