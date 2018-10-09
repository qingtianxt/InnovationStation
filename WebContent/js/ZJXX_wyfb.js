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
	
	var xm = jQuery("#xm").val();
	if(xm==""){
		alert("专家姓名不能为空");
		return;
	}
	var szs = jQuery("#szs").val();
	var xb = jQuery("#xb").val();
	var gj = jQuery("#gj").val();
	var bgdh = jQuery("#bgdh").val();
	var csrq = jQuery("#csrq").val();
	var zc = jQuery("#zc").val();
	if(zc==""){
		alert("专家职称不能为空");
		return;
	}
	var sj = jQuery("#sj").val();
	var xw = jQuery("#xw").val();
	var zycj = jQuery("#zycj").val();
	var xl = jQuery("#xl").val();
	var yjfx = jQuery("#yjfx").val();
	if(yjfx==""){
		alert("研究方向不能为空");
		return;
	}
	var yslb = jQuery("#yslb").val();
	var byyx = jQuery("#byyx").val();
	var gzdw = jQuery("#gzdw").val();
	var zjch = jQuery("#zjch").val();
	var xkly = jQuery("#xkly").val();
	if(xkly==""){
		alert("学科领域不能为空");
		return;
	}
	var xcshy = jQuery("#xcshy").val();
	var gjc = jQuery("#gjc").val();
	var grjj = jQuery("#grjj").val();
	
	
    var mes = confirm("确定提交？");
    if (mes == true) {
        jQuery.post("InsertZjxxServlet", {
     
        	"xm" : xm,
			"szs" : szs,
			"xb" : xb,
			"gj" : gj,
			"bgdh" : bgdh,
			"csrq" : csrq,
			"zc" : zc,
			"sj" : sj,
			"xw" : xw,
			"zycj" : zycj,
			"xl" : xl,
			"yjfx" : yjfx,
			"yslb" : yslb,
			"byyx" : byyx,
			"gzdw" : gzdw,
			"zjch" : zjch,
			"xkly" : xkly,
			"xcshy" : xcshy,
			"gjc" : gjc,
			"grjj" : grjj,
        	
        	
        }, function(response){
            var mes = response.replace(/^\s+|\s+$/g, "");
            alert(mes);
            if (mes == "提交成功") {
                window.location.href = "ZJXX.jsp";
            }
        });
    }
}