package com.guigu.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.pojo.StaffInfo;
import com.guigu.pojo.TemplateInfo;
import com.guigu.service.TemplateService;
import com.mchange.v2.async.StrandedTaskReporting;

/**
 * 模板Controller
 * @author ZJF
 *
 */
@Controller
@RequestMapping("/TemplateController")
public class TemplateController {
	
	@Resource
	private  TemplateService  templateService;
	@RequestMapping("/listTemplate.action")
    public String listTemplate(HttpServletRequest request) throws Exception {
		List<TemplateInfo> list = templateService.findAll();
		request.setAttribute("templateList", list);
		return "view/marketactive/template/template_list";
      }
	
	@RequestMapping("/findByTitle.action")
    public String findByTitle(String templateTitle,HttpServletRequest request) throws Exception {
		List<TemplateInfo> list = templateService.findByTitle(templateTitle);
		request.setAttribute("templateList", list);
		return "view/marketactive/template/template_list";
      }
	
	
	@RequestMapping("/addTemplate.action")
    public String addTemplate(TemplateInfo templateInfo,HttpServletRequest request) throws Exception {
		Boolean result = templateService.addTemplate(templateInfo);
		return "redirect:/TemplateController/listTemplate.action";
      }
	
	@RequestMapping("/deleteTemplateById.action")
    public String deleteTemplateById(int templateId,HttpServletRequest request) throws Exception {
		Boolean result = templateService.deleteTemplateById(templateId);
		return "redirect:/TemplateController/listTemplate.action";
      }
	
	@RequestMapping("/updateTemplateUi.action")
	public String updateTemplateUi(int templateId,HttpServletRequest  request) throws Exception {
		TemplateInfo templateInfo = templateService.findById(templateId);
		request.setAttribute("templateInfo", templateInfo);
		return "view/marketactive/template/template_update";
	}
	
	
	@RequestMapping("/updateTemplate.action")
    public String updateTemplate(TemplateInfo templateInfo,HttpServletRequest request) throws Exception {
		Boolean result = templateService.updateTemplate(templateInfo);
		return "redirect:/TemplateController/listTemplate.action";
      }
}
