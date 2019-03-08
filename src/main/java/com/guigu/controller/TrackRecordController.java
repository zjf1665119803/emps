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
import org.springframework.web.bind.annotation.RequestParam;

import com.guigu.pojo.StudentInfo;
import com.guigu.pojo.TrackRecordInfo;
import com.guigu.service.StudentInfoService;
import com.guigu.service.TrackRecordService;

@Controller
@RequestMapping("/TrackRecordController")
public class TrackRecordController {
	
	@Resource
	private TrackRecordService trackRecordService;
	
	@Resource
	private StudentInfoService studentInfoService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	//dateFormat.parse(source)
	dateFormat.setLenient(true);
	binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat,true));
	}


	
	@RequestMapping("/findAllTrack.action")
	public String findAllTrack(HttpServletRequest request) throws Exception {
		List<TrackRecordInfo> list = trackRecordService.findAll();
		request.setAttribute("trackRecordInfoList", list);
		return "view/recruitstudent/trackrecord/trackrecord_list";
	}
		
	
		@RequestMapping("/trackRecordUpdateUi.action")
		public String trackRecordUpdateUi(int trackRecordId,HttpServletRequest request) throws Exception {
			List<StudentInfo> list = studentInfoService.findAll();
			request.setAttribute("studentInfoList", list);
			TrackRecordInfo trackRecordInfo = trackRecordService.findById(trackRecordId);
			request.setAttribute("trackRecordInfo", trackRecordInfo);
			return "view/recruitstudent/trackrecord/trackrecord_update";	
	}
		
		@RequestMapping("/trackRecordUpdate.action")
		public String trackRecordUpdate(TrackRecordInfo trackRecordInfo,HttpServletRequest request) throws Exception {
			trackRecordService.updateById(trackRecordInfo);
			return "redirect:/TrackRecordController/findAllTrack.action";	
	}
		
		@RequestMapping("/trackRecordDelete.action")
		public String trackRecordDelete(int trackRecordId,HttpServletRequest request) throws Exception {
			trackRecordService.deleteById(trackRecordId);
			return "redirect:/TrackRecordController/findAllTrack.action";	
	}
		
		@RequestMapping("/trackRecordAdd.action")
		public String trackRecordAdd(TrackRecordInfo trackRecordInfo,HttpServletRequest request) throws Exception {
			trackRecordService.add(trackRecordInfo);
			return "redirect:/TrackRecordController/findAllTrack.action";	
	}
		
		@RequestMapping("/trackRecordAddUi.action")
		public String trackRecordAddUi(HttpServletRequest request) throws Exception {
			List<StudentInfo> list = studentInfoService.findAll();
			request.setAttribute("studentInfoList", list);
			return "view/recruitstudent/trackrecord/trackrecord_add";
	}
		
		@RequestMapping("/trackRecordFind.action")
		public String trackRecordFind(String studentName,String studentType,HttpServletRequest request) throws Exception {
			List<TrackRecordInfo> list = trackRecordService.find(studentName,studentType);
			request.setAttribute("trackRecordInfoList", list);
			return "view/recruitstudent/trackrecord/trackrecord_list";
	}

}
