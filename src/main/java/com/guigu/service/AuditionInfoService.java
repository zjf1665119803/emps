package com.guigu.service;

import java.util.List;

import com.guigu.pojo.AuditionInfo;
import com.guigu.pojo.TrackRecordInfo;

public interface AuditionInfoService {

	List<AuditionInfo> findAll() throws Exception;

	AuditionInfo findById(int auditionId) throws Exception;

	void updateById(AuditionInfo auditionInfo) throws Exception;

	void deleteById(int auditionId) throws Exception;

	void add(AuditionInfo AuditionInfo) throws Exception;

	List<AuditionInfo> find(String studentName, String auditionCourse) throws Exception;

}
