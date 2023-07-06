<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		// application.getAttribute返回值为Object类型，需要转换为Integer
		Integer cnt = (Integer) application.getAttribute("hitCount");
		out.print(cnt);
		if (cnt == null) {
			cnt = 1;
		} else {
			cnt += 1;
		}
		application.setAttribute("hitCount", cnt);
		out.print("<br/>"+cnt);
	%>
</body>
</html>