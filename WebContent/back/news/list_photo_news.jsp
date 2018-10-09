<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="util" uri="http://localhost:8080/3-28/util"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/sl.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.12.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.validate.js"></script>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/lhgcalendar.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/lhgcore.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/lhgcalendar.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/layer/layer.js"></script>
<title>图片新闻查询</title>

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
			errorPlacement:function(error,element){
				layer.open({
					content:error.html(),btn:["确定"],skin:"layui-layer-lan",btn1:function(index,layero){layer.close(index);element.val("");}
				});								
				
				return false;
			},onfocusout:false,onkeyup:false,onclick:false
		})
	});
</script>
</head>
<body style="background-color: #ffffff">
	<div>
		<div class="nav">
	您现在的位置：
	<ul class="nav-ul">
		<li class="nav-li"><a href="#">新闻管理</a></li>
		<li class="nav-li"><a href="#">图片新闻管理</a></li>
	</ul>
</div>
			<!--查询框 -->
			<form action="newsPhotoServlet">
				<input type="hidden" name="method" value="list"> <input
					type="hidden" name="result" value="list">
				<table class="query-table">
					<tr>
						<td>发布人：</td>
						<td><input name="publisher" type="text" id="publisher"
							width="" value="${pagingBean.q_publisher }" /></td>
						<td>标题：</td>
						<td><input name="title" type="text" id="title"
							value="${pagingBean.q_title }"></td>
					</tr>
					<!-- 					<tr> -->
					<!-- 						<td>内容：</td> -->
					<%-- 						<td><input name="content" type="text" value="${pagingBean.q_content }" --%>
					<!-- 							id="content" /></td> -->
					<!-- 					</tr> -->
					<tr>
						<td height="21">起始时间：</td>
						<td><input name="startTime" type="text" id="time1"
							onclick="J.calendar.get({id:'time1'});" readonly="readonly"
							value="${pagingBean.startTime }" /></td>
						<td>截止时间：</td>
						<td><input name="endTime" type="text"
							value="${pagingBean.endTime }" id="time2"
							onclick="J.calendar.get({id:'time2'});" readonly="readonly" /></td>
						<td align="right"><input type="submit" value="查询" /></td>
					</tr>
				</table>

			</form>
		</div>

		<div class="result">
			<table class="result-table">
				<tr>
					<td width="5%" height="20" bgcolor="d3eaef"><div
							align="center">序号</div></td>
					<td width="30%" height="20" bgcolor="d3eaef"><div
							align="center">新闻标题</div></td>
					<td width="7%" height="20" bgcolor="d3eaef"><div
							align="center">发布人</div></td>
					<td width="10%" height="20" bgcolor="d3eaef"><div
							align="center">发布时间</div></td>
					<td width="13%" height="20" bgcolor="d3eaef"><div
							align="center">基本操作</div></td>
				</tr>
				<c:forEach items="${sessionScope.pagingBean.list }" var="newsPhoto"
					varStatus="status">
					<tr>
						<td>${status.index+1 + (sessionScope.pagingBean.currentPage-1) * sessionScope.pagingBean.pageSize  }</td>
						<td style="text-align: left; padding-left: 30px;">
							<!-- 				<div style="text-align:left;padding-left:30px;"> --> <%-- 					<c:if test="${newsPhoto.title.length()>15 }">${fn:substring(newsPhoto.title,0,15) }&nbsp;.&nbsp;.&nbsp;.</c:if> --%>
							<%-- 					<c:if test="${newsPhoto.title.length()<=15 }"> --%> <%-- 					</c:if> --%>
							<!-- 					</div> --> ${newsPhoto.title }
						</td>
						<td>${newsPhoto.publisher }</td>
						<td>${newsPhoto.time }</td>
						<td><a
							href="javascript:fun('get','detail','${newsPhoto.id }')">查看</a> <a
							href="javascript:fun('get','edit','${newsPhoto.id }')">编辑</a> <a
							href="javascript:del(${newsPhoto.id })">删除</a></td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan='5' bgcolor="d3eaef"><util:page pagingBean="${pagingBean }" /></td>
				</tr>
			</table>
		</div>

	 
	<c:set value="${pagingBean.preUrl }" var="preUrl" scope="request"></c:set>
	<script>
		function fun(method, result, id) {
			var url = "newsPhotoServlet?method="
					+ method
					+ "&result="
					+ result
					+ "&id="
					+ id
					+ "&currentPage=${pagingBean.currentPage}&pageSize=${pagingBean.pageSize}";
			location.href = url;
		}
		function del(id) {
			var url = "newsPhotoServlet?method=del&id=" + id;
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
	<%-- 	<c:set var="url" scope="request" value="${fn:replace(pagingBean.preUrl,'&','&nbsp;') }"></c:set> --%>
</body>
</html>