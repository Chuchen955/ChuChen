<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login processing</title>
</head>
<body>
	<%
		// 设置页面字符编码   
		request.setCharacterEncoding("UTF-8");
		// 获取账号、密码
		// trim()去掉字符串两头的所有空格
		String name = request.getParameter("uname").trim();
		String pwd = request.getParameter("pwd").trim();
		
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jspexample?useUnicode=true&characterEncoding=utf8","root","");
		PreparedStatement pstmt = conn.prepareStatement("insert into usertable (username,password) values('"+name+"','"+pwd+"')");//预处理 
		int i = pstmt.executeUpdate();
		if(i==1){
			out.print("<script>alert('注册成功');</script>");
			response.sendRedirect("login.jsp");
		}else{
			out.print("<script>alert('注册失败');</script>");
		}
	%>
</body>
</html>