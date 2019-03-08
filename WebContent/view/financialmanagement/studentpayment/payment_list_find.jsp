<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <li>学员缴费</li>
    </ul>
</div>
<div class="row alert alert-info"  style="margin:0px; padding:3px;" >
<form class="form-horizontal">
    </form>
</div>
<div class="row" style="padding:15px; padding-top:0px; ">
	<table class="table  table-condensed table-striped">
    	<tr>
        	<th>缴费单号</th>
            <th>学生姓名</th>
            <th>负责人</th>
        	<th>缴费状态</th>
        	<th>缴费时间</th>
        	<th>缴费方式</th>
        	<th>优惠金额</th>
        	<th>应交金额</th>
        	<th>实交金额</th>
           
        </tr>
          	<tr>
          	<td>${requestScope.studentPayment.paymentId }</td>
            <td>${requestScope.studentPayment.studentInfo.studentName}</td>
            <td>${requestScope.studentPayment.staffInfo.staffName }</td>
        	<td>${requestScope.studentPayment.paymentSituation }</td>
        	<td>${requestScope.studentPayment.paymentTime }</td>
        	<td>${requestScope.studentPayment.paymentMethod }</td>
        	<td>${requestScope.studentPayment.discountAmount }</td>
        	<td>${requestScope.studentPayment.shouldAmount }</td>
        	<td>${requestScope.studentPayment.realAmount }</td>
           
        </tr> 
       	
    </table>
</div>
<script type="text/javascript">
    function findByName(){
    	var name = $("#studentNameId").val();
		location.href="${pageContext.request.contextPath }/FinancialMentController/findByStudentName.action?studentName="+name;
	}
    
    function deleteById(id) {
      	 if(confirm("是否进行删除？")){
      		 location.href="${pageContext.request.contextPath }/EmailController/deleteById.action?emailId="+id;
      	 }
      }
      
    function lookById(id) {
            location.href="${pageContext.request.contextPath }/EmailController/lookById.action?emailId="+id;
         }
    function getTemplate() {
        location.href="${pageContext.request.contextPath }/EmailController/getTemplate.action";
     }
</script>
</body>
</html>
