<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>pageTest</title>
</head>
<body>
	<%
		// 在本页面中设置的值，其他页面调取不到，作用域仅限本页面
		String name = "page";
		pageContext.setAttribute("name", name);
	%>
	<strong>
		testOne:<%=pageContext.getAttribute("name") %>
	</strong>
	<br/>
	<% 
		// include("pagetwo.jsp")为空值，包含的是pagetwo.jsp的内容，作用域不牵扯pageone.jsp
		pageContext.include("pagetwo.jsp");
	%>
</body>
</html>