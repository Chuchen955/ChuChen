<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Calculate a prime number</title>
</head>
<body>
	<!-- 1-100之间的素数之和 素数：除了1和自身以外不能被其他自然数整除，1除外-->
	<%
	int count=0,i=0,j = 0;
	for(i = 2; i<100;i++){
		boolean flag = true;
		for(j=2;j<i;j++){
			if(i%j==0){
				flag = false;
			}
		}
		if(flag == true){
			count+=i;
		}
	}
	%>
	<%=count %>
</body>
</html>