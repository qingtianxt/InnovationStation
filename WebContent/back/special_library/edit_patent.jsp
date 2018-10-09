<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/sl.css">

<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.12.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.validate.js"></script>

<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/lhgcalendar.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/lhgcore.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/lhgcalendar.js"></script>
<title>编辑专利信息</title>
<style>
	input[type='text'],textarea{
		width:100%;
		box-sizing: border-box;
	}
	td.label{
		width:100px;
		text-align: left;
	}
</style>
</head>
<body>
<div><div class="nav">
	您现在的位置：
	<ul class="nav-ul">
		<li class="nav-li"><a href="#">专题专利</a></li>
		<li class="nav-li"><a href="javascript:back()">专利管理</a></li>
		<li class="nav-li"><a href="#">编辑专利</a></li>
	</ul>
	</div>
<c:if test="${requestScope.patent !=null }"><c:set var="url" value="patentServlet?method=save&result=list"/></c:if><c:if test="${requestScope.patent ==null }"><c:set var="url" value="patentServlet?method=save&result=save"/></c:if>
<form action="${url }" method="post">
	<input type="hidden" value="${requestScope.patent.id }" name="id">
	<table class='form-table' style="margin:auto">
		<caption>编辑专利信息</caption>
		<tr>
			<td class='label'><label for="zlh">专利号:</label></td>
			<td class='input' ><input name="zlh" type='text' value="${requestScope.patent.zlh }" required></td>
			<td class='label'><label for="sqrq">申请日期:</label></td>
			<td class='input'><input name="sqrq" type='text' value="${requestScope.patent.sqrq }"></td>
		</tr>
		<tr>
			<td class='label'><label for="gkh">公开号:</label></td>
			<td class='input' ><input name="gkh" type='text' value="${requestScope.patent.gkh}"></td>
			<td class='label'><label for="gkr">公开日:</label></td>
			<td class='input' ><input name="gkr" type='text' value="${requestScope.patent.gkr}"></td>
		</tr>
		<tr>
			<td class="label"><label for="fmmc">发明名称:</label></td>
			<td class="input"><input name="fmmc" type='text' value="${requestScope.patent.fmmc }">
			<td class="label"><label for="ipc_flh">IPC分类号:</label></td>
			<td class="input"><input name="ipc_flh" type='text' value="${requestScope.patent.ipc_flh}">
		</tr>		
		<tr>
			<td class="label"><label for="fmr">发明人:</label></td>
			<td class="input"><input name="fmr" type='text' value="${requestScope.patent.fmr}">
			<td class="label"><label for="sqr">申请人:</label></td>
			<td class="input"><input name="sqr" type='text' value="${requestScope.patent.sqr}">
		</tr>		
		<tr>
			<td class="label"><label for="yxqr">优先权日:</label></td>
			<td class="input"><input name="yxqr" type='text' value="${requestScope.patent.yxqr}">
			<td class="label"><label for="yxqh">优先权号:</label></td>
			<td class="input"><input name="yxqh" type='text' value="${requestScope.patent.yxqh}">
		</tr>		
		<tr>
			<td class="label"><label for="flzt">法律状态:</label></td>
			<td class="input"><input name="flzt" type='text' value="${requestScope.patent.flzt}">
			<td class="label"><label for="sqrdz">申请人地址:</label></td>
			<td class="input"><input name="sqrdz" type='text' value="${requestScope.patent.sqrdz}">
		</tr>	
		<tr>
			<td class="label"><label for="zy">摘要:</label></td>
			<td class="" colspan="3">
				<textarea name="zy" rows="" style="height:200px;text-align:left;font-size: 16px" cols="">
					${fn:trim(requestScope.patent.zy) }</textarea>
			</td>
		</tr>	
<!-- 		<tr> -->
<!-- 			<td class="input" colspan='4'> -->
<!-- 				</td> -->
<!-- 		</tr> -->
	</table>
	<div align="center">
	<br><br><br>
		<input type="button" value="取消" onclick="back()"><input type="submit" value="保存"><br><br>
	</div>
</form>

</div>
</body>
<script type="text/javascript">
	function back(){
		var url = "${pageContext.request.contextPath}/back/patent/patentServlet?method=list&result=list&msg=7";
		location.href = url;
	}
</script>
</html>