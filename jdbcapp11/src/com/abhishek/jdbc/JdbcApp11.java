package com.abhishek.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcApp11 {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myDB", "root", "Abhishek123");
			st = con.createStatement();
			
			rs = st.executeQuery("update emp1 set ESAL = ESAL - 500 where ESAL < 10000");
			int rowCount = st.getUpdateCount();
			System.out.println("RowCount	: "+rowCount);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
				st.close();
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}