package com.taikang.tkcow.moduleContent.action;

import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.udp.framework.core.action.IBaseAction;

import java.util.Arrays;
import java.util.List;


/**
  * IModuleContentAction
  */

public interface IModuleContentAction extends IBaseAction { 

	final String ACTION_ID = "moduleContentAction"; 	
	
	/**
 	 * 查询单条数据
 	 * @param param
 	 * @return
 	 */
 	public Dto findzjowModuleconOne(Dto param);
 	
 	/**
 	 * 查询所有下级栏目子栏目内容图片
 	 * @param param
 	 * @return
 	 */
 	public List<Dto> findzjowModulecont(Dto param);
 	
 	/**
 	 * 查询所有新闻事件
 	 * @param param
 	 * @return
 	 */
 	public List<Dto> findzjowModulexwsj(Dto param);
 	
 	/**
 	 * 查询新闻单个详细内容
 	 * @param param
 	 * @return
 	 */
 	public Dto findxwOne(Dto param);
 	
 	/**
 	 * 查询上一篇内容
 	 * @param param
 	 * @return
 	 */
 	public Dto findupxwOne(Dto param);
 	
 	/**
 	 * 查询下一篇内容
 	 * @param param
 	 * @return
 	 */
 	public Dto finddoxwOne(Dto param);
 	
 	/**
 	 * 分页查询所有新闻事件
 	 * @param param
 	 * @return
 	 */
 	public List<Dto> findzjowModulexwsjpage(Dto param);
 	
 	/**
 	 * 查询关于我们父节点内容(类型为07)
 	 * @param param
 	 * @return
 	 */
 	public Dto findparOne(Dto param);
 	
 	/**
 	 * 查询关于我们子节点内容(类型为07)
 	 * @param param
 	 * @return
 	 */
 	public List<Dto> findchilrOne(Dto param);
}
