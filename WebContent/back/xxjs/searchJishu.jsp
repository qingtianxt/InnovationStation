<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="util" uri="http://localhost:8080/3-28/util"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>技术管理</title>
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
<script type="text/javascript">
	$(document).ready(function() {
		$.validator.addMethod("checkDate", function(value, element) {
			try {
				var time1 = Date.parse($("#time1").val());
				var time2 = Date.parse($("#time2").val());
				if (isNaN(time1) || isNaN(time2))
					return true;
				var flag = time1 < time2;
				return flag;
			} catch (e) {
				return true;
			}
		}, "日期范围错误");
		$("form").validate({
			rules : {
				endTime : {
					checkDate : true
				}
			},
			errorPlacement : function(error, element) {
				layer.open({
					content : error.html(),
					btn : [ "确定" ],
					skin : "layui-layer-lan",
					btn1 : function(index, layero) {
						layer.close(index);
						element.focus();
					}
				});

				return false;
			},
			onfocusout : false,
			onkeyup : false,
			onclick : false
		})
	});
</script>
</head>
<body>
	<div>
		<div class="nav">
			您现在的位置：
			<ul class="nav-ul">
				<li class="nav-li"><a
					href="${pageContext.request.contextPath }/back/welcome.jsp">首页</a></li>
				<li class="nav-li"><a href="javascript:void(0)">找技术</a></li>
			</ul>
		</div>
		<div>
			<form
				action="${pageContext.request.contextPath }/back/xxjs/xxjsServlet?method=searchJishu"
				method="post" id="form">
				<table class="query-table">
					<tr>
						<td>技术名称：</td>
						<td><input name="techName" type="text" id="jsmc" width=""
							value="${supplyPageBean.techName }" /></td>
						<td>关键词：</td>
						<td><input name="keyWord" type="text" id="gjc"
							value="${supplyPageBean.keyWord }" /></td>
					</tr>

					<tr>
						<td height="21">起始时间：</td>
						<td><input name="startTime" type="text" id="time1"
							onclick="J.calendar.get({id:'time1'});" readonly="readonly"
							value="${supplyPageBean.startTime }" /></td>
						<td>截止时间：</td>
						<td><input name="endTime" type="text" id="time2"
							onclick="J.calendar.get({id:'time2'});" readonly="readonly"
							value="${supplyPageBean.endTime }" /></td>
					</tr>
					<tr>
						<td>所属高新技术类别：</td>
						<td><select name="category" id="jslb"><option
									value="">请选择</option>
								<c:forEach items="${category }" var="category">
									<option
										<c:if test="${category[1].equals(supplyPageBean.category) }">selected="selected"</c:if>>${category[1] }</option>
								</c:forEach>
						</select></td>
						<td>
						<td><input type="submit" value="查询" /></td>
					</tr>
				</table>
			</form>
			<div>
				<table class="result-table">
					<tr>
						<th>序号</th>
						<th>技术名称</th>
						<th>所属高新技术类别</th>
						<th>发布时间</th>
						<th>审核状态</th>
						<th>基本操作</th>
					</tr>
					<c:forEach varStatus="status" items="${SupplyList }" var="supply">
						<tr>
							<td>${status.index+1+(supplyPageBean.currentPage-1)*supplyPageBean.pageSize }</td>
							<td style="text-align: left; padding: 0 15px;"
								title="${supply.mc }">${supply.mc }</td>
							<td style="text-align: left; padding: 0 15px;"
								title="${supply.jslb }">${supply.jslb }</td>
							<td>${supply.time }</td>
							<td><c:if test="${supply.sh==1 }">通过</c:if> <c:if
									test="${supply.sh==-1 }">不通过</c:if> <c:if
									test="${supply.sh==0 }">未审核</c:if></td>
							<td><a
								href="${pageContext.request.contextPath }/back/xxjs/xxjsServlet?method=getSupplyById&id=${supply.id }">查看</a></td>
						</tr>
					</c:forEach>
					<tr>
						<td colspan="6"><util:page pagingBean="${supplyPageBean }" /></td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</body>
</html>