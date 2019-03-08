<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>首页</title>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</head>

<body>
<div style="padding:0px; margin:0px;">
 <ul class="breadcrumb" style="  margin:0px; " >
    	<li><a href="#">招生管理</a></li>
        <li>试听记录</li>
    </ul>
</div>
<form class="form-inline">
<div class="row alert alert-info"  style="margin:0px; padding:3px;" >

     <div class="form-group">
         <label class="" for="activename">学员姓名：</label>
        <input type="email" class="form-control" id="activename" placeholder="请输入学员姓名">
      </div>
    <div class="form-group">
         <label class="" for="activename">试听课程：</label>
		   <input type="email" class="form-control" id="activename1" placeholder="请输入试听课程">	
      </div>
    <input type="button"   class="btn btn-danger"     value="查询"  onClick="find();"/>
    <a  class="btn btn-success"  href="${pageContext.request.contextPath}/AuditionInfoController/auditionInfoAddUi.action">添加纪录</a>
    
</div>
<div class="row" style="padding:15px; padding-top:0px; ">
	<table class="table  table-condensed table-striped">
    	<tr>
        	<th>编号</th>
            <th>姓名</th>
            <th>试听课程</th>
            <th>试听时间</th>
            <th>地点</th>
            <th>操作</th>
        </tr>
         <c:forEach items="${requestScope.auditionInfoList}" var ="auditionInfo">
        	<tr>
        	<td>${auditionInfo.auditionId}</td>
            <td>${auditionInfo.studentName}</td>
            <td>${auditionInfo.auditionCourse}</td>
            <td>${auditionInfo.auditionTime}</td>
            <td>${auditionInfo.auditionAddr}</td>
            <th>
            <a href="${pageContext.request.contextPath}/AuditionInfoController/auditionInfoUpdateUi.action?auditionId=${auditionInfo.auditionId}">修改</a> 
            <a href="javaScript:void(0);" onclick="deleteById(${auditionInfo.auditionId})">删除</a>
            </th>
        </tr>
        </c:forEach>
     	                   
    </table>
</div>
</form>
</body>
<script type="text/javascript">
function deleteById(id){
	if(confirm("是否删除？")){
		location.href="${pageContext.request.contextPath}/AuditionInfoController/auditionInfoDelete.action?auditionId="+id;
	}else{}
}
function find(){
	var name = $("#activename").val().trim();
	var course = $("#activename1").val().trim();
	location.href="${pageContext.request.contextPath}/AuditionInfoController/auditionInfoFind.action?studentName="+name+"&auditionCourse="+course;
	
}
</script>
</html>
