
package com.rk.service;

import java.util.List;

import com.rk.model.Field;
import com.rk.model.User;

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
         ���汣��       ����BUG 
*/
public interface AdminService {
	
	/**
	 * ����Ա��¼����
	 * @param account �˺�
	 * @param password ����
	 * @return �����¼�ɹ�,����һ���û�,�����¼ʧ��,����<b>null</b>
	 */
	User login(String account, String password);

	

}
