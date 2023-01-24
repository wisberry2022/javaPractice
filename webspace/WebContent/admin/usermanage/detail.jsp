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
		String[] datas = new String[4];
		String[] labels = {"회원 아이디", "회원 비밀번호", "회원 이메일", "회원 유형"};
		String[] names = {"id", "pwd", "email", "typeid"};
		String id = request.getParameter("id"); 
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/webdb?useUnicode=true&characterEncoding=utf8";
		String sql = "select user_id, pwd, email, typeid from userinfo where user_id='" + id + "'";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "root", "");
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				for(int i = 0; i<datas.length; i++) {
					datas[i] = rs.getString(i+1);
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if(stmt != null) stmt.close();
			if(conn != null) conn.close();
		}
	%>
	
	<h3 align = "center"><%=id %> 회원 정보 수정</h3>
	
	<form action = "edit.jsp" method = "post">
		<input type = "hidden" name = "before" value = <%=id %> />
		<table align = "center" cellspacing="5">
			<% for(int i = 0; i<labels.length; i++) { %>
				<% if(i == 1) { %>
					<tr>
						<td><%= labels[i] %>: </td>
						<td><input type = "password" name = <%=names[i] %> value=<%=datas[i] %> style="width:97.8%" /> </td>
					</tr>
				<%}else if(i == 3){ %>
					<tr>
						<td><%= labels[i] %>: </td>
						<td>
							<select name = <%=names[i] %>>
								<option value = "1">관리자</option>
								<option value = "2" selected>일반 회원</option>
								<option value = "3">특별 회원</option>
							</select>
						</td>
					</tr>
				<%}else { %>
				<tr>
					<td><%=labels[i] %>: </td>
					<td><input type = "text" name = <%=names[i] %> value=<%=datas[i] %> /></td>
				</tr>
				<%} %>
			<%} %>
			<tr>
				<td colspan = "2" align = "center"><input type = "submit" value = "수정하기"/></td>
			</tr>
		</table>
	</form>
	<p align = "center"><a href= "userManager.jsp">뒤로가기</a></p>
</body>
</html>