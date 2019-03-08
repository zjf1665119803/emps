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
        <li>跟踪记录</li>
    </ul>
</div>
<form class="form-inline">
<div class="row alert alert-info"  style="margin:0px; padding:3px;" >

     <div class="form-group">
         <label class="" for="activename">学员姓名：</label>
        <input type="email" class="form-control" id="activename" placeholder="请输入学员姓名">
      </div>
    <div class="form-group">
         <label class="" for="activename">学员意向：</label>
		 <select id="activetype" name="" class="form-control">
         	<option value="请选择">请选择</option>
         	<option value="意向低">意向低</option>
            <option value="意向高">意向高</option>
         </select>
      </div>
    <input type="button"   class="btn btn-danger"     value="查询"  onClick="find();"/>
    <a  class="btn btn-success"  href="${pageContext.request.contextPath}/TrackRecordController/trackRecordAddUi.action">添加纪录</a>
    
</div>
<div class="row" style="padding:15px; padding-top:0px; ">
	<table class="table  table-condensed table-striped">
    	<tr>
        	<th>编号</th>
            <th>主题</th>
            <th>姓名</th>
            <th>内容</th>
            <th>意向状态</th>
            <th>负责人</th>
            <th>联系时间</th>
            <th>下次联系时间</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${requestScope.trackRecordInfoList}" var ="trackRecordInfo">
        	<tr>
        	<td>${trackRecordInfo.trackRecordId}</td>
            <td>${trackRecordInfo.trackRecordTitle}</td>
            <td>${trackRecordInfo.studentName}</td>
            <td>${trackRecordInfo.trackRecordContent}</td>
            <td>${trackRecordInfo.studentType}</td>
            <td>负责人</td>
            <td>${trackRecordInfo.trackRecordTime}</td>
            <td>${trackRecordInfo.nextRecordTime}</td>
            <th>
            <a href="${pageContext.request.contextPath}/TrackRecordController/trackRecordUpdateUi.action?trackRecordId=${trackRecordInfo.trackRecordId}">修改</a> 
            <a href="javaScript:void(0);" onclick="deleteById(${trackRecordInfo.trackRecordId})">删除</a>
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
		location.href="${pageContext.request.contextPath}/TrackRecordController/trackRecordDelete.action?trackRecordId="+id;
	}else{}
}
function find(){
	var name = $("#activename").val().trim();
	var type = $("#activetype").val();
	location.href="${pageContext.request.contextPath}/TrackRecordController/trackRecordFind.action?studentName="+name+"&studentType="+type;
}
</script>

</html>
