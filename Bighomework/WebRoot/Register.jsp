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
	<!--  教材预订管理系统 -->
	<div align="left">
		<h2 class="sub-header" style="padding-left: 30px">用户注册</h2>
	</div>
	<font size="4px" style=" color:red;"><s:fielderror></s:fielderror></font>
	<div align="center">
		<form action="register.action" method="post" name="form1">
			<h3>
				<font color=#999999 style="margin-right: 50px">输入您的信息，请认真核实</font>
			</h3>
			<br> <font size="3px" style="margin-right:50px; color:#999999;">您的学号:</font><input
				type="text"
				style="margin-right: 70px;margin-bottom:20px; font-size:15px; color: #999999"
				name="snumber"><br>
				 <font size="3px"
				style="margin-right:50px; color:#999999;">密码:</font><input
				type="password"
				style="margin-right: 100px;margin-bottom:20px; font-size:15px; color: #999999"
				name="spas"><br> 
				<font size="3px"
				style="margin-right:50px; color:#999999;">请再次输入密码:</font><input
				type="password"
				style="margin-right: 25px;margin-bottom:20px; font-size:15px; color: #999999"
				name="spas1"><br> 
				<font size="3px"
				style="margin-right:50px; color:#999999;">姓名:</font><input
				type="text"
				style="margin-right: 100px;margin-bottom:20px; font-size:15px; color: #999999"
				name="sname"><br> <br> 
				<input type="submit"
				style="margin-right: 100px;margin-bottom:20px; font-size:15px; color: #999999"
				value="提交"><br>
				 <input type="reset"
				style="margin-right: 100px;margin-bottom:20px; font-size:15px; color: #999999"
				value="重置"><br>

		</form>
	</div>

</body>
</html>