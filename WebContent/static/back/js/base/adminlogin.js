function adminlogin(url){
	    //首先获取密码
	    var account = $('#account')[0].value;
	    var password = $('#password')[0].value;
	    //alert(password);
	    //点击按钮时发送ajax请求
	    $.ajax({
	        type:"POST",
	        url:url,
	        async:true,
	        data:{
	        	account:account,
	        	password:password 
	        },
	        dataType: 'json',
	        success: function(datas){
	            if( datas.code == 3){
	            	window.location.href='index';
	            }else{
	                alert(datas.msg);
	            }
	    }
	});
}

