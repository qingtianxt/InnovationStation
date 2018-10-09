<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- css  js文件链接 -->
</head>
<style type="text/css">
.table {
	
}

.table tr {
	
}

.table tr td {
	text-align: left;
	height: 30px;
}

.table tr td input {
	height: 20px;
	width: 98%;
}
</style>
<script
	src="${pageContext.request.contextPath }/js/kjcg/jquery.provincesCity.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath }/js/kjcg/jquery.provincesCityGM.js"
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/js/kjcg/gmjj.js"
	type="text/javascript"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/kjcg/front_kjcg.js"></script>
<script>
	$(document).ready(function() {
		$(function() {
			$("#tree1").ProvinceCityGM();
		});
	});
</script>
</head>
<body>
	<form
		action="${pageContext.request.contextPath }/front/kjcg/kjcgFrontServlet?method=add"
		method="post" id="checkForm">
		<input type="hidden" id="user" name="user" value="${session_user.id }">
		<div class="table" align="center">
			<h1>成果转化项目库</h1>
			<table width="800" height="570" border="1"
				style="border-collapse: collapse;" class="form-table">
				<tr>
					<td width="110"><div align="center">
							成果名称&nbsp;&nbsp;<font style="color: red">*</font>
						</div></td>
					<td colspan="3"><input id="cgmc" name="mc" type="text" /></td>
				</tr>
				<tr>
					<td><div align="center">
							批准登记号&nbsp;&nbsp;<font style="color: red">*</font>
						</div></td>
					<td width="200"><input id="pzdjh" name="djh" type="text" /></td>
					<td width="140"><div align="center">成果类别</div></td>
					<td width="200">
						<!--     	<input id="gclb" name="gclb" type="text" /> --> <select
						id="gclb" name="cglb" style="width: 98%">
							<option value="基础理论成果">基础理论成果</option>
							<option value="应用技术成果">应用技术成果</option>
							<option value="软科学成果">软科学成果</option>
							<option value="其他">其他</option>
					</select>
					</td>
				</tr>
				<tr>
					<td><div align="center">
							成果所属单位&nbsp;&nbsp;<font style="color: red">*</font>
						</div></td>
					<td colspan="3"><input id="cgssdw" name="dw" type="text" /></td>
				</tr>
				<tr>
					<td><div align="center">
							通讯地址&nbsp;&nbsp;<font style="color: red">*</font>
						</div></td>
					<td colspan="3"><input id="txdz" name="dz" type="text"
						size="54" /></td>
				</tr>
				<tr>
					<td><div align="center">
							成果体现形式&nbsp;&nbsp;<font style="color: red">*</font>
						</div></td>
					<td colspan="3">
						<div id="cgtxxs" class="jstxxs">
							<c:forEach items="${jstxxs }" var="l" varStatus="vs">
								<c:if test="${vs.count%6==0 }">

									<input style="width: 2%" type="checkbox" name="xs" id="jstxxs"
										value="${l.jstxxsid }" />${l.jstxxsmc }<br>
								</c:if>
								<c:if test="${vs.count%6!=0 }">

									<input style="width: 2%" type="checkbox" name="xs" id="jstxxs"
										value="${l.jstxxsid }" />${l.jstxxsmc }
							</c:if>
							</c:forEach>
						</div>
					</td>
				</tr>
				<tr>
					<td><div align="center">
							登记日期&nbsp;&nbsp;<font style="color: red">*</font>
						</div></td>
					<td><input id="djrq" name="djrq" type="text"
						onclick="J.calendar.get({id:'djrq'});" readonly="readonly" /></td>
					<td><div align="center">所属高新技术类别</div></td>
					<td><select id="ssgxjslb" name="jslb" style="width: 98%">
							<c:forEach items="${ssgxjslb }" var="s">
								<option value=${s.jslbmc }>${s.jslbmc }</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td><div align="center">成果水平</div></td>
					<td>
						<!--     	<input id="cgsp" name="cgsp" type="text" /> --> <select
						id="cgsp" name="sp" style="width: 98%">
							<option value="国际领先">国际领先</option>
							<option value="国际先进">国际先进</option>
							<option value="国内领先">国内领先</option>
							<option value="国内先进">国内先进</option>
							<option value="其他">其他</option>
					</select>
					</td>
					<td><div align="center">核心专利</div></td>
					<td><input id="hxzl" name="hxzl" type="text" /></td>
				</tr>
				<tr>
					<td><div align="center">成果所处阶段</div></td>
					<td>
						<!--     	<input id="cgscjd" name="cgscjd" type="text" /> --> <select
						id="cgscjd" name="jd" style="width: 98%">
							<option value="成熟应用阶段">成熟应用阶段</option>
							<option value="初期阶段">初期阶段</option>
							<option value="中期阶段">中期阶段</option>
							<option value="其他">其他</option>
					</select>
					</td>
					<td><div align="center">应用状态</div></td>
					<td>
						<!--     	<input id="yyzt" name="yyzt	" type="text" /> --> <select
						id="yyzt" name="yyzt" style="width: 98%">
							<option value="小批量或小范围应用">小批量或小范围应用</option>
							<option value="产业化应用">产业化应用</option>
							<option value="应用后停用">应用后停用</option>
							<option value="未应用">未应用</option>
							<option value="试用">试用</option>
							<option value="其他">其他</option>
					</select>
					</td>
				</tr>
				<tr>
					<td><div align="center">
							技术所属领域&nbsp;&nbsp;<font style="color: red">*</font>
						</div></td>
					<td colspan="3">
						<!--     	<input id="jsssly" name="jsssly" type="text" /> -->
						<div id="jsssly" class="jsssly">
							<c:forEach items="${jsssly }" var="l" varStatus="vs">
								<c:if test="${vs.count%6==0 }">

									<input style="width: 2%" type="checkbox" name="jsssly"
										id="jsssly" value="${l.lyid }" />${l.lymc }<br>
								</c:if>
								<c:if test="${vs.count%6!=0 }">

									<input style="width: 2%" type="checkbox" name="jsssly"
										id="jsssly" value="${l.lyid }" />${l.lymc }
							</c:if>
							</c:forEach>
						</div>
					</td>
				</tr>
				<tr>
					<td><div align="center">联系人</div></td>
					<td><input id="lxr" name="lxr" type="text" /></td>
					<td><div align="center">联系人电话</div></td>
					<td><input id="lxdh" name="dh" type="text" /></td>
				</tr>
				<tr>
					<td><div align="center">成果属性</div></td>
					<td>
						<!--     	<input id="cgsx" name="cgsx" type="text" /> --> <select
						id="cgsx" name="cgsx" style="width: 98%">
							<option value="国内技术二次开发">国内技术二次开发</option>
							<option value="国外引进消化吸收创新">国外引进消化吸收创新</option>
							<option value="原始性创新">原始性创新</option>
							<option value="其他">其他</option>
					</select>
					</td>
					<td><div align="center">年份</div></td>
					<td><input id="nf" name="nf" type="text" /></td>
				</tr>
				<tr>
					<td><div align="center">
							成果应用行业&nbsp;&nbsp;<font style="color: red">*</font>
						</div></td>
					<td colspan="3"><div id="tree1"></div></td>
				</tr>
				<tr>
					<td><div align="center">关键词</div></td>
					<td colspan="3"><input id="gjc" name="gjc" type="text" /></td>
				</tr>
				<tr>
					<td colspan="4"><div align="center">简介</div></td>
				</tr>
				<tr>
					<td height="171" colspan="4"><textarea id="jj" name="gbnr"
							style="width: 800px; height: 200px"></textarea></td>
				</tr>
			</table>
			<br> <br> <br> <br>
			<div align="center">
				<input type="button" id="upload" value="保存"
					style="hight: 80px; width: 100px">
			</div>
		</div>
		<br> <br> <br> <br />
	</form>
	<c:if test="${not empty msg }">
		<script type="text/javascript">
			$(function() {
				layer.alert('${msg}', {
					skin : 'layui-layer-lan' //样式类名
					,
					closeBtn : 0
				});

			})
		</script>
	</c:if>
</body>
</html>