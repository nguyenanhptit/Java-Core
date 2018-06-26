package bai12;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcFirstExample {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		Connection connection = null;
		Statement statement = null;
		try {
			File file = new File("E:\\java\\sampledb");
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			connection = DriverManager.getConnection("jdbc:derby:" + file.getAbsolutePath() + ";create=true");
			statement = connection.createStatement();
			System.out.println("db path" + file.getAbsolutePath());
			System.out.println("create database succesfull");
			String sql = "create table student(" + " id bigint primary key"
					+ " generated always as identity(start with 1, increment by 1)," + " name varchar(1000),"
					+ " age integer default 20)";
			statement.execute(sql);
			System.out.println("create table");
			 System.out.println(statement.execute(sql));
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
