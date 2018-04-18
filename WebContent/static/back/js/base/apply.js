$(document).ready(function(){
	
	refreshVip();
	
	$('#applytable').on('check.bs.table',function (row,elem) {
		openBtn();
	});
	
	$('#applytable').on('uncheck.bs.table', function (row,elem) {
		 closeBtn();
	 });
});



//在这里定义加载数据到bootstraptable
function refreshVip() {
    //直接发送ajax获取数据.
    $.ajax({
        type:"get",
        url:'apply/appling',
        async:true,
        dataType:'json',
        success:function(data){
           // alert("调试信息:读取数据成功" + data);
            $('#applytable').bootstrapTable('load',data);
	    }
	});
}

//开关按钮的函数
function closeBtn() {
    $("button[name='refuseapply']").attr('disabled','disabled');
    $("button[name='passapply']").attr('disabled','disabled');
}
function openBtn() {
    $("button[name='refuseapply']").removeAttr('disabled');
    $("button[name='passapply']").removeAttr('disabled');
}

function refuseapply(){
	
	var rows = $('#applytable').bootstrapTable('getSelections');
	
	var id = $(rows).last()[0].id;
	var borrowtype = $(rows).last()[0].borrowtype;
	
	$.ajax({
        type:"post",
        url:'apply/refuse/' + id,
        async:true,
        dataType:'json',
        success:function(data){
        	if(data.code === 1){
        		alert("已拒绝申请")
        		refreshVip();
        		closeBtn();
        	}
        	else if(data.code === 0){
        		alert("拒绝通过失败");
        	}
	    }
	});
}
function passapply(){
	var rows = $('#applytable').bootstrapTable('getSelections');
	
	var id = $(rows).last()[0].id;
	var borrowtype = $(rows).last()[0].borrowtype;
	$.ajax({
        type:"post",
        url:'apply/pass/' + id,
        async:true,
        dataType:'json',
        data:{
        	borrowtype:borrowtype
        },
        success:function(data){
        	if(data.code === 1){
        		alert("已通过审核");
        		refreshVip();
        		closeBtn();
        	}
        	else if(data.code === 0){
        		alert("通过失败");
        	}
	    }
	});
}
