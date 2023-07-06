<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Show user message</title>
</head>
<body>
	<h1 align="center">Please enter the registration information</h1>
	<% //以POST方式提交数据时
		//设置读取请求信息的字符编码为UTF-8，解决中文乱码
		request.setCharacterEncoding("UTF-8");
		//获取用户名、密码
		String Ming = request.getParameter("Ming");
		String Pwd = request.getParameter("Pwd");
	%>
	<table border="0" align="center">
		<tr>
			<td>UserName：</td>
			<td><%=Ming %></td>
		</tr>
		<tr>
			<td>PassWord：</td>
			<td><%=Pwd %></td>
		</tr>
		<tr>
			<td>InformationSource：</td>
			<td>
				<%
					// 获取复选框内容
					String[] favorites = request.getParameterValues("favorite");
					if (favorites != null) {
						for (String favorite : favorites) {
							out.println(favorite);
						}
					}
				%>
			</td>
		</tr>
	</table>
</body>
</html>