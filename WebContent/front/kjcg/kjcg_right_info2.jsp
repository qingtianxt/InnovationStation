<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="refresh">
		<div class="display1">
			<table width="835" border="0" align="center" cellpadding="0"
				cellspacing="0">
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
									style="color: #0B3E97; font-size: 17px; text-decoration: none; font-weight: bold;">${cgalBean.mc }</td>
							</tr>
							<tr>
								<td height="35">
									<center>
										<p>
											<!--<$[信息来源]>end-->
											<strong>发表日期</strong>：${cgalBean.time }
											<c:if
												test="${ cgalBean.time.equals('') || cgalBean.time==null  }">未标注</c:if>
											<!--<$[发布日期]>begin-->
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
								<td height="195" valign="top">
									<table width="100%" border="0" align="center" cellpadding="0"
										cellspacing="0" height="100%">
										<tr>
											<td valign="top" class="copy3" id="zoom"><p>
													<!-- 									sdfsdf -->
										<tr height="36">
											<td width="130px"><div align="left"
													style="font-weight: bold;">案例名称:</div></td>
											<td colspan="3">${cgalBean.mc }</td>
										</tr>
										<tr height="36">
											<td width="130px"><div align="left"
													style="font-weight: bold;">所在地:</div></td>
											<td width="260px"><c:if
													test="${cgalBean.szd.equals('') || cgalBean.szd==null  }">未标注</c:if>${cgalBean.szd }</td>
											<td width="130px">
												<div align="left" style="font-weight: bold;">关键词:</div>
											</td>
											<td><c:if
													test="${cgalBean.gjc.equals('') || cgalBean.gjc==null  }">未标注</c:if>${cgalBean.gjc }</td>

										</tr>
										<tr height="36">
											<td width="130px"><div align="left"
													style="font-weight: bold;">单位:</div></td>
											<td colspan="3"><c:if
													test="${cgalBean.dw.equals('') || cgalBean.dw==null  }">未标注</c:if>s${cgalBean.dw }</td>
										</tr>

										<!-- 					没有登录看不到下面的内容 -->
										<c:if test="${empty session_user }">
											<tr height="36">
												<td colspan="4"><div>
														<font color="red">如果您想查询项目具体的详细信息，请您<a
															href='../index.jsp'>登录</a>，如您还没有开通创新驿站账号，请立即 <a
															href='../register.jsp' target="_blank">注册</a></font>
													</div></td>
											</tr>
										</c:if>
										<c:if test="${not empty session_user }">
											<tr height="36px">
												<td colspan="4"><div align="center"
														style="font-weight: bold;">案例内容</div></td>
											</tr>
											<tr>
												<td colspan="4"><c:if
														test="${ cgalBean.nr.equals('') || cgalBean.nr==null  }">未标注</c:if>${cgalBean.nr }</td>
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