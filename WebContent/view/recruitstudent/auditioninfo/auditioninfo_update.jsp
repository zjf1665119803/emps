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
         <li>修改记录</li>
    </ul>
</div>

<form action="${pageContext.request.contextPath}/AuditionInfoController/auditionInfoUpdate.action" class="form-horizontal">

    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">基本信息</h5>
	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">编号</label>
                <div class="col-sm-9">
                	<input type="text" value="${requestScope.auditionInfo.auditionId}" name="auditionId" class="form-control input-sm" placeholder="请输入编号" readonly="readonly"/>
                </div>
            </div>
        
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">试听课程</label>
                <div class="col-sm-9">
                	<input type="text" value="${requestScope.auditionInfo.auditionCourse}" name="auditionCourse" class="form-control input-sm" placeholder="请输入试听课程"/>
                </div>
            </div>
        </div>

    </div>
    	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">试听学员</label>
                <div class="col-sm-9">
                	<select name="studentName" class="form-control input-sm">
                    <c:forEach items="${requestScope.studentInfoList}" var="studentInfo">
                		<option value = "${studentInfo.studentName}">${studentInfo.studentName}</option>
                	</c:forEach>
                    </select>
                </div>
            </div>
        </div>
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">试听时间</label>
                <div class="col-sm-9">
               		 <input type="text" value="${requestScope.auditionInfo.auditionTime}" name="auditionTime" class="form-control input-sm" placeholder="请输入试听时间"/>
                </div>
            </div>
        
        </div>

    </div>
       	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">试听地点</label>
                <div class="col-sm-9">
               		 <input type="text" value="${requestScope.auditionInfo.auditionAddr}" name="auditionAddr" class="form-control input-sm" placeholder="请输入试听地点"/>
                </div>
            </div>
        
        </div>

    </div>
    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">描述</h5>
    	<div class="row">
    	<div class="col-sm-10">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">描述</label>
                <div class="col-sm-9">
                	<textarea name="auditionDesc" class="form-control">
                	${requestScope.auditionInfo.auditionDesc}
                	</textarea>
                </div>
            </div>
        
        </div>

    </div>
 
   	<div class="row">
    	<div class="col-sm-3 col-sm-offset-4">
        	<input  type="submit" class="btn btn-success" value="保存"/>

              <a class="btn btn-warning" href="${pageContext.request.contextPath}AuditionInfoController/findAllAudition.action">返回上一级</a>
        </div>
    </div>
</form>

</body>
</html>
