package com.guigu.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.pojo.StaffInfo;
import com.guigu.service.StaffInfoService;
import com.guigu.util.JsonUtil;

@RequestMapping("/TeacherController")
@Controller
public class TeacherController {

	@Resource
	private StaffInfoService  staffInfoService;
	
	private static final  Logger LOGGER = Logger.getLogger(TeacherController.class);//定义一个静态常量
	
	@RequestMapping("/findAllTeacher.action")
	public String findAllTeacher(HttpServletRequest  request) throws Exception {
		List<StaffInfo> list = null;
		try {
			list = staffInfoService.findAll();
			LOGGER.info("TeacherController->findAllTeacher,return result:"+JsonUtil.toJson(list));
			request.setAttribute("staffInfoList", list);
			return "/view/classinfo/teacher/teacher_list";
		} catch (Exception e) {
			LOGGER.error("TeacherController->findAllTeacher,exception:"+e.getMessage());
			throw e;
		}
	}
	
	
	@RequestMapping("/teacherAdd.action")
	public String teacherAdd(StaffInfo staffInfo,HttpServletRequest  request) throws Exception {
		try {
			LOGGER.info("TeacherController->teacherAdd,param:"+JsonUtil.toJson(staffInfo));
			boolean  result = staffInfoService.add(staffInfo);
			return "redirect:/TeacherController/findAllTeacher.action";
		} catch (Exception e) {
			LOGGER.error("TeacherController->teacherAdd,exception:"+e.getMessage());
			throw e;
		}
	}
	
	@RequestMapping("/teacherUpdateUi.action")
	public String teacherUpdateUi(int staffId,HttpServletRequest  request) throws Exception {
		try {
			LOGGER.info("TeacherController->teacherUpdateUi,param:"+JsonUtil.toJson(staffId));
			StaffInfo  staffInfo = staffInfoService.findById(staffId);
			LOGGER.info("TeacherController->teacherUpdateUi,return result:"+JsonUtil.toJson(staffInfo));
			request.setAttribute("staffInfo", staffInfo);
			return "/view/classinfo/teacher/teacher_update";
		} catch (Exception e) {
			LOGGER.error("TeacherController->teacherUpdateUi,exception:"+e.getMessage());
			throw e;
		}
	}
	
	@RequestMapping("/teacherUpdate.action")
	public String teacherUpdate(StaffInfo staffInfo,HttpServletRequest  request) throws Exception {
		try {
			boolean  result = staffInfoService.updateById(staffInfo);
			return "redirect:/TeacherController/findAllTeacher.action";
		} catch (Exception e) {
			LOGGER.error("TeacherController->teacherUpdate,exception:"+e.getMessage());
			throw e;
		}
	}
	
}
