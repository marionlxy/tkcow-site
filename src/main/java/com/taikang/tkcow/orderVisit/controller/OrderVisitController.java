package com.taikang.tkcow.orderVisit.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taikang.tkcow.orderVisit.action.IOrderVisitAction;
import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.udp.framework.common.datastructre.impl.BaseDto;
import com.taikang.udp.framework.common.util.TKDateTimeUtils;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;
import com.taikang.udp.framework.core.web.BaseController;
import com.taikang.udp.sys.util.CommonUtil;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ResponseBody;

/**
  * OrderVisitController
  */
@Controller("orderVisitController")
@RequestMapping(value="/orderVisit")
public class OrderVisitController  extends BaseController  {
		
	@Resource(name=IOrderVisitAction.ACTION_ID)
	private IOrderVisitAction orderVisitAction;
		
	
	
	/**
	 * 保存新增或修改的记录，将其持久化到数据库中
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping("/save")
	@ResponseBody
	private String saveAskforClaimInfo(HttpServletRequest request ,String visitName,String visitTel,String visitCount,String visitTime,String visitSite,String visitAge,String visitSex,String visitService,String visitBak) throws ParseException
	{
		Dto map=new BaseDto();
		map.put("visitId", UUID.randomUUID().toString().replace("-", ""));
		map.put("visitName", visitName);
		map.put("visitTel", visitTel);
		map.put("visitCount", visitCount);
		map.put("visitTime", visitTime);
		map.put("visitSite", visitSite);
		map.put("visitFrom", 1);
		map.put("visitAge", visitAge);
		map.put("visitSex", visitSex);
		map.put("visitService", visitService);
		map.put("visitBak", visitBak);
		map.put("createdTime",  TKDateTimeUtils.getTodayTimeStamp()); 
		map.put("version", 0);
		map.put("delflag", 0);
		String ip =getRemortIP(request);
		map.put("userIp", ip);
		orderVisitAction.insertObject(map);
		map.put("result", "true");
		
		return map.toJson();
	}
	
	/**
	 * 获取ip
	 */
	
	public String getRemortIP(HttpServletRequest request) {

		if (request.getHeader("x-forwarded-fo") == null) {

		return request.getRemoteAddr();

		}

		return request.getHeader("x-forwarded-for");

		}
	/**
	 * 打开主查询页面
	 * @return 页面地址
	 */
	@RequestMapping("")
	public String showOrderVisitIndexPage() {
		return "orderVisit/orderVisitIndex"; 
	}
	
	/**
	 * 查询信息列表
	 * @return 分页列表数据
	 */
	@RequestMapping("/list")
	@ResponseBody
	public Map<String,Object> getOrderVisitList(HttpServletRequest request,CurrentPage page){
		Map<String, Object> map = new HashMap<String, Object>();
		
		page.setParamObject(CommonUtil.getParamAsDto(request));
		CurrentPage currentPage = orderVisitAction.queryForPage(page);
		
		map.put("rows", currentPage.getPageItems());
		map.put("total", currentPage.getTotalRows());
		
		return map;
	}

	/**
	 * 打开新增或修改页面
	 * @return
	 */
	@RequestMapping("edit")
	public String showOrderVisitEditPage(String rowId,Model model) {
		
		if(rowId!=null && !rowId.equals(""))
		{
			model.addAttribute("rowId",rowId );
		}
		
		return "orderVisit/orderVisitEdit"; 
	}
	
	/**
	 * 获取一条记录详细信息，用来填充修改界面
	 * @return
	 */
	@RequestMapping("/getOne")
	@ResponseBody
	public Dto getOrderVisitById(@RequestParam("rowId")String rowId)
	{
		Dto param = new BaseDto();
		param.put("rowId", rowId);
		return orderVisitAction.findOne(param);
	}
	
	/**
	 * 保存新增或修改的记录，将其持久化到数据库中
	 * @return
	 */
	@RequestMapping("/saveT")
	@ResponseBody
	private Map<String,String> saveOrderVisitInfo(HttpServletRequest request)
	{
		Map<String,String> map=new HashMap<String,String>();
		
		Dto param = CommonUtil.getParamAsDto(request);
		if(param.get("rowId") ==null ||"".equals(param.get("rowId")))
		{
			orderVisitAction.insertObject(param);
			map.put(MESSAGE_INFO, "新增成功！");
		}
		else
		{
			orderVisitAction.updateObject(param);
			map.put(MESSAGE_INFO, "更新成功！");
		}
		map.put(RTN_RESULT, "true");
		
		return map;
	}
	
	/**
	*删除一条或多条记录
	*/
	@RequestMapping(value="/del")
	@ResponseBody
	public Map<String, String> deleteOrderVisit(@RequestParam("rowId") String rowId) {
		Map<String, String> map = new HashMap<String, String>();
		Dto param = new BaseDto();
		param.put("rowId", rowId);
		orderVisitAction.deleteObject(param);
		
		map.put(RTN_RESULT, "true");
		map.put(MESSAGE_INFO, "操作成功！");
		
		return map;
	}
}

