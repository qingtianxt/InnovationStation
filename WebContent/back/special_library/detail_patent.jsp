<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>专利详情页面</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/sl.css">

<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.12.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.validate.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/layer/layer.js"></script>
</head>
<body>
<div class="nav">
	您现在的位置：
	<ul class="nav-ul">
		<li class="nav-li"><a href="#">专题专利</a></li>
		<li class="nav-li"><a href="javascript:back()">专利管理</a></li>
		<li class="nav-li"><a href="#">专利详情</a></li>
	</ul>
	</div>
<table class="table">
	<caption>专利详情</caption>
			<tr>
				<td width="100" class="title"><div align="center">专利号</div></td>
				
				<td width="166" >${requestScope.patent.zlh }</td>
				<td width="100" class="title"><div align="center">申请日期</div></td>
				<td width="166">${requestScope.patent.sqrq }
			</tr>
			<tr>
				<td class="title"><div align="center">公开（公告）号</div></td>
				<td width="166">${requestScope.patent.gkh }</td>
				<td width="100" class="title"><div align="center">公开（公告）日</div></td>
				<td width="166">${requestScope.patent.gkr }
				</td>
			</tr>
			<tr>
				<td class="title"><div align="center" >发明名称</div></td>
				<td>${requestScope.patent.fmmc }</td>
				<td class="title"><div align="center">IPC分类号</div></td>
				<td>${requestScope.patent.ipc_flh }</td>
			</tr>
			<tr>
				<td class="title"><div align="center">发明人</div></td>
				<td>${requestScope.patent.fmr }</td>
				<td class="title"><div align="center">申请人</div></td>
				<td>${requestScope.patent.sqr }
				</td>
			</tr>
			<tr>
				<td class="title"><div align="center">优先权日</div></td>
				<td>${requestScope.patent.yxqr }</td>
				<td class="title"><div align="center">优先权号</div></td>
				<td>${requestScope.patent.yxqh }</td>
			</tr>
			<tr>
				<td class="title"><div align="center">法律状态</div></td>
				<td>${requestScope.patent.flzt }</td>
				<td class="title"><div align="center">申请人地址</div></td>
				<td>${requestScope.patent.sqrdz }</td>
			</tr>
			<tr>
				<td colspan="4" class="title"><div align="center">摘要</div></td>
			</tr>
			<tr>
			
				<td height="23" colspan="4">${requestScope.patent.zy }
				</td>
			</tr>
		</table>
	<div align="center">
		<br><br><input type="button" value="确定" onclick="back()">
		<input type="button" value="修改" onclick="javascript:edit(${requestScope.patent.id})">
		<input type="button" value="删除" onclick="javascript:del(${requestScope.id})">
		<script type="text/javascript">
			function back(){
				url="${pageContext.request.contextPath}/back/patent/patentServlet?method=list&result=list&msg=7";
				location.href = url;
			}
			function edit(id){
				location.href="patentServlet?method=getPatent&result=edit&id="+id;
			}
			function del(id){
				layer.open({
					content : '您确定要删除此条专利吗？',
					btn : [ '确认', '取消' ],
					yes : function(index, layero) {
						location.href = "patentServlet?method=del&result=list&id="
							+ id;
					},
					btn2 : function(index, layero) {

					},
					cancel : function() {
						//右上角关闭回调  
					}
				});
			}
		</script>
	</div>
</body>
</html>