<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
	String isLogined = request.getParameter("isLogined");
	if((isLogined == null) || (isLogined.equals("false"))) {
%>
<h1 align = "center">로그인 화면</h1>
	<form action = "login.jsp" method="post">
		<table align="center" cellspacing="5">
			<tr>
				<td>아이디</td>
				<td><input type = "text" name = "id" required/></td>
			</tr>
			<tr>
				<td>비밀번호: </td>
				<td><input type = "password" name = "pwd" style="width:97.5%" required /></td>
			</tr>
			<tr>
				<td colspan = "2" align = "center"><input type = "submit" value = "로그인" /></td>
			</tr>
		</table>
			<p align = "center"><a href = "find.jsp">아이디/비밀번호 찾기</a></p>
			<p align = "center"><a href = "signup.jsp">회원가입</a></p>
	</form>
	<%} else { %>
		<h1>환영합니다!</h1>
	<%} %>
</body>
</html>