<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>专家信息</title>
<!-- css  js文件链接 -->
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.4.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/lhgcore.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/lhgcalendar.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.9.1.min.js"></script>
<!-- 上传信息 -->
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/zjxx/back_zjxx.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/layer/layer.js"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/sl.css">
<!-- css  js文件链接 -->
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
	/* 	background-color: transparent; */
	/* 	border-bottom: #ffffff 1px solid; */
	/* 	border-left: #ffffff 1px solid; */
	/* 	border-right: #ffffff 1px solid; */
	/* 	border-top: #ffffff 1px solid; */
	/* 	border-color: #ffffff #ffffff #ffffff #ffffff;  */
	height: 20px;
	width: 99%;
}
</style>
<body bgcolor="#DDF2FC">
	<div class="nav">
		您现在的位置：
		<ul class="nav-ul">
			<li class="nav-li"><a href="javascript:void(0)">专家信息</a></li>
			<li class="nav-li"><a href="javascript:void(0)">添加专家</a></li>
		</ul>
	</div>
	<div class="table" align="center">
		<h1>专家信息库</h1>
		<br>
		<form
			action="${pageContext.request.contextPath }/back/zjxx/zjxxServlet?method=add"
			method="post" id="checkForm">
			<table width="800" border="1" style="border-collapse: collapse;"
				class="form-table">
				<tr>
					<td width="100"><div align="center">
							姓名&nbsp;&nbsp;<font style="color: red">*</font>
						</div></td>
					<td width="286"><input id="xm" name="xm" type="text" /></td>
					<td width="100"><div align="center">
							所在市&nbsp;&nbsp;<font style="color: red">*</font>
						</div></td>
					<td width="286"><input id="szs" name="mc_szs" type="text" /></td>
				</tr>
				<tr>
					<td><div align="center">
							性别&nbsp;&nbsp;<font style="color: red">*</font>
						</div></td>
					<td><input id="xb" name="xb" type="text" /></td>
					<td><div align="center">
							国籍&nbsp;&nbsp;<font style="color: red">*</font>
						</div></td>
					<td><input id="gj" name="gj" type="text" /></td>
				</tr>
				<tr>
					<td><div align="center">
							办公电话&nbsp;&nbsp;<font style="color: red">*</font>
						</div></td>
					<td><input id="bgdh" name="dh_bg" type="text" /></td>
					<td><div align="center">
							出生日期&nbsp;&nbsp;<font style="color: red">*</font>
						</div></td>
					<td><input id="csrq" name="rq_cs" type="text"
						onclick="J.calendar.get({id:'csrq'});" readonly="readonly" /></td>
				</tr>
				<tr>
					<td><div align="center">
							职称&nbsp;&nbsp;<font style="color: red">*</font>
						</div></td>
					<td><input id="zc" name="zc_zy" type="text" /></td>
					<td><div align="center">
							手机&nbsp;&nbsp;<font style="color: red">*</font>
						</div></td>
					<td><input id="sj" name="sj" type="text" /></td>
				</tr>
				<tr>
					<td><div align="center">学位</div></td>
					<td><input id="xw" name="xw" type="text" /></td>
					<td><div align="center">主要成就</div></td>
					<td><input id="zycj" name="ch_qt" type="text" /></td>
				</tr>
				<tr>
					<td><div align="center">学历</div></td>
					<td><input id="xl" name="xl" type="text" /></td>
					<td><div align="center">
							研究方向&nbsp;&nbsp;<font style="color: red">*</font>
						</div></td>
					<td><input id="yjfx" name="yjfx" type="text" /></td>
				</tr>
				<tr>
					<td><div align="center">院士类别</div></td>
					<td><select name="yslb" id="yslb" style="width: 60%;">
							<option value="科学院院士">科学院院士</option>
							<option value="工程院院士">工程院院士</option>
							<option value="其他">其他</option>
					</select></td>
					<td><div align="center">毕业院校</div></td>
					<td><input id="byyx" name="byyx" type="text" /></td>
				</tr>
				<tr>
					<td><div align="center">工作单位</div></td>
					<td colspan="3"><input id="gzdw" name="dw_gz" type="text" /></td>
				</tr>
				<tr>
					<td><div align="center">专家称号</div></td>
					<td colspan="3"><input id="zjch" name="ch" type="text" /></td>
				</tr>
				<tr>
					<td><div align="center">
							学科领域&nbsp;&nbsp;<font style="color: red">*</font>
						</div></td>
					<td colspan="3"><input id="xkly" name="xkly" type="text" /></td>
				</tr>
				<tr>
					<td><div align="center">现从事行业</div></td>
					<td colspan="3"><input id="xcshy" name="xcshy" type="text" /></td>
				</tr>
				<tr>
					<td><div align="center">关键词</div></td>
					<td colspan="3"><input id="gjc" name="gjc" type="text" /></td>
				</tr>
				<tr>
					<td colspan="4"><div align="center">个人简介</div></td>
				</tr>
				<tr>
					<td colspan="4"><textarea id="grjj" name="bz"
							style="width: 830px; height: 250px"></textarea></td>
				</tr>
			</table>

			<br> <br> <br>
			<div align="center">
				<input id="sb" type="button" id="sb" value="保存"
					style="hight: 80px; width: 100px">
			</div>
		</form>
	</div>
	<br>
	<br>
	<br>
	<br>
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