/**
 * 
 */

$(function() {
	$.get(global.rootpath + "/back/role/roleServlet", {
				method : "list",
				result : "json"
			}, function(res) {
				for (var i in res) {
					var x = global.user.userId;
					var $option = $("<option></option>");
					$option.attr("value", res[i]['id']);
					$option.html(res[i]['roleName']);
					if (x == res[i]['id'])
						$option.attr("selected", "selected");
					$option.appendTo($("#jsm"));
				}
			}, "json");

	$.validator.addMethod("isCellphone", function(value, element) {
				var reg = /^[1][3458][0-9]{9}$/;
				return reg.test(value) || value == "";
			}, "请输入正确的手机号码");
	$.validator.addMethod("isValidateName", function(value, element) {
				var reg = /^[A-Za-z0-9\_]+$/;
				return reg.test(value) || value == "";
			}, "用户名只能包含字母数字下划线")
	$("form").validate({
		rules : {
			username : {
				required : true,
				isValidateName : true,
				rangelength : [6, 25],
				remote : {// 访问后台servlet验证用户名是否已经存在
					url : global.rootpath + "/back/user/userServlet",
					type : "GET",
					dataType : "json",
					data : { // 传递的数据
						username : function() {
							return $("#username").val();
						},
						method : "checkUsername"
					},
					dataFilter : function(data) {// 访问后调用的方法
						return data == "true"
								|| global.user.username == $("#username").val();
					}
				}
			},
			pwd : {
				required : true,
				rangelength : [6, 25]
			},
			confirmPwd : {
				required : true,
				equalTo : "#password"
			},
			cellphone : {
				isCellphone : true
			},
			email : {
				email : true,
				maxlength : 25
			},
			cellphone : "isCellphone",
			address : {
				maxlength : 25
			},
			name : {
				maxlength : 25
			}
		},
		messages : {
			username : {
				required : "请输入用户名",
				rangelength : "用户名不能少于6个字符不能多于25",
				remote : "该用户名以存在"
			},
			pwd : {
				required : "请输入密码",
				rangelength : "密码不能少于6个字符不能多于25"
			},
			validataCode : "请输入验证码",
			pwd2 : {
				required : "请输入确认密码",
				equalTo : "两次密码输入不一致"
			},
			email : {
				email : "请输入正确的邮箱地址",
				maxlength : "邮箱长度不能超过25个字符"
			},
			name : {
				maxlength : "企业名称不能超过25个字符"
			},
			address : {
				maxlength : "企业地址不能超过25个字符"
			}
		},
		errorPlacement : function(error, element) {

			error.css("color", "red").appendTo(element.parent());
		},
		submitHandler : function() {
			layer.open({
						content : "您确定要提交吗?",
						btn : ["确定", "取消"],
						skin : "layui-layer-lan",
						btn1 : function(index, layero) {
							layer.close(index);
							$("form")[0].submit();
						},
						btn2 : function(index, layero) {
							layer.close(index);
						}
					});
		}
	})

	if (global.msg == "1") {
		layer.open({
					content : "添加成功",
					btn : ["确定"],
					skin : "layui-layer-lan",
					btn1 : function(index, layero) {
						layer.close(index);
						element.focus();
						isPrompt = null;
					}
				});
	} else if (global.msg == "2") {
		layer.open({
					content : "添加失败",
					btn : ["确定"],
					skin : "layui-layer-lan",
					btn1 : function(index, layero) {
						layer.close(index);
						element.focus();
						isPrompt = null;
					}
				});
	}
})
function back() {
	var url = global.rootpath
			+ "/back/user/userServlet?method=list&result=list&msg=7";
	location.href = url;
}