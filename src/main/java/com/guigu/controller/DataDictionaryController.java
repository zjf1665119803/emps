package com.guigu.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.ser.std.StdArraySerializers.BooleanArraySerializer;
import com.guigu.pojo.DataDictionary;
import com.guigu.pojo.StaffInfo;
import com.guigu.pojo.TemplateInfo;
import com.guigu.service.DataDictionaryService;
import com.guigu.service.TemplateService;

/**
 * 数据字典Controller
 * @author ZJF
 *
 */
@Controller
@RequestMapping("/DataDictionaryController")
public class DataDictionaryController {
	@Resource
	private  DataDictionaryService  dataDictionaryService;
	
	@RequestMapping("/listDataDictionary.action")
    public String listDataDictionary(HttpServletRequest request) throws Exception {
		List<DataDictionary> list = dataDictionaryService.findAll();
		request.setAttribute("dataDictionaryList", list);
		return "view/system/datadictionary/datadictionary_list";
      }
	
	@RequestMapping("/findByType.action")
	public String findByType(String dataType,HttpServletRequest request) throws Exception {
		List<DataDictionary> list = dataDictionaryService.findByType(dataType);
		request.setAttribute("dataDictionaryList", list);
		return "view/system/datadictionary/datadictionary_list";
	}
	
	
	@RequestMapping("/addDataDictionary.action")
	public String addDataDictionary(DataDictionary dataDictionary,HttpServletRequest request) throws Exception {
		Boolean result = dataDictionaryService.addDataDictionary(dataDictionary);
		return "redirect:/DataDictionaryController/listDataDictionary.action";
	}
	
	@RequestMapping("/deleteDataDictionaryById.action")
	public String deleteDataDictionaryById(int dataId,HttpServletRequest request) throws Exception {
		Boolean result = dataDictionaryService.deleteDataDictionaryById(dataId);
		return "redirect:/DataDictionaryController/listDataDictionary.action";
	}
	
	@RequestMapping("/updateDataDictionaryUi.action")
	public String updateDataDictionaryUi(int dataId,HttpServletRequest request) throws Exception {
		DataDictionary  dataDictionary = dataDictionaryService.findById(dataId);
		request.setAttribute("dataDictionary", dataDictionary);
		return "view/system/datadictionary/datadictionary_update";
	}
	
	
	@RequestMapping("/updateDataDictionary.action")
	public String updateDataDictionary(DataDictionary dataDictionary,HttpServletRequest request) throws Exception {
		Boolean result = dataDictionaryService.updateDataDictionary(dataDictionary);
		return "redirect:/DataDictionaryController/listDataDictionary.action";
	}
}






