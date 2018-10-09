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
	<div class="display1">
		<table width="835" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td valign="top" background="../images/news_read.jpg"
					bgcolor="#FFFFFF" align="center">
					<table align="center"
						style="margin: auto; color: #333333; width: 100%; font-size: 17px; line-height: 180%; text-decoration: none; border-collapse: collapse;">
						<tr>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td height="50" align="center" class="article_title"
								style="color: #0B3E97; font-size: 17px; text-decoration: none; font-weight: bold;">${jsxqBean.mc }</td>
						</tr>
						<tr>
							<td height="35">
								<center>
									<p>
										<!--<$[信息来源]>end-->
										<strong>发表日期</strong>：${jsxqBean.time }
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
										<td width="141"><div align="left"
												style="font-weight: bold;">技术需求名称:</div></td>
										<td colspan="3">${jsxqBean.mc }</td>
									</tr>
									
								
									<tr>
										<td height="38"><div align="left"
												style="font-weight: bold;">技术需求单位:</div></td>
										<td colspan="3">${jsxqBean.mc_dw }<c:if
												test="${ jsxqBean.mc_dw.equals('') || jsxqBean.mc_dw==null  }">未标注</c:if></td>
									</tr>
									<tr>
										<td height="38"><div align="left"
												style="font-weight: bold;">单位地址:</div></td>
										<td colspan="3">${jsxqBean.dz_dw }<c:if
												test="${ jsxqBean.dz_dw=='未标注' || jsxqBean.dz_dw.equals('') || jsxqBean.dz_dw==null  }">未标注</c:if></td>
									</tr>
									<tr>
										<td height="38"><div align="left"
												style="font-weight: bold;">投入总资金及用途:</div></td>
										<td colspan="3">${jsxqBean.yt_tr }<c:if
												test="${jsxqBean.yt_tr.equals('') || jsxqBean.yt_tr==null  }">未标注</c:if></td>
									</tr>
										<tr>
										<td height="38"><div align="left"
												style="font-weight: bold;">联系人:</div></td>
										<td width="262">${jsxqBean.lxr }<c:if
												test="${jsxqBean.lxr.equals('') || jsxqBean.lxr==null  }">未标注</c:if></td>
										<td width="125"><div align="left"
												style="font-weight: bold;">联系电话:</div></td>
										<td width="254">${jsxqBean.dh_lx }<c:if
												test="${jsxqBean.dh_lx.equals('') || jsxqBean.dh_lx==null  }">未标注</c:if></td>
									</tr>
									<tr>
										<td height="38"><div align="left"
												style="font-weight: bold;">合作方式:</div></td>
										<td>${jsxqBean.hzfs }<c:if
												test="${jsxqBean.hzfs.equals('') || jsxqBean.hzfs==null  }">未标注</c:if>
										<td><div  align="left"
												style="font-weight: bold;">E-Mail:</div></td>
										<td>${jsxqBean.email }<c:if
												test="${ jsxqBean.email.equals('') || jsxqBean.email==null  }">未标注</c:if></td>
									</tr>
									
									<tr>
										<td height="38"><div align="left"
												style="font-weight: bold;">技术所属领域:</div></td>
										<td >${jsssly }<c:if
												test="${ jsssly.equals('') || jsssly==null  }">未标注</c:if></td>
												<td height="38"><div align="left"
												style="font-weight: bold;">关键词:</div></td>
										<td >${jsxqBean.gjc }<c:if
												test="${jsxqBean.gjc.equals('') || jsxqBean.gjc==null  }">未标注</c:if></td>
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
											<td height="38" colspan="1" valign="top"><div
													align="left" style="font-weight: bold;">单位情况简介:</div></td>
											<td height="100" colspan="3" width="800" valign="top">
												<div style="font-size: 15px; word-break: break-all;"
													align="left">${jsxqBean.jj_dw }<c:if
														test="${jsxqBean.jj_dw.equals('') || jsxqBean.jj_dw==null  }">未标注</c:if>
												</div>
											</td>
										</tr>
										<tr>
											<td height="38" colspan="1" valign="top"><div
													align="left" style="font-weight: bold;">技术需求说明:</div></td>
											<td height="100" colspan="3"><div
													style="font-size: 15px; word-break: break-all;"
													align="left">${jsxqBean.nr_xq }<c:if
														test="${jsxqBean.nr_xq.equals('') || jsxqBean.nr_xq==null  }">未标注</c:if>
												</div></td>
										</tr>
										<tr>
											<td height="38" colspan="1"><div align="left"
													style="font-weight: bold;">人才信息:</div></td>
											<td height="100" colspan="4"><div
													style="font-size: 15px; word-break: break-all;"
													align="left">${jsxqBean.rcxx }<c:if
														test="${jsxqBean.rcxx.equals('') || jsxqBean.rcxx==null  }">未标注</c:if>
												</div></td>
										</tr>
										<tr>
											<td height="38" colspan="1"><div align="left"
													style="font-weight: bold;">资金信息:</div></td>
											<td height="100" colspan="3"><div
													style="font-size: 15px; word-break: break-all;"
													align="left">${jsxqBean.zjxx }<c:if
														test="${jsxqBean.zjxx.equals('') || jsxqBean.zjxx==null  }">未标注</c:if>
												</div></td>
										</tr>
										<tr>
											<td height="38" colspan="1"><div align="left"
													style="font-weight: bold;">项目状况:</div></td>
											<td height="100" colspan="3"><div
													style="font-size: 15px; word-break: break-all;"
													align="left">${jsxqBean.xmzk }<c:if
														test="${jsxqBean.xmzk.equals('') || jsxqBean.xmzk==null  }">未标注</c:if>
												</div></td>
										</tr>
										<tr>

										</tr>
									</c:if>
									<!-- 	      如果没有的登录或没有权限就不能看到上边的内容             -->
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
</body>
</html>