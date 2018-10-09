<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.12.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.validate.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/layer/layer.js"></script>
<%-- <script type="text/javascript" src="${pageContext.request.contextPath }/js/global.js"></script> --%>
<style>
	:root{
		background-color: #ddf2fc
	}
	input[type='number'],select{
		width:100%;
		font-size:16px;
		padding:3px;
		box-sizing: border-box;
	}
	table{
		border-collapse: collapse;
		table-layout: fixed;
	}
	td,th{
		white-space: nowrap;
		overflow: hidden;
		padding:3px 15px;
	}
	
	div.file-div{
		width:80%;
		margin:15px auto;
		padding:20px;
	}
	div.format-div{
		width:80%;
		margin: auto;
		padding:20px;
		font-size:18px;
		line-height: 160%;
	}
	ul#sheet-nav{
		margin:0;
		padding:0;
		list-style: none;
		display: inline-block;
	}
	li{
		display: inline-block;
		background-color: #ffddee;
		padding:10px 15px 5px;
		font-size: 18px;
		border-right: 3px #bbffaa solid;
	}
	li:LAST-CHILD{
		border-right: 0px;
	}
	ul#sheet-nav a{
		color: blue;
		text-decoration: none;
	}
	li.active{
		background-color: #bbffaa;
	}
	#upload{
		margin:2px 5px 0px 20px;
		padding:5px 15px;
		font-size: 18px;
		background-color: #ffddcc;
	}
</style>
<script type="text/javascript">
$(function(){
	// 添加验证方法，检查上传文件是否是Excel文件
	$.validator.addMethod("isXlsFile",function(value,element){
		if(value=="")
			return true;
		var index = value.lastIndexOf(".");
		if(index<0)
			return false;
		return value.substr(index)==".xls";
	},"不支持的文件格式");
	$("#fileUploadform").validate({
		focusCleanup:false,		
		rules:{
			data:{required:true,isXlsFile:true}
		},messages:{
			data:{required:"请选择文件",isXlsFile:"暂时只支持Microsoft Office Excel 97-2003格式的Excel文件"}
		},errorPlacement:function(error,element){
			error.css("color","red").appendTo(element.parent().siblings('span'));
		}
	});
})
	
</script>
<c:if test="${! empty param.msg }">
<script type="text/javascript">
	
	layer.open({
		content:"${param.msg}", 		
		  skin: 'layui-layer-lan' //样式类名
		  ,btn:['确定'],
		  btn1:function(index,layero){
			  layer.close(index);
		  }
		});
</script>
</c:if>
<title>从Excel表格中导入专利信息</title>
</head>
<body>
<div>
<!-- <div class="nav"> -->
<!-- 	您现在的位置： -->
<!-- 	<ul class="nav-ul"> -->
<!-- 		<li class="nav-li"><a href="#">专题专利</a></li> -->
<!-- 		<li class="nav-li"><a href="javascript:back()">专利库管理</a></li> -->
<!-- 		<li class="nav-li"><a href="#">发布</a></li> -->
<!-- 	</ul> -->
<!-- 	</div> -->
	<div class="file-div">
		<form enctype="multipart/form-data" action="patentServlet?method=import" method="post" id="fileUploadform">
			<input type="hidden" name="ztzlk_id" value="${param.id }">
			<label>请选择文件:&nbsp;&nbsp;<input type="file" name="data"></label><label><input type="submit" value="提交"></label>&nbsp;&nbsp;<span></span>
		</form>
	</div>
	<c:if test="${!empty excel2 }">
	<div class="format-div">
		<form action="patentServlet?method=import2&result=import" method="post" onsubmit="return validate(this)">
			<input type="hidden" name="path" value="${excel2.path }">
			<input type="hidden" name="ztzlk_id" value="${excel2.ztzlk_id }">
			<input type="hidden" name="username" value="${sessionScope.session_user.username}">
			<div id="adjust">
				<ul id="sheet-nav">
					<c:forEach items="${excel2.sheets}" var="sheet" varStatus="status">
						<li id="li_${sheet.name}" <c:if test="${status.index==0 }">class="active"</c:if>><a href="javascript:showTable('${sheet.name}')">${sheet.name}</a>
						<%--<label><input name="sheet" type="checkbox" value="${sheet.name}" onclick="showTable(this.value)">${sheet.name}</label><br> --%>
					</c:forEach>
				</ul>
				<Input id="upload" type="submit" value="确定" >
				<c:forEach items="${excel2.sheets }" var="sheet" varStatus="status">
					<table class='' style="width:600px;display: none" border=1 id="sheet_${sheet.name}">
