package com.taikang.tkcow.homePage.service.impl;
 
import com.taikang.tkcow.homePage.service.IhomepageService;
import java.util.List;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;
import java.util.Arrays;
import com.taikang.tkcow.homePage.model.homepageBO;
import com.taikang.udp.framework.common.datastructre.Dto;
import org.springframework.stereotype.Service;
import com.taikang.udp.framework.core.service.impl.BaseServiceImpl;
 
  
/**
  * homepageServiceImpl
  */
 @Service(IhomepageService.SERVICE_ID)
 public class homepageServiceImpl extends BaseServiceImpl 
 implements IhomepageService<homepageBO>  
  {
  	 	 	
 	/**
	  * 增加数据
	  */
	public void insertObject(homepageBO homepage) {
		logger.debug("<======homepageServiceImpl--inserthomepage======>");		
		appDao.insert("homepage.addhomepage",homepage);
	} 	
 	
 	/**
      * 修改数据
      */
	public void updateObject(homepageBO homepage) {
		logger.debug("<======homepageServiceImpl--updatehomepage======>");
		appDao.update("homepage.updatehomepage",homepage);
	}

	 /**
      * 删除数据
      */
	public void deleteObject(homepageBO homepage) {
		logger.debug("<======homepageServiceImpl--deletehomepage======>");
		appDao.delete("homepage.deletehomepage",homepage);
	}
	
	/**
      * 查询数据
      */
	public homepageBO findOne(homepageBO homepage) {
		logger.debug("<======homepageServiceImpl--findhomepage======>");
		
		homepageBO homepageBackBO=appDao.queryOneObject("homepage.findOnehomepage", homepage);
		return homepageBackBO;		
	}
	
	/**
      * 查询所有数据
      */
	public List<homepageBO> findAll(homepageBO  homepage) {
		logger.debug("<======homepageServiceImpl--findAllhomepage======>");
		return appDao.queryForEntityList("homepage.findAllhomepage", homepage);
	}
	
	
	 /**
      * 分页查询数据
      */
	public CurrentPage queryForPage(CurrentPage currentPage) {
		logger.debug("<======homepageServiceImpl--queryhomepageForPage======>");
		return appDao.queryForPage("homepage.queryhomepageForPage", currentPage);
	}
		
	/**
      * 查询所有数据 ，重新组装为map
      */
	public List<Dto> findAllMap(Dto param){
		logger.debug("<======homepageServiceImpl--findAllMaphomepage======>");		
		return appDao.queryForMapList("homepage.findAllMaphomepage", param);
	}
	
	/**
     * 查询核心菜单数据 ，重新组装为map
     */
	public List<Dto> findAlLHexinMenu(Dto param){
		logger.debug("<======homepageServiceImpl--findAlLHexinMenu======>");		
		return appDao.queryForMapList("homepage.findAlLHexinMenu", param);
	}
	
	
	/**
     * 查询首页底部菜单 ，重新组装为map
     */
	public List<Dto> findAllMapBottomMenu(Dto param){
		logger.debug("<======findAllMapBottomMenu--	findAllMapBottomMenu======>");		
		return appDao.queryForMapList("homepage.findAllMapBottomMenu", param);
	}
	
	/**
     * 查询首页一级菜单 ，重新组装为map
     */
	public List<Dto> findAllMapOneMenu(Dto param){
		logger.debug("<======findAllMapOneMenu--	findAllMapOneMenu======>");		
		return appDao.queryForMapList("homepage.findAllMapOneMenu", param);
	}
	
	/**
	 * 首页搜索功能
	 */
	public List<Dto> findAllLikeinfor(Dto param){
		logger.debug("<======findAllLikeinfor--	findAllLikeinfor======>");		
		return appDao.queryForMapList("homepage.findAllLikeinfor", param);
	}
	
	/**
	 * 搜索信息总条数
	 */
	public List<Dto> findAllPageTatle(Dto param){
		logger.debug("<======findAllLikeinfor--	findPageTatle======>");		
		return appDao.queryForMapList("homepage.findPageTatle", param);
	}
	
	public List<Dto> findAllByType(Dto param) {
		logger.debug("<======findAllByType--	findPageTatle======>");		
		return appDao.queryForMapList("homepage.findAllByType", param);
	}
 }
  