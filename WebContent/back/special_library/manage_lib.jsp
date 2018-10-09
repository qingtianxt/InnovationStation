<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="u" uri="http://localhost:8080/3-28/util"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>专题库管理</title>
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
		<li class="nav-li"><a href="#">专题专利</a></li>
		<li class="nav-li"><a href="#">专题库管理</a></li>
	</ul>
	</div>
			<form action="libraryServlet?method=list&result=list" method="post">
				<table class="query-table">
					<tr>
						<td>专利库名称：</td>
						<td><input name="name" value="${param.name }" type="text"
							id="ztzlk" placeholder="专题库名称" /></td>
						<td>发布人：</td>
						<td><input name="publisher" type="text" id="fbr"
							value="${param.publisher }" placeholder="发布人" /></td>
					</tr>
					<tr>
						<td>发布时间：</td>
						<td><input name="startTime" value="${param.startTime }"
							type="text" id="time1" onclick="J.calendar.get({id:'time1'});"
							readonly="readonly" placeholder="起始时间" />
						<td>截止时间：
						<td><input name="endTime" value="${param.endTime }"
							type="text" id="time2" onclick="J.calendar.get({id:'time2'});"
							readonly="readonly" placeholder="截止时间" />
						<td><input type="submit" value="查询" onclick="fun()" /></td>
					</tr>
					<!-- 				  <tr> -->
					<!-- 				    <td height="21">专利库简介：</td> -->
					<!-- 				    <td colspan="3"> -->
					<%-- 				    	<input name="intro" type="text" id="zlkjj" value="${param.intro }" style="width:350px" placeholder="专题库简介"/> --%>
					<!-- 			        </td> -->
					<!-- 		        </tr> -->
				</table>

			</form>
		</div>
		<div>
			<table class='result-table'>
				<tr>
					<td width="5%" height="20"><div align="center">序号</div></td>
					<td width="30%" height="20"><div align="center">专利库名称</div></td>
					<td width="7%" height="20"><div align="center">发布人</div></td>
					<td width="10%" height="20"><div align="center">发布时间</div></td>
					<td width="13%" height="20"><div align="center">基本操作</div></td>
				</tr>
				<c:forEach items="${libraries }" var="library" varStatus="status">
					<tr>
						<td>${status.index+1 + (sessionScope.pagingBean.currentPage-1) * sessionScope.pagingBean.pageSize }</td>
						<td style="text-align: left; padding-left: 30px;">${library.title }</td>
						<td style="text-align: left; padding-left: 30px;">${library.publisher }</td>
						<td>${library.date }</td>
						<td><a
							href="libraryServlet?method=getLib&id=${library.id }&result=detail">查看</a>|
							<a
							href="libraryServlet?method=getLib&id=${library.id }&result=edit">编辑</a>|
							<a href="import_patent.jsp?id=${library.id }">发布</a>| <a
							href="javascript:del(${library.id })">删除</a></td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="5"><u:page
							pagingBean="${sessionScope.pagingBean }" /></td>
				</tr>
			</table>
			<script type="text/javascript">
				function del(id) {
					layer.open({
						content : '你确定要删除吗?',
						btn : [ '确认', '取消' ],
						yes : function(index, layero) {
							location.href = "libraryServlet?method=del&id="
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
			<c:if test="${param.msg.equals('999') }">
				<script type="text/javascript">
					$(function() {
						layer.alert('发布成功', {
							skin : 'layui-layer-lan' //样式类名
							,
							closeBtn : 0
						});

					})
				</script>
			</c:if>
			<c:if test="${param.msg.equals('1000') }">
				<script type="text/javascript">
					$(function() {
						layer.alert('发布失败', {
							skin : 'layui-layer-lan' //样式类名
							,
							closeBtn : 0
						});

					})
				</script>
			</c:if>
		</div>
</body>
<script type="text/javascript">
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
	errorPlacement:function(error,element){
		layer.open({
			content:error.html(),btn:["确定"],skin:"layui-layer-lan",btn1:function(index,layero){layer.close(index);element.val("");}
		});								
		
		return false;
	},onfocusout:false,onkeyup:false,onclick:false
})
</script>
</html>