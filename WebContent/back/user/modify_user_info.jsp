<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改用户信息</title>
<script type="text/javascript" src="/InnovationStation/js/jquery-1.12.1.js"></script>
<script type="text/javascript" src="/InnovationStation/js/jquery.validate.js"></script>
<link type="text/css" rel="stylesheet" href="/InnovationStation/css/sl.css">
<link type="text/css" rel="stylesheet" href="/InnovationStation/css/lhgcalendar.css">
<script type="text/javascript" src="/InnovationStation/js/lhgcore.js"></script>
<script type="text/javascript" src="/InnovationStation/js/lhgcalendar.js"></script>
<link rel="stylesheet" type="text/css" href="/InnovationStation/css/sl.css">
<style>
	
</style>
</head>
<body bgcolor="#DDF2FC">
	<div class="" align="center">
		<h1>修改用户信息</h1>
		<table style="width:800px">
		  <tr>
		    <td width="150">用户名</td>
		    <td width="700">
		    	<input disabled="disabled" value="songlin" id="username" name="username" type="text" />
		    	<input type="hidden" id="id" name="id" value="${requestScope.userBean.id }">
		    </td>
	      </tr>
		  <tr>
		    <td>企业名称</td>
		    <td><input value="${requestScope.userBean.name }" id="qymc" name="name" type="text" /></td>
	      </tr>
		  <tr>
		    <td>企业地址</td>
		    <td><input value="${requestScope.userBean.address }" id="qydz" name="address" type="text" /></td>
	      </tr>
		  <tr>
		    <td>联系方式</td>
		    <td><input value="${requestScope.userBean.cellphone }" id="lxfs" name="cellphone" type="text" /></td>
	      </tr>
		  <tr>
		    <td>邮箱</td>
		    <td><input value="${requestScope.userBean.email }" id="yx" name="email" type="text"/></td>
	      </tr>
	      
		  <tr>
		    <td>角色</td>
		    <td>
		    	<select name="roleId" id="role" class="fenlei">
		    	</select>
	    	</td>
	      </tr>
	  </table>
		<br><br><br><br>
		<div align="center">
			<input type="submit" value="保存" style="hight: 80px; width: 100px">
		</div>

	</div>
	<br><br><br><br>
</body>
<c:if test="${param.result.equals('sh') }">
<script type="text/javascript">
	$("input[type!='submit']").attr("readonly","readonly")
</script>
</c:if>
</html>