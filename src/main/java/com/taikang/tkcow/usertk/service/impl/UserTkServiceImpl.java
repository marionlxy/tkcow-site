package com.taikang.tkcow.usertk.service.impl;
 
import java.util.List;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;
import java.util.Arrays;
import com.taikang.udp.framework.common.datastructre.Dto;
import org.springframework.stereotype.Service;
import com.taikang.tkcow.usertk.model.UserTkBO;
import com.taikang.tkcow.usertk.service.IUserTkService;
import com.taikang.udp.framework.core.service.impl.BaseServiceImpl;
 
  
/**
  * UserTkServiceImpl
  */
 @Service(IUserTkService.SERVICE_ID)
 public class UserTkServiceImpl extends BaseServiceImpl 
 implements IUserTkService<UserTkBO>  
  {
  	 	 	
 	/**
	  * 增加数据
	  */
	public void insertObject(UserTkBO userTk) {
		logger.debug("<======UserTkServiceImpl--insertUserTk======>");		
		appDao.insert("UserTk.addUserTk",userTk);
	} 	
 	
 	/**
      * 修改数据
      */
	public void updateObject(UserTkBO userTk) {
		logger.debug("<======UserTkServiceImpl--updateUserTk======>");
		appDao.update("UserTk.updateUserTk",userTk);
	}

	 /**
      * 删除数据
      */
	public void deleteObject(UserTkBO userTk) {
		logger.debug("<======UserTkServiceImpl--deleteUserTk======>");
		appDao.delete("UserTk.deleteUserTk",userTk);
	}
	
	/**
      * 查询数据
      */
	public UserTkBO findOne(UserTkBO userTk) {
		logger.debug("<======UserTkServiceImpl--findUserTk======>");
		
		UserTkBO userTkBackBO=appDao.queryOneObject("UserTk.findOneUserTk", userTk);
		return userTkBackBO;		
	}
	
	/**
      * 查询所有数据
      */
	public List<UserTkBO> findAll(UserTkBO  userTk) {
		logger.debug("<======UserTkServiceImpl--findAllUserTk======>");
		return appDao.queryForEntityList("UserTk.findAllUserTk", userTk);
	}
	
	
	 /**
      * 分页查询数据
      */
	public CurrentPage queryForPage(CurrentPage currentPage) {
		logger.debug("<======UserTkServiceImpl--queryUserTkForPage======>");
		return appDao.queryForPage("UserTk.queryUserTkForPage", currentPage);
	}
		
	/**
      * 查询所有数据 ，重新组装为map
      */
	public List<Dto> findAllMap(Dto param){
		logger.debug("<======UserTkServiceImpl--findAllMapUserTk======>");		
		return appDao.queryForMapList("UserTk.findAllMapUserTk", param);
	}
 }
  