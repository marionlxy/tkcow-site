package com.taikang.tkcow.cooperlogo.controller;

import java.util.ArrayList;
import java.util.Map;

import com.taikang.tkcow.cooperlogo.action.IZjowCooperLogoAction;

import java.util.List;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Controller;

import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;
import com.taikang.udp.framework.common.datastructre.Dto;

import java.util.HashMap;

import com.taikang.udp.framework.common.datastructre.impl.BaseDto;

import javax.annotation.Resource;

import com.taikang.udp.framework.core.web.BaseController;
import com.taikang.udp.sys.util.CommonUtil;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;


/**
  * ZjowCooperLogoController
  */
@Controller("zjowCooperLogoController")
@RequestMapping(value="/zjowCooperLogo")
public class ZjowCooperLogoController  extends BaseController  {
		
	@Resource(name=IZjowCooperLogoAction.ACTION_ID)
	private IZjowCooperLogoAction zjowCooperLogoAction;
		
	/**
	 * 打开主查询页面
	 * @return 页面地址
	 */
	@RequestMapping("")
	public String showZjowCooperLogoIndexPage() {
		return "zjowCooperLogo/zjowCooperLogoIndex"; 
	}
	
	/**
	 * 查询信息列表
	 * @return 分页列表数据
	 */
	@RequestMapping("/list")
	@ResponseBody
	public Map<String,Object> getZjowCooperLogoList(HttpServletRequest request,CurrentPage page){
		Map<String, Object> map = new HashMap<String, Object>();
		
		page.setParamObject(CommonUtil.getParamAsDto(request));
		CurrentPage currentPage = zjowCooperLogoAction.queryForPage(page);
		
		map.put("rows", currentPage.getPageItems());
		map.put("total", currentPage.getTotalRows());
		
		return map;
	}

	/**
	 * 打开新增或修改页面
	 * @return
	 */
	@RequestMapping("edit")
	public String showZjowCooperLogoEditPage(String rowId,Model model) {
		
		if(rowId!=null && !rowId.equals(""))
		{
			model.addAttribute("rowId",rowId );
		}
		
		return "zjowCooperLogo/zjowCooperLogoEdit"; 
	}
	
	/**
	 * 获取一条记录详细信息，用来填充修改界面
	 * @return
	 */
	@RequestMapping("/getOne")
	@ResponseBody
	public Dto getZjowCooperLogoById(@RequestParam("rowId")String rowId)
	{
		Dto param = new BaseDto();
		param.put("rowId", rowId);
		return zjowCooperLogoAction.findOne(param);
	}
	
	/**
	 * 保存新增或修改的记录，将其持久化到数据库中
	 * @return
	 */
	@RequestMapping("/save")
	@ResponseBody
	private Map<String,String> saveZjowCooperLogoInfo(HttpServletRequest request)
	{
		Map<String,String> map=new HashMap<String,String>();
		
		Dto param = CommonUtil.getParamAsDto(request);
		if(param.get("rowId") ==null ||"".equals(param.get("rowId")))
		{
			zjowCooperLogoAction.insertObject(param);
			map.put(MESSAGE_INFO, "新增成功！");
		}
		else
		{
			zjowCooperLogoAction.updateObject(param);
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
	public Map<String, String> deleteZjowCooperLogo(@RequestParam("rowId") String rowId) {
		Map<String, String> map = new HashMap<String, String>();
		Dto param = new BaseDto();
		param.put("rowId", rowId);
		zjowCooperLogoAction.deleteObject(param);
		
		map.put(RTN_RESULT, "true");
		map.put(MESSAGE_INFO, "操作成功！");
		
		return map;
	}
	
	/**
	 * 查询logo列表
	 */
	@RequestMapping("/contentfindOnelists/{modid}/{modType}")
	public String getZjowModuleContentfindOnes(@PathVariable("modid")String modid,@PathVariable("modType")String modType,Model model){
		Dto map = new BaseDto();
		Dto returnDto=new BaseDto();
		map.put("mod_id", modid); //模块id
		map.put("mod_type", modType); // 模块类型
		List<Dto> list = zjowCooperLogoAction.findAll(map);
		System.out.println(list);
		String url = null;
		List<Dto> dtoList = new ArrayList<Dto>();
		for (int i = 0; i < list.size(); i++) {
			Dto menuParam = new BaseDto();
			menuParam.put("url", list.get(i).get("url"));
			url = (String) list.get(i).get("url");
			menuParam.put("modName", list.get(i).get("modname"));
			menuParam.put("logolist", list.get(i).get("logolist"));
			dtoList.add(menuParam);
		}
		returnDto.put("menuList", dtoList);
		System.out.println(returnDto.toJson());
		model.addAttribute("menuList", returnDto.toJson());
		return url;
	}
}

