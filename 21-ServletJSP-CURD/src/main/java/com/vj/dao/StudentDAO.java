package com.vj.dao;

import java.util.List;

import com.vj.model.Student;

public interface StudentDAO {


	/**
	 * This Method takes model class object as input
	 * and returns PrimaryKey(Integer as)Output
	 * 
	 */
	public Integer saveStudent(Student s);
	/**
	 * This method is used to fetch 
	 * all rows from DB table 
	 * as List of Objects
	 * 
	 */
	public List<Student> getAllStudents();
	/**
	 * This method is used to remove one row
	 * based on PK value. Returns success/fail
	 * message back to UI
	 */
	public String deleteStudent(Integer id);
	
	//get oneStudent object based on PK
	public Student getOneStudent(Integer id);
	//to update the select record
	public String updateStudent(Student s);

}
