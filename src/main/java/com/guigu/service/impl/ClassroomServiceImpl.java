package com.guigu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.guigu.mapper.ClassroomInfoMapper;
import com.guigu.pojo.ClassroomInfo;
import com.guigu.pojo.ClassroomInfoExample;
import com.guigu.service.ClassroomService;
import com.guigu.util.JsonUtil;

@Service
public class ClassroomServiceImpl implements ClassroomService {
	@Resource
	private ClassroomInfoMapper classroomInfoMapper;
	private static final Logger LOGGER = Logger.getLogger(ClassroomServiceImpl.class);

	@Override
	public List<ClassroomInfo> findAllClassroom() throws Exception {
		List<ClassroomInfo> list = null;
		
		try {
			list = classroomInfoMapper.selectByExample(new ClassroomInfoExample());
			LOGGER.info("ClassroomServiceImpl->findAllClassroom,return result:"+JsonUtil.toJson(list));//记录出参
			return list;
		} catch (Exception e) {
			LOGGER.error("ClassroomServiceImpl->findAllClassroom,exception:"+e.getMessage());
			throw e;
		}
	}

	@Override
	public List<ClassroomInfo> findByName(String classroomName) throws Exception {
		try {
			LOGGER.info("ClassroomServiceImpl->findByName,param:"+JsonUtil.toJson(classroomName));//记录入参
			ClassroomInfoExample example = new ClassroomInfoExample();
			example.createCriteria().andClassroomNameLike("%"+classroomName+"%");
			return classroomInfoMapper.selectByExample(example);
		} catch (Exception e) {
			LOGGER.error("ClassroomServiceImpl->findByName,exception:"+e.getMessage());
			throw e;
		}
	}

	@Override
	public boolean addClassroomInfo(ClassroomInfo classroomInfo) throws Exception {
		return classroomInfoMapper.insertSelective(classroomInfo) > 0;
	}

	@Override
	public boolean deleteById(int classroomId) throws Exception {
		return classroomInfoMapper.deleteByPrimaryKey(classroomId) > 0;
	}

	@Override
	public ClassroomInfo findById(int classroomId) throws Exception {
		return classroomInfoMapper.selectByPrimaryKey(classroomId);
	}

	@Override
	public boolean updateById(ClassroomInfo classroomInfo) throws Exception {
		return classroomInfoMapper.updateByPrimaryKeySelective(classroomInfo) > 0;
	}

}
