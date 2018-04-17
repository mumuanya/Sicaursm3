$(document).ready(function(){
	
	refreshVip();
	
	$('#applyrecordtable').on('check.bs.table',function (row,elem) {
		openBtn();
	});
	
	$('#applyrecordtable').on('uncheck.bs.table', function (row,elem) {
		 closeBtn();
	});
});

//在这里定义加载数据到bootstraptable
function refreshVip() {
    //直接发送ajax获取数据.
    $.ajax({
        type:"get",
        url:'apply/returned',
        async:true,
        dataType:'json',
        success:function(data){
           // alert("调试信息:读取数据成功" + data);
            $('#applyrecordtable').bootstrapTable('load',data);
	    }
	});
}


//开关按钮的函数
function closeBtn() {
    $("button[name='lookapplyrecord']").attr('disabled','disabled');
}
function openBtn() {
    $("button[name='lookapplyrecord']").removeAttr('disabled');
}