package com.thuannd.dao;

import java.util.List;

public interface StudentDAO {
	public void insert(Student student);

	public List<Student> listStudent();

	public void createTableIfNotExist();

	public void deleteStudent(int id);

	public Student getStudentById(int id);

	public void updateStudent(Student student);

	public List<Student> searchStudent(String keyword);
}
