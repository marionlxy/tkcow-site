package com.taikang.tkcow.moduleDes.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.baitanw.maomao.utils.PageBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taikang.tkcow.action.IleftMenuAction;
import com.taikang.tkcow.cooperlogo.action.IZjowCooperLogoAction;
import com.taikang.tkcow.moduleContent.action.IModuleContentAction;
import com.taikang.tkcow.moduleDes.action.IModuleDesAction;
import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.udp.framework.common.datastructre.impl.BaseDto;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;
import com.taikang.udp.framework.core.web.BaseController;
import com.taikang.udp.sys.util.CommonUtil;


/**
  * ModuleDesController
  */
@Controller("moduleDesController")
@RequestMapping(value="/moduleDes")
public class ModuleDesController  extends BaseController  {
		
	@Resource(name=IModuleDesAction.ACTION_ID)
	private IModuleDesAction moduleDesAction;
	
	@Resource(name=IleftMenuAction.ACTION_ID)
	private IleftMenuAction leftMenuAction;
	
	@Resource(name=IModuleContentAction.ACTION_ID)
	private IModuleContentAction moduleContentAction;
	@Resource(name=IZjowCooperLogoAction.ACTION_ID)
	private IZjowCooperLogoAction zjowCooperLogoAction;
	
	/**
	 * 根据传过来的链接，去查数据，
	 */
	
	
//	@RequestMapping("/toShowPage")
//	public String showModuleDesPage(String modId,Model model,PageBean pageBean) {
//		
//		
//		//查询 id ，类别
//		
//		Dto dto = new BaseDto();
//		dto.put("modId", modId);
//		
//		Dto oneDto = moduleDesAction.findOne(dto);
//		
//		String  modType = oneDto.get("modType").toString();
//		
//		Dto param = new BaseDto();
//		param.put("modId", modId);
//		param.put("modType", modType);
//		String url  ="";
//		model.addAttribute("id", modId);
//		//下级栏目，
//		if(modType.equals("01")){//栏目类别,01下级栏目，02栏目介绍，03叶子内容模板，04叶子带图列表模板，05叶子Logo列表模板，06叶子不带图列表模板
//			
//			Dto map = new BaseDto();
//			Dto map2 = new BaseDto();
//			map.put("modId", modId); //模块id
//			map.put("modType", modType); // 模块类型
//			Dto d = moduleContentAction.findzjowModuleconOne(map);
//			Dto map1 = new BaseDto();
//			map1.put("mod_id", modId); //模块id
//			map1.put("mod_type", modType); // 模块类型
//			List<Dto> list = moduleContentAction.findzjowModulecont(map1);
//			System.out.println(list);
//			List<Dto> dtoList = new ArrayList<Dto>();
//			for (int i = 0; i < list.size(); i++) {
//				Dto menuParam = new BaseDto();
//				menuParam.put("url", list.get(i).get("url"));
//				menuParam.put("contlist", list.get(i).get("contlist"));
//				dtoList.add(menuParam);
//				url = menuParam.get("url").toString();
//			}
//			//dtoList.add(d);
//			map2.put("contlist", dtoList);
//			map2.put("contents", d);
//			model.addAttribute("contlist",map2.toJson());
//			System.out.println(map2.toJson());
//			
//		}else if(modType.equals("02")){//栏目介绍
//			 Dto desDto = moduleDesAction.findzjowlmjs(param);
//			 JSONObject json = JSONObject.fromObject(desDto);
//				JSONObject jsono = (JSONObject) json.get("contentdt");
//				if(jsono == null){
//					url = json.getString("url");
//				}else{
//					url = jsono.getString("url");
//				}
//				model.addAttribute("content",desDto.toJson());
//				
//		}else if(modType.equals("03")){//03叶子内容模板
//				Dto map = new BaseDto();
//				map.put("modId", modId); //模块id
//				map.put("modType", modType); // 模块类型
//				Dto d = moduleDesAction.findzjowModuleOne(map);
//				System.out.println(d.toJson());
//				JSONObject json = JSONObject.fromObject(d);
//				JSONObject jsono = (JSONObject) json.get("contentdt");
//				if(jsono == null){
//					url = json.getString("url");
//				}else{
//					url = jsono.getString("url");
//				}
//				model.addAttribute("content",d.toJson());
//				
//		}else if(modType.equals("04")){//04叶子带图列表模板
//			Dto map = new BaseDto();
//			Dto map1 = new BaseDto();
//			map.put("belong_id", modId); //模块id
//			map.put("mod_type", modType); // 模块类型
//			List<Dto> list = moduleDesAction.findAll(map);
//			List<Dto> dtoList = new ArrayList<Dto>();
//			for (int i = 0; i < list.size(); i++) {
//				Dto menuParam = new BaseDto();
//				menuParam.put("url", list.get(i).get("url"));
//				menuParam.put("modName", list.get(i).get("modname"));
//				menuParam.put("imglists", list.get(i).get("imglist"));
//				dtoList.add(menuParam);
//				url = menuParam.get("url").toString();
//
//			}
//			map1.put("menuList", dtoList);
//			System.out.println(map1.toJson());
//			model.addAttribute("listimg",map1.toJson());
//			
//		}else if(modType.equals("05")){//05叶子Logo列表模板
//			Dto map = new BaseDto();
//			Dto returnDto=new BaseDto();
//			map.put("mod_id", modId); //模块id
//			map.put("mod_type", modType); // 模块类型
//			List<Dto> list = zjowCooperLogoAction.findAll(map);
//			System.out.println(list);
//			List<Dto> dtoList = new ArrayList<Dto>();
//			for (int i = 0; i < list.size(); i++) {
//				Dto menuParam = new BaseDto();
//				menuParam.put("url", list.get(i).get("url"));
//				url = (String) list.get(i).get("url");
//				menuParam.put("modName", list.get(i).get("modname"));
//				menuParam.put("logolist", list.get(i).get("logolist"));
//				dtoList.add(menuParam);
//			}
//			returnDto.put("menuList", dtoList);
//			System.out.println(returnDto.toJson());
//			model.addAttribute("menuList", returnDto.toJson());
//			
//		}else if(modType.equals("06")){//06叶子不带图列表模板
//			Dto map1 = new BaseDto();
//			Dto map = new BaseDto();
//			String modname=null;
//			map1.put("mod_id", modId); //模块id
//			map1.put("mod_type", modType); // 模块类型
//			List<Dto> list = moduleContentAction.findzjowModulexwsj(map1);
//			if(list.size()>0){
//				for (int j = 0; j < list.size(); j++) {
//					pageBean.setTotalCount((Integer) list.get(j).get("size"));
//					modname = (String)list.get(j).get("mod_name");
//				}
//				int pageNo = pageBean.getPageNo();
//				int pageSize=2; //显示多少条
//				pageBean.setPageCount(pageSize); //设置显示多少条
//				int start = (pageNo - 1)* pageSize;
//				map1.put("pageNo", start);
//				map1.put("pageSize", pageSize);
//				List<Dto> listpa = moduleContentAction.findzjowModulexwsjpage(map1);
//				List<Dto> dtoList = new ArrayList<Dto>();
//				
//				for (int i = 0; i < listpa.size(); i++) {
//					url = (String) listpa.get(i).get("url");
//					Dto menuParam = new BaseDto();
//					menuParam.put("url", listpa.get(i).get("url"));
//					menuParam.put("xwslist", listpa.get(i).get("xwlist"));
//					dtoList.add(menuParam);
//					
//					map.put("xwList", dtoList);
//					map.put("mod_name", modname);
//					System.out.println(map.toJson());
//					model.addAttribute("xwlists",map.toJson());
//					model.addAttribute("pageBean", pageBean);
//				}
//			}
//			
//		}else if(modType.equals("07")){ //07关于我们根据父ID查询子ID内容
//			Dto dt = new BaseDto();
//			Dto d = moduleContentAction.findparOne(param);
//			url = (String) d.get("url");
//			JSONObject json = JSONObject.fromObject(d);
//			JSONObject jsono = (JSONObject) json.get("parcont");
//			String mod_parent_id = jsono.getString("modParentId");
//			if(mod_parent_id!=null || !"".equals(mod_parent_id)){
//				Dto params  = new BaseDto();
//				params.put("modId", mod_parent_id);
//				dt = moduleContentAction.findchilrOne(params);
//			}
//			model.addAttribute("parcont", d.toJson());
//			model.addAttribute("chilrcont", dt.toJson());
//		}
//
//		return url; 
//	}
	
