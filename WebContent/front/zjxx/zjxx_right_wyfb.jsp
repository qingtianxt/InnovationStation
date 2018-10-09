<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/zjxx/front_zjxx.js"></script>
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
<body>
	<div id="refresh">
		<div align="center" class="table">
			<input type="hidden" name="user" id="user"
				value="${session_user.id }">
			<form
				action="${pageContext.request.contextPath }/front/zjxx/zjxxFrontServlet?method=add"
				method="post" id="checkForm">
				<br>
				<table width="800" height="549" border="1">
					<tr>
						<td width="100"><div align="center">姓名</div></td>
						<td width="286"><input id="xm" name="xm" type="text" /></td>
						<td width="100"><div align="center">所在市</div></td>
						<td width="286"><input id="szs" name="szs" type="text" /></td>
					</tr>
					<tr>
						<td><div align="center">性别</div></td>
						<td><input id="xb" name="xb" type="text" /></td>
						<td><div align="center">国籍</div></td>
						<td><input id="gj" name="gj" type="text" /></td>
					</tr>
					<tr>
						<td><div align="center">办公电话</div></td>
						<td><input id="bgdh" name="bgdh" type="text" /></td>
						<td><div align="center">出生日期</div></td>
						<td><input id="csrq" name="csrq" type="text"
							onclick="J.calendar.get({id:'csrq'});" readonly="readonly" /></td>
					</tr>
					<tr>
						<td><div align="center">职称</div></td>
						<td><input id="zc" name="zc" type="text" /></td>
						<td><div align="center">手机</div></td>
						<td><input id="sj" name="sj" type="text" /></td>
					</tr>
					<tr>
						<td><div align="center">学位</div></td>
						<td><input id="xw" name="xw" type="text" /></td>
						<td><div align="center">主要成就</div></td>
						<td><input id="zycj" name="zycj" type="text" /></td>
					</tr>
					<tr>
						<td><div align="center">学历</div></td>
						<td><input id="xl" name="zl" type="text" /></td>
						<td><div align="center">研究方向</div></td>
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
						<td colspan="3"><input id="gzdw" name="gzdw" type="text" /></td>
					</tr>
					<tr>
						<td><div align="center">专家称号</div></td>
						<td colspan="3"><input id="zjch" name="zjch" type="text" /></td>
					</tr>
					<tr>
						<td><div align="center">学科领域</div></td>
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
						<td colspan="4"><textarea id="grjj" name="grjj"
								style="width: 800px; height: 200px"></textarea></td>
					</tr>
				</table>
				<br> <br> <br> <br>
				<div align="center">
					<input id="sb" type="button" value="保存"
						style="hight: 80px; width: 100px">
				</div>
			</form>
		</div>
	</div>
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