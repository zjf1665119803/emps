package com.guigu.service;

import java.util.List;

import com.guigu.pojo.StudentInfo;
import com.guigu.pojo.TrackRecordInfo;

public interface TrackRecordService {

	List<TrackRecordInfo> findAll() throws Exception;

	TrackRecordInfo findById(int trackRecordId) throws Exception;

	void updateById(TrackRecordInfo trackRecordInfo) throws Exception;

	void deleteById(int trackRecordId) throws Exception;

	void add(TrackRecordInfo trackRecordInfo) throws Exception;

	List<TrackRecordInfo> find(String studentName, String studentType) throws Exception;

	

}
