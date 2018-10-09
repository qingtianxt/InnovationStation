$(document).ready(function(){ 
	$("#username").blur(function(){
		var str=$("#username").val();
		var containSpecial = RegExp(/[(\ )(\~)(\!)(\@)(\#)(\$)(\%)(\^)(\&)(\*)(\()(\))(\-)(\_)(\+)(\=)(\[)(\])(\{)(\})(\|)(\\)(\;)(\:)(\')(\")(\,)(\.)(\/)(\<)(\>)(\?)(\)]+/);      
	    if(containSpecial.test(str)){
	    	$("#user2").html("<font color='red'>用户名不能存在特殊字符！</font>");
	    	return ;
	    	}
	    if(str==""){
	    	$("#user2").html("<font color='red'>用户名应不能为空</font>");
	    	}
	    else if(/.*[\u4e00-\u9fa5]+.*$/.test(str)){
			$("#user2").html("<font color='red'>用户名应不能使用汉字！</font>");
		 }
		else if(str.length>20||str.length<6){
			$("#user2").html("<font color='red'>用户名应大于6位且小于20位</font>");
		}else {
			var params="username="+str;
			 doAjax("CheckUserName", params, function(rstText) {
				var result=eval('('+rstText+')');
				if(result.status=='OK')
					{
					$("#user2").html("<font color='green'>用户名可以使用！</font>");
					}else
						{
						$("#user2").html("<font color='red'>用户名已被使用！</font>");
						}
			});
		 }
    });
	 $("#pwd").blur(function(){
		 var str=$("#pwd").val();
		  var str2=$("#rspwd").val();
		 var containSpecial = RegExp(/[(\ )(\~)(\!)(\@)(\#)(\$)(\%)(\^)(\&)(\*)(\()(\))(\-)(\_)(\+)(\=)(\[)(\])(\{)(\})(\|)(\\)(\;)(\:)(\')(\")(\,)(\.)(\/)(\<)(\>)(\?)(\)]+/);      
		 if(containSpecial.test(str))
    	 {
    	 $("#pwd2").html("<font color='red'>密码不能存在特殊字符！</font>");
    	 }
		 if(str==""){
			 $("#pwd2").html("<font color='red'>密码不能为空</font>");
		 }else if(str.length>20||str.length<6){
			 $("#pwd2").html("<font color='red'>密码应大于6位且小于20位</font>");
		 }
		 else{
				 $("#pwd2").html("");		
				 	 
		 }
		 if(str2!="")
		 {
		 	if(str!=str2)
			{
				 $("#rspwd2").html("<font color='red'>两次密码不同</font>");
			}
			else
			{
			 $("#rspwd2").html("");
			 }
		 }
    });
	 $("#rspwd").blur(function(){
		 var str1=$("#rspwd").val();
		 var str2=$("#pwd").val();
		 if(str1!=str2){
			 $("#rspwd2").html("<font color='red'>两次密码不同</font>");
		 }else{
			 $("#rspwd2").html("");
		 }
    });
	 

	 
	 

	 $("#jgqc").blur(function(){
		 var str=$("#jgqc").val();
		 if(str=="")
		 {
		 $("#jgqc2").html("<font color='red'>企业名称不可为空!</font>");
		 return ;
		 } 
		 var containSpecial = RegExp(/[(\ )(\~)(\!)(\@)(\#)(\$)(\%)(\^)(\&)(\*)(\()(\))(\-)(\_)(\+)(\=)(\[)(\])(\{)(\})(\|)(\\)(\;)(\:)(\')(\")(\,)(\.)(\/)(\<)(\>)(\?)(\)]+/);      
	     if(containSpecial.test(str))
	    	 {
	    	 $("#jgqc2").html("<font color='red'>企业名称含有特殊字符!</font>");
	    	 }
	     else {
			{
				$("#jgqc2").html("");
			}
		}


	    
	 });
	 
	 
	 $("#yx").blur(function(){
		 var str=$("#yx").val();
		 if(str=="")
		 {
		 $("#yx2").html("");
		 return ;
		 } 
		
         var pattern =/^[a-zA-Z0-9_\-]{1,}@[a-zA-Z0-9_\-]{1,}\.[a-zA-Z0-9_\-.]{1,}$/;
            
                 if(!pattern.exec(str))
                 {
                	 $("#yx2").html("<font color='red'>邮箱不正确!</font>");
                 }
                 else
                 {
                	 $("#yx2").html("");
                 }
	 });

	 $("#yddh").blur(function(){
		 var s=$("#yddh").val();
		 if(s=="")
			 {
			 $("#yddh2").html("");
			 return ;
			 } 
		  var reg0 = /^(13[0-9]|15[0-9]|18[0-9])\d{8}$/;
       
         var my = false;
         if (reg0.test(s))my=true;
             
                 if (!my)
                 {
                	 $("#yddh2").html("<font color='red'>请输入正确的联系方式!</font>");
                 }
                 else
                {
                	 $("#yddh2").html("");
                }
	 });
});
function getXMLHttpResquest() {
	  var request;
      if (window.XMLHttpRequest)
      {
          request = new XMLHttpRequest();
      }
      else
      {
          try
          {
              request = new ActiveXObject("Microsoft.XMLHTTP");
          }
          catch (e)
          {
              request = new ActiveXObject("Msxml2.XMLHTTP");
          }
      }
      return request;
}
function doAjax(url,params,callBack) {
	var req=getXMLHttpResquest();
	if(req!=null)
		{
		req.onreadystatechange=function(){
			if(req.readyState==4)
				{
				if(200==req.status)
					{
					callBack(req.responseText);
					
					}else if(404==req.status)
						{
						alert('404-HTTP请求路径错误！');
						}
					else if(500==req.status)
						{
						alert('500-HTTP请求路径错误！');
						}
						
				}
			
		};
		req.open("POST",url,true);
		req.setRequestHeader("Content-Type","application/x-www-form-urlencoded;;charset=utf-8");
		req.send(params);
	}
	
}
