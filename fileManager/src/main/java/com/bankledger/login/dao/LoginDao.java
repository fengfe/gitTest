package com.bankledger.login.dao;


import org.apache.ibatis.annotations.Param;

import com.bankledger.login.entity.User;

public interface LoginDao {
	/**根据用户名查询用户*/
	User findObjectByName(@Param("userName") String userName);
	
	/**根据用户名查询是否存在*/
	int isExist (String userName);
}
