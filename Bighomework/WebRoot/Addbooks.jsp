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
 
file
="../css/index.css"
 
%>
</style>
<!-- 导入js文件 -->
<script type="application/javascript" src="../js/jquery-1.9.1.min.js"></script>
<script type="application/javascript" src="../js/bootstrap.min.js"></script>
<script src="../js/ie-emulation-modes-warning.js"></script>
<script src="../js/jquery.min.js"></script>
<script src="../js/holder.min.js"></script>
<script src="../js/ie10-viewport-bug-workaround.js"></script>

<script type="text/javascript">
    
        function validate()
        {
            var page = document.getElementsByName("page")[0].value;
                
            if(page > "<s:property value='%{#request.pageBean.totalPage}'/>")
            {
                alert("你输入的页数大于最大页数，页面将跳转到首页！");
                
                window.document.location.href = "addbooks";                
                return false;
            }           
            return true;
        }    
    </script>
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
			<br> <br> <br>
			<div class="col-md-8">
				<h2 class="sub-header">购入教材</h2>
				<div class="table-responsive">
					<table class="table table-striped">
						<thead>
							<tr>
								<th>编号：</th>
								<th>书名：</th>
								<th>作者：</th>
								<th>价格：</th>
								<th>出版社：</th>
								<th>剩余数量：</th>
								<th>操作：</th>
							</tr>
							<s:iterator value="#session.addbooks" var="book">
								<s:if test="#book.bookcount<=5">
									<tr style="color: red">
								</s:if>
								<s:else>
									<tr>
								</s:else>
								<td><s:property value="#book.id" /></td>
								<td><s:property value="#book.bookname" /></td>
								<td><s:property value="#book.bookwriter" /></td>
								<td><s:property value="#book.bookprice" /></td>
								<td><s:property value="#book.bookplace" /></td>
								<td><s:property value="#book.bookcount" /></td>
								<td><a
									href="showselectedbook.action?bookid=<s:property value="#book.id"/>">购入图书</a></td>
								</tr>
							</s:iterator>
						</thead>
						<tbody>
						</tbody>
					</table>
					<center>

						<font size="4">当前<font color="red"><s:property
									value="#request.pageBean.currentPage" /></font>页
						</font>&nbsp;&nbsp; <font size="4">共<font color="red"><s:property
									value="#request.pageBean.totalPage" /></font>页
						</font>&nbsp;&nbsp; <font size="4">共<font color="red"><s:property
									value="#request.pageBean.allRows" /></font>条记录
						</font><br> <br>

						<s:if test="#request.pageBean.currentPage == 1">
            首页&nbsp;&nbsp;&nbsp;上一页
        </s:if>

						<s:else>
							<a href="addbooks.action">首页</a>
            &nbsp;&nbsp;&nbsp;
            <a
								href="addbooks.action?page=<s:property value="#request.pageBean.currentPage - 1"/>">上一页</a>
						</s:else>

						<s:if
							test="#request.pageBean.currentPage != #request.pageBean.totalPage">
							<a
								href="addbooks.action?page=<s:property value="#request.pageBean.currentPage + 1"/>">下一页</a>
            &nbsp;&nbsp;&nbsp;
            <a
								href="addbooks.action?page=<s:property value="#request.pageBean.totalPage"/>">尾页</a>
						</s:if>

						<s:else>
            下一页&nbsp;&nbsp;&nbsp;尾页
        </s:else>

					</center>
					<br>

					<center>

						<form action="addbooks" onsubmit="return validate();">
							<font size="4">跳转至</font> <input type="text" size="2" name="page">页
							<input type="submit" value="跳转">
						</form>

					</center>
				</div>
			</div>

		</div>

	</div>

</body>
</html>