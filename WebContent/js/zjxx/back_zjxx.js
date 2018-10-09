var ok = "";
$(document).ready(function() {
	$("#xm").blur(function() {
		var xm = jQuery("#xm").val();
		if (xm.length >= 10) {
			layer.alert('专家姓名长度不超过10', {
				skin : 'layui-layer-lan' // 样式类名
				,
				closeBtn : 0
			});

			return;
		}
	});
	$("#szs").blur(function() {
		var szs = jQuery("#szs").val();
		if (szs.length >= 10) {
			layer.alert('输入的所在市的长度小于10', {
				skin : 'layui-layer-lan' // 样式类名
				,
				closeBtn : 0
			});

			return;
		}
	});

	$("#xb").blur(function() {
		var xb = jQuery("#xb").val();
		if (xb != '男' && xb != '女' && xb != '') {
			layer.alert('请输入正确的性别的格式', {
				skin : 'layui-layer-lan' // 样式类名
				,
				closeBtn : 0
			});

			return;
		}
	});
	$("#gj").blur(function() {
		var gj = jQuery("#gj").val();
		if (gj.length >= 15) {
			layer.alert('输入国籍的长度不超过15', {
				skin : 'layui-layer-lan' // 样式类名
				,
				closeBtn : 0
			});

			return;
		}
	});
	$("#bgdh").blur(function() {
		var bgdh = $("#bgdh").val();
		if (bgdh != "") {
			if (!/^\d{3,4}\-\d{7,8}$/.test(bgdh)) {
				layer.alert('办公电话输入格式不正确', {
					skin : 'layui-layer-lan' // 样式类名
					,
					closeBtn : 0
				});
				return;
			}
		}

	});

	$("#zc").blur(function() {
		var zc = jQuery("#zc").val();
		if (zc.length >= 20) {
			layer.alert('输入职称的长度不超过20', {
				skin : 'layui-layer-lan' // 样式类名
				,
				closeBtn : 0
			});

			return;
		}
	});

	$("#sj").blur(function() {
		var str = $("#sj").val();
		var r = new RegExp(/\d{11}/);
		if (str != "") {
			if (!r.exec(str) || str.length != 11) {
				layer.alert('请填写正确手机号', {
					skin : 'layui-layer-lan' // 样式类名
					,
					closeBtn : 0
				});
				return;
			}
		}

	});

	$("#xw").blur(function() {
		var xw = jQuery("#xw").val();
		if (xw.length >= 10) {
			layer.alert('输入学位的长度不超过10', {
				skin : 'layui-layer-lan' // 样式类名
				,
				closeBtn : 0
			});

			return;
		}
	});
	$("#zycj").blur(function() {
		var zycj = jQuery("#zycj").val();
		if (zycj.length >= 50) {
			layer.alert('输入主要成就的长度不超过50', {
				skin : 'layui-layer-lan' // 样式类名
				,
				closeBtn : 0
			});

			return;
		}
	});

	$("#xl").blur(function() {
		var xl = jQuery("#xl").val();
		if (xl.length >= 10) {
			layer.alert('输入学历的长度不超过10', {
				skin : 'layui-layer-lan' // 样式类名
				,
				closeBtn : 0
			});

			return;
		}
	});
	$("#yjfx").blur(function() {
		var yjfx = jQuery("#yjfx").val();
		if (yjfx.length >= 25) {
			layer.alert('输入研究方向的长度不超过25', {
				skin : 'layui-layer-lan' // 样式类名
				,
				closeBtn : 0
			});

			return;
		}
	});
	$("#byyx").blur(function() {
		var byyx = jQuery("#byyx").val();
		if (byyx.length >= 10) {
			layer.alert('输入毕业院校的长度不超过10', {
				skin : 'layui-layer-lan' // 样式类名
				,
				closeBtn : 0
			});

			return;
		}
	});
	$("#gzdw").blur(function() {
		var gzdw = jQuery("#gzdw").val();
		if (gzdw.length >= 30) {
			layer.alert('输入工作单位的长度不超过30', {
				skin : 'layui-layer-lan' // 样式类名
				,
				closeBtn : 0
			});

			return;
		}
	});
	$("#zjch").blur(function() {
		var zjch = jQuery("#zjch").val();
		if (zjch.length >= 50) {
			layer.alert('输入专家称号的长度不超过50', {
				skin : 'layui-layer-lan' // 样式类名
				,
				closeBtn : 0
			});

			return;
		}
	});
	$("#xkly").blur(function() {
		var xkly = jQuery("#xkly").val();
		if (xkly.length >= 50) {
			layer.alert('输入学科领域的长度不超过50', {
				skin : 'layui-layer-lan' // 样式类名
				,
				closeBtn : 0
			});

			return;
		}
	});
	$("#xcshy").blur(function() {
		var xcshy = jQuery("#xcshy").val();
		if (xcshy.length >= 25) {
			layer.alert('输入现从事行业的长度不超过25', {
				skin : 'layui-layer-lan' // 样式类名
				,
				closeBtn : 0
			});

			return;
		}
	});
	$("#gjc").blur(function() {
		var gjc = jQuery("#gjc").val();
		if (gjc.length >= 50) {
			layer.alert('输入关键词的长度不超过50', {
				skin : 'layui-layer-lan' // 样式类名
				,
				closeBtn : 0
			});

			return;
		}
	});
	$("#grjj").blur(function() {
		var grjj = jQuery("#grjj").val();
		if (grjj.length >= 10000) {
			layer.alert('输入个人简介的长度不建议超过10000', {
				skin : 'layui-layer-lan' // 样式类名
				,
				closeBtn : 0
			});

			return;
		}
	});

	$("#sb").click(function() {
		var xm = jQuery("#xm").val();
		if (xm == "") {
			layer.alert('专家姓名是必填项', {
				skin : 'layui-layer-lan' // 样式类名
				,
				closeBtn : 0
			});

			return;
		}
		if (xm.length >= 10) {
			layer.alert('专家姓名长度不超过10', {
				skin : 'layui-layer-lan' // 样式类名
				,
				closeBtn : 0
			});

			return;
		}
		var szs = jQuery("#szs").val();
		if (szs.length >= 10) {
			layer.alert('输入的所在市的长度小于10', {
				skin : 'layui-layer-lan' // 样式类名
				,
				closeBtn : 0
			});

			return;
		}
		if (szs == "") {
			layer.alert('所在市是必填项', {
				skin : 'layui-layer-lan' // 样式类名
				,
				closeBtn : 0
			});
			return;
		}
		var xb = jQuery("#xb").val();
		if (xb == "") {
			layer.alert('性别是必填项', {
				skin : 'layui-layer-lan' // 样式类名
				,
				closeBtn : 0
			});
			return;
		}
		if (xb != '男' && xb != '女' && xb != '') {
			layer.alert('请输入正确的性别的格式', {
				skin : 'layui-layer-lan' // 样式类名
				,
				closeBtn : 0
			});
			return;
		}
		var gj = jQuery("#gj").val();
		if (gj.length >= 15) {
			layer.alert('输入国籍的长度不超过15', {
				skin : 'layui-layer-lan' // 样式类名
				,
				closeBtn : 0
			});

			return;
		}
		if (gj == "") {
			layer.alert('国籍是必填项', {
				skin : 'layui-layer-lan' // 样式类名
				,
				closeBtn : 0
			});
			return;
		}

		var csrq = $("#csrq").val();
		if (csrq == "") {
			layer.alert('出生日期是必填项', {
				skin : 'layui-layer-lan' // 样式类名
				,
				closeBtn : 0
			});
			return;
		}

		var zc = jQuery("#zc").val();
		if (zc.length >= 20) {
			layer.alert('输入职称的长度不超过20', {
				skin : 'layui-layer-lan' // 样式类名
				,
				closeBtn : 0
			});

			return;
		}
		if (zc == "") {
			layer.alert('职称是必填项', {
				skin : 'layui-layer-lan' // 样式类名
				,
				closeBtn : 0
			});

			return;
		}
		var str = $("#sj").val();
		if (str == "") {
			layer.alert('手机号是必填项', {
				skin : 'layui-layer-lan' // 样式类名
				,
				closeBtn : 0
			});
		}
		var r = new RegExp(/\d{11}/);
		if (!r.exec(str) || str.length != 11) {
			layer.alert('请填写正确手机号', {
				skin : 'layui-layer-lan' // 样式类名
				,
				closeBtn : 0
			});
			return;
		}
		var xw = jQuery("#xw").val();
		if (xw.length >= 10) {
			layer.alert('输入学位的长度不超过10', {
				skin : 'layui-layer-lan' // 样式类名
				,
				closeBtn : 0
			});

			return;
		}
		var zycj = jQuery("#zycj").val();
		if (zycj.length >= 50) {
			layer.alert('输入主要成就的长度不超过50', {
				skin : 'layui-layer-lan' // 样式类名
				,
				closeBtn : 0
			});

			return;
		}
		var xl = jQuery("#xl").val();
		if (xl.length >= 10) {
			layer.alert('输入学历的长度不超过10', {
				skin : 'layui-layer-lan' // 样式类名
				,
				closeBtn : 0
			});

			return;
		}
		var yjfx = jQuery("#yjfx").val();
		if (yjfx.length >= 25) {
			layer.alert('输入研究方向的长度不超过25', {
				skin : 'layui-layer-lan' // 样式类名
				,
				closeBtn : 0
			});

			return;
		}
		if (yjfx == "") {
			layer.alert('研究方向是必填项', {
				skin : 'layui-layer-lan' // 样式类名
				,
				closeBtn : 0
			});
		}
		var byyx = jQuery("#byyx").val();
		if (byyx.length >= 10) {
			layer.alert('输入毕业院校的长度不超过10', {
				skin : 'layui-layer-lan' // 样式类名
				,
				closeBtn : 0
			});

			return;
		}
		var gzdw = jQuery("#gzdw").val();
		if (gzdw.length >= 30) {
			layer.alert('输入工作单位的长度不超过30', {
				skin : 'layui-layer-lan' // 样式类名
				,
				closeBtn : 0
			});

			return;
		}
		var zjch = jQuery("#zjch").val();
		if (zjch.length >= 50) {
			layer.alert('输入专家称号的长度不超过50', {
				skin : 'layui-layer-lan' // 样式类名
				,
				closeBtn : 0
			});

			return;
		}
		var xkly = jQuery("#xkly").val();
		if (xkly.length >= 50) {
			layer.alert('输入学科领域的长度不超过50', {
				skin : 'layui-layer-lan' // 样式类名
				,
				closeBtn : 0
			});

			return;
		}
		if (xkly == "") {
			layer.alert('学科领域是必填项', {
				skin : 'layui-layer-lan' // 样式类名
				,
				closeBtn : 0
			});

			return;
		}
		var xcshy = jQuery("#xcshy").val();
		if (xcshy.length >= 25) {
			layer.alert('输入现从事行业的长度不超过25', {
				skin : 'layui-layer-lan' // 样式类名
				,
				closeBtn : 0
			});

			return;
		}
		var gjc = jQuery("#gjc").val();
		if (gjc.length >= 50) {
			layer.alert('输入关键词的长度不超过50', {
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