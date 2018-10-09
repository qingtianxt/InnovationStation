<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div style="text-align: center"><img src="${pageContext.request.contextPath}/front/images/erji_01.jpg" width="1005" height="120" alt="">
</div>
<div class="nav" style="color:#ffffff;font-weight: bolid">
	<ul class="title" style="padding:0;margin:0">
            <li><a href="${pageContext.request.contextPath}/front/index.jsp" onclick='ccc()'>首&nbsp;&nbsp;页</a>
            <li><a href="${pageContext.request.contextPath}/front/news/newsServlet?method=list" onclick='ccc()'>新闻公告</a>
            <li><a href="${pageContext.request.contextPath }/front/qyxq/qyxqFrontServlet?method=getList&currentPage=1" onclick='ccc()'>企业需求</a>
            <li><a href="${pageContext.request.contextPath}/front/technology_supply/supplyServlet?method=list&result=front" onclick='ccc()'>技术供给</a>
            <li><a href="${pageContext.request.contextPath}/front/kjcg/kjcgFrontServlet?method=getList&currentPage=1" onclick='ccc()'>科技成果</a>
            <li><a href="${pageContext.request.contextPath}/front/special_library/libraryServlet?method=list" onclick='ccc()'>专题专利</a>
            <li><a href="${pageContext.request.contextPath}/front/zcfg/zcfgFrontServlet?method=getList&currentPage=1" onclick='ccc()'>政策法规</a>
            <li><a href="${pageContext.request.contextPath}/front/zjxx/zjxxFrontServlet?method=getFrontList&currentPage=1" onclick='ccc()'>专家信息</a>
            <li><a href="${pageContext.request.contextPath}/front/site/siteServlet?method=list" onclick='ccc()'>合作站点</a></li>
            <li><a href="${pageContext.request.contextPath}/front/fwpt/FwptServlet?method=getList&currentPage=1">服务平台</a></li>
   </ul>    
</div>