<%-- 						<caption>${sheet.name}</caption> --%>
						<tr>
							<td style="font-weight: bold;">工作簿名称:</td>
							<td>${sheet.name}</td>
							<td style="font-weight:bold;">是否添加</td>
							<td><label><input name="sheet" type="checkbox" value="${sheet.name}" onclick="showTable(this.value)" <c:if test="${status.index==0 }">checked="checked"</c:if>></label></td>
						</tr>
						<tr>
							<td ><label for="startRows">数据开始行</label></td>
							<td class='input' ><input type="number" value="2" min="1" name="start_${sheet.name }" onkeypress="return isNum()"></td>
							<td ><label for="startRows">数据结束行</label></td>
							<td class='input' ><input type="number" value="" min="1" name="end_${sheet.name}" onkeypress="return isNum()"></td>
						</tr>
						<tr>
							<th colspan="2">目标列名称</th><th colspan="2">数据源列名称</th>
						</tr>
						<tr>
							<td colspan="2"><label for="zlh_${sheet.name}">专利号</label></td>
							<td class='input' colspan="2"><select name="zlh_${sheet.name}"></select></td>
						</tr>
						<tr>
							<td colspan="2"><label for="sqrq_${sheet.name}">申请日期</label></td>
							<td class='input'colspan="2"><select name="sqrq_${sheet.name}"></select></td>
						</tr>
						<tr>
							<td colspan="2"><label for="gkh_${sheet.name}">公开号</label></td>
							<td class='input' colspan="2"><select name="gkh_${sheet.name}"></select></td>
						</tr>
						<tr>
							<td colspan="2"><label for="gkr_${sheet.name}">公开日</label></td>
							<td class='input' colspan="2"><select name="gkr_${sheet.name}"></select></td>
						</tr>
						<tr>
							<td colspan="2"><label for="fmmc_${sheet.name}">发明名称</label></td>
							<td colspan="2"><select name="fmmc_${sheet.name}"></select>
						</tr>
						<tr>
							<td colspan="2"><label for="ipc_flh_${sheet.name}">IPC分类号</label></td>
							<td colspan="2"><select name="ipc_flh_${sheet.name}"></select>
						</tr>		
						<tr>
							<td colspan="2"><label for="fmr_${sheet.name}">发明人</label></td>
							<td colspan="2"><select name="fmr_${sheet.name}"></select>
						</tr>
						<tr>
							<td colspan="2"><label for="sqr_${sheet.name}">申请人</label></td>
							<td colspan="2"><select name="sqr_${sheet.name}"></select>
						</tr>		
						<tr>
							<td colspan="2"><label for="yxqr_${sheet.name}">优先权日</label></td>
							<td colspan="2"><select name="yxqr_${sheet.name}"></select>
						</tr>
						<tr>
							<td colspan="2"><label for="yxqh_${sheet.name}">优先权号</label></td>
							<td colspan="2"><select name="yxqh_${sheet.name}"></select>
						</tr>		
						<tr>
							<td colspan="2"><label for="flzt_${sheet.name}">法律状态</label></td>
							<td colspan="2"><select name="flzt_${sheet.name}"></select>
						</tr>
						<tr>
							<td colspan="2"><label for="sqrdz_${sheet.name}">申请人地址</label></td>
							<td colspan="2"><select name="sqrdz_${sheet.name}"></select>
						</tr>	
						<tr>
							<td colspan="2"><label for="zy_${sheet.name}">摘要</label></td>
							<td colspan="2"><select name="zy_${sheet.name}"></select></td>
						</tr>	
						
					</table>
					<script type="text/javascript">
						var $sel = $("#sheet_${sheet.name} select")
						$sel.html("<c:forEach items='${sheet.handNames}' var='content' varStatus='status'><option value='${status.index}'><c:if test='${content.length()<=15}'>${content}</c:if><c:if test='${content.length()>15}'>${fn:substring('content',0,15)}...</c:if></c:forEach><option value='-1'></option>");
						for(var i = 0; i < $sel.length; i++){
							$sel[i].selectedIndex = i;
						}
					</script>
				</c:forEach>	
			</div>
			
		</form>
	</div>
	</c:if>
</div>
</body>
<script type="text/javascript">
function isNum(e) {
	var s;
	if (window.event) {
		s = String.fromCharCode(window.event.keyCode);
	} else {
		s = String.fromCharCode(e.keyCode);
	}
	var reg = /[0-9]/;
	var f = reg.test(s);
	return f;
}
function checkContent(value){
	return /^[0-9]*$/.test(value)
}


function showTable(table){
	$("table[id^='sheet_']").hide();
	$("#sheet_"+table).show();
	$("li[id^='li_']").removeClass("active");
	$("#li_"+table).addClass("active");
}
// 首次显示第一个表格
var tables = document.getElementsByTagName("table")
if(tables!=null&&tables.length>0){
	tables[0].style.display = "block";
}

// 当表单提交时验证表单
function validate(form){
	var count = 0;
	for(var i in form.sheet){
		if(form.sheet[i].checked == true){
			count++;
		}
	}
	if(count<form.sheet.length){
		layer.open({content:"您有"+(form.sheet.length-count)+"个工作簿没有选择,是否提交",
			btn:["确定","取消"],
			btn1:function(index,layero){
				layer.close(index);
				form.submit();
			},btn2:function(index,layero){
				layer.close(index);
			}
		});
		return false;
	}
	return true;
}

function back(){
	var url = "${pageContext.request.contextPath}/back/special_library/libraryServlet?method=list&result=list&msg=7";
	location.href = url;
}
</script>
</html>