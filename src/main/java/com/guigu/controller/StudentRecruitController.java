package com.guigu.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.pojo.StudentInfo;
import com.guigu.service.StudentInfoService;
import com.guigu.service.StudentRecruitService;

@Controller
@RequestMapping("/StudentRecruitController")
public class StudentRecruitController {
	
	@Resource
	private StudentRecruitService studentRecruitService;
	
	private Logger logger = Logger.getLogger(StudentRecruitController.class);
	
	private static final String CLASS_NAME = "StudentRecruitController";
	
	@RequestMapping("/findAllStudent.action")
	public String findAllStudent(HttpServletRequest request)  {
		try {
			List<StudentInfo> list = studentRecruitService.findAll();
			System.out.println(list);
			request.setAttribute("studentInfoList", list);
		} catch (Exception e) {
			StringBuilder sb = new StringBuilder(CLASS_NAME);
			sb.append(e.getMessage());
			logger.info(sb);
		}
		return "view/recruitstudent/recruitstudent/recruitstudent_list";
	}
		
	
		@RequestMapping("/studentRecruitUpdateUi.action")
		public String studentInfoUpdateUi(int studentId,HttpServletRequest request)  {

			try {
				StudentInfo studentInfo = studentRecruitService.findById(studentId);
				request.setAttribute("studentInfo", studentInfo);
			} catch (Exception e) {
				StringBuilder sb = new StringBuilder(CLASS_NAME);
				sb.append("studentId=");sb.append(studentId);
				sb.append(e.getMessage());
				logger.info(sb);
			}
			return "view/recruitstudent/recruitstudent/recruitstudent_update";	
	}
		
		@RequestMapping("/studentRecruitUpdate.action")
		public String studentInfoUpdate(StudentInfo studentinfo,HttpServletRequest request)  {
			try {
				studentRecruitService.updateById(studentinfo);
			} catch (Exception e) {
				StringBuilder sb = new StringBuilder(CLASS_NAME);
				sb.append(studentinfo);
				sb.append(e.getMessage());
				logger.info(sb);
			}
			return "redirect:/StudentRecruitController/findAllStudent.action";	
	}
		
		@RequestMapping("/studentRecruitDelete.action")
		public String studentInfoDelete(int studentId,HttpServletRequest request)  {
			try {
				studentRecruitService.deleteById(studentId);
			} catch (Exception e) {
				StringBuilder sb = new StringBuilder(CLASS_NAME);
				sb.append("studentId");sb.append(studentId);
				sb.append(e.getMessage());
				logger.info(sb);
			}
			return "redirect:/StudentRecruitController/findAllStudent.action";	
	}
		
		@RequestMapping("/studentRecruitAdd.action")
		public String studentInfoAdd(StudentInfo studentinfo,HttpServletRequest request)  {
			studentinfo.setStudentMark("1");
			try {
				studentRecruitService.add(studentinfo);
			} catch (Exception e) {
				StringBuilder sb = new StringBuilder(CLASS_NAME);
				sb.append(studentinfo);
				sb.append(e.getMessage());
				logger.info(sb);
			}
			return "redirect:/StudentRecruitController/findAllStudent.action";	
	}
			
		@RequestMapping("/studentFindBy.action")
		public String studentFindByName(String studentName,String studentType,HttpServletRequest request) {

			try {
				List<StudentInfo> list = studentRecruitService.findBy(studentName,studentType);
				request.setAttribute("studentInfoList", list);
			} catch (Exception e) {
				StringBuilder sb = new StringBuilder(CLASS_NAME);
				sb.append("studentName");sb.append(studentName);
				sb.append("studentType");sb.append(studentType);
				sb.append(e.getMessage());
				sb.append(e.getMessage());
				logger.info(sb);
			}
			return "view/recruitstudent/recruitstudent/recruitstudent_list";	
	}
		

}
