<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="util" uri="http://localhost:8080/3-28/util"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="refresh">
		<!--                   查询                                                                      -->
		<div class="search">
			<form
				action="${pageContext.request.contextPath }/front/zjxx/zjxxFrontServlet?method=getList&currentPage=1"
				method="post" id="checkForm">
				<a>选择时间段：</a> <input readonly="readonly" type="text" name="time1"
					id="time1" style="width: 100px; height: 28px"> <img
					src="${pageContext.request.contextPath}/images/date.png" id="date1"
					width="20" height="20" border="0"
					onclick="J.calendar.get({id:'time1'});"> <a>到：</a> <input
					readonly="readonly" type="text" name="time2" id="time2"
					style="width: 100px; height: 28px"> <img
					src="${pageContext.request.contextPath}/images/date.png" id="date2"
					width="20" height="20" border="0"
					onclick="J.calendar.get({id:'time2'});"> <a>标题：</a> <input
					type="text" style="width: 200px; height: 28px" id="xm" name="xm">
				<!-- 							<input type="text" style="width: 200px; height: 28px" value="请输入..." -->
				<!-- 							onfocus="if(value=='请输入...') {value='';}" onblur="if (value=='') {value='请输入...';}">  -->
				<a href="javascript:void(0)" id="sb"> <img
					src="${pageContext.request.contextPath}/images/search.png"
					name="mc" id="mc" width="77" height="28" border="0">
				</a>
			</form>
		</div>
		<script type="text/javascript">
				$("#mc").val("${zjxxPagingBean.xm}");
				$("#time1").val("${zjxxPagingBean.time1}");
				$("#time2").val("${zjxxPagingBean.time2}");

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
		<!--                          显示结果                      start                                             -->
		<div class="display">
			<table bgcolor="#99D1D3" height="50">
				<tr>
					<td width="450" style="text-align: center; font-family: '黑体'">姓名</td>
					<td width="150" style="text-align: center; font-family: '黑体'">学科领域</td>
					<td width="150" style="text-align: center; font-family: '黑体'"
						id="QYXQ_fbsj" title="点击按时间排序结果">发布时间</td>
					<td width="100" style="text-align: center; font-family: '黑体'"
						id="QYXQ_djl" title="点击按点击量排序结果">点击量</td>
				</tr>
			</table>

			<table id="datatable" border="0" cellspacing="0" cellpadding="0">
				<c:forEach items="${zjxxPagingBean.list }" var="p">
					<tr height="40">
						<td width="450" style="text-align: left; font-family: '黑体'">&nbsp;&nbsp;<a
							href="${pageContext.request.contextPath }/front/zjxx/zjxxFrontServlet?method=getById&id=${p.id}" target="_blank">${p.xm }</a></td>
						<td width="150" style="text-align: center"><a>${p.xkly }</a></td>
						<td width="150" style="text-align: center"><a>${p.rq_cs }</a></td>
						<td width="100" style="text-align: center"><a>${p.hits }</a></td>
					</tr>
				</c:forEach>
			</table>
			<util:page pagingBean="${zjxxPagingBean }" />
		</div>

		<!--                          显示结果                         end                                          -->
	</div>
</body>
</html>