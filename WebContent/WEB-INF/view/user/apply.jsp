<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<title>四川农业大学公共资源管理平台 - 主面板</title>
		
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
		
		<!--引入css-->
		<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/static/front/css/bootstrap.min.css"/>
		<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/static/front/css/bootstrap-theme.min.css"/>
		<!--一些自定义的样式-->
		<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/static/front/css/styles.css"/>
		<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/static/front/css/base/index.css"/>
		<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/static/css/bootstrap-select.min.css"/>
		<!--引入js-->
		<script src="<%= request.getContextPath() %>/static/front/js/jquery-2.1.0.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%= request.getContextPath() %>/static/front/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%= request.getContextPath() %>/static/front/js/bootstrap-table.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%= request.getContextPath() %>/static/js/bootstrap-select.min.js" type="text/javascript" charset="utf-8"></script>
		<style type="text/css">
			.form-control{
				display:inline-block;
				width:220px;
			}
		</style>
	</head>
	<body>
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="#"><span>四川农业大学公共资源</span>管理</a>
					<ul class="user-menu">
						<li class="dropdown pull-right">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-user"></span>${user.neckname}<span class="caret"></span></a>
							<ul class="dropdown-menu" role="menu">
								<li onclick="userloginoff('<%= request.getContextPath()%>/user/loginoff')"><a href="#"><span class="glyphicon glyphicon-log-out"></span> 退出登录</a></li>
							</ul>
						</li>
					</ul>
				</div>
								
			</div><!-- /.container-fluid -->
		</nav>
		
		<!--左侧的导航栏-->
		<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
			<form role="search">
				<div class="form-group">
					<input type="text" class="form-control" placeholder="查找">
				</div>
			</form>
			<div class="accordion-group">
				<div class="accordion-heading menu-tap">
					<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseOne">
						<span class="glyphicon glyphicon-user"></span>查看可用场地/物品
					</a>
				</div>
				<div id="collapseOne" class="accordion-body collapse" style="height: 0px; ">
					<ul class="nav menu">
						<li><a href="field" style="color: green;"><span class="glyphicon glyphicon-sunglasses"></span> 可用场地</a></li>
						<li><a href="item" style="color: green;"><span class="glyphicon glyphicon-shopping-cart"></span> 可用物品</a></li>
					</ul>
				</div>
			</div>
			<div class="accordion-group">
				<div class="accordion-heading menu-tap">
					<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseTwo">
						<span class="glyphicon glyphicon-user"></span>申请管理
					</a>
				</div>
				<div id="collapseTwo" class="accordion-body collapse" style="height: 0px; ">
					<ul class="nav menu">
						<li class="active"><a href="apply" style="color: green;"><span class="glyphicon glyphicon-sunglasses"></span> 申请借用场地/物品</a></li>
						<li><a href="appling" style="color: green;"><span class="glyphicon glyphicon-shopping-cart"></span>正在审核中</a></li>
						<li><a href="applied" style="color: green;"><span class="glyphicon glyphicon-shopping-cart"></span> 审核通过申请</a></li>
						<li><a href="applyhistory" style="color: green;"><span class="glyphicon glyphicon-shopping-cart"></span> 历史申请(已归还记录)</a></li>
					</ul>
				</div>
			</div>
			<div class="attribution">(c) SICAURSM  2017. 版权所有.  </div>
		</div><!--/.sidebar-->
		
		<!--这里是右边部分的主面板了-->
		<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
			<div class="row">
				<div class="row">
					<ol class="breadcrumb">
						<li><a href="#"><span class="glyphicon glyphicon-jpy"></span></a></li>
						<li class="active">申请表填写</li>
					</ol>
				</div><!--/.row-->
				<!--这里是表格和相关按钮-->
				<div class="row">
					<div class="col-lg-12">
						<div class="panel panel-default">
							<div class="panel-body">
								<div class="row text-center" style="margin-bottom: 20px;">
									<div class="col-lg-6">
										<label for="borrowtype">借用类型：</label>
										<select id="borrowtype" class="selectpicker" name="borrowtype">
											<option selected="selected" disabled="disabled">请选择</option>
											<option value="0">场地</option>
											<option value="1">物品</option>
										</select>
									</div>
									<div class="col-lg-6">
										<label for="name">借用名称：</label>
										<select id="tid" class="selectpicker" name="name">
											<option selected="selected" disabled="disabled">请选择</option>
										</select>
									</div>
								</div>
								<div class="row text-center"  style="margin-bottom: 20px;">
									<div class="col-lg-6">
										<label for="borrowreason">借用理由：</label>
										<input class="form-control" type="text" name="borrowreason" id="borrowreason" value="" />
									</div>
									<div class="col-lg-6">
										<label for=""borrowtime"">借用时长：</label>
										<input class="form-control" type="number" name=""borrowtime"" id="borrowtime" value="" placeholder="输入借用天数"/>
									</div>
								</div>
								<div class="row text-center">
									<div class="col-lg-2 col-lg-offset-4">
										<button type="button" class="btn btn-info" onclick="resetValue()">重新填写</button>
									</div>
									<div class="col-lg-2">
										<button type="button" class="btn btn-success" onclick="toapply()">提交申请</button>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<script src="<%= request.getContextPath() %>/static/front/js/base/apply.js" type="text/javascript" charset="utf-8"></script>
	</body>
</html>
