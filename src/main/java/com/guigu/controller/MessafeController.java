package com.guigu.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.pojo.AnthortyInfo;
import com.guigu.pojo.EmailInfo;
import com.guigu.pojo.MessafeInfo;
import com.guigu.pojo.StaffInfo;
import com.guigu.pojo.TemplateInfo;
import com.guigu.service.MessafeService;
import com.guigu.service.StaffInfoService;
import com.guigu.service.TemplateService;
@Controller
@RequestMapping("/MessafeController")
public class MessafeController {
	@Resource
	private TemplateService templateService;
	@Resource
	private  MessafeService  messafeService;
	@Resource
	private StaffInfoService staffInfoService;
	@RequestMapping("/listMessafe.action")
    public String listMessafe(HttpServletRequest request) throws Exception {
		List<MessafeInfo> list = messafeService.findAll();
		request.setAttribute("messafeList", list);
		return "view/marketactive/messafeinfo/messafeinfo_list";
      }
	@RequestMapping("/findByPhone.action")
    public String findByPhone(String messafePhone , HttpServletRequest request) throws Exception {
		List<MessafeInfo> list = messafeService.findByPhone(messafePhone);
		request.setAttribute("messafeList", list);
		return "view/marketactive/messafeinfo/messafeinfo_list";
      }
	
	@RequestMapping("/deleteMessafeById.action")
    public String deleteMessafeById(int messafeId , HttpServletRequest request) throws Exception {
		Boolean result = messafeService.deleteMessafeById(messafeId);
		return "redirect:/MessafeController/listMessafe.action";
      }
	
	@RequestMapping("/findStaffById.action")
    public String findStaffById(int staffId , HttpServletRequest request) throws Exception {
		StaffInfo  staffInfo = staffInfoService.findById(staffId);
		System.out.println(staffInfo);
		request.setAttribute("staffInfo",staffInfo);
		return "view/marketactive/messafeinfo/messafeinfo_list";
      }
	
	@RequestMapping("/lookById.action")
	public String lookById(int  messafeId, HttpServletRequest  request) throws Exception {
		MessafeInfo  messafeInfo = messafeService.lookById(messafeId);
		request.setAttribute("messafeInfo",messafeInfo);
		return "view/marketactive/messafeinfo/messafeinfo_show";
	}
	
	@RequestMapping("/getTemplate.action")
	public String getTemplate(HttpServletRequest  request) throws Exception {
		List<TemplateInfo>  templateInfoList = templateService.findAllMessage();
		request.setAttribute("templateInfoList", templateInfoList);
		return "view/marketactive/messafeinfo/messafeinfo_send";
	}
	
	@RequestMapping("/sendMessge.action")
    public String sendMessge(MessafeInfo messafeInfo,HttpServletRequest request) throws Exception {
		Boolean result = messafeService.sendMessge(messafeInfo);
		return "redirect:/MessafeController/listMessafe.action";
      }
}
