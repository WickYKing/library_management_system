package com.lms.dao;

import java.util.List;

import com.lms.models.Student;

public interface StudentDao {
	public Integer addStudent(Student student);
	public Integer updateStudent(Student student);
	public Integer deleteStudent(Integer id);
	public Integer getIdByName(Integer id);
	public Student getStudentById(Integer id);
	public List<Student> getAllStudent();
	public Integer getIdByRollNo(String rollNo);
	

}
