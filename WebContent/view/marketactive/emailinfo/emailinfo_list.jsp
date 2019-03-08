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
    	<li><a href="#">营销管理</a></li>
        <li>邮件管理</li>
    </ul>
</div>
<div class="row alert alert-info"  style="margin:0px; padding:3px;" >
<form class="form-horizontal">
	<div class="col-sm-2">主题:</div>
    <div class="col-sm-3">
    	<input type="text" id="titleId" class="form-control input-sm"/>
    </div>
    <input type="button"   class="btn btn-danger" onclick="findByTitle();"    value="查询"/>
    <input type="button"   class="btn btn-success"   value="发送邮件" onClick="getTemplate();"/>
    </form>
</div>
<div class="row" style="padding:15px; padding-top:0px; ">
	<table class="table  table-condensed table-striped">
    	<tr>
        	<th>编号</th>
            <th>主题</th>
            <th>发送人</th>
            <th>发送时间</th>
            <th>接收人</th>
            <th>接收地址</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${requestScope.emailList }" var="email">
        <tr>
        	<td>${email.emailId }</td>
            <td>${email.emailTitle }</td>
            <td >${email.staffInfo.staffName }</td>  <!-- 发送人 -->
            <td>${email.emailTime }</td>
            <td>${email.emailMan }</td>
            <td>${email.emailAddr }</td>
            <th>
            <a onclick="lookById(${email.emailId });" href="javaScript:void(0);">查看</a> 
            <a  href="javaScript:void(0);" onclick="deleteById(${email.emailId })">删除</a>
        </tr>
        </c:forEach>
       	
    </table>
</div>
<script type="text/javascript">
    function findByTitle(){
    	var title = $("#titleId").val();
		location.href="${pageContext.request.contextPath }/EmailController/findByTitle.action?emailTitle="+title;
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
