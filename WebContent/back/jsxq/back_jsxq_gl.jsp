<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="util" uri="http://localhost:8080/3-28/util"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>技术需求管理</title>
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
				<li class="nav-li"><a href="javascript:void(0)">企业需求</a></li>
				<li class="nav-li"><a href="javascript:void(0)">需求管理</a></li>
			</ul>
		</div>
		<div>
			<form
				action="${pageContext.request.contextPath }/back/jsxq/qyxq?method=getGlList&currentPage=1"
				method="post" id="checkForm">
				<table class="query-table">
					<tr>
						<td>需求名称：</td>
						<td><input name="mc" type="text" id="mc" width=""
							maxlength="100" value="${qyxqPagingBean.mc }" /></td>
						<td>需求说明：</td>
						<td><input name="nr_xq" type="text" id="nr_xq"
							value="${qyxqPagingBean.nr_xq }" /></td>
					</tr>

					<tr>
						<td height="21">起始时间：</td>
						<td><input name="time1" type="text" id="time1"
							onclick="J.calendar.get({id:'time1'});" readonly="readonly"
							value="${qyxqPagingBean.time1 }" /></td>
						<td>截止时间：</td>
						<td><input name="tim21" type="text" id="time2"
							onclick="J.calendar.get({id:'time2'});" readonly="readonly"
							value="${qyxqPagingBean.time2 }" /></td>
					</tr>
					<tr>
						<td>所属领域：</td>
						<td><select name="jsssly" id="jsssly"><option
									value="">请选择</option>
								<c:forEach items="${jsssly }" var="j">
									<option value="${j.lyid }">${j.lymc }</option>
								</c:forEach>
						</select></td>
						<td>
						<td><input type="submit" value="查询" id="sb" /></td>
					</tr>
				</table>

				<script type="text/javascript">
					$("#mc").val("${qyxqPagingBean.mc}");
					$("#nr_xq").val("${qyxqPagingBean.nr_xq}");
					$("#time1").val("${qyxqPagingBean.time1}");
					$("#time2").val("${qyxqPagingBean.time2}");
					$("#jsssly").val("${qyxqPagingBean.jsssly}");

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
						} else {
							$("#checkForm").submit();
						}
					});
				</script>
			</form>
			<div>
				<table class="result-table">
					<tr>
						<th>序号</th>
						<th>技术需求名称</th>
						<th>合作方式</th>
						<th>发布时间</th>
						<th>审核状态</th>
						<th>基本操作</th>
					</tr>
					<c:forEach varStatus="status" items="${qyxqPagingBean.list }"
						var="item">
						<tr>
							<td>${status.index+1+(qyxqPagingBean.currentPage-1)*qyxqPagingBean.pageSize }</td>
							<td style="text-align: left; padding: 0 15px;"
								title="${item.mc }">${item.mc }</td>
							<td style="text-align: left; padding: 0 15px;"
								title="${item.hzfs }">${item.hzfs }</td>
							<td>${item.time }</td>
							<td><c:if test="${item.sh==1 }">通过</c:if> <c:if
									test="${item.sh==-1 }">不通过</c:if> <c:if test="${item.sh==0 }">未审核</c:if></td>
							<td><a href='javascript:void(0)'
								onclick="delete1('${item.id}')">删除</a>| <a
								href='${pageContext.request.contextPath }/back/jsxq/qyxq?method=getInfo&id=${item.id}'>查看</a></td>
						</tr>
					</c:forEach>
					<tr>
						<td colspan="6"><util:page pagingBean="${qyxqPagingBean }" /></td>
					</tr>
				</table>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		function delete1(obj) {
			layer
					.open({
						content : '你确定要删除吗?',
						btn : [ '确认', '取消' ],
						yes : function(index, layero) {
							location.href = "${pageContext.request.contextPath }/back/jsxq/qyxq?method=delete&id="
									+ obj;
						},
						btn2 : function(index, layero) {

						},
						cancel : function() {
							//右上角关闭回调  
						}
					});
		}
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