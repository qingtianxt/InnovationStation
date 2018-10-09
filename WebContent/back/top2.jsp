<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.STYLE {
font-size:14px;
color:#FFFFFF;

}
</style>
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" background="#B1D8EA" bgcolor="#B1D8EA">
<div style="background-color: #1f8de4;height: 30px; position: relative;margin-top: 5px;margin-left: 8px;border: #ffffff 1px solid" >
	<div  style="position: absolute;top: 5px;right: 20px" >
	<font color="ffffff"><span class="STYLE">您好！   今天是：
	<script> 
             var weekDayLabels = new Array("星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六");
             var now = new Date();
             var year = now.getFullYear();
             var month = now.getMonth() + 1;
             var day = now.getDate();
             var currentime = year + "年" + month + "月" + day + "日 " + weekDayLabels[now.getDay()];
             document.write(currentime);
     </script>
              </span>
	&nbsp;${session_user.username }
	<a style="text-decoration: none;" target="right" href="${pageContext.request.contextPath}/back/user/modifyPwd.jsp"><span class="STYLE" >修改密码</span></a>|
	<a style="text-decoration: none;" target="_top" href="${pageContext.request.contextPath}/front/index.jsp"><span class="STYLE" >返回首页</span></a>|
	<a style="text-decoration: none;" href="${pageContext.request.contextPath }/back/user/userServlet?method=logout" target="_parent"><span class="STYLE">退出系统</span></a>
	</font>
	</div>
</div>
</body>
</html>




















