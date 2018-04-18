$(document).ready(function(){
	//刷新一下页面的数据
	refreshVip();
	
	//监听按钮开关
	 $('#filedtable').on('check.bs.table',function (row,elem) {
		openBtn();
		//将model中的内容换成需要的内容
		var rows = $('#filedtable').bootstrapTable('getSelections');
        var elems = $("#lookfieldmodal").children('input');
        $(elems[0]).val($(rows).last()[0].id);
        $(elems[1]).val($(rows).last()[0].name);
        $(elems[2]).val($(rows).last()[0].description);
        $(elems[3]).val($(rows).last()[0].state);
        $(elems[4]).val($(rows).last()[0].position);
        
        //修改update modal中的内容
        var elems2 = $("#updatefieldmodal").children('input');
        var selects = $("#updatefieldmodal").children('select');
        
        $(elems2[0]).val($(rows).last()[0].id);
        $(elems2[1]).val($(rows).last()[0].name);
        $(elems2[2]).val($(rows).last()[0].description);
        $(elems2[3]).val($(rows).last()[0].position);
        
	 });
	 
	 $('#filedtable').on('uncheck.bs.table', function (row,elem) {
		 closeBtn();
	 });
});


function deletefield(){
	var rows = $('#filedtable').bootstrapTable('getSelections');
	var id = $(rows).last()[0].id;
	$.ajax({
        type:"delete",
        url:'field/delete/' + id,
        async:true,
        dataType:'json',
        success:function(data){
        	if(data.code === 1){
        		refreshVip();
        		closeBtn();
        		$("#deletefield").modal('hide');
        	}
        	else if(data.code === 0){
        		alert("删除失败");
        	}
	    }
	});
}

function addfield(){
	var name = $('#addfieldmodal').children('input')[0].value;
	var description = $('#addfieldmodal').children('input')[1].value;
	var position = $('#addfieldmodal').children('input')[2].value;
	$.ajax({
        type:"post",
        url:'field/add',
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
        		$("#addfield").modal('hide');
        	}
        	else if(data.code === 0){
        		alert("增加失败");
        	}
	    }
	});
}
//修改
function updatefield(){
	
	var id = $('#updatefieldmodal').children('input')[0].value;
	var name = $('#updatefieldmodal').children('input')[1].value;
	var description = $('#updatefieldmodal').children('input')[2].value;
	var position = $('#updatefieldmodal').children('input')[3].value;
	var state = $('#updatefieldmodal').children('select')[0].value;
	
	$.ajax({
        type:"post",
        url:'field/update/' + id,
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
        		$("#updatefield").modal('hide');
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
        url:'field/all',
        async:true,
        dataType:'json',
        success:function(data){
           // alert("调试信息:读取数据成功" + data);
            $('#filedtable').bootstrapTable('load',data);
	    }
	});
}


//开关按钮的函数
function closeBtn() {
    $("button[name='deletefield']").attr('disabled','disabled');
    $("button[name='updatefield']").attr('disabled','disabled');
    $("button[name='lookfield']").attr('disabled','disabled');
}
function openBtn() {
    $("button[name='deletefield']").removeAttr('disabled');
    $("button[name='updatefield']").removeAttr('disabled');
    $("button[name='lookfield']").removeAttr('disabled');
}


















