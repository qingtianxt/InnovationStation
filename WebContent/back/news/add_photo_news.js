/**
 * 
 */
$(function() {
			var isPrompt = null;
			$("form").validate({
						errorElement : 'span',
						rules : {
							publisher : {
								required : true,
								maxlength : 10
							},
							time : {
								required : true
							},
							title : {
								required : true,
								maxlength: 50,
								remote : {
									url : global.rootpath+"/back/news/newsPhotoServlet",
									type : "GET",
									dataType : "json",
									data : {
										method : "checkName",
										title : function(){ return $("#Title").val();}
									},
									dataFilter : function (res){
										return res.toString() == "true" || global.newsPhoto.title == $("#Title").val();
									}
								}
							},
							image : {
								required : global.newsPhoto.title=="",
								maxlength : 80
							},
							content : {
								required : true
							}
						},
						messages : {
							publisher : {
								required : "请输入发布人",
								maxlength:"发布人长度不能超过10个字符"
							},
							time : {
								required : "请选择发表时间"
							},
							title : {
								required : "请输入新闻标题",
								remote : "该条新闻已经存在",
								maxlength:"新闻标题长度不能超过50个字符"
							},
							image : {
								required : "请选择图片",
								maxlength :"图片路径过长"
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
										content : "确定提交吗？",
										btn : ["确定", "取消"],
										skin : "layui-layer-lan",
										btn1 : function(index, layero) {
											layer.close(index);
											$("form")[0].submit();
										}
									});
						}
					});
		})