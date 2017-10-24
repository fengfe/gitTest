package com.bankledger.login.service;

import javax.annotation.Resource;

import org.omg.CORBA.portable.UnknownException;
import org.springframework.stereotype.Service;

import com.bankledger.login.dao.LoginDao;
import com.bankledger.login.entity.User;

@Service
public class UserServiceImpl implements UserService{
	@Resource
	LoginDao dao;
	
	
	@Override
	public User isExist(String userName,String password) {
		if(userName==null||userName.length()==0) {
			throw new RuntimeException("登录名不能为空");
		}
		if(password==null||password.length()==0)
			throw new RuntimeException("密码不能为空");
		int num = dao.isExist(userName);
		if(num==0)throw new RuntimeException("用户不存在");
		User user = dao.findObjectByName(userName);
		if(!user.getPassWord().trim().equals(password)) {
			throw new RuntimeException("密码不正确");
		}
		return user;
	}

	
}
