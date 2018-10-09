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
</head>
<body>
<div align="center" style="background: #C0E4FA;position: relative;">
欢迎来到河北省创新驿站协同工作平台管理系统
</div>
<br>
<form action="../role/roleServlet?method=pageList&result=list" method="post">
	<table class="query-table">
	  <tr>
	    <td>用户名：</td>
	    <td><input name="username" type="text" id="yhm" value="${pagingBean.username }" /></td>
	    <td>角色名：</td>
	    <td>
			<select  name="roleId" id="jsm" style="width:150px" >
	              <option value="">请选择</option>
	        </select>
		</td>
	    <td>
	    	<input type="submit" value="查询"/>
	   	</td>
	    <td rowspan="3">
	    	<input type="button" value="添加新角色" onclick="toAdd()"/>
	    	<input type="button" value="角色权限管理" onclick="manage()"/>
	   	</td>
	  </tr>
	</table>
</form>
<table class="result-table">
	<tr>
		<th width="5%">序号</th><th width="20%">用户名</th><th width="20%">用户角色</th><th width="13%">操作</th>
	</tr>
	<c:forEach items="${userBeans }" var="userBean" varStatus="status">
		<tr>
			<td>${status.index+1 }</td>
			<td style="padding-left: 5px;text-align:left">${userBean.username }</td>
			<td style="padding-left: 5px;text-align:left">${userBean.role.roleName }</td>
			<td><a href="roleServlet?method=getRole&result=detail&id=${userBean.role.id }">查看</a></td>
		</tr>
	</c:forEach>
	<tr>
		<td colspan="4"><u:page pagingBean="${sessionScope.pagingBean }"/></td>
	</tr>
	</table>
</body>
<script type="text/javascript">
	var x = "${pagingBean.roleId}";
	$.get("${pageContext.request.contextPath}/back/role/roleServlet", {
		method : "list",
		result : "json"
	}, function(res) {
		for(var i in res){
			var $option = $("<option></option>");
			$option.attr("value",res[i]['id']);
			$option.html(res[i]['roleName']);
			if(x!=""&&x==res[i]['id'])
				$option.attr("selected","selected");
			$option.appendTo($("#jsm"));
		}
	}, "json");
	
	function toAdd(){
		location.href = "add_role.jsp";
	}
	function manage(){
		location.href = "${pageContext.request.contextPath}/back/role/manage.jsp";
	}
</script>
</html>