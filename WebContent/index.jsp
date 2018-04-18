<%@ page language="java" contentType="text/html; charset=utf-8" %>
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
						<a href="common/notice" style="font-size: 45px;">公告</a>
					</li>
				</ul>
			</div>
		</div>
		<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
				<li data-target="#carousel-example-generic" data-slide-to="1"></li>
				<li data-target="#carousel-example-generic" data-slide-to="2"></li>
			</ol>

			<!-- Wrapper for slides -->
			<div class="carousel-inner" role="listbox">
				<div class="item active">
					<img src="<%= request.getContextPath() %>/static/public/img/slide3.jpg" alt="">
					<div class="carousel-caption">
						化繁为简
					</div>
				</div>
				<div class="item">
					<img src="<%= request.getContextPath() %>/static/public/img/slide2.jpg" alt="">
					<div class="carousel-caption">
						实时通知
					</div>
				</div>
				<div class="item">
					<img src="<%= request.getContextPath() %>/static/public/img/slide1.jpg" alt="">
					<div class="carousel-caption">
						集中管理
					</div>
				</div>
			</div>

			<!-- Controls -->
			<a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
				<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
				<span class="sr-only">上一个</span>
			</a>
			<a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
				<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
				<span class="sr-only">下一个</span>
			</a>
		</div>
		<div class="container header-start text-center">
			<div class="heading-icon">
				<i class="fa fa-3x fa-desktop"></i>
			</div>
			<h1 class="main-text">开始使用校园公共资源借用平台</h1>
			<p class="text-center sub-text">校园公共平台旨在营造一个线上线下的运营模式,提高校园公共物资借用效率，为管理者和师生提供便捷的服务和高效的执行方法。</p>
		</div>
		<div class="divider col-sm-12 col-xs-12 col-md-12">
			<div class="header-text"><span>开始使用</span></div>
		</div>

		<section class="blog">
			<div class="item col-md-4">
				<div class="blok-read-sm">
					<a href="admin/login" class="hover-image">
						<img src="<%= request.getContextPath() %>/static/public/img/admin.jpg" alt="image">
						<span class="layer-block"></span>
					</a>
				</div>
			</div>
			<div class="item col-md-4">
				<div class="blok-read-sm">
					<a href="user/login" class="hover-image">
						<img src="<%= request.getContextPath() %>/static/public/img/student.jpg" alt="image">
						<span class="layer-block"></span>
					</a>
				</div>
			</div>
			<div class="item col-md-4">
				<div class="blok-read-sm">
					<a href="common/notice" class="hover-image">
						<img src="<%= request.getContextPath() %>/static/public/img/notice.jpg" alt="image">
						<span class="layer-block"></span>
					</a>
				</div>
			</div>
		</section>

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
