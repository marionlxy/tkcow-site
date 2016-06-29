package com.taikang.tkcow.usertk.action.impl;


import com.taikang.udp.framework.common.datastructre.impl.BaseDto;
import javax.annotation.Resource;
import com.taikang.tkcow.usertk.action.IUserTkAction;
import java.util.List;
import com.taikang.udp.framework.core.action.impl.BaseActionImpl;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;
import java.util.Arrays;
import com.taikang.udp.framework.common.datastructre.Dto;
import org.springframework.stereotype.Service;
import com.taikang.tkcow.usertk.model.UserTkBO;
import com.taikang.tkcow.usertk.service.IUserTkService;

/**
  * UserTkAction
  */
  @Service(IUserTkAction.ACTION_ID)
public class UserTkActionImpl extends BaseActionImpl 
  implements IUserTkAction {

    /**
      * 注入service
      */
    @Resource(name=IUserTkService.SERVICE_ID)
	private IUserTkService<UserTkBO> userTkService;	
	
	/**
	  * 增加数据
	  */
	public void insertObject(Dto param) {
		logger.debug("<======UserTkAction--addUserTk======>");
		
		UserTkBO userTkBO = BaseDto.toModel(UserTkBO.class , param);
		userTkService.insertObject(userTkBO);
	}
	
	/**
      * 修改数据
      */
	public void updateObject(Dto param){
		logger.debug("<======UserTkAction--updateUserTk======>");
		
		UserTkBO userTkBO = BaseDto.toModel(UserTkBO.class , param);
		userTkService.updateObject(userTkBO);
	}

	 /**
      * 删除数据
      */
	public void deleteObject(Dto param) {
		logger.debug("<======UserTkAction--deleteUserTk======>");
		
		UserTkBO userTkBO = BaseDto.toModel(UserTkBO.class , param);
		userTkService.deleteObject(userTkBO);
	}
	
	/**
      * 查询单条数据
      */
	public Dto findOne(Dto param) {
		logger.debug("<======UserTkAction--findOneUserTk======>");
		
		UserTkBO userTkBO = BaseDto.toModel(UserTkBO.class , param);
		return userTkService.findOne(userTkBO).toDto();//返回的BO对象自动转换成Dto返回
	}  
	
	/**
      * 查询所有数据
      */
	public List<Dto> findAll(Dto param) {
		logger.debug("<======UserTkAction--findAllUserTk======>");
				
		return userTkService.findAllMap(param);
	} 
	
		
	 /**
      * 分页查询数据
      */
	public CurrentPage queryForPage(CurrentPage currentPage){
		logger.debug("<======UserTkAction--queryUserTkForPage======>");
		
		return userTkService.queryForPage(currentPage);
	}	
}
