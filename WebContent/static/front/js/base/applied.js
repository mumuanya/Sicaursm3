$(document).ready(function(){
	
	refreshVip();
	
	$('#appliedtable').on('check.bs.table',function (row,elem) {
		openBtn();
	});
	
	$('#appliedtable').on('uncheck.bs.table', function (row,elem) {
		 closeBtn();
	 });
});

//在这里定义加载数据到bootstraptable
function refreshVip() {
    //直接发送ajax获取数据.
    $.ajax({
        type:"get",
        url:'apply/applied',
        async:true,
        dataType:'json',
        success:function(data){
           // alert("调试信息:读取数据成功" + data);
            $('#appliedtable').bootstrapTable('load',data);
	    }
	});
}

//开关按钮的函数
function closeBtn() {
    $("button[name='applyreturn']").attr('disabled','disabled');
}
function openBtn() {
    $("button[name='applyreturn']").removeAttr('disabled');
}

function returnapply(){
	var rows = $('#appliedtable').bootstrapTable('getSelections');
	
	var id = $(rows).last()[0].id;
	$.ajax({
        type:"post",
        url:'apply/return/' + id,
        async:true,
        dataType:'json',
        success:function(data){
        	if(data.code === 1){
        		alert("已申请归还");
        		refreshVip();
        		closeBtn();
        	}
        	else if(data.code === 0){
        		alert("申请归还失败");
        	}
	    }
	});
}