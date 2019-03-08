package com.guigu.service;

import java.util.List;

import com.guigu.pojo.ClassInfo;

public interface ClassInfoService {

	List<ClassInfo> findAllClass() throws Exception;

	List<ClassInfo> findByName(String className) throws Exception;

	boolean addClassInfo(ClassInfo classInfo) throws Exception ;

	boolean deleteById(int classId) throws Exception;

	ClassInfo findById(int classId) throws Exception;

	boolean updateById(ClassInfo classInfo) throws Exception;

}
