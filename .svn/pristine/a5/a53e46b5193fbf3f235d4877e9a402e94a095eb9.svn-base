package com.taikang.tkcow.cooperlogo.action.impl;


import com.taikang.udp.framework.common.datastructre.impl.BaseDto;
import com.taikang.tkcow.cooperlogo.service.IZjowCooperLogoService;

import javax.annotation.Resource;

import com.taikang.tkcow.cooperlogo.model.ZjowCooperLogoBO;
import com.taikang.tkcow.cooperlogo.action.IZjowCooperLogoAction;

import java.util.ArrayList;
import java.util.List;

import com.taikang.udp.framework.core.action.impl.BaseActionImpl;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;

import java.util.Arrays;

import com.taikang.udp.framework.common.datastructre.Dto;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Service;

/**
  * ZjowCooperLogoAction
  */
  @Service(IZjowCooperLogoAction.ACTION_ID)
public class ZjowCooperLogoActionImpl extends BaseActionImpl 
  implements IZjowCooperLogoAction {

    /**
      * 注入service
      */
    @Resource(name=IZjowCooperLogoService.SERVICE_ID)
	private IZjowCooperLogoService<ZjowCooperLogoBO> zjowCooperLogoService;	
	
	/**
	  * 增加数据
	  */
	public void insertObject(Dto param) {
		logger.debug("<======ZjowCooperLogoAction--addZjowCooperLogo======>");
		
		ZjowCooperLogoBO zjowCooperLogoBO = BaseDto.toModel(ZjowCooperLogoBO.class , param);
		zjowCooperLogoService.insertObject(zjowCooperLogoBO);
	}
	
	/**
      * 修改数据
      */
	public void updateObject(Dto param){
		logger.debug("<======ZjowCooperLogoAction--updateZjowCooperLogo======>");
		
		ZjowCooperLogoBO zjowCooperLogoBO = BaseDto.toModel(ZjowCooperLogoBO.class , param);
		zjowCooperLogoService.updateObject(zjowCooperLogoBO);
	}

	 /**
      * 删除数据
      */
	public void deleteObject(Dto param) {
		logger.debug("<======ZjowCooperLogoAction--deleteZjowCooperLogo======>");
		
		ZjowCooperLogoBO zjowCooperLogoBO = BaseDto.toModel(ZjowCooperLogoBO.class , param);
		zjowCooperLogoService.deleteObject(zjowCooperLogoBO);
	}
	
	/**
      * 查询单条数据
      */
	public Dto findOne(Dto param) {
		logger.debug("<======ZjowCooperLogoAction--findOneZjowCooperLogo======>");
		
		ZjowCooperLogoBO zjowCooperLogoBO = BaseDto.toModel(ZjowCooperLogoBO.class , param);
		return zjowCooperLogoService.findOne(zjowCooperLogoBO).toDto();//返回的BO对象自动转换成Dto返回
	}  
	
	/**
      * 查询logo列表所有数据
      */
	public List<Dto> findAll(Dto param) {
		logger.debug("<======ZjowCooperLogoAction--findAllZjowCooperLogo======>");
		List<Dto> dt =zjowCooperLogoService.findAllMap(param);		
		Dto dto = new BaseDto();
		for (int i = 0; i < dt.size(); i++) {
			dto.put("modname", dt.get(i).get("mod_name"));
			System.out.println(dto);
		}
		dto.put("url", "tkcontent/yzhhzhb");
		dto.put("logolist", dt);
		dto.put("size", dt.size());
		List<Dto> list = new ArrayList<Dto>();
		list.add(dto);
		return list;
	} 
	
		
	 /**
      * 分页查询数据
      */
	public CurrentPage queryForPage(CurrentPage currentPage){
		logger.debug("<======ZjowCooperLogoAction--queryZjowCooperLogoForPage======>");
		
		return zjowCooperLogoService.queryForPage(currentPage);
	}

	/**
	 * 分页查询logo
	 */
	public List<Dto> findzjowModulogopage(Dto param) {
		logger.debug("<======ZjowCooperLogoAction--findAllZjowCooperLogo======>");
		List<Dto> dt =zjowCooperLogoService.findzjowModulogopage(param);		
		Dto dto = new BaseDto();
		for (int i = 0; i < dt.size(); i++) {
			dto.put("modname", dt.get(i).get("mod_name"));
			System.out.println(dto);
		}
		dto.put("url", "tkcontent/yzhhzhb");
		dto.put("logolist", dt);
		List<Dto> list = new ArrayList<Dto>();
		list.add(dto);
		return list;
	}	
}
