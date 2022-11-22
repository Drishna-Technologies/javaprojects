package com.drishnatechnologies.exceltodb.service;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.drishnatechnologies.exceltodb.model.Student;

@Service
public interface ExcelToDBService {

	public List<Student> extractStudentFromExcel() throws IOException;
}
