var ok = "";
$(document).ready(function() {
	$("#cgmc").blur(function() {
		var str = $("#cgmc").val();
		var km = "成果转化项目";
		var params = "jsxqmc=" + str + "," + km;
		doAjax("CheckServlet", params, function(rstText) {
			var result = eval('(' + rstText + ')');
			if (result.status != 'OK') {
				alert("成果已经存在");
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
	
	var cgmc = jQuery("#cgmc").val();
	if(cgmc==""){
		alert("成果名称不能为空");
		return;
	}
	var pzdjh = jQuery("#pzdjh").val();
	var gclb = jQuery("#gclb").val();
	var cgssdw = jQuery("#cgssdw").val();
	var djrq = jQuery("#djrq").val();
	var ssgxjslb = jQuery("#ssgxjslb").val();
	//var cgtxxs = jQuery("#cgtxxs").val();
	var cgsp = jQuery("#cgsp").val();
	var cgscjd = jQuery("#cgscjd").val();
	var yyzt = jQuery("#yyzt").val();
	//var cgyyhy = jQuery("#cgyyhy").val();
	//var jsssly = jQuery("#jsssly").val();
	var lxr = jQuery("#lxr").val();
	var lxdh = jQuery("#lxdh").val();
	var cgsx = jQuery("#cgsx").val();
	var nf = jQuery("#nf").val();
	var txdz = jQuery("#txdz").val();
	var hxzl = jQuery("#hxzl").val();
	var gjc = jQuery("#gjc").val();
	var jj = jQuery("#jj").val();
	
	var selectgm1 = jQuery("#selectGM1").val();
    var selectgm2 = jQuery("#selectGM2").val();
    var selectgm3 = jQuery("#selectGM3").val();
    if(selectgm1 =="请选择")
	{
	alert("成果应用行业为必填项！");
	return;
	}
	
    var jsssly1 = document.getElementById("jsssly").getElementsByTagName("input");
	var jsssly = "";
	for (var i = 0; i < 22; i++) {
        if (jsssly1[i].checked) {
            if (jsssly == "") {
            	jsssly = jsssly + i;
            }
            else {
            	jsssly = jsssly + "," + i;
            }
        }
    }
	if(jsssly==""){
		alert("技术所属领域不能为空");
		return;
	}
	
	var cgtxxs1 = document.getElementById("cgtxxs").getElementsByTagName("input");
	var cgtxxs = "";
	for (var i = 0; i < 14; i++) {
        if (cgtxxs1[i].checked) {
            if (cgtxxs == "") {
            	cgtxxs = cgtxxs + i;
            }
            else {
            	cgtxxs = cgtxxs + "," + i;
            }
        }
    }
	if(cgtxxs==""){
		alert("成果体现形式不能为空");
		return;
	}
	
	if(ok == "no"){
		alert("成果已经存在");
	}else{
	    var mes = confirm("确定提交？");
	    if (mes == true) {
	        jQuery.post("InsertKjcgServlet", {
	            
	        	"selectgm1": $("#selectGM1").val(),
	            "selectgm2": $("#selectGM2").val(),
	            "selectgm3": $("#selectGM3").val(),
	        	 "cgmc" : cgmc,
	        	 "pzdjh" : pzdjh,
	        	 "gclb" : gclb,
	        	 "cgssdw" : cgssdw,
	        	 "djrq" : djrq,
	        	 "ssgxjslb" : ssgxjslb,
	        	 "cgtxxs" : cgtxxs,
	        	 "cgsp" : cgsp,
	        	 "cgscjd" : cgscjd,
	        	 "yyzt" : yyzt,
	        	// "cgyyhy" : cgyyhy,
	        	 "jsssly" : jsssly,
	        	 "lxr" : lxr,
	        	 "lxdh" : lxdh,
	        	 "cgsx" : cgsx,
	        	 "nf" : nf,
	        	 "txdz" : txdz,
	        	 "hxzl" : hxzl,
	        	 "gjc" : gjc,
	        	 "jj" : jj,
	        	
	        }, function(response){
	            var mes = response.replace(/^\s+|\s+$/g, "");
	            alert(mes);
	            if (mes == "提交成功") {
	                window.location.href = "KJCG.jsp";
	            }
	        });
	    }
    }
}
