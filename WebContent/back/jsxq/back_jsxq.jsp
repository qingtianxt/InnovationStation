<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>企业需求</title>
<!-- css  js文件链接 -->
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.4.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/lhgcore.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/lhgcalendar.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/layer/layer.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery.validate.js"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/sl.css">

<!-- 上传信息 -->

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
}
</style>

<body bgcolor="#DDF2FC">
	<div class="nav">
		您现在的位置：
		<ul class="nav-ul">
			<li class="nav-li"><a href="javascript:void(0)">企业需求</a></li>
			<li class="nav-li"><a href="javascript:void(0)">添加需求</a></li>
		</ul>
	</div>
	<div class="table" align="center">
		<h1>添加企业需求</h1>
		<form
			action="${pageContext.request.contextPath }/back/jsxq/qyxq?method=add"
			method="post" id="checkForm">
			<table width="775" height="1071" border="1"
				style="border-collapse: collapse;" class="form-table">
				<tr>
					<td width="141"><div align="center">
							技术需求名称&nbsp;&nbsp;<font style="color: red">*</font>
						</div></td>
					<td colspan="3"><input id="mc" name="mc" type="text"
						maxlength="100" style="width: 99%;" /></td>
				</tr>
				<tr>
					<td height="38"><div align="center">合作方式</div></td>
					<td><select name="hzfs" id="hzfs" style="width: 60%;">
							<option value="成果引进">成果引进</option>
							<option value="联合研发">联合研发</option>
							<option value="其他">其他</option>
					</select></td>
					<td><div align="center">E-Mail</div></td>
					<td><input id="email" name="email" type="text"
						style="width: 99%;" /></td>
				</tr>
				<tr>
					<td height="38"><div align="center">
							技术需求单位&nbsp;&nbsp;<font style="color: red">*</font>
						</div></td>
					<td colspan="3"><input id="mc_dw" name="mc_dw" type="text"
						maxlength="100" style="width: 99%;" /></td>
				</tr>
				<tr>
					<td height="38"><div align="center">
							单位地址&nbsp;&nbsp;<font style="color: red">*</font>
						</div></td>
					<td colspan="3"><input id="dz_dw" name="dz_dw" type="text"
						style="width: 99%;" /></td>
				</tr>
				<tr>
					<td height="38"><div align="center">
							联系人&nbsp;&nbsp;<font style="color: red">*</font>
						</div></td>
					<td width="262"><input id="lxr" name="lxr" type="text"
						maxlength="50" style="width: 99%;" /></td>
					<td width="125"><div align="center">
							联系电话&nbsp;&nbsp;<font style="color: red">*</font>
						</div></td>
					<td width="254"><input id="dh_lx" name="dh_lx" type="text"
						maxlength="11" style="width: 99%;" /></td>
				</tr>
				<tr>
					<td height="38"><div align="center">投入总资金及用途</div></td>
					<td colspan="3"><input id="yt_tr" name="yt_tr" type="text"
						style="width: 99%;" /></td>
				</tr>
				<tr>
					<td height="38"><div align="center">关键词</div></td>
					<td colspan="3"><input id="gjc" name="gjc" type="text"
						maxlength="100" style="width: 99%;" /></td>
				</tr>
				<tr>
					<td height="70"><div align="center">
							技术所属领域&nbsp;&nbsp;<font style="color: red">*</font>
						</div></td>
					<td colspan="3">
						<div id="jsssly" class="jsssly">
							<c:forEach items="${jsssly }" var="l" varStatus="vs">
								<c:if test="${vs.count%6==0 }">
									<input type="checkbox" name="ly_js" id="ly_js"
										value="${l.lyid }" />${l.lymc }<br>
								</c:if>
								<c:if test="${vs.count%6!=0 }">
									<input type="checkbox" name="ly_js" id="ly_js"
										value="${l.lyid }" />${l.lymc }
        	</c:if>
							</c:forEach>
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="4" height="38"><div align="center">单位情况简介</div></td>
				</tr>
				<tr>
					<td height="100" colspan="4"><textarea id="jj_dw" name="jj_dw"
							style="height: 150px; width: 775px"></textarea></td>
				</tr>
				<tr>
					<td colspan="4" height="38"><div align="center">技术需求说明</div></td>
				</tr>
				<tr>
					<td height="100" colspan="4"><textarea id="nr_xq" name="nr_xq"
							style="height: 150px; width: 775px"></textarea></td>
				</tr>
				<tr>
					<td colspan="4" height="38"><div align="center">人才信息</div></td>
				</tr>
				<tr>
					<td height="100" colspan="4"><textarea id="rcxx" name="rcxx"
							style="height: 150px; width: 775px"></textarea></td>
				</tr>
				<tr>
					<td colspan="4" height="38"><div align="center">资金信息</div></td>
				</tr>
				<tr>
					<td height="100" colspan="4"><textarea id="zjxx" name="zjxx"
							style="height: 150px; width: 775px"></textarea></td>
				</tr>
				<tr>
					<td colspan="4" height="38"><div align="center">项目状况</div></td>
				</tr>
				<tr>
					<td height="100" colspan="4"><textarea id="xmzk" name="xmzk"
							style="height: 150px; width: 775px"></textarea></td>
				</tr>
			</table>

			<br> <br> <br> <br>
			<div align="center">
				<input id="upload" type="button" value="保存"
					style="hight: 80px; width: 150px">
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
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/js/qyxq/back_jsxq.js"></script>
</body>
</html>