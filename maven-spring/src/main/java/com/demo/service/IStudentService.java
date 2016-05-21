package com.demo.service;

import com.demo.bean.Student;

public interface IStudentService {

	Student selectById(Integer id);

	int addStudent(Student student);

	int updateStudent(Student student);

	void addAndUpdate(Student student);

}