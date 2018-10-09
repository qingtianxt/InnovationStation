jQuery(function() {
	$("#zctj").click(function() {
		var username = $("#username").val();
		var pwd = $("#pwd").val();
		var rspwd = $("#rspwd").val();
		var jgqc = $("#jgqc").val();
		var rand = $("#rand").val();
		function containSpecial(s) {
			var containSpecial = RegExp(/[(\ )(\~)(\!)(\#)(\$)(\%)(\^)(\&)(\*)(\()(\))(\-)(\_)(\+)(\=)(\[)(\])(\{)(\})(\|)(\\)(\;)(\:)(\')(\")(\,)(\.)(\/)(\<)(\>)(\?)(\)]+/);
			return (containSpecial.test(s));
		}
		if (username == "") {
			alert("用户名不能为空");
		} else if (document.all.user2.innerText == "用户名已被使用！") {
			alert("用户名已被使用！");
		} else if (document.all.user2.innerText == "用户名不能存在特殊字符！") {
			alert("用户名不能存在特殊字符！");
		} else if (document.all.user2.innerText == "用户名应不能使用汉字！") {
			alert("用户名不能存在特殊字符！");
		} else if (document.all.user2.innerText == "用户名应大于6位且小于20位") {
			alert("用户名应大于6位且小于20位");
		} else if (pwd == "") {
			alert("密码不能为空");
		} else if (document.all.pwd2.innerText == "密码应大于6位且小于20位") {
			alert("密码应大于6位且小于20位");
		} else if (document.all.pwd2.innerText == "密码不能存在特殊字符！") {
			alert("密码不能存在特殊字符！");
		} else if (rspwd == "") {
			alert("请再次输入密码");
		} else if (document.all.rspwd2.innerText == "两次密码不同") {
			alert("两次密码不同");
		}  else if (jgqc == "") {
			alert("企业名称不能为空！");
		} else if (document.all.jgqc2.innerText == "企业名称含有特殊字符!") {
			alert("企业名称不能含有特殊字符!");
		}   else if (document.all.yddh2.innerText == "请输入正确的联系方式!") {
			alert("请输入正确的联系方式!");
		}  else if (document.all.yx2.innerText == "邮箱不正确！") {
			alert("邮箱不正确！");
		} else if (rand == "") {
			alert("验证码不可为空！");
		} else if (pwd.length > 20 || pwd.length < 6) {
			alert("密码应大于6位且小于20位");
		} else if (rspwd != pwd) {
			alert("两次密码不同");
		} else if (containSpecial(username)) {
			alert("用户名存在特殊字符，请检查");
		}  else {
			var mes = confirm("确定注册？");
			if(mes == true){
			jQuery.post("InsertUserServlet", {
				"username" : $("#username").val(),
				"pwd" : $("#pwd").val(),
				"jgqc" : $("#jgqc").val(),
				"txdz" : $("#txdz").val(),
				"yddh" : $("#yddh").val(),
				"yx" : $("#yx").val(),
				"rand" : $("#rand").val()
			}, function(response) {
				alert(response);
				var mes = response.replace(/^\s+|\s+$/g, "");
				if (mes == "注册成功") { 	
					
					window.top.location.href = "index.jsp";
				}
			});
		}
		}
	});
});