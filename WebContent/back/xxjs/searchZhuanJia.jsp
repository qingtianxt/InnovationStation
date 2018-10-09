<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="util" uri="http://localhost:8080/3-28/util"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>专家信息管理</title>
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
				<li class="nav-li"><a href="javascript:void(0)">找专家</a></li>
			</ul>
		</div>
		<div>
			<form
				action="${pageContext.request.contextPath }/back/xxjs/xxjsServlet?method=searchZhuanJia&currentPage=1"
				method="post" id="checkForm">
				<table class="query-table">
					<tr>
						<td>专家姓名：</td>
						<td><input name="xm" type="text" id="xm" width=""
							value="${zjxxPagingBean.xm }" /></td>
						<td>职称：</td>
						<td><input name="zc_zy" type="text" id="zc_zy"
					/></td>
					</tr>

					<tr>
						<td>学科领域：</td>
						<td><input name="xkly" type="text" id="xkly" width=""
							value="${zjxxPagingBean.xkly }" /></td>
						<td>所在市：</td>
						<td><input name="mc_szs" type="text" id="mc_szs"
							value="${zjxxPagingBean.mc_szs }" /></td>
					</tr>


					<tr>
						<td>研究方向：</td>
						<td><input name="yjfx" type="text" id="yjfx" /></td>
						<td>
						<td><input type="submit" value="查询" id="sb" /></td>
					</tr>
				</table>

				<script type="text/javascript">
					$("#xm").val("${zjxxPagingBean.xm}");
					$("#zc_zy").val("${zjxxPagingBean.zc_zy}");
					$("#xkly").val("${zjxxPagingBean.xkly}");
					$("#szs").val("${zjxxPagingBean.mc_szs}");
					$("#yjfx").val("${zjxxPagingBean.yjfx}");

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
						<th>专家姓名</th>
						<th>职称</th>
						<th>学科领域</th>
						<th>研究方向</th>
						<th>基本操作</th>
					</tr>
					<c:forEach varStatus="status" items="${zjxxPagingBean.list }"
						var="item">
						<tr>
							<td>${status.index+1+(zjxxPagingBean.currentPage-1)*zjxxPagingBean.pageSize }</td>
							<td style="text-align: left; padding: 0 15px;"
								title="${item.xm }">${item.xm }</td>
							<td style="text-align: left; padding: 0 15px;"
								title="${item.zc_zy }">${item.zc_zy }</td>
							<td title="${item.xkly }">${item.xkly }</td>
							<td title="${item.xkly }">${item.yjfx }</td>
							<td><a
								href='${pageContext.request.contextPath }/back/xxjs/xxjsServlet?method=getZhuanjiaById&id=${item.id}'>查看</a>
								</td>
						</tr>
					</c:forEach>
					<tr>
						<td colspan="6"><util:page pagingBean="${zjxxPagingBean }" /></td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</body>
</html>