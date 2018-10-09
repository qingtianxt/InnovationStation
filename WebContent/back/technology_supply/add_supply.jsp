<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加技术供给</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.12.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.validate.js"></script>

<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/lhgcalendar.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/lhgcore.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/lhgcalendar.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/layer/layer.js"></script>
<style type="text/css">


 tr td input[type='text'] { 
/*  	height: 20px;  */
 	width: 98%; 
 } 
 input,select{
 	box-sizing: border-box;
 	padding:5px;
 }
</style>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/sl.css">
</head>
<body>
<div>
<div class="nav">
	您现在的位置：
	<ul class="nav-ul">
		<li class="nav-li"><a href="#">技术供给</a></li>
		<li class="nav-li"><a href="#">添加信息</a></li>
	</ul>
</div>
<div align="center"  class="">
<form action="supplyServlet?method=add&result=add" method="post">
<c:if test="${supply!=null }"><input type="hidden" value="${supply.id }" name="id"></c:if>
<c:if test="${sessionScope.session_user!=null }"><input type="hidden" value="${sessionScope.session_user.username}" name="username"></c:if>
			<table border="1" style="width:800px;height:549px;border-collapse: collapse;" class="form-table">
				<caption>编辑技术信息</caption>
				<tr height="36">
					<td width="130"><div class="title required">技术名称</div></td>
					<td width="250">
						<input type="text" name="mc"  id="jsmc" placeholder="请输入技术名称" value="${supply.mc }" autofocus="autofocus"/>
					</td>
					<td width="120"><div class="title">技术水平</div></td>
					<td width="260">
						<select  name="sp" id="jssp" style="width: 98%;">
							<option value="国际领先" <c:if test="${supply.sp.equals('国际领先') }">selected="selected"</c:if>>国际领先</option>
							<option value="国际先进" <c:if test="${supply.sp.equals('国际先进') }">selected="selected"</c:if>>国际先进</option>
							<option value="国内领先" <c:if test="${supply.sp.equals('国内领先') }">selected="selected"</c:if>>国内领先</option>
							<option value="国内先进" <c:if test="${supply.sp.equals('国内先进') }">selected="selected"</c:if>>国内先进</option>
							<option value="其他" <c:if test="${supply.sp.equals('其他') }">selected="selected"</c:if>>其他</option>
						</select>
					</td>
				</tr>
				<tr height="36">
					<td ><div class="title">批准登记号</div></td>
					<td>
						<input name="djh" type="text" id="pzdjh" value="${supply.djh }" placeholder="请输入批准登记号"/>
					</td>
					<td><div class="title">应用状态</div></td>
					<td>
<!-- 						<input name="yyzt" type="text" id="yyzt"/> -->
						<select  name="yyzt" id="yyzt" style="width: 98%;">
							<option value="产业化应用" <c:if test="${supply.yyzt.equals('产业化应用') }">selected="selected"</c:if>>产业化应用</option>
							<option value="试用" <c:if test="${supply.yyzt.equals('试用') }">selected="selected"</c:if>>试用</option>
							<option value="未应用" <c:if test="${supply.yyzt.equals('未应用') }">selected="selected"</c:if>>未应用</option>
							<option value="小批量或小范围应用" <c:if test="${supply.yyzt.equals('小批量或小范围应用') }">selected="selected"</c:if>>小批量或小范围应用</option>
							<option value="应用后停用" <c:if test="${supply.yyzt.equals('应用后停用') }">selected="selected"</c:if>>应用后停用</option>
							<option value="其他" <c:if test="${supply.yyzt.equals('其他') }">selected="selected"</c:if>>其他</option>
						</select>
					</td>
				</tr>
				<tr height="36">
					<td><div class="title required">是否专利技术</div></td>
					<td>
						<label><input name="sfzl" type="radio" value="是" id="sfzljs" <c:if test="${suppy.sfzl.equals('') }">checked="checked"</c:if>  />是</label>
						<label><input name="sfzl" type="radio" value="否" id="sfzljs" <c:if test="${suppy.sfzl.equals('') }">checked="checked"</c:if> />否</label>
					</td>
					<td><div class="title">联系人</div></td>
					<td>
						<input name="lxr" type="text" id="lxr" value="${supply.lxr }" placeholder="请输入联系人"/>
					</td>
				</tr>
				<tr height="36">
					<td><div class="title">专利号</div></td>
					<td>
					<input name="zlh" type="text" id="zlh" value="${supply.zlh }" placeholder="请输入专利号"/>
					</td>
					<td><div class="title">联系人电话</div></td>
					<td>
					<input name="dh" type="text" id="lxdh" value="${supply.dh }" placeholder="请输入联系人电话"/>
					</td>
				</tr>
				<tr height="36">
					<td><div class="title">所属高新技术类别</div></td>
					<td>
						<select  name="jslb" id="ssgxjslb" style="width: 98%;">
						</select>
					</td>
					<td><div class="title">登记日期</div></td>
					<td>
						<input name="djrq" type="text" id="djrq" onclick="J.calendar.get({id:'djrq'});" placeholder="请选择登记日期" readonly="readonly" value="${supply.djrq }" />
					</td>
				</tr>
				<tr height="36">
					<td><div class="title">技术所处阶段</div></td>
					<td>
