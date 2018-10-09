<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录系统</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.12.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.validate.js"></script>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/sl.css">
<style type="text/css">
	.form-table td{
		border:0px;
		padding-left:0;
		padding-right:0;
	}
	.input input{
		box-sizing: content-box;
	}
	.input,.label{
		vertical-align: center;
	}
	.label{
		text-align: right;
		padding-right: 10px;
	}
</style>
</head>
<body>
<div>
<form>
	<table class="form-table" style="border:0px;width:400px">
		<caption>用户登录</caption>
		<tr>
			<td class="label" style="width:20%" colspan="1"><label for="username">用户名</label></td>
			<td class="input" style="width:80%" colspan="2"><input name="username" id="username" type="text" value="${userBean.username}"></td>
		</tr>
		<tr>
			<td class="label" colspan="1"><label for="pwd">密码</label></td>
			<td class="input" colspan="2"><input type="password" name="pwd" id="pwd"></td>
		</tr>
		<tr>
			<td class="label"><label for="validateCode">验证码</label></td>
			<td class="input">
				<input id="validateCode" name="validateCode" type="text" value="">
			</td>
			<td>
				<img alt="" src="${pageContext.request.contextPath }/IdcodeServlet" onclick="getImage(this)" style="cursor:pointer;">
			</td>
		</tr>
		<tr>	
			<td></td>
			<td colspan="2" style="text-align:left">
				<input type="submit" value="提交" class="btn" style="width:90%;font-size: 18px">
			</td>
		</tr>
		<tr>
			<td></td><td><label><input type="checkbox" name="autoLogin" id="autoLogin" value="是">下次自动登录</label>
		</tr>
	</table>
</form>
</div>
<script type="text/javascript">
	function getImage(img){
		img.src = "${pageContext.request.contextPath}/IdcodeServlet?time="+new Date();
	}

	$("form").validate({
		rules:{
			username:{required:true},
			pwd:{required:true},
			validateCode:{required:true},
		},
		messages:{
			username:{required:"请输入用户名"},
			pwd:{required:"请输入密码"},
			validateCode:{required:"请输入验证码"}
		},
		errorPlacement:function(error,element){
			element.parent().append("<br>");
			error.css("color","red").appendTo(element.parent());
		},
		submitHandler:function(){
			var username = $("#username").val();
			var pwd = $("#pwd").val();
			var validateCode = $("#validateCode").val();
			var autoLogin = document.getElementById("autoLogin").checked ? "是":"否";
			$.post(
					"${pageContext.request.contextPath}/front/user/userServlet",
					{
						method : "login",
						result : "json",
						username : username,
						pwd : pwd,
						validateCode : validateCode,
						autoLogin : autoLogin
					}, function(response) {
						switch(response){
						case 0:
							window.top.location.href = "${pageContext.request.contextPath}/front/index.jsp";
							break;
						case 1:
							alert("验证码错误");
							break;
						case 2:
							alert("用户不存在");
							break;
						case 3:
							alert("密码错误！");
							break;
						default:
							alert("系统错误！")
						}
					}, "json");
		}
	});
</script>
</body>
</html>