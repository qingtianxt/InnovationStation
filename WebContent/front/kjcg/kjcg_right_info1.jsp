<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/front.css">
</head>
<body background="../images/news_read.jpg">
	<div>
		<table align="center"
			style="margin: auto; color: #333333; width: 100%; font-size: 17px; line-height: 180%; text-decoration: none; border-collapse: collapse;">
			<tr height="30px">
				<td></td>
			</tr>
			<tr>
				<td colspan="4" align="center" class="article_title"
					style="color: #0B3E97; font-size: 17px; text-decoration: none; font-weight: bold;">${cgzhxmBean.mc }
				</td>
			</tr>
			<tr>
				<td colspan="4">
					<div style="font-size: 17px">
						<p>
							<!--<$[信息来源]>end-->
							<strong>发表日期</strong>：${cgzhxmBean.time }
							<!--<$[发布日期]>begin-->
							<!--<$[发布日期]>end-->
							<strong>阅读资料</strong>：17 <strong>信息来源： 河北省科学技术情报研究院</strong>&nbsp;&nbsp;[<strong>字体大小</strong>：<A
								href="javascript:doZoom(16)">大</a> <A
								href="javascript:doZoom(14)">中</a> <A
								href="javascript:doZoom(12)">小</a>]
						</p>
					</div>
				</td>
			</tr>
			<tr height="2">
				<td height="2" bgcolor="#0B3E97" colspan="4"></td>
			</tr>
			<tr height="30px">
				<td></td>
			</tr>
			<tr height="36">
				<td width="130px"><div align="left" style="font-weight: bold;">成果名称:</div></td>
				<td colspan="3">${cgzhxmBean.mc }</td>
			</tr>
			<tr height="36">
				<td width="130px"><div align="left" style="font-weight: bold;">成果类别:</div></td>
				<td>${cgzhxmBean.cglb }<c:if
						test="${ cgzhxmBean.cglb.equals('') || cgzhxmBean.cglb==null  }">未标注</c:if></td>
				<td width="130px"><div align="left" style="font-weight: bold;">成果所属单位:</div></td>
				<td>${cgzhxmBean.dw }<c:if
						test="${ cgzhxmBean.dw.equals('') || cgzhxmBean.dw==null  }">未标注</c:if></td>
			</tr>
			<tr height="36">
				<td width="130px"><div align="left" style="font-weight: bold;">登记日期:</div></td>
				<td>${cgzhxmBean.djrq }<c:if
						test="${cgzhxmBean.djrq.equals('') || cgzhxmBean.djrq==null  }">未标注</c:if></td>
				<td width="160px"><div align="left" style="font-weight: bold;">所属高新技术类别:</div></td>
				<td>${cgzhxmBean.jslb }<c:if
						test="${ cgzhxmBean.jslb.equals('') || cgzhxmBean.jslb==null  }">未标注</c:if></td>
			</tr>
			<tr height="36">
				<td width="130px"><div align="left" style="font-weight: bold;">成果体现形式:</div></td>
				<td ><div align="left" style="font-weight: bold;">${cgzhxmBean.xs }<c:if
							test="${ cgzhxmBean.xs.equals('') || cgzhxmBean.xs==null  }">未标注</c:if>
					</div></td>
					<td width="130px"><div align="left" style="font-weight: bold;">批准登记号:</div></td>
				<td>${cgzhxmBean.djh }<c:if
						test="${ cgzhxmBean.djh.equals('') || cgzhxmBean.djh==null  }">未标注</c:if></td>
			</tr>
			<!-- 					没有登录看不到下面的内容 -->
			<c:if test="${empty session_user }">
				<tr>
					<td colspan="4"><font color="red">如果您想查询项目具体的详细信息，请您<a
							href='../index.jsp'>登录</a>，如您还没有开通创新驿站账号，请立即 <a
							href='../register.jsp' target="_blank">注册</a></font></td>
				</tr>
			</c:if>
			<c:if test="${not empty session_user }">
				<tr height="36">
					<td width="130px"><div align="left" style="font-weight: bold;">成果水平:</div></td>
					<td width="260px">${cgzhxmBean.sp }<c:if
							test="${  cgzhxmBean.sp.equals('') || cgzhxmBean.sp==null  }">未标注</c:if></td>
					<td width="130px"><div align="left" style="font-weight: bold;">成果所处阶段:</div></td>
					<td width="260px">${cgzhxmBean.jd }<c:if
							test="${ cgzhxmBean.jd.equals('') || cgzhxmBean.jd==null  }">未标注</c:if></td>
				</tr>
				<tr height="36">
					<td width="130px"><div align="left" style="font-weight: bold;">应用状态:</div></td>
					<td>${cgzhxmBean.yyzt}<c:if
							test="${cgzhxmBean.yyzt.equals('') || cgzhxmBean.yyzt==null  }">未标注</c:if></td>
					<td width="130px"><div align="left" style="font-weight: bold;">成果应用行业:</div></td>
					<td>${cgzhxmBean.yyhy }<c:if
							test="${cgzhxmBean.yyhy.equals('') || cgzhxmBean.yyhy==null  }">未标注</c:if></td>
				</tr>
				<tr height="36">
					<td width="130px"><div align="left" style="font-weight: bold;">技术所属领域:</div></td>
					<td>${jsssly }<c:if
								test="${ cgzhxmBean.djh.equals('') || cgzhxmBean.djh==null  }">未标注</c:if>
						</td>
					<td width="130px"><div align="left" style="font-weight: bold;">关键词:</div></td>
					<td><input style="display: none;" id="gjc" name="gjc"
						type="text" />${cgzhxmBean.gjc }<c:if
							test="${ jsssly.equals('') || jsssly==null  }">未标注</c:if></td>
				</tr>
				<tr height="36">
					<td width="130px"><div align="left" style="font-weight: bold;">联系人:</div></td>
					<td>${cgzhxmBean.lxr }<c:if
							test="${ cgzhxmBean.lxr.equals('') || cgzhxmBean.lxr==null  }">未标注</c:if></td>
					<td width="130px"><div align="left" style="font-weight: bold;">联系人电话:</div></td>
					<td>${cgzhxmBean.dh }<c:if
							test="${  cgzhxmBean.dh.equals('') || cgzhxmBean.dh==null  }">未标注</c:if></td>
				</tr>
				<tr height="36">
					<td width="130px"><div align="left" style="font-weight: bold;">成果属性:</div></td>
					<td>${cgzhxmBean.cgsx }<c:if
							test="${  cgzhxmBean.cgsx.equals('') || cgzhxmBean.cgsx==null  }">未标注</c:if></td>
					<td width="130px"><div align="left" style="font-weight: bold;">年份:</div></td>
					<td>${cgzhxmBean.nf }<c:if
							test="${  cgzhxmBean.nf.equals('') || cgzhxmBean.nf==null  }">未标注</c:if></td>
				</tr>
				<tr height="36">
					<td width="130px"><div align="left" style="font-weight: bold;">通讯地址:</div></td>
					<td>${cgzhxmBean.dz }<c:if
							test="${  cgzhxmBean.dz.equals('') || cgzhxmBean.dz==null  }">未标注</c:if></td>
					<td width="130px"><div align="left" style="font-weight: bold;">核心专利:</div></td>
					<td>${cgzhxmBean.hxzl }<c:if
							test="${  cgzhxmBean.hxzl.equals('') || cgzhxmBean.hxzl==null  }">未标注</c:if></td>
				</tr>
				<tr height="36">
					<td width="130px"><div align="left" style="font-weight: bold;">关键词</div></td>
					<td colspan="3"><input style="display: none;" id="gjc"
						name="gjc" type="text" />${cgzhxmBean.gjc }<c:if
							test="${cgzhxmBean.gjc.equals('') || cgzhxmBean.gjc==null  }">未标注</c:if></td>
				</tr>
				<tr height="36">
					<td colspan="1" valign="top"><div align="left"
							style="font-weight: bold; vertical-align: top">简介:</div></td>
					<td colspan="3">${cgzhxmBean.gbnr }<c:if
							test="${ cgzhxmBean.gbnr.equals('') || cgzhxmBean.gbnr==null  }">未标注</c:if>
					</td>

				</tr>
			</c:if>
		</table>
	</div>
</body>
</html>