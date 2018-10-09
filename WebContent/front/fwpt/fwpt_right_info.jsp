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
		<div class="display" align="center">
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
									style="color: #0B3E97; font-size: 16px; text-decoration: none; font-weight: bold;">${FwptBean.mc }
								</td>
							</tr>
							<tr>
								<td height="35">
									<center>
										<p>
											<!--<$[信息来源]>end-->
											<!--<$[发布日期]>begin-->
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
								<td valign="top">
									<table class="copy3" id="zoom" width="100%" border="0"
										align="center" cellpadding="0" cellspacing="0">
										<!-- 									asd -->
										<tr>
											<td width="150"><div align="left" style="font-weight: bold;">服务单位名称:</div></td>
											<td width="700">${FwptBean.mc }<input
												style="display: none" id="jgmc" name="jgmc" type="text" /></td>
										</tr>
										<tr height="20">
											<td height="2"></td>
										</tr>
										<tr>
											<td><div align="left" style="font-weight: bold;">联系人:</div></td>
											<td>${FwptBean.lxr }<c:if
						test="${ FwptBean.lxr.equals('') || FwptBean.lxr==null  }">未标注</c:if><input style="display: none"
												id="lxr" name="lxr" type="text" /></td>
										</tr>
										<tr height="20">
											<td height="2"></td>
										</tr>
										<tr>
											<td><div align="left" style="font-weight: bold;">联系方式:</div></td>
											<td>${FwptBean.dh }<c:if
						test="${ FwptBean.dh.equals('') || FwptBean.dh==null  }">未标注</c:if><input style="display: none"
												id="lxfs" name="lxfs" type="text" /></td>
										</tr>
										<tr height="20">
											<td height="2"></td>
										</tr>
										<tr>
											<td><div align="left" style="font-weight: bold;">服务单位类型:</div></td>
											<td>${FwptBean.km }<c:if
						test="${ FwptBean.km.equals('') || FwptBean.km==null  }">未标注</c:if><input style="display: none"
												id="email" name="email" type="text" /></td>
										</tr>

										<!-- 		如果没有的登录或没有权限就不能看到下边的内容 -->
										<c:if test="${empty session_user }">
											<tr>
												<td colspan="4"><div>
														<font color="red">如果您想查询项目具体的详细信息，请您<a
															href='../index.jsp'>登录</a>，如您还没有开通创新驿站账号，请立即 <a
															href='../register.jsp' target="_blank">注册</a></font>
													</div></td>
											</tr>
										</c:if>
										<c:if test="${not empty session_user }">
											<tr height="20">
												<td height="2"></td>
											</tr>
											<tr>
												<td><div align="left" style="font-weight: bold;">通讯地址:</div></td>
												<td>${FwptBean.dz }<c:if
						test="${ FwptBean.dz.equals('') || FwptBean.dz==null  }">未标注</c:if><input style="display: none"
													id="txdz" name="txdz" type="text" /></td>
											</tr>
											<tr height="20">
												<td height="2"></td>
											</tr>
											<tr>
												<td><div align="left" style="font-weight: bold;">关键词:</div></td>
												<td>${FwptBean.gjc }<c:if
						test="${ FwptBean.gjc.equals('') || FwptBean.gjc==null  }">未标注</c:if><input style="display: none"
													id="gjc" name="gjc" type="text" /></td>
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