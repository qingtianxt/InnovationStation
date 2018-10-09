<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="u" uri="http://localhost:8080/3-28/util"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/front.css">
<jsp:include page="links.jsp"></jsp:include>
<style type="text/css">
</style>
</head>
<body>
	<div class="all">
		<jsp:include
			page="${paggeContext.request.contextPath }/front/head.jsp"></jsp:include>
		<div class="content">
			<div class="display1" style="margin: auto; min-height: 500px">
			<form action="${pageContext.request.contextPath}/userServlet?method=register" method="post">
					<table id="datatable" style="margin:auto;background-color: #e5ecff;height: 50%;width:100%">
						<tr>
							<td align="right" style="height: 40px" width="32%">用户名：</td>
							<td align="left" width="22%"><input type="text"
								name="username" style="width: 200px" id="username" value="${param.username}"></td>
							<td id="user2" align="left"><font color="red">*</font>不能少于6个字符不能多于20</td>
						</tr>
						<tr>
							<td align="right" style="height: 40px">用户密码：</td>
							<td align="left"><input type="password" name="pwd"
								style="width: 200px" id="pwd"></td>
							<td id="pwd2" align="left"><font color="red">*</font>不能少于6个字符不能多于20</td>
						</tr>
						<tr>
							<td align="right" style="height: 40px">确认密码：</td>
							<td align="left"><input type="password" name="pwd2"
								style="width: 200px" id="rspwd"></td>
							<td id="rspwd2" align="left"></td>
						</tr>
						<tr>
							<td align="right" style="height: 40px">企业名称：</td>
							<td align="left"><input type="text" name="name" value="${param.name}"
								style="width: 200px" id="jgqc"></td>
							<td id="jgqc2" align="left"></td>
						</tr>
						<tr>
							<td align="right" style="height: 40px">企业地址：</td>
							<td align="left"><input type="text" style="width: 200px" value="${param.address }"
								name="address" id="txdz"></td>
							<td></td>
						</tr>
						<tr>
							<td align="right" style="height: 40px">联系方式：</td>
							<td align="left"><input type="text" style="width: 200px" value="${param.cellphone }"
								name="cellphone" id="yddh"></td>
							<td id=yddh2 align="left"></td>
						</tr>
						<tr>
							<td align="right" style="height: 40px">邮箱：</td>
							<td align="left"><input style="width: 200px" type="text" value="${param.email}"
								name="email" id="yx"></td>
							<td id=yx2 align="left"></td>
						</tr>
	
						<tr>
							<td align="right" style="height: 40px">验证码</td>
							<td align="left"><input type="text" style="width: 100px"
								name="validataCode" id="rand"> <font color="red">*</font> <img
								src="${pageContext.request.contextPath}/IdcodeServlet" id="shuaxin" onclick="getImage(this)"
								style="width: 60px; height: 30px;cursor:pointer;vertical-align: middle;"></td>
							<td></td>
						</tr>
	
						<tr>
							<td align="left" style="height: 40px"></td>
							<td align="left" width="22%"><input type="submit" id="zctj"
								style="background: #0078cb; width: 200px; height: 35px; color: white"
								value="立即注册"></td>
						</tr>
					</table>
			</form>
			</div>

		</div>

		<jsp:include
			page="${paggeContext.request.contextPath }/front/bottom.jsp"></jsp:include>
	</div>
</body>
<script type="text/javascript">
	function getImage(img){
		img.src = "${pageContext.request.contextPath}/IdcodeServlet?time="+new Date();
	}
	
	
	
	
	$.validator.addMethod("isCellphone", function(value, element) {
		var reg = /^[1][3458][0-9]{9}$/;
		return reg.test(value)||value=="";
	}, "请输入正确的手机号码");
	$.validator.addMethod("checkWords",function(value,element){
		var reg = /^[A-Za-z0-9\_]+$/;
		return reg.test(value)||value=="";
	},"只能包含字母数字下划线")
	$("form").validate({
		rules:{
			username:{required:true,rangelength:[6,25],checkWords:true,remote : {// 访问后台servlet验证用户名是否已经存在
				url : "${pageContext.request.contextPath}/front/user/userServlet",
				type:"GET",
				dataType : "json",
				data : { // 传递的数据
					username : function(){
						return $("#username").val();
					},
					method : "checkUsername"
				},
				dataFilter : function (data){// 访问后调用的方法
						return data=="true";
					}
				}},
			pwd:{required:true,rangelength:[6,25],checkWords:true},
			validataCode:"required",
			pwd2:{required:true,equalTo:"#pwd"},
			email:{email:true,maxlength:25},
			cellphone:"isCellphone",
			qydz:{maxlength:25},
			qymc:{maxlength:25}
		},messages:{
			username:{required:"请输入用户名",rangelength:"用户名不能少于6个字符不能多于25",remote:"该用户名以存在"},
			pwd:{required:"请输入密码",rangelength:"密码不能少于6个字符不能多于25"},
			validataCode:"请输入验证码",
			pwd2:{required:"请输入确认密码",equalTo:"两次密码输入不一致"},
			email:{email:"请输入正确的邮箱地址",maxlength:"邮箱长度不能超过25个字符"},
			qymc:{maxlength:"企业名称不能超过25个字符"},
			qydz:{maxlength:"企业地址不能超过25个字符"}
		},errorPlacement:function(error,element){
			error.css("color","red");
			element.parent().next("td").empty().append(error);
		}
	});
	
	var message = "${param.msg}";
	if(message!=""){
		layer.open({
			content:message,skin: 'layui-layer-lan',closeBtn: ["确定"],
			yes:function(index,layero){
				layer.close(index);
				if(message=="注册成功!")
					window.top.location.href = "${pageContext.request.contextPath}/front/index.jsp";
			}
		});
	}

</script>
</html>