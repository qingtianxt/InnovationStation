var ok = "";
$(document).ready(function() {
	$("#username").blur(function() {
		var str = $("#username").val();
		if(str!=""){
		var params="username="+str;
		doAjax("CheckUserName", params, function(rstText) {
			var result=eval('('+rstText+')');
			if(result.status=='OK'){
				alert("用户不存在");
				ok = "no";
			}
//			else if(result.status=='OK1'){
//				alert("用户尚未经过审核");
//				ok = "no";
//			}
			else{
				ok = "ok";
			}
		});
		}
	});
});
//使用原生ajax
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

jQuery(function() {
	$("#login").click(function() {
		var username = $("#username").val();
		var password = $("#password").val();
		var randcode = $("#randcode").val();
		var containSpecial = RegExp(/[(\ )(\~)(\!)(\#)(\$)(\%)(\^)(\&)(\*)(\()(\))(\-)(\_)(\+)(\=)(\[)(\])(\{)(\})(\|)(\\)(\;)(\:)(\')(\")(\,)(\.)(\/)(\<)(\>)(\?)(\)]+/);
		var num = new RegExp(/^[0-9]+$/);
		if (username == "") {
			alert("用户名不能为空");
		} else if (username.length > 20 || username.length < 6) {
			alert("用户名小于6位或大于20位");

		} else if (password == "") {
			alert("密码不能为空");
			
		} else if (password.length > 20 || password.length < 6) {
			alert("密码小于6位或大于20位");
			
		} else if (randcode == "") {
			alert("验证码不能为空");
		
		} else if (!num.test(randcode)) {
				alert("验证码只能由数字组成!");
		} else if (containSpecial.test(username) || containSpecial.test(password) || containSpecial.test(randcode)) {
				alert("有特殊字符请重新填写！");
		}else if(ok=="no"){
			alert("用户名不正确");
		}
		else{
			jQuery.post("LoginServlet", {
	    	"username" : $("#username").val(),
	    	"password" : $("#password").val(),
	    	"randcode" : $("#randcode").val()
	    },function(response){
			var mes = response.replace(/^\s+|\s+$/g, "");
			if (mes == "登录成功") {
				alert(username+", 您好！欢迎来到创新驿站个人工作平台！");
				//window.top.location.href = "back_stage/main.html";
				window.location.reload();
			}
			else{
				alert(response);
			}
	    });	
		}
	});
});