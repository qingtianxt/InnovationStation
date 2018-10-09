<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="top_login">
  <div class="login_in">
	<div align="center">
	<input type="hidden" id="power" value="-1">
		  <label>尊敬 的,${sessionScope.session_user.username},您好！</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		  <label>欢迎使用河北省创新驿站协同工作平台</label>	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		  <label><a onClick="stage()">用户中心</a></label>&nbsp;&nbsp;&nbsp;
		  <a href="javascript:logout()" style="margin-right:30px; text-decoration:none;cursor: pointer;"><label style="cursor:pointer;">退出登录</label></a>
	 </div>	
  </div>
</div>
<script>
function stage(){
	var powerName = "${sessionScope.session_user.role.roleName}";
	if(powerName=="无权限"){
		
		layer.open({
			content:"对不起,您的账号还未通过审核!",
			btn:["确定"],
			skin:"layui-layer-lan",
			offset:['100px','500px'],
			btn1:function(index,layero){
				layer.close(index);
			}
		})
	}else{
		location.href = "${pageContext.request.contextPath}/back/main.jsp";
	}
}
function logout(){
	var f = window.location.href;
	/*
	if(confirm("您确定要退出吗？"))
		window.location.href = "${pageContext.request.contextPath}/userServlet?method=logout";
	*/
	layer.open({  
		content: '确定要退出吗?',  
		btn: ['确认', '取消'],  
		btn1: function(index, layero) {  
			layer.close(index);
			window.top.location.href = "${pageContext.request.contextPath}/userServlet?method=logout";
		},  
		btn2: function(index, layero) {  
			//loaction.href = "${pageContext.request.contextPath}/userServlet?method=logout";
			layer.close(index);
		}  
		,  
		cancel: function() {  
			//右上角关闭回调  
		}  ,
		offset:['100px','500px']
	});  
}
</script>