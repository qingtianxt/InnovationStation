<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>角色管理</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.12.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.validate.js"></script>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/sl.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/lhgcalendar.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/lhgcore.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/lhgcalendar.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/layer/layer.js"></script>
</head>
<body bgcolor="#DDF2FC">
	<br>
	<br>
	<br>
	<form name="" method="get">
		<div class="table" align="center">
			<table style="width: 800px" border="1">
				<tr>
					<td width="170">新闻公告</td>
					<td colspan="2">
						<select name="id" id="id" style="width:98%;height:30px"></select>
					</td>
				</tr>
			</table>
			<table style="width: 800px" border="1">
				<tr>
					<td width="174"><div align="center">权限名称 34项权限</div></td>
					<td width="507"><div align="center">权限说明</div></td>
					<td width="97"><div align="center">是否赋予</div></td>
				</tr>
			</table>
			<!--   新闻公告 -->
				<table style="width: 800px" border="1">
					<tr>
						<td colspan="2">新闻公告</td>
						<td width="97"><div align="center">
								<input type="checkbox" id="xwgg" name="alls" title="全选/取消全选"
									onclick="selectNext('xwgg')" />
							</div></td>
					</tr>
					<tr>
						<td width="174"><div align="center">图片新闻</div></td>
						<td width="507">网站首页图片新闻</td>
						<td><div align="center">
								<input type="checkbox" id="xwgg_tpxw" name="xwgg" title="选择/不选择" />
							</div></td>
					</tr>
					<tr>
						<td width="174"><div align="center">图片新闻管理</div></td>
						<td width="507">对新添加的图片新闻进行管理</td>
						<td><div align="center">
								<input type="checkbox" id="xwgg_tpxw_gl" name="xwgg"
									title="选择/不选择" />
							</div></td>
					</tr>
					<tr>
						<td><div align="center">添加信息</div></td>
						<td>添加新闻公告（国内新闻或通知公告）</td>
						<td><div align="center">
								<input type="checkbox" id="xwgg_tjxx" name="xwgg" title="选择/不选择" />
							</div></td>
					</tr>
					<tr>
						<td><div align="center">信息管理</div></td>
						<td>对添加的新闻进行管理</td>
						<td><div align="center">
								<input type="checkbox" id="xwgg_xxgl" name="xwgg" title="选择/不选择" />
							</div></td>
					</tr>
				</table>
				
				<!--   企业需求	  -->
				<table style="width: 800px" border="1">
					<tr>
						<td colspan="2">企业需求</td>
						<td width="97"><div align="center">
								<input type="checkbox" id="qyxq" name="alls" title="全选/取消全选"
									onclick="selectNext('qyxq')" />
							</div></td>
					</tr>
					<tr>
						<td width="174"><div align="center">添加信息</div></td>
						<td width="507">添加企业需求信息</td>
						<td><div align="center">
								<input type="checkbox" id="qyxq_tjxx" name="qyxq" title="选择/不选择" />
							</div></td>
					</tr>
					<tr>
						<td><div align="center">信息管理</div></td>
						<td>对用户输入的企业信息进行管理</td>
						<td><div align="center">
								<input type="checkbox" id="qyxq_xxgl" name="qyxq" title="选择/不选择" />
							</div></td>
					</tr>
					<tr>
						<td><div align="center">信息审核</div></td>
						<td>对用户输入的企业信息进行审核</td>
						<td><div align="center">
								<input type="checkbox" id="qyxq_xxsh" name="qyxq" title="选择/不选择" />
							</div></td>
					</tr>
				</table>
				<!-- 	技术供给 -->
				<table style="width: 800px" border="1">
					<tr>
						<td colspan="2">技术供给</td>
						<td width="97"><div align="center">
								<input type="checkbox" id="jsgj" name="alls" title="全选/取消全选"
									onClick="selectNext('jsgj')" />
							</div></td>
					</tr>
					<tr>
						<td width="174"><div align="center">添加信息</div></td>
						<td width="507">添加新技术</td>
						<td><div align="center">
								<input type="checkbox" id="jsgj_tjxx" name="jsgj" title="选择/不选择" />
							</div></td>
					</tr>
					<tr>
						<td><div align="center">信息管理</div></td>
						<td>技术管理</td>
						<td><div align="center">
								<input type="checkbox" id="jsgj_xxgl" name="jsgj" title="选择/不选择" />
							</div></td>
					</tr>
					<tr>
						<td><div align="center">信息审核</div></td>
						<td>对技术进行技术审核</td>
						<td><div align="center">
								<input type="checkbox" id="jsgj_xxsh" name="jsgj" title="选择/不选择" />
							</div></td>
					</tr>
				</table>
				<!-- 	科技成果 -->
				<table style="width: 800px" border="1">
					<tr>
						<td colspan="2">科技成果</td>
						<td width="97"><div align="center">
								<input type="checkbox" id="kjcg" name="alls" title="全选/取消全选"
									onClick="selectNext('kjcg')" />
							</div></td>
					</tr>
					<tr>
						<td width="174"><div align="center">成功转化项目</div></td>
						<td width="507">项目成功转化项目</td>
						<td><div align="center">
								<input type="checkbox" id="kjcg_cgzhxm" name="kjcg"
									title="选择/不选择" />
							</div></td>
					</tr>
					<tr>
						<td><div align="center">成功案例</div></td>
						<td>项目已经成功案例</td>
						<td><div align="center">
								<input type="checkbox" id="kjcg_cgal" name="kjcg" title="选择/不选择" />
							</div></td>
					</tr>
					<tr>
						<td><div align="center">信息管理</div></td>
						<td>以上信息的管理</td>
						<td><div align="center">
								<input type="checkbox" id="kjcg_xxgl" name="kjcg" title="选择/不选择" />
							</div></td>
					</tr>
				</table>
				<!-- 	专题专利 -->
				<table style="width: 800px" border="1">
					<tr>
						<td colspan="2">专题专利</td>
						<td width="97"><div align="center">
								<input type="checkbox" id="ztzl" name="alls" title="全选/取消全选"
									onClick="selectNext('ztzl')" />
							</div></td>
					</tr>
					<tr>
						<td width="174"><div align="center">添加专题</div></td>
						<td width="507">添加新专题专利库</td>
						<td><div align="center">
								<input type="checkbox" id="ztzl_tjzt" name="ztzl" title="选择/不选择" />
							</div></td>
					</tr>
					<tr>
						<td width="174"><div align="center">添加信息</div></td>
						<td width="507">添加新专利</td>
						<td><div align="center">
								<input type="checkbox" id="ztzl_tjxx" name="ztzl" title="选择/不选择" />
							</div></td>
					</tr>
					<tr>
						<td><div align="center">信息管理</div></td>
						<td>专利信息管理</td>
						<td><div align="center">
								<input type="checkbox" id="ztzl_xxgl" name="ztzl" title="选择/不选择" />
							</div></td>
					</tr>
				</table>
				<!-- 	服务平台 -->
				<table style="width: 800px" border="1">
					<tr>
						<td colspan="2">合作站点</td>
						<td width="97"><div align="center">
								<input type="checkbox" id="fwpt" name="alls" title="全选/取消全选"
									onClick="selectNext('fwpt')" />
							</div></td>
					</tr>
					<tr>
						<td width="174"><div align="center">合作站点</div></td>
						<td width="507">添加与创新驿站有合作的网站平台</td>
						<td><div align="center">
								<input type="checkbox" id="fwpt_fwjg" name="fwpt" title="选择/不选择" />
							</div></td>
					</tr>
					<tr>
						<td><div align="center">信息管理</div></td>
						<td>对以上服务机构平台进行管理</td>
						<td><div align="center">
								<input type="checkbox" id="fwpt_xxgl" name="fwpt" title="选择/不选择" />
							</div></td>
					</tr>
				</table>
				<!-- 	专家信息 -->
				<table style="width: 800px" border="1">
					<tr>
						<td colspan="2">专家信息</td>
						<td width="97"><div align="center">
								<input type="checkbox" id="zjxx" name="alls" title="全选/取消全选"
									onClick="selectNext('zjxx')" />
							</div></td>
					</tr>
					<tr>
						<td width="174"><div align="center">添加信息</div></td>
						<td width="507">添加专家信息</td>
						<td><div align="center">
								<input type="checkbox" id="zjxx_tjxx" name="zjxx" title="选择/不选择" />
							</div></td>
					</tr>
					<tr>
						<td><div align="center">信息管理</div></td>
						<td>专家信息管理</td>
						<td><div align="center">
								<input type="checkbox" id="zjxx_xxgl" name="zjxx" title="选择/不选择" />
							</div></td>
					</tr>
				</table>
				<!-- 	政策法规 -->
				<table style="width: 800px" border="1">
					<tr>
						<td colspan="2">政策法规</td>
						<td width="97"><div align="center">
								<input type="checkbox" id="zcfg" name="alls" title="全选/取消全选"
									onClick="selectNext('zcfg')" />
							</div></td>
					</tr>
					<tr>
						<td width="174"><div align="center">添加信息</div></td>
						<td width="507">添加国家政策法规</td>
						<td><div align="center">
								<input type="checkbox" id="zcfg_tjxx" name="zcfg" title="选择/不选择" />
							</div></td>
					</tr>
					<tr>
						<td><div align="center">信息管理</div></td>
						<td>政策管理</td>
						<td><div align="center">
								<input type="checkbox" id="zcfg_xxgl" name="zcfg" title="选择/不选择" />
							</div></td>
					</tr>
				</table>
				<!-- 	系统管理 -->
				<table style="width: 800px" border="1">
					<tr>
						<td colspan="2">系统管理</td>
						<td width="97"><div align="center">
								<input type="checkbox" id="xtgl" name="alls" title="全选/取消全选"
									onClick="selectNext('xtgl')" />
							</div></td>
					</tr>
					<tr>
						<td width="174"><div align="center">修改密码</div></td>
						<td width="507">用户修改密码</td>
						<td><div align="center">
								<input type="checkbox" id="xtgl_xgmm" name="xtgl" title="选择/不选择" />
							</div></td>
					</tr>
					<tr>
						<td><div align="center">用户管理</div></td>
						<td>用户管理</td>
						<td><div align="center">
								<input type="checkbox" id="xtgl_yhgl" name="xtgl" title="选择/不选择" />
							</div></td>
					</tr>
					<tr>
						<td><div align="center">角色管理</div></td>
						<td>添加修改角色以及权限</td>
						<td><div align="center">
								<input type="checkbox" id="xtgl_jsgl" name="xtgl" title="选择/不选择" />
							</div></td>
					</tr>
					<tr>
						<td><div align="center">免责声明</div></td>
						<td>发布前台免责声明</td>
						<td><div align="center">
								<input type="checkbox" id="xtgl_mzsm" name="mzsm" title="选择/不选择" />
							</div></td>
					</tr>
				</table>
			<br> 
			<div align="center">
				<input type="button" onclick="upload()" value="提交" style="hight: 80px; width: 100px">
			</div>
		</div>
	</form>
	<br>
	<br>
	<br>
	<br>
	<br>

