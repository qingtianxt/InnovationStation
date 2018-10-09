<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<div class="display1" style="margin: auto;min-height: 500px">
	<table
		style="width: 835px; margin: auto; border-collapse: collapse;">
		<tr>
			<td valign="top"
				background="${pageContext.request.contextPath}/front/images/news_read.jpg"
				bgcolor="#FFFFFF" align="center">
				<table
					style="width: 95%; margin: auto; border-collapse: collapse;">
					<tr>
						<td>&nbsp;</td>
					</tr>
					<tr>

						<td height="50" align="center" class="article_title" style="color: #0B3E97;font-size: 16px; text-decoration: none; font-weight: bold;">${patent.fmmc}</td>
					</tr>
					<tr>
						<td height="35">
							<p class="sub-title" style="text-align: center; font-size: 12px; line-height: 24px;">
								<!--<$[信息来源]>end-->
								<strong>发表日期</strong>：
								<!--<$[发布日期]>begin-->
								${patent.sqrq}
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
							<table class="table" style="margin:auto;width:100%;color: #333333;font-size: 14px;  line-height: 180%;  text-decoration: none;border-collapse: collapse;">
								<tr>
									<td width="100" class="title"><div align="left">专利号</div></td>
									
									<td width="166" >${requestScope.patent.zlh }</td>
									<td width="100" class="title"><div align="left">申请日期</div></td>
									<td width="166">${requestScope.patent.sqrq }
								</tr>
								<tr>
									<td class="title"><div align="left">公开（公告）号</div></td>
									<td width="166">${requestScope.patent.gkh }</td>
									<td width="100" class="title"><div align="left">公开（公告）日</div></td>
									<td width="166">${requestScope.patent.gkr }
									</td>
								</tr>
								<tr>
									<td class="title"><div align="left" >发明名称</div></td>
									<td>${requestScope.patent.fmmc }</td>
									<td class="title"><div align="left">IPC分类号</div></td>
									<td>${requestScope.patent.ipc_flh }</td>
								</tr>
								<c:if test="${empty sessionScope.session_user }">
									<tr>
										<td colspan="4"><div>
												<font color="red">如果您想查询项目具体的详细信息，请您<a
													href='${pageContext.request.contextPath}/front/index.jsp'>登录</a>，如您还没有开通创新驿站账号，请立即 <a
													href='${pageContext.request.contextPath}/front/register.jsp' target="_blank">注册</a></font>
											</div></td>
									</tr>
								</c:if>
								<c:if test="${!empty sessionScope.session_user }">
									<tr>
										<td class="title"><div align="left">发明人</div></td>
										<td>${requestScope.patent.fmr }</td>
										<td class="title"><div align="left">申请人</div></td>
										<td>${requestScope.patent.sqr }
										</td>
									</tr>
									<tr>
										<td class="title"><div align="left">优先权日</div></td>
										<td>${requestScope.patent.yxqr }</td>
										<td class="title"><div align="left">优先权号</div></td>
										<td>${requestScope.patent.yxqh }</td>
									</tr>
									<tr>
										<td class="title"><div align="left">法律状态</div></td>
										<td>${requestScope.patent.flzt }</td>
										<td class="title"><div align="left">申请人地址</div></td>
										<td>${requestScope.patent.sqrdz }</td>
									</tr>
									<tr>
										<td class="title" valign="top"><div align="left">摘要</div></td>
										<td  colspan="3">${requestScope.patent.zy }
										</td>
									</tr>
								</c:if>
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