<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="u" uri="http://localhost:8080/3-28/util" %>
<div class="main" style="min-height: 500px">
	<div class="search">
		<form action="${pageContext.request.contextPath}/front/site/siteServlet?method=list&type=${param.type}" method="post">
			<label>选择时间段：
			  <input readonly="readonly" type="text" name="startTime" id="time1" style="width: 100px; height: 28px"></label> 
			  <img src="${pageContext.request.contextPath}/front/images/date.png" id="date1" width="20" height="20" border="0" onclick="J.calendar.get({id:'time1'});">
			<label>到：
			  <input readonly="readonly" type="text" name="endTime" id="time2" style="width: 100px; height: 28px"></label> 
			  <img src="${pageContext.request.contextPath}/front/images/date.png" id="date2" width="20" height="20" border="0" onclick="J.calendar.get({id:'time2'});"> 
			<label>标题：
			  <input type="text" style="width: 200px; height: 28px" id="title" name="siteName"></label>  
			<button class="image-button">
				<img src="${pageContext.request.contextPath}/front/images/search.png" name="KJCG" id="KJCG" width="77" height="100%" border="0">
			</button>
		</form> 
	</div>
	<table class="display-table">
		<tr style="background-color: #99d1d3;height: 50px;margin-top:2px;">
			<td width="450" style="text-align:center; font-family:'黑体'">站点名称</td>
			<td width="300" style="text-align:center; font-family:'黑体'">添加日期</td>
			<td width="250" style="text-align:center; font-family:'黑体'" id="KJCG_djl" title="点击按点击量排序结果">点击量</td>
		</tr>
		<!-- 表格内容放在此处 -->
		<c:forEach items="${sites}" var="patent">
			<tr>
				<td style="text-align:left;font-family:'黑体';padding-left:10px"><a href="${patent.link }" title="${patent.id }" target="_block">${patent.name}</a></td>
				<td style="text-align:center;font-family:'黑体';">${patent.date}</td>
				<td style="text-align:right;font-family:'黑体';padding-right:70px">${patent.hites}</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="4"><u:page pagingBean="${pagingBean }" preUrl="${pageContext.request.contextPath}/front/site/siteServlet?method=list"/>
		</tr>
	</table>
	
</div>