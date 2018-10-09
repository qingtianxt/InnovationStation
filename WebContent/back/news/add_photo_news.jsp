<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加图片新闻</title>
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
<script type="text/javascript">
	var global = {
			rootpath : "${pageContext.request.contextPath}",
			newsPhoto : {
				title : "${newsPhoto.title}"
			}
	}
</script>
<script type="text/javascript" src="add_photo_news.js"></script>
<style>
	input[type='text'] ,input[type='file']{
		box-sizing: border-box;
		width: 100%;
		padding:5px ;
	}
	td{
		padding:3px 0px;
		font-size: 16px;
		font-weight: bold;
	}
</style>

</head>
<body>
	<div class="nav">
		您现在的位置：
		<ul class="nav-ul">
			<li class="nav-li"><a href="#">新闻管理</a></li>
			<li class="nav-li"><a href="#">添加图片新闻</a></li>
		</ul>
	</div>

	<!-- 添加新闻        start-->
	<div class="insert_news">
		<c:if test="${empty newsPhoto }">
			<c:set scope="page" value="newsPhotoServlet?method=save&result=add"
				var="url"></c:set>
		</c:if>
		<c:if test="${!empty newsPhoto }">
			<c:set scope="page"
				value="newsPhotoServlet?method=save&result=update&id=${newsPhoto.id }"
				var="url"></c:set>
		</c:if>
		<form action="${url }" method="post" enctype="multipart/form-data"
			name="form1" onsubmit="return sub(this)">
			<input type="hidden" value="${newsPhoto.id }" name="id"> <input
				type="hidden" value="${sessionScope.session_user.username }"
				name="username">
			<table style="width: 680px; margin: auto">
				<caption style="font-size: 25px; margin: 15px">添加图片新闻</caption>
				<tr>
					<td width="75" height="25"><span class="STYLE4 required">发布人:</span></td>
					<td height="25" colspan="4"><input name="publisher"
						placeholder="请输入新闻发布人" type="text" id="Publisher" size="50"  
						value="${newsPhoto.publisher }"
						autofocus="autofocus"></td>
				</tr>
				<tr>
					<td width="75" height="25"><span class="STYLE4 required">发布时间:</span></td>
					<td height="25" colspan="4"><input name="time" type="text"
						id="Time" placeholder="请选择发布时间" size="50" maxlength="50"
						onclick="J.calendar.get({id:'Time'});" readonly="readonly"
						value="${newsPhoto.time }"></td>
				</tr>
				<tr>
					<td width="75" height="25"><span class="STYLE4 required">新闻标题:</span></td>
					<td height="25" colspan="4"><input name="title" type="text"
						id="Title" size="50" placeholder="请输入新闻标题" maxlength="50"
						value="${newsPhoto.title }"></td>
				</tr>
				<tr>
					<td width="75" height="25"><span class="STYLE4 required">图片路径:</span></td>
					<td height="25" colspan="4"><input name="image" type="file"
						id="file" size="50" >
				</tr>
				<tr>
					<td width="75" height="25"><span class="STYLE4 required">新闻内容:</span></td>
					<td width="108" height="25">&nbsp;</td>
				</tr>
				<tr>
					<td colspan="6"><label> <textarea name="content"
								id="content1" cols="100" rows="1000"
								style="width: 700px; height: 200px;">${newsPhoto.content }</textarea>
					</label></td>
				</tr>
				<tr>
					<td style="text-align: right" colspan="6"><br> <input
						type="submit" name="Submit" id="sc" value="提交"> <input
						name="Reset" type="reset" id="Reset" value="重置"></td>
				</tr>
			</table>
		</form>
		<br>
		<br>
		<br>
		<br>
	</div>
	<script type="text/javascript">
			var editor = new UE.ui.Editor();
			editor.render("content1");
		</script>
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