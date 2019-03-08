package com.guigu.service;

import java.util.List;

import com.guigu.pojo.DataDictionary;

public interface DataDictionaryService {

	List<DataDictionary> findByType(String dataType) throws Exception;

	List<DataDictionary> findAll()throws Exception ;

	Boolean addDataDictionary(DataDictionary dataDictionary)throws Exception;

	Boolean deleteDataDictionaryById(int dataId)throws Exception;

	DataDictionary findById(int dataId)throws Exception;

	Boolean updateDataDictionary(DataDictionary dataDictionary)throws Exception;

}
