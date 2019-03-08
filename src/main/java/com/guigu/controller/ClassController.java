package com.guigu.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.pojo.ClassInfo;
import com.guigu.pojo.ClassroomInfo;
import com.guigu.pojo.DisciplineInfo;
import com.guigu.pojo.StaffInfo;
import com.guigu.pojo.SyllabusInfo;
import com.guigu.service.ClassInfoService;
import com.guigu.service.ClassroomService;
import com.guigu.service.DisciplineInfoService;
import com.guigu.service.StaffInfoService;
import com.guigu.service.SyllabusService;

@RequestMapping("/ClassController")
@Controller
public class ClassController {
	@Resource
	private ClassInfoService classInfoService;
	@Resource
	private StaffInfoService staffInfoService;
	@Resource
	private DisciplineInfoService disciplineInfoService;
	@Resource
	private ClassroomService classroomService;
	@Resource
	private SyllabusService syllabusService;
	
	@RequestMapping("/findAllClass.action")
	public String findAllClass(HttpServletRequest request) throws Exception {
		List<ClassInfo> list = classInfoService.findAllClass();
		request.setAttribute("classInfoList", list);
		return "/view/classinfo/classinfo/classinfo_list";
	}
	
	@RequestMapping("/findByName.action")
	public String findByname(String className,HttpServletRequest request) throws Exception {
		List<ClassInfo> list = classInfoService.findByName(className);
		request.setAttribute("classInfoList", list);
		return "/view/classinfo/classinfo/classinfo_list";
	}
	
	@RequestMapping("/addBefore.action")
	public String getOption(HttpServletRequest request) throws Exception {
		List<StaffInfo> staffInfoList = staffInfoService.findAll();
		List<DisciplineInfo> disciplineInfoList = disciplineInfoService.findAll();
		List<ClassroomInfo> classroomInfoList = classroomService.findAllClassroom();
		List<SyllabusInfo> syllabusInfoList = syllabusService.findAllSyllabus();
		request.setAttribute("staffInfoList", staffInfoList);
		request.setAttribute("disciplineInfoList", disciplineInfoList);
		request.setAttribute("classroomInfoList", classroomInfoList);
		request.setAttribute("syllabusInfoList", syllabusInfoList);
		return "view/classinfo/classinfo/classinfo_add";
	}
	
	@RequestMapping("/addClass.action")
	public String addClass(ClassInfo classInfo,HttpServletRequest request) throws Exception {
		boolean result = classInfoService.addClassInfo(classInfo);
		return "redirect:/ClassController/findAllClass.action";
	}
	
	@RequestMapping("/deleteById.action")
	public String deleteById(int classId,HttpServletRequest request) throws Exception {
		boolean result = classInfoService.deleteById(classId);
		return "redirect:/ClassController/findAllClass.action";
	}
	
	@RequestMapping("updateUi.action")
	public String updateUi(int classId,HttpServletRequest request) throws Exception {
		
		ClassInfo classInfo = classInfoService.findById(classId);
		List<StaffInfo> staffInfoList = staffInfoService.findAll();
		List<DisciplineInfo> disciplineInfoList = disciplineInfoService.findAll();
		List<ClassroomInfo> classroomInfoList = classroomService.findAllClassroom();
		List<SyllabusInfo> syllabusInfoList = syllabusService.findAllSyllabus();
		request.setAttribute("staffInfoList", staffInfoList);
		request.setAttribute("disciplineInfoList", disciplineInfoList);
		request.setAttribute("classroomInfoList", classroomInfoList);
		request.setAttribute("syllabusInfoList", syllabusInfoList);
		request.setAttribute("classInfo", classInfo);
		
		return "/view/classinfo/classinfo/classinfo_update";
	}
	
	@RequestMapping("/update.action")
	public String update(ClassInfo classInfo,HttpServletRequest request) throws Exception {
		boolean result = classInfoService.updateById(classInfo);
		return "redirect:/ClassController/findAllClass.action";
	}
	
}










