<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加用户</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.12.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.validate.js"></script>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/sl.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/lhgcalendar.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/lhgcore.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/lhgcalendar.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/sl.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/layer/layer.js"></script>
<style>
	td.label{
		text-align:right;
	}
	td.label:AFTER {
	content: ":";
	}
	#no-table{
		border: 0px;
	}
	#no-table td{
		border: 0px;
	}
</style>
</head>
<body bgcolor="#DDF2FC">
<div class="nav">
	您现在的位置：
	<ul class="nav-ul">
		<li class="nav-li"><a href="#">用户管理</a></li>
		<li class="nav-li"><a href="javascript:back()">用户列表</a></li>
		<li class="nav-li"><a href="#">编辑用户信息</a></li>
	</ul>
	</div>
	<div class="" align="center">
		<h1>编辑用户信息</h1>
<%-- 		<c:if test="${param.msg.equals('1') }"><div class="alert">添加成功</div></c:if> --%>
<%-- 		<c:if test="${param.msg.equals('2') }"><div class="alert">添加失败</div></c:if> --%>
	<form action="${pageContext.request.contextPath}/back/user/userServlet" method="post">
		<input type="hidden" value="add" name="method">
		<c:if test="${empty requestScope.userBean }"><input type="hidden" value="add" name="result"></c:if>
		<c:if test="${!empty requestScope.userBean }">
			<input type="hidden" value="list" name="result">
			<input type="hidden" value="${requestScope.userBean.id }" name="id">
		</c:if>
		
		<table style="width:600px;" class="table" id="no-table">
		  <tr>
		    <td width="150" class="label">用户名</td>
		    <td width="500" class="input">
		    	<input id="username" name="username" type="text" value="${requestScope.userBean.username }" autofocus="autofocus" <c:if test="${!empty requestScope.userBean }">readonly="readonly"</c:if> />
		    </td>
	      </tr>
	      <c:if test="${empty requestScope.userBean }">
	      <tr>
		    <td class="label">密码</td>
		    <td class="input">
		    	<input id="password" name="pwd" type="password" value="${requestScope.userBean.pwd }" />
		    </td>
	      </tr>
	      <tr>
		    <td class="label">确认密码 </td>
		    <td class="input">
		    	<input id="confiremPwd" name="confirmPwd" type="password" value="${requestScope.userBean.pwd }" />
		    </td>
	      </tr>
	      </c:if>
		  <tr>
		    <td class="label"> 企业名称 </td>
		    <td class="input"><input id="qymc" name="name" type="text" value="${requestScope.userBean.name }" /></td>
	      </tr>
		  <tr>
		    <td class="label"> 企业地址 </td>
		    <td class="input"><input id="qydz" name="address" type="text" value="${requestScope.userBean.address }" /></td>
	      </tr>
		  <tr>
		    <td class="label"> 联系方式 </td>
		    <td class="input"><input id="lxfs" name="cellphone" type="text" value="${requestScope.userBean.cellphone }" /></td>
	      </tr>
		  <tr>
		    <td class="label"> 邮箱 </td>
		    <td class="input"><input id="yx" name="email" type="email" value="${requestScope.userBean.email }" /></td>
	      </tr>
	      
		  <tr>
		    <td class="label">角色</td>
		    <td class="input">
		    	<select name="roleId" id="jsm" class="fenlei">
		    	</select>
	    	</td>
	      </tr>
	  </table>
		<br><br>
		<div align="center">
			<input type="submit" value="保存" style="hight: 80px; width: 100px">
		</div>
	</form>		

	</div>
	<br><br><br><br>
</body>
<script type="text/javascript">
	var global = {
			rootpath:"${pageContext.request.contextPath}",
			user:{
				username:"${requestScope.userBean.username}",
				userId : "${requestScope.userBean.id}"
			},
			msg:"${param.msg}"
	}
</script>
<script type="text/javascript" src="add_user.js"></script>
</html>