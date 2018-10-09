<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style type="text/css">
body {
	margin: 0;
	padding: 0;
	font-size: 12px;
	font-family: "Microsoft Yahei", Verdana, Arial, Helvetica, sans-serif
}

.leftMenu {
 	min-width: 220px; 
/* 	width: 268px; */
	margin: 40px auto 0 auto;
}

.menu {
	border: #bdd7f2 1px solid;
	border-top: #0080c4 4px solid;
	border-bottom: #0080c4 4px solid;
	background: #f4f9ff repeat-y right;
}

.menu .ListTitle {
	border-bottom: 1px #98c9ee solid;
	display: block;
	text-align: center;
	/*position: relative;*/
	height: 38px;
	line-height: 38px;
	cursor: pointer;
	/*+min-width:220px;*/
	background: #C0E4FA; +
	width: 100%;
}

.ListTitlePanel {
	position: relative;
}

.leftbgbt {
	position: absolute;
	background: no-repeat;
	width: 11px;
	height: 52px;
	left: -11px;
	top: -4px;
}
/*.leftbgbt {
	float:left;
	background: no-repeat;
	width: 11px;
	height: 52px;
	left: 0px;
	top: 0px;
	zoom:1;
	z-index:200px;
}
*/
.leftbgbt2 {
	position: absolute;
	background: no-repeat;
	width: 11px;
	height: 48px;
	left: -11px;
	top: -1px;
}

.menuList {
	display: block; //
	此元素显示为块状元素 height: auto;
}

.menuList div {
	height: 28px;
	line-height: 24px;
	border-bottom: 1px #98c9ee dotted;
}

.menuList div a {
	display: block;
	background: #E5F1F8;
	line-height: 28px;
	height: 28px;
	text-align: center;
	color: #185697;
	text-decoration: none;
}

.menuList div a:hover {
	color: #f30;
	background: #0080c4;
	color: #fff;
}
.active {
	color: #f30;
	background: #0080c4;
	color: #fff;
}
.xitong {
	width: 270px;
}
.menu-title{
	color:white; 
	background-image: url('${pageContext.request.contextPath }/images/xitong.png'); 
	background-repeat:repeat;
	text-align: center;
}
.menu-title h1{
	margin:0;
	padding:10px 20px;
}
</style>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-1.4.js"></script>
<script type="text/javascript">
	$(document).ready(
			function() {
				var menuParent = $('.menu > .ListTitlePanel > div');//获取menu下的父层的DIV
				var menuList = $('.menuList');
				$('.menu > .menuParent > .ListTitlePanel > .ListTitle').each(
						function(i) {//获取列表的大标题并遍历
							$(this).click(function() {
								if ($(menuList[i]).css('display') == 'none') {
									$(menuList[i]).slideDown(300);//点击的时候如果是slideDown就让链表不显示内容
								} else {
									$(menuList[i]).slideUp(300);
								}
							});
						});
				$(".menuList").hide();
				
			});
