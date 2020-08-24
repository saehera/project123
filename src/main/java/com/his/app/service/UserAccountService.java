package com.his.app.service;

import java.util.List;


import com.his.app.entity.UserAccountEntity;
import com.his.app.model.UserAccountModel;

public interface UserAccountService {
	
	public boolean createUser(UserAccountModel userAccModel);
	public boolean isTempPwdValid(String tempPwd);
	public List<UserAccountModel>getAllUsers();
	//public List<UserAccountModel>getuserById();
	//public String updateUser(UserAccountModel UserAccountModel);
	public boolean deleteUser(Long userId);
	public UserAccountModel getUserById(Long userId);
	

}
