<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>user login</title>
</head>
<body>
	<form name="formS" action="doLogin.jsp" method="post">
		<table border="0" align="center">
			<tr>
				<td>User：</td>
				<td><input type="text" name="uname"></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="pwd"></td>
			</tr>
			<tr>
				<td align="center" colspan="2"><input type="submit"
					value="login"></td>
			</tr>
		</table>
	</form>
</body>
</html>
