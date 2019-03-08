package com.guigu.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.pojo.EmailInfo;
import com.guigu.pojo.MessafeInfo;
import com.guigu.pojo.RoleInfo;
import com.guigu.pojo.StaffInfo;
import com.guigu.pojo.TemplateInfo;
import com.guigu.service.EmailService;
import com.guigu.service.TemplateService;

@Controller
@RequestMapping("/EmailController")
public class EmailController {
	
	@Resource
	private  EmailService  emailService;
	
	@Resource
	private TemplateService templateService;
	@RequestMapping("/listEmail.action")
    public String listEmail(HttpServletRequest request) throws Exception {
		List<EmailInfo> list = emailService.findAll();
		request.setAttribute("emailList", list);
		return "view/marketactive/emailinfo/emailinfo_list";
      }
	
	@RequestMapping("/findByTitle.action")
    public String findByTitle(String emailTitle, HttpServletRequest request) throws Exception {
		System.out.println(emailTitle);
		List<EmailInfo> list = emailService.findByTitle(emailTitle);
		request.setAttribute("emailList", list);
		return "view/marketactive/emailinfo/emailinfo_list";
      }
	@RequestMapping("/deleteById.action")
    public String deleteById(int emailId , HttpServletRequest request) throws Exception {
		Boolean result = emailService.deleteById(emailId);
		return "redirect:/EmailController/listEmail.action";
      }
	
	@RequestMapping("/lookById.action")
	public String lookById(int  emailId, HttpServletRequest  request) throws Exception {
		
		EmailInfo  emailInfo = emailService.lookById(emailId);
		request.setAttribute("emailInfo",emailInfo);
		return "view/marketactive/emailinfo/emailInfo_show";
	}
	
	
	@RequestMapping("/sendEmail.action")
    public String sendEmail(EmailInfo email ,HttpServletRequest request) throws Exception {
		Boolean result = emailService.sendEmail(email);
		return "redirect:/EmailController/listEmail.action";
      }
	
	@RequestMapping("/getTemplate.action")
	public String getTemplate(HttpServletRequest  request) throws Exception {
		List<TemplateInfo>  templateInfoList = templateService.findAllEmail();
		request.setAttribute("templateInfoList", templateInfoList);
		return "view/marketactive/emailinfo/emailinfo_send";
	}
}