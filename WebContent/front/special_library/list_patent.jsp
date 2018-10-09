<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="u" uri="http://localhost:8080/3-28/util" %>
<div class="main" style="min-height: 500px">
	<div class="search">
		<form action="${pageContext.request.contextPath}/front/special_library/libraryServlet?method=list&libId=${patents[0].ztzlk_id}" method="post">
			<label>选择时间段：
			  <input readonly="readonly" type="text" name="startTime" id="time1" style="width: 100px; height: 28px"></label> 
			  <img src="${pageContext.request.contextPath}/front/images/date.png" id="date1" width="20" height="20" border="0" onclick="J.calendar.get({id:'time1'});">
			<label>到：
			  <input readonly="readonly" type="text" name="endTime" id="time2" style="width: 100px; height: 28px"></label> 
			  <img src="${pageContext.request.contextPath}/front/images/date.png" id="date2" width="20" height="20" border="0" onclick="J.calendar.get({id:'time2'});"> 
			<label>标题：
			  <input type="text" style="width: 200px; height: 28px" id="title" name="name"></label>  
			<button class="image-button">
				<img src="${pageContext.request.contextPath}/front/images/search.png" name="KJCG" id="KJCG" width="77" height="100%" border="0">
			</button>
		</form> 
	</div>
	<table class="display-table">
		<tr style="background-color: #99d1d3;height: 50px;margin-top:2px;">
			<td width="450" style="text-align:center; font-family:'黑体'">发明名称</td>
			<td width="200" style="text-align:center; font-family:'黑体'">专利号</td>
			<td width="200" style="text-align:center; font-family:'黑体'" id="KJCG_fbsj" title="点击按时间排序结果">申请时间</td>
			<td width="150" style="text-align:center; font-family:'黑体'" id="KJCG_djl" title="点击按点击量排序结果">点击量</td>
		</tr>
		<!-- 表格内容放在此处 -->
		<c:forEach items="${patents}" var="patent">
			<tr>
				<td style="text-align:left;font-family:'黑体';padding-left:10px"><a href="${pageContext.request.contextPath}/front/patent/patentServlet?method=visit&id=${patent.id}" target="_blank">${patent.fmmc}</a></td>
				<td style="text-align:center;font-family:'黑体';">${patent.zlh}</td>
				<td style="text-align:center;font-family:'黑体';">${patent.sqrq}</td>
				<td style="text-align:right;font-family:'黑体';padding-right:30px">${patent.hits}</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="4"><u:page pagingBean="${pagingBean }" preUrl="${pageContext.request.contextPath}/front/special_library/libraryServlet?method=list"/>
		</tr>
	</table>
	
</div>