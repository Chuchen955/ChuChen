<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>The login process</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		if("1460623538".equals(name) && "123456".equals(pwd)){
			// 重定向
			//response.sendRedirect("welcome.jsp");
			//response.sendRedirect("welcome.jsp?username=" + name);// 重定向（查询字符串，传递简单信息）
			
			// 转发
			request.getRequestDispatcher("welcome.jsp").forward(request, response);
		}else{
			out.print("Redirection failed, now in transit control page.");
			response.sendRedirect("login.jsp");
		}
	%>
</body>
</html>