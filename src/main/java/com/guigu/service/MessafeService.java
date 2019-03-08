package com.guigu.service;

import java.util.List;

import com.guigu.pojo.MessafeInfo;

public interface MessafeService {

	List<MessafeInfo> findAll() throws Exception;

	List<MessafeInfo> findByPhone(String messafePhone)throws Exception;

	Boolean deleteMessafeById(int messafeId)throws Exception;

	MessafeInfo lookById(int messafeId)throws Exception;

	Boolean sendMessge(MessafeInfo messafeInfo)throws Exception;

}
