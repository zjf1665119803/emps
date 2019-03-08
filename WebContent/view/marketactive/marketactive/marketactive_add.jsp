<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
        <li>添加活动</li>
    </ul>
</div>

<form action="${pageContext.request.contextPath }/MarketActiveController/addMarketActive.action" class="form-horizontal" method="post">
    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">基本信息</h5>
	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">编号</label>
                <div class="col-sm-9">
                	<input type="text" name="activeId" readonly="readonly" class="form-control input-sm" placeholder="请输入编号"/>
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">活动名称</label>
                <div class="col-sm-9">
                	<input type="text" name="activeName" class="form-control input-sm" placeholder="请输入活动名称"/>
                </div>
            </div>
        </div>
    </div>
    	<!--开始 -->
    	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">开始时间</label>
                <div class="col-sm-9">
                	<input type="text" name="activeStart" class="form-control input-sm" placeholder="请输入开始时间"/>
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">活动状态</label>
                <div class="col-sm-5">
                	<select name="activeState" class="form-control input-sm">
                    	<option value="0">准备中</option>
                        <option value="1">开始</option>
                        <option value="2">进行中</option>
                        <option value="3">完成</option>
                    </select>
                </div>
            </div>
        </div>
    </div>
   <!--结束 -->
       	<!--开始 -->
    	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">结束时间</label>
                <div class="col-sm-9">
                	<input type="text" name="activeEnd" class="form-control input-sm" placeholder="请输入结束时间"/>
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">活动类型</label>
                <div class="col-sm-5">
                	<select name="activeType" class="form-control input-sm">
                    	<option value="0">现场交流</option>
                        <option value="1">会议</option>
                        <option value="">其他</option>
                    </select>
                </div>
            </div>
        </div>
    </div>
   <!--结束 -->
    <!--开始 -->
    	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">成本预算</label>
                <div class="col-sm-6">
                	<input type="text" name="activeCosteEmtimate" class="form-control input-sm" placeholder="请输入成本预算"/>
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">实际成本</label>
                <div class="col-sm-6">
                	<input type="text" name="activeCoste" class="form-control input-sm" placeholder="请输入实际成本"/>
                </div>
            </div>
        </div>
    </div>
   <!--结束 -->
   <!--开始 -->
    	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">预期反应</label>
                <div class="col-sm-6">
                	 	<select name="activeRefectEstimate" class="form-control input-sm">
                    	<option value="0">好</option>
                        <option value="1">非常好</option>
                        <option value="2">非常非常的好</option>
                    </select>
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">预期学员</label>
                <div class="col-sm-6">
                	<input type="text" name="activeStudent" class="form-control input-sm" placeholder="请输入预期学员"/>
                </div>
            </div>
        </div>
    </div>
   <!--结束 -->
    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">描述信息</h5>
    	<div class="row">
    	<div class="col-sm-10">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">描述信息</label>
                <div class="col-sm-9">
                	<textarea class="form-control" name="activeContent"></textarea>
                </div>
            </div>
        
        </div>

    </div>
 
   	<div class="row">
    	<div class="col-sm-3 col-sm-offset-4">
        	<input  type="submit" class="btn btn-success" value="保存"/>
            <a class="btn btn-warning" href="marketactive_list.html">返回上一级</a>
        </div>
    </div>
</form>

</body>
</html>
