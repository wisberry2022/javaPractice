package com0120;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

// 학번, 국어(ml), 영어(eng), 수학(math) 정보를 담고 있는 학생 Class
class Student {
	private int id;
	private int ml;
	private int eng;
	private int math;
	
	public Student(int id, int ml, int eng, int math) {
		this.id = id;
		this.ml = ml;
		this.eng = eng;
		this.math = math;
	}
	
	public int getId() {
		return id;
	}
	
	public int getMl() {
		return ml;
	}
	
	public int getEng() {
		return eng;
	}
	
	public int getMath() {
		return math;
	}
	
	public void setMl(int ml) {
		this.ml = ml;
	}
	
	public void setEng(int eng) {
		this.eng = eng;
	}
	
	public void setMath(int math) {
		this.math = math;
	}

	public int getSum() {
		return ml+eng+math;
	}
	
	public double getAvg() {
		return (int)(this.getSum()*100 / 3.0) * 0.01;
	}
	
	public String getGrade() {
		int criteria = getSum();
		if(criteria >= 3*90) {
			return "A";
		}else if(criteria >= 3*80) {
			return "B";
		}else if(criteria >= 3*70) {
			return "C";
		}else if(criteria >= 3*60) {
			return "D";
		}else {
			return "F(재수강 요망)";
		}
	}	
}

// 메인 클래스
public class Ex01 {
	static Connection conn = null;
	static Statement stmt = null;
	
	// 메인메소드
	public static void main(String[] args) {
		System.out.println("학생성적관리프로그램(ver 0.5.0)");
		String select;
		
		while(true) {
			Scanner sc = new Scanner(System.in);
			System.out.print("1.리스트    2.상세보기    3.입력    4.수정    5.삭제    0.종료  >");
			select = sc.nextLine();
			if(select.equals("0")) {
				
				System.out.println("이용해주셔서 감사합니다!");
				return;
			}else if(select.equals("1")) {
				// 리스트
				ArrayList<String[]> datas = totalShow();
				System.out.println("---------------------------------------------------------");
				System.out.println("학번\t국어\t영어\t수학");
				for(int i = 0; i<datas.size(); i++) {
					String[] data = datas.get(i);
					System.out.println(data[0] + "\t" + data[1] + "\t" + data[2] + "\t" + data[3]);
				}
				System.out.println("---------------------------------------------------------");
			}else if(select.equals("2")) {		
				// 상세보기
				boolean isFinish = false;
				int search, selection;
				System.out.println("---------------------------------------------------------");
				System.out.println("학번을 입력하여 해당 학생의 상세한 성적정보를 확인할 수 있습니다!");
				while(!isFinish) {
					System.out.print("학번> ");
					search = sc.nextInt();
					if(isContain(search)) {
						String[] data = getDetail(search);
						System.out.println("---------------------------------------------------------");
						System.out.println("학번: " + data[0]);
						System.out.println("전체 총점: " + data[1]);
						System.out.println("개인 평균/전체 평균: " + data[2] + "/" + data[3]);
						System.out.println("학점: " + data[4]);
						System.out.println("---------------------------------------------------------");
						isFinish = true;
					}else {
						System.out.print("존재하지 않는 학번입니다! 다시 입력: 1  이전 메뉴: 0  > ");
						selection = sc.nextInt();
						if(selection == 0) {
							isFinish = true;
						}else if(selection == 1) {
							System.out.println("입력을 계속합니다");	
						}
					}
				}
				
			}else if(select.equals("3")) {
				// 입력
				int id = 0;
				int ml, eng, math;
				System.out.println("------------------------------------------------");
				System.out.println("학번과 과목별 시험점수를 입력해주세요!");
				
				// 유효성 검사 진행(중복 학번 체크)
				while(true) {
					System.out.print("학번> ");
					int temp = sc.nextInt();
					if(isContain(temp)) {
						System.out.println("이미 존재하는 학번입니다! 다시 입력하세요!");
					}else {
						id = temp;
						break;
					}
				}
				
				// 유효성 검사 진행(과목 점수 입력)
				while(true) {
					System.out.print("국어> ");
					int temp = sc.nextInt();
					if((temp > 100) || (temp < 0)) {
						System.out.println("시험 점수는 0 ~ 100 사이 숫자만 입력받습니다!");
					}else {
						ml = temp;
						break;
					}
				}
				
				// 유효성 검사 진행(과목 점수 입력)
				while(true) {
					System.out.print("영어> ");
					int temp = sc.nextInt();
					if((temp > 100) || (temp < 0)) {
						System.out.println("시험 점수는 0 ~ 100 사이 숫자만 입력받습니다!");
					}else {
						eng = temp;
						break;
					}
				}
				
				// 유효성 검사 진행(과목 점수 입력)
				while(true) {
					System.out.print("수학> ");
					int temp = sc.nextInt();
					if((temp > 100) || (temp < 0)) {
						System.out.println("시험 점수는 0 ~ 100 사이 숫자만 입력받습니다!");
					}else {
						math = temp;
						break;
					}
				}
				Student std = new Student(id, ml, eng, math);
				insertOne(std);
				System.out.println("------------------------------------------------");
			}else if(select.equals("4")) {
				// 수정
				int id, ml, eng, math, selection;
				boolean isFinish = false;
				System.out.println("------------------------------------------------\n");
				System.out.println("학번을 입력하여 성적을 수정할 수 있습니다!");
				while(!isFinish) {
					System.out.print("학번> ");
					id = sc.nextInt();
					if(isContain(id)) {
						// 유효성 검사 진행(과목 점수 입력)
						while(true) {
							System.out.print("국어> ");
							ml = sc.nextInt();
							if((ml > 100) || (ml < 0)) {
								System.out.println("시험 점수는 0 ~ 100 사이 숫자만 입력받습니다!");
							}else {
								break;
							}
						}
						
						// 유효성 검사 진행(과목 점수 입력)
						while(true) {
							System.out.print("영어> ");
							eng = sc.nextInt();
							if((eng > 100) || (eng < 0)) {
								System.out.println("시험 점수는 0 ~ 100 사이 숫자만 입력받습니다!");
							}else {
								break;
							}
						}
						
						// 유효성 검사 진행(과목 점수 입력)
						while(true) {
							System.out.print("수학> ");
							math = sc.nextInt();
							if((math > 100) || (math < 0)) {
								System.out.println("시험 점수는 0 ~ 100 사이 숫자만 입력받습니다!");
							}else {
								break;
							}
						}
						Student std = new Student(id, ml, eng, math);
						modify(std);
						System.out.println(id + "번 학생의 성적을 수정하였습니다!\n");
						System.out.println("---------------------------------------------------------");
						isFinish = true;
					}else {
						System.out.print("존재하지 않는 학번입니다! 다시 입력: 1  이전 메뉴: 0  > ");
						selection = sc.nextInt();
						if(selection == 0) {
							isFinish = true;
						}else if(selection == 1) {
							System.out.println("입력을 계속합니다");	
						}
					}	
				}
			}else if(select.equals("5")) {
				boolean isFinish = false;
				int id, selection;
				System.out.println("------------------------------------------------\n");
				System.out.println("학번을 입력하여 학생 정보를 삭제할 수 있습니다!");
				while(!isFinish) {
					System.out.print("학번> ");
					id = sc.nextInt();
					if(isContain(id)) {
						deleteOne(id);
						isFinish = true;
						System.out.println(id + "번 학생의 정보를 삭제하였습니다!\n");
					}else {
						System.out.print("존재하지 않는 학번입니다! 다시 입력: 1  이전 메뉴: 0  > ");
						selection = sc.nextInt();
						if(selection == 0) {
							isFinish = true;
						}else if(selection == 1) {
							System.out.println("입력을 계속합니다");
						}
					}
				}
				System.out.println("------------------------------------------------\n");
			}else {
				System.out.println("잘못된 입력입니다! 0번에서 5번까지만 입력할 수 있습니다!");
			}	
		}
	}

