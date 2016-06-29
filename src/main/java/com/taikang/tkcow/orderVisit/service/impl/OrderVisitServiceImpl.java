package com.taikang.tkcow.orderVisit.service.impl;
 
import com.taikang.tkcow.orderVisit.service.IOrderVisitService;
import java.util.List;
import com.taikang.tkcow.orderVisit.model.OrderVisitBO;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;
import java.util.Arrays;
import com.taikang.udp.framework.common.datastructre.Dto;
import org.springframework.stereotype.Service;
import com.taikang.udp.framework.core.service.impl.BaseServiceImpl;
 
  
/**
  * OrderVisitServiceImpl
  */
 @Service(IOrderVisitService.SERVICE_ID)
 public class OrderVisitServiceImpl extends BaseServiceImpl 
 implements IOrderVisitService<OrderVisitBO>  
  {
  	 	 	
 	/**
	  * 增加数据
	  */
	public void insertObject(OrderVisitBO orderVisit) {
		logger.debug("<======OrderVisitServiceImpl--insertOrderVisit======>");		
		appDao.insert("OrderVisit.addOrderVisit",orderVisit);
	} 	
 	
 	/**
      * 修改数据
      */
	public void updateObject(OrderVisitBO orderVisit) {
		logger.debug("<======OrderVisitServiceImpl--updateOrderVisit======>");
		appDao.update("OrderVisit.updateOrderVisit",orderVisit);
	}

	 /**
      * 删除数据
      */
	public void deleteObject(OrderVisitBO orderVisit) {
		logger.debug("<======OrderVisitServiceImpl--deleteOrderVisit======>");
		appDao.delete("OrderVisit.deleteOrderVisit",orderVisit);
	}
	
	/**
      * 查询数据
      */
	public OrderVisitBO findOne(OrderVisitBO orderVisit) {
		logger.debug("<======OrderVisitServiceImpl--findOrderVisit======>");
		
		OrderVisitBO orderVisitBackBO=appDao.queryOneObject("OrderVisit.findOneOrderVisit", orderVisit);
		return orderVisitBackBO;		
	}
	
	/**
      * 查询所有数据
      */
	public List<OrderVisitBO> findAll(OrderVisitBO  orderVisit) {
		logger.debug("<======OrderVisitServiceImpl--findAllOrderVisit======>");
		return appDao.queryForEntityList("OrderVisit.findAllOrderVisit", orderVisit);
	}
	
	
	 /**
      * 分页查询数据
      */
	public CurrentPage queryForPage(CurrentPage currentPage) {
		logger.debug("<======OrderVisitServiceImpl--queryOrderVisitForPage======>");
		return appDao.queryForPage("OrderVisit.queryOrderVisitForPage", currentPage);
	}
		
	/**
      * 查询所有数据 ，重新组装为map
      */
	public List<Dto> findAllMap(Dto param){
		logger.debug("<======OrderVisitServiceImpl--findAllMapOrderVisit======>");		
		return appDao.queryForMapList("OrderVisit.findAllMapOrderVisit", param);
	}
 }
  