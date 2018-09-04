<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>登录界面</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<!-- 连接css样式 -->
<!-- <link href="css/login.css" rel="stylesheet" type="text/css"> -->
<script type="application/javascript" src="../js/jquery-1.9.1.min.js"></script>
<script type="application/javascript" src="js/bootstrap.min.js"></script>

<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<style type="text/css">
.myform {
	width: 40%;
	margin: 0 auto;
}

.myinput {
	margin: 10px auto;
}
</style>
</head>

<body>
	<!-- GIMS：Graduate Information Management System 毕业生信息管理系统 -->
	<s:if test="#session.flag==1">
		<script type="text/javascript">alert("用户名或密码输入错误！")</script>
	</s:if>
	<div class="container">

		<form class="form-signin myform" action="checklogin.action"
			method="post">
			<h2 class="form-signin-heading">请登录</h2>
			<label for="inputUsername" class="sr-only">Username</label> <font
				size="3px">请输入用户名：</font> <input type="text"
				class="form-control myinput" name="username" placeholder="ursename"
				required autofocus> <label for="inputPassword"
				class="sr-only">Password</label> <font size="3px">请输入密码：</font> <input
				type="password" name="userpass" class="form-control myinput"
				placeholder="Password" required>

			<button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
			<br> 没有账号？<a href="Register.jsp">立即注册</a>
		</form>

	</div>
</body>
</html>