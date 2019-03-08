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
    	<li><a href="#">系统管理</a></li>
        <li>数据字典</li>
    </ul>
</div>
<div class="row alert alert-info"  style="margin:0px; padding:3px;" >
<form class="form-horizontal">
	<div class="col-sm-2">类型:</div>
    <div class="col-sm-3">
    	<input type="text" id="typeId" class="form-control input-sm"/>
    </div>
    <input type="button"   class="btn btn-danger"  onclick="findByType();"  value="查询"/>
    <input type="button"   class="btn btn-danger"  onClick="javascript:window.location='${pageContext.request.contextPath }/view/system/datadictionary/datadictionary_add.jsp'"  value="添加"/>
    </form>
</div>
<div class="row" style="padding:15px; padding-top:0px; ">
	<table class="table  table-condensed table-striped">
    	<tr>
        	<th>编号</th>
            <th>名称</th>
            <th>类型</th>
            <th>描述</th>
            <th>操作</th>
        </tr>
        <c:forEach  items="${requestScope.dataDictionaryList }" var="dataDictionaryInfo">
        	<tr>
        	<td>${dataDictionaryInfo.dataId }</td>
            <td>${dataDictionaryInfo.dataContent }</td>
            <td>${dataDictionaryInfo.dataType }</td>
            <td>${dataDictionaryInfo.dataDesc }</td>
            <th>
            <a href="${pageContext.request.contextPath }/DataDictionaryController/updateDataDictionaryUi.action?dataId=${dataDictionaryInfo.dataId }">修改</a>
            <a href="javaScript:void(0);" onclick="deleteById(${dataDictionaryInfo.dataId }) ">删除</a>
            </th>
        </tr> 
        
        </c:forEach>
       	<!-- <tr>
        	<td>1001</td>
            <td>良好</td>
            <td>预期反应</td>
            <td>描述</td>
            <th><a href="datadictionary_update.html">修改</a> <a href="">删除</a></th>
        </tr>
            	<tr>
        	<td>1001</td>
            <td>良好</td>
            <td>预期反应</td>
            <td>描述</td>
            <th><a href="datadictionary_update.html">修改</a> <a href="">删除</a></th>
        </tr>       	<tr>
        	<td>1001</td>
            <td>良好</td>
            <td>预期反应</td>
            <td>描述</td>
            <th><a href="datadictionary_update.html">修改</a> <a href="">删除</a></th>
        </tr>       	<tr>
        	<td>1001</td>
            <td>良好</td>
            <td>预期反应</td>
            <td>描述</td>
            <th><a href="datadictionary_update.html">修改</a> <a href="">删除</a></th>
        </tr>   -->   
    </table>
</div>

</body>
<script type="text/javascript">
  function findByType(){
	var type = $("#typeId").val();
	location.href="${pageContext.request.contextPath }/DataDictionaryController/findByType.action?dataType="+type;
}
  function deleteById(id) {
	  if(confirm("是否进行删除？")){
			 location.href="${pageContext.request.contextPath }/DataDictionaryController/deleteDataDictionaryById.action?dataId="+id;
		 }
	
}
</script>
</html>



    