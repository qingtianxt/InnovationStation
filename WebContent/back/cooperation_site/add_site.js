/**
 * 
 */

$(document).ready(function() {

	$("form").validate({
		rules : {
			name : {
				required : true,
				maxlength : 50,
				remote : {
					url : global.rootpath
							+ "/back/cooperation_site/coopSiteServlet",
					type : "post",
					dataType : "json",
					data : {
						name : function() {
							return $("#siteName").val()
						},
						method : "checkSiteName"
					},
					dataFilter : function(res) {
						return res.toString() == "true"
								|| global.site.title == $("#siteName").val();
					}
				}
			},
			link : {
				required : true,
				url : true
			}
		},
		messages : {
			name : {
				required : "请输入标题名称",
				maxlength : "标题名称需少于50个字符",
				remote : "该站点已存在"
			},
			link : {
				required : "请输入网址",
				url : "请输入正确的网址"
			}
		},
		errorPlacement : function(error, element) {
			element.parent().siblings().css("vertical-align", "top")
			error.css("color", "red").appendTo(element.parent());
		},
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
	if (global.msg == "1") {
		content = '添加成功！';
		layer.alert(content, {
			skin : 'layui-layer-lan' // 样式类名
				,
				closeBtn : 0
		});
	} else if (global.msg == "2") {
		content = "添加失败！";
		layer.alert(content, {
			skin : 'layui-layer-lan' // 样式类名
				,
				closeBtn : 0
		});
	}
});



