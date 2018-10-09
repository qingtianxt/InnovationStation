<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<!-- 	<link rel="stylesheet" type="text/css" href="css/title.css" /> -->
	<jsp:include page="links.jsp"></jsp:include>
<!--     css    js   链接	   -->
	<style>
	body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-repeat: repeat-x;
	background-color: #FFFFFF;
	

}
#global{
 cursor: pointer;
}
.STYLE1 {
	font-size: 14px;
	font-weight: bold;
	color: #ffffff;
}



.STYLE2 {
	font-size: 14px;
	font-weight: bold;
	color: #000000;
}

.STYLE3 {
	color: #003366;
	font-size: 12px;
}

/* .title { */
/* 	font-size: 14px; */
/* 	font-weight: bold; */
/* 	position: relative; */
/* 	top: 0px; */
/* 	margin-left: 60px; */
/* 	float: left; */
/* 	width: 100%; */
/* 	color: #FFFFF; */
/* } */

/* .title li { */
/* 	display: inline-block; */
/* 	float: left; */
/* 	line-height: 20px; */
/* 	color: #FFFFF; */
/* } */

/* .title>li>a { */
/* 	font-size: 14px; */
/* 	color: #FFFFFF; */
/* 	text-decoration: none; */
/* } */

/* .title li:hover>a { */
/* 	background: #fffff; */
/* 	color: #ffffff; */
/* } */

ul,li {
	margin: 0px;
	padding: 0px;
	list-style: none;
}

p {
	margin-top: 0px;
	margin-bottom: 0px;
	font-size: 12px;
	line-height: 24px;
}

a {
	color: #06C;
	text-decoration: none;
	font-size: 14px;
}



.diyi_left {
	width: 225px;
	margin: 0px 0;
	overflow: hidden;
	border: #CCC solid 0px;    /*çŸ©å½¢æ¡† 0pxæ²¡æœ‰     1pxæœ‰çŸ©å½¢æ¡†*/
	float: left;
	height: 140px;
}

.zq {
	width: 460px;
	margin: 0px auto;  /*è°ƒèŠ‚çŸ©å½¢æ¡†çš„å¤§å°*/
	overflow: hidden;
	line-height: 24px;
	color: #666;
}

.zq ul li {
	font-size: 8px;
	line-height: 28px;  /*ç‚¹ç‚¹çº¿è·ç¦»çŸ©å½¢æ¡†ä¸Šè¾¹ç•Œçš„è·ç¦»*/
 	border-bottom: dashed 1px #CCC;    /*ç‚¹ç‚¹çº¿ */
	background: url(${pageContext.request.contextPath}/front/images/list.gif) no-repeat 0px 0px;
	padding-left: 0px;
	white-space: nowrap;
	overflow: hidden;
	text-overflow: ellipsis;
}

.zq ul li a {
	color: #666;
}

.zq ul li span {
	font-size: 10px;
	color: #06C;
}

.zq ul li a:hover {
	text-decoration: underline;
}



.top_login {
	background: #d1e8fe;
	height: 40px;
	/* position: fixed; */
	left: 0px;
	top: 0px;
	width: 100%;
	/* z-index: 999999; */
}

.login_in {
	width: 1000px;
	margin: 0px auto;
	line-height: 40px;
}

.login_in a {
	color: #000;
}



.yqlj table tr td a {
	font-size: 14px
}
.yqlj table tr td a:link {
	color: #000000;
	text-decoration: none;
}
/* æ¿€æ´»ï¼šçº¢è‰² */
.yqlj table tr td a:active: {
	color: red;
}
.yqlj table tr td a:visited {
	color: purple;
	text-decoration: none;
}
.yqlj table tr td a:hover {
	color: blue;
	text-decoration: underline;
}
.group{
	color: #666;
	display:box;
	display:-moz-box;
	display:-webkit-box;
	display:-ms-flexbox;
    border-bottom: dashed 1px #CCC;
    background: url(${pageContext.request.contextPath}/front/images/list.gif) no-repeat 0px 0px;
    
}
/* .group:AFTER { */
/* 	content: "  >>"; */
/* } */
.group a{
	color:#666;
}
.group a:HOVER{
	color:#06c;
}
.item{
	width:200px;
	white-space: nowrap;
	overflow: hidden;
	text-overflow: ellipsis;
	font-size: 8px;
    line-height: 28px;
}
	</style>
