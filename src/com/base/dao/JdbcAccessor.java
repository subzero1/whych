package com.base.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public abstract class JdbcAccessor {
	private String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static DataSource dataSuorce = null;
	static {
		try {
			Context context = new InitialContext();
			context = (Context) context.lookup("java:comp/env");
			dataSuorce = (DataSource) context.lookup("jdbc/gz_whych");
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (Exception eq) {
			eq.printStackTrace();
		}
	}

	public Connection getConnection() {
		try {
			return dataSuorce.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Connection getConnection(String ConnentionStr, String Cur_DbUser,
			String Cur_DbPass) {
		Connection conn = null;
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(ConnentionStr, Cur_DbUser,
					Cur_DbPass);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public void closeConnection(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void closeStatement(Statement statement) {
		try {
			if (statement != null) {
				statement.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void closeResultSet(ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
