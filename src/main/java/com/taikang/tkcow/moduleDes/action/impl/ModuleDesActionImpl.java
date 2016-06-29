package com.taikang.tkcow.moduleDes.action.impl;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.baitanw.maomao.utils.PageBean;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.taikang.tkcow.action.IleftMenuAction;
import com.taikang.tkcow.banner.action.IBannerAction;
import com.taikang.tkcow.cooperlogo.action.IZjowCooperLogoAction;
import com.taikang.tkcow.homePage.action.IhomepageAction;
import com.taikang.tkcow.moduleContent.action.IModuleContentAction;
import com.taikang.tkcow.moduleDes.action.IModuleDesAction;
import com.taikang.tkcow.moduleDes.model.ModuleDesBO;
import com.taikang.tkcow.moduleDes.service.IModuleDesService;
import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.udp.framework.common.datastructre.impl.BaseDto;
import com.taikang.udp.framework.core.action.impl.BaseActionImpl;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;

/**
  * ModuleDesAction
  */
  @Service(IModuleDesAction.ACTION_ID)
public class ModuleDesActionImpl extends BaseActionImpl 
  implements IModuleDesAction {
	  @Resource(name=IleftMenuAction.ACTION_ID)
		private IleftMenuAction leftMenuAction;
		@Resource(name=IModuleContentAction.ACTION_ID)
		private IModuleContentAction moduleContentAction;
		@Resource(name=IZjowCooperLogoAction.ACTION_ID)
		private IZjowCooperLogoAction zjowCooperLogoAction;
		@Resource(name=IhomepageAction.ACTION_ID)
		private IhomepageAction homepageAction;
		@Resource(name=IBannerAction.ACTION_ID)
		private IBannerAction bannerAction;
    /**
      * 注入service
      */
    @Resource(name=IModuleDesService.SERVICE_ID)
	private IModuleDesService<ModuleDesBO> moduleDesService;	
	
	/**
	  * 增加数据
	  */
	public void insertObject(Dto param) {
		logger.debug("<======ModuleDesAction--addModuleDes======>");
		
		ModuleDesBO moduleDesBO = BaseDto.toModel(ModuleDesBO.class , param);
		moduleDesService.insertObject(moduleDesBO);
	}
	
	/**
      * 修改数据
      */
	public void updateObject(Dto param){
		logger.debug("<======ModuleDesAction--updateModuleDes======>");
		
		ModuleDesBO moduleDesBO = BaseDto.toModel(ModuleDesBO.class , param);
		moduleDesService.updateObject(moduleDesBO);
	}

	 /**
      * 删除数据
      */
	public void deleteObject(Dto param) {
		logger.debug("<======ModuleDesAction--deleteModuleDes======>");
		
		ModuleDesBO moduleDesBO = BaseDto.toModel(ModuleDesBO.class , param);
		moduleDesService.deleteObject(moduleDesBO);
	}
	
	/**
      * 查询单条数据
      */
	public Dto findOne(Dto param) {
		logger.debug("<======ModuleDesAction--findOneModuleDes======>");
		
		ModuleDesBO moduleDesBO = BaseDto.toModel(ModuleDesBO.class , param);
		return moduleDesService.findOne(moduleDesBO).toDto();//返回的BO对象自动转换成Dto返回
	}  
	
	/**
	 * 查询带图列表模板页面
	 */
	public List<Dto> findAll(Dto param) {
		logger.debug("<======ModuleDesAction--findAllModuleDes======>");
		Dto list = new BaseDto();
		List<Dto> dt =moduleDesService.findAllMap(param);
		byte[] byte1=null;
		String str=null;
		Dto dto = new BaseDto();
		for (int i = 0; i < dt.size(); i++) {
			dto.put("modname", dt.get(i).get("modpas_name"));
			System.out.println(dto);
		}
			dto.put("url", "tkcontent/xmly");
			dto.put("imglist", dt);
			dto.put("size", dt.size());

		List<Dto> list1 = new ArrayList<Dto>();
		list1.add(dto);
		return list1;
	}
	/**
	 * 查询带图列表模板页面
	 */
//	public List<Dto> findAll(Dto param) {
//		logger.debug("<======ModuleDesAction--findAllModuleDes======>");
//		Dto list = new BaseDto();
//		List<Dto> dt =moduleDesService.findAllMap(param);
//		
//		JSONArray jsonObject = JSONArray.fromObject(dt);
//		JSONObject  object = new JSONObject();
//		for (int i = 0; i < jsonObject.size(); i++) {
//			object= (JSONObject) jsonObject.get(i);
//			System.out.println(object);
//		}
//		String modname = object.getString("modpas_name");
//		if(modname!=null || modname!=""){
//			list.put("url", "tkcontent/xmly");
//			list.put("modname", modname);
//			list.put("imglist", dt);
//		}else{
//			list.put("url", "tkcontent/xmly");
//			list.put("modname", "");
//			list.put("imglist", dt);
//		}
//
//		List<Dto> list1 = new ArrayList<Dto>();
//		list1.add(list);
//		JSONArray jsonArray = JSONArray.fromObject(list1);
//		System.out.println(jsonArray.toString());
//		return jsonArray;
//	} 
	
		
	 /**
      * 分页查询数据
      */
	public CurrentPage queryForPage(CurrentPage currentPage){
		logger.debug("<======ModuleDesAction--queryModuleDesForPage======>");
		
		return moduleDesService.queryForPage(currentPage);
	}	
	
	/**
	 * 查询内容模板有banner图或者没有banner图
	 */
	public Dto findzjowModuleOne(Dto param){
		logger.debug("<======ModuleDesAction--findzjowModuleOne======>");
		Dto d = moduleDesService.findzjowModuleOne(param);
		Dto map = new BaseDto();
		String str = (String) d.get("hasbanner");
		byte[] by = (byte[])d.get("hascontent");
		String belong_id = (String) d.get("bannerId");
		String str1 = null;
		if(str==null||str==""){
			d.put("url","tkcontent/flshm"); //放页面路径
			d.put("hascontent", str1);
			return d;
		}else{
//			String str2;
			try {
//				BASE64Decoder decoder = new BASE64Decoder();
				str1 = new String(by);
//				try {
//					str2 = new String(decoder.decodeBuffer(str1),"utf-8");
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(str.equals("1")){ //1没有banner图表
				d.put("url","tkcontent/flshm"); //放页面路径
				d.put("hascontent", str1);
				d.put("strtype", str);
				return d;
			}else{ //0 有banner图表			
				Dto map1 = new BaseDto();
				map1.put("belong_id", belong_id); //模块id
				List<Dto> dt =moduleDesService.findzjowModulebanner(map1);	
				d.put("url","tkcontent/contetnh"); //放页面路径
				d.put("hascontent", str1);
				map.put("bannerlist", dt);
				map.put("contentdt", d);
				map.put("strtype", str);
				return map;//返回的BO对象自动转换成Dto返回
			}
		}
		
	}

	/**
	 * 查询所有banner图表
	 */
	public List<Dto> findzjowModulebanner(Dto param) {
		logger.debug("<======ModuleDesAction--findzjowModulebanner======>");
		return moduleDesService.findzjowModulebanner(param);
	}

	/**
	 * 栏目介绍
	 */
	public Dto findzjowlmjs(Dto param) {
		logger.debug("<======ModuleDesAction--findzjowModuleOne======>");
		Dto dt1 = moduleDesService.findzjowlmjs(param);
		if (dt1 == null || dt1.isAllEmpty()) {
			Dto ret = new BaseDto();
			ret.put("url","tkcow/index"); //放页面路径
			return ret;
		}
		String modid = (String) dt1.get("modId");
		String modType  = (String)dt1.get("modType");
		Dto param1 = new BaseDto();
		
		param1.put("modId", modid);
		param1.put("modType", modType);
		Dto d = moduleDesService.findzjowModuleOne(param1);
		Dto map = new BaseDto();
		String str = (String) d.get("hasbanner");
		byte[] by = (byte[])d.get("hascontent");
		String belong_id = (String) d.get("bannerId");
		String str1 = null;
		if(str==null||str==""){
			d.put("url","tkcontent/flshm"); //放页面路径
			d.put("hascontent", str1);
			return d;
		}else{
			try {
				str1 = new String(by);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(str.equals("1")){ //1没有banner图表
				d.put("url","tkcontent/flshm"); //放页面路径
				d.put("hascontent", str1);
				d.put("strtype", str);
				return d;
			}else{ //0 有banner图表			
				Dto map1 = new BaseDto();
				map1.put("belong_id", belong_id); //模块id
				List<Dto> dt =moduleDesService.findzjowModulebanner(map1);	
				d.put("url","tkcontent/contetnh"); //放页面路径
				d.put("hascontent", str1);
				map.put("bannerlist", dt);
				map.put("contentdt", d);
				map.put("strtype", str);
				return map;//返回的BO对象自动转换成Dto返回
				}
		}
	}
	/**
	 * 取得头部banner.
	 */
	private String getHeadBanner (String modId) {
		if (modId == null || "".equals(modId)) {
			return "";
		}
		Dto param = new BaseDto();
		param.put("modId", modId);
		Dto param2 = new BaseDto();
		param2.put("belongId", modId);
		Dto ban = bannerAction.findOne(param2);
		if (ban.isAllEmpty() || ban.getAsString("banImgUrl") == null || "".equals(ban.getAsString("banImgUrl"))) {
			Dto mod = homepageAction.findOne(param);
			int lvl = mod.getAsInteger("modLevel");
			String pId = mod.getAsString("modParentId");
			while (lvl > 1) {
				Dto param3 = new BaseDto();
				param3.put("belongId", pId);
				Dto param4 = new BaseDto();
				param4.put("modId", pId);
				Dto ban2 = bannerAction.findOne(param3);
				if (ban2.isAllEmpty() || ban2.getAsString("banImgUrl") == null || "".equals(ban2.getAsString("banImgUrl"))) {
					Dto mod2 = homepageAction.findOne(param4);
					pId = mod2.getAsString("modParentId");
					lvl = mod2.getAsInteger("modLevel");
				} else {
					return ban2.getAsString("banImgUrl");
				}
			}
		} else {
			return ban.getAsString("banImgUrl");
		}
		return "";
	}
	
	public String showModuleDesPage(String modUrl,Model model,PageBean pageBean) {
		
		//查询 id ，类别
		
		Dto dto = new BaseDto();
		dto.put("modUrl", modUrl);
		ModuleDesBO moduleDesBO = BaseDto.toModel(ModuleDesBO.class , dto);

		Dto oneDto = moduleDesService.findOne(moduleDesBO).toDto();
		
		String  modType = oneDto.get("modType").toString();
		String modId = oneDto.get("modId").toString();
		Dto param = new BaseDto();
		param.put("modId", modId);
		param.put("modType", modType);
		String url  ="";
		model.addAttribute("id", modId);
		
		
		String banUrl = getHeadBanner(modId);
		if (banUrl != null && !"".equals(banUrl)) {
			model.addAttribute("banUrl", banUrl);
		}
		
		Dto oneChild = leftMenuAction.findOne(param);
		if(oneChild !=null && !"".equals(oneChild)){
			String modName = oneChild.getAsString("modName");
			model.addAttribute("modName",modName);
		}
		//下级栏目，
		if(modType.equals("01")){//栏目类别,01下级栏目，02栏目介绍，03叶子内容模板，04叶子带图列表模板，05叶子Logo列表模板，06叶子不带图列表模板
			
			Dto map = new BaseDto();
			Dto map2 = new BaseDto();
			map.put("modId", modId); //模块id
			map.put("modType", modType); // 模块类型
			map.put("delflag", "0");// 模块类型
			Dto d = moduleContentAction.findzjowModuleconOne(map);
			Dto map1 = new BaseDto();
			map1.put("mod_id", modId); //模块id
			//map1.put("mod_type", modType); // 模块类型
			List<Dto> list = moduleContentAction.findzjowModulecont(map1);
			System.out.println(list);
			List<Dto> dtoList = new ArrayList<Dto>();
			for (int i = 0; i < list.size(); i++) {
				Dto menuParam = new BaseDto();
				menuParam.put("url", list.get(i).get("url"));
				menuParam.put("contlist", list.get(i).get("contlist"));
				dtoList.add(menuParam);
				url = menuParam.get("url").toString();
			}
			//dtoList.add(d);
			map2.put("contlist", dtoList);
			map2.put("contents", d);
			model.addAttribute("contlist",map2.toJson());
			System.out.println(map2.toJson());
			
			
			
		}else if(modType.equals("02")){//栏目介绍
			/*Dto desDto = findzjowlmjs(param);
			 JSONObject json = JSONObject.fromObject(desDto);
				JSONObject jsono = (JSONObject) json.get("contentdt");
				if(jsono == null){
					url = json.getString("url");
				}else{
					url = jsono.getString("url");
				}
				model.addAttribute("content",desDto.toJson());*/
			if (param.isAllEmpty()) {
				return "tkcow/index";
			}
			ModuleDesBO myBo = BaseDto.toModel(ModuleDesBO.class , param);
			ModuleDesBO child = moduleDesService.findFirstChild(myBo);
			if (child == null || child.getModUrl() == null || "".equals(child.getModUrl())) {
				return "tkcow/index";
			}
			return showModuleDesPage(child.getModUrl(), model, pageBean);
		}else if(modType.equals("03")){//03叶子内容模板
				Dto map = new BaseDto();
				map.put("modId", modId); //模块id
				map.put("modType", modType); // 模块类型
				Dto d = findzjowModuleOne(map);
				System.out.println(d.toJson());
				JSONObject json = JSONObject.fromObject(d);
				JSONObject jsono = (JSONObject) json.get("contentdt");
				if(jsono == null){
					url = json.getString("url");
				}else{
					url = jsono.getString("url");
				}
				model.addAttribute("content",d.toJson());
		}else if(modType.equals("04")){//04叶子带图列表模板
			
			Dto map = new BaseDto();
			Dto map1 = new BaseDto();
			map.put("belong_id", modId); //模块id
			map.put("mod_type", modType); 
			map.put("delflag", "0");
			//ModuleDesBO moduleDesBOT = BaseDto.toModel(ModuleDesBO.class , map);

			List<Dto>  list = findAll(map);
			
			List<Dto> dtoList = new ArrayList<Dto>();
			for (int i = 0; i < list.size(); i++) {
				Dto menuParam = new BaseDto();
				menuParam.put("url", list.get(i).get("url"));
				menuParam.put("modName", list.get(i).get("modname"));
				menuParam.put("imglists", list.get(i).get("imglist"));
				int sizes = (Integer) list.get(i).get("size");
				pageBean.setTotalCount(sizes);
				dtoList.add(menuParam);
				url = menuParam.get("url").toString();

			}
			int pageNo = pageBean.getPageNo();
			int pageSize=8; //显示多少条
			pageBean.setPageCount(pageSize); //设置显示多少条
			int start = (pageNo - 1)* pageSize;
			map.put("pageNo", start);
			map.put("pageSize", pageSize);
			List<Dto> listpa = moduleDesService.findAllMapic(map); //分页查询数据
			
			byte[] byte1=null;
			String str=null;
			Dto dto1 = new BaseDto();
			for (int i = 0; i < listpa.size(); i++) {
				dto1.put("modname", listpa.get(i).get("modpas_name")); //获取标题
				System.out.println(dto1);
			}
				dto1.put("imglist", listpa);

			List<Dto> list1 = new ArrayList<Dto>();
			list1.add(dto1);
			
			List<Dto> dtoList1 = new ArrayList<Dto>();
			for (int i = 0; i < list1.size(); i++) {
				Dto menuParam = new BaseDto();
				menuParam.put("modName", list1.get(i).get("modname"));
				menuParam.put("imglists", list1.get(i).get("imglist"));
				dtoList1.add(menuParam);
			}
			
			map1.put("menuList", dtoList1);
			System.out.println(map1.toJson());
			model.addAttribute("listimg",map1.toJson());
			model.addAttribute("pageBean", pageBean);
			
		}else if(modType.equals("05")){//05叶子Logo列表模板
			Dto map = new BaseDto();
			Dto returnDto=new BaseDto();
			map.put("mod_id", modId); //模块id
			map.put("mod_type", modType); // 模块类型
			map.put("delflag", "0");// 模块类型
			List<Dto> list = zjowCooperLogoAction.findAll(map);
			System.out.println(list);
			
			for (int i = 0; i < list.size(); i++) {
				int sizes = (Integer) list.get(i).get("size");
				pageBean.setTotalCount(sizes);
			}
			int pageNo = pageBean.getPageNo();
			int pageSize=12; //显示多少条
			pageBean.setPageCount(pageSize); //设置显示多少条
			int start = (pageNo - 1)* pageSize;
			map.put("pageNo", start);
			map.put("pageSize", pageSize);
			List<Dto> listpa =zjowCooperLogoAction.findzjowModulogopage(map);
			List<Dto> dtoList = new ArrayList<Dto>();
			for (int i = 0; i < listpa.size(); i++) {
				Dto menuParam = new BaseDto();
				menuParam.put("url", listpa.get(i).get("url"));
				url = (String) listpa.get(i).get("url");
				//int sizes = (Integer) listpa.get(i).get("size");
				//pageBean.setTotalCount(sizes);
				menuParam.put("modName", listpa.get(i).get("modname"));
				menuParam.put("logolist", listpa.get(i).get("logolist"));
				dtoList.add(menuParam);
			}
			
			returnDto.put("menuList", dtoList);
			System.out.println(returnDto.toJson());
			model.addAttribute("menuList", returnDto.toJson());
			model.addAttribute("pageBean", pageBean);
			
		}else if(modType.equals("06")){//06叶子不带图列表模板
			Dto map1 = new BaseDto();
			Dto map = new BaseDto();
			String modname=null;
			map1.put("mod_id", modId); //模块id
			map1.put("mod_type", modType); // 模块类型
			map.put("delflag", "0");// 模块类型
			List<Dto> list = moduleContentAction.findzjowModulexwsj(map1);
			if(list.size()>0){
				if (list != null && list.size() > 0) {
					modname = (String)list.get(0).get("mod_name");
					int sizes = (Integer) list.get(0).get("size");
					pageBean.setTotalCount(sizes);
				}
				int pageNo = pageBean.getPageNo();
				int pageSize=12; //显示多少条
				pageBean.setPageCount(pageSize); //设置显示多少条
				int start = (pageNo - 1)* pageSize;
				map1.put("pageNo", start);
				map1.put("pageSize", pageSize);
				List<Dto> listpa = moduleContentAction.findzjowModulexwsjpage(map1);
				List<Dto> dtoList = new ArrayList<Dto>();
				
				for (int i = 0; i < listpa.size(); i++) {
					url = (String) listpa.get(i).get("url");
					Dto menuParam = new BaseDto();
					menuParam.put("url", listpa.get(i).get("url"));
					menuParam.put("xwslist", listpa.get(i).get("xwlist"));
					dtoList.add(menuParam);
					
					map.put("xwList", dtoList);
					map.put("mod_name", modname);
					System.out.println(map.toJson());
					model.addAttribute("xwlists",map.toJson());
					model.addAttribute("pageBean", pageBean);
				}
			}
		}else if(modType.equals("07")){ //07关于我们根据父ID查询子ID内容
			Dto dt = new BaseDto();
			Dto d = moduleContentAction.findparOne(param);
			url = (String) d.get("url");
			JSONObject json = JSONObject.fromObject(d);
			JSONObject jsono = (JSONObject) json.get("parcont");
			String mod_parent_id = jsono.getString("modId");
			List <Dto> dt1 = new ArrayList<Dto>();
			if(mod_parent_id!=null || !"".equals(mod_parent_id)){
				Dto params  = new BaseDto();
				params.put("modId", mod_parent_id);
				dt1 = moduleContentAction.findchilrOne(params);
			}
			dt.put("chirroco", dt1);
			model.addAttribute("parcont", d.toJson());
			model.addAttribute("chilrcont", dt.toJson());
			
		}else if(modType.equals("08")){ //08查询不带图列表详情内容
			Dto d = moduleContentAction.findxwOne(param);
			param.put("modType", modType);
			//查询新闻内容的上一篇和下一篇
			Dto upd = moduleContentAction.findupxwOne(param);
			url = (String) d.get("url");
			Dto map = new BaseDto();
			map.put("xwcontent", d);
			model.addAttribute("xwcontent", map.toJson());
			model.addAttribute("xwud", upd.toJson());
		}
		
		
		
		return url; 
	}
	
}
