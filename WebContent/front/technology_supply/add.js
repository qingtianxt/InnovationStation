/**
 * 
 */

var jslb = data.jslb;
var xs = data.xs;
// 加载技术类别下拉框
$.get(data.rootpath + "/back/selectionServlet", {
			method : "getJslbList",
			result : "json"
		}, function(res) {
			for (var i in res) {
				var $option = $("<option>");
				$option.append(res[i][1]);
				if (jslb == res[i][1])
					$option.attr("selected", "selected");
				$option.appendTo($("#ssgxjslb"));
			}
		}, "json");
// 加载技术体现形式下拉框
$.get(data.rootpath + "/back/selectionServlet", {
			method : "getJstxxsList",
			result : "json"
		}, function(res) {
			for (var i in res) {
				var $option = $("<option></option>");
				$option.attr("value", res[i][0]);
				$option.html(res[i][1]);
				if (xs == res[i][1])
					$option.attr("selected", "selected");
				$option.appendTo($("#jstxxs"));
			}
		}, "json");

var errorPrompt = null;
// 表单验证
$.validator.addMethod("year", function(value, element) {
			var reg = /^[12][0-9]{3}$/;
			return reg.exec(value) || value == "" || value == null;
		}, "年份格式不正确")
$.validator.addMethod("number", function(value, element) {
			var numberReg = /^[1][3458][0-9]{9}$/;
			return this.optional(element) || (numberReg.test(value));
		}, "请正确填写您的手机号码");
$("#form2").validate({
	rules : {
		mc : {
			required : true,
			maxlength : 50,
			remote : {
				url : global.rootpath + "/back/technology_supply/supplyServlet",
				dataType : "json",
				type : "GET",
				data : {
					name : function() {
						return $("#jsmc").val();
					},
					method : "checkName",
					result : "json"
				},
				dataFilter : function(res) {
					return res.toString() != "true"
							|| global.supply.mc == $("#jsmc").val();
				}
			}
		},
		djh : {
			maxlength : 10
		},
		nf : {
			year : true
		},
		dh : {
			number : true
		},
		gjc : {
			required : "required",
			maxlength : 25
		},
		djh : {
			maxlength : 10
		},
		lxr : {
			maxlength : 10
		},
		zlh : {
			maxlength : 10
		},
		dw : {
			maxlength : 50
		},
		dz : {
			maxlength : 50
		}
	},
	messages : {
		mc : {
			required : "请输入技术名称",
			remote : "改技术已经存在！",
			maxlength : "技术名称不能超过50个字符"
		},
		gjc : {
			required : "请输入关键词",
			maxlength : "关键词不能超过25个字符"
		},
		djh : {
			maxlength : "登记号不能超过10个字符"
		},
		lxr : {
			maxlength : "联系人不能超过10个字符"
		},
		zlh : {
			maxlength : '专利号不能超过10个字符'
		},
		dw : {
			maxlength : "技术供给单位不能超过50个字符"
		},
		dz : {
			maxlength : "通讯地址不能超过50个字符"
		}
	},
	errorPlacement : function(error, element) {
		if (!errorPrompt) {
			layer.open({
						content : error.html(),
						btn : ["确定"],
						skin : "layui-layer-lan",
						btn1 : function(index, layero) {
							layer.close(index);
							element.focus();
							isValidated = false;
						}
					});
			isValidated = true;
		}
	},
	onfocusout : false,
	onkeyup : false,
	onclick : false,
	submitHandler : function() {
		layer.open({
					content : "您确定要提交吗?",
					btn : ["确定", "取消"],
					skin : "layui-layer-lan",
					btn1 : function(index, layero) {
						layer.close(index);
						document.forms[0].submit();
					},
					btn2 : function(index, layero) {
						layer.close(index);
					}
				});
	}
});