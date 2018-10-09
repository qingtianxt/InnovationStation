var ok = "";
$(document).ready(
		function() {
			$("#zcmc").blur(function() {
				var str = $("#zcmc").val();
				var params = "method=checkMc&zcmc=" + str;
				doAjax("zcfgServlet", params, function(rstText) {
					var result = eval('(' + rstText + ')');
					if (result.status != 'OK') {
						layer.alert('政策已经存在', {
							skin : 'layui-layer-lan' // 样式类名
							,
							closeBtn : 0
						});
						ok = "no";
					} else {
						0
						ok = "ok";
					}
				});
			});
			$("#zcmc").blur(function() {
				var str = $("#zcmc").val();
				if (str.length >= 50) {
					layer.alert('请将名称长度限制在50字之内', {
						skin : 'layui-layer-lan' // 样式类名
						,
						closeBtn : 0
					});
					return;
				}
			});

			
			$("#zcwh").blur(function() {
				var str = $("#zcwh").val();
				if (str.length >= 25) {
					layer.alert('请将政策文号的长度限制在25字之内', {
						skin : 'layui-layer-lan' // 样式类名
						,
						closeBtn : 0
					});
					return;
				}
			});

			$("#zdjg").blur(function() {
				var str = $("#zdjg").val();
				if (str.length >= 50) {
					layer.alert('请将机关名称长度限制在50字之内', {
						skin : 'layui-layer-lan' // 样式类名
						,
						closeBtn : 0
					});
					return;
				}
			});

			$("#sxfw").blur(function() {
				var str = $("#sxfw").val();
				if (str.length >= 50) {
					layer.alert('请将施行范围长度限制在50字之内', {
						skin : 'layui-layer-lan' // 样式类名
						,
						closeBtn : 0
					});
					return;
				}
			});
			$("#ztc").blur(function() {
				var str = $("#ztc").val();
				if (str.length >= 25) {
					layer.alert('请将主题词长度限制在25字之内', {
						skin : 'layui-layer-lan' // 样式类名
						,
						closeBtn : 0
					});
					return;
				}
			});

			$("#gjz").blur(function() {
				var str = $("#gjz").val();
				if (str.length >= 25) {
					layer.alert('请将关键字长度限制在25字之内', {
						skin : 'layui-layer-lan' // 样式类名
						,
						closeBtn : 0
					});
					return;
				}
			});

			$("#sb").click(
					function() {
						var zcmc = $("#zcmc").val();
						if (zcmc == "") {
							layer.alert('政策名称不能为空', {
								skin : 'layui-layer-lan' // 样式类名
								,
								closeBtn : 0
							});
							return ;
						}
						if (zcmc.length >= 50) {
							layer.alert('请将名称长度限制在50字之内', {
								skin : 'layui-layer-lan' // 样式类名
								,
								closeBtn : 0
							});
							return;
						}
						if(ok=="no"){
							layer.alert('该名称已存在', {
								skin : 'layui-layer-lan' // 样式类名
								,
								closeBtn : 0
							});
							return;
						}
						var time1 = $("#gbrq").val();
						var time2 = $("#sxrq").val();
						if (time1 == "") {
							layer.alert('公布时间不能为空', {
								skin : 'layui-layer-lan' // 样式类名
								,
								closeBtn : 0
							});
							return ;
						}
						if (time1 > time2&&time2!="") {
							layer.alert('公布日期不能大于施行日期', {
								skin : 'layui-layer-lan' // 样式类名
								,
								closeBtn : 0
							});
							return;
						}
						
						var str = $("#zcwh").val();
						if (str.length >= 25) {
							layer.alert('请将政策文号的长度限制在25字之内', {
								skin : 'layui-layer-lan' // 样式类名
								,
								closeBtn : 0
							});
							return;
						}
						if (str == "") {
							layer.alert('政策文号不能为空', {
								skin : 'layui-layer-lan' // 样式类名
								,
								closeBtn : 0
							});
							return ;
						}
						var str = $("#zdjg").val();
						if (str.length >= 50) {
							layer.alert('请将机关名称长度限制在50字之内', {
								skin : 'layui-layer-lan' // 样式类名
								,
								closeBtn : 0
							});
							return;
						}
						var str = $("#sxfw").val();
						if (str.length >= 50) {
							layer.alert('请将施行范围长度限制在50字之内', {
								skin : 'layui-layer-lan' // 样式类名
								,
								closeBtn : 0
							});
							return;
						}
						var str = $("#ztc").val();
						if (str.length >= 25) {
							layer.alert('请将主题词长度限制在25字之内', {
								skin : 'layui-layer-lan' // 样式类名
								,
								closeBtn : 0
							});
							return;
						}
						if (str == "") {
							layer.alert('主题词不能为空', {
								skin : 'layui-layer-lan' // 样式类名
								,
								closeBtn : 0
							});
							return ;
						}
						var str = $("#gjz").val();
						if (str.length >= 25) {
							layer.alert('请将关键字长度限制在25字之内', {
								skin : 'layui-layer-lan' // 样式类名
								,
								closeBtn : 0
							});
							return;
						}

						var zyzddx1=document.getElementsByName('ttzlymc');
						var zyzddx = "";
						for (var i = 0; i < zyzddx1.length; i++) {
							if (zyzddx1[i].checked) {
								if (zyzddx == "") {
									zyzddx = zyzddx + i;
								} else {
									zyzddx = zyzddx + "," + i;
								}
							}
						}
						if (zyzddx == "") {
							layer.alert('主要针对对象至少勾选一项', {
								skin : 'layui-layer-lan' // 样式类名
								,
								closeBtn : 0
							});
							return;
						}

						else {
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

					});

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
