<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<div
			style="background: #3FA0F1; height: 30px; width: 170px; margin-top: 5px; margin-left: 2px"
			align="center">
			<font color="#ffffff" style="top: 4px; position: relative;">科技成果栏</font>
		</div>
		<div
			style="background: #c0e4fa; height: 30px; width: 170px; margin-top: 5px; margin-left: 2px; align: left">
			<img style="margin-left: 15px;" src="../images/tubiao.jpg" width="12px"
				height="12px;"> <a href="${pageContext.request.contextPath}/front/kjcg/kjcgFrontServlet?method=addUI">我要发布</a>
		</div>
		<div
			style="background: #c0e4fa; height: 30px; width: 170px; margin-top: 5px; margin-left: 2px; align: left">
			<img style="margin-left: 15px;" src="../images/tubiao.jpg" width="12px"
				height="12px;"> <a href="${pageContext.request.contextPath}/front/kjcg/kjcgFrontServlet?method=getListByUser&currentPage=1">我已发布</a>
		</div>
		<div
			style="background: #c0e4fa; height: 30px; width: 170px; margin-top: 5px; margin-left: 2px; align: left">
			<img style="margin-left: 15px;" src="../images/tubiao.jpg" width="12px"
				height="12px;"> <a href="${pageContext.request.contextPath}/front/kjcg/kjcgFrontServlet?method=getList&currentPage=1">已征集</a>
		</div>
	</div>
</body>
</html>