<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改密码</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.12.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.validate.js"></script>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/sl.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/layer/layer.js"></script>
<style>
	input{
		width:100%;
		padding:3px;
		box-sizing: border-box;
	}
	.no-border{
		border: 0px;
	}
	.no-border td{
		border: 0px;
	}
</style>
</head>
<body bgcolor="#DDF2FC">
<div class="nav">
	您现在的位置：
	<ul class="nav-ul">
		<li class="nav-li"><a href="#">用户管理</a></li>
		<li class="nav-li"><a href="#">修改密码</a></li>
	</ul>
	</div>
	<div class="table" align="center">
		<h1>修改密码</h1>
		<form action="${pageContext.request.contextPath}/back/user/userServlet?method=modify&result=json" method="post">
				<table class="no-border" style="width:400">
				  <tr>
				    <td width="65"><div align="right">原密码</div></td>
				    <td width="335" colspan="2">
				    	<input id="oldpwd" name="oldpwd" type="password" autofocus="autofocus" />
				    </td>
			      </tr>
				  <tr>
				    <td><div align="right">新密码</div></td>
				    <td colspan="2"><input id="newpwd" name="newpwd" type="password" /></td>
			      </tr>
			      <tr>
				    <td><div align="right">确认密码</div></td>
				    <td colspan="2"><input id="confirmpwd" name="confirmpwd" type="password" /></td>
			      </tr>
			      <tr>
				    <td><div align="right">验证码</div></td>
				    <td>
				    	<input id="rand" name="rand" type="text" /></td>
				    <td>
				    	<img src="${pageContext.request.contextPath }/IdcodeServlet" id="shuaxin" onclick="getImage(this)" style="margin:0;width:70px;height:30px;cursor:pointer;">
			        </td>
			      </tr>
			  </table>
				<br><br><br><br>
				<div align="center">
					<input type="submit" id="xgmm" value="保存" style="hight: 80px; width: 100px;cursor:pointer;">
				</div>
		</form>

	</div>
	<br><br><br><br>
	<script type="text/javascript">
		// 点击验证码的时候重新获取验证码
		function getImage(obj){
			var url = "${pageContext.request.contextPath }/IdcodeServlet?time="+new Date();
			obj.src = url;
		}
		
		// 提交表单
		function subData(){
			
			$.post("${pageContext.request.contextPath}/back/user/userServlet", {
					method : "modify",
					result : "json",
					oldpwd : $("#oldpwd").val(),
					newpwd : $("#newpwd").val(),
					validateCode : $("#rand").val()
				}, function(response) {
					
					var msg = "";
					if(response+""=="3")
						msg = "修改成功";
					else if(response+""=="1")
						msg = "验证码错误";
					else if(response+""==2)
						msg = "密码错误";
					else
						msg = "登录超时";
					layer.open({
						content:msg,btn:["确定"],
						skin:'layui-layer-lan',
						btn1:function(index,layero){
							layer.close(index);
							window.location.reload();
						}
					});
				}, "json");
		}
		
		var isPrompt = null;
		
		$.validator.addMethod("notEqualTo",function(value,element,params){
			return value != $(params).val();
		},"新密码不能与原密码相同");
		
		
		// 验证表单
		$("form").validate({
			submitHandler : function(){
				layer.open({
					content:"确定提交吗?",
					btn:["确定","取消"],
					btn1:function(index,layero){
						subData();
						layer.close(index);
					},
					btn2:function(index,layer0){
						layer.close(index);
					}
				})
			},
			rules : {
				oldpwd : {
					required : true
				},
				newpwd : {
					required : true,
					rangelength : [ 6, 16 ],
					notEqualTo:"#oldpwd"
				},
				confirmpwd : {
					required : true,
					equalTo : "#newpwd"
				},
				rand : {
					required : true
				}
			},
			messages : {
				oldpwd : {
					required : "请输入原密码"
				},
				newpwd : {
					required : "请输入新密码",
					rangelength : "6-16位"
				},
				confirmpwd : {
					required : "请输入确认密码",
					equalTo : "两次密码输入不一致"
				},
				rand : {
					required : "请输入验证码"
				}
			},
			errorPlacement:function(error,element){
				if(isPrompt==null){
					layer.open({
						content:error.html(),
						btn:["确定"],
						skin:"layui-layer-lan",
						btn1:function(index,layero){
							layer.close(index);
							element.focus();
							isPrompt = null;
						}
					});						
					isPrompt = error.html();
				}
				
				return false;
			},onfocusout:false,onkeyup:false,onclick:false
		});
	</script>
</body>
</html>