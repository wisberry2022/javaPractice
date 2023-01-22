<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ page import = "java.sql.*, java.util.*" %>
	<%
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		String sql = "insert into userinfo(user_id, pwd, email, signup) values (";
		sql += "'"+ id + "', '" + pwd + "', '" + email + "', now())";
		System.out.println(sql);
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/webdb?useUnicode=true&characterEncoding=utf8";
		
		Connection conn = null;
		Statement stmt = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "root", "");
			stmt = conn.createStatement();
			
			stmt.executeUpdate(sql);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			if(stmt != null) stmt.close();
			if(conn != null) conn.close();	
		}
		response.sendRedirect("index.jsp");
	%>
	
	
</body>
</html>