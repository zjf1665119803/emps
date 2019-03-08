package com.guigu.service;

import java.util.List;

import com.guigu.pojo.ClassroomInfo;

public interface ClassroomService {

	List<ClassroomInfo> findAllClassroom() throws Exception;

	List<ClassroomInfo> findByName(String classroomName) throws Exception;

	boolean addClassroomInfo(ClassroomInfo classroomInfo) throws Exception;

	boolean deleteById(int classroomId) throws Exception;

	ClassroomInfo findById(int classroomId) throws Exception;

	boolean updateById(ClassroomInfo classroomInfo) throws Exception;

}
