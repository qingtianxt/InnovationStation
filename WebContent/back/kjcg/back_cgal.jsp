<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<!-- 上传信息 -->
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/kjcg/back_cgal.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/layer/layer.js"></script>
		<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/sl.css">
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
	width: 99%;
}
</style>
<body bgcolor="#DDF2FC">
<div class="nav">
			您现在的位置：
			<ul class="nav-ul">
			<li class="nav-li"><a href="javascript:void(0)">科技成果</a></li>
				<li class="nav-li"><a href="javascript:void(0)">添加成功案例</a></li>
			</ul>
		</div>
	<div class="table" align="center">
		<h1>成功案例库</h1>
		<form
			action="${pageContext.request.contextPath }/back/kjcg/cgalServlet?method=add"
			method="post" id="checkForm">
			<table width="800" border="1" style="border-collapse: collapse;">
				<tr>
					<td width="100"><div align="center">案例名称&nbsp;&nbsp;<font style="color: red">*</font> </div></td>
					<td width="700"><input id="almc" name="mc" type="text" /></td>
				</tr>
				<tr>
					<td><div align="center">所在地</div></td>
					<td><input id="szd" name="szd" type="text" /></td>
				</tr>
				<tr>
					<td><div align="center">单位&nbsp;&nbsp;<font style="color: red">*</font> </div></td>
					<td><input id="dw" name="dw" type="text" /></td>
				</tr>
				<tr>
					<td><div align="center">关键词&nbsp;&nbsp;<font style="color: red">*</font> </div></td>
					<td><input id="gjc" name="gjc" type="text" /></td>
				</tr>
				<tr>
					<td colspan="2"><div align="center">案例内容</div></td>
				</tr>
				<tr>
					<td colspan="2"><textarea id="alnr" name="nr"
							style="width: 800px; height: 200px"></textarea></td>
				</tr>
			</table>

			<br> <br> <br> <br>
			<div align="center">
				<input type="button" id="upload" value="保存"
					style="hight: 80px; width: 100px">
			</div>
		</form>
	</div>

	<br>
	<br>
	<br>
	<br>
		<c:if test="${not empty msg }">
		<script type="text/javascript">
			$(function() {
				layer.alert('${msg}', {
					skin : 'layui-layer-lan' //样式类名
					,
					closeBtn : 0
				});

			})
		</script>
	</c:if>

</body>
</html>