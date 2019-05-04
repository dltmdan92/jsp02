package emp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import config.DB;

public class EmpDAO {
	public void insert() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DB.dbConn();
			conn.setAutoCommit(false);
			long before = System.currentTimeMillis();
			for(int i = 1; i <= 100000; i++) {
				String sql = "insert into emp2 (empno, ename, deptno) "
							+ " values (?, ?, ?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, i);
				pstmt.setString(2, "kim" + i);
				pstmt.setInt(3, i);
				pstmt.executeUpdate();
				pstmt.close();
			}
			conn.commit(); // 수동커밋
			conn.setAutoCommit(true);
			long after = System.currentTimeMillis();
			System.out.println("실행시간 : " + (after - before));
		} catch(Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void insert_batch() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DB.dbConn();
			conn.setAutoCommit(false);
			long before = System.currentTimeMillis();
			String sql = "insert into emp2 (empno, ename, deptno) "
					+ " values (?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			for(int i = 100001; i <= 200000; i++) {
				pstmt.setInt(1, i);
				pstmt.setString(2, "lee" + i);
				pstmt.setInt(3, i);
				pstmt.addBatch();
			}
			pstmt.executeBatch();
			conn.commit();
			conn.setAutoCommit(true);
			long after = System.currentTimeMillis();
			System.out.println("실행시간 : " + (after - before));
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
