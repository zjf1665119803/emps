package com.guigu.service;

import java.util.List;

import com.guigu.pojo.MessafeInfo;
import com.guigu.pojo.TemplateInfo;

public interface TemplateService {

	List<TemplateInfo> findAll() throws Exception;

	List<TemplateInfo> findByTitle(String templateTitle) throws Exception;

	Boolean addTemplate(TemplateInfo templateInfo)throws Exception;

	Boolean deleteTemplateById(int templateId)throws Exception;

	TemplateInfo findById(int templateId)throws Exception;

	Boolean updateTemplate(TemplateInfo templateInfo)throws Exception;

	List<TemplateInfo> findAllEmail()throws Exception;

	List<TemplateInfo> findAllMessage()throws Exception;

}
