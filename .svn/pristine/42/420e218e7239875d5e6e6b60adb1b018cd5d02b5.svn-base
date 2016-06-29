package com.taikang.tkcow.service.impl;
 
import java.util.List;

import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;

import java.util.Arrays;

import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.udp.framework.common.datastructre.impl.BaseDto;
import com.taikang.tkcow.service.IZjowModuleContentService;

import org.springframework.stereotype.Service;

import com.taikang.tkcow.model.ZjowModuleContentBO;
import com.taikang.tkcow.moduleDes.model.ModuleDesBO;
import com.taikang.udp.framework.core.service.impl.BaseServiceImpl;
 
  
/**
  * ZjowModuleContentServiceImpl
  */
 @Service(IZjowModuleContentService.SERVICE_ID)
 public class ZjowModuleContentServiceImpl extends BaseServiceImpl 
 implements IZjowModuleContentService<ZjowModuleContentBO>  
  {
  	 	 	
 	/**
	  * 增加数据
	  */
	public void insertObject(ZjowModuleContentBO zjowModuleContent) {
		logger.debug("<======ZjowModuleContentServiceImpl--insertZjowModuleContent======>");		
		appDao.insert("ZjowModuleContent.addZjowModuleContent",zjowModuleContent);
	} 	
 	
 	/**
      * 修改数据
      */
	public void updateObject(ZjowModuleContentBO zjowModuleContent) {
		logger.debug("<======ZjowModuleContentServiceImpl--updateZjowModuleContent======>");
		appDao.update("ZjowModuleContent.updateZjowModuleContent",zjowModuleContent);
	}

	 /**
      * 删除数据
      */
	public void deleteObject(ZjowModuleContentBO zjowModuleContent) {
		logger.debug("<======ZjowModuleContentServiceImpl--deleteZjowModuleContent======>");
		appDao.delete("ZjowModuleContent.deleteZjowModuleContent",zjowModuleContent);
	}
	
	/**
      * 查询数据
      */
	public ZjowModuleContentBO findOne(ZjowModuleContentBO zjowModuleContent) {
		logger.debug("<======ZjowModuleContentServiceImpl--findZjowModuleContent======>");
		
		ZjowModuleContentBO zjowModuleContentBackBO=appDao.queryOneObject("ZjowModuleContent.findOneZjowModuleContent", zjowModuleContent);
		return zjowModuleContentBackBO;		
	}
	
	/**
      * 查询所有数据
      */
	public List<ZjowModuleContentBO> findAll(ZjowModuleContentBO  zjowModuleContent) {
		logger.debug("<======ZjowModuleContentServiceImpl--findAllZjowModuleContent======>");
		return appDao.queryForEntityList("ZjowModuleContent.findAllZjowModuleContent", zjowModuleContent);
	}
	
	
	 /**
      * 分页查询数据
      */
	public CurrentPage queryForPage(CurrentPage currentPage) {
		logger.debug("<======ZjowModuleContentServiceImpl--queryZjowModuleContentForPage======>");
		return appDao.queryForPage("ZjowModuleContent.queryZjowModuleContentForPage", currentPage);
	}
		
	/**
      * 查询所有数据 ，重新组装为map
      */
	public List<Dto> findAllMap(Dto param){
		logger.debug("<======ZjowModuleContentServiceImpl--findAllMapZjowModuleContent======>");		
		return appDao.queryForMapList("ZjowModuleContent.findAllMapZjowModuleContent", param);
	}
	
	/**
     * 查询单挑数据
     */
	public Dto findzjowModuleOne(Dto param) {
		logger.debug("<======GoodsServiceImpl--findGoods======>");
		ModuleDesBO zjowModuleContentBO = BaseDto.toModel(ModuleDesBO.class , param);
		return  appDao.queryOneObject("ZjowModuleContent.findOnentConte", zjowModuleContentBO).toDto(); 
	}
 }
  