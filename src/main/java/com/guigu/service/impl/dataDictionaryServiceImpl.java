package com.guigu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.guigu.mapper.DataDictionaryMapper;
import com.guigu.pojo.DataDictionary;
import com.guigu.pojo.DataDictionaryExample;
import com.guigu.service.DataDictionaryService;
@Service
public class dataDictionaryServiceImpl implements DataDictionaryService {
	@Resource
    private DataDictionaryMapper dataDictionaryMapper;
	
	@Override
	public List<DataDictionary> findByType(String dataType) throws Exception {
		DataDictionaryExample example = new DataDictionaryExample();
		example.createCriteria().andDataTypeLike("%"+dataType+"%");
		return dataDictionaryMapper.selectByExample(example);
	}
	@Override
	public List<DataDictionary> findAll() throws Exception {
		List<DataDictionary> list = dataDictionaryMapper.selectByExample(new DataDictionaryExample());
		return list; 
	}
	@Override
	public Boolean addDataDictionary(DataDictionary dataDictionary) throws Exception {
		return dataDictionaryMapper.insertSelective(dataDictionary) > 0;
	}
	@Override
	public Boolean deleteDataDictionaryById(int dataId) throws Exception {
		return dataDictionaryMapper.deleteByPrimaryKey(dataId)>0;
	}
	@Override
	public DataDictionary findById(int dataId) throws Exception {
		return dataDictionaryMapper.selectByPrimaryKey(dataId);
	}
	@Override
	public Boolean updateDataDictionary(DataDictionary dataDictionary) throws Exception {
		return dataDictionaryMapper.updateByPrimaryKeySelective(dataDictionary) > 0;
	}
}
