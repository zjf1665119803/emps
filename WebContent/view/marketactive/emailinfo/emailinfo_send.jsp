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
        <li>邮件管理</li>
        <li>发送邮件</li>
    </ul>
</div>

<form action="${pageContext.request.contextPath }/EmailController/sendEmail.action" class="form-horizontal" method="post">

    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">基本信息</h5>
	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">模板</label>
                <div class="col-sm-9">
                	<select name="" class="form-control input-sm">
                	   <c:forEach items="${requestScope.templateInfoList }" var="templateInfo">
                	       <option>${templateInfo.templateType }</option>
                	   </c:forEach>
                	   
                    </select>
                </div>
            </div>
        
        </div>
    </div>
     	<div class="row">
                <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">主题</label>
                <div class="col-sm-9">
                	<input type="text" name="emailTitle" class="form-control input-sm" placeholder="请输入主题"/>
                </div>
            </div>
        </div>
        
        </div>
    	<div class="row">
                <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">接收人</label>
                <div class="col-sm-9">
                	<input type="text" name="emailMan" class="form-control input-sm" placeholder="请输入接收人"/>
                </div>
            </div>
        </div>
        
        </div>
       
    	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">邮件地址</label>
                <div class="col-sm-9">
                	<input type="text" name="emailAddr" class="form-control input-sm"  placeholder="请输入电话号码"/>
                </div>
            </div>
        
        </div>


    </div>
    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">邮件内容信息</h5>
    	<div class="row">
    	<div class="col-sm-10">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">邮件内容</label>
                <div class="col-sm-9">
                	<textarea class="form-control" name="emailContent"></textarea>
                </div>
            </div>
        
        </div>

    </div>
 
   	<div class="row">
    	<div class="col-sm-3 col-sm-offset-4">
        	<input  type="submit" class="btn btn-success" value="发送"/>

              <a class="btn btn-warning" href="emailinfo_list.html">返回上一级</a>
        </div>
    </div>
</form>

</body>
</html>
