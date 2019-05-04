package config;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DB {
	public static Connection dbConn() {
		//context.xml에 설정된 dbcp에서 커넥션을 가져옴
		DataSource ds = null;
		Connection conn = null;
		
		try {
			//context.xml 분석하는 객체
			Context ctx = new InitialContext();
			//context.xml의 Resource 태그 검색
			ds = (DataSource) ctx.lookup("java:/comp/env/JSP_DB");
			conn = ds.getConnection(); // 커넥션 할당 받음
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
