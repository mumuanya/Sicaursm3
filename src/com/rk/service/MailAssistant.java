package com.rk.service;

public interface MailAssistant {

	void passwordToMail(String usermail,String newPsd,String neckname,String oldPsd);
	
	void passwordToMailWithInlineResource(String usermail,String newPsd,String neckname,String oldPsd);
	
	/**
	 * 拒绝用户申请物品、场地使用权利
	 * @param usermail
	 * @param neckname
	 */
	void refuseApply(String usermail,String neckname);
	
	/**
	 * 同意用户申请物品、场地使用权利
	 * @param usermail
	 * @param neckname
	 */
	void agreeApply(String usermail,String neckname);
	
	/**
	 * 催促用户归还资源
	 * @param usermail
	 * @param neckname
	 */
	void urgeApply(String usermail,String neckname);
	
	/**
	 * 同意用户归还资源
	 * @param usermail
	 * @param neckname
	 */
	void agreeReturn(String usermail,String neckname);
}
