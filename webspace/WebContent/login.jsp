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
		public boolean isValid(String qid, String qpwd, String id, String pwd) {
			if(id.equals(qid) && pwd.equals(qpwd)) {
				return true;
			}else {
				return false;
			}
		}
	%>
	<%
		boolean isLogin = false;
		int auth = 0;
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String sql = "select user_id, pwd, typeid from userinfo where user_id='"+id + "' AND pwd='" + pwd + "'";
		
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/webdb?useUnicode=true&characterEncoding=utf8";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "root", "");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()){
				auth = rs.getInt(3);
				isLogin = isValid(rs.getString(1), rs.getString(2), id, pwd);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(conn != null) conn.close();
		}
		
		if(isLogin) {
			if(auth == 1) response.sendRedirect("/webspace/admin/index.jsp");
			else if(auth == 2) response.sendRedirect("index.jsp?isLogined=true");
		}else {%>
			<h3>로그인에 실패하였습니다! 아이디랑 비밀번호를 다시 입력하세요!</h3>
			<p><a href = "index.jsp?isLogined=false">메인화면으로가기</a></p>
		<% } %>
</body>
</html>