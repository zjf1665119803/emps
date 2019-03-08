package com.guigu.service;

import java.util.List;

import com.guigu.pojo.StudentInfo;
import com.guigu.pojo.TrackRecordInfo;

public interface StudentInfoService {

	List<StudentInfo> findAll() throws Exception;

	StudentInfo findById(int studentId) throws Exception;

	void updateById(StudentInfo studentinfo) throws Exception;

	void deleteById(int studentId) throws Exception;

	void add(StudentInfo studentinfo) throws Exception;

	List<StudentInfo> findByName(String studentName) throws Exception;



}
