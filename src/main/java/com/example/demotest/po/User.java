package com.example.demotest.po;

import java.util.LinkedHashMap;

/**
 * @author Louis
 * @description 用户类
 */
public class User {
	/**
	 * 用户ID
	 */
	private Long userId;
	
	/**
	 * 用户名称
	 */
	private String userName;
	
	/**
	 * 用户组ID
	 */
	private Integer groupId;
	
	public User(){}
	
	public User(Long userId, String userName, Integer groupId) {
		this.userId = userId;
		this.userName = userName;
		this.groupId = groupId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	@Override
	public String toString() {
		LinkedHashMap<String,Object> map=new LinkedHashMap<String,Object>();
		map.put("userId", userId);
		map.put("userName", userName);
		map.put("groupId", groupId);
		return map.toString();
	}
}
