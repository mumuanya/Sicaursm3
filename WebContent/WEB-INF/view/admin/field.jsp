<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<title>四川农业大学公共资源管理平台 - 主面板</title>
		
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
		
		<!--引入css-->
		<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/static/back/css/bootstrap.min.css"/>
		<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/static/back/css/bootstrap-theme.min.css"/>
		<!--一些自定义的样式-->
		<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/static/back/css/styles.css"/>
		<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/static/back/css/base/index.css"/>
		<!--引入js-->
		<script src="<%= request.getContextPath() %>/static/back/js/jquery-2.1.0.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%= request.getContextPath() %>/static/back/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%= request.getContextPath() %>/static/back/js/bootstrap-table.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%= request.getContextPath() %>/static/back/js/base/public.js" type="text/javascript" charset="utf-8"></script>
	</head>
	<body>
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="#"><span>四川农业大学公共资源</span>管理</a>
					<ul class="user-menu">
						<li class="dropdown pull-right">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-user"></span>${admin.neckname}<span class="caret"></span></a>
							<ul class="dropdown-menu" role="menu">
								<li onclick="adminloginoff('<%= request.getContextPath()%>/admin/loginoff')"><a href="#"><span class="glyphicon glyphicon-log-out"></span> 退出登录</a></li>
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
						<span class="glyphicon glyphicon-user"></span>场地/物品管理
					</a>
				</div>
				<div id="collapseOne" class="accordion-body collapse" style="height: 0px; ">
					<ul class="nav menu">
						<li class="active"><a href="field.html" style="color: green;"><span class="glyphicon glyphicon-sunglasses"></span> 场地管理</a></li>
						<li><a href="item.html" style="color: green;"><span class="glyphicon glyphicon-shopping-cart"></span> 物品管理</a></li>
					</ul>
				</div>
			</div>
			<div class="accordion-group">
				<div class="accordion-heading menu-tap">
					<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseTwo">
						<span class="glyphicon glyphicon-user"></span>借用申请管理
					</a>
				</div>
				<div id="collapseTwo" class="accordion-body collapse" style="height: 0px; ">
					<ul class="nav menu">
						<li><a href="apply.html" style="color: green;"><span class="glyphicon glyphicon-sunglasses"></span> 查看申请</a></li>
						<li><a href="passedapply.html" style="color: green;"><span class="glyphicon glyphicon-shopping-cart"></span> 已借出申请</a></li>
						<li><a href="returingapply.html" style="color: green;"><span class="glyphicon glyphicon-shopping-cart"></span> 归还申请</a></li>
						<li><a href="applyrecord.html" style="color: green;"><span class="glyphicon glyphicon-shopping-cart"></span> 历史申请(已归还记录)</a></li>
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
						<li class="active">场地管理</li>
					</ol>
				</div><!--/.row-->
			
				<!--这里是表格和相关按钮-->
				<div class="row">
					<div class="col-lg-12">
						<div class="panel panel-default">
							<div class="panel panel-heading">
								<button class="btn btn-primary" name="deletefield" disabled="disabled" data-toggle="modal" data-target=".deletefield">删除</button>
								<button class="btn btn-primary" name="updatefield" disabled="disabled" data-toggle="modal" data-target=".updatefield">修改</button>
								<button class="btn btn-primary" name="addfield" data-toggle="modal" data-target=".addfield">增加</button>
								<button class="btn btn-primary" name="lookfield" disabled="disabled" data-toggle="modal" data-target=".lookfield">查看详细</button>
							</div>
							<div class="panel-body">
								<table data-toggle="table" id="filedtable" data-show-refresh="true" data-show-toggle="true" data-single-select="true" data-show-columns="true" data-search="true" data-select-item-name="toolbar1" data-pagination="true" data-sort-name="name" data-sort-order="desc">
									<thead>
										<tr>
											<th data-checkbox="true" >选择</th>
											<th data-sortable="true" data-field="id">ID</th>
											<th data-field="name">名称</th>
											<th data-field="description">描述</th>
											<th data-field="state">状态</th>
											<th data-field="position">位置</th>
										</tr>
									</thead>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--以下是模态框  -->
		<!--查看模态框  -->
		<div class="modal fade lookfield" tabindex="-1" role="dialog" aria-labelledby="lookfieldModalLabel">
		  <div class="modal-dialog modal-sm" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		       		查看场地信息
		       </div>
		       <div class="modal-body">
		       		<div id="lookfieldmodal">
		        		<label for="id">ID号:</label><input type="text" name="id" id="id" value="" disabled="disabled"/>
		        		<br /><label for="name">名称:</label><input type="text" name="name" id="name" value="" disabled="disabled"/>
		        		<br /><label for="description">描述:</label><input type="text" name="description" id="description" value="" disabled="disabled"/>
		        		<br /><label for="state">状态:</label><input type="text" name="state" id="state" value="" disabled="disabled"/>
		        		<br /><label for="position">位置:</label><input type="text" name="position" id="position" value="" disabled="disabled"/>
		        	</div>
		        </div>
		        <div class="modal-footer">
		        	<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
		        </div>
		    </div>
		  </div>
		</div>
		<!--/查看模态框  -->
		<!--删除模态框  -->
		<div class="modal fade deletefield" id="deletefield" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
		  <div class="modal-dialog modal-sm" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		       		删除收录场地信息
		       </div>
		        <div class="modal-body">
		        	<p style="color: red;">删除场地收录信息，将会导致关于此场地的申请信息全部失效！</p>
		        </div>
		        <div class="modal-footer">
		        	<button type="button" class="btn btn-default" data-dismiss="modal">取消删除</button>
       			 	<button type="button" class="btn btn-primary" onclick="deletefield()">确认删除</button>
		        </div>
		    </div>
		  </div>
		</div>
		<!--/删除模态框  -->
		<!--更新模态框  -->
		<div class="modal fade updatefield" id="updatefield" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
		  <div class="modal-dialog modal-sm" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		       		修改收录场地信息
		       </div>
		        <div class="modal-body" id="updatefieldmodal">
		        	<label for="id">ID号:</label><input type="text" name="id" id="id" value="" disabled="disabled"/><span style="color:red;">不可修改</span>
		        	<hr />
		        		<br /><label for="name">名称:</label><input type="text" name="name" id="name" value=""/>
		        		<br /><label for="description">描述:</label><input type="text" name="description" id="description" value=""/>
		        		<br /><label for="state">状态:</label>
								<select name="state">
									<option value="0">未借出</option>
									<option value="1">已借出</option>
								</select>
		        		<br /><label for="position">位置:</label><input type="text" name="position" id="position" value=""/>
		        </div>
		        <div class="modal-footer">
		        	<button type="button" class="btn btn-default" data-dismiss="modal">取消修改</button>
       			 	<button type="button" class="btn btn-primary" onclick="updatefield()">确认修改</button>
		        </div>
		    </div>
		  </div>
		</div>
		<!--/更新模态框  -->
		<!--增加模态框  -->
		<div class="modal fade addfield" id="addfield" tabindex="-1" role="dialog" aria-labelledby="myaddModalLabel">
		  <div class="modal-dialog modal-sm" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		       		增加收录场地信息
		       </div>
		        <div class="modal-body" id="addfieldmodal">
		        		<br /><label for="name">名称:</label><input type="text" name="name" id="name" value=""/>
		        		<br /><label for="description">描述:</label><input type="text" name="description" id="description" value=""/>
		        		<br /><label for="position">位置:</label><input type="text" name="position" id="position" value=""/>
		        </div>
		        <div class="modal-footer">
		        	<button type="button" class="btn btn-default" data-dismiss="modal">取消增加</button>
       			 	<button type="button" class="btn btn-primary" onclick="addfield()">确认增加</button>
		        </div>
		    </div>
		  </div>
		</div>
		<!--/增加模态框  -->
		<script src="<%= request.getContextPath() %>/static/back/js/base/field.js" type="text/javascript" charset="utf-8"></script>
	</body>
</html>
