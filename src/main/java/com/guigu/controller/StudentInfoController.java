package com.guigu.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.pojo.StudentInfo;
import com.guigu.service.StudentInfoService;

@Controller
@RequestMapping("/StudentInfoController")
public class StudentInfoController {
	
	@Resource
	private StudentInfoService studentInfoService;
	
	@RequestMapping("/findAllStudent.action")
	public String findAllStudent(HttpServletRequest request) throws Exception {
		List<StudentInfo> list = studentInfoService.findAll();
		request.setAttribute("studentInfoList", list);
		return "view/recruitstudent/studentpool/studentpool_list";
	}
		
	
		@RequestMapping("/studentInfoUpdateUi.action")
		public String studentInfoUpdateUi(int studentId,HttpServletRequest request) throws Exception {

			StudentInfo studentInfo = studentInfoService.findById(studentId);
			request.setAttribute("studentInfo", studentInfo);
			return "view/recruitstudent/studentpool/studentpool_update";	
	}
		
		@RequestMapping("/studentInfoUpdate.action")
		public String studentInfoUpdate(StudentInfo studentinfo,HttpServletRequest request) throws Exception {
			studentInfoService.updateById(studentinfo);
			return "redirect:/StudentInfoController/findAllStudent.action";	
	}
		
		@RequestMapping("/studentInfoDelete.action")
		public String studentInfoDelete(int studentId,HttpServletRequest request) throws Exception {
			studentInfoService.deleteById(studentId);
			return "redirect:/StudentInfoController/findAllStudent.action";	
	}
		
		@RequestMapping("/studentInfoAdd.action")
		public String studentInfoAdd(StudentInfo studentinfo,HttpServletRequest request) throws Exception {
			studentInfoService.add(studentinfo);
			return "redirect:/StudentInfoController/findAllStudent.action";	
	}
			
		@RequestMapping("/studentFindByName.action")
		public String studentFindByName(String studentName,HttpServletRequest request) throws Exception {
			List<StudentInfo> list = studentInfoService.findByName(studentName);
			request.setAttribute("studentInfoList", list);
			return "view/recruitstudent/studentpool/studentpool_list";	
	}
	
		public StudentInfo findById(int studentId) throws Exception{
			StudentInfo sto = studentInfoService.findById(studentId);
			return sto;
		}
}
