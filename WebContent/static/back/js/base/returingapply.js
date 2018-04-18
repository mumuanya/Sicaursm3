$(document).ready(function(){
	
	refreshVip();
	
	$('#returningapplytable').on('check.bs.table',function (row,elem) {
		openBtn();
	});
	
	$('#returningapplytable').on('uncheck.bs.table', function (row,elem) {
		 closeBtn();
	});
});

//在这里定义加载数据到bootstraptable
function refreshVip() {
    //直接发送ajax获取数据.
    $.ajax({
        type:"get",
        url:'apply/returning',
        async:true,
        dataType:'json',
        success:function(data){
           // alert("调试信息:读取数据成功" + data);
            $('#returningapplytable').bootstrapTable('load',data);
	    }
	});
}


//开关按钮的函数
function closeBtn() {
    $("button[name='consent']").attr('disabled','disabled');
}
function openBtn() {
    $("button[name='consent']").removeAttr('disabled');
}

//同意归还函数
function returnapply(){
	var rows = $('#returningapplytable').bootstrapTable('getSelections');
	
	var id = $(rows).last()[0].id;
	var borrowtype = $(rows).last()[0].borrowtype;
	
	$.ajax({
        type:"post",
        url:'apply/return/' + id,
        async:true,
        dataType:'json',
        data:{
        	borrowtype:borrowtype
        },
        success:function(data){
        	if(data.code === 1){
        		alert("归还成功");
        		refreshVip();
        		closeBtn();
        	}
        	else if(data.code === 0){
        		alert("归还失败");
        	}
	    }
	});
}