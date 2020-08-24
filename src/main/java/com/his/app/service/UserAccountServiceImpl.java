package com.his.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.his.app.entity.UserAccountEntity;
import com.his.app.model.UserAccountModel;
import com.his.app.repository.UserAccountRepository;
import com.his.app.utils.EmailUtils;
import com.his.app.utils.PwdUtils;

@Service
public class UserAccountServiceImpl implements UserAccountService {
	
	@Autowired
	UserAccountRepository userAccRepo;
	@Autowired
	EmailUtils emailUtils;

	@Override
	public boolean createUser(UserAccountModel userAccModel) {
		userAccModel.setUserPwd(PwdUtils.alphaNumericString(8));
		UserAccountEntity userAccEntity = new UserAccountEntity();
		BeanUtils.copyProperties(userAccModel, userAccEntity);
		UserAccountEntity savedEntity = userAccRepo.save(userAccEntity);  
		if(savedEntity.getUserId() !=null) {
			return emailUtils.sendUnlockEmail(userAccModel);
		}
		 return false;
	}

	
	


	@Override
	public boolean isTempPwdValid(String tempPwd) {
		UserAccountEntity userAccEntity = userAccRepo.findByUserPwd(tempPwd);
		
		
		return userAccEntity != null;
	}





	@Override
	public List<UserAccountModel> getAllUsers() {
		List<UserAccountEntity> entityList = userAccRepo.findAll();
		List<UserAccountModel>  userModel = new ArrayList<UserAccountModel>();
		BeanUtils.copyProperties(entityList, userModel);
		
		for(UserAccountEntity entity : entityList) {
			UserAccountModel userAccModel = new UserAccountModel();
			BeanUtils.copyProperties(entity, userAccModel);
			userModel.add(userAccModel);
			
		}
		return userModel;
	}





	@Override
	public UserAccountModel getUserById(Long userId) {
		 Optional<UserAccountEntity> findById = userAccRepo.findById(userId);
			if(findById.isPresent()) {
				UserAccountEntity userEntity = findById.get();
				UserAccountModel userModel = new UserAccountModel();
				BeanUtils.copyProperties(userEntity, userModel);
				return userModel;
			}
			
			return null;

	}





	@Override
	public boolean deleteUser(Long userId) {
		userAccRepo.deleteById(userId);
		return false;
	}



	




	





	




	


	
}
