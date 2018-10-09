var ok = "";
$(document).ready(function() {
	$("#jsxqmc").blur(function() {
		var str = $("#jsxqmc").val();
		var km = "技术需求";
		var params = "jsxqmc=" + str + "," + km;
		doAjax("CheckServlet", params, function(rstText) {
			var result = eval('(' + rstText + ')');
			if (result.status != 'OK') {
				alert("此技术已经存在");
				ok = "no";
			}else{
				ok = "ok";
			}
		});
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
					alert('404-HTTP请求路径错误！');
				} else if (500 == req.status) {
					alert('500-HTTP请求路径错误！');
				}
			}
		};
		req.open("POST", url, true);
		req.setRequestHeader("Content-Type",
				"application/x-www-form-urlencoded;;charset=utf-8");
		req.send(params);
	}
}
function upload() {
	var username = $("#username").val();
	var power = $("#power").val();
	if(username == "" || username == null || username == "null"){
		alert("您还没有登录，请先登录");
		return;
	}
	if(power == "0"){
		alert("对不起，您尚没有此权限");
		return;
	}
	var jsxqmc = jQuery("#jsxqmc").val();
	var jsssly = jQuery("#jsssly").val();
	var hzfs = jQuery("#hzfs").val();
	var email = jQuery("#email").val();
	var jsxqdw = jQuery("#jsxqdw").val();
	var dwdz = jQuery("#dwdz").val();
	var lxr = jQuery("#lxr").val();
	var lxdh = jQuery("#lxdh").val();
	var trzzjjyt = jQuery("#trzzjjyt").val();
	var gjc = jQuery("#gjc").val();
	var dwqkjj = jQuery("#dwqkjj").val();
	var jsxqsm = jQuery("#jsxqsm").val();
	var rcxx = jQuery("#rcxx").val();
	var zjxx = jQuery("#zjxx").val();
	var xmzk = jQuery("#xmzk").val();
	
	if(ok == "no"){
		alert("此技术已经存在");
	}else{
		var mes = confirm("确定提交？");
		if (mes == true) {
			jQuery.post("InsertJsxqServlet", {
				"jsxqmc" : jsxqmc,
				"jsssly" : jsssly,
				"hzfs" : hzfs,
				"email" : email,
				"jsxqdw" : jsxqdw,
				"dwdz" : dwdz,
				"lxr" : lxr,
				"lxdh" : lxdh,
				"trzzjjyt" : trzzjjyt,
				"gjc" : gjc,
				"dwqkjj" : dwqkjj,
				"jsxqsm" : jsxqsm,
				"rcxx" : rcxx,
				"zjxx" : zjxx,
				"xmzk" : xmzk,
			}, function(response) {
				var mes = response.replace(/^\s+|\s+$/g, "");
				alert(mes);
				if (mes == "提交成功") {
					window.location.href = "QYXQ.jsp";
				}
			});
		}
	}
}