package mbcboard.dao;

import java.lang.reflect.Member;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.print.attribute.standard.RequestingUserName;

import mbcboard.dto.MemberDTO;

public class MemberDAO {

	// 필드
	public MemberDTO memberDTO = new MemberDTO(); //빈 객체 생성
	public Connection connection = null; // 1단계에서 사용하는 객체
	public Statement statement = null; // 3단계에서 사용하는 객체(구형), 변수 직접처리, '" + name + "'
	public PreparedStatement preparedStatement = null; // 3단계에서 사용하는 객체(신형), ?(인파라미터)
	public ResultSet resultSer = null; // 4단계에서 결과받는 표 객체 executeQuery (select결과)
	public int result = 0; // 4단계에서 결과 받는 정수 executeUpdate (insert, update, delete)
	// 1개의 행이 삽입| 수정 |삭제 되었습니다. (정상처리 -> commit)
	// 0개의 행이 삽입| 수정 | 삭제 되었습니다. (비정상처리 -> rollback)
	

	
	
	// 생성자
	
	
	// 메서드
	
	
	public void createMember() throws SQLException{
		
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String dbUser = "system";
		String dpPassword = "oracle";
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("사용할 id를 입력하세요 : ");
		String id = scanner.nextLine();
		
		System.out.print("사용할 pw를 입력하세요 : ");
		String pw = scanner.nextLine();		
		
		System.out.println("사용할 email을 입력하세요 : ");
		String email = scanner.nextLine();
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection conn = DriverManager.getConnection(url, dbUser, dpPassword);
			
			String bwriter = "회원";  
			
			String sql = "insert into member(mno, id, pw, email, bwriter) values(member_seq.nextval, ?, ?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, email);
			pstmt.setString(4, bwriter);
			
			int rows = pstmt.executeUpdate();
			
			if(rows > 0) {
				System.out.println("회원가입 성공!");
			}else {
				System.out.println("회원가입 실패.");
			}
			pstmt.close();
			conn.close();
		}catch(ClassNotFoundException e) {
			System.out.println("JDBC 드라이버 오류 : " + e.getMessage());
		}catch (SQLException e) {
			System.out.println("DB오류 : " + e.getMessage());
		}
		
		
	} // 회원가입 메서드 종료


	public MemberDTO loginMember(String id, String pw, MemberDTO session) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:orcl",
					"system", "oracle"			
					);
			String sql = "select * from member where id = ? and pw = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				MemberDTO memberDTO = new MemberDTO();
				memberDTO.setMno(rs.getInt("mno"));
				memberDTO.setId(rs.getString("id"));
				memberDTO.setPw(rs.getString("pw"));
				memberDTO.setEmail(rs.getString("email"));
				
				return memberDTO;
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			
		conn.close();
		
		}
		
		
		return null;
	}



	public boolean updateMemberInfo(String id, String newpw, String newemail) throws SQLException {
		Connection conn = null ;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "oracle");
		
			String sql = "update member set pw = ?, email = ? where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newpw);
			pstmt.setString(2, newemail);
			pstmt.setString(3, id);
			
			int rows = pstmt.executeUpdate();
			return rows > 0;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			conn.close();
			pstmt.close();
		}

	}


	public boolean delete(String userId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from member where id = ?";
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "oracle");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			
			int rowsAffected = pstmt.executeUpdate();
			return rowsAffected > 0;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		

	}

	
		
}// 클래스 종료
