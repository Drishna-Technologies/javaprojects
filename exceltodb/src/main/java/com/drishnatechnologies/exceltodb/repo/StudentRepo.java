package com.drishnatechnologies.exceltodb.repo;

import org.springframework.data.repository.CrudRepository;

import com.drishnatechnologies.exceltodb.model.Student;

public interface StudentRepo extends CrudRepository<Student, Integer>{

}
