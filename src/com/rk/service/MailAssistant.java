package com.rk.service;

public interface MailAssistant {

	void passwordToMail(String usermail,String newPsd,String neckname,String oldPsd);
	
	void passwordToMailWithInlineResource(String usermail,String newPsd,String neckname,String oldPsd);
	
	/**
	 * �ܾ��û�������Ʒ������ʹ��Ȩ��
	 * @param usermail
	 * @param neckname
	 */
	void refuseApply(String usermail,String neckname);
	
	/**
	 * ͬ���û�������Ʒ������ʹ��Ȩ��
	 * @param usermail
	 * @param neckname
	 */
	void agreeApply(String usermail,String neckname);
	
	/**
	 * �ߴ��û��黹��Դ
	 * @param usermail
	 * @param neckname
	 */
	void urgeApply(String usermail,String neckname);
	
	/**
	 * ͬ���û��黹��Դ
	 * @param usermail
	 * @param neckname
	 */
	void agreeReturn(String usermail,String neckname);
}
