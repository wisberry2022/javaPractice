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
		margin: 1rem 1rem 3rem 1rem;
	}
</style>
</head>
<body>
	<h2 align = "center">회원 관리</h2>
	<div align = "center">
		<a href = "../adminManager.jsp">관리자 목록</a>
		<a href = "./userManager.jsp">회원 관리</a>
		<a href = "../">홈</a>
	</div>
	<%@ page import="java.sql.*, java.util.*" %>
	<%
		ArrayList<String[]> datas = new ArrayList<String[]>();
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/webdb?useUnicode=true&characterEncoding=utf8";
		String sql = "select user_id, email, signup, typeid from userinfo where typeid != 1";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try{
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "root", "");
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				String[] input = new String[4];
				for(int i = 0; i<4; i++) {
					if(i == 2) input[i] = rs.getDate(i+1).toString();
					else if(i == 3) {
						if(rs.getInt(i+1) == 2) input[i] = "일반 회원";
						else input[i] = "기타";
					}else {
						input[i] = rs.getString(i+1);	
					}
					
				}
				datas.add(input);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(conn != null) conn.close();
		}
	%>
	
	<form action = "delete.jsp" method="post">
		<table align = "center" cellspacing="5" border = "4">
			<tr>
				<td style="width:100px" align = "center">선택</td>
				<td style="width:150px" align = "center">아이디</td>
				<td style="width:400px" align = "center">이메일</td>
				<td style="width:200px" align = "center">가입일자</td>
				<td style="width:150px" align = "center">회원유형</td>
			</tr>
			<% for(int i = 0; i<datas.size(); i++) 
				{ String[] data = datas.get(i);%>
				<tr>
					<td align = "center"><input type = "checkbox" name = "value" value="<%=data[0] %>"/></td>
					<% for(int j = 0; j<data.length; j++) { %>
						<td align = "center"><a href = "detail.jsp?id=<%=data[0] %>"><%=data[j] %></a></td>
					<%} %>
				</tr>
			<%} %>
		</table>
		<p align = "center"><input type = "submit" value = "삭제하기"/></p>
	</form>
	
</body>
</html>