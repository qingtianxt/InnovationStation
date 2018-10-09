<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="u" uri="http://localhost:8080/3-28/util"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${TeachSupplyBean.mc}</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/front.css">
<style type="text/css">
</style>
<jsp:include page="../links.jsp"></jsp:include>
</head>
<body>
	<c:if test="${empty sessionScope.session_user }">
		<c:import url="${paggeContext.request.contextPath }/front/login.jsp"></c:import>
	</c:if>
	<c:if test="${! empty sessionScope.session_user }">
		<c:import url="${paggeContext.request.contextPath }/front/top.jsp"></c:import>
	</c:if>
	<div class="all">
		<jsp:include
			page="${paggeContext.request.contextPath }/front/head.jsp"></jsp:include>
		<div class="content">
			<div class="left" style="background-color:">
				<div class="mune">
					<div
						style="background: #3FA0F1; height: 30px; width: 170px; margin-top: 10px; margin-left: 2px"
						align="center">
						<font color="#ffffff" style="top: 4px; position: relative;">科技成果栏</font>
					</div>
					<div
						style="background: #c0e4fa; height: 30px; width: 170px; margin-top: 5px; margin-left: 2px; align: left">
						<img style="margin-left: 15px;"
							src="${pageContext.request.contextPath}/front/images/tubiao.jpg"
							width="12px" height="12px;"> <a href="add.jsp">我要发布</a>
					</div>
					<div
						style="background: #c0e4fa; height: 30px; width: 170px; margin-top: 5px; margin-left: 2px; align: left">
						<img style="margin-left: 15px;"
							src="${pageContext.request.contextPath}/front/images/tubiao.jpg"
							width="12px" height="12px;"> <a href="${pageContext.request.contextPath}/front/technology_supply/supplyServlet?method=list&result=front&username=${sessionScope.session_user.username}">我已发布</a>
					</div>
					<div
						style="background: #c0e4fa; height: 30px; width: 170px; margin-top: 5px; margin-left: 2px; align: left">
						<img style="margin-left: 15px;"
							src="${pageContext.request.contextPath}/front/images/tubiao.jpg"
							width="12px" height="12px;"> <a href="${pageContext.request.contextPath}/front/technology_supply/supplyServlet?method=list&result=front">已征集</a>
					</div>
				</div>
			</div>
			<div class="right" style="background-color:">
				<div class="display1">
					<table style="width: 835px; margin: auto; border-collapse: collapse;">
						<tr>
							<td height="101" valign="top" background="${pageContext.request.contextPath }/front/images/news_read.jpg"
								bgcolor="#FFFFFF" align="center">
								<table style="width: 95%; margin: auto; border-collapse: collapse;">
									<tr>
										<td>&nbsp;</td>
									</tr>
									<tr>

										<td height="50" align="center" class="article_title" style="color: #0B3E97;font-size: 16px; text-decoration: none; font-weight: bold;">${TeachSupplyBean.mc}</td>
									</tr>
									<tr>
										<td height="35">
												<p class="sub-title" style="text-align: center; font-size: 12px; line-height: 24px;">
													<!--<$[信息来源]>end-->
													<strong>发表日期</strong>：
													<!--<$[发布日期]>begin-->
 													${TeachSupplyBean.time }
													<!--<$[发布日期]>end-->
													<strong>阅读资料</strong>：17 <strong>信息来源：
														河北省科学技术情报研究院</strong>&nbsp;&nbsp;[<strong>字体大小</strong>：<A
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
										<td height="195" valign="top">
											<table class='table2' style="margin:auto;color: #333333;width:100%;font-size: 14px;  line-height: 180%;  text-decoration: none;border-collapse: collapse;">
												<tr>
													<td valign="top" class="copy3" id="zoom"><p>
												<tr height="36">
													<td width="120"><div align="left" style="font-weight: bold;">技术名称:</div></td>
													<td width="260">${TeachSupplyBean.mc}</td>
													<td width="120"><div align="left" style="font-weight: bold;">技术水平:</div></td>
													<td width="260">${TeachSupplyBean.sp}<c:if test="${TeachSupplyBean.sp==null || TeachSupplyBean.sp.equals('') }">未标注</c:if></td>
												</tr>
												<tr height="36">
													<td><div align="left" style="font-weight: bold;">批准登记号:</div></td>
													<td>${TeachSupplyBean.djh }<c:if test="${TeachSupplyBean.djh==null || TeachSupplyBean.djh.equals('') }">未标注</c:if></td>
													<td><div align="left" style="font-weight: bold;">应用状态:</div></td>
													<td>${TeachSupplyBean.yyzt }<c:if test="${TeachSupplyBean.yyzt==null || TeachSupplyBean.yyzt.equals('') }">未标注</c:if></td>
												</tr>
												<tr height="36">
													<td><div align="left" style="font-weight: bold;">是否专利技术:</div></td>
													<td>${TeachSupplyBean.sfzl }<c:if test="${TeachSupplyBean.sfzl==null || TeachSupplyBean.sfzl.equals('') }">未标注</c:if></td>
													<td><div align="left" style="font-weight: bold;">联系人:</div></td>
													<td>${TeachSupplyBean.lxr }<c:if test="${TeachSupplyBean.lxr==null || TeachSupplyBean.lxr.equals('') }">未标注</c:if></td>
												</tr>
												<tr height="36">
													<td><div align="left" style="font-weight: bold;">专利号:</div></td>
													<td>${TeachSupplyBean.zlh }<c:if test="${TeachSupplyBean.zlh==null || TeachSupplyBean.zlh.equals('') }">未标注</c:if></td>
													<td><div align="left" style="font-weight: bold;">联系人电话:</div></td>
													<td>${TeachSupplyBean.dh }<c:if test="${TeachSupplyBean.dh==null || TeachSupplyBean.dh.equals('') }">未标注</c:if></td>
												</tr>
												<!-- 					没有登录看不到下面的内容 -->
												<c:if test="${empty sessionScope.session_user }">
													<tr>
														<td colspan="4"><div>
																<font color="red">如果您想查询项目具体的详细信息，请您<a
																	href='${pageContext.request.contextPath}/front/index.jsp'>登录</a>，如您还没有开通创新驿站账号，请立即 <a
																	href='${pageContext.request.contextPath}/front/register.jsp' target="_blank">注册</a></font>
															</div></td>
													</tr>
												</c:if>
												<c:if test="${ ! empty sessionScope.session_user }">
													<tr height="36">
														<td><div align="left"style="font-weight: bold;">所属高新技术类别:</div></td>
														<td>${TeachSupplyBean.jslb }<c:if test="${TeachSupplyBean.jslb==null || TeachSupplyBean.jslb.equals('') }">未标注</c:if>
														</td>
														<td><div align="left"style="font-weight: bold;">登记日期:</div></td>
														<td>${TeachSupplyBean.djrq }<c:if test="${TeachSupplyBean.djrq==null || TeachSupplyBean.djrq.equals('') }">未标注</c:if>
														</td>
													</tr>
													<tr height="36">
														<td><div align="left"style="font-weight: bold;">技术所处阶段:</div></td>
														<td>${TeachSupplyBean.jd }<c:if test="${TeachSupplyBean.jd==null || TeachSupplyBean.jd.equals('') }">未标注</c:if>
														</td>
														<td><div align="left" style="font-weight: bold;">年份:</div></td>
														<td>${TeachSupplyBean.nf }<c:if test="${TeachSupplyBean.nf==null || TeachSupplyBean.nf.equals('') }">未标注</c:if>
														</td>
													</tr>
													<tr height="36">
														<td><div align="left" style="font-weight: bold;">技术属性:</div></td>
														<td>${TeachSupplyBean.cgsx }<c:if test="${TeachSupplyBean.cgsx==null || TeachSupplyBean.cgsx.equals('') }">未标注</c:if>
														</td>								
														<td><div align="left" style="font-weight: bold;">专利状态:</div></td>
														<td>${TeachSupplyBean.zlzt }<c:if test="${TeachSupplyBean.zlzt==null || TeachSupplyBean.zlzt.equals('') }">未标注</c:if>
														</td>
													</tr>
													<tr height="36">
														<td><div align="left"style="font-weight: bold;">技术体现形式:</div></td>
														<td colspan="3">
															${TeachSupplyBean.xs }<c:if test="${TeachSupplyBean.xs==null || TeachSupplyBean.xs.equals('') }">未标注</c:if>
														</td>
													</tr>
													<tr height="36">
														<td><div align="left"style="font-weight: bold;">技术供给单位:</div></td>
														<td colspan="3" align="left">${TeachSupplyBean.dw }<c:if test="${TeachSupplyBean.dw==null || TeachSupplyBean.dw.equals('') }">未标注</c:if></td>
													</tr>
													<tr height="36">
														<td height="35"><div align="left"style="font-weight: bold;">通讯地址:</div></td>
														<td colspan="3"align="left">${TeachSupplyBean.dz }<c:if test="${TeachSupplyBean.dz==null || TeachSupplyBean.dz.equals('') }">未标注</c:if></td>
													</tr>
													<tr height="36">
														<td><div align="left"style="font-weight: bold;">关键词:</div></td>
														
														<td colspan="3"align="left">${TeachSupplyBean.gjc }<c:if test="${TeachSupplyBean.gjc==null || TeachSupplyBean.gjc.equals('') }">未标注</c:if></td>
													</tr>
													<tr>
														<td colspan="1" height="36"style="font-weight: bold; vertical-align: top">项目简介:</td>
														<td colspan="3" height="36"style="">${TeachSupplyBean.gbnr }</td>
													</tr>
												</c:if>
											</table>
									<tr>
										<td>&nbsp;</td>
									</tr>
									<tr height="2">
										<td height="2" bgcolor="#0B3E97"></td>
									</tr>
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
		</div>
		<jsp:include
			page="${paggeContext.request.contextPath }/front/bottom.jsp"></jsp:include>
	</div>
</body>
</html>
