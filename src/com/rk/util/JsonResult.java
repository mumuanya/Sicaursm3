package com.rk.util;

public class JsonResult {

	private static Integer code;
	private static boolean result;
	private static String msg;
	
	
	public  Integer getCode() {
		return code;
	}
	public  void setCode(Integer code) {
		JsonResult.code = code;
	}
	public  boolean isResult() {
		return result;
	}
	public  void setResult(boolean result) {
		JsonResult.result = result;
	}
	public  String getMsg() {
		return msg;
	}
	public  void setMsg(String msg) {
		JsonResult.msg = msg;
	}
	
	public static JsonResult setTrue() {
		code = 1;
		result = true;
		msg="³É¹¦";
		return new JsonResult();
	}
	public static JsonResult setFalse() {
		code = -1;
		result = false;
		msg="Ê§°Ü";
		return new JsonResult();
	}
}
