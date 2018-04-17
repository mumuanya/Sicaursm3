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
