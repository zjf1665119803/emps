<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <li>短信管理</li>
    </ul>
</div>
<div class="row alert alert-info"  style="margin:0px; padding:3px;" >
<form class="form-horizontal">
	<div class="col-sm-2">电话号码:</div>
    <div class="col-sm-3">
    	<input type="text" id="phoneId" class="form-control input-sm"/>
    </div>
    <input type="button"   class="btn btn-danger"  onclick="findByPhone();"    value="查询"/>
    <input type="button"   class="btn btn-danger"  onclick="getTemplate();"    value="发送短信"/>
    </form>
</div>
<div class="row" style="padding:15px; padding-top:0px; ">
	<table class="table  table-condensed table-striped">
    	<tr>
        	<th>编号</th>
            <th>发送人</th>
            <th>短信内容</th>
            <th>发送时间</th>
            <th>接收人</th>
            <th>接收号码</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${requestScope.messafeList }" var="messafe">
        <tr>
        	<td>${messafe.messafeId }</td>
            <td>${messafe.staffInfo.staffName }</td>
            <td >${messafe.messafeContent }</td>
            <td>${messafe.messafeTime }</td>
            <td>${messafe.messafeMan }</td>
            <td>${messafe.messafePhone }</td>
            <th>
            <a onclick="lookById(${messafe.messafeId });" href="javaScript:void(0);">查看</a> 
            <a  href="javaScript:void(0);" onclick="deleteById(${messafe.messafeId })">删除</a>
            </th>
        </tr>
        </c:forEach>
    </table>
</div>

</body>

<script type="text/javascript">
    function findByPhone() {
		var phone = $("#phoneId").val();
		location.href="${pageContext.request.contextPath}/MessafeController/findByPhone.action?messafePhone="+phone;
	}
    
    function deleteById(id) {
   	 if(confirm("是否进行删除？")){
   		 location.href="${pageContext.request.contextPath }/MessafeController/deleteMessafeById.action?messafeId="+id;
   	 }
   }
    function findById(staffId) {
    	location.href="${pageContext.request.contextPath }/MessafeController/findStaffById.action?staffId="+staffId;
	}
    function lookById(id) {
        location.href="${pageContext.request.contextPath }/MessafeController/lookById.action?messafeId="+id;
     }
    function getTemplate() {
        location.href="${pageContext.request.contextPath }/MessafeController/getTemplate.action";
     }
</script>
</html>
    