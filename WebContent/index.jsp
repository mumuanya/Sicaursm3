<%@ page language="java" contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
<head>
 <meta charset="UTF-8">
 <title>加载中</title>
 <meta http-equiv="content-type" content="text/html; charset=utf-8" />
 <style type="text/css">
  .spinner {
   margin: 300px auto 0 auto;
   width: 50px;
   height: 60px;
   text-align: center;
   font-size: 10px;
  }

  .spinner > div {
   background-color: #FFFFFF;
   height: 100%;
   width: 6px;
   display: inline-block;

   -webkit-animation: stretchdelay 1.2s infinite ease-in-out;
   animation: stretchdelay 1.2s infinite ease-in-out;
  }

  .spinner .rect2 {
   -webkit-animation-delay: -1.1s;
   animation-delay: -1.1s;
  }

  .spinner .rect3 {
   -webkit-animation-delay: -1.0s;
   animation-delay: -1.0s;
  }

  .spinner .rect4 {
   -webkit-animation-delay: -0.9s;
   animation-delay: -0.9s;
  }

  .spinner .rect5 {
   -webkit-animation-delay: -0.8s;
   animation-delay: -0.8s;
  }

  @-webkit-keyframes stretchdelay {
   0%, 40%, 100% { -webkit-transform: scaleY(0.4) }
   20% { -webkit-transform: scaleY(1.0) }
  }

  @keyframes stretchdelay {
   0%, 40%, 100% {
    transform: scaleY(0.4);
    -webkit-transform: scaleY(0.4);
   }  20% {
       transform: scaleY(1.0);
       -webkit-transform: scaleY(1.0);
      }
  }
  .spinner2{
   margin: 10px 0 0 0;
  }
  .spinner2 > h1 {

  }
 </style>
</head>
<body style="background-color: deepskyblue;">
<div class="spinner">
 <div class="rect1"></div>
 <div class="rect2"></div>
 <div class="rect3"></div>
 <div class="rect4"></div>
 <div class="rect5"></div>
</div>
<div class="spinner2" style="color: white; text-align: center;">
 <h1 style="border: solid 1px white; width:200px;margin:auto; top:20px; margin-top:20px;"><a style="text-decoration: none;color:white" href="javascript:admin()">我是管理员</a></h1>
 <h1 style="border: solid 1px white; width:200px;margin:auto; margin-top:20px;"><a style="text-decoration: none;color:white" href="javascript:user()">我是用户</a></h1>
</div>
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
<script type="text/javascript">

	function user(){
		window.location.href = "<%= request.getContextPath() %>/user/login";
	}
	function admin(){
		window.location.href = "<%= request.getContextPath() %>/admin/login";
	}
    
</script>
</body>
</html>
