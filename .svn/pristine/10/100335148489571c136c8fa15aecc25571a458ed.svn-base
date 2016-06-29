package com.taikang.tkcow.controller;

import java.util.Map;

import com.taikang.tkcow.action.IZjowModuleContentAction;
import com.taikang.tkcow.moduleDes.action.IModuleDesAction;

import java.util.List;

import org.springframework.stereotype.Controller;

import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;
import com.taikang.udp.framework.common.datastructre.Dto;

import java.util.HashMap;

import com.taikang.udp.framework.common.datastructre.impl.BaseDto;

import javax.annotation.Resource;

import com.taikang.udp.framework.core.web.BaseController;
import com.taikang.udp.sys.util.CommonUtil;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;


/**
  * 查询模块内容，图片列表
  */
@Controller("zjowModuleContentController")
@RequestMapping(value="/zjowModuleContent")
public class ZjowModuleContentController  extends BaseController  {
		
	@Resource(name=IZjowModuleContentAction.ACTION_ID)
	private IZjowModuleContentAction zjowModuleContentAction;
	@Resource(name=IModuleDesAction.ACTION_ID)
	private IModuleDesAction moduleDesAction;
		
		
	/**
	 * 打开主查询页面
	 * @return 页面地址
	 */
	@RequestMapping("")
	public String showZjowModuleContentIndexPage() {
		return "zjowModuleContent/zjowModuleContentIndex"; 
	}
	
	/**
	 * 查询叶子内容模板
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/contentfindOnelist")
	@ResponseBody
	public Dto getZjowModuleContentfindOne(@RequestParam("modId")String modId,@RequestParam("modType")String modType){
		Dto map = new BaseDto();
		map.put("modId", modId); //模块id
		map.put("modType", modType); // 模块类型
		Dto d = zjowModuleContentAction.findzjowModuleOne(map);
		return d;
	}
	
	
	/**
	 * 查询叶子内容模板
	 * @return 分页列表数据
	 */
	@RequestMapping("/list")
	@ResponseBody
	public Map<String,Object> getZjowModuleContentList(HttpServletRequest request,CurrentPage page){
		Map<String, Object> map = new HashMap<String, Object>();
		page.setParamObject(CommonUtil.getParamAsDto(request));
		CurrentPage currentPage = zjowModuleContentAction.queryForPage(page);
		
		map.put("rows", currentPage.getPageItems());
		map.put("total", currentPage.getTotalRows());
		
		return map;
	}

	
	/**
	 * 打开新增或修改页面
	 * @return
	 */
	@RequestMapping("edit")
	public String showZjowModuleContentEditPage(String rowId,Model model) {
		
		if(rowId!=null && !rowId.equals(""))
		{
			model.addAttribute("rowId",rowId );
		}
		
		return "zjowModuleContent/zjowModuleContentEdit"; 
	}
	
	/**
	 * 获取一条记录详细信息，用来填充修改界面
	 * @return
	 */
	@RequestMapping("/getOne")
	@ResponseBody
	public Dto getZjowModuleContentById(@RequestParam("rowId")String rowId)
	{
		Dto param = new BaseDto();
		param.put("rowId", rowId);
		return zjowModuleContentAction.findOne(param);
	}
	
	/**
	 * 保存新增或修改的记录，将其持久化到数据库中
	 * @return
	 */
	@RequestMapping("/save")
	@ResponseBody
	private Map<String,String> saveZjowModuleContentInfo(HttpServletRequest request)
	{
		Map<String,String> map=new HashMap<String,String>();
		
		Dto param = CommonUtil.getParamAsDto(request);
		if(param.get("rowId") ==null ||"".equals(param.get("rowId")))
		{
			zjowModuleContentAction.insertObject(param);
			map.put(MESSAGE_INFO, "新增成功！");
		}
		else
		{
			zjowModuleContentAction.updateObject(param);
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
	public Map<String, String> deleteZjowModuleContent(@RequestParam("rowId") String rowId) {
		Map<String, String> map = new HashMap<String, String>();
		Dto param = new BaseDto();
		param.put("rowId", rowId);
		zjowModuleContentAction.deleteObject(param);
		
		map.put(RTN_RESULT, "true");
		map.put(MESSAGE_INFO, "操作成功！");
		
		return map;
	}
}

