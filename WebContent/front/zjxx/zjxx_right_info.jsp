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
									style="color: #0B3E97; font-size: 17px; text-decoration: none; font-weight: bold;">${zjxxBean.xm }</td>
							</tr>
							<tr>
								<td height="35">
									<center>
										<p>
											<!--<$[信息来源]>end-->
											<strong>国籍</strong>：
											<!--<$[发布日期]>begin-->${zjxxBean.gj }
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
											<td width="100"><div align="left"
													style="font-weight: bold;">姓名:</div></td>
											<td width="286">${zjxxBean.xm }</td>
											<td width="100"><div align="left"
													style="font-weight: bold;">所在市:</div></td>
											<td width="286">${zjxxBean.mc_szs }<c:if
													test="${ zjxxBean.mc_szs=='未标注' || zjxxBean.mc_szs.equals('') || zjxxBean.mc_szs==null  }">未标注</c:if></td>
										</tr>
										<tr height="38">
											<td><div align="left" style="font-weight: bold;">性别:</div></td>
											<td>${zjxxBean.xb }<c:if
													test="${ zjxxBean.xb=='未标注' || zjxxBean.xb.equals('') || zjxxBean.xb==null  }">未标注</c:if></td>
											<td><div align="left" style="font-weight: bold;">国籍:</div></td>
											<td>${zjxxBean.gj }<c:if
													test="${ zjxxBean.gj=='未标注' || zjxxBean.gj.equals('') || zjxxBean.gj==null  }">未标注</c:if></td>
										</tr>

										<!-- 		如果没有的登录或没有权限就不能看到下边的内容 -->

										<c:if test="${ empty session_user }">
											<tr height="38">
												<td colspan="4"><div>
														<font color="red">如果您想查询项目具体的详细信息，请您<a
															href='../index.jsp'>登录</a>，如您还没有开通创新驿站账号，请立即 <a
															href='../register.jsp' target="_blank">注册</a></font>
													</div></td>
											</tr>
										</c:if>
										<c:if test="${not empty session_user }">
											<tr height="38">
												<td><div align="left" style="font-weight: bold;">办公电话:</div></td>
												<td>${zjxxBean.dh_bg }<c:if
														test="${ zjxxBean.dh_bg=='未标注' || zjxxBean.dh_bg.equals('') || zjxxBean.dh_bg==null  }">未标注</c:if></td>
												<td><div align="left" style="font-weight: bold;">出生日期:</div></td>
												<td>${zjxxBean.rq_cs }<c:if
														test="${ zjxxBean.rq_cs=='未标注' || zjxxBean.rq_cs.equals('') || zjxxBean.rq_cs==null  }">未标注</c:if></td>
											</tr>
											<tr height="38">
												<td><div align="left" style="font-weight: bold;">职称:</div></td>
												<td>${zjxxBean.zc_zy}<c:if
														test="${ zjxxBean.zc_zy=='未标注' || zjxxBean.zc_zy.equals('') || zjxxBean.zc_zy==null  }">未标注</c:if></td>
												<td><div align="left" style="font-weight: bold;">手机:</div></td>
												<td>${zjxxBean.sj }<c:if
														test="${ zjxxBean.sj=='未标注' || zjxxBean.sj.equals('') || zjxxBean.sj==null  }">未标注</c:if></td>
											</tr>
											<tr height="38">
												<td><div align="left" style="font-weight: bold;">学位:</div></td>
												<td>${zjxxBean.xw }<c:if
														test="${ zjxxBean.xw=='未标注' || zjxxBean.xw.equals('') || zjxxBean.xw==null  }">未标注</c:if></td>
												<td><div align="left" style="font-weight: bold;">主要成就:</div></td>
												<td>${zjxxBean.ch_qt }<c:if
														test="${ zjxxBean.ch_qt=='未标注' || zjxxBean.ch_qt.equals('') || zjxxBean.ch_qt==null  }">未标注</c:if></td>
											</tr>
											<tr height="38">
												<td><div align="left" style="font-weight: bold;">学历:</div></td>
												<td>${zjxxBean.xl }<c:if
														test="${ zjxxBean.xl=='未标注' || zjxxBean.xl.equals('') || zjxxBean.xl==null  }">未标注</c:if></td>
												<td><div align="left" style="font-weight: bold;">研究方向:</div></td>
												<td>${zjxxBean.yjfx }<c:if
														test="${ zjxxBean.yjfx=='未标注' || zjxxBean.yjfx.equals('') || zjxxBean.yjfx==null  }">未标注</c:if></td>
											</tr>
											<tr height="38">
												<td><div align="left" style="font-weight: bold;">院士类别:</div></td>
												<td>${zjxxBean.yslb }<c:if
														test="${ zjxxBean.yslb=='未标注' || zjxxBean.yslb.equals('') || zjxxBean.yslb==null  }">未标注</c:if></td>
												<td><div align="left" style="font-weight: bold;">毕业院校:</div></td>
												<td>${zjxxBean.byyx }<c:if
														test="${ zjxxBean.byyx=='未标注' || zjxxBean.byyx.equals('') || zjxxBean.byyx==null  }">未标注</c:if></td>
											</tr>
											<tr height="38">
												<td><div align="left" style="font-weight: bold;">工作单位:</div></td>
												<td colspan="3">${zjxxBean.dw_gz }<c:if
														test="${ zjxxBean.dw_gz=='未标注' || zjxxBean.dw_gz.equals('') || zjxxBean.dw_gz==null  }">未标注</c:if></td>
											</tr>
											<tr height="38">
												<td><div align="left" style="font-weight: bold;">专家称号:</div></td>
												<td colspan="3">${zjxxBean.ch }<c:if
														test="${ zjxxBean.ch=='未标注' || zjxxBean.ch.equals('') || zjxxBean.ch==null  }">未标注</c:if></td>
											</tr>
											<tr height="38">
												<td><div align="left" style="font-weight: bold;">学科领域:</div></td>
												<td colspan="3">${zjxxBean.xkly }<c:if
														test="${ zjxxBean.xkly=='未标注' || zjxxBean.xkly.equals('') || zjxxBean.xkly==null  }">未标注</c:if></td>
											</tr>
											<tr height="38">
												<td><div align="left" style="font-weight: bold;">现从事行业:</div></td>
												<td colspan="3">${zjxxBean.xcshy }<c:if
														test="${ zjxxBean.xcshy=='未标注' || zjxxBean.xcshy.equals('') || zjxxBean.xcshy==null  }">未标注</c:if></td>
											</tr>
											<tr height="38">
												<td><div align="left" style="font-weight: bold;">关键词:</div></td>
												<td colspan="3">${zjxxBean.gjc }<c:if
														test="${ zjxxBean.gjc=='未标注' || zjxxBean.gjc.equals('') || zjxxBean.gjc==null  }">未标注</c:if></td>
											</tr>
											<tr height="38">
												<td colspan="1" valign="top"><div
														style="font-weight: bold;">个人简介:</div></td>
												<td colspan="3">${zjxxBean.bz }<c:if
														test="${ zjxxBean.bz=='未标注' || zjxxBean.bz.equals('') || zjxxBean.bz==null  }">未标注</c:if></td>
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