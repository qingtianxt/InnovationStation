<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="u" uri="http://localhost:8080/3-28/util" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新闻公告</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/front.css">
<jsp:include page="../links.jsp"></jsp:include>
<style type="text/css">
	.xx{
		background-color: #ffddaa;
	}
</style>
</head>
<body>
<c:if test="${empty sessionScope.session_user }">
	<c:import url="${paggeContext.request.contextPath }/front/login.jsp"></c:import>
</c:if>
<c:if test="${! empty sessionScope.session_user }">
	<c:import url="${paggeContext.request.contextPath }/front/top.jsp"></c:import>
</c:if>
<div class="all">
<jsp:include page="${paggeContext.request.contextPath }/front/head.jsp"></jsp:include>
	<div class="content" >
		<div class="left" style="background-color: ">
			<div class="mune">
				<div style="background:#3FA0F1;height:30px;width:170px;margin-top:10px;margin-left:2px"align="center">
					<font color="#ffffff" style="top: 4px;position: relative;">新闻公告栏</font>
				</div>
				<div style="background:#c0e4fa;height:30px;width:170px;margin-top:5px;margin-left:2px;align:left">
					<img style="margin-left: 15px;"src="${pageContext.request.contextPath}/front/images/tubiao.jpg" width="12px" height="12px;">
					<a href="${pageContext.request.contextPath}/front/news/newsServlet?method=list">新闻公告</a>
				</div>
			</div>
		</div>
		<div class="right" style="background-color: ">
			<div class="main" style="min-height: 500px">
				<div class="search">
					<form name="from1" action="${pageContext.request.contextPath}/front/news/newsServlet?method=list" method="post">
						<label>选择时间段：
						  <input readonly="readonly" type="text" name="qstart" id="time1" style="width: 100px; height: 28px" value="${newsPaging.qstart}"></label> 
						  <img src="${pageContext.request.contextPath}/front/images/date.png" id="date1" width="20" height="20" border="0" onclick="J.calendar.get({id:'time1'});">
						<label>到：
						  <input readonly="readonly" type="text" name="qend" id="time2" style="width: 100px; height: 28px" value="${newsPaging.qend}"></label> 
						  <img src="${pageContext.request.contextPath}/front/images/date.png" id="date2" width="20" height="20" border="0" onclick="J.calendar.get({id:'time2'});"> 
						<label>标题：
						  <input type="text" style="width: 200px; height: 28px" id="title" name="qtitle" value="${newsPaging.qtitle}"></label>  
						<button class="image-button">
							<img src="${pageContext.request.contextPath}/front/images/search.png" name="KJCG" id="KJCG" width="77" height="100%" border="0">
						</button>
						<input type="hidden" name="orderBy" value="${newsPaging.orderBy}">
						<input type="hidden" name="sortBy" value="${newsPaging.sortBy}">
					</form> 
					</div>
					<table class="display-table">
						<thead>
							<tr style="background-color: #99d1d3;height: 50px;margin-top:2px;">
								<td width="450" style="text-align:center; font-family:'黑体'">标题</td>
								<td width="200" style="text-align:center; font-family:'黑体'">类型</td>
								<td width="200" style="text-align:center; font-family:'黑体'" id="KJCG_fbsj" ><span title="点击按时间排序结果" style='cursor: pointer;' onclick="sort(document.forms,'time')">发布时间</span></td>
								<td width="150" style="text-align:center; font-family:'黑体'" id="KJCG_djl"><span title="点击按时间排序结果" style='cursor: pointer;' onclick="sort(document.forms,'hits')">点击量</span></td>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${newsBeans}" var="bean">
								<tr>
									<td style="text-align:left;font-family:'黑体';padding-left:10px">
										<a target='_blank' href="${pageContext.request.contextPath}/front/news/newsServlet?method=visit&id=${bean.id}">${bean.title}</a>
									</td>
									<td style="text-align:center;font-family:'黑体';">${bean.type}</td>
									<td style="text-align:center;font-family:'黑体';">${bean.time}</td>
									<td style="text-align:right;font-family:'黑体';padding-right:30px">${bean.hits}</td>
								</tr>
							</c:forEach>
						</tbody>
						<tfoot>
							<tr>
								<td colspan="4" style="padding:0"><u:page pagingBean="${newsPaging }" preUrl="${pageContext.request.contextPath}/front/news/newsServlet?method=list" css="xx"/></td>
							</tr>
						</tfoot>
					</table>
			</div>
		</div>
	</div>
<jsp:include page="${paggeContext.request.contextPath }/front/bottom.jsp"></jsp:include>
</div>
</body>
<script type="text/javascript">
	function sort(forms,field){
		var form = forms[forms.length-1];
		form.orderBy.value = field;
		if(form.sortBy.value=="DESC")
			form.sortBy.value="ASC";
		else
			form.sortBy.value="DESC";
		form.submit();
	}
</script>
</html>