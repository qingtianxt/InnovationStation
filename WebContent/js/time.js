/**
 * 
 */
 $(function(){
	 $.validator.addMethod("timerange",function(value,element){
	 	var time1 = $("input[name='startTime']").val();
	 	var time2 = $("input[name='endTime']").val();
	 	return time1 < time2 || time1=="" || time2 == "";
	 },"时间分布不合理");
	 $("form").validate({
	 	rules:{
	 		endTime:{timerange:true}
	 	},errorPlacement:function(error,element){
	 		layer.open({
	 			content:error.html(),
	 			btn:['确定'],
	 			btn1:function(index,layero){
	 				layer.close(index);
	 			}
	 		});
	 		return false;
	 	}
	 })
 })