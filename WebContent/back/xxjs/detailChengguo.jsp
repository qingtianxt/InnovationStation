<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>成果转化项目</title>
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
</head>
<style type="text/css">
.table {
	
}

.table tr {
	
}

.table tr td {
	text-align: left;
	height: 30px;
}

.table tr td input {
	height: 20px;
	width: 95%;
}
</style>
<body bgcolor="#DDF2FC">
<div class="nav">
			您现在的位置：
			<ul class="nav-ul">
			<li class="nav-li"><a href="${pageContext.request.contextPath }/back/welcome.jsp">首页</a></li>
				<li class="nav-li"><a href="javascript:void(0)" onclick="back()">找成果</a></li>
				<li class="nav-li"><a href="javascript:void(0)">成果信息</a></li>
			</ul>
		</div>
	<div class="table" align="center">
		<h1>成果转化项目库</h1>


		<table width="800" height="570" border="1"  style="border-collapse: collapse;" class="form-table">
			<tr>
				<td width="110"><div align="center">成果名称</div></td>
				<td colspan="3"><input id="cgmc" name="cgmc" type="text"
					style="display: none;" />${cgzhxmBean.mc }</td>
			</tr>
			<tr>
				<td><div align="center">批准登记号</div></td>
				<td width="200"><input style="display: none;" id="pzdjh"
					name="djh" type="text" />${cgzhxmBean.djh }</td>
				<td width="140"><div align="center">成果类别</div></td>
				<td width="200"><input style="display: none;" id="gclb"
					name="gclb" type="text" />${cgzhxmBean.cglb }</td>
			</tr>
			<tr>
				<td><div align="center">成果所属单位</div></td>
				<td colspan="3"><input style="display: none;" id="cgssdw"
					name="cgssdw" type="text" />${cgzhxmBean.dw }</td>
			</tr>
			<tr>
				<td><div align="center">通讯地址</div></td>
				<td colspan="3"><input style="display: none;" id="txdz"
					name="txdz" type="text" size="54" />${cgzhxmBean.dz }</td>
			</tr>
			<tr>
				<td><div align="center">成果体现形式</div></td>
				<td colspan="3">
					<div id="jstxxs" class="jstxxs">
						<input type="hidden" id="lyz" value="">
						<c:forEach items="${jstxxs }" var="l" varStatus="vs">
							<c:if test="${vs.count%6==0 }">
								<input style="width: 2%" disabled="disabled" type="checkbox"
									value="${l.jstxxsid }" name="xs_js" />${l.jstxxsmc }<br>
							</c:if>
							<c:if test="${vs.count%6!=0 }">
								<input style="width: 2%" disabled="disabled" type="checkbox"
									value="${l.jstxxsid }" name="xs_js" />${l.jstxxsmc }
        	</c:if>
						</c:forEach>
					</div>
				</td>
			</tr>
			<tr>
				<td><div align="center">登记日期</div></td>
				<td><input style="display: none;" id="djrq" name="djrq"
					type="text" />${cgzhxmBean.djrq }</td>
				<td><div align="center">所属高新技术类别</div></td>
				<td><input style="display: none;" id="ssgxjslb" name="ssgxjslb"
					type="text" />${cgzhxmBean.jslb }</td>
			</tr>
			<tr>
				<td><div align="center">成果水平</div></td>
				<td><input style="display: none;" id="cgsp" name="cgsp"
					type="text" />${cgzhxmBean.sp }</td>
				<td><div align="center">核心专利</div></td>
				<td><input style="display: none;" id="hxzl" name="hxzl"
					type="text" />${cgzhxmBean.hxzl }</td>
			</tr>
			<tr>
				<td><div align="center">成果所处阶段</div></td>
				<td><input style="display: none;" id="cgscjd" name="cgscjd"
					type="text" />${cgzhxmBean.jd }</td>
				<td><div align="center">应用状态</div></td>
				<td><input style="display: none;" id="yyzt" name="yyzt"
					type="text" />${cgzhxmBean.yyzt }</td>
			</tr>
			<tr>
				<td><div align="center">技术所属领域</div></td>
				<td colspan="3">
					<div id="jsssly" class="jsssly">
						<input type="hidden" id="lyz" value="">
						<c:forEach items="${jsssly }" var="l" varStatus="vs">
							<c:if test="${vs.count%6==0 }">
								<input style="width: 2%" disabled="disabled" type="checkbox"
									value="${l.lyid }" name="ly_js" />${l.lymc }<br>
							</c:if>
							<c:if test="${vs.count%6!=0 }">
								<input style="width: 2%" disabled="disabled" type="checkbox"
									value="${l.lyid }" name="ly_js" />${l.lymc }
        	</c:if>
						</c:forEach>
					</div>
				</td>
			</tr>
			<tr>
				<td><div align="center">联系人</div></td>
				<td><input style="display: none;" id="lxr" name="lxr"
					type="text" />${cgzhxmBean.lxr }</td>
				<td><div align="center">联系人电话</div></td>
				<td><input style="display: none;" id="lxdh" name="lxdh"
					type="text" />${cgzhxmBean.dh }</td>
			</tr>
			<tr>
				<td><div align="center">成果属性</div></td>
				<td><input style="display: none;" id="cgsx" name="cgsx"
					type="text" />${cgzhxmBean.cgsx }</td>
				<td><div align="center">年份</div></td>
				<td><input style="display: none;" id="nf" name="nf" type="text" />${cgzhxmBean.nf }</td>
			</tr>
			<tr>
				<td><div align="center">成果应用行业</div></td>
				<td colspan="3"><input style="display: none;" id="cgyyhy"
					name="cgyyhy" type="text" />${yyhy }</td>
			</tr>
			<tr>
				<td><div align="center">关键词</div></td>
				<td colspan="3"><input style="display: none;" id="gjc"
					name="gjc" type="text" />${cgzhxmBean.gjc }</td>
			</tr>
			<tr>
				<td colspan="4"><div align="center">简介</div></td>
			</tr>
			<tr>
				<td height="171" colspan="4">${cgzhxmBean.gbnr }</td>
			</tr>
		</table>
		<script type="text/javascript">
			//function lyz(){

			var items = document.getElementsByName("ly_js");

			var xqly = "${cgzhxmBean.jsssly}".split(",");
			for (var i = 0; i < items.length; i++) {
				for (var j = 0; j < xqly.length; j++) {
					if (items[i].value == xqly[j]) {
						items[i].checked = "checked";
					}
				}
			}

			var items1 = document.getElementsByName("xs_js");

			var xqly = "${cgzhxmBean.xs}".split(",");
			for (var i = 0; i < items1.length; i++) {
				for (var j = 0; j < xqly.length; j++) {
					if (items1[i].value == xqly[j]) {
						items1[i].checked = "checked";
					}
				}
			}
			//}
		</script>
		<br> <br> <br> <br>
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
		function back(){
			location.href="${kjcgPagingBean.preUrl}"+"&msg=7"
		}
	</script>
	<br>
	<br>
	<br>
	<br>
</body>
</html>