</script>
<c:set scope="page" value="${ f:split(session_user.role.power,',') }" var="power"></c:set>
</head>
<body style="margin-top: -40px;">

	<div class="leftMenu">
		<div class="menu-title" >
			<h1>系统菜单</h1>
		</div>
		<div class="menu">
			<c:if test="${power[0]==1 }">
				<div class="menuParent">
					<div class="ListTitlePanel">
						<div class="ListTitle">
							<strong>新闻公告</strong>
							<div class="leftbgbt2"></div>
						</div>
					</div>
					<div class="menuList">
					<c:if test="${power[1]==1 }">
						<div>
							<a target="right"
								href="${pageContext.request.contextPath }/back/news/add_photo_news.jsp">图片新闻</a>
						</div>
					</c:if>
					<c:if test="${power[2]==1 }">
						<div>
							<a target="right"
								href="${pageContext.request.contextPath }/back/news/newsPhotoServlet?method=list&result=list">图片新闻管理</a>
						</div>
					</c:if>
					<c:if test="${power[3]==1 }">
						<div>
							<a target="right"
								href="${pageContext.request.contextPath }/back/news/add_news.jsp">添加信息</a>
						</div>
					</c:if>
					<c:if test="${power[4]==1 }">
						<div>
							<a target="right"
								href="${pageContext.request.contextPath }/back/news/newsServlet?method=list&result=list">信息管理</a>
						</div>
					</c:if>
					</div>
				</div>
			</c:if>
			<c:if test="${power[5]==1 }">
				<div class="menuParent">
					<div class="ListTitlePanel">
						<div class="ListTitle">
							<strong>企业需求</strong>
							<div class="leftbgbt"></div>
						</div>
					</div>
					<div class="menuList">
					<c:if test="${power[6]==1 }">
						<div>
							<a
								href="${pageContext.request.contextPath}/back/jsxq/qyxq?method=addUI"
								target="right">添加信息</a>
						</div>
					</c:if>
					<c:if test="${power[7]==1 }">
						<div>
							<a
								href="${pageContext.request.contextPath}/back/jsxq/qyxq?method=getShList&currentPage=1"
								target="right">信息审核</a>
						</div>
					</c:if>
					<c:if test="${power[8]==1 }">
						<div>
							<a
								href="${pageContext.request.contextPath}/back/jsxq/qyxq?method=getGlList&currentPage=1"
								target="right">信息管理</a>
						</div>
					</c:if>
					</div>
				</div>
			</c:if>
			
			<c:if test="${power[9]==1 }">
				<div class="menuParent">
					<div class="ListTitlePanel">
						<div class="ListTitle">
							<strong>技术供给</strong>
							<div class="leftbgbt2"></div>
						</div>
					</div>
					<div class="menuList">
					<c:if test="${power[10]==1 }">
						<div>
							<a target="right"
								href="${pageContext.request.contextPath }/back/technology_supply/add_supply.jsp">添加信息</a>
						</div>
					</c:if>
					<c:if test="${power[11]==1 }">
						<div>
							<a target="right"
								href="${pageContext.request.contextPath }/back/technology_supply/supplyServlet?method=list&result=list&status=sh%20in%20(-1,0)">信息审核</a>
						</div>
					</c:if>
					<c:if test="${power[12]==1 }">
						<div>
							<a target="right"
								href="${pageContext.request.contextPath }/back/technology_supply/supplyServlet?method=list&result=list2&status=sh%20in%20(1)">信息管理</a>
						</div>
					</c:if>
					</div>
				</div>
			</c:if>

			
			<c:if test="${power[13]==1 }">
				<div class="menuParent">
					<div class="ListTitlePanel">
						<div class="ListTitle">
							<strong>科技成果</strong>
							<div class="leftbgbt"></div>
						</div>
					</div>
					<div class="menuList">
					<c:if test="${power[14]==1 }">
						<div>
							<a
								href="${pageContext.request.contextPath}/back/kjcg/cgzhxmServlet?method=cgzhxmUI"
								target="right">成果转化项目</a>
						</div>
					</c:if>
					<c:if test="${power[15]==1 }">
						<div>
							<a
								href="${pageContext.request.contextPath}/back/kjcg/back_cgal.jsp"
								target="right">成功案例</a>
						</div>
					</c:if>
					<c:if test="${power[16]==1 }">
						<div>
							<a
								href="${pageContext.request.contextPath}/back/kjcg/kjcgServlet?method=getList&currentPage=1"
								target="right">信息管理</a>
						</div>
					</c:if>
					</div>
				</div>
			</c:if>
			<c:if test="${power[17]==1 }">
				<div class="menuParent">
					<div class="ListTitlePanel">
						<div class="ListTitle">
							<strong>专题专利</strong>
							<div class="leftbgbt2"></div>
						</div>
					</div>
					<div class="menuList">
					<c:if test="${power[18]==1 }">
						<div>
							<a target="right"
								href="${pageContext.request.contextPath }/back/special_library/add_lib.jsp">添加专题库</a>
						</div>
					</c:if>
					<c:if test="${power[19]==1 }">
						<div>
							<a target="right"
								href="${pageContext.request.contextPath }/back/special_library/libraryServlet?method=list&result=list">专题库管理</a>
						</div>
					</c:if>
					<c:if test="${power[20]==1 }">
						<div>
							<a target="right"
								href="${pageContext.request.contextPath }/back/special_library/patentServlet?method=list&result=list">专利管理</a>
						</div>
					</c:if>
					</div>
				</div>
			</c:if>
			<c:if test="${power[21]==1 }">
				<div class="menuParent">
					<div class="ListTitlePanel">
						<div class="ListTitle">
							<strong>合作站点</strong>
							<div class="leftbgbt"></div>
						</div>
					</div>
					<div class="menuList">
					<c:if test="${power[22]==1 }">
						<div>
							<a target="right"
								href="${pageContext.request.contextPath }/back/cooperation_site/add_site.jsp">添加信息
							</a>
						</div>
					</c:if>
					<c:if test="${power[23]==1 }">
						<div>
							<a target="right"
								href="${pageContext.request.contextPath }/back/cooperation_site/coopSiteServlet?method=list&result=list">信息管理</a>
						</div>
					</c:if>
					</div>
				</div>
			</c:if>
			<c:if test="${power[24]==1 }">
				<div class="menuParent">
					<div class="ListTitlePanel">
						<div class="ListTitle">
							<strong>专家信息</strong>
							<div class="leftbgbt"></div>
						</div>
					</div>
					<div class="menuList">
					<c:if test="${power[25]==1 }">
						<div>
							<a
								href="${pageContext.request.contextPath}/back/zjxx/back_zjxx.jsp"
								target="right">添加信息</a>
						</div>
					</c:if>
					<c:if test="${power[26]==1 }">
						<div>
							<a
								href="${pageContext.request.contextPath }/back/zjxx/zjxxServlet?method=getList&currentPage=1"
								target="right">信息管理</a>
						</div>
					</c:if>
					</div>
				</div>
			</c:if>
			<c:if test="${power[27]==1 }">
				<div class="menuParent">
					<div class="ListTitlePanel">
						<div class="ListTitle">
							<strong>政策法规</strong>
							<div class="leftbgbt"></div>
						</div>
					</div>
					<div class="menuList">
					<c:if test="${power[28]==1 }">
						<div>
							<a
								href="${pageContext.request.contextPath}/back/zcfg/zcfgServlet?method=addUI"
								target="right">添加信息</a>
						</div>
					</c:if>
					<c:if test="${power[29]==1 }">
						<div>
							<a
								href="${pageContext.request.contextPath }/back/zcfg/zcfgServlet?method=getList&currentPage=1"
								target="right">信息管理</a>
						</div>
					</c:if>
					</div>
				</div>
			</c:if>

			


			<c:if test="${power[30]==1 }">
				<div class="menuParent">
					<div class="ListTitlePanel">
						<div class="ListTitle">
							<strong>用户管理</strong>
							<div class="leftbgbt"></div>
						</div>
					</div>
					<div class="menuList">
					<c:if test="${power[31]==1 }">
						<div>
							<a target="right"
								href="${pageContext.request.contextPath }/back/user/modifyPwd.jsp">修改密码
							</a>
						</div>
					</c:if>
					<c:if test="${power[32]==1 }">
						<div>
							<a target="right"
								href="${pageContext.request.contextPath }/back/user/userServlet?method=list&result=list">用户管理</a>
						</div>
					</c:if>
					<c:if test="${power[33]==1 }">
						<div>
							<a target="right"
								href="${pageContext.request.contextPath }/back/role/roleServlet?method=list&result=list">角色管理</a>
						</div>
					</c:if>
					<c:if test="${power[34]==1 }">
						<div>
							<a target="right"
								href="${pageContext.request.contextPath }/back/disclaimer/add.jsp">免责声明</a>
						</div>
					</c:if>
					</div>
				</div>
			</c:if>
			<c:if test="${power[35]==1 }">
				<div class="menuParent">
					<div class="ListTitlePanel">
						<div class="ListTitle">
							<strong>信息检索</strong>
							<div class="leftbgbt2"></div>
						</div>
					</div>
					<div class="menuList">
					<c:if test="${power[36]==1 }">
						<div>
							<a target="right"
								href="${pageContext.request.contextPath}/back/xxjs/daohang.jsp">信息检索</a>
						</div>
					</c:if>
					</div>
				</div>
			</c:if>
		</div>
	</div>
	<div style="text-align: center;"></div>
</body>
</html>