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
	<div class="col-sm-2">学员姓名</div>
    <div class="col-sm-3">
    	<input type="text" id="studentNameId" class="form-control input-sm"/>
    </div>
    <input type="button"   class="btn btn-danger" onclick="findByName();"    value="查询"/>
    <input type="button"   class="btn btn-success"   value="添加缴费记录" onClick="getStudentAndStaff();"/>
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
        	<th>优惠金额</th>
        	<th>应交金额</th>
        	<th>实交金额</th>
            <th>操作</th>
        </tr>
        <c:forEach  items="${requestScope.studentPaymentList }" var="studentPayment">
          	<tr>
          	<td>${studentPayment.paymentId }</td>
            <td>${studentPayment.studentInfo.studentName}</td>
            <td>${studentPayment.staffInfo.staffName }</td>
        	<td>${studentPayment.paymentSituation }</td>
        	<td>${studentPayment.paymentTime }</td>
        	<td>${studentPayment.discountAmount }</td>
        	<td>${studentPayment.shouldAmount }</td>
        	<td>${studentPayment.realAmount }</td>
            <th> 
           <a href="javaScript:void(0);"  onclick="deleteById(${studentPayment.paymentId });">删除</a></th>
        </tr>
        </c:forEach>
       	
    </table>
</div>
<script type="text/javascript">
    function findByName(){
    	var name = $("#studentNameId").val();
		location.href="${pageContext.request.contextPath }/FinancialMentController/findByStudentName.action?studentName="+name;
	}
    
    function deleteById(id) {
      	 if(confirm("是否进行删除？")){
      		 location.href="${pageContext.request.contextPath }/FinancialMentController/deleteById.action?paymentId="+id;
      	 }
      }
      
    function lookById(id) {
            location.href="${pageContext.request.contextPath }/EmailController/lookById.action?emailId="+id;
         }
    function getStudentAndStaff() {
        location.href="${pageContext.request.contextPath }/FinancialMentController/getStudentAndStaff.action";
     }
</script>
</body>
</html>
