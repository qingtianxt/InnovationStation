<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>河北省创新驿站</title>
</head>
<frameset rows="125,*,75" cols="*" frameborder="no" border="0"
	framespacing="0" bordercolor="#000000">
	<frame src="${pageContext.request.contextPath }/back/top1.jsp" name="topFrame" frameborder="no" scrolling="no"
		id="topFrame" title="topFrame" />
	<frameset name="myFrame" cols="260,*" frameborder="no" border="0"
		framespacing="0">
		<frame src="${pageContext.request.contextPath }/back/left.jsp" name="leftFrame"  scrolling="yes"
			style="padding-left: 0px; padding-top: 0px;" frameborder="no"
			scrolling="no" noresize="noresize" id="leftFrame" title="leftFrame" />
		<frameset name="myFrame" rows="40,*" frameborder="no" border="0"
			framespacing="0">
			<frame src="${pageContext.request.contextPath }/back/top2.jsp" name="navFrame" frameborder="no" id="navFrame"
				style="margin-top: 0px;" title="manFrame" />
			<frame src="${pageContext.request.contextPath }/back/welcome.jsp" name="right" frameborder="no" id="manFrame"
				style="padding-left: 2px" title="manFrame" />
		</frameset>
	</frameset>
	<frame src="${pageContext.request.contextPath }/back/down.jsp" name="topFrame" frameborder="no" scrolling="no"
		id="topFrame" title="topFrame" />
</frameset>
</html>
