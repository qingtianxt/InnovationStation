<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="u" uri="http://localhost:8080/3-28/util" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.12.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.validate.js"></script>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/sl.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/lhgcalendar.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/lhgcore.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/lhgcalendar.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/sl.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/layer/layer.js"></script>
</head>
<body>
<div>
<div class="nav">
	您现在的位置：
	<ul class="nav-ul">
		<li class="nav-li"><a href="#">用户管理</a></li>
		<li class="nav-li"><a href="#">用户列表</a></li>
	</ul>
	</div>
<form action="${pageContext.request.contextPath }/back/user/userServlet?method=list&result=list" method="post">
	<table class="query-table">
  <tr>
    <td >用户名：</td>
    <td ><input name="username" type="text" id="yhm" value="${pagingBean.username }" placeholder="请输入用户名" /></td>
    <td height="23">企业名称：</td>
    <td><input name="eName" type="text" id="qymc" value="${pagingBean.eName }" placeholder="请输入企业名称"/></td>
    <td>角色名：</td>
    <td>
		<select  name="roleId" id="jsm">
        </select>
	</td>
    <td>
    	<input type="submit" value="查询"/>
   	</td>
    <td>
    	<input type="button" value="添加新用户" onclick="toAdd()" />
   	</td>
  </tr>
</table>
</form>
	<table class="result-table">
	<tr>
		<th width="5%">序号</th><th width="20%">用户名</th><th width="17%">企业名称</th><th width="10%">用户角色</th><th width="13%">操作</th>
	</tr>
	<c:forEach items="${pageBeans }" var="userBean" varStatus="status">
		<tr>
			<td>${status.index+1 + (sessionScope.pagingBean.currentPage-1) * sessionScope.pagingBean.pageSize }</td>
			<td style="padding-left: 5px;text-align:left">${userBean.username }</td>
			<td style="padding-left: 5px;text-align:left">${userBean.name}</td>
			<td style="padding-left: 5px;text-align:left">${userBean.role.roleName }</td>
			<td><c:if test="${userBean.role.id==0 }"><a href="userServlet?method=getUser&result=sh&id=${userBean.id }">审核</a></c:if>
				<a href="userServlet?method=getUser&result=update&id=${userBean.id }">编辑</a>|<a href="javascript:del(${userBean.id })">删除</a></td>
		</tr>
	</c:forEach>
	<tr>
		<td colspan="5"><u:page pagingBean="${sessionScope.pagingBean }"/></td>
	</tr>
	</table>
</div>
<script type="text/javascript">
	var x = "${pagingBean.roleId}";
	$.get("${pageContext.request.contextPath}/back/role/roleServlet", {
		method : "list",
		result : "json"
	}, function(res) {
		$("#jsm").empty();
		$("#jsm").append("<option value=''>请选择</option>")
		for(var i in res){
			var $option = $("<option></option>");
			$option.attr("value",res[i]['id']);
			$option.html(res[i]['roleName']);
			if(x!=""&&x==res[i]['id'])
				$option.attr("selected","selected");
			$option.appendTo($("#jsm"));
		}
	}, "json");
	
	function toAdd(){
		location.href = "${pageContext.request.contextPath}/back/user/add_user.jsp";
	}
	
	function del(id){
		layer
		.open({
			content : '你确定要删除吗?',
			btn : [ '确认', '取消' ],
			yes : function(index, layero) {
				location.href = "userServlet?method=del&result=list&id="+id;
			},
			btn2 : function(index, layero) {

			},
			cancel : function() {
				//右上角关闭回调  
			}
		});
	}
</script>
<c:if test="${param.msg.equals('1') }">
		<script type="text/javascript">
			$(function() {
				layer.alert('操作成功', {
					skin : 'layui-layer-lan' //样式类名
					,
					closeBtn : 0
				});

			})
		</script>
	</c:if>
	<c:if test="${param.msg.equals('2') }">
		<script type="text/javascript">
			$(function() {
				layer.alert('操作失败', {
					skin : 'layui-layer-lan' //样式类名
					,
					closeBtn : 0
				});

			})
		</script>
	</c:if>
</body>
</html>