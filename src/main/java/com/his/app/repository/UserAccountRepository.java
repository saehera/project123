package com.his.app.repository;

import java.io.Serializable;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.his.app.entity.UserAccountEntity;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccountEntity, Serializable>{
	
	
	public UserAccountEntity  findByUserPwd(String userPwd);
	
	@Transactional
    @Modifying
	@Query("UPDATE  UserAccountEntity SET activeSw=?2 WHERE userAccId=?1")
	public int updateByActiveSw(Integer userId,String activeSw);

	//@Query("select * from UserAccountEntity where userId=:")
	//public UserAccountEntity  getUserId(Long userId);
}
