<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>政策法规</title>
<!-- css  js文件链接 -->
	<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/sl.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.4.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/lhgcore.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/lhgcalendar.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.9.1.min.js"></script>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/ueditor/ueditor.config.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/ueditor/ueditor.all.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/ueditor/ueditor.all.js"></script>
<link
	href="${pageContext.request.contextPath}/ueditor/themes/default/css/ueditor.css"
	type="text/css" rel="stylesheet">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/layer/layer.js"></script>
<!-- 上传信息 -->
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/zcfg/back_zcfg.js"></script>
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
}
</style>
<body bgcolor="#DDF2FC">
<div class="nav">
			您现在的位置：
			<ul class="nav-ul">
				<li class="nav-li"><a href="javascript:void(0)">政策法规</a></li>
				<li class="nav-li"><a href="javascript:void(0)">添加政策</a></li>
			</ul>
		</div>
	<div class="table" align="center">
		<h1>政策信息库</h1>
		<form
			action="${pageContext.request.contextPath }/back/zcfg/zcfgServlet?method=add"
			method="post" id="checkForm">
			<table width="800" border="1"  style="border-collapse: collapse;" class="form-table">
				<tr>
					<td width="99"><div align="center">政策名称&nbsp;&nbsp;<font style="color: red">*</font> </div></td>
					<td colspan="3"><input id="zcmc" name="zcmc" type="text"
						style="width: 99%" /></td>
				</tr>
				<tr>
					<td><div align="center">公布日期&nbsp;&nbsp;<font style="color: red">*</font></div></td>
					<td width="286"><input style="width: 99%" id="gbrq"
						name="bgbrq" type="text" onclick="J.calendar.get({id:'gbrq'});"
						readonly="readonly" /></td>
					<td width="101"><div align="center">施行日期</div></td>
					<td width="286"><input style="width: 99%" id="sxrq"
						name="bsxrq" type="text" onclick="J.calendar.get({id:'sxrq'});"
						readonly="readonly" /></td>
				</tr>
				<tr>
					<td><div align="center">政策分类</div></td>
					<td>
						<!-- 		    	<input id="zcfl" name="zcfl" type="text" /> --> <select
						name="zcflmc" id="zcfl" style="width: 99%">
							<option value="地方非立法性文件">地方非立法性文件</option>
							<option value="地方性法规">地方性法规</option>
							<option value="地方政府规章">地方政府规章</option>
							<option value="国家法律">国家法律</option>
							<option value="国家非立法性文件">国家非立法性文件</option>
							<option value="国务院部门规章">国务院部门规章</option>
							<option value="行政法规">行政法规</option>
					</select>
					</td>
					<td><div align="center">颁布形式</div></td>
					<td>
						<!-- 		    	<input id="bbxs" name="bbxs" type="text" /> --> <select
						name="bbbxsmc" id="bbxs" style="width: 99%">
							<option value="部门首长令">部门首长令</option>
							<option value="地方人民代表大会主席团">地方人民代表大会主席团</option>
							<option value="地方首长令">地方首长令</option>
							<option value="国家主席令">国家主席令</option>
							<option value="国务院令">国务院令</option>
							<option value="下发文件">下发文件</option>
							<option value="政府公告">政府公告</option>
					</select>
					</td>
				</tr>
				<tr>
					<td><div align="center">政策文号&nbsp;&nbsp;<font style="color: red">*</font></div></td>
					<td colspan="3"><input style="width: 99%" id="zcwh"
						name="zcwh" type="text" /></td>
				</tr>
				<tr>
					<td><div align="center">制定机关</div></td>
					<td colspan="3"><input style="width: 99%" id="zdjg"
						name="bzdjgmc" type="text" /></td>
				</tr>
				<tr>
					<td><div align="center">施行范围</div></td>
					<td colspan="3"><input style="width: 99%" id="sxfw"
						name="bsxfwmc" type="text" /></td>
				</tr>
				<tr>
					<td><div align="center">主题词&nbsp;&nbsp;<font style="color: red">*</font></div></td>
					<td colspan="3"><input style="width: 99%" id="ztc"
						name="ztcmc" type="text" /></td>
				</tr>
				<tr>
					<td><div align="center">关键字</div></td>
					<td colspan="3"><input style="width: 99%" id="gjz"
						name="gjzmc" type="text" /></td>
				</tr>
				<tr>
					<td><div align="center">主要针对对象&nbsp;&nbsp;<font style="color: red">*</font></div></td>
					<td colspan="3">
						<!-- 		    	<input id="zyzddx" name="zyzddx" type="text" /> -->
						<div id="zyzddx" class="zyzddx">
							<c:forEach items="${zyzddx }" var="z" varStatus="vs">
								<c:if test="${vs.count%5==0 }">
									<input style="width: 2%" type="checkbox" name="ttzlymc"
										id="zyzddx" value="${z.zyzddxid }" />${z.zyzddxmc }<br>
								</c:if>
								<c:if test="${vs.count%5!=0 }">
									<input style="width: 2%" type="checkbox" name="ttzlymc"
										id="zyzddx" value="${z.zyzddxid }" />${z.zyzddxmc }
 	        	</c:if>
							</c:forEach>
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="4"><div align="center">政策内容</div></td>
				</tr>
				<tr>
					<td colspan="4"><textarea name="zcnr" id="content1" cols="100"
							rows="1000" style="width: 780px; height: 350px;"></textarea></td>
				</tr>
			</table>
			<br> <br> <br> <br>
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
	<script type="text/javascript">
		var editor = new UE.ui.Editor();
		editor.render("content1");
	</script>
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




