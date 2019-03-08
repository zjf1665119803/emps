package com.guigu.service;

import java.util.List;

import com.guigu.pojo.StudentPayment;

public interface FinancialMentService {

	List<StudentPayment> findAll() throws Exception;

	StudentPayment findById(Integer staffId)throws Exception;

	boolean addPayMent(StudentPayment studentPayment)throws Exception;

	boolean deleteById(int paymentId)throws Exception;


}
