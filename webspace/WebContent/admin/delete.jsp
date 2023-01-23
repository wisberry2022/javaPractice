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
		// 같은 이름의 파라미터를 가진 여러 개의 value를 문자열 배열로 받기
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/webdb?useUnicode=true&characterEncoding=utf8";
		
		Connection conn = null;
		Statement stmt = null;
		
		String[] values = request.getParameterValues("check");
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "root", "");
			stmt = conn.createStatement();
				
			for(int i = 0; i<values.length; i++) {
				String sql = "delete from userinfo where user_id=";
				sql += "'" + values[i] + "'";
				stmt.executeUpdate(sql);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(stmt != null) stmt.close();
			if(conn != null) conn.close();
		}
				
		response.sendRedirect("adminManager.jsp");
	%>
</body>
</html>