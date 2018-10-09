<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/sl.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.12.1.js"></script>
<script type="text/javascript">
	$(function(){
		$("p > span,p").css("background-color","");
	})
</script>
<title>新闻详情</title>
<style type="text/css">
.table {
	border-collapse:collapse;  
}

.table tr {
	
}

.table tr td {
	text-align: left;
	height: 30px;
}

.table tr td input {
	height: 20px;
	width: 60%;
}
</style>

</head>
<body bgcolor="#DDF2FC">
<div>
	<div class="nav">
			您现在的位置：
			<ul class="nav-ul">
				<li class="nav-li"><a href="${pageContext.request.contextPath }/back/welcome.jsp">首页</a></li>
				<li class="nav-li"><a href="javascript:void(0)"  onclick="back()">找新闻</a></li>
				<li class="nav-li"><a href="javascript:void(0)">新闻信息</a></li>
			</ul>
		</div>
		<div class="table" align="center" >
		<br><br><br><br>
		<table border="1" style="width:800px">
		  <tr>
		    <td width="90">发布人：</td>
		    <td colspan="3">${newsBean.publisher }</td>
	      </tr>
		  <tr>
		    <td>发布时间：</td>
		    <td colspan="3">${newsBean.time }</td>
	      </tr>
		  <tr>
		    <td>标题：</td>
		    
		    <td colspan="3">${newsBean.title }</td>
	      </tr>
		  <tr>
		    <td>类型：</td>
		    <td colspan="3">${newsBean.type }</td>
	      </tr>
		  <tr>
		    <td colspan="4" height="38"><div align="left">内容：</div></td>
	      </tr>
		  <tr>
		    <td colspan="4">${newsBean.content }
			</td>
	      </tr>
	  </table>
</div>
	<br><br><br><br>
	<div align="center">
	<input style="margin:auto" type="button" value="确定" onclick="back()" >
	</div>
	<br><br><br><br>
	<script type="text/javascript">
		function back(){
			location.href = "${pageContext.request.contextPath}/back/xxjs/xxjsServlet?method=searchNews&msg=7";
		}
	</script>
</div>
</body>
</html>