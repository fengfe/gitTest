package com.bankledger.login.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bankledger.attachement.web.JsonResult;
import com.bankledger.login.entity.User;
import com.bankledger.login.service.UserService;

@Controller
public class UserController {
	@Resource
	UserService userService;
	
	@RequestMapping("/toLoginUI")
	public String toLoginUI() {
		return "login";
	}
	@RequestMapping("/loginUI")
	@ResponseBody
	public JsonResult loginUI(String userName,String password) {
			User user = userService.isExist(userName, password);
		return new JsonResult();
	}
}
