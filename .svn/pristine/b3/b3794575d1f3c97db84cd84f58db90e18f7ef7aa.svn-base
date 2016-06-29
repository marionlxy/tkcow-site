package com.taikang.tkcow.moduleImg.action.impl;


import com.taikang.udp.framework.common.datastructre.impl.BaseDto;

import javax.annotation.Resource;

import com.taikang.tkcow.moduleImg.action.IModuleImgAction;
import com.taikang.tkcow.moduleImg.service.IModuleImgService;

import java.util.ArrayList;
import java.util.List;

import com.taikang.udp.framework.core.action.impl.BaseActionImpl;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;

import java.util.Arrays;

import com.taikang.udp.framework.common.datastructre.Dto;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Service;

import com.taikang.tkcow.moduleImg.model.ModuleImgBO;

/**
  * ModuleImgAction
  */
  @Service(IModuleImgAction.ACTION_ID)
public class ModuleImgActionImpl extends BaseActionImpl 
  implements IModuleImgAction {

    /**
      * 注入service
      */
    @Resource(name=IModuleImgService.SERVICE_ID)
	private IModuleImgService<ModuleImgBO> moduleImgService;	
	
	/**
	  * 增加数据
	  */
	public void insertObject(Dto param) {
		logger.debug("<======ModuleImgAction--addModuleImg======>");
		
		ModuleImgBO moduleImgBO = BaseDto.toModel(ModuleImgBO.class , param);
		moduleImgService.insertObject(moduleImgBO);
	}
	
	/**
      * 修改数据
      */
	public void updateObject(Dto param){
		logger.debug("<======ModuleImgAction--updateModuleImg======>");
		
		ModuleImgBO moduleImgBO = BaseDto.toModel(ModuleImgBO.class , param);
		moduleImgService.updateObject(moduleImgBO);
	}

	 /**
      * 删除数据
      */
	public void deleteObject(Dto param) {
		logger.debug("<======ModuleImgAction--deleteModuleImg======>");
		
		ModuleImgBO moduleImgBO = BaseDto.toModel(ModuleImgBO.class , param);
		moduleImgService.deleteObject(moduleImgBO);
	}
	
	/**
      * 查询单条数据
      */
	public Dto findOne(Dto param) {
		logger.debug("<======ModuleImgAction--findOneModuleImg======>");
		
		ModuleImgBO moduleImgBO = BaseDto.toModel(ModuleImgBO.class , param);
		return moduleImgService.findOne(moduleImgBO).toDto();//返回的BO对象自动转换成Dto返回
	}  
	
	/**
      * 查询所有数据
      */
	public List<Dto> findAll(Dto param) {
		logger.debug("<======ModuleImgAction--findAllModuleImg======>");
				
		return moduleImgService.findAllMap(param);
	} 
	
		
	 /**
      * 分页查询数据
      */
	public CurrentPage queryForPage(CurrentPage currentPage){
		logger.debug("<======ModuleImgAction--queryModuleDesForPage======>");
		
		return moduleImgService.queryForPage(currentPage);
	}

	/**
	 * 查询带图列表模板
	 */
	public List<Dto> findzjowModuleimg(Dto param) {
		logger.debug("<======ModuleImgAction--queryModuleImgForPage======>");
		Dto list = new BaseDto();
		List<Dto> dt =moduleImgService.findzjowModuleimg(param);
		JSONArray jsonObject = JSONArray.fromObject(dt);
		JSONObject  object = new JSONObject();
		for (int i = 0; i < jsonObject.size(); i++) {
			object= (JSONObject) jsonObject.get(i);
			System.out.println(object);
		}
		String modname = object.getString("mod_name");
		String title = object.getString("title");
//		if(modimgdes==null || modimgdes==""){
//			list.put("url", "tkcontent/xmly");
//			list.put("imglist", dt);
//			list.put("modname", modname);
//			list.put("modimgdes", modimgdes);
//		}else{
			list.put("url", "tkcontent/xmly");
			list.put("imglist", dt);
			list.put("modname", modname);
			list.put("title", title);
//		}
		
		List<Dto> list1 = new ArrayList<Dto>();
		list1.add(list);
		JSONArray jsonArray = JSONArray.fromObject(list1);
		System.out.println(jsonArray.toString());
		return jsonArray;
	}	
}
