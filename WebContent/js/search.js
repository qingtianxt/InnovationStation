
/************************************************************************/




/**
 * 获取表格的一行
 * @return {}
 */
function getRow(){
	return $("<tr style='height:30px'><td style='text-align:left; font-family:\'黑体\';padding-left:20px'><a target='_block' href=''></a></td></tr>");
}

/**
 * 获取分页标签
 * @param {} url
 * @param {} param
 * @param {} target
 * @param {} showField
 * @param {} preUrl
 * @return {}
 */
function getBottom(url,param,target,showField,preUrl){
	var $td = $("<td style='text-align:right;font-family:\'黑体\';padding-left:20px'></td>");
	var $span = $("<span></span>");
	$span.append("当前页:"+param.currentPage+"  ");
	$span.append("总页数:"+param.totalPage+"  ");
	$td.append($span);
	var $a1 = $("<a>  上一页   </a>");
	//var str1 = "{method:'search',currentPage:"+(param.currentPage-1)+",pageSize:"+(param.pageSize)+",key:'"+param.key+"',totalPage:"+param.totalPage+"}";
	var href1 = "javascript:getPage('"+url+"','search',"+(param.currentPage-1)+","+param.pageSize+",'"+param.key+"',"+param.totalPage+",'"+target+"','"+showField+"','"+preUrl+"')";
	$a1.attr("href",href1);
	//var str2 = "{method:'search',currentPage:"+(param.currentPage+1)+",pageSize:"+(param.pageSize)+",key:'"+param.key+"',totalPage:"+param.totalPage+"}";
	var $a2 = $("<a> 下一页    </a>");
	href1 = "javascript:getPage('"+url+"','search',"+(param.currentPage+1)+","+param.pageSize+",'"+param.key+"',"+param.totalPage+",'"+target+"','"+showField+"','"+preUrl+"')";
	$a2.attr("href",href1);
	$td.append($a1).append($a2);
	return $("<tr style='heigth:30px'></tr>").append($td);
}
/**
 * 查找函数
 * @param {} url 		资源访问路径
 * @param {} param		请求参数
 * @param {} target		结果显示元素
 * @param {} showField	请求结果中需要显示的字段
 * @param {} preUrl		查看详细情况访问路劲前缀
 */
function search(url,param,target,showField,preUrl){
	if(param.currentPage<=0)
		return;
	if(param.currentPage>param.totalPage)
		return;
	$.get(url, param, function(res) {
		param.totalPage = res.totalPage;
		param.totalCount = res.totalCount;
		var data = res['list'];
		$(target).empty();
		for(var i in data){
			var $tr = getRow();
			var $a = $tr.children("td").children("a");
			$a.attr("href",preUrl+"&id="+data[i].id+"&km="+data[i].km+"&mc="+data[i].mc);
			$a.attr("target","_blank");
			$a.html(data[i][showField]);
			$tr.appendTo($(target));
		}
		$(target).append(getBottom(url,param,target,showField,preUrl));
		$(target).addClass("style");
	}, "json");
}

function query(keys,root){
	var param = {method:"search",key:keys,currentPage:1,pageSize:5,result:"json"};
	search(root+"/front/technology_supply/supplyServlet", param,"#jsgjk","mc",root+"/front/technology_supply/supplyServlet?method=visit&key="+keys);
	search(root+"/front/news/newsServlet",param,"#xwgg","title",root+"/front/news/newsServlet?method=visit&key="+keys);
	search(root+"/front/qyxq/qyxqFrontServlet",param,"#qyxq","mc",root+"/front/qyxq/qyxqFrontServlet?method=getById&key="+keys);
	search(root+"/front/zcfg/zcfgFrontServlet",param,"#zcfg","zcmc",root+"/front/zcfg/zcfgFrontServlet?method=getById&key="+keys);
	search(root+"/front/zjxx/zjxxFrontServlet",param,"#zjxx","xm",root+"/front/zjxx/zjxxFrontServlet?method=getById&key="+keys);
	search(root+"/front/kjcg/kjcgFrontServlet",param,"#kjcg","mc",root+"/front/kjcg/kjcgFrontServlet?method=getById&key="+keys);
	search(root+"/front/ztzl/ZtzlxxkServlet",param,"#ztzlxxk","mc",root+"/front/ztzl/ZtzlxxkServlet?method=visit&key="+keys);
	search(root+"/front/fwpt/FwptServlet",param,"#fwpt","mc",root+"/front/fwpt/FwptServlet?method=getBykmAndMc&key="+keys)
}
function getPage(url,method,currentPage,pageSize,key,totalPage,target,field,preUrl){
	search(url,{method:method,currentPage:currentPage,pageSize:pageSize,key:key,totalPage:totalPage},target,field,preUrl);
}

