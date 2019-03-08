package com.guigu.service;

import java.util.List;

import com.guigu.pojo.StudentInfo;

public interface StudentRecruitService {

	List<StudentInfo> findAll() throws Exception;

	StudentInfo findById(int studentId) throws Exception;

	void updateById(StudentInfo studentinfo) throws Exception;

	void deleteById(int studentId) throws Exception;

	void add(StudentInfo studentinfo) throws Exception;

	List<StudentInfo> findByName(String studentName) throws Exception;

	List<StudentInfo> findByType(String studentType) throws Exception;

	List<StudentInfo> findBy(String studentName, String studentType)  throws Exception;




}
