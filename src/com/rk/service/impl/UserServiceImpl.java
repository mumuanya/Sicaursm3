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
		
		// 1.通过mapper找到对应的数据库记录
		try {
			user = userMapper.selectByAccount(account);
			//2.通过密码判断是否匹配
			if(!user.getPassword().equals(password)) {
				return null;
			}
			//3.匹配则返回user,否则返回null
			return user;
		} catch (Exception e) {
			System.out.println("按照账号查找用户时抛出异常");
			e.printStackTrace();
			return null;
		}			
	}
}
