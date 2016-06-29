package com.taikang.tkcow.moduleDes.action;

import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.udp.framework.core.action.IBaseAction;

import java.util.Arrays;
import java.util.List;

import org.baitanw.maomao.utils.PageBean;
import org.springframework.ui.Model;


/**
  * IModuleDesAction
  */

public interface IModuleDesAction extends IBaseAction { 

	final String ACTION_ID = "moduleDesAction"; 	
	
	public Dto findzjowModuleOne(Dto param);
	
	public List<Dto> findzjowModulebanner(Dto param);
	
	/**
 	 * 查询栏目介绍
 	 * @param param
 	 * @return
 	 */
 	public Dto findzjowlmjs(Dto param);

	public String showModuleDesPage(String urlK, Model model, PageBean pageBean);
}
