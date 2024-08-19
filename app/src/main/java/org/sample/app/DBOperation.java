package org.sample.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBOperation {
	static final String DB_URL = System.getenv("DB_URL");
	static final String USER = System.getenv("DB_USER");
	static final String PASS = System.getenv("DB_PASS");
	public String execute(Query query) {
		String sql = query.toSQL();
		return executeStatement(sql);
	}

	private String executeStatement(String sql) {
		System.out.println("Executing SQL: " + sql);
		StringBuilder sb = new StringBuilder();
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		    Statement stmt = conn.createStatement();
		    ResultSet rs = stmt.executeQuery(sql);
		) {
			boolean first = true;
			while(rs.next()){
				if (!first) {
					sb.append(",\n");
				}
				sb.append("{\"ID\": " + rs.getInt("id"));
				sb.append(", \"Age\": " + rs.getInt("age"));
				sb.append("\", \"First\": " + rs.getString("first"));
				sb.append("\", \"Last\": " + rs.getString("last") + "\"}");
			}
		} catch (SQLException e) {
			//ignore for now - this is just a sample
			//e.printStackTrace();
		}
		return sb.toString();
	}
}