</head>



<body style="background-position:0px 42px;background-image:url('${pageContext.request.contextPath}/front/images/erjibg.jpg'); ;background-repeat: repeat-x;" >
<c:if test="${empty sessionScope.session_user }">
	<c:import url="${paggeContext.request.contextPath }/front/login.jsp"></c:import>
</c:if>
<c:if test="${! empty sessionScope.session_user }">
	<c:import url="${paggeContext.request.contextPath }/front/top.jsp"></c:import>
</c:if>
<div align="center">


  <!-- Save for Web Slices (创新驿站3切.psd) -->
  <table id="__01" width="1006" height="1188" border="0" cellpadding="0" cellspacing="0">
    <tr>
      <td colspan="14">
        <img src="${pageContext.request.contextPath}/front/images/erji_01.jpg" width="1005" height="120" alt=""></td>
	    <td>
		    <img src="${pageContext.request.contextPath}/front/images/&#x5206;&#x9694;&#x7b26;.gif" width="1" height="120" alt=""></td>
	  </tr>
    <tr>
      <td height="45" colspan="15" background="${pageContext.request.contextPath}/front/images/erji_02.jpg">
        <div align="center">
        <div class="nav" style="color:#ffffff;font-weight: bolid">
	<ul class="title" style="padding:0;margin:0">
            <li><a href="${pageContext.request.contextPath}/front/index.jsp" >首&nbsp;&nbsp;页</a>
            <li><a href="${pageContext.request.contextPath}/front/news/newsServlet?method=list" >新闻公告</a>
            <li><a href="${pageContext.request.contextPath}/front/qyxq/qyxqFrontServlet?method=getList&currentPage=1">企业需求</a>
            <li><a href="${pageContext.request.contextPath}/front/technology_supply/supplyServlet?method=list&result=front">技术供给</a>
            <li><a href="${pageContext.request.contextPath}/front/kjcg/kjcgFrontServlet?method=getList&currentPage=1">科技成果</a>
            <li><a href="${pageContext.request.contextPath}/front/special_library/libraryServlet?method=list">专题专利</a>
            <li><a href="${pageContext.request.contextPath}/front/zcfg/zcfgFrontServlet?method=getList&currentPage=1">政策法规</a>
            <li><a href="${pageContext.request.contextPath}/front/zjxx/zjxxFrontServlet?method=getFrontList&currentPage=1">专家信息</a>
            <li><a href="${pageContext.request.contextPath}/front/site/siteServlet?method=list">合作站点</a></li>
            <li><a href="${pageContext.request.contextPath}/front/fwpt/FwptServlet?method=getList&currentPage=1">服务平台</a></li>
   </ul>    
</div>
        </div>
      </td>
	    <td>
		    <img src="${pageContext.request.contextPath}/front/images/&#x5206;&#x9694;&#x7b26;.gif" width="1" height="31" alt=""></td>
	  </tr>
    <tr>
      <td colspan="3">
        <img src="${pageContext.request.contextPath}/front/images/index_03.jpg" width="46" height="37" alt=""></td>
	    <td colspan="4" background="${pageContext.request.contextPath}/front/images/0index_03.jpg"><span class="STYLE3">您现在的位置：&nbsp;&nbsp;河北创新驿站&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;首页</span></td>
	    <td colspan="5" background="${pageContext.request.contextPath}/front/images/0index_03.jpg" style="text-align: right;">
	    <label>
	        <input width="310" height="18" type="text" name="globalsearch" id="globalsearch"> 
        </label></td>
	    <td colspan="2">
		    <img src="${pageContext.request.contextPath}/front/images/index_06.jpg" width="38" height="37" alt="" name="global" id="global"></td>
	    <td>
		    <img src="${pageContext.request.contextPath}/front/images/&#x5206;&#x9694;&#x7b26;.gif" width="1" height="37" alt=""></td>
	  </tr>
    <tr>
      <td colspan="5">
       <a href="${pageContext.request.contextPath}/front/technology_supply/supplyServlet?method=list&result=front" target="_block"> 
       	<img  src="${pageContext.request.contextPath}/front/images/index_07.jpg" width="257" height="49" alt=""></a>
       </td>
 <%--图片新闻   start--%>
