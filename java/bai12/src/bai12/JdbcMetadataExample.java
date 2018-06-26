package bai12;

import java.io.File;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcMetadataExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection = null;
		Statement statement = null;
		try {
			File file = new File("E:\\java\\sampledb1");
			try {
				Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
				connection = DriverManager.getConnection("jdbc:derby:"+file.getAbsolutePath()+ ";create=true");
				statement = connection.createStatement();
				System.out.println("db path"+ file.getAbsolutePath());
				System.out.println("create database succesfull");
				DatabaseMetaData metaData = connection.getMetaData();
				System.out.println("db version" + metaData.getDatabaseMajorVersion());
				System.out.println("driver name" + metaData.getDriverName());
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
