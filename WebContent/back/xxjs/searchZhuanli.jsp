<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="u" uri="http://localhost:8080/3-28/util"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/sl.css">

<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.12.1.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery.validate.js"></script>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/css/lhgcalendar.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/lhgcore.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/lhgcalendar.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/layer/layer.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/time.js"></script>
<title>专利管理</title>
</head>
<body>
	<div>
		<div class="nav">
			您现在的位置：
			<ul class="nav-ul">
				<li class="nav-li"><a
					href="${pageContext.request.contextPath }/back/welcome.jsp">首页</a></li>
				<li class="nav-li"><a href="javascript:void(0)">找专利</a></li>
			</ul>
		</div>
		<div>
			<form
				action="${pageContext.request.contextPath}/back/xxjs/xxjsServlet?method=searchZhuanli"
				method="post">
				<table class="query-table">
					<tr>
						<td>发明专利名称：</td>
						<td><input name="name" value="${pagingBean.name }"
							type="text" id="fwptmc" placeholder="请输入专利名称" /></td>
						<td>专利号：</td>
						<td><input name="patentNumber" type="text"
							value="${pagingBean.patentNumber }" placeholder="请输入专利号">
						</td>
					</tr>
					<tr>
						<td>起始时间：</td>
						<td><input name="startTime" value="${pagingBean.startTime }"
							type="text" id="time1" onclick="J.calendar.get({id:'time1'});"
							readonly="readonly" placeholder="申请时间" />
						<td>截止时间：</td>
						<td><input name="endTime" value="${pagingBean.endTime }"
							type="text" id="time2" onclick="J.calendar.get({id:'time2'});"
							readonly="readonly" placeholder="申请时间" /></td>
						<td><input type="submit" value="查询" /></td>
					</tr>
					<!-- 		  <tr> -->
					<!-- 		  	<td height="21">摘要：</td> -->
					<!-- 		    <td colspan="3"> -->
					<!-- 		    	<input name="summary" type="text" id="gjc" style="width:350px"/> -->
					<!-- 	        </td> -->
					<!-- 		  </tr> -->
				</table>
			</form>
		</div>
		<div>
			<table class='result-table'>
				<tr>
					<td width="5%" height="20"><div align="center">序号</div></td>
					<td width="30%" height="20"><div align="center">发明名称</div></td>
					<td width="10%" height="20"><div align="center">专利号</div></td>
					<td width="10%" height="20"><div align="center">申请时间</div></td>
					<td width="15%" height="20"><div align="center">基本操作</div></td>
				</tr>
				<c:forEach items="${patents }" var="patent" varStatus="status">
					<tr>
						<td>${status.index+1+(pagingBean.currentPage-1)*pagingBean.pageSize }</td>
						<td style="text-align: left; padding-left: 15px">${patent.fmmc }</td>
						<td>${patent.zlh }</td>
						<td>${patent.sqrq }</td>
						<td><a
							href="${pageContext.request.contextPath }/back/xxjs/xxjsServlet?method=getZhuanliById&id=${patent.id }">查看</a>
						</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="5"><u:page
							pagingBean="${sessionScope.pagingBean }" /></td>
				</tr>
			</table>
		</div>
	</div>
</body>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/time.js"></script>
</html>