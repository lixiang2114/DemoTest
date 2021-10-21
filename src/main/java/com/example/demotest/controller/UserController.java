package com.example.demotest.controller;

import java.util.LinkedHashMap;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demotest.po.User;

@Controller
@RequestMapping("user")
public class UserController {
	/**
	 * 用户字典
	 */
	private LinkedHashMap<Long,User> userDict=new LinkedHashMap<Long,User>();
	
	@PostConstruct
	private void init(){
		userDict.put(100L, new User(100L,"zhangsan",10));
		userDict.put(101L, new User(101L,"lisi",12));
		userDict.put(102L, new User(102L,"wangwu",10));
	}

	@ResponseBody
	@RequestMapping("/add")
    public String addUser(User user)  throws Exception{
		System.out.println("invoke controller method:addUser");
		userDict.put(user.getUserId(), user);
        return null==user?null:user.toString();
    }
	
	@ResponseBody
	@RequestMapping("/get")
    public String getUser(Long userId)  throws Exception{
		User user=userDict.get(userId);
        return null==user?"null":user.toString();
    }
	
	@RequestMapping("/list")
    public String listUser(Model model)  throws Exception{
		model.addAttribute("userList", userDict.values());
        return "list";
    }
}
