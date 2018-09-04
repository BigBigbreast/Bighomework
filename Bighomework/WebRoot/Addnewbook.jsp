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

<title>My JSP 'index.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link href="../css/ie10-viewport-bug-workaround.css" rel="stylesheet">
<link href="../css/dashboard.css" rel="stylesheet">
<style>
<%@
include
 
file="../css/index.css"
 
%>
</style>
<!-- 导入js文件 -->
<script type="application/javascript" src="../js/jquery-1.9.1.min.js"></script>
<script type="application/javascript" src="../js/bootstrap.min.js"></script>
<script src="../js/ie-emulation-modes-warning.js"></script>
<script src="../js/jquery.min.js"></script>
<script src="../js/holder.min.js"></script>
<script src="../js/ie10-viewport-bug-workaround.js"></script>

<style>
#mytbody {
	height: 10px;
}
</style>
<style>
#myinput {
	width: 15%;
}
</style>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>

			<h3>
				<font color=white>欢迎您,<s:property
						value="#session.student.sname" /></font>
			</h3>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#">收藏</a></li>
				<li><a href="#">设置</a></li>
				<li><a href="#">反馈</a></li>
				<li><a href="#">联系我</a></li>
			</ul>
			<form class="navbar-form navbar-right">
				<input type="text" class="form-control" placeholder="站内搜索...">
			</form>
		</div>
	</div>
	</nav>

	<div class="container-fluid">
		<div class="myShange"></div>

		<div class="row">
			<!-- 左部栅格导航栏 -->
			<div class="col-md-2">
				<ul class="nav nav-sidebar">

					<br>
					<br>
					<br>
					<br>
					<li><a href="lookbooks.action">购买教材</a>
					<li>
					<li><a href="SearchBook.jsp">搜索教材</a>
					<li>
					<li><a href="userforms.action">查看我的订单</a>
					<li><font size="5px" color="red">-------------</font>
					<li><a href="Searchuserform.jsp">搜索购书单</a>
					<li>
					<li><a href="showforms.action">审核购书单</a>
					<li>
					<li><a href="showallrecepts.action">开发票</a>
					<li>
					<li><a href="showalllingforms.action">查看所有领书单</a>
					<li><font size="5px" color="red">-------------</font>
					<li><a href="addbooks.action">购入书籍</a>
					<li>
					<li><a href="showecharts.action">查看图表</a>
					<li><a href="Addnewbook.jsp">购入新书籍</a>
					<li><font size="5px" color="red">-------------</font>
					<li><a href="login.jsp">返回登录界面</a>
					<li>
				</ul>
			</div>
			<!-- 右部表格数据 -->
			<br> <br> <br> <br> <br> <br> <br>
			<br> <br>
			<div align="left">
				<h2 class="sub-header">添加新教材</h2>
			</div>
			<div align="center">
				<form action="addnewbook" method="post" id="form1">
					<h3>
						<font color=#999999 style="margin-right: 50px">以下填入书籍的图书信息，请认真核实</font>
					</h3>
					<br> <font size="3px"
						style="margin-right:50px; color:#999999;">图书名称:</font><input
						type="text"
						style="margin-right: 100px;margin-bottom:20px; font-size:15px; color: #999999"
						name="bookname"><br> <font size="3px"
						style="margin-right:50px; color:#999999;">作者:</font><input
						type="text"
						style="margin-right: 100px;margin-bottom:20px; font-size:15px; color: #999999"
						name="bookwriter"><br> <font size="3px"
						style="margin-right:50px; color:#999999;">价格:</font><input
						type="text"
						style="margin-right: 100px;margin-bottom:20px; font-size:15px; color: #999999"
						name="bookprice"><br> <font size="3px"
						style="margin-right:50px; color:#999999;">出版社:</font><input
						type="text"
						style="margin-right: 100px;margin-bottom:20px; font-size:15px; color: #999999"
						name="bookplace"><br> <font size="3px"
						style="margin-right:50px; color:#999999;">数量:</font><input
						type="text" name="bookcount"
						style="margin-right: 100px;margin-bottom:20px; font-size:15px; color: blue"><br>
					<input type="button" id="go"
						style="margin-right: 100px;margin-bottom:20px; font-size:15px; color: #999999"
						value="提交"><br>
					<div align="center">
						<font size="4px" style="margin-right:200px; color:red;"><s:fielderror></s:fielderror></font>
					</div>
				</form>
				<script>
		    	var loginForm = document.getElementById('form1');
		    	var go = document.getElementById('go');
		    	go.onclick = function(){
		        var count = loginForm.bookcount.value
		        //这里判断了输入不能大于100
		        var reg = /^[0-9]+.?[0-9]*$/;
		        if(!reg.test(count)){
		        	alert('输入格式不正确');
		        }
		        else if(count>100){
		            //验证通过，提交表单数据
		            alert('购买书籍不能超过100');
		        }else if(count==0){
		            alert('数量不能为空');
		        }else{
		            loginForm.submit();		        	   
		   		}
		   		}
				</script>
			</div>
		</div>

	</div>

</body>
</html>