<%-- <input type="hidden" id="img<%=i %>" value="<%=photo.getString("id") %>,<%=photo.getString("title") %>,<%=photo.getString("image") %>"> --%>
<td colspan="4" rowspan="4">
		<div id="imgADPlayer" style="width:491;height: 223"></div>

		</td>
 <%--图片新闻   start--%>
	    <td colspan="5">
		    <a href="${pageContext.request.contextPath}/front/qyxq/qyxqFrontServlet?method=getList&currentPage=1"><img src="${pageContext.request.contextPath}/front/images/index_09.jpg" width="257" height="49" alt=""></a></td>
	    <td>
		    <img src="${pageContext.request.contextPath}/front/images/&#x5206;&#x9694;&#x7b26;.gif" width="1" height="49" alt=""></td>
	  </tr>
    <tr>
      <td colspan="2" rowspan="2">
        <img src="${pageContext.request.contextPath}/front/images/index_10.jpg" width="15" height="165" alt=""></td>
   <%--找技术块   start--%>
	    <td colspan="2" rowspan="2" bgcolor="#FFFFFF">
	    <div class="diyi_left" id="teachnology">
				<div class="zq">
					<ul>                     <!--         五条记录 -->
					
					</ul>
				</div>
			</div>
	    </td>
	<%--找技术块  end--%>
	    <td rowspan="2">
		    <img src="${pageContext.request.contextPath}/front/images/index_12.jpg" width="13" height="165" alt=""></td>
	    <td colspan="2">
		    <img src="${pageContext.request.contextPath}/front/images/index_13.jpg" width="15" height="164" alt=""></td>
	    
	    <td colspan="2" bgcolor="#FFFFFF">
<!-- 找需求	     -->
	    <div class="diyi_left" id="zxq">
				<div class="zq">
					<ul>                     
          			<!--         五条记录 -->
					
					</ul>
				</div>
			</div>
	    
	    </td>
<!-- 	    找需求 -->
	    <td>
		    <img src="${pageContext.request.contextPath}/front/images/index_15.jpg" width="13" height="164" alt=""></td>
	    <td>
		    <img src="${pageContext.request.contextPath}/front/images/&#x5206;&#x9694;&#x7b26;.gif" width="1" height="164" alt=""></td>
	  </tr>
    <tr>
      <td colspan="5" rowspan="3">
        <a href="${pageContext.request.contextPath}/front/fwpt/FwptServlet?method=list"><img src="${pageContext.request.contextPath}/front/images/index_16.jpg" width="257" height="59" alt=""></a></td>
	    <td>
		    <img src="${pageContext.request.contextPath}/front/images/&#x5206;&#x9694;&#x7b26;.gif" width="1" height="1" alt=""></td>
	  </tr>
    <tr>
      <td colspan="5" rowspan="2">
        <a href="${pageContext.request.contextPath}/front/kjcg/kjcgFrontServlet?method=getList&currentPage=1"><img src="${pageContext.request.contextPath}/front/images/index_17.jpg" width="257" height="58" alt=""></a></td>
	    <td>
		    <img src="${pageContext.request.contextPath}/front/images/&#x5206;&#x9694;&#x7b26;.gif" width="1" height="9" alt=""></td>
	  </tr>
    <tr>
      <td colspan="4">
        <a href="${pageContext.request.contextPath}/front/news/newsServlet?method=list">
        	<img src="${pageContext.request.contextPath}/front/images/index_18.jpg" width="492" height="49" alt=""></a></td>
	    <td>
		    <img src="${pageContext.request.contextPath}/front/images/&#x5206;&#x9694;&#x7b26;.gif" width="1" height="49" alt=""></td>
	  </tr>
    <tr>
      <td colspan="2" rowspan="2">
        <img src="${pageContext.request.contextPath}/front/images/index_19.jpg" width="15" height="149" alt=""></td>
	    
