/**
 * 
 */

var editor = new UE.ui.Editor();
editor.render("zlkjj");

var isPrompt = null;
$("form").validate({
	rules : {
		title : {
			required : true,
			maxlength : 25,
			remote : {
				url : global.rootpath + "/back/special_library/libraryServlet",
				type : "GET",
				dataType : "json",
				data : {
					title : function() {
						return $("#title").val()
					},
					method : "checkTitle",
					result : "json"
				},
				dataFilter : function(dataReturn) {
					return dataReturn == "true"
							|| global.library.title == $("#title").val();
				}
			}
		},
		publisher : {
			required : true,
			maxlength : 10
		},
		date : {
			required : true
		}
	},
	messages : {
		title : {
			required : "专题库名称不能为空",
			maxlength : "名称长度不能超过25个字符",
			remote : "该名称的专题库已经存在"
		},
		publisher : {
			required : "请输入发布人",
			maxlength : "发布人名称不能超过5个字符"
		},
		date : {
			required : "请选择发布日期"
		}
	},
	errorPlacement : function(error, element) {
		if (isPrompt == null) {

			layer.open({
						content : error.html(),
						btn : ["确定"],
						skin : "layui-layer-lan",
						btn1 : function(index, layero) {
							layer.close(index);
							element.focus();
							isPrompt = null;
						}
					});
			isPrompt = error.html();
		}

		return false;
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
						$("form")[0].submit();
					},
					btn2 : function(index, layero) {
						layer.close(index);
					}
				});
	}
})