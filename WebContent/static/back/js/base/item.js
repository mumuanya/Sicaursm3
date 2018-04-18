$(document).ready(function(){
	
	//刷新表格数据
	refreshVip();
	
	//监听按钮开关
	 $('#itemtable').on('check.bs.table',function (row,elem) {
		 openBtn();
		 
		//将model中的内容换成需要的内容
		var rows = $('#itemtable').bootstrapTable('getSelections');
        var elems = $("#lookitemmodal").children('input');
        $(elems[0]).val($(rows).last()[0].id);
        $(elems[1]).val($(rows).last()[0].name);
        $(elems[2]).val($(rows).last()[0].description);
        $(elems[3]).val($(rows).last()[0].state);
        $(elems[4]).val($(rows).last()[0].position);
        
        //修改update modal中的内容
        var elems2 = $("#updateitemmodal").children('input');
        var selects = $("#updateitemmodal").children('select');
        
        $(elems2[0]).val($(rows).last()[0].id);
        $(elems2[1]).val($(rows).last()[0].name);
        $(elems2[2]).val($(rows).last()[0].description);
        $(elems2[3]).val($(rows).last()[0].position);
	 });
	 
	 $('#itemtable').on('uncheck.bs.table', function (row,elem) {
		 closeBtn();
	 });
});

function deleteitem(){
	var rows = $('#itemtable').bootstrapTable('getSelections');
	var id = $(rows).last()[0].id;
	$.ajax({
        type:"delete",
        url:'item/delete/' + id,
        async:true,
        dataType:'json',
        success:function(data){
        	if(data.code === 1){
        		refreshVip();
        		closeBtn();
        		$("#deleteitem").modal('hide');
        	}
        	else if(data.code === 0){
        		alert("删除失败");
        	}
	    }
	});
}

function additem(){
	var name = $('#additemmodal').children('input')[0].value;
	var description = $('#additemmodal').children('input')[1].value;
	var position = $('#additemmodal').children('input')[2].value;
	$.ajax({
        type:"post",
        url:'item/add',
        async:true,
        dataType:'json',
        data:{
        	name:name,
        	description:description,
        	position:position
        },
        success:function(data){
        	if(data.code === 1){
        		refreshVip();
        		closeBtn();
        		$("#additem").modal('hide');
        	}
        	else if(data.code === 0){
        		alert("增加失败");
        	}
	    }
	});
}

//修改
function updateitem(){
	
	var id = $('#updateitemmodal').children('input')[0].value;
	var name = $('#updateitemmodal').children('input')[1].value;
	var description = $('#updateitemmodal').children('input')[2].value;
	var position = $('#updateitemmodal').children('input')[3].value;
	var state = $('#updateitemmodal').children('select')[0].value;
	
	$.ajax({
        type:"post",
        url:'item/update/' + id,
        async:true,
        dataType:'json',
        data:{
        	name:name,
        	description:description,
        	position:position,
        	state:state
        },
        success:function(data){
        	if(data.code === 1){
        		refreshVip();
        		closeBtn();
        		$("#updateitem").modal('hide');
        	}
        	else if(data.code === 0){
        		alert("增加失败");
        	}
	    }
	});
}



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


//开关按钮的函数
function closeBtn() {
    $("button[name='deleteitem']").attr('disabled','disabled');
    $("button[name='updateitem']").attr('disabled','disabled');
    $("button[name='lookitem']").attr('disabled','disabled');
}
function openBtn() {
    $("button[name='deleteitem']").removeAttr('disabled');
    $("button[name='updateitem']").removeAttr('disabled');
    $("button[name='lookitem']").removeAttr('disabled');
}