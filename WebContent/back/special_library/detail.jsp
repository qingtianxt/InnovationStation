<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/sl.css">

<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.12.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.validate.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/layer/layer.js"></script>
<script type="text/javascript">
	$(function(){
		$("p > span,p").css("background-color","");
	})
</script>
<title>专题库详情</title>
</head>
<body>
<div>
<div class="nav">
	您现在的位置：
	<ul class="nav-ul">
		<li class="nav-li"><a href="#">专题专利</a></li>
		<li class="nav-li"><a href="JavaScript:back()">专题库管理</a></li>
		<li class="nav-li"><a href="#">专题库详情</a></li>
	</ul>
	</div>
	<table class='table'>
		<caption>专题库详情</caption>
		<tr>
			<td class="title" width="100px">专题库名称</td>
			<td >${requestScope.library.title }</td>
		</tr>
		<tr>
			<td class="title">发布人</td>
			<td >${requestScope.library.publisher }</td>
		</tr>
		<tr>
			<td class="title">发布时间</td>
			<td >${requestScope.library.date }</td>
		</tr>
		<tr>
			<td colspan="2" class='title' style="text-align:center">专题库简介</td>
		</tr>
		<tr>
			<td colspan='2' style="text-align:left"><p>${requestScope.library.intro }</p></td>
		</tr>
	</table>
	<div align="center">
		<br><br><input type="button" value="确定" onclick="back()" >
				<input type="button" value="修改" onclick="javascript:edit(${requestScope.library.id})">
				<input type="button" value="删除" onclick="javascript:del(${requestScope.library.id})">
		
	</div>
	<script type="text/javascript">
		function del(id){
			layer.open({
				content : '你确定要删除吗?',
				btn : [ '确认', '取消' ],
				yes : function(index, layero) {
					location.href =  "libraryServlet?method=del&id="+id;
				},
				btn2 : function(index, layero) {

				},
				cancel : function() {
					//右上角关闭回调  
				}
			});
		}
		function edit(id){
			location.href="libraryServlet?method=getLib&result=edit&id="+id;
		}
		function back(){
			location.href="${pageContext.request.contextPath}/back/special_library/libraryServlet?method=list&result=list&msg=7";
		}
	</script>
</div>
</body>
</html>