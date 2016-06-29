package com.taikang.tkcow.action.impl;


import com.taikang.udp.framework.common.datastructre.impl.BaseDto;
import javax.annotation.Resource;
import com.taikang.tkcow.action.IZjowModuleContentAction;
import java.util.List;
import com.taikang.udp.framework.core.action.impl.BaseActionImpl;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;
import java.util.Arrays;
import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.tkcow.service.IZjowModuleContentService;
import org.springframework.stereotype.Service;
import com.taikang.tkcow.model.ZjowModuleContentBO;

/**
  * ZjowModuleContentAction
  */
  @Service(IZjowModuleContentAction.ACTION_ID)
public class ZjowModuleContentActionImpl extends BaseActionImpl 
  implements IZjowModuleContentAction {

    /**
      * 注入service
      */
    @Resource(name=IZjowModuleContentService.SERVICE_ID)
	private IZjowModuleContentService<ZjowModuleContentBO> zjowModuleContentService;	
	
	/**
	  * 增加数据
	  */
	public void insertObject(Dto param) {
		logger.debug("<======ZjowModuleContentAction--addZjowModuleContent======>");
		
		ZjowModuleContentBO zjowModuleContentBO = BaseDto.toModel(ZjowModuleContentBO.class , param);
		zjowModuleContentService.insertObject(zjowModuleContentBO);
	}
	
	/**
      * 修改数据
      */
	public void updateObject(Dto param){
		logger.debug("<======ZjowModuleContentAction--updateZjowModuleContent======>");
		
		ZjowModuleContentBO zjowModuleContentBO = BaseDto.toModel(ZjowModuleContentBO.class , param);
		zjowModuleContentService.updateObject(zjowModuleContentBO);
	}

	 /**
      * 删除数据
      */
	public void deleteObject(Dto param) {
		logger.debug("<======ZjowModuleContentAction--deleteZjowModuleContent======>");
		
		ZjowModuleContentBO zjowModuleContentBO = BaseDto.toModel(ZjowModuleContentBO.class , param);
		zjowModuleContentService.deleteObject(zjowModuleContentBO);
	}
	
 
	
	/**
      * 查询所有数据
      */
	public List<Dto> findAll(Dto param) {
		logger.debug("<======ZjowModuleContentAction--findAllZjowModuleContent======>");
				
		return zjowModuleContentService.findAllMap(param);
	} 
	
		
	 /**
      * 分页查询数据
      */
	public CurrentPage queryForPage(CurrentPage currentPage){
		logger.debug("<======ZjowModuleContentAction--queryZjowModuleContentForPage======>");
		
		return zjowModuleContentService.queryForPage(currentPage);
	}	
	public Dto findzjowModuleOne(Dto param) {
		logger.debug("<======ZjowModuleContentAction--findOneZjowModuleContent======>");
		return zjowModuleContentService.findzjowModuleOne(param);//返回的BO对象自动转换成Dto返回
	}

	/* (non-Javadoc)
	 * @see com.taikang.udp.framework.core.action.IBaseAction#findOne(com.taikang.udp.framework.common.datastructre.Dto)
	 */
	@Override
	public Dto findOne(Dto param) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