</body>
<script type="text/javascript">
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
			$option.appendTo($("select[name='id']"));
		}
		var $sel = $("select[name='id']");
		
		function fun(bb){
			var index = $sel[0].selectedIndex;
			var str = res[index]["power"];
			var array = str.split(",");
			var $inputs = $("input[type='checkbox']");
			for(var i = 0; i < $inputs.length; i++){
				$inputs[i].checked = array[i]=='1';
				if(bb==true){
					$inputs[i].disabled = true;
				}else{
					$inputs[i].disabled = false;
				}
			}
		}
		fun(true);
		// 设置当角色改变时显示选择对应角色的权限
		$sel.change(fun);
		
	}, "json");

	function selectNext(obj){
		var array = document.getElementsByName(obj);
		var title = document.getElementById(obj);
		if(title.checked){
			for(var i in array){
				array[i].checked = true;
			}
		}else{
			for(var i in array){
				array[i].checked = false;
			}
		}
	}
	function upload(){
		var str = "";
		var $inputs = $("input[type='checkbox']");
		for(var i = 0; i < $inputs.length; i++){
			if($inputs[i].checked)
				str+="1,";
			else
				str+="0,";
		}
		str += "1,1";
			
		$.post("roleServlet", {
				method : "add",
				result : "json",
				power : str,
				id : $("#id").val()
			}, function(value) {
				if(value==true){
					//alert(1);
					
					layer.open({
						content:"修改成功！",
						skin:'layui-layer-lan',
						btn:["确定"], 
						btn1:function(index,layero){
							layer.close(index);
							window.location.reload();
						}
					})
				}else{
					//alert(1);
					layer.open({
						content:"修改成功！",
						skin:'layui-layer-lan',
						btn:["确定"], 
						btn1:function(index,layero){
							layer.close(index);
							windows.location.reload();
						}
					})
				}
			}, "json");
	}
	
</script>
</html>