package bai12;

import java.io.File;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class JdbcRowSetExaample {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		Connection connection = null;
		Statement statement = null;
		RowSetFactory rsf = null;
		
			File file = new File("E:\\java\\sampledb1");
			try {
				Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
				connection = DriverManager.getConnection("jdbc:derby:"+file.getAbsolutePath()+ ";create=true");
				statement = connection.createStatement();
				System.out.println("db path"+ file.getAbsolutePath());
				System.out.println("create database succesfull");
				rsf= RowSetProvider.newFactory();
				JdbcRowSet jdbcRs = rsf.createJdbcRowSet();
				jdbcRs.setUrl("jdbc:derby:" +file);
				jdbcRs.setCommand("select * from student");
				jdbcRs.execute();
				while(jdbcRs.next()) {
					System.out.println(jdbcRs.getInt(1)+ "\t" + jdbcRs.getString("name"));
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
		
		}finally {
			try {
				connection.close();
	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}}


