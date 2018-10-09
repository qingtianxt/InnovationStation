<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加合作站点</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.12.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.validate.js"></script>

<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/lhgcalendar.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/lhgcore.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/lhgcalendar.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/sl.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/layer/layer.js"></script>
<script type="text/javascript">
	var global = {
			rootpath:"${pageContext.request.contextPath}",
			site:{title:"${site.name}"},
			msg :"${param.msg}"
	}
</script>
<script type="text/javascript"  src="add_site.js"> </script>
<style>
td.label, td.input {
	vertical-align: middle;
}
.input input,.input select{
	width:100%;
	box-sizing: border-box;
}
.no-border{
	border: 0px;
}
.no-border td{
	border:0px;
}
</style>
</head>
<body>
	<div>
	<div class="nav">
	您现在的位置：
	<ul class="nav-ul">
		<li class="nav-li"><a href="#">合作站点</a></li>
		<li class="nav-li"><a href="#">添加站点</a></li>
	</ul>
	</div>
		<div>
			<form action="coopSiteServlet" method="post">
				<c:if test="${site==null }">
					<input type="hidden" value="add" name="method">
					<input type="hidden" value="add" name="result">
				</c:if>
				<c:if test="${site!=null }">
					<input type="hidden" value="add" name="method">
					<input type="hidden" value="list" name="result">
					<input type="hidden" value="${requestScope.site.id }" name="id">
				</c:if>
				<table class="form-table no-border" style="width: 600px">
					<caption>添加合作站点</caption>
					<tr>
						<td class='label required' width="50"><label for="name">标题</label></td>
						<td class='input' colspan="3"><input type="text" id="siteName" name="name"
							value="${requestScope.site.name }" placeholder="请输入标题"
							autofocus="autofocus">
					</tr>
					<tr>
						<td class='label required'><label for="link">网址</label></td>
						<td class='input' colspan="3"><input type="url" name="link"
							value="${requestScope.site.link }" placeholder="请输入网址">
					</tr>
					<tr>
						<td class='label'><label for="type">分类</label></td>
						<td class='input' colspan="3"><select name="type">
								<option
									<c:if test="${requestScope.site.type.equals('区域站点') }">selected="selected"</c:if>>区域站点
								
								<option
									<c:if test="${requestScope.site.type.equals('基础站点') }">selected="selected"</c:if>>基础站点
								
								<option
									<c:if test="${requestScope.site.type.equals('合作站点') }">selected="selected"</c:if>>合作站点
								
						</select>
					</tr>
				</table>
				<div align="center">
					<br>
					<br>
					<input type="submit" value="提交"><br>
					<br>
				</div>
			</form>
		</div>
		
	</div>
</body>
</html>