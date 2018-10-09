<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="util" uri="http://localhost:8080/3-28/util"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>政策法规信息管理</title>
<style type="text/css">
</style>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/sl.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.12.1.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery.validate.js"></script>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/css/lhgcalendar.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/lhgcore.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/lhgcalendar.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/layer/layer.js"></script>

</head>
<body>
	<div>
	<div class="nav">
			您现在的位置：
			<ul class="nav-ul">
				<li class="nav-li"><a href="${pageContext.request.contextPath }/back/welcome.jsp">首页</a></li>
				<li class="nav-li"><a href="javascript:void(0)">找政策</a></li>
			</ul>
		</div>
		<div>
			<form
				action="${pageContext.request.contextPath }/back/xxjs/xxjsServlet?method=searchZhengce&currentPage=1"
				method="post" id="checkForm">
				<table class="query-table">
					<tr>
						<td>政策名称：</td>
						<td><input name="zcmc" type="text" id="zcmc" width=""
							value="${zcfgPagingBean.zcmc }" /></td>
						<td>主题词：</td>
						<td><input name="ztcmc" type="text" id="ztcmc"
							value="${zcfgPagingBean.ztcmc }" /></td>
					</tr>

					<tr>
						<td>政策类型：</td>
						<td><select name="zcflmc" id="zcflmc">
								<option value="">请选择</option>
								<option value="地方非立法性文件">地方非立法性文件</option>
								<option value="地方性法规">地方性法规</option>
								<option value="地方政府规章">地方政府规章</option>
								<option value="国家法律">国家法律</option>
								<option value="国家非立法性文件">国家非立法性文件</option>
								<option value="国务院部门规章">国务院部门规章</option>
								<option value="行政法规">行政法规</option>
						</select></td>
						<td>政策文号：</td>
						<td><input name="zcwh" type="text" id="zcwh"
							value="${zcfgPagingBean.zcwh }" /></td>
					</tr>
					<tr>
						<td height="21">起始时间：</td>
						<td><input name="time1" type="text" id="time1"
							onclick="J.calendar.get({id:'time1'});" readonly="readonly"
							value="${kjcgPagingBean.time1 }" /></td>
						<td>截止时间：</td>
						<td><input name="tim21" type="text" id="time2"
							onclick="J.calendar.get({id:'time2'});" readonly="readonly"
							value="${kjcgPagingBean.time2 }" /></td>
						<td><input type="submit" value="查询" id="sb" /></td>
					</tr>


				</table>

				<script type="text/javascript">
					$("#zcmc").val("${zcfgPagingBean.zcmc}");
					$("#zcflmc").val("${zcfgPagingBean.zcflmc}");
					$("#ztcmc").val("${zcfgPagingBean.ztcmc}");

					$("#time1").val("${zcfgPagingBean.time1}");
					$("#time2").val("${zcfgPagingBean.time2}");
					$("#zcwh").val("${zcfgPagingBean.zcwh}");

					$("#sb").click(function() {
						var time1 = $("#time1").val();
						var time2 = $("#time2").val();
						if (time1 > time2) {
							layer.alert('时间分布不合理', {
								skin : 'layui-layer-lan' //样式类名
								,
								closeBtn : 0
							});
							return;
						}
						$("#checkForm").submit();
					});
				</script>
			</form>
			<div>
				<table class="result-table">
					<tr>
						<th>序号</th>
						<th>政策名称</th>
						<th>政策类型</th>
						<th>公布日期</th>
						<th>基本操作</th>
					</tr>
					<c:forEach varStatus="status" items="${zcfgPagingBean.list }"
						var="item">
						<tr>
							<td>${status.index+1+(zcfgPagingBean.currentPage-1)*zcfgPagingBean.pageSize }</td>
							<td style="text-align: left; padding: 0 15px;"
								title="${item.zcmc }">${item.zcmc }</td>
							<td style="text-align: left; padding: 0 15px;"
								title="${item.zcflmc }">${item.zcflmc }</td>
							<td title="${item.bgbrq }">${item.bgbrq }</td>
							<td><a
								href='${pageContext.request.contextPath }/back/xxjs/xxjsServlet?method=getZhengceById&id=${item.id}'>查看</a>
							</td>
						</tr>
					</c:forEach>
					<tr>
						<td colspan="5"><util:page pagingBean="${zcfgPagingBean }" /></td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</body>
</html>