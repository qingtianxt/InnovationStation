<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="util" uri="http://localhost:8080/3-28/util"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>科技成果管理</title>
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
			<li class="nav-li"><a href="javascript:void(0)">科技成果</a></li>
				<li class="nav-li"><a href="javascript:void(0)">成果管理</a></li>
			</ul>
		</div>
		<div>
			<form
				action="${pageContext.request.contextPath }/back/kjcg/kjcgServlet?method=getList&currentPage=1"
				method="post" id="checkForm">
				<table class="query-table">
					<tr>
						<td>成果名称：</td>
						<td><input name="mc" type="text" id="kjcgmc" width=""
							value="${kjcgPagingBean.mc }" /></td>
						<td>所属单位：</td>
						<td><input name="dw" type="text" id="kjssdw"
							value="${kjcgPagingBean.dw }" /></td>
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
					</tr>
					<tr>
						<td>成果类型：</td>
						<td><select name="km" id="kjcglx">
								<option value="">请选择</option>
								<option value="成果转化项目">成果转化项目</option>
								<option value="成功案例">成功案例</option>
						</select></td>
						<td>
						<td><input type="submit" value="查询" id="sb" /></td>
					</tr>
				</table>

				<script type="text/javascript">
					$("#kjcgmc").val("${kjcgPagingBean.mc}");
					$("#kjcglx").val("${kjcgPagingBean.km}");
					$("#kjssdw").val("${kjcgPagingBean.dw}");
					$("#time1").val("${kjcgPagingBean.time1}");
					$("#time2").val("${kjcgPagingBean.time2}");
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

					function getNext(obj) {
						var page = obj.name;
						$("#checkForm")
								.attr(
										"action",
										"${pageContext.request.contextPath }/back/kjcg/kjcgServlet?method=getList&currentPage=1");
						//alert($("#checkForm").attr('action'));

						$("#checkForm").submit();
					}
				</script>
			</form>
			<div>
				<table class="result-table">
					<tr>
						<th>序号</th>
						<th>科技成果名称</th>
						<th>科技成果类型</th>
						<th>科技所属单位</th>
						<th>发布时间</th>
						<th>基本操作</th>
					</tr>
					<c:forEach varStatus="status" items="${kjcgPagingBean.list }"
						var="item">
						<tr>
							<td>${status.index+1+(kjcgPagingBean.currentPage-1)*kjcgPagingBean.pageSize }</td>
							<td style="text-align: left; padding: 0 15px;"
								title="${item.mc }">${item.mc }</td>
							<td style="text-align: left; padding: 0 15px;"
								title="${item.km }">${item.km }</td>
							<td>${item.dw }</td>
							<td>${item.time }</td>
							<td><a href='javascript:void(0)'
								onclick="delete1('${item.id}')">删除</a> | <a
								href="${pageContext.request.contextPath }/back/kjcg/kjcgServlet?method=look&id=${item.id}">查看</a>
								| <a
								href='${pageContext.request.contextPath }/back/kjcg/kjcgServlet?method=editUI&id=${item.id}'>编辑</a></td>
						</tr>
					</c:forEach>
					<tr>
						<td colspan="6"><util:page pagingBean="${kjcgPagingBean }" /></td>
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
							location.href = "${pageContext.request.contextPath }/back/kjcg/kjcgServlet?method=delete&id="
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