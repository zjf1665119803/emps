package com.guigu.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.pojo.SyllabusInfo;
import com.guigu.service.SyllabusService;

@RequestMapping("/SyllabusContronller")
@Controller
public class SyllabusContronller {
	@Resource 
	private SyllabusService syllabusService;
	
	@RequestMapping("/findAllSyllabus.action")
	public String findAllSyllabus(HttpServletRequest request) throws Exception {
		List<SyllabusInfo> list = syllabusService.findAllSyllabus();
		request.setAttribute("syllabusInfoList", list);
		return "/view/classinfo/syllabusinfo/syllabusinfo_list";
	}
	
	@RequestMapping("/findByName.action")
	public String findByName(String syllabusName,HttpServletRequest request) throws Exception {
		List<SyllabusInfo> list = syllabusService.findByName(syllabusName);
		request.setAttribute("syllabusInfoList", list);
		return "/view/classinfo/syllabusinfo/syllabusinfo_list";
	}
	
	@RequestMapping("/addSyllabusInfo.action")
	public String addSyllabusInfo(SyllabusInfo syllabusInfo,HttpServletRequest request) throws Exception {
		boolean result = syllabusService.addSyllabusInfo(syllabusInfo);
		return "redirect:/SyllabusContronller/findAllSyllabus.action";
	}
	
	@RequestMapping("/deleteById.action")
	public String deleteById(int syllabusId,HttpServletRequest request) throws Exception{
		boolean result = syllabusService.deleteById(syllabusId);
		return "redirect:/SyllabusContronller/findAllSyllabus.action";
	}
	
	@RequestMapping("/updateUi.action")
	public String updateUi(int syllabusId,HttpServletRequest request) throws Exception {
		SyllabusInfo syllabusInfo = syllabusService.finById(syllabusId);
		request.setAttribute("syllabusInfo", syllabusInfo);
		return "/view/classinfo/syllabusinfo/syllabusinfo_update";
		
	}
	
	@RequestMapping("/update.action")
	public String update(SyllabusInfo syllabusInfo,HttpServletRequest request) throws Exception {
		boolean result = syllabusService.updateById(syllabusInfo);
		return "redirect:/SyllabusContronller/findAllSyllabus.action";
	}
	
}











