package com.guigu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.guigu.mapper.EmailInfoMapper;
import com.guigu.mapper.StaffInfoMapper;
import com.guigu.pojo.EmailInfo;
import com.guigu.pojo.EmailInfoExample;
import com.guigu.pojo.MessafeInfo;
import com.guigu.pojo.MessafeInfoExample;
import com.guigu.pojo.TemplateInfo;
import com.guigu.pojo.TemplateInfoExample;
import com.guigu.service.EmailService;
@Service
public class EmailServiceImpl implements EmailService {
	
	    @Resource
	    private EmailInfoMapper emailInfoMapper;
	    
	    @Resource
		private StaffInfoMapper staffInfoMapper;
	    
		@Override
		public List<EmailInfo> findAll() throws Exception {
			List<EmailInfo> list = emailInfoMapper.selectByExample(new EmailInfoExample());
			if(!CollectionUtils.isEmpty(list)) {
				list.forEach((email)->{
					email.setStaffInfo(staffInfoMapper.selectByPrimaryKey(email.getStaffId()));
				});
			}
			return list;
			
	}

		
		
		@Override
		public List<EmailInfo> findByTitle(String emailTitle) throws Exception {
			EmailInfoExample example = new EmailInfoExample();
			example.createCriteria().andEmailTitleLike("%"+emailTitle+"%");
			return emailInfoMapper.selectByExample(example);
		}
		@Override
		public Boolean deleteById(int emailId) throws Exception {
			return emailInfoMapper.deleteByPrimaryKey(emailId)>0;
		}
		@Override
		public EmailInfo lookById(int emailId) throws Exception {
			EmailInfo emailInfo = emailInfoMapper.selectByPrimaryKey(emailId);
			if(!emailInfo.equals(null)) {
				emailInfo.setStaffInfo(staffInfoMapper.selectByPrimaryKey(emailInfo.getStaffId()));
			}
			return emailInfo;
		}



		@Override
		public Boolean sendEmail(EmailInfo email) throws Exception {
			return emailInfoMapper.insertSelective(email)>0;
		}
	}
