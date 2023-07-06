<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Submit</title>
</head>
<body>
	<%
		//以POST方式提交数据时
		//设置读取请求信息的字符编码为UTF-8，解决中文乱码
		request.setCharacterEncoding("UTF-8");
		//获取用户名、密码
		String Ming = request.getParameter("Ming");
		String Pwd = request.getParameter("Pwd");
		String fruitstr = "";// 设置字符串拼接水果
		String[] fruits = request.getParameterValues("fruit");
		if (fruits != null) {
			for (String fruit : fruits) {
				fruitstr += fruit + "  ";
			}
		}
		if (Ming.equals("admin") && Pwd.equals("123456")) {
			session.setAttribute("uname", Ming);
			session.setAttribute("upwd", Pwd);
			session.setAttribute("ufruit", fruitstr);
			request.getRequestDispatcher("success.jsp").forward(request,response);

		} else {
			response.sendRedirect("error.jsp");
		}
	%>
</body>
</html>