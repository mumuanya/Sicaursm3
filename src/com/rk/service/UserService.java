package com.rk.service;

import com.rk.model.User;

public interface UserService {
     /**
      * 用户登录方法
      * @param account
      * @param password
      * @return 如果登录成功,返回一个用户,如果登录失败,返回<b>null</b>
      */
	User login(String account,String password);
}
