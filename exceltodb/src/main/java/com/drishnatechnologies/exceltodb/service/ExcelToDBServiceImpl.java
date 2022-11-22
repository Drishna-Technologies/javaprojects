package com.drishnatechnologies.exceltodb.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import com.drishnatechnologies.exceltodb.model.Student;

@Service
public class ExcelToDBServiceImpl implements ExcelToDBService {

	@Override
	public List<Student> extractStudentFromExcel() throws IOException {
		// obtaining input bytes from a file
		InputStream fis = new FileInputStream(new File("student.xlsx"));
		List<Student> studentList = new ArrayList<Student>();
		Workbook workbook = new XSSFWorkbook(fis);
		Sheet sheet = workbook.getSheet("Sheet1");
		Iterator<Row> rows = sheet.iterator();
		int rowNumber = 0;
		while (rows.hasNext()) {
			Row currentRow = rows.next();

			// skip header
			if (rowNumber == 0) {
				rowNumber++;
				continue;
			}

			Iterator<Cell> cellsInRow = currentRow.iterator();

			Student student = new Student();

			int cellIdx = 0;
			while (cellsInRow.hasNext()) {
				Cell currentCell = cellsInRow.next();

				switch (cellIdx) {
				case 0:
					student.setId((int) currentCell.getNumericCellValue());
					System.out.println(student.getId());
					break;

				case 1:
					student.setName(currentCell.getStringCellValue());
					break;

				case 2:
					student.setEmail(currentCell.getStringCellValue());
					break;

				case 3:
					student.setMobile(String.valueOf(currentCell.getNumericCellValue()));
					break;

				default:
					break;
				}

				cellIdx++;
			}
			studentList.add(student);
		}
		return studentList;
	}
}
