package com.taikang.tkcow.controller;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;

import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;
import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.tkcow.action.IleftMenuAction;

import java.util.HashMap;

import com.taikang.udp.framework.common.datastructre.impl.BaseDto;

import javax.annotation.Resource;

import com.taikang.udp.framework.core.web.BaseController;
import com.taikang.udp.sys.util.CommonUtil;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;


/**
  * leftMenuController
  */
@Controller("leftMenuController")
@RequestMapping(value="/leftMenu")
public class leftMenuController  extends BaseController  {
		
	@Resource(name=IleftMenuAction.ACTION_ID)
	private IleftMenuAction leftMenuAction;
		
	/**
	 * 打开主查询页面
	 * @return 页面地址
	 */
	@RequestMapping("")
	public String showleftMenuIndexPage() {
		return "leftMenu/leftMenuIndex"; 
	}
	
	/**
	 * 查询信息列表
	 * @return 分页列表数据
	 */
	@RequestMapping("/list")
	@ResponseBody
	public Map<String,Object> getleftMenuList(HttpServletRequest request,CurrentPage page){
		Map<String, Object> map = new HashMap<String, Object>();
		
		page.setParamObject(CommonUtil.getParamAsDto(request));
		CurrentPage currentPage = leftMenuAction.queryForPage(page);
		
		map.put("rows", currentPage.getPageItems());
		map.put("total", currentPage.getTotalRows());
		
		return map;
	}

	/**
	 * 打开新增或修改页面
	 * @return
	 */
	@RequestMapping("edit")
	public String showleftMenuEditPage(String rowId,Model model) {
		
		if(rowId!=null && !rowId.equals(""))
		{
			model.addAttribute("rowId",rowId );
		}
		
		return "leftMenu/leftMenuEdit"; 
	}
	
	/**
	 * 获取一条记录详细信息，用来填充修改界面
	 * @return
	 */
	@RequestMapping("/getOne")
	@ResponseBody
	public Dto getleftMenuById(@RequestParam("rowId")String rowId)
	{
		Dto param = new BaseDto();
		param.put("rowId", rowId);
		return leftMenuAction.findOne(param);
	}
	
