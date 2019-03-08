<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    	<li><a href="#">营销管理</a></li>
        <li>短信管理</li>
        <li>查看信息</li>
    </ul>
</div>

<form action="" class="form-horizontal">

    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">基本信息</h5>
	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">发送人</label>
                <div class="col-sm-9">
                	<p class="form-control-static">${messafeInfo.staffInfo.staffName }</p>
                </div>
            </div>
        </div>
        <div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">发送时间</label>
                <div class="col-sm-9">
                	<p class="form-control-static">${messafeInfo.messafeTime }</p>
                </div>
            </div>
        </div>
    </div>
    
    	<div class="row">
                <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">接收人</label>
                <div class="col-sm-9">
                	<p class="form-control-static">${messafeInfo.messafeMan }</p>
                </div>
            </div>
        </div>
        
        </div>
    
    	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">电话号码</label>
                <div class="col-sm-9">
                	<p class="form-control-static">${messafeInfo.messafePhone }</p>
                </div>
            </div>
        
        </div>


    </div>
    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">短信内容信息</h5>
    	<div class="row">
    	<div class="col-sm-10">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">短信内容</label>
                <div class="col-sm-9">
                	<p class="form-control-static">${messafeInfo.messafeContent }</p>
                </div>
            </div>
        
        </div>

    </div>
 
   	<div class="row">
    	<div class="col-sm-3 col-sm-offset-4">
   

              <a class="btn btn-warning" href="messafeinfo_list.html">返回上一级</a>
        </div>
    </div>
</form>

</body>
</html>
