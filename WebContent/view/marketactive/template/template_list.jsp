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
        <li>短信邮件模板</li>
    </ul>
</div>
<div class="row alert alert-info"  style="margin:0px; padding:3px;" >
<form class="form-horizontal">
	<div class="col-sm-2">标题:</div>
    <div class="col-sm-3">
    	<input type="text" id="titleId" class="form-control input-sm"/>
    </div>
    <input type="button"   class="btn btn-danger"  onclick="findByTitle();"  value="查询"/>
   <input type="button"   class="btn btn-danger"  onclick="javascript:window.location = '${pageContext.request.contextPath}/view/marketactive/template/template_add.jsp'"  value="添加模板"/>
    </form>
</div>
<div class="row" style="padding:15px; padding-top:0px; ">
	<table class="table  table-condensed table-striped">
    	<tr>
        	<th>编号</th>
            <th>标题</th>
            <th>内容</th>
            <th>类别</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${requestScope.templateList }" var="template">
        <tr>
        	<td>${template.templateId }</td>
            <td>${template.templateTitle }</td>
            <td>${template.templateContent }</td>
            <td>${template.templateType }</td>
            <th>
            <a  href="${pageContext.request.contextPath }/TemplateController/updateTemplateUi.action?templateId=${template.templateId }">修改</a>
            <a  href="javaScript:void(0);" onclick="deleteById(${template.templateId })">删除</a>
            </th>
        </tr>
        </c:forEach>
       	
    </table>
</div>

</body>
<script type="text/javascript">
    function findByTitle(){
    	var title = $("#titleId").val();
		location.href="${pageContext.request.contextPath }/TemplateController/findByTitle.action?templateTitle="+title;
	}
    
    function deleteById(id) {
   	 if(confirm("是否进行删除？")){
   		 location.href="${pageContext.request.contextPath }/TemplateController/deleteTemplateById.action?templateId="+id;
   	 }
   }
</script>
</html>
