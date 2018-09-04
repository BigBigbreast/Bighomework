<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!-- <link rel="stylesheet" type="text/css" href="../css/index.css"> -->



<!-- 首页只能用include导入样式文件，不知道为什么 -->
<style>
<%@
include
 
file="../css/bootstrap.min.css"%>
<%@
include
 

file="../css/ie10-viewport-bug-workaround.css"
 

%>
<%@
include
 

file="../css/cover.css"
 

%>
<%@
include
 

file="../js/ie-emulation-modes-warning.js"
 

%>
<%@
include
 

file="../js/bootstrap.min.js"
 

%>
<%@
include


file
="../js/ie10-viewport-bug-workaround.js"
 

%>
</style>
</head>



<body>

	<div class="site-wrapper">

		<div class="site-wrapper-inner">

			<div class="cover-container">

				<div class="masthead clearfix">
					<div class="inner">
						<h3 class="masthead-brand">Cover</h3>
						<nav>
						<ul class="nav masthead-nav">
							<li class="active"><a href="admin/BasicInformation.jsp">Home</a></li>
							<li><a href="login.jsp">Features</a></li>
							<li><a href="login.jsp">Login</a></li>
						</ul>
						</nav>
					</div>
				</div>

				<div class="inner cover">
					<h1 class="cover-heading">欢迎来到郑州大学教材预订系统</h1>
					<br> <br> <br> <br> <br> <br>
					<p class="lead">
						<a href="login.jsp" class="btn btn-lg btn-default">立即进入</a>
					</p>
				</div>

				<div class="mastfoot">
					<div class="inner">
						<p>制作人：赵腾飞 201677I1250</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
