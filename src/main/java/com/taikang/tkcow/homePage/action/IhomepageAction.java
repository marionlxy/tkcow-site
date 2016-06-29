package com.taikang.tkcow.homePage.action;

import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.udp.framework.core.action.IBaseAction;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;

import java.util.Arrays;
import java.util.List;


/**
  * IhomepageAction
  */

public interface IhomepageAction extends IBaseAction { 

	final String ACTION_ID = "homepageAction";

	List<Dto> findAlLHexinMenu(Dto param);

	public List<Dto> findAllMapBottomMenu(Dto param);

	List<Dto> findAllMapOneMenu(Dto param);

	List<Dto> findAllLikeinfor(Dto param);

	CurrentPage findAllLikeinfor(CurrentPage page);

	List<Dto> findAllPageTatle(Dto param); 
	
	List<Dto> findAllByType(Dto param); 
}
