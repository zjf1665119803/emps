package com.guigu.service;

import java.util.List;

import com.guigu.pojo.EmailInfo;

public interface EmailService {

	List<EmailInfo> findAll() throws Exception;

	List<EmailInfo> findByTitle(String emailTitle)throws Exception;

	Boolean deleteById(int emailId) throws Exception;

	EmailInfo lookById(int emailId) throws Exception;

	Boolean sendEmail(EmailInfo email)throws Exception;

}
