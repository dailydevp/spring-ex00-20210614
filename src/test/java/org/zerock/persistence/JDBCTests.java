package org.zerock.persistence;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class JDBCTests {

	@Test
	public void test() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (Exception e) {
			fail();
		}
		
		String url = "jdbc:mariadb://aws ip주소/test";
		String user = "로그인유저명";
		String password = "비밀번호";

	try (Connection con = DriverManager.getConnection(url,user,password)){
		
		assertNotNull(con);
		
	} catch (Exception e) {
		fail();
	}
  }
}
