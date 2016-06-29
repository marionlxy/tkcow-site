package com.taikang.tkcow.cooperlogo.service.impl;
 
import com.taikang.tkcow.cooperlogo.service.IZjowCooperLogoService;
import com.taikang.tkcow.cooperlogo.model.ZjowCooperLogoBO;
import java.util.List;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;
import java.util.Arrays;
import com.taikang.udp.framework.common.datastructre.Dto;
import org.springframework.stereotype.Service;
import com.taikang.udp.framework.core.service.impl.BaseServiceImpl;
 
  
/**
  * ZjowCooperLogoServiceImpl
  */
 @Service(IZjowCooperLogoService.SERVICE_ID)
 public class ZjowCooperLogoServiceImpl extends BaseServiceImpl 
 implements IZjowCooperLogoService<ZjowCooperLogoBO>  
  {
  	 	 	
 	/**
	  * 增加数据
	  */
	public void insertObject(ZjowCooperLogoBO zjowCooperLogo) {
		logger.debug("<======ZjowCooperLogoServiceImpl--insertZjowCooperLogo======>");		
		appDao.insert("ZjowCooperLogo.addZjowCooperLogo",zjowCooperLogo);
	} 	
 	
 	/**
      * 修改数据
      */
	public void updateObject(ZjowCooperLogoBO zjowCooperLogo) {
		logger.debug("<======ZjowCooperLogoServiceImpl--updateZjowCooperLogo======>");
		appDao.update("ZjowCooperLogo.updateZjowCooperLogo",zjowCooperLogo);
	}

	 /**
      * 删除数据
      */
	public void deleteObject(ZjowCooperLogoBO zjowCooperLogo) {
		logger.debug("<======ZjowCooperLogoServiceImpl--deleteZjowCooperLogo======>");
		appDao.delete("ZjowCooperLogo.deleteZjowCooperLogo",zjowCooperLogo);
	}
	
	/**
      * 查询数据
      */
	public ZjowCooperLogoBO findOne(ZjowCooperLogoBO zjowCooperLogo) {
		logger.debug("<======ZjowCooperLogoServiceImpl--findZjowCooperLogo======>");
		
		ZjowCooperLogoBO zjowCooperLogoBackBO=appDao.queryOneObject("ZjowCooperLogo.findOneZjowCooperLogo", zjowCooperLogo);
		return zjowCooperLogoBackBO;		
	}
	
	/**
      * 查询所有数据
      */
	public List<ZjowCooperLogoBO> findAll(ZjowCooperLogoBO  zjowCooperLogo) {
		logger.debug("<======ZjowCooperLogoServiceImpl--findAllZjowCooperLogo======>");
		return appDao.queryForEntityList("ZjowCooperLogo.findAllZjowCooperLogo", zjowCooperLogo);
	}
	
	
	 /**
      * 分页查询数据
      */
	public CurrentPage queryForPage(CurrentPage currentPage) {
		logger.debug("<======ZjowCooperLogoServiceImpl--queryZjowCooperLogoForPage======>");
		return appDao.queryForPage("ZjowCooperLogo.queryZjowCooperLogoForPage", currentPage);
	}
		
	/**
      * 查询所有数据 ，重新组装为map
      */
	public List<Dto> findAllMap(Dto param){
		logger.debug("<======ZjowCooperLogoServiceImpl--findAllMapZjowCooperLogo======>");		
		return appDao.queryForMapList("ZjowCooperLogo.findAllMapZjowCooperLogo", param);
	}

	/**
	 * 分页查询logo
	 */
	public List<Dto> findzjowModulogopage(Dto param) {
		logger.debug("<======ZjowCooperLogoServiceImpl--findzjowModulogopage======>");		
		return appDao.queryForMapList("ZjowCooperLogo.findzjowModulogopage", param);
	}
 }
  