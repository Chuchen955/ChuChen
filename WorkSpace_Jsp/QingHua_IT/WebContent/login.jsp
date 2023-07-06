<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Request Implement the registered</title>
</head>
<body>
	<h1 align="center">Please enter the registration information</h1>
	<form action="ShowMessage.jsp" method="post">
		<table border="0" align="center">
			<tr>
				<td>Username：</td><td><input type="text" name="Ming"></td>
			</tr>
			<tr>
				<td>Password：</td><td><input type="password" name="Pwd"></td>
			</tr>
			<tr>
				<td>InformationSource：</td>
				<td>
					<input type="checkbox" name="favorite" value="ThePress"> ThePress &nbsp;
        			<input type="checkbox" name="favorite" value="Network"> Network &nbsp;
        			<input type="checkbox" name="favorite" value="FriendRecommended"> FriendRecommended &nbsp;
        			<input type="checkbox" name="favorite" value="Television"> Television &nbsp;
        		</td>
			</tr>
			<tr>
				<td align="center" colspan="2"><input type="submit" value="Submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>