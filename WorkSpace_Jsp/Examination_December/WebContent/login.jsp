<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
	<form action="submit.jsp" method="post">
		<table border="0" align="center">
			<tr>
				<td>用户名：</td><td><input type="text" name="Ming" value="张朝阳"></td>
			</tr>
			<tr>
				<td>密码：</td><td><input type="password" name="Pwd"></td>
			</tr>
			<tr>
				<td>喜欢的水果：</td>
				<td>
					<input type="checkbox" name="fruit" value="苹果"> 苹果 &nbsp;
        			<input type="checkbox" name="fruit" value="香蕉"> 香蕉 &nbsp;
        			<input type="checkbox" name="fruit" value="橘子"> 橘子 &nbsp;
        			<input type="checkbox" name="fruit" value="桃子"> 桃子 &nbsp;
        		</td>
			</tr>
			<tr>
				<td align="center" colspan="2"><input type="submit" value="提交"></td>
			</tr>
		</table>
	</form>
</body>
</html>