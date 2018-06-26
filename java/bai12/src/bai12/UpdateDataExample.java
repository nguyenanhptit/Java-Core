package bai12;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateDataExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection = null;

		File file = new File("E:\\java\\sampledb1");

		PreparedStatement statement = null;
		ResultSet rs = null; // doc tung dong 1 trong bang
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			connection = DriverManager.getConnection("jdbc:derby:" + file.getAbsolutePath() + ";create=true");
			statement = connection.prepareStatement("UPDATE Student Set Name = ? WHERE ID = ?");

			// statement = connection.createStatement();
			System.out.println("db path" + file.getAbsolutePath());
			System.out.println("create database succesfull");
			// String sql = "create table student(" + " id bigint primary key"
			// + " generated always as identity(start with 1, increment by 1)," + " name
			// varchar(1000),"
			// + " age integer default 20)";
			// statement.execute(sql);
			statement.setString(1, "le thi z");
			statement.setInt(2, 1);
			statement.executeUpdate();

			statement = connection.prepareStatement("select * from student");  // de in ra cm
			rs = statement.executeQuery(); // quet ca bang
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
