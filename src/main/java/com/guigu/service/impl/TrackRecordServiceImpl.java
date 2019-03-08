package com.guigu.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.guigu.mapper.StudentInfoMapper;
import com.guigu.mapper.TrackRecordInfoMapper;
import com.guigu.pojo.StudentInfo;
import com.guigu.pojo.StudentInfoExample;
import com.guigu.pojo.TrackRecordInfo;
import com.guigu.pojo.TrackRecordInfoExample;
import com.guigu.service.TrackRecordService;

@Service
public class TrackRecordServiceImpl implements TrackRecordService {
	
	@Resource
	private TrackRecordInfoMapper trackRecordInfoMapper;
	
	@Resource
	private StudentInfoMapper studentInfoMapper;

	@Override
	public List<TrackRecordInfo> findAll() {
		List<TrackRecordInfo> list = trackRecordInfoMapper.selectByExample(new TrackRecordInfoExample());
		for (TrackRecordInfo trackRecordInfo : list) {
			StudentInfo sti = studentInfoMapper.selectByPrimaryKey(trackRecordInfo.getStudentId());
			trackRecordInfo.setStudentName(sti.getStudentName());
			trackRecordInfo.setStudentType(sti.getStudentType());
		}
		return list;
	}

	@Override
	public TrackRecordInfo findById(int trackRecordId) {
		TrackRecordInfo tri = trackRecordInfoMapper.selectByPrimaryKey(trackRecordId);
		StudentInfo sti = studentInfoMapper.selectByPrimaryKey(tri.getStudentId());
		tri.setStudentName(sti.getStudentName());
		tri.setStudentType(sti.getStudentType());
		return tri;
	}

	@Override
	public void updateById(TrackRecordInfo trackRecordInfo) throws Exception {
		StudentInfoExample studentInfoExample = new StudentInfoExample();
		studentInfoExample.createCriteria().andStudentNameEqualTo(trackRecordInfo.getStudentName());
		trackRecordInfo.setStudentId(studentInfoMapper.selectByExample(studentInfoExample).get(0).getStudentId());
		trackRecordInfoMapper.updateByPrimaryKey(trackRecordInfo);
		
	}

	@Override
	public void deleteById(int trackRecordId) {
		trackRecordInfoMapper.deleteByPrimaryKey(trackRecordId);
	}

	@Override
	public void add(TrackRecordInfo trackRecordInfo) throws Exception {
		StudentInfoExample studentInfoExample = new StudentInfoExample();
		studentInfoExample.createCriteria().andStudentNameEqualTo(trackRecordInfo.getStudentName());
		trackRecordInfo.setStudentId(studentInfoMapper.selectByExample(studentInfoExample).get(0).getStudentId());
		trackRecordInfoMapper.insert(trackRecordInfo);
	}

	@Override
	public List<TrackRecordInfo> find(String studentName, String studentType) throws Exception {
		StudentInfoExample studentInfoExample = new StudentInfoExample();
		if(studentType.equals("请选择")) {
			studentInfoExample.createCriteria().andStudentNameLike("%"+studentName+"%");
		}else {
			studentInfoExample.createCriteria().andStudentNameLike("%"+studentName+"%").andStudentTypeEqualTo(studentType);
		}
		
		List<StudentInfo> list = studentInfoMapper.selectByExample(studentInfoExample);
		List<TrackRecordInfo> lists = new ArrayList<>();
		for (StudentInfo studentInfo : list) {
			TrackRecordInfoExample tre = new TrackRecordInfoExample();
			tre.createCriteria().andStudentIdEqualTo(studentInfo.getStudentId());
			if(trackRecordInfoMapper.selectByExample(tre).size() > 0 ) {
				for (int i=0;i<trackRecordInfoMapper.selectByExample(tre).size();i++) {
					lists.add(trackRecordInfoMapper.selectByExample(tre).get(i));
				}
			}
			
		}
		for (TrackRecordInfo trackRecordInfo : lists) {
			StudentInfo sti = studentInfoMapper.selectByPrimaryKey(trackRecordInfo.getStudentId());
			trackRecordInfo.setStudentName(sti.getStudentName());
			trackRecordInfo.setStudentType(sti.getStudentType());
		}
		
		return lists;
	}



}
