<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>专家信息查看</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/sl.css">
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
	width: 95%;
}
</style>
<body bgcolor="#DDF2FC">
	<div class="nav">
			您现在的位置：
			<ul class="nav-ul">
				<li class="nav-li"><a href="javascript:void(0)">专家信息</a></li>
				<li class="nav-li"><a href="javascript:void(0)" onclick="back()">专家管理</a></li>
				<li class="nav-li"><a href="javascript:void(0)">查看专家</a></li>
			</ul>
		</div>
	<div class="table" align="center">
		<table width="800" border="1" style="border-collapse: collapse;"
			class="form-table">
			<tr>
				<td width="100"><div align="center">姓名</div></td>
				<td width="286">${zjxxBean.xm }</td>
				<td width="100"><div align="center">所在市</div></td>
				<td width="286">${zjxxBean.mc_szs }</td>
			</tr>
			<tr>
				<td><div align="center">性别</div></td>
				<td>${zjxxBean.xb }</td>
				<td><div align="center">国籍</div></td>
				<td>${zjxxBean.gj }</td>
			</tr>
			<tr>
				<td><div align="center">办公电话</div></td>
				<td>${zjxxBean.dh_bg }</td>
				<td><div align="center">出生日期</div></td>
				<td>${zjxxBean.rq_cs }</td>
			</tr>
			<tr>
				<td><div align="center">职称</div></td>
				<td>${zjxxBean.zc_zy }</td>
				<td><div align="center">手机</div></td>
				<td>${zjxxBean.sj }</td>
			</tr>
			<tr>
				<td><div align="center">学位</div></td>
				<td>${zjxxBean.xw }</td>
				<td><div align="center">主要成就</div></td>
				<td>${zjxxBean.ch_qt }</td>
			</tr>
			<tr>
				<td><div align="center">学历</div></td>
				<td>${zjxxBean.xl }</td>
				<td><div align="center">研究方向</div></td>
				<td>${zjxxBean.yjfx }</td>
			</tr>
			<tr>
				<td><div align="center">院士类别</div></td>
				<td>${zjxxBean.yslb }</td>
				<td><div align="center">毕业院校</div></td>
				<td>${zjxxBean.byyx }</td>
			</tr>
			<tr>
				<td><div align="center">工作单位</div></td>
				<td colspan="3">${zjxxBean.dw_gz }</td>
			</tr>
			<tr>
				<td><div align="center">专家称号</div></td>
				<td colspan="3">${zjxxBean.ch }</td>
			</tr>
			<tr>
				<td><div align="center">学科领域</div></td>
				<td colspan="3">${zjxxBean.xkly }</td>
			</tr>
			<tr>
				<td><div align="center">现从事行业</div></td>
				<td colspan="3">${zjxxBean.xcshy }</td>
			</tr>
			<tr>
				<td><div align="center">关键词</div></td>
				<td colspan="3">${zjxxBean.gjc }</td>
			</tr>
			<tr>
				<td colspan="4"><div align="center">个人简介</div></td>
			</tr>
			<tr>
				<td colspan="4">${zjxxBean.bz }</td>
			</tr>
		</table>

	</div>
	<br>
	<br>
	<br>
	<br>
	<div align="center">
		<input style="margin: auto" type="button" value="确定" onclick="back()">
	</div>
	<script type="text/javascript">
		function back() {
			location.href = "${zjxxPagingBean.preUrl}" + "&msg=7"
		}
	</script>
	<br>
	<br>
	<br>
	<br>
</body>
</html>