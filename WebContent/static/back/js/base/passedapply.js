$(document).ready(function(){
	
	refreshVip();
	
	$('#passedapplytable').on('check.bs.table',function (row,elem) {
		openBtn();
	});
	
	$('#passedapplytable').on('uncheck.bs.table', function (row,elem) {
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
            $('#passedapplytable').bootstrapTable('load',data);
	    }
	});
}

//开关按钮的函数
function closeBtn() {
    $("button[name='restitution']").attr('disabled','disabled');
}
function openBtn() {
    $("button[name='restitution']").removeAttr('disabled');
}