var ok = "";
$(document)
		.ready(
				function() {
					var user = $("#user").val();
					if (user == null || user == "") {
						layer.alert('你还没有登录，请先登录', {
							skin : 'layui-layer-lan' // 样式类名
							,
							closeBtn : 0
						});
					}

					$("#mc").blur(function() {
						var mc = $("#mc").val();
						var params = "mc=" + mc + "&method=checkMc"
						doAjax("qyxqFrontServlet", params, function(rstText) {
							var result = eval('(' + rstText + ')');
							if (result.status != 'OK') {
								layer.alert('此技术已经存在', {
									skin : 'layui-layer-lan' // 样式类名
									,
									closeBtn : 0
								});
								ok = "no";
							} else {
								ok = "ok";
							}
							return;
						});

						if (mc.length >= 50) {
							layer.alert('名称长度应在50字以内', {
								skin : 'layui-layer-lan' // 样式类名
								,
								closeBtn : 0
							});
							return;
						}
					});

					$("#email")
							.blur(
									function() {
										var email = $("#email").val();
										reg = /^([a-zA-Z0-9]+[_|\-|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\-|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/gi;
										if (email != "" && !reg.test(email)) {
											layer.alert('E-Mail填写不正确', {
												skin : 'layui-layer-lan' // 样式类名
												,
												closeBtn : 0
											});
											return;
										}
									});

					$("#mc_dw").blur(function() {
						var mc_dw = $("#mc_dw").val();
						if (mc_dw.length >= 50) {
							layer.alert('单位名称长度应在50字以内', {
								skin : 'layui-layer-lan' // 样式类名
								,
								closeBtn : 0
							});
							return;
						}
					});

					$("#dz_dw").blur(function() {
						var dz_dw = $("#dz_dw").val();
						if (dz_dw.length >= 100) {
							layer.alert('地址长度应在100字以内', {
								skin : 'layui-layer-lan' // 样式类名
								,
								closeBtn : 0
							});
							return;
						}
					});

					$("#lxr").blur(function() {
						var lxr = $("#lxr").val();
						if (lxr.length >= 25) {
							layer.alert('联系人长度应在25字以内', {
								skin : 'layui-layer-lan' // 样式类名
								,
								closeBtn : 0
							});
							return;
						}
					});
					$("#dh_lx").blur(
							function() {
								var dh_lx = $("#dh_lx").val();
								if (dh_lx != "") {
									if (!/^\d{3,4}\-\d{7,8}$/.test(dh_lx)
											&& !(/^1(3|4|5|7|8)\d{9}$/
													.test(dh_lx))) {
										layer.alert('联系电话输入格式不正确', {
											skin : 'layui-layer-lan' // 样式类名
											,
											closeBtn : 0
										});
										return;
									}

								}

							});
					$("#yt_tr").blur(function() {
						var yt_tr = $("#yt_tr").val();
						if (yt_tr.length >= 100) {
							layer.alert('投入总资金及用途长度应在100字以内', {
								skin : 'layui-layer-lan' // 样式类名
								,
								closeBtn : 0
							});
							return;
						}
					});
					$("#gjc").blur(function() {
						var gjc = $("#gjc").val();
						if (gjc.length >= 100) {
							layer.alert('关键词长度应在100字以内', {
								skin : 'layui-layer-lan' // 样式类名
								,
								closeBtn : 0
							});
							return;
						}
					});

					$("#jj_dw").blur(function() {
						var jj_dw = $("#jj_dw").val();
						if (jj_dw.length >= 10000) {
							layer.alert('单位情况长度应在10000字以内', {
								skin : 'layui-layer-lan' // 样式类名
								,
								closeBtn : 0
							});
							return;
						}
					});
					$("#nr_xq").blur(function() {
						var nr_xq = $("#nr_xq").val();
						if (nr_xq.length >= 10000) {
							layer.alert('技术需求说明长度应在10000字以内', {
								skin : 'layui-layer-lan' // 样式类名
								,
								closeBtn : 0
							});
							return;
						}
					});
					$("#rcxx").blur(function() {
						var gjc = $("#rcxx").val();
						if (gjc.length >= 10000) {
							layer.alert('人才信息长度应在10000字以内', {
								skin : 'layui-layer-lan' // 样式类名
								,
								closeBtn : 0
							});
							return;
						}
					});
					$("#zjxx").blur(function() {
						var zjxx = $("#zjxx").val();
						if (zjxx.length >= 10000) {
							layer.alert('资金信息长度应在10000字以内', {
								skin : 'layui-layer-lan' // 样式类名
								,
								closeBtn : 0
							});
							return;
						}
					});
					$("#xmzk").blur(function() {
						var xmzk = $("#xmzk").val();
						if (xmzk.length >= 10000) {
							layer.alert('项目状况长度应在10000字以内', {
								skin : 'layui-layer-lan' // 样式类名
								,
								closeBtn : 0
							});
							return;
						}
					});
					$("#upload")
							.click(
									function() {
										var user = $("#user").val();
										if (user == null || user == "") {
											layer.alert('你还没有登录，请先登录', {
												skin : 'layui-layer-lan' // 样式类名
												,
												closeBtn : 0
											});
											return;
										}
										var mc = jQuery("#mc").val();
										if (mc == "") {
											layer.alert('需求名称是必填项', {
												skin : 'layui-layer-lan' // 样式类名
												,
												closeBtn : 0
											});
											return;
										}
										if (ok == "no") {
											layer.alert('该需求已存在', {
												skin : 'layui-layer-lan' // 样式类名
												,
												closeBtn : 0
											});
											return;
										}
										if (mc.length >= 50) {
											layer.alert('名称长度应在50字以内', {
												skin : 'layui-layer-lan' // 样式类名
												,
												closeBtn : 0
											});
											return;
										}
										var email = $("#email").val();
										reg = /^([a-zA-Z0-9]+[_|\-|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\-|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/gi;
										if (email != "" && !reg.test(email)) {
											layer.alert('E-Mail填写不正确', {
												skin : 'layui-layer-lan' // 样式类名
												,
												closeBtn : 0
											});
											return;
										}
										var mc_dw = $("#mc_dw").val();
										if (mc_dw.length >= 50) {
											layer.alert('单位名称长度应在50字以内', {
												skin : 'layui-layer-lan' // 样式类名
												,
												closeBtn : 0
											});
											return;
										}
										if (mc_dw == "") {
											layer.alert('单位名称是必填项', {
												skin : 'layui-layer-lan' // 样式类名
												,
												closeBtn : 0
											});
											return;
										}
										var dz_dw = $("#dz_dw").val();
										if (dz_dw.length >= 100) {
											layer.alert('地址长度应在100字以内', {
												skin : 'layui-layer-lan' // 样式类名
												,
												closeBtn : 0
											});
											return;
										}
										if (dz_dw == "") {
											layer.alert('单位地址是必填项', {
												skin : 'layui-layer-lan' // 样式类名
												,
												closeBtn : 0
											});
											return;
										}
										var lxr = $("#lxr").val();
										if (lxr.length >= 25) {
											layer.alert('联系人长度应在25字以内', {
												skin : 'layui-layer-lan' // 样式类名
												,
												closeBtn : 0
											});
											return;
										}
										if (lxr == "") {
											layer.alert('联系人是必填项', {
												skin : 'layui-layer-lan' // 样式类名
												,
												closeBtn : 0
											});
											return;
										}
										var dh_lx = $("#dh_lx").val();
										if (dh_lx == "") {
											layer.alert('联系电话为必填项', {
												skin : 'layui-layer-lan' // 样式类名
												,
												closeBtn : 0
											});
											return;
										}
										if (!/^\d{3,4}\-\d{7,8}$/.test(dh_lx)
												&& !(/^1(3|4|5|7|8)\d{9}$/
														.test(dh_lx))) {
											layer.alert('联系电话输入格式不正确', {
												skin : 'layui-layer-lan' // 样式类名
												,
												closeBtn : 0
											});
											return;
										}
										var yt_tr = $("#yt_tr").val();
										if (yt_tr.length >= 100) {
											layer.alert('投入总资金及用途长度应在100字以内', {
												skin : 'layui-layer-lan' // 样式类名
												,
												closeBtn : 0
											});
											return;
										}
										var gjc = $("#gjc").val();
										if (gjc.length >= 100) {
											layer.alert('关键词长度应在100字以内', {
												skin : 'layui-layer-lan' // 样式类名
												,
												closeBtn : 0
											});
											return;
										}
										var jsssly1 = document.getElementById(
												"jsssly").getElementsByTagName(
												"input");
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
											layer.alert('技术所属领域不能为空', {
												skin : 'layui-layer-lan' // 样式类名
												,
												closeBtn : 0
											});
											return;
										}
										if (ok == "no") {
											layer.alert('此技术已经存在', {
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