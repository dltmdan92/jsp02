package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.DB;
import crypt.BCrypt;

public class MemberDAO {
	public List<MemberDTO> memberList() {
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DB.dbConn();
			String sql = "SELECT  USER_ID," + 
						"        PASSWD," + 
						"        NAME," + 
						"        TO_CHAR(REG_DATE, 'YYYY-MM-DD') REG_DATE," + 
						"        ADDRESS," + 
						"        TEL" + 
						"  FROM    MEMBER_02";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				/*
				MemberDTO dto = new MemberDTO();
				dto.setUserid(rs.getString("USER_ID"));
				dto.setPasswd(rs.getString("PASSWD"));
				dto.setName(rs.getString("NAME"));
				dto.setReg_date(rs.getString("REG_DATE"));
				dto.setAddress(rs.getString("ADDRESS"));
				dto.setTel(rs.getString("TEL"));
				*/
				String userid = rs.getString("USER_ID");
				String passwd = rs.getString("PASSWD");
				String name = rs.getString("NAME");
				String reg_date = rs.getString("REG_DATE");
				String address = rs.getString("ADDRESS");
				String tel = rs.getString("TEL");
				MemberDTO dto = new MemberDTO(userid, passwd, name, reg_date, address, tel);
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if(pstmt != null) {
					pstmt.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if(conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return list;
	}
	
	public int insert(MemberDTO dto) {
		int rows = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DB.dbConn();
			String sql = "INSERT INTO MEMBER_02 (USER_ID, PASSWD, NAME, ADDRESS, TEL) VALUES "
					+ " (?, ?, ?, ?, ?) ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getUserid());
			pstmt.setString(2, dto.getPasswd());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getAddress());
			pstmt.setString(5, dto.getTel());
			rows = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if(conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return rows;
	}
	
	public MemberDTO memberDetail(String userid) {
		MemberDTO dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DB.dbConn();
			String sql = "SELECT * FROM MEMBER_02 WHERE USER_ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			System.out.println("rs : " + rs.toString());
			while(rs.next()) {
				dto = new MemberDTO();
				dto.setUserid(rs.getString("USER_ID"));
				dto.setPasswd(rs.getString("PASSWD"));
				dto.setName(rs.getString("NAME"));
				dto.setAddress(rs.getString("ADDRESS"));
				dto.setReg_date(rs.getString("REG_DATE"));
				dto.setTel(rs.getString("TEL"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if(pstmt != null) {
					pstmt.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if(conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dto;
	}
	
	public void update(MemberDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DB.dbConn();
			String sql = "UPDATE MEMBER_02" +
						" SET PASSWD = ?," +
						" 		NAME = ?," +
						"		ADDRESS = ?," +
						"		TEL = ?" +
						" WHERE	USER_ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getPasswd());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getAddress());
			pstmt.setString(4, dto.getTel());
			pstmt.setString(5, dto.getUserid());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if(conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public void delete(String userid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DB.dbConn();
			String sql = "DELETE FROM MEMBER_02 WHERE USER_ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if(conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public String loginCheck(MemberDTO dto) {
		String result = "";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DB.dbConn();
			String sql = "select * from member_02 where user_id = ? and passwd = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getUserid());
			pstmt.setString(2, dto.getPasswd());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getString("name") + "님 환영합니다.";
			} else {
				result = "로그인 실패";
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if(pstmt != null) {
					pstmt.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if(conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}
	
	public int insertMember03(MemberDTO dto) {
		int rows = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DB.dbConn();
			String sql = "INSERT INTO MEMBER_03 (USER_ID, PASSWD, NAME, address, tel) VALUES "
					+ " (?, ?, ?, ?, ?) ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getUserid());
			pstmt.setString(2, dto.getPasswd());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getAddress());
			pstmt.setString(5, dto.getTel());
			rows = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if(conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return rows;
	}
	
	public int insertMemberEncrypt(MemberDTO dto) {
		int rows = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DB.dbConn();
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO MEMBER_03 ");
			sql.append("(USER_ID, PASSWD, NAME, address, tel) values ");
			sql.append("(?, PACK_ENCRYPTION_DECRYPTION.FUNC_ENCRYPT(?), ?, ?, ?) ");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getUserid());
			pstmt.setString(2, dto.getPasswd());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getAddress());
			pstmt.setString(5, dto.getTel());
			rows = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if(conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return rows;
	}
	
	public MemberDTO loginOracleDecrypt(MemberDTO dto) {
		MemberDTO memberDTO = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DB.dbConn();
			String sql = "select user_id, name from member_03 where " +
							"user_id = ? and passwd = PACK_ENCRYPTION_DECRYPTION.FUNC_ENCRYPT(?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getUserid());
			pstmt.setString(2, dto.getPasswd());
			System.out.println("userid : " + dto.getUserid() + ", passwd : " + dto.getPasswd());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				memberDTO = new MemberDTO();
				memberDTO.setUserid(rs.getString("user_id"));
				memberDTO.setName(rs.getString("name"));
				System.out.println(memberDTO);
			} else {
				System.out.println("no exist!");
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if(conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return memberDTO;
	}
	
	public int insertBcrypt(MemberDTO dto) {
		int rows = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DB.dbConn();
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO MEMBER_03 ");
			sql.append("(user_id, passwd, name) VALUES ");
			sql.append("(?,?,?)");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getUserid());
			// 실행할 때마다 암호화키가 변경됨
			// BCrypt.hashpw(암호화할 평문, 암호화키)
			String passwd = 
					BCrypt.hashpw(dto.getPasswd(), BCrypt.gensalt());
			System.out.println("평문 : " + dto.getPasswd());
			System.out.println("암호화된 텍스트 : " + passwd);
			pstmt.setString(2, passwd);
			pstmt.setString(3, dto.getName());
			rows = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return rows;
	}
	
	public MemberDTO loginCheckBcrypt(MemberDTO dto) {
		MemberDTO result = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DB.dbConn();
			String sql = "select user_id, passwd, name from member_03 where " +
						"user_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getUserid());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String passwd = rs.getString("passwd");
				if(BCrypt.checkpw(dto.getPasswd(), passwd)) {
					result = new MemberDTO();
					result.setUserid(rs.getString("user_id"));
					result.setName(rs.getString("name"));
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if(pstmt != null) {
					pstmt.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if(conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}

}
