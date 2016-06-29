package com.taikang.tkcow.moduleImg.controller;

import java.util.Map;
import java.util.List;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;

import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;
import com.taikang.udp.framework.common.datastructre.Dto;

import java.util.HashMap;

import com.taikang.udp.framework.common.datastructre.impl.BaseDto;

import javax.annotation.Resource;

import com.taikang.tkcow.moduleImg.action.IModuleImgAction;
import com.taikang.udp.framework.core.web.BaseController;
import com.taikang.udp.sys.util.CommonUtil;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;


/**
  * ModuleImgController
  */
@Controller("moduleImgController")
@RequestMapping(value="/moduleImg")
public class ModuleImgController  extends BaseController  {
		
	@Resource(name=IModuleImgAction.ACTION_ID)
	private IModuleImgAction moduleImgAction;
		
	/**
	 * 打开主查询页面
	 * @return 页面地址
	 */
	@RequestMapping("")
	public String showModuleImgIndexPage() {
		return "moduleImg/moduleImgIndex"; 
	}
	
	/**
	 * 查询信息列表
	 * @return 分页列表数据
	 */
	@RequestMapping("/list")
	@ResponseBody
	public Map<String,Object> getModuleImgList(HttpServletRequest request,CurrentPage page){
		Map<String, Object> map = new HashMap<String, Object>();
		
		page.setParamObject(CommonUtil.getParamAsDto(request));
		CurrentPage currentPage = moduleImgAction.queryForPage(page);
		
		map.put("rows", currentPage.getPageItems());
		map.put("total", currentPage.getTotalRows());
		
		return map;
	}

	/**
	 * 打开新增或修改页面
	 * @return
	 */
	@RequestMapping("edit")
	public String showModuleImgEditPage(String rowId,Model model) {
		
		if(rowId!=null && !rowId.equals(""))
		{
			model.addAttribute("rowId",rowId );
		}
		
		return "moduleImg/moduleImgEdit"; 
	}
	
	/**
	 * 获取一条记录详细信息，用来填充修改界面
	 * @return
	 */
	@RequestMapping("/getOne")
	@ResponseBody
	public Dto getModuleImgById(@RequestParam("rowId")String rowId)
	{
		Dto param = new BaseDto();
		param.put("rowId", rowId);
		return moduleImgAction.findOne(param);
	}
	
	/**
	 * 保存新增或修改的记录，将其持久化到数据库中
	 * @return
	 */
	@RequestMapping("/save")
	@ResponseBody
	private Map<String,String> saveModuleImgInfo(HttpServletRequest request)
	{
		Map<String,String> map=new HashMap<String,String>();
		
		Dto param = CommonUtil.getParamAsDto(request);
		if(param.get("rowId") ==null ||"".equals(param.get("rowId")))
		{
			moduleImgAction.insertObject(param);
			map.put(MESSAGE_INFO, "新增成功！");
		}
		else
		{
			moduleImgAction.updateObject(param);
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
	public Map<String, String> deleteModuleImg(@RequestParam("rowId") String rowId) {
		Map<String, String> map = new HashMap<String, String>();
		Dto param = new BaseDto();
		param.put("rowId", rowId);
		moduleImgAction.deleteObject(param);
		
		map.put(RTN_RESULT, "true");
		map.put(MESSAGE_INFO, "操作成功！");
		
		return map;
	}
	
	/**
	 * 查询带图列表模板
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/contentfindOnelists")
	public String getZjowModuleContentfindOnes(String belongid,String modType,Model model){
		Dto map = new BaseDto();
		Dto map1 = new BaseDto();
		map.put("belong_id", belongid); //模块id
		map.put("mod_type", modType); // 模块类型
		List<Dto> list = moduleImgAction.findzjowModuleimg(map);
		System.out.println(list);
		//JSONObject jsonObject = new JSONObject();
		model.addAttribute("listimg",list.toString());
		return "tkcontent/xmly";
	}
}

