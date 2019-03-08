package com.guigu.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.pojo.ClassroomInfo;
import com.guigu.service.ClassroomService;

@RequestMapping("/ClassroomInfoController")
@Controller
public class ClassroomInfoController {
	@Resource
	private ClassroomService classroomService;
	@RequestMapping("/classroomInfoList.action")
	public String findAllClassroomInfo(HttpServletRequest request) throws Exception {
		List<ClassroomInfo> list = classroomService.findAllClassroom();
		request.setAttribute("classroomInfoList", list);
		return "/view/classinfo/classroominfo/classroominfo_list";
	}
	
	@RequestMapping("/findByName.action")
	public String findByname(String classroomName,HttpServletRequest request) throws Exception {
		List<ClassroomInfo> list = classroomService.findByName(classroomName);
		request.setAttribute("classroomInfoList", list);
		return "/view/classinfo/classroominfo/classroominfo_list";
	}
	
	@RequestMapping("/addClassroomInfo.action")
	public String addClassroomInfo(ClassroomInfo classroomInfo,HttpServletRequest request) throws Exception {
		boolean result = classroomService.addClassroomInfo(classroomInfo);
		return "redirect:/ClassroomInfoController/classroomInfoList.action";
	}
	
	@RequestMapping("/deleteById.action")	
	public String deleteById(int classroomId,HttpServletRequest request) throws Exception {
		boolean result = classroomService.deleteById(classroomId);
		return "redirect:/ClassroomInfoController/classroomInfoList.action";
	}
	
	@RequestMapping("updateUi.action")
	public String updateUi(int classroomId,HttpServletRequest request) throws Exception {
		ClassroomInfo classroomInfo = classroomService.findById(classroomId);
		request.setAttribute("classroomInfo", classroomInfo);
		return "/view/classinfo/classroominfo/classroominfo_update";
	}
	
	@RequestMapping("/update.action")
	public String update(ClassroomInfo classroomInfo,HttpServletRequest request) throws Exception {
		boolean result = classroomService.updateById(classroomInfo);
		return "redirect:/ClassroomInfoController/classroomInfoList.action";
		
	}
}

















