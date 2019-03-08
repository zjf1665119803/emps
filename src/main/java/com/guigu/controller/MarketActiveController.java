package com.guigu.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.pojo.MarketActive;
import com.guigu.pojo.RoleInfo;
import com.guigu.pojo.StaffInfo;
import com.guigu.pojo.TemplateInfo;
import com.guigu.service.MarketActiveService;
import com.guigu.service.TemplateService;

@Controller
@RequestMapping("/MarketActiveController")
public class MarketActiveController {

	@Resource
	private  MarketActiveService  marketActiveService;
	@RequestMapping("/listMarketActive.action")
    public String listMarketActive(HttpServletRequest request) throws Exception {
		List<MarketActive> list = marketActiveService.findAll();
		request.setAttribute("marketActiveList", list);
		return "view/marketactive/marketactive/marketactive_list";
      }
	@RequestMapping("/deleteById.action")
    public String deleteById(int activeId , HttpServletRequest request) throws Exception {
		Boolean result = marketActiveService.deleteById(activeId);
		return "redirect:/MarketActiveController/listMarketActive.action";
      }
	
	@RequestMapping("/findByMethod.action")
	public String findByMethod(String activeName,Integer activeState ,HttpServletRequest  request) throws Exception {
		List<MarketActive>  list = marketActiveService.findByNameAndState(activeName,activeState);
		request.setAttribute("marketActiveList", list);
		return "view/marketactive/marketactive/marketactive_list";
	}
	
	@RequestMapping("/addMarketActive.action")
    public String addMarketActive(MarketActive marketActive , HttpServletRequest request) throws Exception {
		Boolean result = marketActiveService.addMarketActive(marketActive);
		return "redirect:/MarketActiveController/listMarketActive.action";
      }
	

	@RequestMapping("/updateUi.action")
	public String updateUi(int  activeId,HttpServletRequest  request) throws Exception {
		MarketActive marketActive = marketActiveService.findById(activeId);
		request.setAttribute("marketActive", marketActive);
		return "view/marketactive/marketactive/marketactive_update";
		
	}
	
	@RequestMapping("/update.action")
    public String update(MarketActive  marketActive , HttpServletRequest request) throws Exception {
		Boolean result = marketActiveService.update(marketActive);
		return "redirect:/MarketActiveController/listMarketActive.action";
      }
}
