package com.guigu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.guigu.mapper.TemplateInfoMapper;
import com.guigu.pojo.TemplateInfo;
import com.guigu.pojo.TemplateInfoExample;
import com.guigu.service.TemplateService;
@Service
public class TemplateServiceImpl  implements TemplateService{
    @Resource
    private TemplateInfoMapper templateInfoMapper;
	@Override
	public List<TemplateInfo> findAll() throws Exception {
		return templateInfoMapper.selectByExample(new TemplateInfoExample());
	}
	@Override
	public List<TemplateInfo> findByTitle(String templateTitle) throws Exception {
		TemplateInfoExample example = new TemplateInfoExample();
		example.createCriteria().andTemplateTitleLike("%"+templateTitle+"%");
		return templateInfoMapper.selectByExample(example);
	}
	@Override
	public Boolean addTemplate(TemplateInfo templateInfo) throws Exception {
		return templateInfoMapper.insertSelective(templateInfo)>0;
	}
    @Override
	public Boolean deleteTemplateById(int templateId) throws Exception {
		return templateInfoMapper.deleteByPrimaryKey(templateId)>0;
	}
	@Override
	public TemplateInfo findById(int templateId) throws Exception {
		return templateInfoMapper.selectByPrimaryKey(templateId);
	}
	@Override
	public Boolean updateTemplate(TemplateInfo templateInfo) throws Exception {
		return templateInfoMapper.updateByPrimaryKeySelective(templateInfo)>0;
	}
	@Override
	public List<TemplateInfo> findAllEmail() throws Exception {
		TemplateInfoExample example = new TemplateInfoExample();
		example.createCriteria().andTemplateTypeLike("%邮件%");
		return templateInfoMapper.selectByExample(example);
	}
	@Override
	public List<TemplateInfo> findAllMessage() throws Exception {
		TemplateInfoExample example = new TemplateInfoExample();
		example.createCriteria().andTemplateTypeLike("%短信%");
		return templateInfoMapper.selectByExample(example);
	}
}
