<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>河北创新驿站协同工作平台</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--     css    js   链接	   -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/title.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-1.4.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/chang${pageContext.request.contextPath}/images.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/refresh.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/login.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/search.js"></script>
<!--     css    js   链接	   -->
</head>

<script type="text/javascript">
function stage(){
	var powerid = $("#power").val();
	if(powerid=="0"){
		alert("您的账号还没有被审核，请耐心等待。。。");
	}
	else{
		window.location.href="${pageContext.request.contextPath}/back/main.jsp";
	}
}
//onClick="stage()"
</script>

<body background="${pageContext.request.contextPath}/images/erjibg.jpg"
	style="background-position: 0px 42px">
	<c:if test="${not empty user}">
		<div class="top_login">
			<div class="login_in">
				<div align="center">
					<label>用户名：</label> <input id="username" type="text"
						style="width: 80px"> <label>密码：</label> <input
						id="password" type="password" style="width: 80px"> <label>验证码：</label>
					<input id="randcode" type="text" style="width: 40px"> <img
						src="js/randCode.jsp" id="shuaxin"
						style="width: 40px; height: 20px"> <input name="login"
						id="login" type="submit" value="登录"
						style="background: #214278; width: 60px; color: white">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
						onClick="window.location='register.jsp'" type="submit"
						name="zhuce" id="zhuce" value="注册"
						style="background: #214278; width: 60px; color: white">
				</div>
			</div>
		</div>
	</c:if>
	<c:if test="${empty user}">
		<div class="top_login">
			<div class="login_in">
				<div align="center">
					<input type="hidden" id="power" value="${user.id }"> <label>尊敬
						的,${user.username },您好！
					</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <label>欢迎使用河北省创新驿站协同工作平台</label>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <label><a
						onClick="stage()">用户中心</a></label>&nbsp;&nbsp;&nbsp; <a href="ExitServlet"
						style="margin-right: 30px; text-decoration: none;"><label>退出登录</label></a>
				</div>
			</div>
		</div>
	</c:if>
	<div align="center">
		<br> <br>
		<!-- Save for Web Slices (创新驿站3切.psd) -->
		<table id="__01" width="1006" height="1188" border="0" cellpadding="0"
			cellspacing="0">
			<tr>
				<td colspan="14"><img src="${pageContext.request.contextPath}/images/erji_01.jpg" width="1005"
					height="120" alt=""></td>
				<td><img src="${pageContext.request.contextPath}/images/&#x5206;&#x9694;&#x7b26;.gif" width="1"
					height="120" alt=""></td>
			</tr>
			<tr>
				<td height="45" colspan="15" background="${pageContext.request.contextPath}/images/erji_02.jpg">
					<div align="center">
						<ul class="title">
							<li><a href="index.jsp" onclick='ccc()'><font
									color="#FFFFF" style="font-weight: bold;">首&nbsp;&nbsp;页</font></a>&nbsp;&nbsp;&nbsp;&nbsp;▕&nbsp;&nbsp;&nbsp;&nbsp;</li>
							<li><a href="secondary.jsp" onclick='ccc()'><font
									color="#FFFFFF" style="font-weight: bold;">新闻公告</font></a>&nbsp;&nbsp;&nbsp;&nbsp;▕&nbsp;&nbsp;&nbsp;&nbsp;</li>
							<li><a href="${pageContext.request.contextPath}/front/QYXQ.jsp" onclick='ccc()'><font
									color="#FFFFFF" style="font-weight: bold;">企业需求</font></a>&nbsp;&nbsp;&nbsp;&nbsp;▕&nbsp;&nbsp;&nbsp;&nbsp;</li>
							<li><a href="JSGJ.jsp" onclick='ccc()'><font
									color="#FFFFFF" style="font-weight: bold;">技术供给</font></a>&nbsp;&nbsp;&nbsp;&nbsp;▕&nbsp;&nbsp;&nbsp;&nbsp;</li>
							<li><a href="KJCG.jsp" onclick='ccc()'><font
									color="#FFFFFF" style="font-weight: bold;">科技成果</font></a>&nbsp;&nbsp;&nbsp;&nbsp;▕&nbsp;&nbsp;&nbsp;&nbsp;</li>
							<li><a href="ZTZL.jsp" onclick='ccc()'><font
									color="#FFFFFF" style="font-weight: bold;">专题专利</font></a>&nbsp;&nbsp;&nbsp;&nbsp;▕&nbsp;&nbsp;&nbsp;&nbsp;</li>
							<li><a href="ZCFG.jsp" onclick='ccc()'><font
									color="#FFFFFFF" style="font-weight: bold;">政策法规</font></a>&nbsp;&nbsp;&nbsp;&nbsp;▕&nbsp;&nbsp;&nbsp;&nbsp;</li>
							<li><a href="ZJXX.jsp" onclick='ccc()'><font
									color="#FFFFFF" style="font-weight: bold;">专家信息</font></a>&nbsp;&nbsp;&nbsp;&nbsp;▕&nbsp;&nbsp;&nbsp;&nbsp;</li>
							<li><a href="FWPT.jsp?look=2" onclick='ccc()'><font
									color="#FFFFFF" style="font-weight: bold;">合作站点</font></a></li>
						</ul>
					</div>
				</td>
				<td><img src="${pageContext.request.contextPath}/images/&#x5206;&#x9694;&#x7b26;.gif" width="1"
					height="31" alt=""></td>
			</tr>
			<tr>
				<td colspan="3"><img src="${pageContext.request.contextPath}/images/index_03.jpg" width="46"
					height="37" alt=""></td>
				<td colspan="4" background="${pageContext.request.contextPath}/images/0index_03.jpg"><span
					class="STYLE3">您现在的位置：&nbsp;&nbsp;河北创新驿站&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;首页</span></td>
				<td colspan="5" background="${pageContext.request.contextPath}/images/0index_03.jpg"><label>

				</label><label>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp; <input width="310" height="18" type="text"
						name="globalsearch" id="globalsearch">
				</label></td>
				<td colspan="2"><img src="${pageContext.request.contextPath}/images/index_06.jpg" width="38"
					height="37" alt="" name="global" id="global"></td>
				<td><img src="${pageContext.request.contextPath}/images/&#x5206;&#x9694;&#x7b26;.gif" width="1"
					height="37" alt=""></td>
			</tr>
			<tr>
				<td colspan="5"><a href="JSGJ.jsp"> <img
						src="${pageContext.request.contextPath}/images/index_07.jpg" width="257" height="49" alt=""></a></td>
				<%--图片新闻   start--%>
				<%-- <input type="hidden" id="img<%=i %>" value="<%=photo.getString("id") %>,<%=photo.getString("title") %>,<%=photo.getString("image") %>"> --%>
				<td colspan="4" rowspan="4">
					<div class=pic_show style="width: 491px;">
						<div id="imgADPlayer"></div>
						
					</div>
				</td>
				<%--图片新闻   start--%>
				<td colspan="5"><a href="QYXQ.jsp"><img
						src="${pageContext.request.contextPath}/images/index_09.jpg" width="257" height="49" alt=""></a></td>
				<td><img src="${pageContext.request.contextPath}/images/&#x5206;&#x9694;&#x7b26;.gif" width="1"
					height="49" alt=""></td>
			</tr>
			<tr>
				<td colspan="2" rowspan="2"><img src="${pageContext.request.contextPath}/images/index_10.jpg"
					width="15" height="165" alt=""></td>
				<%--找技术块   start--%>
				<td colspan="2" rowspan="2" bgcolor="#FFFFFF">
					<div class="diyi_left">
						<div class="zq">
							<ul>
								
							</ul>
						</div>
					</div>
				</td>
				<%--找技术块  end--%>
				<td rowspan="2"><img src="${pageContext.request.contextPath}/images/index_12.jpg" width="13"
					height="165" alt=""></td>
				<td colspan="2"><img src="${pageContext.request.contextPath}/images/index_13.jpg" width="15"
					height="164" alt=""></td>

				<td colspan="2" bgcolor="#FFFFFF">
					<!-- 找需求	     -->
					<div class="diyi_left">
						<div class="zq">
							<ul>
								<!--         五条记录 -->
							</ul>
						</div>
					</div>

				</td>
				<!-- 	    找需求 -->
				<td><img src="${pageContext.request.contextPath}/images/index_15.jpg" width="13" height="164"
					alt=""></td>
				<td><img src="${pageContext.request.contextPath}/images/&#x5206;&#x9694;&#x7b26;.gif" width="1"
					height="164" alt=""></td>
			</tr>
			<tr>
				<td colspan="5" rowspan="3"><a href="FWPT.jsp"><img
						src="${pageContext.request.contextPath}/images/index_16.jpg" width="257" height="59" alt=""></a></td>
				<td><img src="${pageContext.request.contextPath}/images/&#x5206;&#x9694;&#x7b26;.gif" width="1"
					height="1" alt=""></td>
			</tr>
			<tr>
				<td colspan="5" rowspan="2"><a href="KJCG.jsp"><img
						src="${pageContext.request.contextPath}/images/index_17.jpg" width="257" height="58" alt=""></a></td>
				<td><img src="${pageContext.request.contextPath}/images/&#x5206;&#x9694;&#x7b26;.gif" width="1"
					height="9" alt=""></td>
			</tr>
			<tr>
				<td colspan="4"><a href="secondary.jsp"><img
						src="${pageContext.request.contextPath}/images/index_18.jpg" width="492" height="49" alt=""></a></td>
				<td><img src="${pageContext.request.contextPath}/images/&#x5206;&#x9694;&#x7b26;.gif" width="1"
					height="49" alt=""></td>
			</tr>
			<tr>
				<td colspan="2" rowspan="2"><img src="${pageContext.request.contextPath}/images/index_19.jpg"
					width="15" height="149" alt=""></td>

				<!-- 	    找成果 -->
				<td colspan="2" rowspan="2" bgcolor="#FFFFFF">
					<div class="diyi_left">
						<div class="zq">
							<ul>
								<!--         五条记录 -->
							</ul>
						</div>
					</div>
				</td>
				<!-- 	    找成果 -->

				<td colspan="2" rowspan="2"><img src="${pageContext.request.contextPath}/images/index_21.jpg"
					width="28" height="149" alt=""></td>
				<!-- 	   国内新闻  -->
				<td colspan="2" background="${pageContext.request.contextPath}/images/0index_19.jpg">
					<div class="diyi_center">
						<div class="zq">
							<ul>
								<!--         四条记录 -->
							</ul>
						</div>
					</div>
				</td>
				<!-- 	   国内新闻 -->
				<td colspan="3" rowspan="3"><img src="${pageContext.request.contextPath}/images/index_23.jpg"
					width="32" height="151" alt=""></td>
				<!-- 	   找平台  -->
				<td colspan="2" rowspan="3" bgcolor="#FFFFFF">
					<div class="diyi_left">
						<div class="zq">
							<ul>
								<!--         五条记录 -->
							</ul>
						</div>
					</div>
				</td>
				<!-- 	    找平台 -->
				<td rowspan="3"><img src="${pageContext.request.contextPath}/images/index_25.jpg" width="13"
					height="151" alt=""></td>
				<td><img src="${pageContext.request.contextPath}/images/&#x5206;&#x9694;&#x7b26;.gif" width="1"
					height="143" alt=""></td>
			</tr>
			<tr>
				<td colspan="2" rowspan="3"><a href="secondary.jsp"><img
						src="${pageContext.request.contextPath}/images/index_26.jpg" width="460" height="61" alt=""></a></td>
				<td><img src="${pageContext.request.contextPath}/images/&#x5206;&#x9694;&#x7b26;.gif" width="1"
					height="6" alt=""></td>
			</tr>
			<tr>
				<td colspan="5" rowspan="3"><a href="ZTZL.jsp"><img
						src="${pageContext.request.contextPath}/images/index_27.jpg" width="257" height="56" alt=""></a></td>
				<td rowspan="4"><img src="${pageContext.request.contextPath}/images/index_28.jpg" width="15"
					height="200" alt=""></td>
				<td><img src="${pageContext.request.contextPath}/images/&#x5206;&#x9694;&#x7b26;.gif" width="1"
					height="2" alt=""></td>
			</tr>
			<tr>
				<td rowspan="3"><img src="${pageContext.request.contextPath}/images/index_29.jpg" width="17"
					height="198" alt=""></td>
				<td colspan="5"><a href="ZJXX.jsp"><img
						src="${pageContext.request.contextPath}/images/index_30.jpg" width="257" height="53" alt=""></a></td>
				<td><img src="${pageContext.request.contextPath}/images/&#x5206;&#x9694;&#x7b26;.gif" width="1"
					height="53" alt=""></td>
			</tr>
			<tr>
				<!--      通知公告 -->
				<td colspan="2" rowspan="2" background="${pageContext.request.contextPath}/images/0index_28.jpg">
					<div class="diyi_center">
						<div class="zq">
							<ul>
								<!--         四条记录 -->
							</ul>
						</div>
					</div>
				</td>
				<!-- 	   通知公告 -->
				<td colspan="2" rowspan="2"><img src="${pageContext.request.contextPath}/images/index_32.jpg"
					width="15" height="145" alt=""></td>
				<!-- 	    找专家 -->
				<td colspan="2" rowspan="2" bgcolor="#FFFFFF">
					<div class="diyi_left">
						<div class="zq">
							<ul>
								<!--         五条记录 -->
							</ul>
						</div>
					</div>
				</td>
				<!-- 	    找专家 -->
				<td rowspan="4"><img src="${pageContext.request.contextPath}/images/index_34.jpg" width="13"
					height="353" style="" alt=""></td>
				<td><img src="${pageContext.request.contextPath}/images/&#x5206;&#x9694;&#x7b26;.gif" width="1"
					height="1" alt=""></td>
			</tr>
			<tr>
				<td colspan="2"><img src="${pageContext.request.contextPath}/images/index_35.jpg" width="15"
					height="144" alt=""></td>

				<!-- 	    找专利 -->
				<td colspan="2" bgcolor="#FFFFFF">
					<div class="diyi_left">
						<div class="zq">
							<ul>
							</ul>
						</div>
					</div>

				</td>
				<!-- 	    找专利 -->

				<td><img src="${pageContext.request.contextPath}/images/index_37.jpg" width="13" height="144"
					alt=""></td>
				<td><img src="${pageContext.request.contextPath}/images/&#x5206;&#x9694;&#x7b26;.gif" width="1"
					height="144" alt=""></td>
			</tr>
			<tr>
				<td colspan="11"><img src="${pageContext.request.contextPath}/images/index_38.jpg" width="764"
					height="68" alt=""></td>
				<td colspan="2"><img src="${pageContext.request.contextPath}/images/index_39.jpg" width="229"
					height="68" alt=""></td>
				<td><img src="${pageContext.request.contextPath}/images/&#x5206;&#x9694;&#x7b26;.gif" width="1"
					height="68" alt=""></td>
			</tr>
			<tr>
				<td><img src="${pageContext.request.contextPath}/images/index_40.jpg" width="7" height="140"
					alt=""></td>
				<!-- 	   企业信息 -->
				<td colspan="9">
					<div class="yqlj">
						<table width="720" border="1">
							<tr>
								<td width="138" height="41"><img
									src="${pageContext.request.contextPath}/images/yqlj/yqlj1.png" width="138" height="37" /></td>
								<td width="138"><img src="${pageContext.request.contextPath}/images/yqlj/yqlj2.png" alt=""
									width="138" height="37" /></td>
								<td width="138"><img src="${pageContext.request.contextPath}/images/yqlj/yqlj3.png" alt="]"
									width="138" height="37" /></td>
								<td width="138"><img src="${pageContext.request.contextPath}/images/yqlj/yqlj4.png" alt=""
									width="138" height="37" /></td>
								<td width="134"><img src="${pageContext.request.contextPath}/images/yqlj/yqlj5.png" alt=""
									width="138" height="37" /></td>
							</tr>
							<tr>
								<td><a href="">珠三角技术转移联盟</a></td>
								<td><a href="">石油化工技术转移联盟</a></td>
								<td><a href="">石油化工技术转移联盟</a></td>
								<td><a href="">浙江网上技术市场中介服务联盟</a></td>
								<td><a href="">济南都市圈技术转移联盟</a></td>
							</tr>
							<tr>
								<td height="23"><img src="${pageContext.request.contextPath}/images/yqlj/yqlj6.png" alt=""
									width="138" height="37" /></td>
								<td><img src="${pageContext.request.contextPath}/images/yqlj/yqlj7.png" alt="" width="138"
									height="37" /></td>
								<td><img src="${pageContext.request.contextPath}/images/yqlj/yqlj8.png" alt="" width="138"
									height="37" /></td>
								<td><img src="${pageContext.request.contextPath}/images/yqlj/yqlj9.png" alt="" width="138"
									height="37" /></td>
								<td><img src="${pageContext.request.contextPath}/images/yqlj/yqlj10.png" alt="" width="138"
									height="37" /></td>
							</tr>
							<tr>
								<td height="23"><a href="">长三角科技中介战略联盟</a></td>
								<td><a href="">东北技术转移联盟</a></td>
								<td><a href="">长三角科技中介战略联盟</a></td>
								<td><a href="">饲料产业技术创新战略联盟</a></td>
								<td><a href="">安徽技术转移联盟</a></td>
							</tr>
						</table>
					</div>
				<td>
					<!-- 		    企业信息 --> <img src="${pageContext.request.contextPath}/images/index_42.jpg" width="14"
					height="140" alt="">
				</td>
				<!-- 	    找政策 -->
				<td colspan="2" bgcolor="#FFFFFF">
					<div class="diyi_left">
						<div class="zq">
							<ul>
							</ul>
						</div>
					</div>
				</td>
				<!-- 	    找政策 -->
			<tr>
				<td height="29" colspan="14"><div align="left">
						<br> <font color=#000099 size="4"><strong>友情链接</strong></font>
						<select
							onChange="window.open(this.options[this.selectedIndex].value)">
							<option selected>--省内创新驿站--</option>
							<option
								value="http://www.sjzkj.gov.cn/cyportal/template/site00_index.jsp">石家庄</option>
							<option value="http://www.chengde.gov.cn/">承德市</option>
							<option value="http://www.zjkkj.gov.cn/">张家口市</option>
							<option value="http://www.tskj.com.cn/">唐山市</option>
							<option value="http://www.lfinfo.gov.cn/">廊坊市</option>
							<option
								value="http://www.sjzkj.gov.cn/cyportal/template/site00_index.jsp">石家庄</option>
							<option
								value="http://www.sjzkj.gov.cn/cyportal/template/site00_index.jsp">石家庄</option>
							<option
								value="http://www.sjzkj.gov.cn/cyportal/template/site00_index.jsp">石家庄</option>
						</select> <select
							onChange="window.open(this.options[this.selectedIndex].value)">
							<option selected>--省外创新驿站--</option>
							<option value="http://www.jscxyz.com">江苏创新驿站</option>
							<option value="http://sirn.jinshan.gov.cn">上海创新驿站协同工作平台</option>
							<option value="http://www.nbpc.org.cn ">宁波市创新驿站</option>
							<option value="http://www.gpcstd.com">甘肃省创新驿站</option>
							<option value="http://www.szjssc.org.cn">深圳市创新驿站</option>
							<option value="http://www.cttip.org">中国技术交易信息服务平台</option>
							<option value="http://hebei.ctexmall.com">京津冀技术交易河北平台</option>
							<option value="http://www.ctexmall.com">中国技术交易网络平台</option>
						</select>

					</div></td>
			</tr>
			<!-- <tr>
				<td  colspan="14" height ="12" background="${pageContext.request.contextPath}/images/index_0900.jpg"><div align="center" class="STYLE2">
						<a style="color: #FFFFFF" href="lxwm.jsp">联系我们</a>&nbsp;&nbsp;|&nbsp;&nbsp;设为首页&nbsp;&nbsp;|&nbsp;&nbsp;加入收藏&nbsp;&nbsp;|&nbsp;&nbsp;<a
							href="mzsm.jsp" style="color: #ffffff">免责声明</a>
					</div></td>
	</tr>
			<tr>
				<td colspan="14" height ="167"  background="${pageContext.request.contextPath}/images/index_651.jpg"><div
						align="center" class="STYLE3">
						版权所有 @ 河北省科学技术情报研究院科技政策服务平台 <br> 地址: 河北省石家庄市青园街233号 邮编：050021
					</div></td>
					<td>
		    <img src="${pageContext.request.contextPath}/images/&#x5206;&#x9694;&#x7b26;.gif" width="1" height="" alt=""></td>
			</tr> -->

			<tr>
				<td colspan="14" background="${pageContext.request.contextPath}/images/0index_41.jpg">
					<div align="center" class="STYLE2">
						CopyRight STDU All Right Reserved 版权所有：河北省情报院<br>
						地址：河北省石家庄市北二环东路17号石家庄铁道大学 电话：0311-XXXXXXXXXXX<br>
						技术支持：石家庄铁道大学 备案号：ABCDEFG <a href="mzsm.jsp">免责声明</a>
					</div>
				</td>
				<td><img src="${pageContext.request.contextPath}/images/&#x5206;&#x9694;&#x7b26;.gif" width="1"
					height="167" alt=""></td>
			</tr>
			<tr>
				<td colspan="14"><img src="${pageContext.request.contextPath}/images/index_45.jpg" width="1005"
					height="3" alt=""></td>
				<td><img src="${pageContext.request.contextPath}/images/&#x5206;&#x9694;&#x7b26;.gif" width="1"
					height="3" alt=""></td>
			</tr>
			<tr>
				<td><img src="${pageContext.request.contextPath}/images/&#x5206;&#x9694;&#x7b26;.gif" width="7"
					height="1" alt=""></td>
				<td><img src="${pageContext.request.contextPath}/images/&#x5206;&#x9694;&#x7b26;.gif" width="8"
					height="1" alt=""></td>
				<td><img src="${pageContext.request.contextPath}/images/&#x5206;&#x9694;&#x7b26;.gif" width="31"
					height="1" alt=""></td>
				<td><img src="${pageContext.request.contextPath}/images/&#x5206;&#x9694;&#x7b26;.gif" width="198"
					height="1" alt=""></td>
				<td><img src="${pageContext.request.contextPath}/images/&#x5206;&#x9694;&#x7b26;.gif" width="13"
					height="1" alt=""></td>
				<td><img src="${pageContext.request.contextPath}/images/&#x5206;&#x9694;&#x7b26;.gif" width="15"
					height="1" alt=""></td>
				<td><img src="${pageContext.request.contextPath}/images/&#x5206;&#x9694;&#x7b26;.gif" width="381"
					height="1" alt=""></td>
				<td><img src="${pageContext.request.contextPath}/images/&#x5206;&#x9694;&#x7b26;.gif" width="78"
					height="1" alt=""></td>
				<td><img src="${pageContext.request.contextPath}/images/&#x5206;&#x9694;&#x7b26;.gif" width="17"
					height="1" alt=""></td>
				<td><img src="${pageContext.request.contextPath}/images/&#x5206;&#x9694;&#x7b26;.gif" width="1"
					height="1" alt=""></td>
				<td><img src="${pageContext.request.contextPath}/images/&#x5206;&#x9694;&#x7b26;.gif" width="14"
					height="1" alt=""></td>
				<td><img src="${pageContext.request.contextPath}/images/&#x5206;&#x9694;&#x7b26;.gif" width="204"
					height="1" alt=""></td>
				<td><img src="${pageContext.request.contextPath}/images/&#x5206;&#x9694;&#x7b26;.gif" width="25"
					height="1" alt=""></td>
				<td><img src="${pageContext.request.contextPath}/images/&#x5206;&#x9694;&#x7b26;.gif" width="13"
					height="1" alt=""></td>
				<td></td>
			</tr>
		</table>
		<!-- End Save for Web Slices -->
	</div>
</body>
</html>