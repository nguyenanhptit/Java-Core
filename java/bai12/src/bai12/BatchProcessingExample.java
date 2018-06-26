package bai12;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchProcessingExample {
	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		File file = new File("E:\\java\\sampledb1");
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
			connection.setAutoCommit(false);
			for (int i = 0; i < 20; i++) {
				String name = "tran van" + i;
				int age = 20 + i;
				String sql = "insert into student(name,age)" + " values ( '" + name + "', " + age + ")";
				statement.addBatch(sql);
			}
			connection.rollback();
			connection.setAutoCommit(true);
			statement.executeBatch();
			ResultSet rs = statement.executeQuery("select count(*) from student");
			if (rs.next())
				System.out.println("total record= " + rs.getInt(1));
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
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