	// 학생 정보 DB에 저장하는 메소드
	public static void insertOne(Student std) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/student";
		String sql = "insert into gradeTable(id, ml, eng, math) values (";
		sql += std.getId() + ", " + std.getMl() + ", " + std.getEng() + ", " + std.getMath() + ")";
		System.out.println(sql);
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "root", "");
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) { 
			e.printStackTrace();
		}finally {
			try {
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	// 학생 정보 DB에서 꺼내 출력하는 메소드
	public static ArrayList<String[]> totalShow() {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/student";
		String sql = "select id, ml, eng, math from gradeTable";
		ArrayList<String[]> result = new ArrayList<>();
		
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "root", "");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				try {
					String[] data = {String.valueOf(rs.getInt(1)), String.valueOf(rs.getInt(2)), String.valueOf(rs.getInt(3)), String.valueOf(rs.getInt(4))};
					result.add(data);
				}catch(Exception e) {
					continue;
				}	
			}
		
		}catch (SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) { 
			
		}finally {
			try {
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return result;
	}
	
	// 상세보기를 위한 메소드
	public static String[] getDetail(int id) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/student";
		String sql = "select id, ml, eng, math from gradeTable where id="+id;
		String tSql = "select sum(ml+eng+math)/(select count(*) from gradeTable)/(select count(*) from gradeTable) as avg from gradeTable";
		String[] arr = new String[5];
		ResultSet rs = null;
		
		Double tAvg = 0.0;		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "root", "");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			// 총학생 평균을 얻어내기 위한 쿼리 전송
			ResultSet trs = null;
			Statement temp = conn.createStatement();
			trs = temp.executeQuery(tSql);
			if(trs.next()) tAvg = trs.getDouble(1);
			
			if(rs.next()) {
				Student std = new Student(id, rs.getInt(2), rs.getInt(3), rs.getInt(4));
				arr[0] = String.valueOf(rs.getInt(1));
				arr[1] = String.valueOf(rs.getInt(2) + rs.getInt(3) + rs.getInt(4));
//				arr[2] = String.valueOf((int)((rs.getInt(2) + rs.getInt(3) + rs.getInt(4))/3.0*100)*0.01);
				arr[2] = String.valueOf(std.getAvg());
				arr[3] = String.valueOf((int)(tAvg*100)*0.01);
				arr[4] = String.valueOf(std.getGrade());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) { 
			
		}finally {
			try {
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}
		return arr;
	}
	
	public static boolean isContain(int id) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/student";
		String sql = "select id from gradeTable where id="+id;
		
		ResultSet rs = null;
		int searchResult = 0;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "root", "");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		
			if(rs.next()) searchResult = rs.getInt(1);
		
		} catch (SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) { 
			
		}finally {
			try {
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}
		if(searchResult != 0) return true;
		else return false;
	}
	
	// 수정을 위한 메소드
	public static void modify(Student std) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/student";
		String sql = "update gradeTable set ";
		sql += "id="+std.getId()+", ml=" + std.getMl() + ", eng=" + std.getEng() + ", math=" + std.getMath();
		sql += " where id="+std.getId();
				
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "root", "");
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) { 
			
		}finally {
			try {
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}
	}
	
	// 삭제를 위한 메소드
	public static void deleteOne(int id) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/student";
		String sql = "delete from gradeTable where id=" + id;
				
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "root", "");
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);

		}catch(ClassNotFoundException e) { 
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}
	}
}

