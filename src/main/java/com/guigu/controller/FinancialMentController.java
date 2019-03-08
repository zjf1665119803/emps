package com.guigu.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.pojo.StaffInfo;
import com.guigu.pojo.StudentInfo;
import com.guigu.pojo.StudentPayment;
import com.guigu.service.FinancialMentService;
import com.guigu.service.StaffInfoService;
import com.guigu.service.StudentInfoService;


@RequestMapping("/FinancialMentController")
@Controller
public class FinancialMentController {
		@Resource
		private FinancialMentService financialMentService;
		@Resource
		private StudentInfoService studentInfoService;
		@Resource
		private StaffInfoService staffInfoService;
		
		@RequestMapping("/findAll.action")
		public String findAll(HttpServletRequest request) throws Exception {
			
				List<StudentPayment> list = financialMentService.findAll();
				request.setAttribute("studentPaymentList",list );
				return "/view/financialmanagement/studentpayment/payment_list";
			
		}
		
		@RequestMapping("/findByStudentName.action")
		public String findByStudentName(String studentName,HttpServletRequest request) throws Exception {
			List<StudentInfo> list = studentInfoService.findByName(studentName);
			StudentPayment studentPayment =null;
			//List<StudentPayment> listStudentPayment=null;
			for (StudentInfo studentInfo : list) {
				studentPayment = financialMentService.findById(studentInfo.getStudentId());
				System.out.println(studentPayment);
				//listStudentPayment.add(studentPayment);
			}
			request.setAttribute("studentPayment",studentPayment );
			return "/view/financialmanagement/studentpayment/payment_list_find";
		}
		
		@RequestMapping("/getStudentAndStaff.action")
		public String getStudentAndStaff(HttpServletRequest request) throws Exception {
			
				List<StudentInfo> list1 = studentInfoService.findAll();
				request.setAttribute("studentPaymentList1",list1 );
				List<StaffInfo> list2 = staffInfoService.findAll();
				request.setAttribute("studentPaymentList2",list2 );
				return "/view/financialmanagement/studentpayment/payment_add";
			
		}
		
		@RequestMapping("/addPayMent.action")
		public String addPayMent(StudentPayment studentPayment,HttpServletRequest request) throws Exception {
			System.out.println(studentPayment);
			boolean result = financialMentService.addPayMent(studentPayment);
			return "redirect:/FinancialMentController/findAll.action";
			
		}
		
		
		@RequestMapping("/deleteById.action")
		public String deleteById(int paymentId,HttpServletRequest request) throws Exception {
			boolean result = financialMentService.deleteById(paymentId);
			return "redirect:/FinancialMentController/findAll.action";
			
		}
		
}










