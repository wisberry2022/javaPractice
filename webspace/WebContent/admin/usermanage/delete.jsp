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
		String[] ids = request.getParameterValues("value");
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/webdb?useUnicode=true&characterEncoding=utf8";
		String suffix = "";
		
		Connection conn = null;
		Statement stmt = null;
		
		try{
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "root", "");
			stmt = conn.createStatement();
		
			for(int i = 0; i<ids.length; i++) {
				String sql = "delete from userinfo where user_id=";
				sql += "'" + ids[i] + "'";
				stmt.executeUpdate(sql + suffix);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(stmt != null) stmt.close();
			if(conn != null) conn.close();
		}
		
		response.sendRedirect("./userManager.jsp");
	%>
</body>
</html>