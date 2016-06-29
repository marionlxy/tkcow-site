package com.taikang.tkcow.action.impl;


import com.taikang.udp.framework.common.datastructre.impl.BaseDto;
import javax.annotation.Resource;
import java.util.List;
import com.taikang.udp.framework.core.action.impl.BaseActionImpl;
import com.taikang.tkcow.model.leftMenuBO;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;
import java.util.Arrays;
import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.tkcow.action.IleftMenuAction;
import org.springframework.stereotype.Service;
import com.taikang.tkcow.service.IleftMenuService;

/**
  * leftMenuAction
  */
  @Service(IleftMenuAction.ACTION_ID)
public class leftMenuActionImpl extends BaseActionImpl 
  implements IleftMenuAction {

    /**
      * 注入service
      */
    @Resource(name=IleftMenuService.SERVICE_ID)
	private IleftMenuService<leftMenuBO> leftMenuService;	
	
	/**
	  * 增加数据
	  */
	public void insertObject(Dto param) {
		logger.debug("<======leftMenuAction--addleftMenu======>");
		
		leftMenuBO leftMenuBO = BaseDto.toModel(leftMenuBO.class , param);
		leftMenuService.insertObject(leftMenuBO);
	}
	
	/**
      * 修改数据
      */
	public void updateObject(Dto param){
		logger.debug("<======leftMenuAction--updateleftMenu======>");
		
		leftMenuBO leftMenuBO = BaseDto.toModel(leftMenuBO.class , param);
		leftMenuService.updateObject(leftMenuBO);
	}

	 /**
      * 删除数据
      */
	public void deleteObject(Dto param) {
		logger.debug("<======leftMenuAction--deleteleftMenu======>");
		
		leftMenuBO leftMenuBO = BaseDto.toModel(leftMenuBO.class , param);
		leftMenuService.deleteObject(leftMenuBO);
	}
	
	/**
      * 查询单条数据
      */
	public Dto findOne(Dto param) {
		logger.debug("<======leftMenuAction--findOneleftMenu======>");
		
		leftMenuBO leftMenuBO = BaseDto.toModel(leftMenuBO.class , param);
		return leftMenuService.findOne(leftMenuBO).toDto();//返回的BO对象自动转换成Dto返回
	}  
	
	/**
      * 查询所有数据
      */
	public List<Dto> findAll(Dto param) {
		logger.debug("<======leftMenuAction--findAllleftMenu======>");
				
		return leftMenuService.findAllMap(param);
	} 
	
		
	 /**
      * 分页查询数据
      */
	public CurrentPage queryForPage(CurrentPage currentPage){
		logger.debug("<======leftMenuAction--queryleftMenuForPage======>");
		
		return leftMenuService.queryForPage(currentPage);
	}	
}
