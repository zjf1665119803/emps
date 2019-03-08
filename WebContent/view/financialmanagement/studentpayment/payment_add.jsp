<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>首页</title>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.min.css">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
</head>

<body>
<div style="padding:0px; margin:0px;">
 <ul class="breadcrumb" style="  margin:0px; " >
    	<li><a href="#">财务管理</a></li>
        <li>学生缴费</li>
        <li>添加缴费记录</li>
    </ul>
</div>

<form action="${pageContext.request.contextPath }/FinancialMentController/addPayMent.action" class="form-horizontal" method="post">

     <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">缴费信息</h5>
	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">缴费编号</label>
                <div class="col-sm-9">
                	<input type="text" name="paymentId" class="form-control input-sm" readonly="readonly" placeholder="请输入缴费编号"/>
                </div>
            </div>
        
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">缴费状态</label>
                <div class="col-sm-9">
                	<input type="text" name="paymentSituation" class="form-control input-sm" placeholder="请输入缴费状态"/>
                </div>
            </div>
        </div>

    </div>
    	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">优惠金额</label>
                <div class="col-sm-9">
                	<input type="text" name="discountAmount" class="form-control input-sm"  placeholder="请输入优惠金额"/>
                </div>
            </div>
        
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">应缴金额</label>
                <div class="col-sm-9">
                	<input type="text" name="shouldAmount" class="form-control input-sm" placeholder="请输入应缴"/>
                </div>
            </div>
        </div>

    </div>
    
    <div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">实缴金额</label>
                <div class="col-sm-9">
                	<input type="text" name="realAmount" class="form-control input-sm"  placeholder="请输入实缴"/>
                </div>
            </div>
        
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">缴费时间</label>
                <div class="col-sm-9">
                	<input type="text" name="paymentTime" class="form-control input-sm" placeholder="请输入缴费时间"/>
                </div>
            </div>
        </div>

    </div>
    
    <!-- 结束2 -->
    <!-- 开始3 -->
	<div class="row">
 
        <div class="col-sm-5">
            <div class="form-group">
            		<label class="col-sm-3 control-label">学生姓名</label>
                <div class="col-sm-6">
           		 <select class="form-control input-sm" name="studentId">
                		    <c:forEach items="${requestScope.studentPaymentList1 }" var="student">
                		      <option  value="${student.studentId }">${student.studentName }</option>
                		    </c:forEach>
                        </select>
                </div>
            </div>
        </div>
        
        <div class="col-sm-5">
            <div class="form-group">
            		<label class="col-sm-3 control-label">负责人</label>
                <div class="col-sm-6">
           		 <select class="form-control input-sm" name="staffId">
                		    <c:forEach items="${requestScope.studentPaymentList2 }" var="staff">
                		      <option  value="${staff.staffId }">${staff.staffName }</option>
                		    </c:forEach>
                        </select>
                </div>
            </div>
        </div>
    </div>
    <!-- 结束3 -->
   	<div class="row">
    	<div class="col-sm-5 col-sm-offset-4">
          	<input type="submit" class="btn btn-success" value="确认"/>
            <a class="btn btn-warning">返回上一级</a>
          
        </div>
    </div>
</form>

</body>
</html>
    