package com.guigu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.guigu.mapper.StudentInfoMapper;
import com.guigu.pojo.StudentInfo;
import com.guigu.pojo.StudentInfoExample;
import com.guigu.service.StudentRecruitService;
@Service
public class studentRecruitServiceImpl implements StudentRecruitService {
	
	@Resource
	private StudentInfoMapper studentInfoMapper;

	@Override
	public List<StudentInfo> findAll()  {
		StudentInfoExample studentInfoExample = new StudentInfoExample();
		//studentInfoExample.createCriteria().andStudentMarkEqualTo("1");
		return studentInfoMapper.selectByExample(studentInfoExample);
	}

	@Override
	public StudentInfo findById(int studentId)  {
		return studentInfoMapper.selectByPrimaryKey(studentId);
	}

	@Override
	public void updateById(StudentInfo studentinfo)  {
		studentInfoMapper.updateByPrimaryKey(studentinfo);
		
	}

	@Override
	public void deleteById(int studentId)  {
		studentInfoMapper.deleteByPrimaryKey(studentId);
		
	}

	@Override
	public void add(StudentInfo studentinfo)  {
		studentInfoMapper.insert(studentinfo);
	}

	@Override
	public List<StudentInfo> findByName(String studentName)  {
		StudentInfoExample studentInfoExample = new StudentInfoExample();
		studentInfoExample.createCriteria().andStudentNameLike("%"+studentName+"%").andStudentMarkEqualTo("1");
		return studentInfoMapper.selectByExample(studentInfoExample);
	}

	@Override
	public List<StudentInfo> findByType(String studentType)  {
		StudentInfoExample studentInfoExample = new StudentInfoExample();
		studentInfoExample.createCriteria().andStudentTypeEqualTo(studentType).andStudentMarkEqualTo("1");
		return studentInfoMapper.selectByExample(studentInfoExample);
	}

	@Override
	public List<StudentInfo> findBy(String studentName, String studentType) {
System.out.println("123456");
		StudentInfoExample stu = new StudentInfoExample();
		if(studentType.equals("请选择")) {
			stu.createCriteria().andStudentNameLike("%"+studentName.trim()+"%");		
			}else {
				stu.createCriteria().andStudentNameLike("%"+studentName.trim()+"%").andStudentTypeLike("%"+studentType+"%");		
			}

		return studentInfoMapper.selectByExample(stu);
	}



}