<!-- 						<input name="jsscjd" type="text" id="jsscjd" /> -->
						<select  name="jd" id="jsscjd" style="width: 98%;">
							<option value="成熟应用阶段" <c:if test="${supply.jd.equals('成熟应用阶段') }">selected="selected"</c:if>>成熟应用阶段</option>
							<option value="初期阶段" <c:if test="${supply.jd.equals('初期阶段') }">selected="selected"</c:if>>初期阶段</option>
							<option value="中期阶段" <c:if test="${supply.jd.equals('中期阶段') }">selected="selected"</c:if>>中期阶段</option>
							<option value="其他" <c:if test="${supply.jd.equals('其他') }">selected="selected"</c:if>>其他</option>
						</select>
					</td>
					<td><div class="title">年份</div></td>
					<td>
						<input name="nf" type="text" id="nf" value="${supply.nf }" placeholder="请输入年份"/>
					</td>
				</tr>
				<tr height="36">
					<td><div class="title">技术属性</div></td>
					<td>
<!-- 						<input name="jssx" type="text" id="jssx" /> -->
						<select  name="cgsx" id="jssx" style="width: 98%;">
							<option value="国内技术二次开发" <c:if test="${supply.cgsx.equals('国内技术二次开发') }">selected="selected"</c:if>>国内技术二次开发</option>
							<option value="国外引进消化吸收创新" <c:if test="${supply.cgsx.equals('国外引进消化吸收创新') }">selected="selected"</c:if>>国外引进消化吸收创新</option>
							<option value="原始性创新" <c:if test="${supply.cgsx.equals('原始性创新') }">selected="selected"</c:if>>原始性创新</option>
							<option value="其他" <c:if test="${supply.cgsx.equals('其他') }">selected="selected"</c:if>>其他</option>
						</select>
					</td>								
					<td><div class="title">专利状态</div></td>
					<td><!-- <input name="zlzt" type="text" id="zlzt" /> -->
						<select  name="zlzt" id="zlzt" style="width: 98%;">
							<option value="公开" <c:if test="${supply.zlzt.equals('公开') }">selected="selected"</c:if>>公开</option>
							<option value="不公开"<c:if test="${supply.zlzt.equals('不公开') }">selected="selected"</c:if>>不公开</option>
							<option value="失效" <c:if test="${supply.zlzt.equals('失效') }">selected="selected"</c:if>>失效</option>
							<option value="其他" <c:if test="${supply.zlzt.equals('其他') }">selected="selected"</c:if>>其他</option>
						</select>
					</td>
				</tr>
				<tr height="36">
					<td><div class="title">技术体现形式</div></td>
					<td>
<!-- 						<input name="xs" type="text" id="jstxxs" /> -->
						<select  name="xs" id="jstxxs" style="width: 98%;">
						</select>
					</td><td colspan="2">
				</tr>
				<tr height="36">
					<td><div class="title">技术供给单位</div></td>
					<td colspan="3" align="left">
						<input name="dw" type="text" id="jsgjdw" value="${supply.dw }"placeholder="请输入技术供给单位"/>
					</td>
				</tr>
				<tr height="36">
					<td height="35"><div class="title">通讯地址</div></td>
					<td colspan="3"align="left">
						<input name="dz" type="text" id="txdz" value="${supply.dz }" placeholder="请输入通讯地址"/>
					</td>
				</tr>
				<tr height="36">
					<td><div class="title required">关键词</div></td>
					<td colspan="3"align="left">
						<input name="gjc" type="text" id="gjc" value="${supply.gjc }" placeholder="请输入关键词"/>
					</td>
				</tr>
				<tr>
					<td colspan="4" height="36" class="title" style="text-align:center">项目简介</td>
				</tr>
				<tr>
					<td height="107" colspan="4" style="padding:0px">
						<textarea id="xmjj" name="gbnr" style="height:300px;width:796px;text-indent: 2em" placeholder="项目简介">${supply.gbnr }</textarea></td>
				</tr>
			</table>
			<br><br><br><br>
			<div class="title" style="text-align:center;">
				<input id="sub" type="submit" value="保存" style="hight: 80px; width: 100px" >
			</div>
</form>

	</div>
	<br><br><br><br>

</div>
</body>
<script type="text/javascript">
	var global = {
			rootpath:"${pageContext.request.contextPath}",
			jslb:"${supply.jslb}",
			xs:"${supply.xs}",
			msg:"${param.msg}",
			supply:{mc:"${supply.mc}"}
	}
</script>
<script type="text/javascript" src="add_supply.js"></script>
 
</html>