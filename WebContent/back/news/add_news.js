/**
 * 
 */
 $(function(){
 	var isPrompt = null;
	$("#form1").validate({
			rules : {
				title : {
					required : true,
					maxlength : 50,
					remote:{
						url:global.rootpath+"/back/news/newsServlet",
						type:"GET",
						dataType:"json",
						data:{
							method:"checkName",
							title:function(){ return $("#Title").val()}
						},
						dataFilter:function(res){
							return res.toString() == "true" || global.newsBean.title == $("#Title").val();
						}
					}
				},
				time : {
					required : true
				},
				publisher : {
					required : true,
					maxlength : 10
				},
				content : {
					required : true
				}
			},
			messages : {
				title : {
					required : "请输入新闻标题",
					remote : "该条新闻已经存在",
					maxlength : "新闻标题长度不能超过50个字符"
				},
				time : {
					required : "请选择发布时间"
				},
				publisher : {
					required : "请输入发布人",
					maxlength : "发布人长度不能超过10个字符"
				},
				content : {
					required : "请输入新闻内容"
				}
			},
			errorPlacement : function(error, element) {
				if (isPrompt == null) {
					layer.open({
								content : error.html(),
								btn : ["确定"],
								skin : "layui-layer-lan",
								btn1 : function(index, layero) {
									layer.close(index);
									element.focus();
									isPrompt = null;
								}
							});
					isPrompt = error.html();
				}
				return false;
			},
			onfocusout : false,
			onkeyup : false,
			onclick : false,
			submitHandler : function() {
				layer.open({
							content : "您确定要提交吗?",
							btn : ["确定", "取消"],
							skin : "layui-layer-lan",
							btn1 : function(index, layero) {
								layer.close(index);
								$("#form1")[0].submit();
							},
							btn2 : function(index, layero) {
								layer.close(index);
							}
						});
			}
		});
			
	var editor = new UE.ui.Editor();
	editor.render("content1");
	
	if(global.msg=="1"){
		layer.alert('添加成功', {
					skin : 'layui-layer-lan' //样式类名
					,
					closeBtn : 0
				});
	}
	else if(global.msg=="2"){
		layer.alert('添加失败', {
					skin : 'layui-layer-lan' //样式类名
					,
					closeBtn : 0
				});
	}
	
 })
