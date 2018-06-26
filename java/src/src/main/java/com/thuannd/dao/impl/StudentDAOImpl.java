package com.thuannd.dao.impl;

import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.thuannd.dao.Student;
import com.thuannd.dao.StudentDAO;

public class StudentDAOImpl implements StudentDAO, DisposableBean {

	private final static class StudentRowmapper implements RowMapper<Student> {
		@Override
		public Student mapRow(ResultSet rs, int i) throws SQLException {
			Student student = new Student();
			student.setId(rs.getInt("id"));
			student.setName(rs.getString("name"));
			student.setAge(rs.getInt("age"));
			return student;
		}
	}

	private JdbcTemplate jdbcTemplate;
	private DataSource dataSource;

	public StudentDAOImpl(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void createTableIfNotExist() {
		try {
			DatabaseMetaData dbmd = dataSource.getConnection().getMetaData();
			ResultSet rs = dbmd.getTables(null, null, "STUDENT", null);
			if (rs.next()) {
				System.out.println("table " + rs.getString("TABLE_NAME") + " already exits!");
				return;
			}
			jdbcTemplate.execute(
					"create table student (id bigint primary key generated always as identity (start with 1, increment by 1),  name varchar(1000), age integer)");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void destroy() throws Exception {
		DriverManager.getConnection("jdbc:derby:C:/Java/sampledb2;shutdown=true");
	}

	@Override
	public void insert(Student student) {
		jdbcTemplate.update("INSERT INTO STUDENT (name, age) VALUES (?,?)", student.getName(), student.getAge());
		System.out.println("Created Record name = " + student.getName());
	}

	@Override
	public List<Student> listStudent() {
		return jdbcTemplate.query("SELECT * FROM STUDENT", new StudentRowmapper());
	}

	@Override
	public void deleteStudent(int id) {
		jdbcTemplate.execute("DELETE FROM STUDENT WHERE ID=" + id);
	}

	@Override
	public Student getStudentById(int id) {
		return (Student) jdbcTemplate.queryForObject("SELECT * FROM STUDENT WHERE ID = " + id, new StudentRowmapper());
	}

	@Override
	public void updateStudent(Student student) {
		jdbcTemplate.update("UPDATE STUDENT SET NAME = ?, AGE = ? WHERE ID = ?", student.getName(), student.getAge(),
				student.getId());
	}

	@Override
	public List<Student> searchStudent(String keyword) {
		return jdbcTemplate.query("SELECT * FROM STUDENT WHERE NAME LIKE '%" + keyword + "%'", new StudentRowmapper());
	}

}
