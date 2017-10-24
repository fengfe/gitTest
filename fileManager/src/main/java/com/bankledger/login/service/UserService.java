package com.bankledger.login.service;

import com.bankledger.login.entity.User;

public interface UserService {
		User isExist(String userName,String password);
		
}
