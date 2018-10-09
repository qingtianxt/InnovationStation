<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>成功案例</title>
<!-- css  js文件链接 -->
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.4.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/lhgcore.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/lhgcalendar.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.9.1.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/sl.css">
<!-- 上传信息 -->
<!-- css  js文件链接 -->
<style type="text/css">
.table {
	
}

.table tr {
	
}

.table tr td {
	text-align: left;
	height: 30px;
}

.table tr td input {
	height: 20px;
	width: 98%;
}
</style>
<body bgcolor="#DDF2FC">
	<div class="nav">
		您现在的位置：
		<ul class="nav-ul">
			<li class="nav-li"><a
				href="${pageContext.request.contextPath }/back/welcome.jsp">首页</a></li>
			<li class="nav-li"><a href="javascript:void(0)" onclick="back()">找成果</a></li>
			<li class="nav-li"><a href="javascript:void(0)">案例信息</a></li>
		</ul>
	</div>
	<div class="table" align="center">
		<h1>成功案例库</h1>
		<table width="800" border="1" style="border-collapse: collapse;"
			class="form-table">
			<tr>
				<td width="100"><div align="center">案例名称</div></td>
				<td width="700">${cgalBean.mc }</td>
			</tr>
			<tr>
				<td><div align="center">所在地</div></td>
				<td>${cgalBean.szd }</td>
			</tr>
			<tr>
				<td><div align="center">单位</div></td>
				<td>${cgalBean.dw }</td>
			</tr>
			<tr>
				<td><div align="center">关键词</div></td>
				<td>${cgalBean.gjc }</td>
			</tr>
			<tr>
				<td colspan="2"><div align="center">案例内容</div></td>
			</tr>
			<tr>
				<td colspan="2">${cgalBean.nr }</td>
			</tr>
		</table>
		<br> <br> <br> <br>

	</div>
	<br>
	<br>
	<br>
	<br>
	<div align="center">
		<input style="margin: auto" type="button" value="确定" onclick="back()">
	</div>
	<br>
	<br>
	<br>
	<br>
	<script type="text/javascript">
		function back() {
			location.href = "${kjcgPagingBean.preUrl}" + "&msg=7"
		}
	</script>
</body>
</html>