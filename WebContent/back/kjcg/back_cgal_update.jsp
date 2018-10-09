<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>成功案例</title>
<!-- css  js文件链接 -->
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/lhgcore.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/lhgcalendar.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/layer/layer.js"></script>
<!-- 上传信息 -->
<!-- <script type="text/javascript" src="back_js/back_cgal_update.js"></script> -->
<!-- css  js文件链接 -->
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/kjcg/back_cgalUpdate.js"></script>
	<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/sl.css">
<style type="text/css">
.table {
	
}

.table tr {
	
}

.table tr td {
	text-align: left;
	height: 30px;
}

.table tr td input {
	height: 20px;
	width: 99%;
}
</style>


<body bgcolor="#DDF2FC">
<div class="nav">
			您现在的位置：
			<ul class="nav-ul">
			<li class="nav-li"><a href="javascript:void(0)">科技成果</a></li>
				<li class="nav-li"><a href="javascript:void(0)" onclick="back()">成果管理</a></li>
				<li class="nav-li"><a href="javascript:void(0)">修改成功案例</a></li>
			</ul>
		</div>
	<div class="table" align="center">
		<h1>成功案例库</h1>
		<form action="${pageContext.request.contextPath }/back/kjcg/cgalServlet?method=update" method="post" id="checkForm">
		<table width="800" border="1"  style="border-collapse: collapse;" class="form-table">
		  <tr>
		    <td width="100"><div align="center">案例名称&nbsp;&nbsp;<font style="color: red">*</font></div></td>
		    <td width="700">
		    	<input value="${cgalBean.mc }" id="almc" name="mc" type="text" />
	    		<input type="hidden" value="${cgalBean.id }"  id="id" name="id">
	    	</td>
	      </tr>
		  <tr>
		    <td><div align="center">所在地</div></td>
		    <td><input value="${cgalBean.szd }" id="szd" name="szd" type="text" /></td>
	      </tr>
		  <tr>
		    <td><div align="center">单位&nbsp;&nbsp;<font style="color: red">*</font></div></td>
		    <td><input value="${cgalBean.dw }" id="dw" name="dw" type="text" /></td>
	      </tr>
		  <tr>
		    <td><div align="center">关键词&nbsp;&nbsp;<font style="color: red">*</font></div></td>
		    <td><input value="${cgalBean.gjc }" id="gjc" name="gjc" type="text" /></td>
	      </tr>
		  <tr>
		    <td colspan="2"><div align="center">案例内容</div></td>
	      </tr>
		  <tr>
		    <td colspan="2">
					<textarea id="alnr" name="nr" style="width:820px;height:200px">${cgalBean.nr }</textarea>
			</td>
	      </tr>
	  </table>
		<br><br><br><br>
		<div align="center">
			<input id="upload" type="button" value="保存" style="hight: 80px; width: 100px">
		</div>
		</form>
</div>
	<br><br><br><br>
	<script type="text/javascript">
		function back(){
			location.href="${kjcgPagingBean.preUrl}"+"&msg=7"
		}
	</script>
</body>
</html>