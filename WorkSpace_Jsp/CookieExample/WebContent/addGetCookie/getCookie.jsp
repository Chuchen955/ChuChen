<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Get Cookie</title>
</head>
<body>
	<%
	Cookie[] cookies = request.getCookies();
	String user = "";
	String pwd = "";
	if(cookies != null){
		for(int i = 0; i<cookies.length;i++){
			// 这里为了测试方便使用eles if 语句，只要用户密码都匹配到就验证成功
			// 实际应用中，可能有密码相同的情况，所以实际应用时还得考虑详细的写法
			if(cookies[i].getName().equals("username")){
				user = cookies[i].getValue();
			}else if(cookies[i].getName().equals("password")){
				pwd = cookies[i].getValue();
			}
		}
	}
	out.print("用户名："+user+"，密码："+pwd);
	%>
</body>
</html>