<!-- 	    找成果 -->
	    <td colspan="2" rowspan="2" bgcolor="#FFFFFF">
	     <div class="diyi_left" id="zcg">
				<div class="zq">
					<ul>                     
          			<!--         五条记录 -->
					
					</ul>
				</div>
			</div>
	    </td>
<!-- 	    找成果 -->	    
	    
	    <td colspan="2" rowspan="2">
		    <img src="${pageContext.request.contextPath}/front/images/index_21.jpg" width="28" height="149" alt=""></td>
                                <!-- 	   国内新闻  -->
	    <td colspan="2" background="${pageContext.request.contextPath}/front/images/0index_19.jpg">
<div class="diyi_center" id="internalNews">
				<div class="zq">
					<ul>
					<!--         四条记录 -->
					
				
					</ul>
				</div>
			</div>
        </td>
                                <!-- 	   国内新闻 -->
	    <td colspan="3" rowspan="3">
		    <img src="${pageContext.request.contextPath}/front/images/index_23.jpg" width="32" height="151" alt=""></td>
<!-- 	   找平台  -->
	    <td colspan="2" rowspan="3" bgcolor="#FFFFFF">
        <div class="diyi_left" id="zpt">
				<div class="zq">
					<ul>
					<!--         五条记录 -->
					
					</ul>
				</div>
			</div>
        </td>
<!-- 	    找平台 -->
	    <td rowspan="3">
		    <img src="${pageContext.request.contextPath}/front/images/index_25.jpg" width="13" height="151" alt=""></td>
	    <td>
		    <img src="${pageContext.request.contextPath}/front/images/&#x5206;&#x9694;&#x7b26;.gif" width="1" height="143" alt=""></td>
	  </tr>
    <tr>
      <td colspan="2" rowspan="3">
        <a href="${pageContext.request.contextPath}/front/news/newsServlet?method=list">
        <img src="${pageContext.request.contextPath}/front/images/index_26.jpg" width="460" height="61" alt=""></a></td>
	    <td>
		    <img src="${pageContext.request.contextPath}/front/images/&#x5206;&#x9694;&#x7b26;.gif" width="1" height="6" alt=""></td>
	  </tr>
    <tr>
      <td colspan="5" rowspan="3">
        <a href="${pageContext.request.contextPath}/front/special_library/libraryServlet?method=list" target="_block">
        	<img src="${pageContext.request.contextPath}/front/images/index_27.jpg" width="257" height="56" alt=""></a></td>
	    <td rowspan="4">
		    <img src="${pageContext.request.contextPath}/front/images/index_28.jpg" width="15" height="200" alt=""></td>
	    <td>
		    <img src="${pageContext.request.contextPath}/front/images/&#x5206;&#x9694;&#x7b26;.gif" width="1" height="2" alt=""></td>
	  </tr>
    <tr>
      <td rowspan="3">
        <img src="${pageContext.request.contextPath}/front/images/index_29.jpg" width="17" height="198" alt=""></td>
	    <td colspan="5">
		    <a href="${pageContext.request.contextPath}/front/zjxx/zjxxFrontServlet?method=getFrontList&currentPage=1"><img src="${pageContext.request.contextPath}/front/images/index_30.jpg" width="257" height="53" alt=""></a></td>
	    <td>
		    <img src="${pageContext.request.contextPath}/front/images/&#x5206;&#x9694;&#x7b26;.gif" width="1" height="53" alt=""></td>
	  </tr>
    <tr>
                                        <!--      通知公告 -->
      <td colspan="2" rowspan="2" background="${pageContext.request.contextPath}/front/images/0index_28.jpg">
      <div class="diyi_center" id="notice">
				<div class="zq">
					<ul>
					<!--         四条记录 -->
					
					</ul>
				</div>
			</div>
      </td>
                                        <!-- 	   通知公告 -->
	    <td colspan="2" rowspan="2">
		    <img src="${pageContext.request.contextPath}/front/images/index_32.jpg" width="15" height="145" alt=""></td>
