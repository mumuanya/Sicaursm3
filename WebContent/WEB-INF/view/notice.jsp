<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<meta charset="utf-8">
		<title>校园公共资源借用平台</title>
		<meta name="generator" content="Bootply" />
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<link rel="stylesheet" href="<%= request.getContextPath() %>/static/public/css/bootstrap.min.css">
		<link href="<%= request.getContextPath() %>/static/public/css/styles.css" rel="stylesheet">
		<link rel="stylesheet" href="<%= request.getContextPath() %>/static/public/css/demo.css" />
		<link rel="stylesheet" href="<%= request.getContextPath() %>/static/public/css/testimonial.css" />
		<link rel="stylesheet" href="<%= request.getContextPath() %>/static/public/css/font-awesome.min.css">
	</head>

	<body>
		<div class="header container">
			<div class="visible-xs visible-sm col-xs-12 col-sm-12 text-center sm-logo">
				<a rel="home" href="index.html">
					<img src="<%= request.getContextPath() %>/static/public/img/logo.png" width="200" alt="logo">
				</a>
			</div>
		</div>
		<div class="navbar" role="navigation">
			<div class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="selected">
						<a href="<%= request.getContextPath() %>/index.jsp" style="font-size: 45px;">主页</a>
					</li>
					<li class="hidden-xs hidden-sm">
						<a rel="home" href="<%= request.getContextPath() %>/index.jsp"><img class="logo" src="<%= request.getContextPath() %>/static/public/img/logo.png" width="200" alt="logo"></a>
					</li>
					<li>
						<a href="" style="font-size: 45px;">公告</a>
					</li>
				</ul>
			</div>
		</div>

		<div class="divider col-sm-offset-3 col-md-offset-3 col-lg-offset-3 col-xs-offset-3 col-sm-6 col-xs-6 col-md-6">
			<div class="header-text"><span>公告内容</span></div>
		</div>

		<div id="exTab2" class="col-md-6 col-lg-6 col-lg-offset-3 col-md-offset-3">
			<div class="tab-content ">
				<div class="tab-pane active" id="1">
					<div class="blog-event">
						<div class="featured-blog">
							<h3>引入地点资源列表<small>&nbsp;&nbsp;&nbsp;&nbsp;2018-2-6</small></h3>
							<p> 从现在起，杏园周边环境可外借！请同学们多多留意。</p>
						</div>
					</div>
					<div class="blog-event">
						<div class="featured-blog">
							<h3>引入新的物品资源<small>&nbsp;&nbsp;&nbsp;&nbsp;2018-1-3</small></h3>
							<p> 老区游泳池旁边的球类已开发，目前可借用资源了！</p>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- ============FOOTER============= -->
		<footer id="footer">
			<div class="footer-content container">
				<div class="footer-adress text-center col-xs-12 col-sm-4 col-md-4">
					<h4>页面链接</h4>
					<ul class="footer-menus">
						<li>主页</li>
						<li>公告</li><br />
						<li>我是管理</li>
						<li>我是学生</li>
					</ul>
				</div>
				<div class="footer-second col-xs-12 col-sm-4 col-md-4">
					<div class="social-block text-center">
						<div class="social-share">
							<i class="fa fa-2x fa-qq"></i>
							<i class="fa fa-2x  fa-weibo"></i>
							<i class="fa fa-2x  fa-wechat"></i>
						</div>
					</div>
					<p class="text-center footer-text1">18227592596</p>
					<p class="text-center footer-text">1442364974@qq.com</p>
				</div>
				<div class="footer-third col-xs-12 col-sm-4 col-md-4">
					<div class="copyright">
						<span>Copyright 2018 ShunZhaomin.
						<span>All Rights Reserved</span>
					</div>
				</div>
			</div>
			<div class="move-top-page">
			</div>
		</footer>

		<!-- script references -->
		<script src="<%= request.getContextPath() %>/static/public/js/jquery.min.js"></script>
		<script src="<%= request.getContextPath() %>/static/public/js/bootstrap.min.js"></script>
		<script src="<%= request.getContextPath() %>/static/public/js/nav-hover.min.js"></script>
		<script type="text/javascript" src="<%= request.getContextPath() %>/static/public/js/jquery.bxslider.min.js"></script>
		<script type="text/javascript" src="<%= request.getContextPath() %>/static/public/js/main.js"></script>
		<!-- Place in the <head>, after the three links -->
		<script>
			$('.testimonials-slider').bxSlider({
				slideWidth: 800,
				minSlides: 1,
				maxSlides: 1,
				slideMargin: 32,
				auto: true,
				autoControls: true
			});
		</script>
		<script type="text/javascript">
		</script>
	</body>

</html>