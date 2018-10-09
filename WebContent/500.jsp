<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>错误</title>
<style type="text/css">
	:root{
		background-image: url("${pageContext.request.contextPath}/images/500back.png");
	}
	.image-div{
		position: absolute;
		top:35%;
		left:50%;
		margin-top:-127px;
		margin-left:-319px;
		width: 639px;
		min-height: 254px;
		font-size: 16px;
		font-family: "微软雅黑";
	}
	.prompt{
		width:35%;
		margin:20px auto 0;
		font-weight: 150%;
	}
	.back{
		width:40%;
		margin:20px auto 0;
	}
	.back a{
		padding:5px 15px 3px;
		border: 1px solid gray;
		width: 100px;
		text-align: center;
		border-radius: 5px;
		font-weight: 150%;
		box-shadow: 0 0 2px #78A8B6 2px;
		color:#78A8B6;
		text-decoration: none;
	}
	.back a:FIRST-CHILD{
		background-color: #78A8B6;
		color: white;
	}
	
	.prompt{
		color:#78A8B6;
	}
</style>
</head>
<body>
<div class="wrapper">
	<div class="image-div">
		<img alt="" src="${pageContext.request.contextPath}/images/500.png" >
		<div class="prompt">您还可以:</div>
		<div class="back"><a href="${pageContext.request.contextPath}/front/index.jsp" style="">返回首页</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:back()">返回上一步</a></div>
		<div class="prompt">
			<details>
				<summary>查看详情</summary>
				<p>${pageContext.exception.message}</p>
			</details>
		</div>
	</div>
</div>
</body>
<script type="text/javascript">
	function back(){
		history.back();
	}
</script>
</html>