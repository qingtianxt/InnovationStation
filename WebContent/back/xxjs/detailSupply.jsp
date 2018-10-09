<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/sl.css">
<title>技术供给详情</title>
<style type="text/css">
caption {
	font-size: xx-large;
	font-weight: bold;
	margin-bottom: 15px;
}

.label {
	font-weight: bold;
	text-align: center;
}

p {
	margin: 25px 15px;
	text-indent: 2em;
}
</style>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/js/sl.css">
</head>
<body>
	<div class="nav">
		您现在的位置：
		<ul class="nav-ul">
			<li class="nav-li"><a
				href="${pageContext.request.contextPath }/back/welcome.jsp">首页</a></li>
			<li class="nav-li"><a href="javascript:void(0)" onclick="goBack()">找技术</a></li>
			<li class="nav-li"><a href="javascript:void(0)">技术信息</a></li>
		</ul>
	</div>
	<div class="table" align="center">
		<br>
		<table style="width: 800px; height: 549px; border-collapse: collapse;"
			border="1">
			<caption>技术详情</caption>
			<tr height="36">
				<td width="120" class="label">技术名称</td>
				<td width="260">${supply.mc }</td>
				<td width="120" class="label">技术水平</td>
				<td width="260">${supply.sp }</td>
			</tr>
			<tr height="36">
				<td><div align="center" class="label">批准登记号</div></td>
				<td>${supply.djh }</td>
				<td><div align="center" class="label">应用状态</div></td>
				<td>${supply.yyzt }</td>
			</tr>
			<tr height="36">
				<td><div align="center" class="label">是否专利技术</div></td>
				<td>${supply.sfzl }</td>
				<td><div align="center" class="label">联系人</div></td>
				<td>${supply.lxr }</td>
			</tr>
			<tr height="36">
				<td><div align="center" class="label">专利号</div></td>
				<td>${supply.zlh }</td>
				<td><div align="center" class="label">联系人电话</div></td>
				<td>${supply.dh }</td>
			</tr>
			<tr height="36">
				<td><div align="center" class="label">所属高新技术类别</div></td>
				<td>${supply.jslb }</td>
				<td><div align="center" class="label">登记日期</div></td>
				<td>${supply.djrq }</td>
			</tr>
			<tr height="36">
				<td><div align="center" class="label">技术所处阶段</div></td>
				<td>${supply.jd }</td>
				<td><div align="center" class="label">年份</div></td>
				<td>${supply.nf }</td>
			</tr>
			<tr height="36">
				<td><div align="center" class="label">技术属性</div></td>
				<td>${supply.cgsx }</td>
				<td><div align="center" class="label">专利状态</div></td>
				<td>${supply.zlzt }</td>
			</tr>
			<tr height="36">
				<td><div align="center" class="label">技术体现形式</div></td>
				<td colspan="3">${supply.xs }</td>
			</tr>
			<tr height="36">
				<td><div align="center" class="label">技术供给单位</div></td>
				<td colspan="3" align="left">${supply.dw }</td>
			</tr>
			<tr height="36">
				<td height="35"><div align="center" class="label">通讯地址</div></td>
				<td colspan="3" align="left">${supply.dz }</td>
			</tr>
			<tr height="36">
				<td><div align="center" class="label">关键词</div></td>

				<td colspan="3" align="left">${supply.gjc }</td>
			</tr>
			<tr>
				<td colspan="4" height="36" class="label">项目简介</td>
			</tr>
			<tr>

				<td height="107" colspan="4"><p>${supply.gbnr }</p></td>
			</tr>
			<tr>
				<td colspan="4" height="36" class="label">审核意见</td>
			</tr>
			<tr>
				<td height="107" colspan="4"><p>${supply.shyj }</p></td>
			</tr>
		</table>
		<br>
		<br> <input style="margin: auto" onclick="goBack()" type="button"
			value="确定"> <br>
		<br>
		<br>
		<br>
		<br>
		<c:if test="${supply.sh==0 }">
			<c:set var="result" value="list"></c:set>
		</c:if>
		<c:if test="${supply.sh!=0 }">
			<c:set var="result" value="list2"></c:set>
		</c:if>
		<script type="text/javascript">
			function goBack() {
				window.location.href = "${pageContext.request.contextPath}/back/xxjs/xxjsServlet?method=searchJishu&msg=7";
			}
		</script>
	</div>

</body>
</html>