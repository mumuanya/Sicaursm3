$(document).ready(function(){
	refreshVip();
});

//在这里定义加载数据到bootstraptable
function refreshVip() {
    //直接发送ajax获取数据.
    $.ajax({
        type:"get",
        url:'item/all',
        async:true,
        dataType:'json',
        success:function(data){
           // alert("调试信息:读取数据成功" + data);
            $('#itemtable').bootstrapTable('load',data);
	    }
	});
}