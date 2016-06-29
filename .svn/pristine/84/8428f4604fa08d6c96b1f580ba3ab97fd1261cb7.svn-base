package com.taikang.tkcow.service.impl;
 
import java.util.List;
import com.taikang.tkcow.model.leftMenuBO;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;
import java.util.Arrays;
import com.taikang.udp.framework.common.datastructre.Dto;
import org.springframework.stereotype.Service;
import com.taikang.tkcow.service.IleftMenuService;
import com.taikang.udp.framework.core.service.impl.BaseServiceImpl;
 
  
/**
  * leftMenuServiceImpl
  */
 @Service(IleftMenuService.SERVICE_ID)
 public class leftMenuServiceImpl extends BaseServiceImpl 
 implements IleftMenuService<leftMenuBO>  
  {
  	 	 	
 	/**
	  * 增加数据
	  */
	public void insertObject(leftMenuBO leftMenu) {
		logger.debug("<======leftMenuServiceImpl--insertleftMenu======>");		
		appDao.insert("leftMenu.addleftMenu",leftMenu);
	} 	
 	
 	/**
      * 修改数据
      */
	public void updateObject(leftMenuBO leftMenu) {
		logger.debug("<======leftMenuServiceImpl--updateleftMenu======>");
		appDao.update("leftMenu.updateleftMenu",leftMenu);
	}

	 /**
      * 删除数据
      */
	public void deleteObject(leftMenuBO leftMenu) {
		logger.debug("<======leftMenuServiceImpl--deleteleftMenu======>");
		appDao.delete("leftMenu.deleteleftMenu",leftMenu);
	}
	
	/**
      * 查询数据
      */
	public leftMenuBO findOne(leftMenuBO leftMenu) {
		logger.debug("<======leftMenuServiceImpl--findleftMenu======>");
		
		leftMenuBO leftMenuBackBO=appDao.queryOneObject("leftMenu.findOneleftMenu", leftMenu);
		return leftMenuBackBO;		
	}
	
	/**
      * 查询所有数据
      */
	public List<leftMenuBO> findAll(leftMenuBO  leftMenu) {
		logger.debug("<======leftMenuServiceImpl--findAllleftMenu======>");
		return appDao.queryForEntityList("leftMenu.findAllleftMenu", leftMenu);
	}
	
	
	 /**
      * 分页查询数据
      */
	public CurrentPage queryForPage(CurrentPage currentPage) {
		logger.debug("<======leftMenuServiceImpl--queryleftMenuForPage======>");
		return appDao.queryForPage("leftMenu.queryleftMenuForPage", currentPage);
	}
		
	/**
      * 查询所有数据 ，重新组装为map
      */
	public List<Dto> findAllMap(Dto param){
		logger.debug("<======leftMenuServiceImpl--findAllMapleftMenu======>");		
		return appDao.queryForMapList("leftMenu.findAllMapleftMenu", param);
	}
 }
  