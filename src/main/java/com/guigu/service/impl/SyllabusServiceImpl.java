package com.guigu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.guigu.mapper.SyllabusInfoMapper;
import com.guigu.pojo.SyllabusInfo;
import com.guigu.pojo.SyllabusInfoExample;
import com.guigu.service.SyllabusService;
import com.guigu.util.JsonUtil;

@Service
public class SyllabusServiceImpl implements SyllabusService {
	@Resource
	private SyllabusInfoMapper syllabusInfoMapper;
	private static final Logger LOGGER = Logger.getLogger(SyllabusServiceImpl.class);


	@Override
	public List<SyllabusInfo> findAllSyllabus() throws Exception {
		List<SyllabusInfo> list = null;
		try {
			list = syllabusInfoMapper.selectByExample(new SyllabusInfoExample());
			LOGGER.info("SyllabusServiceImpl->findAllSyllabus,return result:"+JsonUtil.toJson(list));//记录出参
			return list;
		} catch (Exception e) {
			LOGGER.error("SyllabusServiceImpl->findAllSyllabus,exception:"+e.getMessage());
			throw e;
		}
	}


	@Override
	public List<SyllabusInfo> findByName(String syllabusName) throws Exception {
		SyllabusInfoExample example = null;
		try {
			LOGGER.info("SyllabusServiceImpl->findByName,param:"+JsonUtil.toJson(syllabusName));//记录入参
			example = new SyllabusInfoExample();
			example.createCriteria().andSyllabusNameLike("%"+syllabusName+"%");
			return syllabusInfoMapper.selectByExample(example);
		} catch (Exception e) {
			LOGGER.error("SyllabusServiceImpl->findByName,exception:"+e.getMessage());
			throw e;
		}
	}


	@Override
	public boolean addSyllabusInfo(SyllabusInfo syllabusInfo) throws Exception {
		return syllabusInfoMapper.insertSelective(syllabusInfo) > 0;
	}


	@Override
	public boolean deleteById(int syllabusId) throws Exception {
		return syllabusInfoMapper.deleteByPrimaryKey(syllabusId) > 0;
	}


	@Override
	public SyllabusInfo finById(int syllabusId) throws Exception {
		return syllabusInfoMapper.selectByPrimaryKey(syllabusId);
	}


	@Override
	public boolean updateById(SyllabusInfo syllabusInfo) throws Exception {
		return syllabusInfoMapper.updateByPrimaryKeySelective(syllabusInfo) > 0;
	}

}
