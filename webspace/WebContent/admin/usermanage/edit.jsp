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
		//String[] params = {"id", "pwd", "email", "typeid"};
		//String[] input = new String[4];
		Map<String, String[]> pMap = request.getParameterMap();
		String sql = "update userinfo set ";
		sql += "user_id='" + pMap.get("id")[0] + "', pwd='" + pMap.get("pwd")[0] + "', email='" + pMap.get("email")[0] + "', typeid=" + pMap.get("typeid")[0];
		sql += " where user_id='"+pMap.get("before")[0] + "'";
		System.out.println(sql);
		//for(int i = 0; i<params.length; i++) {
		//	String[] data = pMap.get(params[i]);
		//	input[i] = data[0];
		//}
		
		
		//for(int i = 0; i<input.length; i++) {
		//	System.out.println(input[i]);
		//}
		
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
		}finally {
			if(stmt != null) stmt.close();
			if(conn != null) conn.close();
		}
		
		response.sendRedirect("userManager.jsp");
	%>
	
	
</body>
</html>