package com.guigu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.guigu.mapper.StudentInfoMapper;
import com.guigu.pojo.StudentInfo;
import com.guigu.pojo.StudentInfoExample;
import com.guigu.service.StudentInfoService;

@Service
public class StudentInfoServiceImpl implements StudentInfoService{

	@Resource
	private StudentInfoMapper studentInfoMapper;

	
	@Override
	public List<StudentInfo> findAll() throws Exception {
		StudentInfoExample studentInfoExample = new StudentInfoExample();
		//studentInfoExample.createCriteria().andStudentMarkNotEqualTo("-1");
		return studentInfoMapper.selectByExample(studentInfoExample);
	}

	@Override
	public StudentInfo findById(int studentId) throws Exception {
		return studentInfoMapper.selectByPrimaryKey(studentId);
	}

	@Override
	public void updateById(StudentInfo studentinfo) throws Exception {
		studentInfoMapper.updateByPrimaryKey(studentinfo);
		
	}

	@Override
	public void deleteById(int studentId) throws Exception {
		studentInfoMapper.deleteByPrimaryKey(studentId);

		
	}

	@Override
	public void add(StudentInfo studentinfo) throws Exception {
		studentInfoMapper.insert(studentinfo);
		
	}

	@Override
	public List<StudentInfo> findByName(String studentName) throws Exception {
		StudentInfoExample studentInfoExample = new StudentInfoExample();
		studentInfoExample.createCriteria().andStudentNameLike("%"+studentName+"%");
		return studentInfoMapper.selectByExample(studentInfoExample);
		
		
	}

	
	}

