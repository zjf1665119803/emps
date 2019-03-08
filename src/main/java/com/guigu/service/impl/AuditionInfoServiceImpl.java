package com.guigu.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.guigu.mapper.AuditionInfoMapper;
import com.guigu.mapper.StudentInfoMapper;
import com.guigu.pojo.AuditionInfo;
import com.guigu.pojo.AuditionInfoExample;
import com.guigu.pojo.StudentInfo;
import com.guigu.pojo.StudentInfoExample;
import com.guigu.service.AuditionInfoService;

@Service
public class AuditionInfoServiceImpl implements AuditionInfoService {
	
	@Resource
	private StudentInfoMapper studentInfoMapper;

	@Resource
	private AuditionInfoMapper auditionInfoMapper;

	@Override
	public List<AuditionInfo> findAll() throws Exception {
		List<AuditionInfo> list = auditionInfoMapper.selectByExample(new AuditionInfoExample());
		for (AuditionInfo auditionInfo : list) {
			StudentInfo sti = studentInfoMapper.selectByPrimaryKey(auditionInfo.getStudentId());
			auditionInfo.setStudentName(sti.getStudentName());
		}
		return list;
	}

	@Override
	public AuditionInfo findById(int auditionId) throws Exception {
		AuditionInfo aud = auditionInfoMapper.selectByPrimaryKey(auditionId);
		StudentInfo sti = studentInfoMapper.selectByPrimaryKey(aud.getStudentId());
		aud.setStudentName(sti.getStudentName());
		return aud;
	}

	@Override
	public void updateById(AuditionInfo auditionInfo) throws Exception {
		StudentInfoExample studentInfoExample = new StudentInfoExample();
		studentInfoExample.createCriteria().andStudentNameEqualTo(auditionInfo.getStudentName());
		auditionInfo.setStudentId(studentInfoMapper.selectByExample(studentInfoExample).get(0).getStudentId());
		auditionInfoMapper.updateByPrimaryKey(auditionInfo);

	}

	@Override
	public void deleteById(int auditionId) throws Exception {
		auditionInfoMapper.deleteByPrimaryKey(auditionId);

	}

	@Override
	public void add(AuditionInfo auditionInfo) throws Exception {
		StudentInfoExample studentInfoExample = new StudentInfoExample();
		studentInfoExample.createCriteria().andStudentNameEqualTo(auditionInfo.getStudentName());
		auditionInfo.setStudentId(studentInfoMapper.selectByExample(studentInfoExample).get(0).getStudentId());
		auditionInfoMapper.insert(auditionInfo);
	}

	@Override
	public List<AuditionInfo> find(String studentName, String auditionCourse) throws Exception {
		System.out.println(studentName);
		System.out.println(auditionCourse);
			List<AuditionInfo> lists = new ArrayList<>();
		StudentInfoExample studentInfoExample = new StudentInfoExample();

			studentInfoExample.createCriteria().andStudentNameLike("%"+studentName+"%");
			List<StudentInfo> list = studentInfoMapper.selectByExample(studentInfoExample);
			
			for (StudentInfo studentInfo : list) {
				AuditionInfoExample aud = new AuditionInfoExample();
				aud.createCriteria().andStudentIdEqualTo(studentInfo.getStudentId());
				List<AuditionInfo> aud_list = auditionInfoMapper.selectByExample(aud);
				
				for (AuditionInfo auditionInfo : aud_list) {
					AuditionInfoExample audexam = new AuditionInfoExample();
					audexam.createCriteria().andAuditionIdEqualTo(auditionInfo.getAuditionId()).andAuditionCourseLike("%"+auditionCourse+"%");
					List<AuditionInfo> list2 = auditionInfoMapper.selectByExample(audexam);
					for (AuditionInfo studentInfo2 : list2) {
						lists.add(studentInfo2);
					}
				}
			}

		for (AuditionInfo auditionInfo : lists) {
			StudentInfo sti = studentInfoMapper.selectByPrimaryKey(auditionInfo.getStudentId());
			auditionInfo.setStudentName(sti.getStudentName());
		}
		
		return lists;
	}

}
