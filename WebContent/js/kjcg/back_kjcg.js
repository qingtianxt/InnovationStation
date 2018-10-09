var ok = "";
$(document).ready(
		function() {
			// 填表单时需要判断的字段
			$("#cgmc").blur(function() {
				var str = $("#cgmc").val();
				var params = "mc=" + str + "&method=checkXMc"
				doAjax("cgzhxmServlet", params, function(rstText) {
					var result = eval('(' + rstText + ')');
					if (result.status != 'OK') {
						layer.alert('成果已经存在', {
							skin : 'layui-layer-lan' // 样式类名
							,
							closeBtn : 0
						});
						ok = "no";
					} else {
						ok = "ok";
					}
				});
			});
			$("#cgmc").blur(function() {
				var cgmc = $("#cgmc").val();
				if (cgmc.length >= 30) {
					layer.alert('成果名称应限制在30字以内', {
						skin : 'layui-layer-lan' // 样式类名
						,
						closeBtn : 0
					});
					return;
				}
			});
			$("#pzdjh").blur(function() {
				var pzdjh = $("#pzdjh").val();
				if (pzdjh.length >= 10) {
					layer.alert('批准登记号应限制在10字以内', {
						skin : 'layui-layer-lan' // 样式类名
						,
						closeBtn : 0
					});
					return;
				}
			});
			$("#cgssdw").blur(function() {
				var cgssdw = $("#cgssdw").val();
				if (cgssdw.length >= 50) {
					layer.alert('成果所属单位名称应限制在50字以内', {
						skin : 'layui-layer-lan' // 样式类名
						,
						closeBtn : 0
					});
					return;
				}
			});

			$("#txdz").blur(function() {
				var txdz = $("#txdz").val();
				if (txdz.length >= 50) {
					layer.alert('通讯地址应限制在50字以内', {
						skin : 'layui-layer-lan' // 样式类名
						,
						closeBtn : 0
					});
					return;
				}

			});
			$("#hxzl").blur(function() {
				var hxzl = $("#hxzl").val();
				if (hxzl.length >= 10) {
					layer.alert('核心专利应限制在10字以内', {
						skin : 'layui-layer-lan' // 样式类名
						,
						closeBtn : 0
					});
					return;
				}
			});
			$("#lxr").blur(function() {
				var lxr = $("#lxr").val();
				if (lxr.length >= 10) {
					layer.alert('联系人应限制在10字以内', {
						skin : 'layui-layer-lan' // 样式类名
						,
						closeBtn : 0
					});
				}
			});

			$("#lxdh").blur(
					function() {
						var lxdh = $("#lxdh").val();
						if (lxdh != "") {
							if (!/^\d{3,4}\-\d{7,8}$/.test(lxdh)
									&& !(/^1(3|4|5|7|8)\d{9}$/.test(lxdh))) {
								layer.alert('联系电话输入格式不正确', {
									skin : 'layui-layer-lan' // 样式类名
									,
									closeBtn : 0
								});
								return;
							}
						}

					});

			$("#nf").blur(function() {
				var nf = $("#nf").val();
				var zz = /^[0-9]*$/;
				if (nf != "") {
					if (nf.length != 4 || !zz.test(nf)) {
						layer.alert('年份输入格式不正确', {
							skin : 'layui-layer-lan' // 样式类名
							,
							closeBtn : 0
						});
						return;
					}
				}

			});

			$("#gjc").blur(function() {
				var gjc = $("#gjc").val();
				if (gjc.length >= 30) {
					layer.alert('关键词长度应该在30字以内', {
						skin : 'layui-layer-lan' // 样式类名
						,
						closeBtn : 0
					});
				}
			});
			$("#jj").blur(function() {
				var jj = $("#jj").val();
				if (jj.length >= 10000) {
					layer.alert('个人简介长度应该在10000字以内', {
						skin : 'layui-layer-lan' // 样式类名
						,
						closeBtn : 0
					});
				}
			});
			// 提交时的验证
			$("#upload").click(
					function() {
						var cgmc = jQuery("#cgmc").val();
						if (cgmc == "") {
							layer.alert('成果名称不能为空', {
								skin : 'layui-layer-lan' // 样式类名
								,
								closeBtn : 0
							});
							return;
						}
						if (ok == "no") {
							layer.alert('该成果已存在', {
								skin : 'layui-layer-lan' // 样式类名
								,
								closeBtn : 0
							});
							return;
						}
						if (cgmc.length >= 30) {
							layer.alert('成果名称应限制在30字以内', {
								skin : 'layui-layer-lan' // 样式类名
								,
								closeBtn : 0
							});
							return;
						}

						var pzdjh = $("#pzdjh").val();
						if (pzdjh.length >= 10) {
							layer.alert('批准登记号应限制在10字以内', {
								skin : 'layui-layer-lan' // 样式类名
								,
								closeBtn : 0
							});
							return;
						}
						if (pzdjh == "") {
							layer.alert('批准登记号是必填项', {
								skin : 'layui-layer-lan' // 样式类名
								,
								closeBtn : 0
							});
							return;
						}

						var cgssdw = $("#cgssdw").val();
						if (cgssdw.length >= 50) {
							layer.alert('成果所属单位名称应限制在50字以内', {
								skin : 'layui-layer-lan' // 样式类名
								,
								closeBtn : 0
							});
							return;
						}
						if (cgssdw == "") {
							layer.alert('成果所属单位名称是必填项', {
								skin : 'layui-layer-lan' // 样式类名
								,
								closeBtn : 0
							});
							return;
						}
						var txdz = $("#txdz").val();
						if (txdz.length >= 50) {
							layer.alert('通讯地址应限制在50字以内', {
								skin : 'layui-layer-lan' // 样式类名
								,
								closeBtn : 0
							});
							return;
						}
						if (txdz == "") {
							layer.alert('通讯地址是必填项', {
								skin : 'layui-layer-lan' // 样式类名
								,
								closeBtn : 0
							});
							return;
						}
						var cgtxxs1 = document.getElementById("cgtxxs")
								.getElementsByTagName("input");
						var cgtxxs = "";
						for (var i = 0; i < 14; i++) {
							if (cgtxxs1[i].checked) {
								if (cgtxxs == "") {
									cgtxxs = cgtxxs + i;
								} else {
									cgtxxs = cgtxxs + "," + i;
								}
							}
						}
						if (cgtxxs == "") {
							layer.alert('成果体现形式不能为空', {
								skin : 'layui-layer-lan' // 样式类名
								,
								closeBtn : 0
							});
							return;
						}

						var djrq = $("#djrq").val();
						if (djrq == "") {
							layer.alert('登记日期是必填项', {
								skin : 'layui-layer-lan' // 样式类名
								,
								closeBtn : 0
							});
							return;
						}

						var hxzl = $("#hxzl").val();
						if (hxzl.length >= 10) {
							layer.alert('核心专利应限制在10字以内', {
								skin : 'layui-layer-lan' // 样式类名
								,
								closeBtn : 0
							});
							return;
						}

						var jsssly1 = document.getElementById("jsssly")
								.getElementsByTagName("input");
						var jsssly = "";
						for (var i = 0; i < 22; i++) {
							if (jsssly1[i].checked) {
								if (jsssly == "") {
									jsssly = jsssly + i;
								} else {
									jsssly = jsssly + "," + i;
								}
							}
						}
						if (jsssly == "") {
							layer.alert('技术所属领域是必填项', {
								skin : 'layui-layer-lan' // 样式类名
								,
								closeBtn : 0
							});
							return;
						}

						var lxr = $("#lxr").val();
						if (lxr.length >= 10) {
							layer.alert('联系人应限制在10字以内', {
								skin : 'layui-layer-lan' // 样式类名
								,
								closeBtn : 0
							});
							return;
						}
						var lxdh = $("#lxdh").val();
						if (lxdh != "") {
							if (!/^\d{3,4}\-\d{7,8}$/.test(lxdh)
									&& !(/^1(3|4|5|7|8)\d{9}$/.test(lxdh))) {
								layer.alert('联系电话输入格式不正确', {
									skin : 'layui-layer-lan' // 样式类名
									,
									closeBtn : 0
								});
								return;
							}
						}

						var nf = $("#nf").val();
						var zz = /^[0-9]*$/;
						if (nf != "") {
							if (nf.length != 4 || !zz.test(nf)) {
								layer.alert('年份输入格式不正确', {
									skin : 'layui-layer-lan' // 样式类名
									,
									closeBtn : 0
								});
								return;
							}
						}

						var selectgm1 = jQuery("#selectGM1").val();
						var selectgm2 = jQuery("#selectGM2").val();
						var selectgm3 = jQuery("#selectGM3").val();
						if (selectgm1 == "请选择") {
							layer.alert('成果应用行业为必填项！', {
								skin : 'layui-layer-lan' // 样式类名
								,
								closeBtn : 0
							});
							return;
						}
						var gjc = $("#gjc").val();
						if (gjc.length >= 30) {
							layer.alert('关键词长度应该在30字以内', {
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
