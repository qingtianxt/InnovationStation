var ok = "";
$(document).ready(function() {
	$("#almc").blur(function() {
		var str = $("#almc").val();
		var id = $("#id").val();
		var params = "mc=" + str + "&method=checkXMgUpdate&id=" + id
		doAjax("cgalServlet", params, function(rstText) {
			var result = eval('(' + rstText + ')');
			if (result.status != 'OK') {
				layer.alert('此案例已经存在', {
					skin : 'layui-layer-lan' // 样式类名
					,
					closeBtn : 0
				});
				ok = "no";
				return;
			} else {
				ok = "ok";
				return;
			}
		});
		if (almc.length >= 30) {
			layer.alert('案例名称长度应在30以内', {
				skin : 'layui-layer-lan' // 样式类名
				,
				closeBtn : 0
			});
			return;
		}
	});
	$("#szd").blur(function() {
		var szd = $("#szd").val();
		if (szd.length >= 50) {
			layer.alert('所在地长度应在50以内', {
				skin : 'layui-layer-lan' // 样式类名
				,
				closeBtn : 0
			});
			return;
		}
	})
	$("#dw").blur(function() {
		var dw = $("#dw").val();
		if (dw.length >= 50) {
			layer.alert('案例名称长度应在50以内', {
				skin : 'layui-layer-lan' // 样式类名
				,
				closeBtn : 0
			});
			return;
		}
	})
	$("#gjc").blur(function() {
		var gjc = $("#gjc").val();
		if (gjc.length >= 50) {
			layer.alert('关键词长度应在50以内', {
				skin : 'layui-layer-lan' // 样式类名
				,
				closeBtn : 0
			});
			return;
		}
	})
	$("#upload").click(function() {
		var cgmc = jQuery("#almc").val();
		if (cgmc == "") {
			layer.alert('案例名称不能为空', {
				skin : 'layui-layer-lan' // 样式类名
				,
				closeBtn : 0
			});
			return;
		}
		if (ok == "no") {
			layer.alert('该案例已经存在', {
				skin : 'layui-layer-lan' // 样式类名
				,
				closeBtn : 0
			});
			return;
		}
		if (cgmc.length >= 30) {
			layer.alert('案例名称长度应在30以内', {
				skin : 'layui-layer-lan' // 样式类名
				,
				closeBtn : 0
			});
			return;
		}
		var szd = $("#szd").val();
		if (szd.length >= 50) {
			layer.alert('所在地长度应在50以内', {
				skin : 'layui-layer-lan' // 样式类名
				,
				closeBtn : 0
			});
			return;
		}

		var dw = $("#dw").val();
		if (dw.length >= 50) {
			layer.alert('案例名称长度应在50以内', {
				skin : 'layui-layer-lan' // 样式类名
				,
				closeBtn : 0
			});
			return;
		}
		if (dw == "") {
			layer.alert('单位名称是必填项', {
				skin : 'layui-layer-lan' // 样式类名
				,
				closeBtn : 0
			});
			return;
		}
		var gjc = $("#gjc").val();
		if (gjc.length >= 50) {
			layer.alert('关键词长度应在50以内', {
				skin : 'layui-layer-lan' // 样式类名
				,
				closeBtn : 0
			});
			return;
		}
		if (gjc == "") {
			layer.alert('关键词是必填项', {
				skin : 'layui-layer-lan' // 样式类名
				,
				closeBtn : 0
			});
			return;
		} else {
			layer.open({
				content : '确定提交？',
				btn : [ '确认', '取消' ],
				yes : function(index, layero) {
					$("#checkForm").submit();
				},
				btn2 : function(index, layero) {

				},
				cancel : function() {
					// 右上角关闭回调
				}
			});
		}
	})
});
function getXMLHttpResquest() {
	var request;
	if (window.XMLHttpRequest) {
		request = new XMLHttpRequest();
	} else {
		try {
			request = new ActiveXObject("Microsoft.XMLHTTP");
		} catch (e) {
			request = new ActiveXObject("Msxml2.XMLHTTP");
		}
	}
	return request;
}
function doAjax(url, params, callBack) {
	var req = getXMLHttpResquest();
	if (req != null) {
		req.onreadystatechange = function() {
			if (req.readyState == 4) {
				if (200 == req.status) {
					callBack(req.responseText);

				} else if (404 == req.status) {
					layer.alert('404-HTTP请求路径错误！', {
						skin : 'layui-layer-lan' // 样式类名
						,
						closeBtn : 0
					});
					return;
				} else if (500 == req.status) {
					layer.alert('500-HTTP请求路径错误！', {
						skin : 'layui-layer-lan' // 样式类名
						,
						closeBtn : 0
					});
					return;
				}
			}

		};
		req.open("POST", url, true);
		req.setRequestHeader("Content-Type",
				"application/x-www-form-urlencoded;;charset=utf-8");
		req.send(params);
	}

}
