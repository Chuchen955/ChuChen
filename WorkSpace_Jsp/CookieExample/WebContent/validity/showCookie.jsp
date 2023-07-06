<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Show Cookie</title>
</head>
<body>
	<%
		Cookie[] cookies = request.getCookies();// 获取所有的cookie对象
		boolean sign = false;
		if(cookies != null){
			for(int i = 0;i<cookies.length;i++){
				if(cookies[i].getName().equals("info")){
					sign = true;
					out.print("读取Cookie的值："+cookies[i].getValue());
				}
			}
		}
		if(!sign){
			out.print("超过Cookie有效期，无法读取Cookie");
		}
	%>
</body>
</html>