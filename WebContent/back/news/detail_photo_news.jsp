<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/sl.css">
<title>详细信息</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.12.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.validate.js"></script>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/lhgcalendar.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/lhgcore.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/lhgcalendar.js"></script>
<script type="text/javascript">
	$(function(){
		$("p").css("background-color","grba(255,255,255,0)");
	})
</script>
</head>
<body>
<div> 
<div class="nav">
	您现在的位置：
	<ul class="nav-ul">
		<li class="nav-li"><a href="#">新闻管理</a></li>
		<li class="nav-li"><a href="${pageContext.request.contextPath}/back/news/newsPhotoServlet?method=list&result=list&msg=7">图片新闻管理</a></li>
		<li class="nav-li"><a href="#">新闻详情</a></li>
	</ul>
</div>
		
<div style="margin:auto;text-align:center">
<img src="${pageContext.request.contextPath }${newsPhoto.image}" style="max-width: 600px;margin:auto;">
</div>
<br>
	<table width="680" align="center" class="table">
		<caption>新闻详情</caption>
	  <tr>
        <td width="75" height="25"><span class="STYLE4">发布人:</span></td>
        <td height="25" colspan="4">
       		${requestScope.newsPhoto.publisher }
        </td>
      </tr>
      <tr>
        <td width="75" height="25"><span class="STYLE4">发布时间:</span></td>
        <td height="25" colspan="4">
        	${requestScope.newsPhoto.time }
        </td>
      </tr>
      <tr>
        <td width="75" height="25"><span class="STYLE4">新闻标题:</span></td>
        <td height="25" colspan="4">
        	${requestScope.newsPhoto.title }
        </td>
      </tr>
      <tr>
        <td  height="25" colspan="5"><span class="STYLE4">新闻内容:</span></td>
      </tr>
      <tr>
        <td colspan="6">
        <label>
			${requestScope.newsPhoto.content }
        </label>
        </td>
      </tr>
<!--       <tr> -->
<!--         <td height="25" align="right"><label> -->
<!--           　　 -->
<!--         </label></td> -->
<!--         <td height="25"><label> -->
<!--         </label></td> -->
<!--       </tr> -->
    </table>
		<br><br><br><br>
		<div align="center">
			<input style="margin:auto" type="button" value="确定" onclick="back()" >
		</div>
		<br><br><br><br>
	<script type="text/javascript">
		function back(){
			location.href = "${pageContext.request.contextPath}/back/news/newsPhotoServlet?method=list&result=list&msg=7";
		}
	</script>
</div>
</body>
</html>