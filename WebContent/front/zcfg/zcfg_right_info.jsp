<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="refresh">
		<div class="display1">
			<table align="center"
				style="margin: auto; color: #333333; width: 100%; font-size: 17px; line-height: 180%; text-decoration: none; border-collapse: collapse;">
				<tr>
					<td valign="top" background="../images/news_read.jpg"
						bgcolor="#FFFFFF" align="center">
						<table width="95%" border="0" align="center" cellpadding="0"
							cellspacing="0">
							<tr>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td height="50" align="center" class="article_title"
									style="color: #0B3E97; font-size: 17px; text-decoration: none; font-weight: bold;">${zcfgBean.zcmc }</td>
							</tr>
							<tr>
								<td height="35">
									<center>
										<p>
											<!--<$[信息来源]>end-->
											<strong>公布日期</strong>：
											<!--<$[发布日期]>begin-->
											${zcfgBean.bgbrq }
											<!--<$[发布日期]>end-->
											<strong>阅读资料</strong>：17 <strong>信息来源： 河北省科学技术情报研究院</strong>&nbsp;&nbsp;[<strong>字体大小</strong>：<A
												href="javascript:doZoom(16)">大</a> <A
												href="javascript:doZoom(14)">中</a> <A
												href="javascript:doZoom(12)">小</a>]
										</p>
									</center>
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
									<table class="copy3" id="zoom" width="100%" border="0"
										align="center" cellpadding="0" cellspacing="0">
										<!-- 									asd -->
										<tr height="38">
											<td width="99"><div align="left"
													style="font-weight: bold;">政策名称:</div></td>
											<td colspan="3">${zcfgBean.zcmc }</td>
										</tr>
										<tr>
											<td><div align="left" style="font-weight: bold;">公布日期:</div></td>
											<td width="286">${zcfgBean.bgbrq }<c:if
													test="${ zcfgBean.bgbrq.equals('') || zcfgBean.bgbrq==null  }">未标注</c:if></td>
											<td width="101"><div align="left"
													style="font-weight: bold;">施行日期:</div></td>

											<td width="286">${zcfgBean.bsxrq }<c:if
													test="${ zcfgBean.bsxrq.equals('') || zcfgBean.bsxrq==null  }">未标注</c:if></td>
										</tr>
										<tr>
											<td><div align="left" style="font-weight: bold;">政策分类:</div></td>

											<td>${zcfgBean.zcflmc }<c:if
													test="${  zcfgBean.zcflmc.equals('') || zcfgBean.zcflmc==null  }">未标注</c:if></td>
											<td><div align="left" style="font-weight: bold;">颁布形式:</div></td>

											<td>${zcfgBean.bbbxsmc }<c:if
													test="${  zcfgBean.bbbxsmc.equals('') || zcfgBean.bbbxsmc==null  }">未标注</c:if></td>
										</tr>

										<!-- 		如果没有的登录或没有权限就不能看到下边的内容 -->

										<c:if test="${empty sessionScope.session_user }">
											<tr>
												<td colspan="4"><div>
														<font color="red">如果您想查询项目具体的详细信息，请您<a
															href='../index.jsp'>登录</a>，如您还没有开通创新驿站账号，请立即 <a
															href='../register.jsp' target="_blank">注册</a></font>
													</div></td>
											</tr>
										</c:if>
										<c:if test="${not empty sessionScope.session_user }">


											<tr>
												<td><div align="left" style="font-weight: bold;">政策文号:</div></td>
												<td>${zcfgBean.zcwh }<c:if
														test="${ zcfgBean.zcwh.equals('') || zcfgBean.zcwh==null  }">未标注</c:if></td>
												<td><div align="left" style="font-weight: bold;">制定机关:</div></td>
												<td>${zcfgBean.bzdjgmc }<c:if
														test="${  zcfgBean.bzdjgmc.equals('') || zcfgBean.bzdjgmc==null  }">未标注</c:if></td>
											</tr>
											<tr>
												<td><div align="left" style="font-weight: bold;">关键字:</div></td>
												<td colspan="1">${zcfgBean.gjzmc }<c:if
														test="${  zcfgBean.gjzmc.equals('') || zcfgBean.gjzmc==null  }">未标注</c:if></td>
												<td><div align="left" style="font-weight: bold;">主题词:</div></td>
												<td>${zcfgBean.ztcmc }<c:if
														test="${ zcfgBean.ztcmc.equals('') || zcfgBean.ztcmc==null  }">未标注</c:if></td>
											</tr>
											<tr>
												<td width="130"><div align="left"
														style="font-weight: bold;">主要针对对象:</div></td>
												<td colspan="3">${zyzddx }<c:if
														test="${  zyzddx.equals('') ||zyzddx==null  }">未标注</c:if></td>
											</tr>
											<tr>
												<td><div align="left" style="font-weight: bold;">施行范围:</div></td>
												<td colspan="3">${zcfgBean.bsxfwmc }<c:if
														test="${ zcfgBean.bsxfwmc.equals('') || zcfgBean.bsxfwmc==null  }">未标注</c:if></td>
											</tr>


											<tr>
												<td colspan="4"><div align="center"
														style="font-weight: bold;">政策内容</div></td>
											</tr>
											<tr>
												<td colspan="4">${zcfgBean.zcnr }<c:if
														test="${ zcfgBean.zcnr.equals('') || zcfgBean.zcnr==null  }">未标注</c:if></td>
											</tr>
										</c:if>
									</table>
								</td>
							</tr>
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
</body>
</html>