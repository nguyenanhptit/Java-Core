package bai12;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectDataExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		File file = new File("E:\\java\\sampledb2");
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			connection = DriverManager.getConnection("jdbc:derby:" + file.getAbsolutePath() + ";create=true");
			statement = connection.createStatement();
			System.out.println("db path" + file.getAbsolutePath());
			System.out.println("create database succesfull");
			// String sql = "create table student(" + " id bigint primary key"
			// + " generated always as identity(start with 1, increment by 1)," + " name
			// varchar(1000),"
			// + " age integer default 20)";
			// statement.execute(sql);
			statement.execute("insert into student(name, age) values('tran van b', 20)");
			statement.execute("insert into student(name, age) values('tran thi b', 12)");
			statement.execute("insert into student(name, age) values('nguyen van c',56)");
			rs = statement.executeQuery("select * from student");

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt(3);
				System.out.println(id + "\t" + name + "\t" + age);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

}
