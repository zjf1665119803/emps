package com.guigu.service;

import java.util.List;

import com.guigu.pojo.DisciplineInfo;


public interface DisciplineInfoService {

	List<DisciplineInfo> findAll() throws Exception;

	boolean deleteById(int disciplineId) throws Exception;

	List<DisciplineInfo> findByName(String disciplineName) throws Exception;

	boolean addDisciplineInfo(DisciplineInfo disciplineInfo) throws Exception;

	DisciplineInfo findById(int disciplineId) throws Exception;

	boolean updateById(DisciplineInfo disciplineInfo) throws Exception;

}
