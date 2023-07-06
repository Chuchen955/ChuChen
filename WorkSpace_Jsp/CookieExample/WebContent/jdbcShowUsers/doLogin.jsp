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
		// 加载数据库驱动
		Class.forName("com.mysql.jdbc.Driver");
		// 创建连接
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jspexample?useUnicode=true&characterEncoding=utf8","root","");
		// 创建预处理对象
		PreparedStatement pstmt = conn.prepareStatement("select * from usertable where username='"+name+"' and password='"+pwd+"'");
		// 获得结果集 '[/]
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()){
			response.addCookie(new Cookie("uname",name));
			response.sendRedirect("admin.jsp");
		}else{
			out.print("<script>alert('登录失败');</script>");
		}
	%>
</body>
</html>