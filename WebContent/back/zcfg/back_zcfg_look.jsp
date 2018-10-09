<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看新闻公告</title>
<!-- css  js文件链接 -->
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.4.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/lhgcore.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/lhgcalendar.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.9.1.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/sl.css">
<!-- 上传信息 -->
<!-- css  js文件链接 -->
<style type="text/css">
.table {
	border-collapse: collapse;
}

.table tr {
	
}

.table tr td {
	text-align: left;
	height: 30px;
}

.table tr td input {
	height: 20px;
}
</style>

</head>

<body bgcolor="#DDF2FC">
<div class="nav">
			您现在的位置：
			<ul class="nav-ul">
				<li class="nav-li"><a href="javascript:void(0)">政策法规</a></li>
				<li class="nav-li"><a href="javascript:void(0)" onclick="back()">政策管理</a></li>
				<li class="nav-li"><a href="javascript:void(0)">查看政策</a></li>
			</ul>
		</div>
	<div class="table" align="center">
		<br> <br> <br> <br>
		<table width="800" border="1"  style="border-collapse: collapse;" class="form-table">
			<tr>
				<td width="99"><div align="center">政策名称</div></td>
				<td colspan="3">${zcfgBean.zcmc }</td>
			</tr>
			<tr>
				<td><div align="center">公布日期</div></td>
				<td width="286">${zcfgBean.bgbrq }</td>
				<td width="101"><div align="center">施行日期</div></td>
				<td width="286">${zcfgBean.bsxrq }</td>
			</tr>
			<tr>
				<td><div align="center">政策分类</div></td>
				<td>${zcfgBean.zcflmc }</td>
				<td><div align="center">颁布形式</div></td>
				<td>${zcfgBean.bbbxsmc }</td>
			</tr>
			<tr>
				<td><div align="center">政策文号</div></td>
				<td colspan="3">${zcfgBean.zcwh }</td>
			</tr>
			<tr>
				<td><div align="center">制定机关</div></td>
				<td colspan="3">${zcfgBean.bzdjgmc }</td>
			</tr>
			<tr>
				<td><div align="center">施行范围</div></td>
				<td colspan="3">${zcfgBean.bsxfwmc }</td>
			</tr>
			<tr>
				<td><div align="center">主题词</div></td>
				<td colspan="3">${zcfgBean.ztcmc }</td>
			</tr>
			<tr>
				<td><div align="center">关键字</div></td>

				<td colspan="3">${zcfgBean.gjzmc }</td>
			</tr>
			<tr>
				<td><div align="center">主要针对对象</div></td>
				<td colspan="3">
					<!-- 		    	<input id="zyzddx" name="zyzddx" type="text" /> -->
					<div id="zyzddx" class="zyzddx">
						<c:forEach items="${zyzddx }" var="z" varStatus="vs">
							<c:if test="${vs.count%5==0 }">
								<input style="width: 2%" type="checkbox" name="ttzlymc"
									id="ttzlymc" disabled="disabled" value="${z.zyzddxid }" />${z.zyzddxmc }<br>
							</c:if>
							<c:if test="${vs.count%5!=0 }">
								<input style="width: 2%" type="checkbox" name="ttzlymc"
									disabled="disabled" id="ttzlymc" value="${z.zyzddxid }" />${z.zyzddxmc }
 	        	</c:if>
						</c:forEach>
					</div>
				</td>
			</tr>
			<tr>
				<td colspan="4"><div align="center">政策内容</div></td>
			</tr>
			<tr>

				<td colspan="4">${zcfgBean.zcnr }</td>
			</tr>
		</table>
		<script type="text/javascript">
			//这段内容要放在需要获取的标签的后面，否则获取到的内容为空
			var items = document.getElementsByName("ttzlymc");

			var ttzlymc = "${zcfgBean.ttzlymc}".split(",");
			for (var i = 0; i < items.length; i++) {
				for (var j = 0; j < ttzlymc.length; j++) {
					if (items[i].value == ttzlymc[j]) {
						items[i].checked = "checked";
					}
				}
			}
		</script>
	</div>
	<br>
	<br>
	<br>
	<br>
	<div align="center">
		<input style="margin: auto" type="button" value="确定"
			onclick="back()">
	</div>
	<script type="text/javascript">
		function back() {
			location.href = "${zcfgPagingBean.preUrl}" + "&msg=7"
		}
	</script>
	<br>
	<br>
	<br>
	<br>
</body>
</html>


