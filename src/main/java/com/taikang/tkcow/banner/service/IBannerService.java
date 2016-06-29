package com.taikang.tkcow.banner.service;

import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.udp.framework.core.service.IBaseService;

import java.util.Arrays;
import java.util.List;

/**
  * IBannerService
  */
 
 public interface IBannerService<T> extends IBaseService<T>{
 
 	final String SERVICE_ID = "bannerService";

	public  List<Dto> findAllMapHomeBanner(Dto param);  	
 }
 
 
 