<!-- 	    找专家 -->
	    <td colspan="2" rowspan="2" bgcolor="#FFFFFF">
          <div class="diyi_left" id="zzj">
				<div class="zq">
					<ul>
					<!--         五条记录 -->
				
					</ul>
				</div>
			</div>
        </td>
<!-- 	    找专家 -->	    
	    <td rowspan="4" valign="top">
		    <img src="${pageContext.request.contextPath}/front/images/index_34.jpg" width="13" height="353" style="margin-top=-30px;" alt=""></td>
	    <td>
		    <img src="${pageContext.request.contextPath}/front/images/&#x5206;&#x9694;&#x7b26;.gif" width="1" height="1" alt=""></td>
	  </tr>
    <tr>
      <td colspan="2">
        <img src="${pageContext.request.contextPath}/front/images/index_35.jpg" width="15" height="144" alt=""></td>
	    
<!-- 	    找专利 -->
	    <td colspan="2" bgcolor="#FFFFFF">
              <div class="diyi_left" id="patent">
				<div class="zq">
					<ul>
					
					</ul>
				</div>
			</div>

        </td>
<!-- 	    找专利 -->   
	    
	    <td>
		    <img src="${pageContext.request.contextPath}/front/images/index_37.jpg" width="13" height="144" alt=""></td>
	    <td>
		    <img src="${pageContext.request.contextPath}/front/images/&#x5206;&#x9694;&#x7b26;.gif" width="1" height="144" alt=""></td>
	  </tr>
    <tr>
      <td colspan="11">
        <img src="${pageContext.request.contextPath}/front/images/index_38.jpg" width="764" height="68" alt=""></td>
	    <td colspan="2">
		    <img src="${pageContext.request.contextPath}/front/images/index_39.jpg" width="229" height="68" alt=""></td>
	    <td>
		    <img src="${pageContext.request.contextPath}/front/images/&#x5206;&#x9694;&#x7b26;.gif" width="1" height="68" alt=""></td>
	  </tr>
    <tr>
      <td>
        <img src="${pageContext.request.contextPath}/front/images/index_40.jpg" width="7" height="140" alt=""></td>
<!-- 	   企业信息 -->
	    <td colspan="9">
	    <div class="yqlj">
	    <table width="720" border="1">
  <tr>
    <td width="138" height="41"><img src="${pageContext.request.contextPath}/front/images/yqlj/yqlj1.png" width="138" height="37" /></td>
    <td width="138"><img src="${pageContext.request.contextPath}/front/images/yqlj/yqlj2.png" alt="" width="138" height="37" /></td>
    <td width="138"><img src="${pageContext.request.contextPath}/front/images/yqlj/yqlj3.png" alt="]" width="138" height="37" /></td>
    <td width="138"><img src="${pageContext.request.contextPath}/front/images/yqlj/yqlj4.png" alt="" width="138" height="37" /></td>
    <td width="134"><img src="${pageContext.request.contextPath}/front/images/yqlj/yqlj5.png" alt="" width="138" height="37" /></td>
  </tr>
  <tr>
    <td><a href="">珠三角技术转移联盟</a></td>
    <td><a href="">石油化工技术转移联盟</a></td>
    <td><a href="">石油化工技术转移联盟</a></td>
    <td><a href="">浙江网上技术市场中介服务联盟</a></td>
    <td><a href="">济南都市圈技术转移联盟</a></td>
  </tr>
  <tr>
    <td height="23"><img src="${pageContext.request.contextPath}/front/images/yqlj/yqlj6.png" alt="" width="138" height="37" /></td>
    <td><img src="${pageContext.request.contextPath}/front/images/yqlj/yqlj7.png" alt="" width="138" height="37" /></td>
    <td><img src="${pageContext.request.contextPath}/front/images/yqlj/yqlj8.png" alt="" width="138" height="37" /></td>
    <td><img src="${pageContext.request.contextPath}/front/images/yqlj/yqlj9.png" alt="" width="138" height="37" /></td>
    <td><img src="${pageContext.request.contextPath}/front/images/yqlj/yqlj10.png" alt="" width="138" height="37" /></td>
  </tr>
  <tr>
    <td height="23">
        <a href="">长三角科技中介战略联盟</a></td>
    <td><a href="">东北技术转移联盟</a></td>
    <td><a href="">长三角科技中介战略联盟</a></td>
    <td><a href="">饲料产业技术创新战略联盟</a></td>
    <td><a href="">安徽技术转移联盟</a></td>
  </tr>
