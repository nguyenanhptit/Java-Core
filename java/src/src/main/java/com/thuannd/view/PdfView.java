package com.thuannd.view;

import java.util.Map;
import java.util.concurrent.Phaser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.thuannd.dao.JavaClazz;
import com.thuannd.dao.Student;

public class PdfView extends AbstractITextPdfView {
	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) {

		try {
			JavaClazz clazz = (JavaClazz) model.get("clazzObj");
			PdfPTable table = new PdfPTable(3);
			table.setWidthPercentage(100.0f);
			table.setWidths(new float[] { 2.0f, 3.0f, 1.5f });
			table.setSpacingBefore(10);

			Font font = FontFactory.getFont(FontFactory.HELVETICA);

			PdfPCell cell = new PdfPCell();
			cell.setBackgroundColor(BaseColor.CYAN);
			cell.setPadding(5);
			cell.setPhrase(new Phrase("ID", font));
			table.addCell(cell);

			cell.setPhrase(new Phrase("Name", font));
			table.addCell(cell);

			table.completeRow();

			for (Student student : clazz.getStudents()) {
				table.addCell(String.valueOf(student.getId()));
				table.completeRow();
			}

			document.close();
		} catch (DocumentException e) {
			e.printStackTrace();
		}

	}
}
