<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@page import="java.sql.*, java.util.*" %>
	<h1 align="center">회원가입</h1>
	<form action = "register.jsp" method="post">
		<table cellspacing="5" align="center">
			<tr>
				<td>아이디:</td>
				<td><input type = "text" name = "id" required /></td>
			</tr>
			<tr>
				<td>비밀번호:</td>
				<td><input type = "password" name = "pwd" style="width:97.6%" required /></td>
			</tr>
			<tr>
				<td>이메일:</td>
				<td><input type = "email" name = "email" required /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type = "submit" value = "등록하기"/></td>
			</tr>
		</table>
		
	</form>
</body>
</html>