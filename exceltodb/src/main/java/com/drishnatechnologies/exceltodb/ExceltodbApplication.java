package com.drishnatechnologies.exceltodb;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.drishnatechnologies.exceltodb.model.Student;
import com.drishnatechnologies.exceltodb.repo.StudentRepo;
import com.drishnatechnologies.exceltodb.service.ExcelToDBService;

@SpringBootApplication
public class ExceltodbApplication {

	@Autowired
	ExcelToDBService excelToDBService;

	@Autowired
	StudentRepo studentRepo;

	public static void main(String[] args) {
		SpringApplication.run(ExceltodbApplication.class, args);
	}

	@PostConstruct
	public void run() throws IOException {
		List<Student> allStudents = excelToDBService.extractStudentFromExcel();
		for (Student student : allStudents) {
			studentRepo.save(student);
		}
	}
}
