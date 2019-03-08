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
        <li>模板管理</li>
        <li>修改信息</li>
    </ul>
</div>

<form action="${pageContext.request.contextPath }/TemplateController/updateTemplate.action" class="form-horizontal" method="post">

    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">基本信息</h5>
	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">编号</label>
                <div class="col-sm-9">
                	<input type="text" value="${requestScope.templateInfo.templateId }" name="templateId" readonly="readonly" class="form-control input-sm" placeholder="请输入编号"/>
                </div>
            </div>
        
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">标题</label>
                <div class="col-sm-9">
                	<input type="text" value="${requestScope.templateInfo.templateTitle }" name="templateTitle" class="form-control input-sm" placeholder="请输入标题"/>
                </div>
            </div>
        </div>

    </div>
    	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">类型</label>
                <div class="col-sm-9">
                	<select name="templateType" class="form-control input-sm">
                	    <!--  <option  value="短信模板">短信模板</option>
                   	     <option value="邮件模板">邮件模板</option> -->
                	    <c:if test="${requestScope.templateInfo.templateType == '短信模板'}">
                		    <option selected value="短信模板">短信模板</option>
                   	        <option value="邮件模板">邮件模板</option>
                		  </c:if>
                    	<c:if test="${requestScope.templateInfo.templateType == '邮件模板'}">
                		    <option selected value="邮件模板">邮件模板</option>
                   	        <option value="短信模板">短信模板</option>
                		  </c:if>
                    </select>
                </div>
            </div>
        
        </div>


    </div>
    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">内容信息</h5>
    	<div class="row">
    	<div class="col-sm-10">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">内容信息</label>
                <div class="col-sm-9">
                	<textarea name="templateContent" class="form-control">
                	${requestScope.templateInfo.templateContent }
                	</textarea>
                </div>
            </div>
        
        </div>

    </div>
 
   	<div class="row">
    	<div class="col-sm-3 col-sm-offset-4">
        	<input  type="submit" class="btn btn-success" value="保存"/>
               <a class="btn btn-warning" href="template_list.html">返回上一级</a>
        </div>
    </div>
</form>

</body>
</html>
