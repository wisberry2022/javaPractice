<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	div a {
		display: inline-block;
		margin: 0 1rem;
	}
</style>
</head>
<body>
	<div align = "center">
		<a href = "adminManager.jsp">관리자 목록</a>
		<a href = "userManager.jsp">회원 관리</a>
		<a href = "./">홈</a>
	</div>
	<h1 align = "center">관리자 목록</h1>
	
	<%@ page import = "java.sql.*, java.util.*" %>
	<%
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/webdb?useUnicode=true&characterEncoding=utf8";
		String sql = "select user_id, email, signup from userinfo where typeid=1";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(url, "root", "");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
	 %>
	 	<form action = "delete.jsp" method = "post">
		 	<table align="center" cellspacing="5" border="4">
				<tr>
					<td width = "100px" align = "center">선택</td>
					<td width = "200px" align = "center">관리자 아이디</td>
					<td width = "450px" align = "center">이메일</td>
					<td width = "200px" align = "center">등록일</td>
				</tr>
				<% while(rs.next()){ %>
					<tr>
						<td align = "center"><input type = "checkbox" name = "check" value = "<%=rs.getString(1)%>"/></td>
						<td align = "center"><a href = "detail.jsp?id=<%=rs.getString(1) %>"><%= rs.getString(1) %></a></td>
						<td align = "center"><a href = "detail.jsp?id=<%=rs.getString(1) %>"><%= rs.getString(2) %></a></td>
						<td align = "center"><a href = "detail.jsp?id=<%=rs.getString(1) %>"><%= rs.getDate(3) %></a></td>		
					</tr>
				<% } %>
			</table>
			<p align = "center"><input type = "submit" value = "삭제" /></p>
		</form>
		
		<% 
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(conn != null) conn.close();
		} %>
				
		<p align = "center">
			<a href = "add.html">관리자 추가하기</a>
		</p>
	
</body>
</html>