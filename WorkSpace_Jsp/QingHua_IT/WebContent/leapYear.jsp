<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Calculate the number of leap years</title>
</head>
<body>
	<h1>计算2000-2013年中存在几个闰年</h1>
	<%
	/* 年份循环 */
		int count = 0;
		for (int i = 2000; i < 2013; i++) {
			boolean bool = findYear(i);
			/* 计数增加 */
			if(bool==true){
				count++;
			}
		}
	%>
	<%=count %>
	<!-- 判断年份 -->
	<%!public boolean findYear(int year) {
		boolean bool = false;
		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
			bool = true;
		}
		return bool;
	}%>
</body>
</html>