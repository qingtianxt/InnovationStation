<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>专家信息查看</title>
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
	border-collapse: collapse;
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
</head>
<body bgcolor="#DDF2FC">

	<div class="nav">
		您现在的位置：
		<ul class="nav-ul">
			<li class="nav-li"><a href="javascript:void(0)">专家信息</a></li>
			<li class="nav-li"><a href="javascript:void(0)" onclick="back()">专家管理</a></li>
			<li class="nav-li"><a href="javascript:void(0)">修改专家</a></li>
		</ul>
	</div>
	<div class="table" align="center">
		<h1>专家信息库</h1>
		<br>
		<form
			action="${pageContext.request.contextPath }/back/zjxx/zjxxServlet?method=update&id=${zjxxBean.id }"
			method="post" id="checkForm">
			<table width="800" border="1" style="border-collapse: collapse;"
				class="form-table">
				<tr>
					<td width="100"><div align="center">
							姓名&nbsp;&nbsp;<font style="color: red">*</font>
						</div></td>
					<td width="286"><input value="${zjxxBean.xm }" id="xm"
						name="xm" type="text" />
					<td width="100"><div align="center">
							所在市&nbsp;&nbsp;<font style="color: red">*</font>
						</div></td>
					<td width="286"><input value="${zjxxBean.mc_szs }" id="szs"
						name="mc_szs" type="text" /></td>
				</tr>
				<tr>
					<td><div align="center">性别&nbsp;&nbsp;<font style="color: red">*</font></div></td>
					<td><input value="${zjxxBean.xb }" id="xb" name="xb"
						type="text" /></td>
					<td><div align="center">国籍&nbsp;&nbsp;<font style="color: red">*</font></div></td>
					<td><input value="${zjxxBean.gj }" id="gj" name="gj"
						type="text" /></td>
				</tr>
				<tr>
					<td><div align="center">办公电话&nbsp;&nbsp;<font style="color: red">*</font></div></td>
					<td><input value="${zjxxBean.dh_bg }" id="bgdh" name="dh_bg"
						type="text" /></td>
					<td><div align="center">出生日期&nbsp;&nbsp;<font style="color: red">*</font></div></td>
					<td><input value="${zjxxBean.rq_cs }" id="csrq" name="rq_cs"
						type="text" onclick="J.calendar.get({id:'csrq'});"
						readonly="readonly" /></td>
				</tr>
				<tr>
					<td><div align="center">职称&nbsp;&nbsp;<font style="color: red">*</font></div></td>
					<td><input value="${zjxxBean.zc_zy }" id="zc" name="zc_zy"
						tycpe="text" /></td>
					<td><div align="center">手机&nbsp;&nbsp;<font style="color: red">*</font></div></td>
					<td><input value="${zjxxBean.sj }" id="sj" name="sj"
						type="text" /></td>
				</tr>
				<tr>
					<td><div align="center">学位</div></td>
					<td><input value="${zjxxBean.xw }" id="xw" name="xw"
						type="text" /></td>
					<td><div align="center">主要成就</div></td>
					<td><input value="${zjxxBean.ch_qt }" id="zycj" name="ch_qt"
						type="text" /></td>
				</tr>
				<tr>
					<td><div align="center">学历</div></td>
					<td><input value="${zjxxBean.xl }" id="xl" name="xl"
						type="text" /></td>
					<td><div align="center">研究方向&nbsp;&nbsp;<font style="color: red">*</font></div></td>
					<td><input value="${zjxxBean.yjfx }" id="yjfx" name="yjfx"
						type="text" /></td>
				</tr>
				<tr>
					<td><div align="center">院士类别</div></td>
					<td><select name="yslb" id="yslb" style="width: 60%;">
							<option value="${zjxxBean.yslb }">${zjxxBean.yslb }</option>
							<option value="科学院院士">科学院院士</option>
							<option value="工程院院士">工程院院士</option>
							<option value="其他">其他</option>
					</select></td>
					<td><div align="center">毕业院校</div></td>
					<td><input value="${zjxxBean.byyx }" id="byyx" name="byyx"
						type="text" /></td>
				</tr>
				<tr>
					<td><div align="center">工作单位</div></td>
					<td colspan="3"><input value="${zjxxBean.dw_gz }" id="gzdw"
						name="dw_gz" type="text" /></td>
				</tr>
				<tr>
					<td><div align="center">专家称号</div></td>
					<td colspan="3"><input value="${zjxxBean.ch }" id="zjch"
						name="ch" type="text" /></td>
				</tr>
				<tr>
					<td><div align="center">学科领域&nbsp;&nbsp;<font style="color: red">*</font></div></td>
					<td colspan="3"><input value="${zjxxBean.xkly }" id="xkly"
						name="xkly" type="text" /></td>
				</tr>
				<tr>
					<td><div align="center">现从事行业</div></td>
					<td colspan="3"><input value="${zjxxBean.xcshy }" id="xcshy"
						name="xcshy" type="text" /></td>
				</tr>
				<tr>
					<td><div align="center">关键词</div></td>
					<td colspan="3"><input value="${zjxxBean.gjc }" id="gjc"
						name="gjc" type="text" /></td>
				</tr>
				<tr>
					<td colspan="4"><div align="center">个人简介</div></td>
				</tr>
				<tr>
					<td colspan="4"><textarea id="grjj" name="bz"
							style="width: 800px; height: 200px">${zjxxBean.bz }</textarea></td>
				</tr>
			</table>
			<br> <br> <br>
			<div align="center">
				<input id="sb" type="button" value="保存"
					style="hight: 80px; width: 100px">
			</div>
		</form>
	</div>
	<br>
	<br>
	<br>
	<br>
</body>
</html>