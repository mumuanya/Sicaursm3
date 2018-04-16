//注销登录的函数
function adminloginoff(url) {
    //清除令牌信息,相当于注销登录
	$.ajax({
        type:"POST",
        url:url,
        async:true,
        dataType: 'json',
        success: function(datas){
            if( datas.code == 3){
            	window.location.href='login';
            }
	    }
	});
    
}