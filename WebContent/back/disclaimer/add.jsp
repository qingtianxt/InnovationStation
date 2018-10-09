<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/sl.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.12.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.validate.js"></script>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/lhgcalendar.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/lhgcore.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/lhgcalendar.js"></script>
<!-- ueditor编辑器需要引入的文件 -->
<link href="${pageContext.request.contextPath}/ueditor/themes/default/css/ueditor.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="${pageContext.request.contextPath}/ueditor/ueditor.config.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/ueditor/ueditor.all.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/ueditor/ueditor.all.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/ueditor/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/layer/layer.js"></script>

<script type="text/javascript">
<!--
	window.onload = function() {
		var editor = new UE.ui.Editor();
		editor.render("content1");
	}
	function validate(form) {
		if (form.time.value == "") {
			layer.alert('请选择发布时间！', {
				skin : 'layui-layer-lan' //样式类名
				,
				closeBtn : 0
			});
			return false;
		}
		if (form.publisher.value.length > 25) {
			layer.alert('发布人长度不能超过25个字符！', {
				skin : 'layui-layer-lan' //样式类名
				,
				closeBtn : 0
			});
			return false;
		}
	}
	-->
</script>
<style>
table input[type='text'], table textarea {
	width: 100%;
	padding: 5px;
	box-sizing: border-box;
}

td:FIRST-CHILD {
	font-weight: bold;
}
 
</style>
<title>添加免责声明</title>
</head>
<body bgcolor="#DDF2FC">
	<div class="nav">
		您现在的位置：
		<ul class="nav-ul">
			<li class="nav-li"><a href="#">用户管理</a></li>
			<li class="nav-li"><a href="#">添加免责声明</a></li>
		</ul>
	</div>
	<div class="" align="center">
		<h1>免责声明</h1>
		<form
			action="${pageContext.request.contextPath}/back/disclaimer/disclaimerServlet?method=add&result=add"
			onsubmit="return validate(this)" method="post">
			<table width="800" border="0" class="form-table">
				<tr>
					<td width="90" class="required">发布人：</td>
					<td colspan="3"><input readonly
						value="${sessionScope.session_user.username }" name="publisher"
						type="text" id="Publisher" size="50" maxlength="50"></td>
				</tr>
				<tr>
					<td class="required">发布时间：</td>
					<td colspan="3"><input name="time" type="text" id="Time"
						size="50" maxlength="50" onclick="J.calendar.get({id:'Time'});"
						readonly="readonly"></td>
				</tr>
				<tr>
					<td class="required" colspan="4" style="text-align: left;">内容：</td>
				</tr>
				<tr>
					<td colspan="4"><textarea name="content" id="content1"
							cols="100" rows="1000"></textarea></td>
				</tr>
			</table>
			<br> <br> <br> <br>
			<div align="center">
				<input id="uploadmzsm" type="submit" value="保存"
					style="hight: 80px; width: 100px">
			</div>
		</form>
	</div>
	<br>
	<br>
	<br>
	<br>
	<c:if test="${param.msg.equals('1') }">
		<script type="text/javascript">
			$(function() {
				layer.alert('添加成功', {
					skin : 'layui-layer-lan' //样式类名
					,
					closeBtn : 0
				});

			})
		</script>
	</c:if>
	<c:if test="${param.msg.equals('2') }">
		<script type="text/javascript">
			$(function() {
				layer.alert('添加失败', {
					skin : 'layui-layer-lan' //样式类名
					,
					closeBtn : 0
				});

			})
		</script>
	</c:if>
</body>

</html>