<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="util" uri="http://localhost:8080/3-28/util"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>平台信息管理</title>
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
				<li class="nav-li"><a href="javascript:void(0)">找平台</a></li>
			</ul>
		</div>
		<div>
			<form
				action="${pageContext.request.contextPath }/back/xxjs/xxjsServlet?method=searchPingtai&currentPage=1"
				method="post" id="checkForm">
				<table class="query-table">
					<tr>
						<td>单位名称：</td>
						<td><input name="mc" type="text" id="kjcgmc" width=""
							value="${fwptPagingBean.mc }" /></td>
						<td>平台类型：</td>
						<td><select name="km" id="km">
								<option value="">请选择</option>
								<option value="服务机构" >服务机构</option>
								<option value="国内新闻" >国内新闻</option>
								<option value="企业信息" >企业信息</option>
						</select></td>
					</tr>

					<tr>
						<td>联系人：</td>
						<td><input name="lxr" type="text" id="lxr"
							value="${fwptPagingBean.lxr }" /></td>
						<td>关键词：</td>
						<td><input name="gjc" type="text" id="gjc"
							value="${fwptPagingBean.gjc }" /></td>
						<td>
						<td><input type="submit" value="查询" id="sb" /></td>
					</tr>
				</table>

				<script type="text/javascript">
					$("#mc").val("${fwptPagingBean.mc}");
					$("#km").val("${fwptPagingBean.km}");
					$("#lxr").val("${fwptPagingBean.lxr}");
					$("#gjc").val("${fwptPagingBean.gjc}");
					$("#sb").click(function() {
							$("#checkForm").submit();
					});

					function getNext(obj) {
						var page = obj.name;
						$("#checkForm").submit();
					}
				</script>
			</form>
			<div>
				<table class="result-table">
					<tr>
						<th>序号</th>
						<th>单位名称</th>
						<th>平台类型</th>
						<th>联系人</th>
						<th>关键词</th>
						<th>基本操作</th>
					</tr>
					<c:forEach varStatus="status" items="${fwptPagingBean.list }"
						var="item">
						<tr>
							<td>${status.index+1+(fwptPagingBean.currentPage-1)*fwptPagingBean.pageSize }</td>
							<td style="text-align: left; padding: 0 15px;"
								title="${item.mc }">${item.mc }</td>
							<td style="text-align: left; padding: 0 15px;"
								title="${item.km }">${item.km }</td>
							<td>${item.lxr }</td>
							<td>${item.gjc }</td>
							<td><a
								href="${pageContext.request.contextPath }/back/xxjs/xxjsServlet?method=getPingTaiByKmAndMc&mc=${item.mc}&km=${item.km }">查看</a>
							</td>
						</tr>
					</c:forEach>
					<tr>
						<td colspan="6"><util:page pagingBean="${fwptPagingBean }" /></td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</body>
</html>