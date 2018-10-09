<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>河北创新驿站协同工作平台</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/front.css">
<style type="text/css">
	.style{
	color: #000000; text-decoration: none; font-size: 14px;
	width: 100%;
	}
</style>
<jsp:include page="links.jsp"></jsp:include>
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
<!-- 		<div class="left" style="background-color: "> -->
<%-- 			<jsp:include page="menu.jsp"></jsp:include> --%>
<!-- 		</div> -->
<!-- 		<div class="right" style="background-color: "> -->
<%-- 			<jsp:include page="content.jsp"></jsp:include> --%>
<!-- 		</div> -->
		<jsp:include page="search_content.jsp"></jsp:include>
	</div>
<jsp:include page="${paggeContext.request.contextPath }/front/bottom.jsp"></jsp:include>
</div>
</body>
</html>