	/**
	 * 保存新增或修改的记录，将其持久化到数据库中
	 * @return
	 */
	@RequestMapping("/save")
	@ResponseBody
	private Map<String,String> saveleftMenuInfo(HttpServletRequest request)
	{
		Map<String,String> map=new HashMap<String,String>();
		
		Dto param = CommonUtil.getParamAsDto(request);
		if(param.get("rowId") ==null ||"".equals(param.get("rowId")))
		{
			leftMenuAction.insertObject(param);
			map.put(MESSAGE_INFO, "新增成功！");
		}
		else
		{
			leftMenuAction.updateObject(param);
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
	public Map<String, String> deleteleftMenu(@RequestParam("rowId") String rowId) {
		Map<String, String> map = new HashMap<String, String>();
		Dto param = new BaseDto();
		param.put("rowId", rowId);
		leftMenuAction.deleteObject(param);
		
		map.put(RTN_RESULT, "true");
		map.put(MESSAGE_INFO, "操作成功！");
		
		return map;
	}
	
	@RequestMapping(value="/TreeMenu")
	public String TreeMenu( String id,Model model) {
		String menu = "";
		model.addAttribute("id", id);
		
		return "leftmenu/leftmenuIndex";
	}
	
	@RequestMapping(value="/menuList",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String menuList(@RequestBody String id,HttpServletRequest request) {
		Dto resultDto = new BaseDto();

		Dto param = new BaseDto();
		Dto childParam = new BaseDto();
		StringBuilder sb = new StringBuilder();
		id = id.substring(id.indexOf(":")+1);
//		resultDto.put("childId", id);
		childParam.put("modId", id);
		childParam.put("delflag", 0);
		Dto oneChild = leftMenuAction.findOne(childParam);
		if(oneChild !=null && !"".equals(oneChild)){
			String level = oneChild.getAsString("modLevel");
			if("2".equals(level)){
				resultDto.put("twoLevelId", id);
				
				id = oneChild.getAsString("modParentId");
				
				// 点击第一层，但第二层还有值的时候，二层第一个值被选中。
				Dto thirdChild = new BaseDto();
				thirdChild.put("mod_parent_id", oneChild.getAsString("modId"));
				thirdChild.put("delflag", 0);
				List<Dto> thirdChilList = leftMenuAction.findAll(thirdChild);
				if(thirdChilList != null && thirdChilList.size() > 0){
					Dto thirdChil = thirdChilList.get(0);
					resultDto.put("thirdLevelId", thirdChil.getAsString("MOD_ID"));
					
					// 点击第一层，但第三层还有值的时候，三层第一个值被选中。
					Dto child = new BaseDto();
					child.put("mod_parent_id", thirdChil.getAsString("MOD_ID"));
					child.put("delflag", 0);
					List<Dto> chilList = leftMenuAction.findAll(child);
					if(chilList != null && chilList.size() > 0){
						Dto chil = chilList.get(0);
						resultDto.put("childId", chil.getAsString("MOD_ID"));
					}
				}
				
			}if("3".equals(level)){
				resultDto.put("thirdLevelId", id);
				
				Dto twoChild = new BaseDto();
				twoChild.put("modId", oneChild.getAsString("modParentId"));
				twoChild.put("delflag", 0);
				Dto twoChil = leftMenuAction.findOne(twoChild);
				resultDto.put("twoLevelId", twoChil.getAsString("modId"));
				
				// 点击第一层，但第三层还有值的时候，三层第一个值被选中。
				Dto child = new BaseDto();
				child.put("mod_parent_id", id);
				child.put("delflag", 0);
				List<Dto> chilList = leftMenuAction.findAll(child);
				if(chilList != null && chilList.size() > 0){
					Dto chil = chilList.get(0);
					resultDto.put("childId", chil.getAsString("MOD_ID"));
				}
				
				id=twoChil.getAsString("modParentId");
				
			}if("4".equals(level)){
				resultDto.put("childId", id);
				
				Dto twoChild = new BaseDto();
				Dto thirdChild = new BaseDto();
				thirdChild.put("modId", oneChild.getAsString("modParentId"));
				thirdChild.put("delflag", 0);
				Dto thirdChil = leftMenuAction.findOne(thirdChild);
				twoChild.put("modId", thirdChil.getAsString("modParentId"));
				twoChild.put("delflag", 0);
				Dto twoChil = leftMenuAction.findOne(twoChild);
				resultDto.put("thirdLevelId", thirdChil.getAsString("modId"));
				resultDto.put("twoLevelId", twoChil.getAsString("modId"));
				id=twoChil.getAsString("modParentId");
			}
			
//			Dto twoChild = new BaseDto();
//			Dto thirdChild = new BaseDto();
//			thirdChild.put("modId", oneChild.getAsString("modParentId"));
//			thirdChild.put("delflag", 0);
//			Dto thirdChil = leftMenuAction.findOne(thirdChild);
//			twoChild.put("modId", thirdChil == null ? "" : thirdChil.getAsString("modParentId"));
//			twoChild.put("delflag", 0);
//			Dto twoChil = leftMenuAction.findOne(twoChild);
//			resultDto.put("thirdLevelId", thirdChil == null ? "" : thirdChil.getAsString("modId"));
//			resultDto.put("twoLevelId", twoChil == null ? "" : twoChil.getAsString("modId"));
//			id=twoChil.getAsString("modParentId");
			
			resultDto.put("childLevel", level);
		}
		param.put("mod_parent_id", id);
		List<Dto> list = leftMenuAction.findAll(param);
	
		List resultList = new ArrayList();
		List OneChildList = new ArrayList();
		List tChildList = new ArrayList();
		for (Dto bo : list) {
			if (!"08".equals(bo.get("modType"))) {
				Dto mDto = new BaseDto();
				mDto.put("modId", bo.get("MOD_ID"));
				mDto.put("modName", bo.get("MOD_NAME"));
				mDto.put("modParentId", bo.get("MOD_PARENT_ID"));
				mDto.put("modLevel", bo.get("MOD_LEVEL"));
				mDto.put("modUrl", bo.get("MOD_URL"));
				mDto.put("modSquence", bo.get("MOD_SQUENCE"));
				mDto.put("modType", bo.get("modType"));
				resultList.add(mDto);
			}
			Dto para = new BaseDto();
			para.put("mod_parent_id", bo.get("MOD_ID"));
			List<Dto> childList = leftMenuAction.findAll(para);
			if(childList.size()!=0){
				for (int i = 0; i < childList.size(); i++) {
					if (!"08".equals(childList.get(i).get("modType"))) {
						Dto cDto = new BaseDto();
						cDto.put("modId", childList.get(i).get("MOD_ID"));
						cDto.put("modName", childList.get(i).get("MOD_NAME"));
						cDto.put("modParentId", childList.get(i).get("MOD_PARENT_ID"));
						cDto.put("modLevel", childList.get(i).get("MOD_LEVEL"));
						cDto.put("modUrl", childList.get(i).get("MOD_URL"));
						cDto.put("modSquence", childList.get(i).get("MOD_SQUENCE"));
						cDto.put("modType", childList.get(i).get("modType"));
						OneChildList.add(cDto);
					}
					Dto childpara = new BaseDto();
					childpara.put("mod_parent_id", childList.get(i).get("MOD_ID"));
					List<Dto> twoChildList = leftMenuAction.findAll(childpara);
					if(twoChildList.size()!=0){
						for (int j = 0; j < twoChildList.size(); j++) {
							if (!"08".equals(twoChildList.get(j).get("modType"))) {
								Dto twcDto = new BaseDto();
								twcDto.put("modId", twoChildList.get(j).get("MOD_ID"));
								twcDto.put("modName", twoChildList.get(j).get("MOD_NAME"));
								twcDto.put("modParentId", twoChildList.get(j).get("MOD_PARENT_ID"));
								twcDto.put("modLevel", twoChildList.get(j).get("MOD_LEVEL"));
								twcDto.put("modUrl", twoChildList.get(j).get("MOD_URL"));
								twcDto.put("modSquence", twoChildList.get(j).get("MOD_SQUENCE"));
								twcDto.put("modType", twoChildList.get(j).get("modType"));
								tChildList.add(twcDto);
							}
						}
						resultDto.put("twoChildList", tChildList);
					}
				}
				resultDto.put("OneChildList", OneChildList);
			}
		}
		if("10100201".equals(id)){
			resultDto.put("menuName", "活力养老");
		}else if ("10100203".equals(id)){
			resultDto.put("menuName", "高端医疗");
		}else if("10100205".equals(id)){
			resultDto.put("menuName", "企业社区");
		}else if("10100207".equals(id)){
			resultDto.put("menuName", "关于我们");
		}else{
			Dto menuParam = new BaseDto();
			menuParam.put("modId", id);
			Dto menu = leftMenuAction.findOne(menuParam);
			resultDto.put("menuName", menu.get("modName"));
		}
		resultDto.put("resultList", resultList);
		return resultDto.toJson(); 
	}
}

