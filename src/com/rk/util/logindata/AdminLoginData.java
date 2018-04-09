
package com.rk.util.logindata;

import com.alibaba.fastjson.JSON;

/** 
                   _ooOoo_ 
                  o8888888o 
                  88" . "88 
                  (| -_- |) 
                  O\  =  /O 
               ____/`---'\____ 
             .'  \\|     |//  `. 
            /  \\|||  :  |||//  \ 
           /  _||||| -:- |||||-  \ 
           |   | \\\  -  /// |   | 
           | \_|  ''\---/''  |   | 
           \  .-\__  `-`  ___/-. / 
         ___`. .'  /--.--\  `. . __ 
      ."" '<  `.___\_<|>_/___.'  >'"". 
     | | :  `- \`.;`\ _ /`;.`/ - ` : | | 
     \  \ `-.   \_ __\ /__ _/   .-` /  / 
======`-.____`-.___\_____/___.-`____.-'====== 
                   `=---=' 
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 
         佛祖保佑       永无BUG 
*/
/**
 * 账号不存在1
	*密码不正确2
	*登陆成功3
	*登录超时4
	*
	*{
	‘code’:3,
	‘msg’:’xxx’
	}

 * @author Mrruan
 *
 */
public class AdminLoginData {
	
	private Integer code;  //登录代码 
	private String msg;
	
	
	//有四个方法,账号不存在1 密码不正确2 登陆成功3 登录超时4
	public static String noAccount(String msg) {
		AdminLoginData adminLoginData = new AdminLoginData(1,msg);
		return JSON.toJSONString(adminLoginData);
	}
	public static String incorrectPassword(String msg) {
		AdminLoginData adminLoginData = new AdminLoginData(2,msg);
		return JSON.toJSONString(adminLoginData);
	}
	public static String success(String msg) {
		AdminLoginData adminLoginData = new AdminLoginData(3,msg);
		return JSON.toJSONString(adminLoginData);
	}
	public static String timeout(String msg) {
		AdminLoginData adminLoginData = new AdminLoginData(4,msg);
		return JSON.toJSONString(adminLoginData);
	}
	
	
	
	private AdminLoginData(Integer code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}
	
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
