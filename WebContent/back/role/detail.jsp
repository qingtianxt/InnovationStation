<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>角色权限</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.12.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.validate.js"></script>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/sl.css">
</head>
<body bgcolor="#DDF2FC">
<div class="nav">
	您现在的位置：
	<ul class="nav-ul">
		<li class="nav-li"><a href="#">角色管理</a></li>
		<li class="nav-li"><a href="${pageContext.request.contextPath}/back/role/roleServlet?method=list&result=list&msg=7">角色列表</a></li>
		<li class="nav-li"><a href="#">编辑角色权限</a></li>
	</ul>
	</div>
<br>
<div class="table" align="center">


<table width="800" border="1">
	<caption>${role.roleName }</caption>
  <tr>
    <td width="174"><div align="center">权限名称</div></td>
    <td width="507"><div align="center">权限说明</div></td>
    <td width="97"><div align="center">是否赋予</div></td>
  </tr>
  </table>
					<!--   新闻公告 -->
    <form name="xwgg_formName" method="get"> 
  <table width="800" border="1">
  			  <tr>
			    <td colspan="2">新闻公告</td>
			    <td width="97"><div align="center">
			      <input type="checkbox" id="xwgg" name="alls" title="全选/取消全选"  onClick="selectAll('xwgg_formName','xwgg')"
			             disabled  checked/>
			    </div></td>
			  </tr> 
  <tr>
    <td width="174"><div align="center">图片新闻</div></td>
    <td width="507">网站首页图片新闻</td>
    <td><div align="center">
      <input type="checkbox" id="xwgg_tpxw" name="xwgg" title="选择/不选择"  disabled checked/>
    </div></td>
  </tr>
  <tr>
    <td width="174"><div align="center">图片新闻管理</div></td>
    <td width="507">对新添加的图片新闻进行管理</td>
    <td><div align="center">
      <input type="checkbox" id="xwgg_tpxw_gl" name="xwgg" title="选择/不选择"  disabled checked/>
    </div></td>
  </tr>
  <tr>
    <td><div align="center">添加信息</div></td>
    <td>添加新闻公告（国内新闻或通知公告）</td>
    <td><div align="center">
      <input type="checkbox" id="xwgg_tjxx" name="xwgg" title="选择/不选择"  disabled checked />
    </div></td>
  </tr>
  <tr>
    <td><div align="center">信息管理</div></td>
    <td>对添加的新闻进行管理</td>
    <td><div align="center">
      <input type="checkbox" id="xwgg_xxgl" name="xwgg" title="选择/不选择"  disabled checked/>
    </div></td>
  </tr>
  </table>
  </form>
						<!--   企业需求	  -->
	<form name="qyxq_formName" method="get"> 
  	<table width="800" border="1">
			  <tr>
			    <td colspan="2">企业需求</td>
			    <td width="97"><div align="center">
			      <input type="checkbox" id="qyxq" name="alls" title="全选/取消全选"   onClick="selectAll('qyxq_formName','qyxq')"
			    	   disabled  checked/>
			    </div></td>
			  </tr>
  <tr>
    <td width="174"><div align="center">添加信息</div></td>
    <td width="507">添加企业需求信息</td>
    <td><div align="center">
      <input type="checkbox" id="qyxq_tjxx" name="qyxq"  title="选择/不选择"  disabled checked/>
    </div></td>
  </tr>
  <tr>
    <td><div align="center">信息管理</div></td>
    <td>对用户输入的企业信息进行管理</td>
    <td><div align="center">
      <input type="checkbox" id="qyxq_xxgl" name="qyxq"  title="选择/不选择"  disabled checked/>
    </div></td>
  </tr>
  <tr>
    <td><div align="center">信息审核</div></td>
    <td>对用户输入的企业信息进行审核</td>
    <td><div align="center">
      <input type="checkbox" id="qyxq_xxsh" name="qyxq"  title="选择/不选择"  disabled checked/>
    </div></td>
  </tr>
  </table>
  </form>
					<!-- 	技术供给 -->
	<form name="jsgj_formName" method="get"> 
  	<table width="800" border="1">
			  <tr>
			    <td colspan="2">技术供给</td>
			    <td width="97"><div align="center">
			      <input type="checkbox" id="jsgj" name="alls"  title="全选/取消全选"   onClick="selectAll('jsgj_formName','jsgj')"
			       disabled checked/>
			    </div></td>
			  </tr>
  <tr>
    <td width="174"><div align="center">添加信息</div></td>
    <td width="507">添加新技术</td>
    <td><div align="center">
      <input type="checkbox" id="jsgj_tjxx" name="jsgj"  title="选择/不选择"  disabled checked/>
    </div></td>
  </tr>
  <tr>
    <td><div align="center">信息管理</div></td>
    <td>技术管理</td>
    <td><div align="center">
      <input type="checkbox" id="jsgj_xxgl" name="jsgj"  title="选择/不选择"  disabled checked/>
    </div></td>
  </tr>
  <tr>
    <td><div align="center">信息审核</div></td>
    <td>对技术进行技术审核</td>
    <td><div align="center">
      <input type="checkbox" id="jsgj_xxsh" name="jsgj"  title="选择/不选择"  disabled checked/>
    </div></td>
  </tr>
    </table>
  </form>
					<!-- 	科技成果 -->
	<form name="kjcg_formName" method="get"> 
  	<table width="800" border="1">
			  <tr>
			    <td colspan="2">科技成果</td>
			    <td width="97"><div align="center">
			      <input type="checkbox" id="kjcg" name="alls"  title="全选/取消全选"   onClick="selectAll('kjcg_formName','kjcg')"
			       disabled checked/>
			    </div></td>
			  </tr>
  <tr>
    <td width="174"><div align="center">成功转化项目</div></td>
    <td width="507">项目成功转化项目</td>
    <td><div align="center">
      <input type="checkbox" id="kjcg_cgzhxm" name="kjcg"  title="选择/不选择"  disabled checked/>
    </div></td>
  </tr>
  <tr>
    <td><div align="center">成功案例</div></td>
    <td>项目已经成功案例</td>
    <td><div align="center">
      <input type="checkbox" id="kjcg_cgal" name="kjcg"  title="选择/不选择"  disabled checked/>
    </div></td>
  </tr>
  <tr>
    <td><div align="center">信息管理</div></td>
    <td>以上信息的管理</td>
    <td><div align="center">
      <input type="checkbox" id="kjcg_xxgl" name="kjcg"  title="选择/不选择"  disabled checked />
    </div></td>
  </tr>
    </table>
  </form>
      					<!-- 	专题专利 -->
	<form name="ztzl_formName" method="get"> 
  	<table width="800" border="1">
			  <tr>
			    <td colspan="2">专题专利</td>
			    <td width="97"><div align="center">
			      <input type="checkbox" id="ztzl" name="alls"  title="全选/取消全选"   onClick="selectAll('ztzl_formName','ztzl')"
			       disabled checked/>
			    </div></td>
			  </tr>
  <tr>
    <td width="174"><div align="center">添加专题</div></td>
    <td width="507">添加新专题专利库</td>
    <td><div align="center">
      <input type="checkbox" id="ztzl_tjzt" name="ztzl"  title="选择/不选择" disabled checked/>
    </div></td>
  </tr>
  <tr>
    <td width="174"><div align="center">添加信息</div></td>
    <td width="507">添加新专利</td>
    <td><div align="center">
      <input type="checkbox" id="ztzl_tjxx" name="ztzl"  title="选择/不选择"  disabled checked/>
    </div></td>
  </tr>
  <tr>
    <td><div align="center">信息管理</div></td>
    <td>专利信息管理</td>
    <td><div align="center">
      <input type="checkbox" id="ztzl_xxgl" name="ztzl"  title="选择/不选择"  disabled checked/>
    </div></td>
  </tr>
    </table>
  </form>
							<!-- 	服务平台 -->
	<form name="fwpt_formName" method="get"> 
  	<table width="800" border="1">
			  <tr>
			    <td colspan="2">合作站点</td>
			    <td width="97"><div align="center">
			      <input type="checkbox" id="fwpt" name="alls"  title="全选/取消全选"   onClick="selectAll('fwpt_formName','fwpt')"
			       disabled checked/>
			    </div></td>
			  </tr>
 <tr>
    <td width="174"><div align="center">合作站点</div></td>
    <td width="507">添加与创新驿站有合作的网站平台</td>
    <td><div align="center">
      <input type="checkbox" id="fwpt_fwjg" name="fwpt"  title="选择/不选择" disabled checked/>
    </div></td>
  </tr>

  <tr>
    <td><div align="center">信息管理</div></td>
    <td>对以上服务机构平台进行管理</td>
    <td><div align="center">
      <input type="checkbox"  id="fwpt_xxgl" name="fwpt"  title="选择/不选择"  disabled checked/>
    </div></td>
  </tr>
    </table>
  </form>
						<!-- 	专家信息 -->
	<form name="zjxx_formName" method="get"> 
  	<table width="800" border="1">
			  <tr>
			    <td colspan="2">专家信息</td>
			    <td width="97"><div align="center">
			      <input type="checkbox" id="zjxx" name="alls"  title="全选/取消全选"   onClick="selectAll('zjxx_formName','zjxx')"
			    	   disabled  checked/>
			    </div></td>
			  </tr>
  <tr>
    <td width="174"><div align="center">添加信息</div></td>
    <td width="507">添加专家信息</td>
    <td><div align="center">
      <input type="checkbox" id="zjxx_tjxx" name="zjxx"  title="选择/不选择"  disabled checked/>
    </div></td>
  </tr>
  <tr>
    <td><div align="center">信息管理</div></td>
    <td>专家信息管理</td>
    <td><div align="center">
      <input type="checkbox" id="zjxx_xxgl" name="zjxx"  title="选择/不选择"  disabled checked/>
    </div></td>
  </tr>
    </table>
  </form>
						<!-- 	政策法规 -->
	<form name="zcfg_formName" method="get"> 
  	<table width="800" border="1">
			  <tr>
			    <td colspan="2">政策法规</td>
			    <td width="97"><div align="center">
			      <input type="checkbox" id="zcfg" name="alls"  title="全选/取消全选"   onClick="selectAll('zcfg_formName','zcfg')"
			    	   disabled  checked/>
			    </div></td>
			  </tr>
  <tr>
    <td width="174"><div align="center">添加信息</div></td>
    <td width="507">添加国家政策法规</td>
    <td><div align="center">
      <input type="checkbox" id="zcfg_tjxx" name="zcfg"  title="选择/不选择"  disabled checked/>
    </div></td>
  </tr>
  <tr>
    <td><div align="center">信息管理</div></td>
    <td>政策管理</td>
    <td><div align="center">
      <input type="checkbox" id="zcfg_xxgl" name="zcfg"  title="选择/不选择"  disabled checked/>
    </div></td>
  </tr>
    </table>
  </form>
					<!-- 	系统管理 -->
	<form name="xtgl_formName" method="get"> 
  	<table width="800" border="1">
				  <tr>
				    <td colspan="2">系统管理</td>
				    <td width="97"><div align="center">
				      <input type="checkbox" id="xtgl" name="alls"  title="全选/取消全选"   onClick="selectAll('xtgl_formName','xtgl')"
				    	   disabled  checked/>
				    </div></td>
				  </tr>
  <tr>
    <td width="174"><div align="center">修改密码</div></td>
    <td width="507">用户修改密码</td>
    <td><div align="center">
      <input type="checkbox" id="xtgl_xgmm" name="xtgl"  title="选择/不选择"  disabled checked/>
    </div></td>
  </tr>
  <tr>
    <td><div align="center">用户管理</div></td>
    <td>用户管理</td>
    <td><div align="center">
      <input type="checkbox" id="xtgl_yhgl" name="xtgl"  title="选择/不选择"  disabled checked/>
    </div></td>
  </tr>
  <tr>
    <td><div align="center">角色管理</div></td>
    <td>添加修改角色以及权限</td>
    <td><div align="center">
      <input type="checkbox" id="xtgl_jsgl" name="xtgl"  title="选择/不选择"  disabled checked/>
    </div></td>
  </tr>
   <tr>
    <td><div align="center">免责声明</div></td>
    <td>发布前台免责声明</td>
    <td><div align="center">
      <input type="checkbox" id="xtgl_mzsm" name="mzsm"  title="选择/不选择" disabled checked/>
    </div></td>
  </tr>
  </table>
  </form>

<br> 
<br><br><button type="button" onclick="back()">确定</button><br><br><br>
</div>

</body>
<script type="text/javascript">
	var power = "${role.power}";
	var array = power.split(",");
	var box = $("input[type='checkbox']");
	for(var i = 0; i < box.length; i++){
		box[i].checked = array[i]=="1";
	}
	function back(){
		var url = "${pageContext.request.contextPath}/back/role/roleServlet?method=list&result=list&msg=7";
		location.href = url;
	}
</script>
</html>