	/**
	 * 查询新闻事件单个详细内容和查询上一篇和下一篇
	 * @return
	 */
	@RequestMapping("/getxwOne")
	public String getModuleon(String modid,String modType,Model model){
		Dto param = new BaseDto();
		param.put("modId", modid);
		Dto d = moduleContentAction.findxwOne(param);
		param.put("modType", modType);
		//查询新闻内容的上一篇和下一篇
		Dto upd = moduleContentAction.findupxwOne(param);
		String url = (String) d.get("url");
		Dto map = new BaseDto();
		map.put("xwcontent", d);
		model.addAttribute("xwcontent", map.toJson());
		model.addAttribute("xwud", upd.toJson());
		return url;
	}
	/**
	 * 注册页面
	 */
	@RequestMapping("/loginInfo")
	public String showIndexPage() {
		return "moduledes/moduledesLogin"; 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * 打开主查询页面
	 * @return 页面地址
	 */
	@RequestMapping("")
	public String showModuleDesIndexPage() {
		return "moduleDes/moduleDesIndex"; 
	}
	
	/**
	 * 查询信息列表
	 * @return 分页列表数据
	 */
	@RequestMapping("/list")
	@ResponseBody
	public Map<String,Object> getModuleDesList(HttpServletRequest request,CurrentPage page){
		Map<String, Object> map = new HashMap<String, Object>();
		
		page.setParamObject(CommonUtil.getParamAsDto(request));
		CurrentPage currentPage = moduleDesAction.queryForPage(page);
		
		map.put("rows", currentPage.getPageItems());
		map.put("total", currentPage.getTotalRows());
		
		return map;
	}

	/**
	 * 打开新增或修改页面
	 * @return
	 */
	@RequestMapping("edit")
	public String showModuleDesEditPage(String rowId,Model model) {
		
		if(rowId!=null && !rowId.equals(""))
		{
			model.addAttribute("rowId",rowId );
		}
		
		return "moduleDes/moduleDesEdit"; 
	}
	
	/**
	 * 获取一条记录详细信息，用来填充修改界面
	 * @return
	 */
	@RequestMapping("/getOne")
	@ResponseBody
	public Dto getModuleDesById(@RequestParam("rowId")String rowId)
	{
		Dto param = new BaseDto();
		param.put("rowId", rowId);
		return moduleDesAction.findOne(param);
	}
	
	/**
	 * 保存新增或修改的记录，将其持久化到数据库中
	 * @return
	 */
	@RequestMapping("/save")
	@ResponseBody
	private Map<String,String> saveModuleDesInfo(HttpServletRequest request)
	{
		Map<String,String> map=new HashMap<String,String>();
		
		Dto param = CommonUtil.getParamAsDto(request);
		if(param.get("rowId") ==null ||"".equals(param.get("rowId")))
		{
			moduleDesAction.insertObject(param);
			map.put(MESSAGE_INFO, "新增成功！");
		}
		else
		{
			moduleDesAction.updateObject(param);
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
	public Map<String, String> deleteModuleDes(@RequestParam("rowId") String rowId) {
		Map<String, String> map = new HashMap<String, String>();
		Dto param = new BaseDto();
		param.put("rowId", rowId);
		moduleDesAction.deleteObject(param);
		
		map.put(RTN_RESULT, "true");
		map.put(MESSAGE_INFO, "操作成功！");
		
		return map;
	}
	
	/**
	 * 查询叶子内容模板
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/contentfindOnelist")
	public String getZjowModuleContentfindOne(String modid,String modType,Model model){
		Dto map = new BaseDto();
		String url=null;
		map.put("modId", modid); //模块id
		//map.put("modType", modType); // 模块类型
		Dto d = moduleDesAction.findzjowModuleOne(map);
		System.out.println(d.toJson());
		JSONObject json = JSONObject.fromObject(d);
		JSONObject jsono = (JSONObject) json.get("contentdt");
		if(jsono == null){
			url = json.getString("url");
		}else{
			url = jsono.getString("url");
		}
		model.addAttribute("content",d.toJson());
		//String modname=(String) d.get("modName");
		//ModelAndView modelAndView = new ModelAndView();
		//modelAndView.addObject("content", d.toJson());
		//modelAndView.addObject("modname",modname);
		//modelAndView.setViewName(url);
		return url;
	}
	
	/**
	 * 查询带图列表模板
	 * 
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/contentfindOnelists")
	public String getZjowModuleContentfindOnes(String modid,String modType,Model model){
		Dto map = new BaseDto();
		Dto map1 = new BaseDto();
		map.put("belong_id", modid); //模块id
		map.put("mod_type", modType); // 模块类型
		List<Dto> list = moduleDesAction.findAll(map);
		List<Dto> dtoList = new ArrayList<Dto>();
		for (int i = 0; i < list.size(); i++) {
			Dto menuParam = new BaseDto();
			menuParam.put("url", list.get(i).get("url"));
			menuParam.put("modName", list.get(i).get("modname"));
			menuParam.put("imglists", list.get(i).get("imglist"));
			dtoList.add(menuParam);
		}
		map1.put("menuList", dtoList);
		System.out.println(map1.toJson());
		model.addAttribute("listimg",map1.toJson());
		return "tkcontent/xmly";
	}
	
	/**
	 * 查询栏目介绍
	 * 
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/contentfindOne")
	public String getZjowModuleContentfind(String modid,String modType,Model model){
		Dto map = new BaseDto();
		Dto map1 = new BaseDto();
		String url = null;
		map.put("modParentId", modid); //模块id
		Dto d = moduleDesAction.findzjowlmjs(map);
		JSONObject json = JSONObject.fromObject(d);
		JSONObject jsono = (JSONObject) json.get("contentdt");
		if(jsono == null){
			url = json.getString("url");
		}else{
			url = jsono.getString("url");
		}
		model.addAttribute("content",d.toJson());
		model.addAttribute("id", modid);
		return url;
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
		StringBuilder sb = new StringBuilder();
		id = id.substring(id.indexOf(":")+1);
		param.put("mod_parent_id", id);
		List<Dto> list = leftMenuAction.findAll(param);

		List resultList = new ArrayList();
		List OneChildList = new ArrayList();
		List tChildList = new ArrayList();
//		sb.append("")
//		for (int i = 0; i < list.size(); i++) {
//			
//		}
		for (Dto bo : list) {
			Dto mDto = new BaseDto();
			mDto.put("modId", bo.get("MOD_ID"));
			mDto.put("modName", bo.get("MOD_NAME"));
			mDto.put("modParentId", bo.get("MOD_PARENT_ID"));
			mDto.put("modLevel", bo.get("MOD_LEVEL"));
			mDto.put("modUrl", bo.get("MOD_URL"));
			mDto.put("modSquence", bo.get("MOD_SQUENCE"));
			Dto para = new BaseDto();
			para.put("mod_parent_id", bo.get("MOD_ID"));
			List<Dto> childList = leftMenuAction.findAll(para);
			if(childList.size()!=0){
				for (int i = 0; i < childList.size(); i++) {
					Dto cDto = new BaseDto();
					cDto.put("modId", childList.get(i).get("MOD_ID"));
					cDto.put("modName", childList.get(i).get("MOD_NAME"));
					cDto.put("modParentId", childList.get(i).get("MOD_PARENT_ID"));
					cDto.put("modLevel", childList.get(i).get("MOD_LEVEL"));
					cDto.put("modUrl", childList.get(i).get("MOD_URL"));
					cDto.put("modSquence", childList.get(i).get("MOD_SQUENCE"));
					Dto childpara = new BaseDto();
					childpara.put("mod_parent_id", childList.get(i).get("MOD_ID"));
					List<Dto> twoChildList = leftMenuAction.findAll(childpara);
					if(twoChildList.size()!=0){
						for (int j = 0; j < twoChildList.size(); j++) {
							Dto twcDto = new BaseDto();
							twcDto.put("modId", twoChildList.get(j).get("MOD_ID"));
							twcDto.put("modName", twoChildList.get(j).get("MOD_NAME"));
							twcDto.put("modParentId", twoChildList.get(j).get("MOD_PARENT_ID"));
							twcDto.put("modLevel", twoChildList.get(j).get("MOD_LEVEL"));
							twcDto.put("modUrl", twoChildList.get(j).get("MOD_URL"));
							twcDto.put("modSquence", twoChildList.get(j).get("MOD_SQUENCE"));
							tChildList.add(twcDto);
						}
						resultDto.put("twoChildList", tChildList);
					}
					OneChildList.add(cDto);
				}
				resultDto.put("OneChildList", OneChildList);
			}
			resultList.add(mDto);
		}
		if("1".equals(id)){
			resultDto.put("menuName", "活力养老");
		}else if ("1002".equals(id)){
			resultDto.put("menuName", "高端医疗");
		}else if("10100201a1".equals(id)){
			resultDto.put("menuName", "企业社区");
		}else if("A123".equals(id)){
			resultDto.put("menuName", "关于我们");
		}
		resultDto.put("resultList", resultList);
		return resultDto.toJson(); 
	}
	
	
	/**
	 * 查询类型为07的内容
	 * 
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/getgywm")
	public String getgywm(String modid,String modType,Model model){
		String url="";
		Dto param = new BaseDto();
		Dto dt = new BaseDto();
		param.put("modId", modid); //模块id
		param.put("mod_type", modType); // 模块类型
		Dto d = moduleContentAction.findparOne(param);
		url = (String) d.get("url");
		JSONObject json = JSONObject.fromObject(d);
		JSONObject jsono = (JSONObject) json.get("parcont");
		System.out.println(jsono);
		String mod_parent_id = jsono.getString("modParentId");
		List <Dto> dt1 = new ArrayList<Dto>();
		if(mod_parent_id!=null || !"".equals(mod_parent_id)){
			Dto params  = new BaseDto();
			params.put("modId", mod_parent_id);
			dt1 = moduleContentAction.findchilrOne(params);
		}
		dt.put("chirroco", dt1);
		model.addAttribute("parcont", d.toJson());
		model.addAttribute("chilrcont", dt.toJson());
		model.addAttribute("id", modid);
		return url;
	}
}

