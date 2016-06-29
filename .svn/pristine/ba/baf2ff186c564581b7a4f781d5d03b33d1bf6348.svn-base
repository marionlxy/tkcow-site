package com.taikang.tkcow.homePage.action.impl;


import com.taikang.udp.framework.common.datastructre.impl.BaseDto;
import javax.annotation.Resource;
import com.taikang.tkcow.homePage.action.IhomepageAction;
import com.taikang.tkcow.homePage.service.IhomepageService;
import java.util.List;
import com.taikang.udp.framework.core.action.impl.BaseActionImpl;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;
import java.util.Arrays;
import com.taikang.tkcow.homePage.model.homepageBO;
import com.taikang.udp.framework.common.datastructre.Dto;
import org.springframework.stereotype.Service;

/**
  * homepageAction
  */
  @Service(IhomepageAction.ACTION_ID)
public class homepageActionImpl extends BaseActionImpl 
  implements IhomepageAction {

    /**
      * 注入service
      */
    @Resource(name=IhomepageService.SERVICE_ID)
	private IhomepageService<homepageBO> homepageService;	
	
	/**
	  * 增加数据
	  */
	public void insertObject(Dto param) {
		logger.debug("<======homepageAction--addhomepage======>");
		
		homepageBO homepageBO = BaseDto.toModel(homepageBO.class , param);
		homepageService.insertObject(homepageBO);
	}
	
	/**
      * 修改数据
      */
	public void updateObject(Dto param){
		logger.debug("<======homepageAction--updatehomepage======>");
		
		homepageBO homepageBO = BaseDto.toModel(homepageBO.class , param);
		homepageService.updateObject(homepageBO);
	}

	 /**
      * 删除数据
      */
	public void deleteObject(Dto param) {
		logger.debug("<======homepageAction--deletehomepage======>");
		
		homepageBO homepageBO = BaseDto.toModel(homepageBO.class , param);
		homepageService.deleteObject(homepageBO);
	}
	
	/**
      * 查询单条数据
      */
	public Dto findOne(Dto param) {
		logger.debug("<======homepageAction--findOnehomepage======>");
		
		homepageBO homepageBO = BaseDto.toModel(homepageBO.class , param);
		return homepageService.findOne(homepageBO).toDto();//返回的BO对象自动转换成Dto返回
	}  
	
	/**
      * 查询所有数据
      */
	public List<Dto> findAll(Dto param) {
		logger.debug("<======homepageAction--findAllhomepage======>");
				
		return homepageService.findAllMap(param);
	} 
	
	/**
     * 查询核心菜单所有数据
     */
	public List<Dto> findAlLHexinMenu(Dto param) {
		logger.debug("<======homepageAction--findAllhomepage======>");
				
		return homepageService.findAlLHexinMenu(param);
	}
	
	/**
     * 查询底部菜单所有数据
     */
	public List<Dto> findAllMapBottomMenu(Dto param) {
		logger.debug("<======homepageAction--findAllMapBottomMenu======>");
				
		return homepageService.findAllMapBottomMenu(param);
	} 
	
	/**
     * 查询首页一级菜单所有数据
     */
	public List<Dto> findAllMapOneMenu(Dto param) {
		logger.debug("<======homepageAction--findAllMapOneMenu======>");
				
		return homepageService.findAllMapOneMenu(param);
	} 
	
	/**
     * 首页搜索功能
     */
	public List<Dto> findAllLikeinfor(Dto param) {
		logger.debug("<======homepageAction--findAllLikeinfor======>");
				
		return homepageService.findAllLikeinfor(param);
	} 
	
	/**
     * 首页搜索信息总条数
     */
	public List<Dto> findAllPageTatle(Dto param) {
		logger.debug("<======homepageAction--findAllPageTatle======>");
				
		return homepageService.findAllPageTatle(param);
	} 
	
		
	 /**
      * 分页查询数据
      */
	public CurrentPage queryForPage(CurrentPage currentPage){
		logger.debug("<======homepageAction--queryhomepageForPage======>");
		
		return homepageService.queryForPage(currentPage);
	}

	@Override
	public CurrentPage findAllLikeinfor(CurrentPage page) {
		return null;
	}
	
	public List<Dto> findAllByType(Dto param) {
		return homepageService.findAllByType(param);
	}
}
