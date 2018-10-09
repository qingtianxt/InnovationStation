<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/front.css">
<style type="text/css">
	
</style>
<c:import url="../links.jsp"></c:import>
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
					<font color="#ffffff" style="top: 4px;position: relative;">科技成果栏</font>
				</div>
			 	<div style="background:#c0e4fa;height:30px;width:170px;margin-top:5px;margin-left:2px;align:left">
					<img style="margin-left: 15px;"src="${pageContext.request.contextPath}/front/images/tubiao.jpg" width="12px" height="12px;">
					<a href="KJCG_wyfb.jsp">我要发布</a>
				</div>
				<div style="background:#c0e4fa;height:30px;width:170px;margin-top:5px;margin-left:2px;align:left">
					<img style="margin-left: 15px;"src="${pageContext.request.contextPath}/front/images/tubiao.jpg" width="12px" height="12px;">
					<a href="KJCG_wyjfb.jsp">我已发布</a>
				</div>
			 	<div style="background:#c0e4fa;height:30px;width:170px;margin-top:5px;margin-left:2px;align:left">
					<img style="margin-left: 15px;"src="${pageContext.request.contextPath}/front/images/tubiao.jpg" width="12px" height="12px;">
					<a href="KJCG.jsp">已征集</a>
				</div>
			</div>
		</div>
		<div class="right" style="background-color: ">
			<div class="main" style="min-height: 500px">
<!-- 				<div class="search"> -->
<!-- 				<form> -->
<!-- 					<label>选择时间段： -->
<!-- 					  <input readonly="readonly" type="text" name="time1" id="time1" style="width: 100px; height: 28px"></label>  -->
<!-- 					  <img src="images/date.png" id="date1" width="20" height="20" border="0" onclick="J.calendar.get({id:'time1'});"> -->
<!-- 					<label>到： -->
<!-- 					  <input readonly="readonly" type="text" name="time2" id="time2" style="width: 100px; height: 28px"></label>  -->
<!-- 					  <img src="images/date.png" id="date2" width="20" height="20" border="0" onclick="J.calendar.get({id:'time2'});">  -->
<!-- 					<label>标题： -->
<!-- 					  <input type="text" style="width: 200px; height: 28px" id="title" name="title"></label>   -->
<!-- 					<button class="image-button"> -->
<!-- 						<img src="images/search.png" name="KJCG" id="KJCG" width="77" height="100%" border="0"> -->
<!-- 					</button> -->
<!-- 				</form>  -->
<!-- 				</div> -->
<!-- 				<table class="display-table"> -->
<!-- 					<tr style="background-color: #99d1d3;height: 50px;margin-top:2px;"> -->
<!-- 						<td width="450" style="text-align:center; font-family:'黑体'">标题</td> -->
<!-- 						<td width="200" style="text-align:center; font-family:'黑体'">类型</td> -->
<!-- 						<td width="200" style="text-align:center; font-family:'黑体'" id="KJCG_fbsj" title="点击按时间排序结果">发布时间</td> -->
<!-- 						<td width="150" style="text-align:center; font-family:'黑体'" id="KJCG_djl" title="点击按点击量排序结果">点击量</td> -->
<!-- 					</tr> -->
<!-- 					表格内容放在此处 -->
<!-- 				</table> -->
			</div>
		</div>
	</div>
<jsp:include page="${paggeContext.request.contextPath }/front/bottom.jsp"></jsp:include>
</div>
</body>
<script type="text/javascript">
	function changeFrameHeight(){
		document.getElementById("mainFrame").heigth=document.dcocumentElement.clientHeight;
	}
	window.onresize = function(){
		changeFrameHeight();
	}
// 	$(".main").load("news.jsp");
</script>
</html>
