<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>	
<%@ taglib prefix="util" uri="http://localhost:8080/3-28/util" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/sl.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.12.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.validate.js"></script>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/lhgcalendar.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/lhgcore.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/lhgcalendar.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/layer/layer.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$.validator.addMethod("checkDate",function(value,element){
			try{
				var time1 = Date.parse($("#time1").val());
				var time2 = Date.parse($("#time2").val());
				if(isNaN(time1)||isNaN(time2))
					return true;
				var flag = time1 < time2;
				return flag;
			}catch(e){
				return true;
			}
		},"日期范围错误");	
		$("form").validate({
			rules:{
				qend:{checkDate:true}
			},
			errorPlacement:function(error,element){
				layer.open({
					content:error.html(),btn:["确定"],skin:"layui-layer-lan",btn1:function(index,layero){layer.close(index);element.val("");}
				});								
				
				return false;
			},onfocusout:false,onkeyup:false,onclick:false
		})
	});
</script>
<title>新闻公告</title>
</head>
<body style="background-color: #ffffff">
	<div>
		<div class="nav">
			您现在的位置：
			<ul class="nav-ul">
				<li class="nav-li"><a href="${pageContext.request.contextPath }/back/welcome.jsp">首页</a></li>
				<li class="nav-li"><a href="javascript:void(0)">找新闻</a></li>
			</ul>
		</div>
		<div><br>
			<form action="xxjsServlet?method=searchNews" method="post">
				<table class="query-table" >
					<tr>
						<td>发布人：</td>
						<td><input name="qpublisher" type="text" value="${newsPaging.qpublisher }" 
							id="publisher" width="" /></td>
						<td>标题：</td>
						<td><input name="qtitle" type="text" id="title" value="${newsPaging.qtitle }"></td>
					</tr>
<!-- 					<tr> -->
<!-- 						<td>内容：</td> -->
<%-- 						<td colspan="3"><input name="qcontent" type="text" value="${newsPaging.qcontent }" --%>
<!-- 							id="content" style="width: 370px" /></td> -->
<!-- 					</tr> -->
					<tr>
						<td>发布时间：</td>
						<td><input name="qstart" type="text" id="time1" value="${newsPaging.qstart }"
							onclick="J.calendar.get({id:'time1'});"
							readonly="readonly" /> 
						<td>截止时间：
						<td> <input name="qend" type="text" value="${newsPaging.qend }"
							id="time2"  onclick="J.calendar.get({id:'time2'});" readonly="readonly" /></td>
					</tr>
					<tr>
						<td>类型：</td>
						<td><select name="qtype" id="type">
								<option value="">请选择</option>
								<option value="国内新闻" <c:if test="${newsPaging.qtype.equals('国内新闻') }">selected="selected"</c:if>>国内新闻</option>
								<option value="通知公告" <c:if test="${newsPaging.qtype.equals('通知公告') }">selected="selected"</c:if>>通知公告</option>
						</select></td>
						<td align="right" colspan="2"><input type="submit" value="查询" id="sbtbtn" /></td>
					</tr>
				</table>
			</form>
		</div>
		<div>
			<br>
			<table id="datatable" width="100%" border="0" cellpadding="0"
				cellspacing="1" bgcolor="#a8c7ce" style="text-align:center" class="result-table">
				<tr>
					<td bgcolor="d3eaef" width="7%" height="20"><div
							align="center">序号</div></td>
					<td bgcolor="d3eaef" width="25%" height="20"><div
							align="center">新闻标题</div></td>
					<td bgcolor="d3eaef" width="10%" height="20"><div
							align="center">类型</div></td>
					<td bgcolor="d3eaef" width="5%" height="20"><div
							align="center">发布人</div></td>
					<td bgcolor="d3eaef" width="8%" height="20"><div
							align="center">发布时间</div></td>
					<td bgcolor="d3eaef" width="10%" height="20"><div
							align="center">基本操作</div></td>
				</tr>
				<c:forEach var="newsBean" items="${newsBeans }" varStatus="status">
					<tr>
						<td>${status.index+1+(newsPaging.currentPage-1)*newsPaging.pageSize }</td>
						<td style="text-align:left;padding-left:30px;">${newsBean.title }</td>
						<td>${newsBean.type }</td>
						<td>${newsBean.publisher }</td>
						<td>${newsBean.time }</td>
						<td><a href="xxjsServlet?method=getNewsById&id=${newsBean.id }">查看</a></td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="6"  bgcolor="d3eaef">
						<util:page pagingBean="${newsPaging }" css=""/>
					</td>
				</tr>
			</table>
		</div>
	</div>
	
</body>
</html>