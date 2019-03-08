package com.guigu.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.pojo.AuditionInfo;
import com.guigu.pojo.StudentInfo;
import com.guigu.service.AuditionInfoService;
import com.guigu.service.StudentInfoService;

@Controller
@RequestMapping("/AuditionInfoController")
public class AuditionInfoController {
	
	@Resource
	private AuditionInfoService auditionInfoService;
	
	@Resource
	private StudentInfoService studentInfoService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	//dateFormat.parse(source)
	dateFormat.setLenient(true);
	binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat,true));
	}
	
	@RequestMapping("/findAllAudition.action")
	public String findAllAudition(HttpServletRequest request) throws Exception {
		List<AuditionInfo> list = auditionInfoService.findAll();
		request.setAttribute("auditionInfoList", list);
		return "view/recruitstudent/auditioninfo/auditioninfo_list";
	}
	      
		
	
		@RequestMapping("/auditionInfoUpdateUi.action")
		public String auditionInfoUpdateUi(int auditionId,HttpServletRequest request) throws Exception {
			List<StudentInfo> list = studentInfoService.findAll();
			request.setAttribute("studentInfoList", list);
			AuditionInfo auditionInfo = auditionInfoService.findById(auditionId);
			request.setAttribute("auditionInfo", auditionInfo);
			return "view/recruitstudent/auditioninfo/auditioninfo_update";	
	}
		
		@RequestMapping("/auditionInfoUpdate.action")
		public String auditionInfoUpdate(AuditionInfo auditionInfo,HttpServletRequest request) throws Exception {
			auditionInfoService.updateById(auditionInfo);
			return "redirect:/AuditionInfoController/findAllAudition.action";	
	}
		
		@RequestMapping("/auditionInfoDelete.action")
		public String auditionInfoDelete(int auditionId,HttpServletRequest request) throws Exception {
			auditionInfoService.deleteById(auditionId);
			return "redirect:/AuditionInfoController/findAllAudition.action";	
	}
		
		@RequestMapping("/auditionInfoAdd.action")
		public String auditionInfoAdd(AuditionInfo auditionInfo,HttpServletRequest request) throws Exception {
			auditionInfoService.add(auditionInfo);
			return "redirect:/AuditionInfoController/findAllAudition.action";	
	}
		
		@RequestMapping("/auditionInfoAddUi.action")
		public String auditionInfoAddUi(HttpServletRequest request) throws Exception {
			List<StudentInfo> list = studentInfoService.findAll();
			request.setAttribute("studentInfoList", list);
			return "view/recruitstudent/auditioninfo/auditioninfo_add";
	}
		          
		
		@RequestMapping("/auditionInfoFind.action")
		public String auditionInfoFind(String studentName,String auditionCourse,HttpServletRequest request) throws Exception {
			List<AuditionInfo> list = auditionInfoService.find(studentName,auditionCourse);
			request.setAttribute("auditionInfoList", list);
			return "view/recruitstudent/auditioninfo/auditioninfo_list";
	}

}
