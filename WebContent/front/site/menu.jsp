<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<div class="mune">
	<div style="background:#3FA0F1;height:30px;width:170px;margin-top:10px;margin-left:2px"align="center">
		<font color="#ffffff" style="top: 4px;position: relative;">专题专利栏</font>
	</div>
	 	<div style="background:#c0e4fa;height:30px;width:170px;margin-top:5px;margin-left:2px;align:left;text-overflow: ellipsis;white-space: nowrap;overflow: hidden;">
			<img style="margin-left: 15px;"src="${pageContext.request.contextPath}/front/images/tubiao.jpg" width="12px" height="12px;">
			<a href="${pageContext.request.contextPath}/front/site/siteServlet?method=list&type=区域站点">区域站点</a>
		</div>
	 	<div style="background:#c0e4fa;height:30px;width:170px;margin-top:5px;margin-left:2px;align:left;text-overflow: ellipsis;white-space: nowrap;overflow: hidden;">
			<img style="margin-left: 15px;"src="${pageContext.request.contextPath}/front/images/tubiao.jpg" width="12px" height="12px;">
			<a href="${pageContext.request.contextPath}/front/site/siteServlet?method=list&type=基层站点">基层站点</a>
		</div>
	 	<div style="background:#c0e4fa;height:30px;width:170px;margin-top:5px;margin-left:2px;align:left;text-overflow: ellipsis;white-space: nowrap;overflow: hidden;">
			<img style="margin-left: 15px;"src="${pageContext.request.contextPath}/front/images/tubiao.jpg" width="12px" height="12px;">
			<a href="${pageContext.request.contextPath}/front/site/siteServlet?method=list&type=合作站点">合作站点</a>
		</div>
</div>