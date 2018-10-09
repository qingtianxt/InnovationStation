<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.12.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.validate.js"></script>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/sl.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/lhgcalendar.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/lhgcore.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/lhgcalendar.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/sl.css">
<!-- ueditor编辑器需要引入的文件 -->
<link href="${pageContext.request.contextPath}/ueditor/themes/default/css/ueditor.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="${pageContext.request.contextPath}/ueditor/ueditor.config.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/ueditor/ueditor.all.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/ueditor/ueditor.all.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/ueditor/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/layer/layer.js"></script>
<title>添加新闻</title>

<style type="text/css">
td input, td select {
	width: 100%;
	padding: 5px;
	box-sizing: border-box;
}
td{
	font-size: 16px;
	padding: 5px 0px;
}
td:FIRST-CHILD {
	font-weight: bold;
}

</style>
</head>
<body>
<div class="nav">
	您现在的位置：
	<ul class="nav-ul">
		<li class="nav-li"><a href="#">新闻管理</a></li>
		<li class="nav-li"><a href="#">添加新闻</a></li>
	</ul>
</div>
	<c:if test="${empty newsBean }">
		<c:set scope="page" value="newsServlet?method=save&result=add"
			var="url"></c:set>
	</c:if>
	<c:if test="${!empty newsBean }">
		<c:set scope="page"
			value="newsServlet?method=save&result=update&id=${newsBean.id }"
			var="url"></c:set>
	</c:if>
	<div class="" align="center">
		<h1>新闻公告库</h1>
		<form action="${url }" method="post" id="form1">
			<input type="hidden" value="${sessionScope.session_user.username }"
				name="username"> <input type="hidden"
				value="${requestScope.newsBean.id }" name="id">
			<table style="width: 800px; border: 0px">
				<tr>
					<td width="100px" class="required">发布人：</td>
					<td colspan="2" width="500px"><input
						value="${newsBean.publisher }" name="publisher" type="text"
						id="Publisher" size="50" placeholder="请输入新闻发布人"
						autofocus="autofocus"></td>
					<td width="200px"></td>
				</tr>
				<tr>
					<td class="required">发布时间：</td>
					<td colspan="2"><input name="time" type="text" id="Time"
						size="50" maxlength="50" onclick="J.calendar.get({id:'Time'});"
						placeholder="请选择发布时间" readonly="readonly"
						value="${newsBean.time }"></td>
					<td></td>
				</tr>
				<tr>
					<td class="required">标题：</td>
					<td colspan="2"><input name="title" type="text" id="Title"
						size="50" placeholder="请输入新闻标题"
						value="${requestScope.newsBean.title }"></td>
					<td>
				</tr>
				<tr>
					<td>类型：</td>
					<td colspan="2"><select name="type" id="Type">
							<option value="国内新闻"
								<c:if test="${newsBean.type.equals('国内新闻') }">selected="selected"</c:if>>国内新闻</option>
							<option value="通知公告"
								<c:if test="${newsBean.type.equals('通知公告') }">selected="selected"</c:if>>通知公告</option>
					</select></td>
				</tr>
				<tr>
					<td colspan="4" class="required">内容：</td>
				</tr>
				<tr>
					<td colspan="4"><textarea name="content" id="content1"
							cols="100" rows="100" style="width: 796px; height: 200px;">${requestScope.newsBean.content }</textarea>
					</td>
				</tr>
			</table>
			<script type="text/javascript">
				
			</script>
			<br>
			<br>
			<div align="center">
				<input id="upload" type="submit" value="保存"
					style="hight: 80px; width: 100px">
			</div>
		</form>
	</div>
	<br>
	<br>
	<br>
	<br>
	
</body>
<script type="text/javascript">
	var global = {
			rootpath : "${pageContext.request.contextPath}",
			msg:"${param.msg}",
			newsBean:{
				title:"${requestScope.newsBean.title}"
			}
	};
</script>
<script type="text/javascript" src="add_news.js"></script>
</html>