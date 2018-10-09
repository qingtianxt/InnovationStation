<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="u" uri="http://localhost:8080/3-28/util" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.12.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.validate.js"></script>

<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/lhgcalendar.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/lhgcore.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/lhgcalendar.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/sl.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/layer/layer.js"></script>
<title></title>
</head>
<body>
<div>
	<div class="nav">
	您现在的位置：
	<ul class="nav-ul">
		<li class="nav-li"><a href="#">合作站点</a></li>
		<li class="nav-li"><a href="#">站点管理</a></li>
	</ul>
	</div>
	<div>
		<form action="coopSiteServlet?method=list&result=list" method="post">
			<table class="query-table">
			  <tr>
			    <td>站点名称：</td>
			    <td><input placeholder="请输入站点名称" name="siteName" type="text" id="name" width="" value="${pagingBean.siteName }"/></td>
			    <td>站点地址：</td>
			    <td><input name="siteLink" placeholder="请输入站点地址" type="text" id="link" value="${pagingBean.siteLink }"></td>
			    <td><input type="submit" value="查询"></td>
		      </tr>
			</table>
		</form>
	</div>
	<div>
		<table class="result-table">
			<tr >
		        <td width="5%"><div align="center">序号</div></td>
		        <td width="30%"><div align="center">站点名称</div></td>
		        <td width="30%"><div align="center">站点链接</div></td>
		        <td width="13%"><div align="center">基本操作</div></td>
  			</tr>
			<c:forEach items="${requestScope.coopSites }" var="coopSite" varStatus="status">
				<tr>
					<td>${status.index+1 + (sessionScope.pagingBean.currentPage-1) * sessionScope.pagingBean.pageSize }</td>
					<td style="text-align:left;padding-left:35px">${coopSite.name }</td>
					<td style="text-align:left;padding-left:35px"><a target="_black" href="${coopSite.link}">${coopSite.link }</a></td>
					<td>
						<a href="${coopSite.link }" target="_black">查看</a>|
						<a href="coopSiteServlet?method=getCoopSite&result=edit&id=${coopSite.id }">编辑</a>|
						<a href="javascript:del(${coopSite.id })">删除</a>
					</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="4"><u:page pagingBean="${pagingBean }"/></td>
			</tr>
		</table>
	</div>
</div>
<script type="text/javascript">
	function del(id){
		var url = "coopSiteServlet?method=del&result=list&id="+id;
		layer
		.open({
			content : '你确定要删除吗?',
			btn : [ '确认', '取消' ],
			yes : function(index, layero) {
				location.href = url;
			},
			btn2 : function(index, layero) {

			},
			cancel : function() {
				//右上角关闭回调  
			}
		});
	}
</script>
<c:if test="${param.msg.equals('1') }">
		<script type="text/javascript">
			$(function() {
				layer.alert('修改成功', {
					skin : 'layui-layer-lan' //样式类名
					,
					closeBtn : 0
				});

			})
		</script>
	</c:if>
	<c:if test="${param.msg.equals('2') }">
		<script type="text/javascript">
			$(function() {
				layer.alert('修改失败', {
					skin : 'layui-layer-lan' //样式类名
					,
					closeBtn : 0
				});

			})
		</script>
	</c:if>
<c:if test="${param.msg.equals('3') }">
		<script type="text/javascript">
			$(function() {
				layer.alert('删除成功', {
					skin : 'layui-layer-lan' //样式类名
					,
					closeBtn : 0
				});

			})
		</script>
	</c:if>
	<c:if test="${param.msg.equals('4') }">
		<script type="text/javascript">
			$(function() {
				layer.alert('删除失败', {
					skin : 'layui-layer-lan' //样式类名
					,
					closeBtn : 0
				});

			})
		</script>
	</c:if>
</body>
</html>