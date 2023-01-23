<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@page import = "java.sql.*, java.util.*" %>
	<% 
		String id = request.getParameter("id");
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/webdb?useUnicode=true&characterEncoding=utf8";
		String sql = "select user_id, pwd, email from userinfo where user_id='"+id + "'";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		ArrayList<String> datas = new ArrayList<String>();
		String[] titles = {"관리자 아이디", "비밀번호", "이메일"};
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "root", "");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				datas.add(rs.getString(1));
				datas.add(rs.getString(2));
				datas.add(rs.getString(3));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(conn != null) conn.close();
		}
		
	%>
	<h1 align = "center">관리자 계정 정보 수정</h1>
	<form action = "edit.jsp" method = "post">
		<input type = "hidden" name = "value" value = "<%=id %>"/>
		<table align = "center">
			<% for(int i = 0; i<datas.size(); i++) {%>
			<tr>
				<td><%=titles[i] %>: </td>
				<td><input type = "text" name = "value" value = <%=datas.get(i) %> /></td>
			</tr>
			<% } %>
		</table>
		<p align = "center"><input type = "submit" value = "수정하기" /></p>
	</form>
	<p align = "center"><a href = "./adminManager.jsp">취소</a></p>
	
</body>
</html>