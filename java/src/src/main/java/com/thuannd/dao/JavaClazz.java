package com.thuannd.dao;

import java.util.List;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.XmlElement;

@XmlRootElement(name = "clazz")
public class JavaClazz {

	private List<Student> students;

	public JavaClazz() {
		super();
	}

	public JavaClazz(List<Student> students) {
		super();
		this.students = students;
	}

	@XmlElements({ @XmlElement(name = "student", type = Student.class) })
	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

}
