package com.taikang.tkcow.banner.action;

import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.udp.framework.core.action.IBaseAction;

import java.util.Arrays;
import java.util.List;


/**
  * IBannerAction
  */

public interface IBannerAction extends IBaseAction { 

	final String ACTION_ID = "bannerAction";

	public List<Dto> findAllMapHomeBanner(Dto param); 	
}
