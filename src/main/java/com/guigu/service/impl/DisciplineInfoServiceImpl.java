package com.guigu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.guigu.mapper.DisciplineInfoMapper;
import com.guigu.pojo.DisciplineInfo;
import com.guigu.pojo.DisciplineInfoExample;
import com.guigu.service.DisciplineInfoService;
import com.guigu.util.JsonUtil;

@Service
public class DisciplineInfoServiceImpl implements DisciplineInfoService {
	@Resource
	private DisciplineInfoMapper disciplineInfoMapper;
	private static final Logger LOGGER = Logger.getLogger(DisciplineInfoServiceImpl.class);

	@Override
	public List<DisciplineInfo> findAll() throws Exception {
		List<DisciplineInfo> list = null;
		try {
			list = disciplineInfoMapper.selectByExample(new DisciplineInfoExample());
			LOGGER.info("DisciplineInfoServiceImpl->findAll,return result:"+JsonUtil.toJson(list));//记录出参
			return list;
		} catch (Exception e) {
			LOGGER.error("DisciplineInfoServiceImpl->findAll,exception:"+e.getMessage());
			throw e;
		}
	}

	@Override
	public boolean deleteById(int disciplineId) throws Exception {
		
		return disciplineInfoMapper.deleteByPrimaryKey(disciplineId) >0;
	}

	@Override
	public List<DisciplineInfo> findByName(String disciplineName) throws Exception {
		DisciplineInfoExample disciplineInfoExample = new DisciplineInfoExample();
		disciplineInfoExample.createCriteria().andDisciplineNameLike("%"+disciplineName+"%");
		
		return disciplineInfoMapper.selectByExample(disciplineInfoExample);
	}

	@Override
	public boolean addDisciplineInfo(DisciplineInfo disciplineInfo) throws Exception {
		
		return disciplineInfoMapper.insertSelective(disciplineInfo) > 0;
	}

	@Override
	public DisciplineInfo findById(int disciplineId) throws Exception {
		return disciplineInfoMapper.selectByPrimaryKey(disciplineId);
	}

	@Override
	public boolean updateById(DisciplineInfo disciplineInfo) throws Exception {
		return disciplineInfoMapper.updateByPrimaryKeySelective(disciplineInfo) > 0;
	}

}
