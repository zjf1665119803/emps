package com.guigu.service;

import java.util.List;

import com.guigu.pojo.SyllabusInfo;

public interface SyllabusService {

	List<SyllabusInfo> findAllSyllabus() throws Exception;

	List<SyllabusInfo> findByName(String syllabusName) throws Exception;

	boolean addSyllabusInfo(SyllabusInfo syllabusInfo) throws Exception;

	boolean deleteById(int syllabusId) throws Exception;

	SyllabusInfo finById(int syllabusId) throws Exception;

	boolean updateById(SyllabusInfo syllabusInfo) throws Exception;

}
