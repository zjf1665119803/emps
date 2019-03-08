package com.guigu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.guigu.mapper.StaffInfoMapper;
import com.guigu.mapper.StudentInfoMapper;
import com.guigu.mapper.StudentPaymentMapper;
import com.guigu.pojo.StaffInfo;
import com.guigu.pojo.StudentInfo;
import com.guigu.pojo.StudentPayment;
import com.guigu.pojo.StudentPaymentExample;
import com.guigu.service.FinancialMentService;
import com.guigu.util.JsonUtil;

@Service
public class FinancialMentServiceImpl implements FinancialMentService {
	@Resource
	private StudentPaymentMapper studentPaymentMapper;
	@Resource
	private StaffInfoMapper staffInfoMapper;
	@Resource
	private StudentInfoMapper studentInfoMapper;
	
	private static final  Logger LOGGER = Logger.getLogger(FinancialMentServiceImpl.class);//定义一个静态常量

	@Override
	public List<StudentPayment> findAll() throws Exception {
		List<StudentPayment> list = null;
		
		try {
			list = studentPaymentMapper.selectByExample(new StudentPaymentExample());
			if(!CollectionUtils.isEmpty(list)) {
				list.forEach((studentPayment)->{
					studentPayment.setStudentInfo(studentInfoMapper.selectByPrimaryKey(studentPayment.getStudentId()));
				});
			}
			if(!CollectionUtils.isEmpty(list)) {
				list.forEach((studentPayment)->{
					studentPayment.setStaffInfo(staffInfoMapper.selectByPrimaryKey(studentPayment.getStaffId()));
				});
			}
			LOGGER.info("FinancialMentServiceImpl->findAll,return result:"+JsonUtil.toJson(list));//记录出参
			return list;
		} catch (Exception e) {
			LOGGER.error("FinancialMentServiceImpl->findAll,exception:"+e.getMessage());
			throw e;
		}
	}

	@Override
	public StudentPayment findById(Integer paymentId) throws Exception {
		StudentPayment studentPayment = studentPaymentMapper.selectByPrimaryKey(paymentId);
		
		if(!studentPayment.equals(null)) {
				studentPayment.setStudentInfo(studentInfoMapper.selectByPrimaryKey(studentPayment.getStudentId()));
		}
		if(!studentPayment.equals(null)) {
			
				studentPayment.setStaffInfo(staffInfoMapper.selectByPrimaryKey(studentPayment.getStaffId()));
		}
		
		return studentPayment;
	}

	@Override
	public boolean addPayMent(StudentPayment studentPayment) throws Exception {
		return studentPaymentMapper.insertSelective(studentPayment)>0;
	}

	@Override
	public boolean deleteById(int paymentId) throws Exception {
		return studentPaymentMapper.deleteByPrimaryKey(paymentId)>0;
	}

	

}
