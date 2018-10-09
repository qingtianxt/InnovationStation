<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="u" uri="http://localhost:8080/3-28/util" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>角色管理</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.12.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.validate.js"></script>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/sl.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/lhgcalendar.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/lhgcore.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/lhgcalendar.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/sl.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/layer/layer.js"></script>
</head>
<body>
<div class="nav">
	您现在的位置：
	<ul class="nav-ul">
		<li class="nav-li"><a href="#">角色管理</a></li>
		<li class="nav-li"><a href="#">角色列表</a></li>
	</ul>
	</div>
<br>
<form action="../role/roleServlet?method=list&result=list" method="post">
	<table class="query-table">
	  <tr>
<!-- 	    <td>用户名：</td> -->
<%-- 	    <td><input name="username" type="text" id="yhm" value="${pagingBean.username }" /></td> --%>
	    <td>角色名：</td>
	    <td>
			<input type="text" name="roleName">
		</td>
	    <td>
	    	<input type="submit" value="查询"/>
	   	</td>
	    <td rowspan="3">
	    	<input type="button" value="添加新角色" onclick="toAdd()"/>
	   	</td>
	  </tr>
	</table>
</form>
<table class="result-table">
	<tr>
		<th width="10%">序号</th><th width="25%">用户角色</th><th width="23%">操作</th>
	</tr>
	<c:forEach items="${roles }" var="userBean" varStatus="status">
		<tr>
			<td>${status.index+1 }</td>
			<td style="padding:0 15px;text-align:left">${userBean.roleName }</td>
			<td>
				<a href="roleServlet?method=getRole&result=detail&id=${userBean.id }">查看</a>&nbsp;&nbsp;|&nbsp;
				<a href="roleServlet?method=getRole&result=edit&id=${userBean.id }">编辑</a>&nbsp;&nbsp;|&nbsp;
				<a href="javascript:del(${userBean.id })">删除</a>
			</td>
		</tr>
	</c:forEach>
	<tr>
		<td colspan="3">
			<u:page pagingBean="${sessionScope.pagingBean }" 
				preUrl="${pageContext.request.contextPath}/back/role/roleServlet?method=list&result=list" />
		</td>
	</tr>
	</table>
</body>
<script type="text/javascript">

	function toAdd(){
		location.href = "add_role.jsp";
	}
	function del(id){
		layer.alert("您确定要删除此角色吗?",{
			skin:'layui-layer-lan',
			btn:["确定"], 
			btn1:function(index,layero){
				layer.close(index);
				window.location.href="${pageContext.request.contextPath}/back/role/roleServlet?method=del&result=list&id="+id;
			}
		})
	}
</script>
<c:if test="${param.msg.equals('3') }">
	<script type="text/javascript">
	layer.alert("删除成功!",{
		skin:"layui-layer-lan",
		closeBtn:0
	})	
	</script>
</c:if>
<c:if test="${param.msg.equals('4') }">
	<script type="text/javascript">
	layer.alert("删除失败!",{
		skin:"layui-layer-lan",
		closeBtn:0
	})	
	</script>
</c:if>
<c:if test="${param.msg.equals('5') }">
	<script type="text/javascript">
	layer.alert("改角色下存在用户,不能删除",{
		skin:"layui-layer-lan",
		closeBtn:0
	})	
	</script>
</c:if>
<c:if test="${param.msg.equals('6') }">
	<script type="text/javascript">
	layer.alert("超级管理员角色不能删除",{
		skin:"layui-layer-lan",
		closeBtn:0
	})	
	</script>
</c:if>
</html>