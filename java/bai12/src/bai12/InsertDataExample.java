package bai12;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertDataExample {

	public static void main(String[] args)  {
		// TODO Austo-generated method stub
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		try {
			File file = new File("E:\\java\\sampledb1");
			connection = DriverManager.getConnection("jdbc:derby:" + file.getAbsolutePath() + ";create=true");
			statement = connection.createStatement();
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			System.out.println("db path" + file.getAbsolutePath());
			System.out.println("create database succesfull");
//			String sql = "create table student(" + " id bigint primary key"
//					+ " generated always as identity(start with 1, increment by 1)," + " name varchar(1000),"
//					+ " age integer default 20)";
//			statement.execute(sql);
			System.out.println("create tables succesfull");
			statement.execute("insert into student(name, age) values('tran van b', 20)");
			System.out.println("success");
			 statement.execute("insert into student(name, age) values('tran thi b', 12)");
			 statement.execute("insert into student(name, age) values('nguyen van c',56)");
			 rs = statement.executeQuery("select * from student");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {
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