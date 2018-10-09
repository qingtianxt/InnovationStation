<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="u" uri="http://localhost:8080/3-28/util" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${newsBean.title}</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/front.css">
<jsp:include page="../links.jsp"></jsp:include>
<style type="text/css">
	
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
			<div class="display1" style="margin: auto;min-height: 500px">
				<table
					style="width: 835px; margin: auto; border-collapse: collapse;">
					<tr>
						<td valign="top"
							background="${pageContext.request.contextPath}/front/images/news_read.jpg"
							bgcolor="#FFFFFF" align="center">
							<table
								style="width: 95%; margin: auto; border-collapse: collapse;">
								<tr style="text-align:center;">
									<td><img alt="" style="max-width: 900px" src="${pageContext.request.contextPath}/${newsBean.image}"></td>
								</tr>
								<tr>

									<td height="50" align="center" class="article_title" style="color: #0B3E97;font-size: 16px; text-decoration: none; font-weight: bold;">${newsBean.title}</td>
								</tr>
								<tr>
									<td height="35">
										<p class="sub-title" style="text-align: center; font-size: 12px; line-height: 24px;">
											<!--<$[信息来源]>end-->
											<strong>发表日期</strong>：
											<!--<$[发布日期]>begin-->
											${newsBean.time }
											<!--<$[发布日期]>end-->
											<strong>阅读资料</strong>：17 <strong>信息来源： 河北省科学技术情报研究院</strong>&nbsp;&nbsp;[<strong>字体大小</strong>：<A
												href="javascript:doZoom(16)">大</a> <A
												href="javascript:doZoom(14)">中</a> <A
												href="javascript:doZoom(12)">小</a>]
										</p>
									</td>
								</tr>
								<tr height="2">
									<td height="2" bgcolor="#0B3E97"></td>
								</tr>
								<tr height="15">
									<td height="15"></td>
								</tr>
								<tr>
									<td valign="top">
										<table class="copy3" id="zoom"
											style="width: 95%; margin: auto; border-collapse: collapse;">
											<tr>
												<td> <!-- 新闻内容所在列 -->${newsBean.content}</td>
											</tr>
										</table>
									</td>
								</tr>
								<tr> <td>&nbsp;</td> </tr>
								<tr height="2"> <td height="2" bgcolor="#0B3E97"></td> </tr>
								<tr height="15">
									<td height="15"></td>
								</tr>
								<tr>
									<td height="30" valign="top"></td>
								</tr>

							</table>
						</td>
					</tr>
				</table>
			</div>

		</div>

<jsp:include page="${paggeContext.request.contextPath }/front/bottom.jsp"></jsp:include>
</div>
</body>
</html>