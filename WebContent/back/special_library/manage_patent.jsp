<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="u" uri="http://localhost:8080/3-28/util"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/time.js"></script>
<title>专利管理</title>
</head>
<body>
	<div>
		<div class="nav">
	您现在的位置：
	<ul class="nav-ul">
		<li class="nav-li"><a href="#">专题专利</a></li>
		<li class="nav-li"><a href="#">专利管理</a></li>
	</ul>
	</div>
			<form action="patentServlet?method=list&result=list" method="post">
				<table class="query-table">
					<tr>
						<td>发明专利名称：</td>
						<td><input name="name" value="${pagingBean.name }"
							type="text" id="fwptmc" placeholder="请输入专利名称" /></td>
						<td>专利号：</td>
						<td><input name="patentNumber" type="text"
							value="${pagingBean.patentNumber }" placeholder="请输入专利号">
						</td>
					</tr>
					<tr>
						<td>起始时间：</td>
						<td><input name="startTime" value="${pagingBean.startTime }"
							type="text" id="time1" onclick="J.calendar.get({id:'time1'});"
							readonly="readonly" placeholder="申请时间" />
						<td>截止时间：</td>
						<td><input name="endTime" value="${pagingBean.endTime }"
							type="text" id="time2" onclick="J.calendar.get({id:'time2'});"
							readonly="readonly" placeholder="申请时间" /></td>
						<td><input type="submit" value="查询" /></td>
					</tr>
					<!-- 		  <tr> -->
					<!-- 		  	<td height="21">摘要：</td> -->
					<!-- 		    <td colspan="3"> -->
					<!-- 		    	<input name="summary" type="text" id="gjc" style="width:350px"/> -->
					<!-- 	        </td> -->
					<!-- 		  </tr> -->
				</table>
			</form>
		</div>
		<div>
			<table class='result-table'>
				<tr>
					<td width="5%" height="20"><div align="center">序号</div></td>
					<td width="30%" height="20"><div align="center">发明名称</div></td>
					<td width="10%" height="20"><div align="center">专利号</div></td>
					<td width="10%" height="20"><div align="center">申请时间</div></td>
					<td width="15%" height="20"><div align="center">基本操作</div></td>
				</tr>
				<c:forEach items="${patents }" var="patent" varStatus="status">
					<tr>
						<td>${status.index+1 + (sessionScope.pagingBean.currentPage-1) * sessionScope.pagingBean.pageSize }</td>
						<td style="text-align: left; padding-left: 15px">${patent.fmmc }</td>
						<td>${patent.zlh }</td>
						<td>${patent.sqrq }</td>
						<td><a
							href="patentServlet?method=getPatent&id=${patent.id }&result=detail">查看</a>
							<a
							href="patentServlet?method=getPatent&result=edit&id=${patent.id }">编辑</a>
							<a href="javascript:del(${patent.id })">删除</a></td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="5"><u:page
							pagingBean="${sessionScope.pagingBean }" /></td>
				</tr>
			</table>
		</div>
	</div>
	<script type="text/javascript">
		function del(id) {
			layer.open({
				content : '您确定要删除此条专利信息？',
				btn : [ '确认', '取消' ],
				yes : function(index, layero) {
					location.href = "patentServlet?method=del&result=list&id="
							+ id;
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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/time.js"></script>
</html>