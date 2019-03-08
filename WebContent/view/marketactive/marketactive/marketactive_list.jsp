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
        <li>营销活动</li>
    </ul>
</div>
<div class="row alert alert-info"  style="margin:0px; padding:3px;" >
<form class="form-inline">
     <div class="form-group">
         <label class="" for="activename">活动名称：</label>
        <input type="email" class="form-control" id="activename" placeholder="请输入活动名称">
      </div>
      <div class="form-group">
         <label class="" for="activstate">活动状态：</label>
		 <select  class="form-control" id="activstate">
            <option value="0">准备中</option>
            <option value="1">开始</option>
            <option value="2">进行中</option>
            <option value="3">完成</option>
         </select>	
      </div>
    <input type="button"   class="btn btn-danger"   value="查询" onclick="findByMethod();"/>
     <input type="button"   class="btn btn-success"   value="添加活动" onClick="javascript:window.location='${pageContext.request.contextPath }/view/marketactive/marketactive/marketactive_add.jsp'"/>
    </form>
</div>
<div class="row" style="padding:15px; padding-top:0px; ">
	<table class="table  table-condensed table-striped">
    	<tr>
        	<th>编号</th>
            <th>活动名称</th>
            <th>负责人</th>
            <th>开始时间</th>
            <th>结束时间</th>
            <th>活动状态</th>
            <th>操作</th>
        </tr>
       	<c:forEach items="${requestScope.marketActiveList }" var="marketActive">
        <tr>
        	<td>${marketActive.activeId }</td>
            <td>${marketActive.activeName }</td>
            <td>${marketActive.staffInfo.staffName }</td>
            <td>${marketActive.activeStart }</td>
            <td>${marketActive.activeEnd }</td>
            <c:if test="${marketActive.activeState == 0 }">
            <td>准备中</td>
            </c:if>
            <c:if test="${marketActive.activeState == 1 }">
            <td>开始</td>
            </c:if>
            <c:if test="${marketActive.activeState == 2 }">
            <td>进行中</td>
            </c:if>
            <c:if test="${marketActive.activeState == 3 }">
            <td>完成</td>
            </c:if>
            <th>
            <a href="${pageContext.request.contextPath }/MarketActiveController/updateUi.action?activeId=${marketActive.activeId}">修改</a>  
            <a  href="javaScript:void(0);" onclick="deleteById(${marketActive.activeId })">删除</a>
        </tr>
        </c:forEach>
    </table>
</div>

</body>
<script type="text/javascript">
    function findByMethod() {
    	var activename = $("#activename").val();
    	var activstate = $("#activstate").val();
   		location.href="${pageContext.request.contextPath }/MarketActiveController/findByMethod.action?activeState="+activstate+"&activeName="+activename;
    }
    function deleteById(id) {
     	 if(confirm("是否进行删除？")){
     		 location.href="${pageContext.request.contextPath }/MarketActiveController/deleteById.action?activeId="+id;
     	 }
    }
</script>
</html>












