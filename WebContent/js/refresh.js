$(document).ready(function(){
	$("#shuaxin").click(function (){
		$("#shuaxin").attr("src","js/randCode.jsp?"+Math.random());
	});
});