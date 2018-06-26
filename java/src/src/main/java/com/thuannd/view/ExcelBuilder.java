package com.thuannd.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.thuannd.dao.JavaClazz;
import com.thuannd.dao.Student;

public class ExcelBuilder extends AbstractXlsView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		Sheet sheet = workbook.createSheet("Java Clazz");
		Row header = sheet.createRow(0);
		header.createCell(0).setCellValue("ID");
		header.createCell(1).setCellValue("Name");
		header.createCell(2).setCellValue("Age");

		JavaClazz clazz = (JavaClazz) model.get("clazzObj");
		List<Student> students = clazz.getStudents();
		if (students != null) {
			for (int i = 0; i < students.size(); i++) {
				Student student = clazz.getStudents().get(i);
				Row row = sheet.createRow(i + 1);
				row.createCell(0).setCellValue(student.getId());
				row.createCell(1).setCellValue(student.getName());
				row.createCell(2).setCellValue(student.getAge());
			}
		} else {
			System.out.println("NULL cmnr@@");
		}

	}

}
