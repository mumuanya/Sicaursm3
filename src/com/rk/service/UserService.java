package com.rk.service;

import com.rk.model.User;

public interface UserService {
     /**
      * �û���¼����
      * @param account
      * @param password
      * @return �����¼�ɹ�,����һ���û�,�����¼ʧ��,����<b>null</b>
      */
	User login(String account,String password);
}
