<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ page import="java.sql.*, java.util.*" %>
	<%!
		public boolean isValid(ResultSet rs, String id, String pwd) {
			try {
				if(rs.next()) {
					if(id.equals(rs.getString(1)) && pwd.equals(rs.getString(2))) {
						return true;
					}else {
						return false;
					}
				}else {
					return false;
				}
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("rs커서가 없음!");
			}
			return false;
		}
	%>
	<%
		boolean isLogin = false;
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String sql = "select user_id, pwd from userinfo where user_id='"+id + "' AND pwd='" + pwd + "'";
		
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/webdb?useUnicode=true&characterEncoding=utf8";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(url, "root", "");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			isLogin = isValid(rs, id, pwd);
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(conn != null) conn.close();
		}
		
		if(isLogin) {%>
			<% response.sendRedirect("index.jsp?isLogined=true"); %>
		<%}else { %>
			<h3>로그인에 실패하였습니다! 아이디랑 비밀번호를 다시 입력하세요!</h3>
			<p><a href = "index.jsp?isLogined=false">메인화면으로가기</a></p>
		<%} %>
</body>
</html>