</table>
	    </div>	    
	    <td>
<!-- 		    企业信息 -->
		    <img src="${pageContext.request.contextPath}/front/images/index_42.jpg" width="14" height="140" alt=""></td>
<!-- 	    找政策 -->
	    <td colspan="2" bgcolor="#FFFFFF">
<div class="diyi_left" id="zzc">
				<div class="zq">
					<ul>
					
					</ul>
				</div>
			</div>
        </td>
<!-- 	    找政策 -->  
	  <tr>
	  <td height="29" colspan="14" ><div align="left">
	  <br>
	  
      <font color=#000099 size="4"><strong>友情链接</strong></font>
      <select onChange="window.open(this.options[this.selectedIndex].value)">
      	<option selected>--省内创新驿站--</option>
      	<option  value="http://www.sjzkj.gov.cn/cyportal/template/site00_index.jsp">石家庄</option>
      	<option  value="http://www.chengde.gov.cn/">承德市</option>
      	<option  value="http://www.zjkkj.gov.cn/">张家口市</option>
      	<option  value="http://www.tskj.com.cn/">唐山市</option>
      	<option  value="http://www.lfinfo.gov.cn/">廊坊市</option>
      	<option  value="http://www.sjzkj.gov.cn/cyportal/template/site00_index.jsp">石家庄</option>
      	<option  value="http://www.sjzkj.gov.cn/cyportal/template/site00_index.jsp">石家庄</option>
      	<option  value="http://www.sjzkj.gov.cn/cyportal/template/site00_index.jsp">石家庄</option>
      </select>
      <select onChange="window.open(this.options[this.selectedIndex].value)">
      	<option selected>--省外创新驿站--</option>
      	<option  value="http://www.jscxyz.com">江苏创新驿站</option>
      	<option  value="http://sirn.jinshan.gov.cn">上海创新驿站协同工作平台</option>
      	<option  value="http://www.nbpc.org.cn ">宁波市创新驿站</option>
      	<option  value="http://www.gpcstd.com">甘肃省创新驿站</option>
      	<option  value="http://www.szjssc.org.cn">深圳市创新驿站</option>
      	<option  value="http://www.cttip.org">中国技术交易信息服务平台</option>
      	<option  value="http://hebei.ctexmall.com">京津冀技术交易河北平台</option>
      	<option  value="http://www.ctexmall.com">中国技术交易网络平台</option> 	
      </select>
     
      </div></td>
    </tr>
    <!-- <tr>
				<td  colspan="14" height ="12" background="${pageContext.request.contextPath}/front/images/index_0900.jpg"><div align="center" class="STYLE2">
						<a style="color: #FFFFFF" href="lxwm.jsp">联系我们</a>&nbsp;&nbsp;|&nbsp;&nbsp;设为首页&nbsp;&nbsp;|&nbsp;&nbsp;加入收藏&nbsp;&nbsp;|&nbsp;&nbsp;<a
							href="mzsm.jsp" style="color: #ffffff">免责声明</a>
					</div></td>
	</tr>
			<tr>
				<td colspan="14" height ="167"  background="${pageContext.request.contextPath}/front/images/index_651.jpg"><div
						align="center" class="STYLE3">
						版权所有 @ 河北省科学技术情报研究院科技政策服务平台 <br> 地址: 河北省石家庄市青园街233号 邮编：050021
					</div></td>
					<td>
		    <img src="${pageContext.request.contextPath}/front/images/&#x5206;&#x9694;&#x7b26;.gif" width="1" height="" alt=""></td>
			</tr> -->
 
   <tr>
      <td colspan="14" background="${pageContext.request.contextPath}/front/images/0index_41.jpg">
      <div align="center" class="STYLE2">
      CopyRight STDU All Right Reserved  版权所有：河北省情报院<br>
        地址：河北省石家庄市北二环东路17号石家庄铁道大学  电话：0311-XXXXXXXXXXX<br>
      技术支持：石家庄铁道大学 备案号：ABCDEFG <a href="mzsm.jsp">免责声明</a>
      </div></td>
	    <td>
		    <img src="${pageContext.request.contextPath}/front/images/&#x5206;&#x9694;&#x7b26;.gif" width="1" height="167" alt=""></td>
	  </tr>
    <tr>
      <td colspan="14">
        <img src="${pageContext.request.contextPath}/front/images/index_45.jpg" width="1005" height="3" alt=""></td>
	    <td>
		    <img src="${pageContext.request.contextPath}/front/images/&#x5206;&#x9694;&#x7b26;.gif" width="1" height="3" alt=""></td>
	  </tr>
    <tr>
      <td>
        <img src="${pageContext.request.contextPath}/front/images/&#x5206;&#x9694;&#x7b26;.gif" width="7" height="1" alt=""></td>
	    <td>
		    <img src="${pageContext.request.contextPath}/front/images/&#x5206;&#x9694;&#x7b26;.gif" width="8" height="1" alt=""></td>
	    <td>
		    <img src="${pageContext.request.contextPath}/front/images/&#x5206;&#x9694;&#x7b26;.gif" width="31" height="1" alt=""></td>
	    <td>
		    <img src="${pageContext.request.contextPath}/front/images/&#x5206;&#x9694;&#x7b26;.gif" width="198" height="1" alt=""></td>
	    <td>
		    <img src="${pageContext.request.contextPath}/front/images/&#x5206;&#x9694;&#x7b26;.gif" width="13" height="1" alt=""></td>
	    <td>
		    <img src="${pageContext.request.contextPath}/front/images/&#x5206;&#x9694;&#x7b26;.gif" width="15" height="1" alt=""></td>
	    <td>
		    <img src="${pageContext.request.contextPath}/front/images/&#x5206;&#x9694;&#x7b26;.gif" width="381" height="1" alt=""></td>
	    <td>
		    <img src="${pageContext.request.contextPath}/front/images/&#x5206;&#x9694;&#x7b26;.gif" width="78" height="1" alt=""></td>
	    <td>
		    <img src="${pageContext.request.contextPath}/front/images/&#x5206;&#x9694;&#x7b26;.gif" width="17" height="1" alt=""></td>
	    <td>
		    <img src="${pageContext.request.contextPath}/front/images/&#x5206;&#x9694;&#x7b26;.gif" width="1" height="1" alt=""></td>
	    <td>
		    <img src="${pageContext.request.contextPath}/front/images/&#x5206;&#x9694;&#x7b26;.gif" width="14" height="1" alt=""></td>
	    <td>
		    <img src="${pageContext.request.contextPath}/front/images/&#x5206;&#x9694;&#x7b26;.gif" width="204" height="1" alt=""></td>
	    <td>
		    <img src="${pageContext.request.contextPath}/front/images/&#x5206;&#x9694;&#x7b26;.gif" width="25" height="1" alt=""></td>
	    <td>
		    <img src="${pageContext.request.contextPath}/front/images/&#x5206;&#x9694;&#x7b26;.gif" width="13" height="1" alt=""></td>
	    <td></td>
	  </tr>
  </table>
  <!-- End Save for Web Slices -->
</div>
</body>
<script type="text/javascript">
	start("${pageContext.request.contextPath}");
</script>
</html>