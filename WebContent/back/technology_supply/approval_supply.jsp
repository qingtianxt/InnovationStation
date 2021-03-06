<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/sl.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.12.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.validate.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/layer/layer.js"></script>
<title>审核</title>
<style type="text/css">
	caption {
		font-size: xx-large;
		font-weight: bold;
		margin-bottom: 15px; 
}
	.label{
		font-weight: bold;
	}
	p{
		margin:25px 15px;
		text-indent: 2em;
	}
</style>
</head>
<body>
<div class="nav">
	您现在的位置：
	<ul class="nav-ul">
		<li class="nav-li"><a href="#">技术供给</a></li>
		<li class="nav-li"><a href="javascript:goBack()">信息审核</a></li>
		<li class="nav-li"><a href="#">审核</a></li>
	</ul>
</div>
	<div class="table" align="center" > 
			<table style="width:800px;height:549px;border-collapse: collapse;" border="1">
				<tr height="36">
					<td width="120" class="label">技术名称</td>
					<td width="260">${supply.mc }
					</td>
					<td width="120" class="label">技术水平</td>
					<td width="260">
						${supply.sp }
					</td>
				</tr>
				<tr height="36">
					<td ><div align="center" class="label">批准登记号</div></td>
					<td>
						${supply.djh }
					</td>
					<td><div align="center" class="label">应用状态</div></td>
					<td>
						${supply.yyzt }
					</td>
				</tr>
				<tr height="36">
					<td><div align="center" class="label">是否专利技术</div></td>
					<td>
						${supply.sfzl }
					</td>
					<td><div align="center" class="label">联系人</div></td>
					<td>
						${supply.lxr }
					</td>
				</tr>
				<tr height="36">
					<td><div align="center" class="label">专利号</div></td>
					<td>${supply.zlh }
					</td>
					<td><div align="center" class="label">联系人电话</div></td>
					<td>${supply.dh }
					</td>
				</tr>
				<tr height="36">
					<td><div align="center" class="label">所属高新技术类别</div></td>
					<td>${supply.jslb }
					</td>
					<td><div align="center" class="label">登记日期</div></td>
					<td>${supply.djrq }
					</td>
				</tr>
				<tr height="36">
					<td><div align="center" class="label">技术所处阶段</div></td>
					<td>${supply.jd }
					</td>
					<td><div align="center" class="label">年份</div></td>
					<td>${supply.nf }
					</td>
				</tr>
				<tr height="36">
					<td><div align="center" class="label">技术属性</div></td>
					<td>${supply.cgsx }
					</td>								
					<td><div align="center" class="label">专利状态</div></td>
					<td>${supply.zlzt }
					</td>
				</tr>
				<tr height="36">
					<td><div align="center" class="label">技术体现形式</div></td>
					<td colspan="3">
						${supply.xs }
					</td>
				</tr>
				<tr height="36">
					<td><div align="center" class="label">技术供给单位</div></td>
					<td colspan="3" align="left">${supply.dw }</td>
				</tr>
				<tr height="36">
					<td height="35"><div align="center" class="label">通讯地址</div></td>
					<td colspan="3"align="left">${supply.dz }</td>
				</tr>
				<tr height="36">
					<td><div align="center" class="label">关键词</div></td>
					
					<td colspan="3"align="left">${supply.gjc }</td>
				</tr>
				<tr>
					<td colspan="4" height="36" class="label">项目简介</td>
				</tr>
				<tr>
				
					<td height="107" colspan="4"><p>${supply.gbnr }</p>
					</td>
				</tr>
				<tr>
					<td colspan="4" height="36" class="label" style="text-align:center">审核意见</td>
				</tr>
				<tr>
					<td height="107" colspan="4" style="text-align:center">
					<form action="supplyServlet?method=update&result=list&id=${supply.id }" method="post">
						<textarea name="shyj" rows="10" cols="100" style="padding:15px; font-size: 14px"></textarea>
					</form>
					</td>
				</tr>
			</table>
			<br><br>
			<div style="text-align:center">
				<input type="button" onclick="sub('1')" value="通过">
				<input type="button" onclick="sub('-1')" value="不通过">
				<input onclick="goBack()" type="button" value="取消">
			</div>
			<br><br><br><br><br>
			<script type="text/javascript">
				function goBack(){
					layer.open({
						content : "您确定放弃修改吗？",
						btn:["确定","取消"],
						skin : "layui-layer-lan",
						btn1:function(index,layero){
							layer.close(index);							
							window.location.href="${pageContext.request.contextPath}/back/technology_supply/supplyServlet?method=list&result=list&msg=7";
						},
						btn2:function(index,layero){
							layer.close(index);
						}
					})
				}
				function sub(id){
					if(document.forms[0].shyj.value==""){
						layer.open({
							content : "请输入审核意见",							
							closeBtn:0,
							skin : "layui-layer-lan"
						})
						return ;
					}
					
					layer.open({
						content : "您确定保存修改吗？",
						btn:["确定","取消"],
						skin : "layui-layer-lan",
						btn1:function(index,layero){
							document.forms[0].action += "&sh="+id;
							document.forms[0].submit();
							layer.close(index);							
						},
						btn2:function(index,layero){
							layer.close(index);
						}
					})
				}
			</script>
</div>

</body>
</html>