var ok = "";
$(document).ready(function() {
	$("#jsmc").blur(function() {
		var str = $("#jsmc").val();
		var km = "技术供给";
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





function upload(){
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

	var jsmc = jQuery("#jsmc").val();
	var jssp = jQuery("#jssp").val();
	var pzdjh = jQuery("#pzdjh").val();
	var yyzt = jQuery("#yyzt").val();
	var sfzljs = jQuery("#sfzljs").val();
	var lxr = jQuery("#lxr").val();
	var zlh = jQuery("#zlh").val();
	var lxdh = jQuery("#lxdh").val();
	var ssgxjslb = jQuery("#ssgxjslb").val();
	var djrq = jQuery("#djrq").val();
	var jsscjd = jQuery("#jsscjd").val();
	var nf = jQuery("#nf").val();
	var jssx = jQuery("#jssx").val();
	var zlzt = jQuery("#zlzt").val();
	var jstxxs = jQuery("#jstxxs").val();
	var jsgjdw = jQuery("#jsgjdw").val();
	var txdz = jQuery("#txdz").val();
	var gjc = jQuery("#gjc").val();
	var xmjj = jQuery("#xmjj").val();

	if(ok == "no"){
		alert("此技术已经存在");
	}else{
	    var mes = confirm("确定提交？");
	    if (mes == true) {
	        jQuery.post("InsertJsgjServlet", {
	            
	        	"jsmc" : jsmc,
	        	"jssp" : jssp,
	        	"pzdjh" : pzdjh,
	        	"yyzt" : yyzt,
	        	"sfzljs" : sfzljs,
	        	"lxr" : lxr,
	        	"zlh" : zlh,
	        	"lxdh" : lxdh,
	        	"ssgxjslb" : ssgxjslb,
	        	"djrq" : djrq,
	        	"jsscjd" : jsscjd,
	        	"nf" : nf,
	        	"jssx" : jssx,
	        	"zlzt" : zlzt,
	        	"jstxxs" : jstxxs,
	        	"jsgjdw" : jsgjdw,
	        	"txdz" : txdz,
	        	"gjc" : gjc,
	        	"xmjj" : xmjj,
	        	
	        }, function(response){
	            var mes = response.replace(/^\s+|\s+$/g, "");
	            alert(mes);
	            if (mes == "提交成功") {
	                window.location.href = "JSGJ.jsp";
	            }
	        });
	    }
    }
}