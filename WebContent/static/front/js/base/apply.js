$(document).ready(function(){
	//refreshVip();
	
	//监听借用类型的改变
	$('')
});

//在这里定义加载数据到bootstraptable
/*function refreshVip() {
    //直接发送ajax获取数据.
    $.ajax({
        type:"get",
        url:'apply/appling',
        async:true,
        dataType:'json',
        success:function(data){
           // alert("调试信息:读取数据成功" + data);
            $('#applingtable').bootstrapTable('load',data);
	    }
	});
}*/

//获取物品
function getItems(){
	$.ajax({
        type:"get",
        url:'items/all',
        async:true,
        dataType:'json',
        success:function(data){
        	return data;
	    }
	});
}

//获取场地信息
function getFields(){
	$.ajax({
        type:"get",
        url:'fields/all',
        async:true,
        dataType:'json',
        success:function(data){
        	return data;
	    }
	});
}

function setBorrowName(){
	
}