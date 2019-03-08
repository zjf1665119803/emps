package com.guigu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import com.guigu.mapper.ClassInfoMapper;
import com.guigu.pojo.ClassInfo;
import com.guigu.pojo.ClassInfoExample;
import com.guigu.service.ClassInfoService;
import com.guigu.util.JsonUtil;

@Service
public class ClassInfoServiceImpl implements ClassInfoService {
	@Resource
	private ClassInfoMapper classInfoMapper;
	private static final Logger LOGGER = Logger.getLogger(ClassInfoServiceImpl.class);

	@Override
	public List<ClassInfo> findAllClass() throws Exception {
		List<ClassInfo> list =null;
		try {
			list = classInfoMapper.selectByExample(new ClassInfoExample());
			LOGGER.info("ClassInfoServiceImpl->findAllClass,return result:"+JsonUtil.toJson(list));//记录出参
			return list;
		} catch (Exception e) {
			LOGGER.error("ClassInfoServiceImpl->findAllClass,exception:"+e.getMessage());
			throw e;
		}
	}

	@Override
	public List<ClassInfo> findByName(String className) throws Exception {
		try {
			LOGGER.info("ClassInfoServiceImpl->findByName,param:"+JsonUtil.toJson(className));//记录入参
			ClassInfoExample example = new ClassInfoExample();
			example.createCriteria().andClassNameLike("%"+className+"%");
			return classInfoMapper.selectByExample(example);
		} catch (Exception e) {
			LOGGER.error("ClassInfoServiceImpl->findByName,exception:"+e.getMessage());
			throw e;
		}
	}

	@Override
	public boolean addClassInfo(ClassInfo classInfo) throws Exception {
		try {
			LOGGER.info("ClassInfoServiceImpl->addClassInfo,param:"+JsonUtil.toJson(classInfo));//记录入参	
			return classInfoMapper.insertSelective(classInfo) > 0;
		} catch (Exception e) {
			LOGGER.error("ClassInfoServiceImpl->addClassInfo,exception:"+e.getMessage());
			throw e;
		}
	}

	@Override
	public boolean deleteById(int classId) throws Exception {
		try {
			LOGGER.info("ClassInfoServiceImpl->deleteById,param:"+JsonUtil.toJson(classId));//记录入参	
			return classInfoMapper.deleteByPrimaryKey(classId) > 0;
		} catch (Exception e) {
			LOGGER.error("ClassInfoServiceImpl->deleteById,exception:"+e.getMessage());
			throw e;
		}
	}

	@Override
	public ClassInfo findById(int classId) throws Exception {
		try {
			LOGGER.info("ClassInfoServiceImpl->updateById,param:"+JsonUtil.toJson(classId));//记录入参	
			return classInfoMapper.selectByPrimaryKey(classId);
		} catch (Exception e) {
			LOGGER.error("ClassInfoServiceImpl->findById,exception:"+e.getMessage());
			throw e;
		}
	}

	@Override
	public boolean updateById(ClassInfo classInfo) throws Exception {
		try {
			LOGGER.info("ClassInfoServiceImpl->updateById,param:"+JsonUtil.toJson(classInfo));//记录入参	
			return classInfoMapper.updateByPrimaryKeySelective(classInfo) > 0;
		} catch (Exception e) {
			LOGGER.error("ClassInfoServiceImpl->updateById,exception:"+e.getMessage());
			throw e;
		}
	}

}
