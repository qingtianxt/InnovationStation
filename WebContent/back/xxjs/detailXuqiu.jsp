<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="sist.domain.jsxq"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看需求信息</title>
<!-- css  js文件链接 -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/sl.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.4.js"></script>

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
			<li class="nav-li"><a
				href="${pageContext.request.contextPath }/back/welcome.jsp">首页</a></li>
			<li class="nav-li"><a href="javascript:void(0)" onclick="back()">找需求</a></li>
			<li class="nav-li"><a href="javascript:void(0)">需求信息</a></li>
		</ul>
	</div>
	<div class="table" align="center">
		<br> <br> <br> <br> <br>
		<table width="800" height="969" border="1"
			style="border-collapse: collapse;" class="form-table">
			<tr>
				<td width="141"><div align="center">技术需求名称</div></td>

				<td colspan="3">${jsxqBean.mc }</td>
			</tr>
			<tr>
				<td height="38"><div align="center">合作方式</div></td>
				<td>${jsxqBean.hzfs }</td>
				<td><div align="center">E-Mail</div></td>
				<td>${jsxqBean.email }</td>
			</tr>
			<tr>
				<td height="38"><div align="center">技术需求单位</div></td>
				<td colspan="3">${jsxqBean.mc_dw }</td>
			</tr>
			<tr>
				<td height="38"><div align="center">单位地址</div></td>
				<td colspan="3">${jsxqBean.dz_dw }</td>
			</tr>
			<tr>
				<td height="38"><div align="center">联系人</div></td>
				<td width="262">${jsxqBean.lxr }</td>
				<td width="125"><div align="center">联系电话</div></td>
				<td width="254">${jsxqBean.dh_lx }</td>
			</tr>
			<tr>
				<td height="38"><div align="center">投入总资金及用途</div></td>
				<td colspan="3">${jsxqBean.yt_tr }</td>
			</tr>
			<tr>
				<td height="38"><div align="center">关键词</div></td>
				<td colspan="3">${jsxqBean.gjc }</td>
			</tr>
			<tr>
				<td height="70"><div align="center">技术所属领域</div></td>
				<td colspan="3">
					<div id="jsssly" class="jsssly">
						<input type="hidden" id="lyz" value="">
						<c:forEach items="${jsssly }" var="l" varStatus="vs">
							<c:if test="${vs.count%6==0 }">
								<input disabled="disabled" type="checkbox" name="ly_js"
									value="${l.lyid }" />${l.lymc }<br>
							</c:if>
							<c:if test="${vs.count%6!=0 }">
								<input disabled="disabled" type="checkbox" name="ly_js"
									value="${l.lyid }" />${l.lymc }
        	</c:if>
						</c:forEach>
					</div>
				</td>
			</tr>
			<tr>
				<td colspan="4" height="38"><div align="center">单位情况简介</div></td>
			</tr>
			<tr>
				<td height="100" colspan="4" width="800">
					<div
						style="font-size: 15px; padding-top: 15px; word-break: break-all;">${jsxqBean.jj_dw }</div>
				</td>
			</tr>
			<tr>
				<td colspan="4" height="38"><div align="center">技术需求说明</div></td>
			</tr>
			<tr>
				<td height="100" colspan="4">${jsxqBean.nr_xq }</td>
			</tr>
			<tr>
				<td colspan="4" height="38"><div align="center">人才信息</div></td>
			</tr>
			<tr>
				<td height="100" colspan="4">${jsxqBean.rcxx }</td>
			</tr>
			<tr>
				<td colspan="4" height="38"><div align="center">资金信息</div></td>
			</tr>
			<tr>
				<td height="100" colspan="4">${jsxqBean.zjxx }</td>
			</tr>
			<tr>
				<td colspan="4" height="38"><div align="center">项目状况</div></td>
			</tr>
			<tr>
				<td height="100" colspan="4">${jsxqBean.xmzk }</td>
			</tr>
			<tr>
				<td colspan="4" height="38"><div align="center">审核意见</div></td>
			</tr>
			<tr>
				<td height="100" colspan="4">${jsxqBean.shyj }</td>
			</tr>
		</table>

	</div>
	<br>
	<br>
	<br>
	<br>
	<div align="center">
		<input style="margin: auto" type="button" value="确定" onclick="back()">
	</div>
	<br>
	<br>
	<br>
	<br>
	<script type="text/javascript">
		function back() {
			location.href = "${qyxqPagingBean.preUrl}" + "&msg=7"
		}
	</script>
	<!-- 页面加载需要加载，所以需要把这个代码放到多选框的下面 -->
	<script type="text/javascript">
		//function lyz(){

		var items = document.getElementsByName("ly_js");

		var xqly = "${jsxqBean.ly_js}".split(",");
		for (var i = 0; i < items.length; i++) {
			for (var j = 0; j < xqly.length; j++) {
				if (items[i].value == xqly[j]) {
					items[i].checked = "checked";
				}
			}
		}
		//}
	</script>
</body>
</html>


