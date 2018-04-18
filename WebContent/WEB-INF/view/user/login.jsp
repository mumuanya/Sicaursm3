<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1.0" />
<title>学生登录 - 川农大公共资源管理品台</title>

	<!--what we need-->
	<script src="<%= request.getContextPath() %>/static/back/js/jquery-2.1.0.js" type="text/javascript" charset="utf-8"></script>
	<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/static/back/css/bootstrap-theme.min.css"/>
	<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/static/back/css/bootstrap.min.css"/>
	<script src="<%= request.getContextPath() %>/static/back/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="<%= request.getContextPath() %>/static/front/js/base/userlogin.js" type="text/javascript" charset="utf-8"></script>
	<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/static/back/css/main.css"/>
	</head>
	<body>
		<div class="box">
			<h1 id="tag-ruan">欢迎来到川农大公共资源管理品台</h1>
				<div class="login-box">
					<div class="login-title text-center">
						<h1><small>登录</small></h1>
					</div>
					<div class="login-content ">
					<div class="form">
					<form action="#" method="post">
						<div class="form-group">
							<div class="col-xs-12  ">
								<div class="input-group">
									<span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
									<input type="text" id="account" name="account" class="form-control" placeholder="账号"> 
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="col-xs-12">
								
								<div class="input-group">
									<span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
									<input type="password" id="password" name="password" class="form-control" placeholder="密码">
								</div>
							</div>
						</div>
						<div class="form-group form-actions">
							
							<div class="col-xs-4 col-xs-offset-4 ">
								<button type="button" onclick="userlogin('<%= request.getContextPath() %>/user/loginin')" class="btn btn-sm btn-info"><span class="glyphicon glyphicon-off"></span> 登录</button>
							</div>
						</div>
					</form>
					</div>
				</div>
			</div>
		</div>
		<div class="modal-footer" style="text-align: center;">
			<h6> (c) Copyright 2017 sicaursm. All Rights Reserved. </h6>
		</div>
	</body>

</html>

