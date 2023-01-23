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
		// id, pwd, email
		String[] values = request.getParameterValues("value");
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/webdb?useUnicode=true&characterEncoding=utf8";
		String sql = "update userinfo set";
		sql += " user_id='" + values[1] + "', pwd='" + values[2] + "', email='" + values[3] + "'";
		sql += " where user_id='" + values[0] + "'";
		
		System.out.println(sql);
		
		Connection conn = null;
		Statement stmt = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "root", "");
			stmt = conn.createStatement();
			
			stmt.executeUpdate(sql);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(stmt != null) stmt.close();
			if(conn != null) conn.close();
		}
		
		response.sendRedirect("index.jsp");
		
	%>
</body>
</html>