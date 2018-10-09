<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="top_login">
  <div class="login_in">
	<div align="center">
		<form id="form1" method="post" action="${pageContext.request.contextPath}/userServlet?method=login">
			<label>用户名： <input id="username" name="username" type="text" style="width: 80px"></label>
			<label>密码： <input id="password" name="password" type="password" style="width: 80px"></label>
			<label>验证码： <input id="randcode" name="validateCode" type="text" style="width: 40px"> </label> 
				<img src="${pageContext.request.contextPath}/IdcodeServlet" id="shuaxin" style="width: 40px; height: 20px;cursor: pointer;">
			<input name="login" id="login" type="submit" value="登录" style="background: #214278; width: 60px; color: white">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input onClick="window.location='${pageContext.request.contextPath}/front/register.jsp'" type="button" name="zhuce" id="zhuce" value="注册"
				style="background: #214278; width: 60px; color: white">
		</form>
	</div>
  </div>
</div>
<script>
	var message = "${param.msg}";
	if(message!=""){
		layer.open({
			content:message,skin: 'layui-layer-lan',closeBtn: 0
		});
	}
	document.getElementById("shuaxin").onclick = function(){
		this.src = "${pageContext.request.contextPath}/IdcodeServlet?time="+new Date();
	}
	
	
	$.validator.addMethod("isValidateName",function(value,element){
		var reg = /^[A-Za-z0-9\_]+$/;
		return reg.test(value)||value=="";
	},"用户名只能包含字母数字下划线");
	$("#form1").validate({
		rules:{
			validateCode:{required:true},
			password:{required:true,rangelength:[6,16]},
			username:{required:true,rangelength:[6,16],isValidateName:true}
		},
		messages:{
			username:{required:"请输入用户名!",rangelength:"用户名因包含6-16位"},
			password:{required:"请输入密码!",rangelength:"密码因包含6-16位"},
			validateCode:{required:"请输入验证码!"}
		},
		errorPlacement:function(error,element){
			error.css("color","red");
			layer.alert(error.html(), {
				  skin: 'layui-layer-lan' //样式类名
				  ,closeBtn: 0,offset:['200px','400px']
				});
			element.val("");
			/*layer.msg(error.html())*/
			return false;
		},onclick:false,onkeyup:false,onfocusout:false,
		submiHandler:function(){
			$("form").submit();/*
			$.post("${pageContext.request.contextPath}/userServlet", {
					method : "login",
					username : $("#username").val(),
					password : $("#password").val(),
					validateCode : $("#randcode").val()
				}, function(data) {
					if(data=="success"){
						layer.alert( $("#username").val()+', 您好！欢迎来到创新驿站个人工作平台！', {
							  skin: 'layui-layer-lan' //样式类名
							  ,closeBtn: 0
							});
						location.reload();
					}else{
						layer.alert(data, {
							  skin: 'layui-layer-lan' //样式类名
							  ,closeBtn: 0
							});
					}
				});*/
		}
	})
</script>


    