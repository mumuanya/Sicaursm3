$(document).ready(function(){
	//监听借用类型的改变
	$('#borrowtype').bind('change',function(){
		if($(this).val() == 0){
			//场地
			$.ajax({
		        type:"get",
		        url:'fields/all',
		        async:true,
		        dataType:'json',
		        success:function(data){
		        	console.log(data);
		        	//设置第二个select的option
		        	var i = 0;
		        	$("#tid").empty();  //第一步清空select
		        	for(; i<data.length; i++){
		        		$("#tid").append("<option value='" + data[i].id + "'>" + data[i].name + "</option>");
		        		$('#tid').selectpicker('refresh');
		        	}
			    }
			});
		}else if($(this).val() == 1){
			//物品
			$.ajax({
		        type:"get",
		        url:'items/all',
		        async:true,
		        dataType:'json',
		        success:function(data){
		        	console.log(data);
		        	//设置第二个select的option
		        	var i = 0;
		        	$("#tid").empty();  //第一步清空select
		        	for(; i<data.length; i++){
		        		
		        		$("#tid").append("<option value='" + data[i].id + "'>" + data[i].name + "</option>");
		        		$('#tid').selectpicker('refresh');
		        	}
			    }
			});
		}else{
			//其它
			return;
		}
	});
});


//重置输入框的值
function resetValue(){
	//清空借用理由,借用时长
	$("#borrowreason").val("");
	$("#borrowtime").val(0);
}

function toapply(){
	var borrowtype = $("#borrowtype").val();
	var tid = $("#tid").val();
	var borrowreason = $("#borrowreason").val();
	var borrowtime = $("#borrowtime").val();
	console.log(borrowtype + "  " + tid + "  " + borrowreason + "  " + borrowtime);
	
	//发送到后台
	$.ajax({
        type:"post",
        url:'apply/apply',
        async:true,
        dataType:'json',
        data:{
        	borrowtype:borrowtype,
        	tid:tid,
        	borrowreason:borrowreason,
        	borrowtime:borrowtime
        },
        success:function(data){
        	if(data.code == 1){
        		//成功
        		alert("提交申请成功，请等待管理员处理！");
        		window.location.href = 'appling';
        	}else if(data.code == -1){
        		//失败
        		alert("提交失败");
        	}
	    }
	});
}


