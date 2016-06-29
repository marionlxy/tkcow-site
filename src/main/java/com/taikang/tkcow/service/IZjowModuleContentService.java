package com.taikang.tkcow.service;

import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.udp.framework.core.service.IBaseService;

import java.util.Arrays;

/**
  * IZjowModuleContentService
  */
 
 public interface IZjowModuleContentService<T> extends IBaseService<T>{
 
 	final String SERVICE_ID = "zjowModuleContentService";
 	
 	public Dto findzjowModuleOne(Dto param);
 }
 
 
 