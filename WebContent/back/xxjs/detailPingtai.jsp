<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/sl.css">

<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.12.1.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery.validate.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/layer/layer.js"></script>
<script type="text/javascript">
	$(function() {
		$("p > span,p").css("background-color", "");
	})
</script>
<title>平台信息详情</title>
</head>
<body>
	<div class="nav">
		您现在的位置：
		<ul class="nav-ul">
			<li class="nav-li"><a
				href="${pageContext.request.contextPath }/back/welcome.jsp">首页</a></li>
			<li class="nav-li"><a href="javascript:void(0)" onclick="back()">找平台</a></li>
			<li class="nav-li"><a href="javascript:void(0)">平台信息</a></li>
		</ul>
	</div>
	<div>
		<br> <br>
		<table class='table'>
			<caption>平台信息详情</caption>
			<tr>
				<td class="title" width="100px">单位名称</td>
				<td>${FwptBean.mc}</td>
			</tr>
			<tr>
				<td class="title">平台类型</td>
				<td>${FwptBean.km }</td>
			</tr>
			<tr>
				<td class="title">联系人</td>
				<td>${FwptBean.lxr }</td>
			</tr>
			<tr>
				<td class="title">地址</td>
				<td>${FwptBean.dz }</td>
			</tr>
			<tr>
				<td class="title">关键词</td>
				<td>${FwptBean.gjc }</td>
			</tr>
			<tr>
				<td class="title">电话</td>
				<td>${FwptBean.dh }</td>
			</tr>
		</table>
		<div align="center">
			<br>
			<br>
			<input type="button" value="确定" onclick="back()">

		</div>
		<script type="text/javascript">
			function back() {
				url = "${pageContext.request.contextPath}/back/xxjs/xxjsServlet?method=searchPingtai&msg=7";
				location.href = url;
			}
		</script>
	</div>
</body>
</html>