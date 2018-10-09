/**
 * 
 */
//获取当前web应用的名称 
 var webroot=document.location.href;
  webroot=webroot.substring(webroot.indexOf('//')+2,webroot.length);
 webroot=webroot.substring(webroot.indexOf('/')+1,webroot.length);
  webroot=webroot.substring(0,webroot.indexOf('/'));
  rootpath="/"+webroot;
 function start(root){
	 /*加载5条技术供给*/
	 $.post(root+"/front/technology_supply/supplyServlet", {
				method : "list",
				result : "json",
				currentPage : 1,
				pageSize : 5,
				status : "sh in (1)"
			}, function(res) {
				var data = res["data"]
				for(var i in data){
					var $item = $("<div></div>");
					var $a = $("<a></a>");
					$a.attr("href",root+"/front/technology_supply/supplyServlet?method=visit&id="+data[i].id);
					$a.attr("target","_block");
					$a.html(data[i].mc);
					$item.append($a);
					$item.addClass("item");
					$("<div></div>").addClass("group").append($item).append("  >>").appendTo($("#teachnology"));
				}
			}, "json");
			
	/*加载5条专利*/
	$.post(root+"/front/patent/patentServlet", {
				method : "list",
				result : "json",
				currentPage : 1,
				pageSize : 5
			}, function(res) {
				var data = res["data"];
				for(var i in data){
					var $item = $("<div></div>");
					var $a = $("<a></a>");
					$a.attr("href",root+"/front/patent/patentServlet?method=visit&id="+data[i].id);
					$a.attr("target","_block");
					$a.html(data[i].fmmc);
					$item.append($a);
					$item.addClass("item");
					$("<div></div>").addClass("group").append($item).append("  >>").appendTo($("#patent"));
				}
			}, "json");
			
	/*加载4条国内新闻*/		
	$.post(root+"/front/news/newsServlet", {
				method : "list",
				result : "json",
				qtype : "国内新闻",
				currentPage : 1,
				pageSize : 4
			}, function(res) {
				var data = res["data"];
				for(var i in data){
					var $item = $("<div></div>");
					var $a = $("<a></a>");
					$a.attr("href",root+"/front/news/newsServlet?method=visit&id="+data[i].id);
					$a.attr("target","_block").css("font-size","14px");
					$a.html(data[i].title);
					$item.append($a);
					$item.addClass("item");
					$("<div></div>").addClass("group").append($item).appendTo($("#internalNews"));
					$item.after("<div style='font-size:14px'>-------------------------["+data[i].time+"]</div>");
				}
			}, "json");
	// 获取通知公告类型的新闻
	$.post(root+"/front/news/newsServlet", {
				method : "list",
				result : "json",
				qtype : "通知公告",
				currentPage : 1,
				pageSize : 4
			}, function(res) {
				var data = res["data"];
				for(var i in data){
					var $item = $("<div></div>");
					var $a = $("<a></a>");
					$a.attr("href",root+"/front/news/newsServlet?method=visit&id="+data[i].id);
					$a.attr("target","_block").css("font-size","14px");
					$a.html(data[i].title);
					$item.append($a);
					$item.addClass("item");
					$("<div></div>").addClass("group").append($item).appendTo($("#notice"));
					$item.after("<div style='font-size:14px'>-------------------------["+data[i].time+"]</div>");
				}
			}, "json");
	// 获取图片新闻
	$.post(root+"/front/news/photoNewsServlet", {
				method : "all"
			}, function(data) {
				for(var i in data){
					PImgPlayer.addItem(data[i].title,root+"/front/news/photoNewsServlet?method=detail&id="+data[i].id,root+data[i].image);
				}
				 PImgPlayer.init("imgADPlayer",491,223);
			}, "json");
	
	
	// 找需求  TODO 加载内容的访问地址和查看详情的访问地址
	$.post(root+"/front/qyxq/qyxqFrontServlet", {
				method : "getTop",
				result : "json",
				currentPage : 1,
				pageSize : 5
		},function(data){
			for(var i in data){
				var $item = $("<div></div>");
				var $a = $("<a></a>");
				$a.attr("href",root+"/front/qyxq/qyxqFrontServlet?method=getById&id="+data[i].id);
				$a.attr("target","_block");
				$a.html(data[i].mc);
				$item.append($a);
				$item.addClass("item");
				$("<div></div>").addClass("group").append($item).append("  >>").appendTo($("#zxq"));
			}
		},"json");
	
	// 找成果 TODO 加载内容的访问地址和查看详情的访问地址
	$.post(root+"/front/kjcg/kjcgFrontServlet", {
				method : "getTop",
				result : "json",
				currentPage : 1,
				pageSize : 5
		},function(data){
			for(var i in data){
				var $item = $("<div></div>");
				var $a = $("<a></a>");
				$a.attr("href",root+"/front/kjcg/kjcgFrontServlet?method=getById&id="+data[i].id);
				$a.attr("target","_block");
				$a.html(data[i].mc);
				$item.append($a);
				$item.addClass("item");
				$("<div></div>").addClass("group").append($item).append("  >>").appendTo($("#zcg"));
			}
		},"json");
	// 找专家		
	$.post(root+"/front/zjxx/zjxxFrontServlet", {
				method : "getTop",
				result : "json",
				currentPage : 1,
				pageSize : 5
		},function(data){
			for(var i in data){
				var $item = $("<div></div>");
				var $a = $("<a></a>");
				$a.attr("href",root+"/front/zjxx/zjxxFrontServlet?method=getById&id="+data[i].id);
				$a.attr("target","_block");
				$a.html(data[i].xm);
				$item.append($a);
				$item.addClass("item");
				$("<div></div>").addClass("group").append($item).append("  >>").appendTo($("#zzj"));
			}
		},"json");		
	// 找平台		
	$.post(root+"/front/fwpt/FwptServlet", {
				method : "getTop",
				result : "json",
				currentPage : 1,
				pageSize : 5
		},function(data){
			for(var i in data){
				var $item = $("<div></div>");
				var $a = $("<a></a>");
				$a.attr("href",root+"/front/fwpt/FwptServlet?method=getBykmAndMc&km="+data[i]['km']+"&mc="+data[i]['mc']);
				$a.attr("target","_block");
				$a.html(data[i].mc);
				$item.append($a);
				$item.addClass("item");
				$("<div></div>").addClass("group").append($item).append("  >>").appendTo($("#zpt"));
			}
		},"json");		
	// 找政策		
	$.post(root+"/front/zcfg/zcfgFrontServlet", {
				method : "getTop",
				result : "json",
				currentPage : 1,
				pageSize : 5
		},function(data){
			for(var i in data){
				var $item = $("<div></div>");
				var $a = $("<a></a>");
				$a.attr("href",root+"/front/zcfg/zcfgFrontServlet?method=getById&id="+data[i].id);
				$a.attr("target","_block");
				$a.html(data[i].zcmc);
				$item.append($a);
				$item.addClass("item");
				$("<div></div>").addClass("group").append($item).append("  >>").appendTo($("#zzc"));
			}
		},"json");		
	// 服务平台	
	$.post(root+"/front/fwpt/fwptFrontServlet", {
		method : "getTop",
		result : "json",
		currentPage : 1,
		pageSize : 5
	},function(data){
		for(var i in data){
			var $item = $("<div></div>");
			var $a = $("<a></a>");
			$a.attr("href",root+"/front/fwpt/fwptFrontServlet?method=getByKmAndMc&km="+data[i].km+"&mc="+data[i].mc);
			$a.attr("target","_block");
			$a.html(data[i].mc);
			$item.append($a);
			$item.addClass("item");
			$("<div></div>").addClass("group").append($item).append("  >>").appendTo($("#zpt"));
		}
	},"json");		
	// 全局搜索
	$("#global").click(function(){
		
		var key = $("#globalsearch").val();
		if(key==""||key==null){
			layer.open({  
				content: '请输入搜索内容!',  
				btn: ["确定"],  
				yes: function(index, layero) {  
					
					layer.close(index);
				},  
				
				cancel: function() {  
					//右上角关闭回调  
				}  ,
				offset:['100px','400px']
			});  
			return;
		}
		location.href = root+"/front/main.jsp?key="+$("#globalsearch").val();
	})
 }
 //废弃中
 function loadInfo(url,param,preUrl,titile,id){
 	$.get(url, param, function(res) {
				var data = res["data"];
				for(var i in data){
					var $item = $("<div></div>");
					var $a = $("<a></a>");
					$a.attr("href",preUrl+"&id="+data[i][id]);
					$a.attr("target","_block").css("font-size","14px");
					$a.html(data[i][title]);
					$item.append($a);
					$item.addClass("item");
					$("<div></div>").addClass("group").append($item).appendTo($("#notice"));
					$item.after("<div style='font-size:14px'>-------------------------["+data[i].time+"]</div>");
				}
			}, "json");
	$.get("../back/patent/patentServlet", {
				method : "list",
				result : "json",
				currentPage : 1,
				pageSize : 5
			}, function(res) {
				var data = res["data"];
				for(var i in data){
					var $item = $("<div></div>");
					var $a = $("<a></a>");
					$a.attr("href","../front/patent/patentServlet?method=visit&id="+data[i].id);
					$a.attr("target","_block");
					$a.html(data[i].fmmc);
					$item.append($a);
					$item.addClass("item");
					$("<div></div>").addClass("group").append($item).append("  >>").appendTo($("#patent"));
				}
			}, "json");
 }
 
 
 
 
