package com.rk.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rk.dao.UserMapper;
import com.rk.model.User;
import com.rk.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	UserMapper userMapper;

	@Override
	public User login(String account, String password) {
		User user = null;
		
		// 1.ͨ��mapper�ҵ���Ӧ�����ݿ��¼
		try {
			user = userMapper.selectByAccount(account);
			//2.ͨ�������ж��Ƿ�ƥ��
			if(!user.getPassword().equals(password)) {
				return null;
			}
			//3.ƥ���򷵻�user,���򷵻�null
			return user;
		} catch (Exception e) {
			System.out.println("�����˺Ų����û�ʱ�׳��쳣");
			e.printStackTrace();
			return null;
		}			
	}
}
