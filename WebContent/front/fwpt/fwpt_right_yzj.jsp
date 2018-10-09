<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="util" uri="http://localhost:8080/3-28/util"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="refresh">
		<!--                   查询                                                                      -->
		<div class="search">
			<form
				action="${pageContext.request.contextPath}/front/fwpt/FwptServlet?method=getList&currentPagee==1"
				method="post" id="checkForm">
				<a>选择时间段：</a> <input readonly="readonly" type="disabled" name="time1"
					id="time1" style="width: 100px; height: 28px"> <img
					src="${pageContext.request.contextPath}/images/date.png" id="date1"
					width="20" height="20" border="0"
					onclick="J.calendar.get({id:'time1'});"> <a>到：</a> <input
					readonly="readonly" type="text" name="time2" id="time2"
					style="width: 100px; height: 28px"> <img
					src="${pageContext.request.contextPath}/images/date.png" id="date2"
					width="20" height="20" border="0"
					onclick="J.calendar.get({id:'time2'});"> <a>标题：</a> <input
					type="disabled" style="width: 200px; height: 28px" id="mc" name="mc">
				<!-- 							<input type="text" style="width: 200px; height: 28px" value="请输入..." -->
				<!-- 							onfocus="if(value=='请输入...') {value='';}" onblur="if (value=='') {value='请输入...';}">  -->
				<a href="javascript:void(0)" id="sb"> <img
					src="${pageContext.request.contextPath}/images/search.png"
					name="mc" id="mc" width="77" height="28" border="0">
				</a>
			</form>
		</div>
		<script type="text/javascript">
			$("#mc").val("${fwptPagingBean.mc}");

			$("#sb").click(function() {
					$("#checkForm").submit();
			});
		</script>
		<!--                          显示结果                      start                                             -->
		<div class="display">
			<table class="display-table">
		<tr style="background-color: #99d1d3;height: 50px;margin-top:2px;">
			<td width="450" style="text-align:center; font-family:'黑体'">单位名称</td>
			<td width="300" style="text-align:center; font-family:'黑体'">服务平台类型</td>
			<td width="250" style="text-align:center; font-family:'黑体'" id="KJCG_djl" title="">联系人</td>
		</tr>
		<!-- 表格内容放在此处 -->
		<c:forEach items="${fwptPagingBean.list}" var="p">
			<tr>
				<td style="text-align:left;font-family:'黑体';padding-left:10px"><a href="${pageContext.request.contextPath}/front/fwpt/FwptServlet?method=getBykmAndMc&km=${p.km}&mc=${p.mc}" target="_blank">${p.mc}</a></td>
				<td style="text-align:center;font-family:'黑体';">${p.km}</td>
				<td style="text-align:right;font-family:'黑体';padding-right:70px">${p.lxr}</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="4"><util:page pagingBean="${fwptPagingBean }" />
		</tr>
	</table>
		</div>
		<!--                          显示结果                         end                                          -->
	</div>
</body>
</html>