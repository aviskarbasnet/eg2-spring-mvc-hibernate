package com.aviskar.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aviskar.example.dao.StudentDao;
import com.aviskar.example.model.Student;

@Service
public class StudentService {

	@Autowired
	private StudentDao studentDao;

	public List<Student> findAll() {
		return studentDao.findAll();
	}

	public Student findOne(Long id) {
		return studentDao.findOne(id);
	}

	public void save(Student student) {
		studentDao.save(student);
	}

	public void update(Student student) {
		studentDao.update(student);
	}

	public void delete(Long id) {
		studentDao.delete(id);
	}
}
