<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加专题库</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/sl.css">

<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.12.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.validate.js"></script>

<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/lhgcalendar.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/lhgcore.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/lhgcalendar.js"></script>

<link href="${pageContext.request.contextPath}/ueditor/themes/default/css/ueditor.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="${pageContext.request.contextPath}/ueditor/ueditor.config.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/ueditor/ueditor.all.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/ueditor/ueditor.all.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/ueditor/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/layer/layer.js"></script>
<style type="text/css">
	td.label,td.input{
		vertical-align: middle;
	}
	.no-border{
		border:0px;
	}
	.no-border td{
		border: 0px;
	}
	td:FIRST-CHILD{
		text-align: left;
	}
	.input input{
		box-sizing:border-box;
		width: 100%;
	}
</style>
</head>
<body>
<div>
		<div class="nav">
			您现在的位置：
			<ul class="nav-ul">
				<li class="nav-li"><a href="#">专题专利</a></li>
				<li class="nav-li"><a href="#">添加专利库</a></li>
			</ul>
		</div>
<div align="center">
<c:if test="${library==null }">
	<c:set var="url" value="libraryServlet?method=add&result=add" scope="page"/>
</c:if>
<c:if test="${library!=null }">
	<c:set var="url" value="libraryServlet?method=add&result=list" scope="page"/>
</c:if>
	<form action="${url }" method="post">
	<c:if test="${library!=null }"><input type="hidden" name="id" value="${library.id }"></c:if>
		<table class="form-table no-border">
			<caption>添加专题库</caption>
			<tr>
				<td class='label' width="120px"><label for="title">专题库名称：</label>
				<td class='input' colspan="2">
					<input type="text" id='title' name="title" value="${library.title }"  placeholder="请输入专题库名称" autofocus="autofocus" maxlength="50">
				</td>
			</tr>
			<tr>
				<td class='label'><label for="publisher">发布人：</label>
				<td class='input' colspan="2">
					<input type="text" name="publisher" value="${library.publisher }" placeholder="请输入发布人" maxlength="10">
				</td>
			</tr>
			<tr>
				<td class='label'><label for="date">发布时间：</label>
				<td class='input' colspan="2">
					<input type="text" id='date' name="date" onclick="J.calendar.get({id:'date'});" value="${library.date }" readonly="readonly" placeholder="点击选择日期">
				</td>
			</tr>
			<tr>
				<td colspan="4" class='label'><label>专利库简介：</label></td>
			</tr>
			<tr>
				<td height="23" colspan="4" class='input'>
					<textarea id="zlkjj" name="intro" style="width:90%;height:200px">${library.intro }</textarea>
				</td>
			</tr>
		</table>
		<br><br><input type="submit" value="提交"><br><br><br>
	</form>
	
	
</div>
</div>
</body>
<script type="text/javascript">
		var global = {
				rootpath:"${pageContext.request.contextPath}",
				library: {
					title:"${library.title}"
				}
		}
</script>
<script type="text/javascript" src="add_lib.js"></script>
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
</html>