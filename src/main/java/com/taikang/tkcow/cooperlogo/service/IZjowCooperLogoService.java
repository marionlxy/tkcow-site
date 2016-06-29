package com.taikang.tkcow.cooperlogo.service;

import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.udp.framework.core.service.IBaseService;

import java.util.Arrays;
import java.util.List;

/**
  * IZjowCooperLogoService
  */
 
 public interface IZjowCooperLogoService<T> extends IBaseService<T>{
 
 	final String SERVICE_ID = "zjowCooperLogoService";  
 	
 	
 	/**
 	 * 分页查询所有logo
 	 * @param param
 	 * @return
 	 */
 	public List<Dto> findzjowModulogopage(Dto param);
 }
 
 
 