package com.guigu.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.pojo.DisciplineInfo;
import com.guigu.service.DisciplineInfoService;

@RequestMapping("/DisciplineInfoController")
@Controller
public class DisciplineInfoController {
	@Resource
	private DisciplineInfoService disciplineInfoService;
	
		@RequestMapping("/findAllDisciplineInfo.action")	
		public String findAllDisciplineInfo(HttpServletRequest request) throws Exception {
			List<DisciplineInfo> list = disciplineInfoService.findAll();
			request.setAttribute("disciplineInfoList", list);
			return "view/classinfo/disciplineinfo/disciplineinfo_list";
		}
	
		@RequestMapping("/deleteById.action")	
		public String deleteById(int disciplineId,HttpServletRequest request) throws Exception {
			boolean result = disciplineInfoService.deleteById(disciplineId);
			return "redirect:/DisciplineInfoController/findAllDisciplineInfo.action";
		}
		
		@RequestMapping("/findByName.action")
		public String findByName(String disciplineName,HttpServletRequest  request) throws Exception {
			List<DisciplineInfo>  list = disciplineInfoService.findByName(disciplineName);
			request.setAttribute("disciplineInfoList", list);
			return "view/classinfo/disciplineinfo/disciplineinfo_list";
		}
		
		
		@RequestMapping("/addDisciplineInfo.action")
		public String addDisciplineInfo(DisciplineInfo disciplineInfo,HttpServletRequest  request) throws Exception {
			boolean result = disciplineInfoService.addDisciplineInfo(disciplineInfo);
			return "redirect:/DisciplineInfoController/findAllDisciplineInfo.action";
		}
		
		@RequestMapping("/updateUi.action")
		public String updateUi(int disciplineId,HttpServletRequest  request) throws Exception {
			
			DisciplineInfo disciplineInfo = disciplineInfoService.findById(disciplineId);
			request.setAttribute("disciplineInfo", disciplineInfo);
			
			return "view/classinfo/disciplineinfo/disciplineinfo_update";
			
		}
		
		@RequestMapping("/update.action")
		public String update(DisciplineInfo disciplineInfo,HttpServletRequest request) throws Exception {
			boolean result = disciplineInfoService.updateById(disciplineInfo);
			
			return "redirect:/DisciplineInfoController/findAllDisciplineInfo.action";
			
		}
		
}
