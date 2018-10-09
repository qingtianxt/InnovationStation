

function getDialog(width,height){
	var $dialog = $("<div></div>");
	$dialog.width(width);
	$dialog.height(height);
	var off = {left:($(document).width()-width) / 2,top:($(document).height()-height) / 2};
	$dialog.offset(off);
	$dialog.css("position","absolute");
	return $dialog;
}

function getModalDialog(w,h,xp,yp){
	var $pre = $("<div></div>");
	$pre.css("position","absolute");
	$pre.css("margin","0px");
	$pre.css("background-color","rgba(10,13,15,0.2)");
	$pre.width($(document).width());
	$pre.height($(document).height());
	$pre.offset({left:0,top:0});
	var $dialog;
	var width,height,x,y;
	switch(arguments.length){
		case 0:{
			width = 400;
			height = 300;
			x = $(document).width()-width;
			y = $(document).height()-height;
			break;
		}
		case 1:{
			width = w;
			height = 300;
			x = $(document).width()-width;
			y = $(document).height()-height;
			break;
		}
		case 2:{
			width = w;
			height = h;
			x = $(document).width()-width;
			y = $(document).height()-height;
			break;
		}
		case 3:{
			width = w;
			height = h;
			x = xp;
			y = $(document).height()-height;
			break;
		}
		case 4:{
			width = w;
			height = h;
			x = xp;
			y = yp;
			break;
		}
	}
	if(width>$(document).width()){
		width = $(document).width();
		x = 0;
	}
	if(height>$(document).height()){
		height = $(document).height();
		y = 0;
	}
	x /= 2; y /= 2; y = y-y*0.05;
	$dialog = $("<div></div>");
	$dialog.css("position","absolute");
	$dialog.css("padding","20px 15px 5px")
	$dialog.width(width);
	$dialog.height(height);
	$dialog.offset({left:x,top:y});
	$pre.append($dialog);
	$pre.appendTo($("body"));
	
	var $title = $("<div style='min-height:10%'></div>");
	var $content = $("<div></div>");
	$content.height(height*0.75);
	$content.css("overflow","auto");
	var $footer = $("<div style='min-height:10%'></div>");
	$dialog.append($title);
	$dialog.append($content);
	$dialog.append($footer);
	
	$dialog.title = $title;
	$dialog.content = $content;
	$dialog.footer = $footer;
	
	
	$dialog.close = function(){
		$pre.remove();
	}
	$dialog.hidden = function(){
		$pre.hide();
	}
	$dialog.show = function(){
		$pre.show();
	}
	return $dialog;
}