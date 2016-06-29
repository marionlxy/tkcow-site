package com.taikang.tkcow.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.baitanw.maomao.utils.PageBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerMapping;

import com.taikang.tkcow.homePage.action.IhomepageAction;
import com.taikang.tkcow.moduleDes.action.IModuleDesAction;
import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.udp.framework.common.datastructre.impl.BaseDto;
import com.taikang.udp.framework.core.web.BaseController;

@Controller
public class TKCowMainController extends BaseController {
	private String modUrl="";
	String showModel = "";
	Model model;
	@Resource(name=IModuleDesAction.ACTION_ID)
	private IModuleDesAction moduleDesAction;
	@Resource(name=IhomepageAction.ACTION_ID)
	private IhomepageAction moduleAction;
	
	@RequestMapping("/index.htm")
	public String index() {
		return "tkcow/index";
	}

	@RequestMapping("/**")
	public String jump(HttpServletRequest request, Model model,PageBean pageBean) {
		modUrl= extractPathFromPattern(request);
//		String urlK =modUrl.substring(0, 9);
		if(!modUrl.equals("")){
			
			if(modUrl.equals("user/login")){
				//return "moduledes/moduledesLogin"; 
			}
			
			
			if ("sitemap.html".equals(modUrl)) {
				Dto param1 = new BaseDto();
				param1.put("mod_parent_id", "11111111111111111111111111111111");
				param1.put("delflag", "0");
				List<Dto> lis1 = moduleAction.findAllByType(param1);
				Dto param2 = new BaseDto();
				param2.put("mod_parent_id", "22222222222222222222222222222222");
				param2.put("delflag", "0");
				List<Dto> lis2 = moduleAction.findAllByType(param2);
				lis1.addAll(lis2);
				model.addAttribute("rList", lis1);
				List<Dto> dList = new ArrayList<Dto>();
				for (Dto mdto : lis1) {
					Dto result = new BaseDto();
					Dto param3 = new BaseDto();
					param3.put("mod_parent_id", mdto.getAsString("MOD_ID"));
					List<Dto> list = moduleAction.findAllByType(param3);
					result.put("name", mdto.getAsString("MOD_NAME"));
					result.put("url", mdto.getAsString("MOD_URL"));
					result.put("child", list);
					dList.add(result);
				}
				model.addAttribute("cList", dList);
				return "tkcow/sitemap";
			}
			Dto dto = new BaseDto();
			dto.put("modUrl", modUrl);
			
			Dto oneDto = moduleDesAction.findOne(dto);
			if(!oneDto.isAllEmpty()){
				//PageBean pageBean = new PageBean();
				showModel =moduleDesAction.showModuleDesPage(modUrl,model, pageBean);
				if ("tkcow/index".equals(showModel)) {
					return "redirect:/index.htm";
				}
			}else{
				return "redirect:/index.htm";
			}
		}
		return showModel;
	}

	private static String extractPathFromPattern(final HttpServletRequest request) {
		String path = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
		String bestMatchPattern = (String) request.getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE);
		return new AntPathMatcher().extractPathWithinPattern(bestMatchPattern, path);
	}
	
}
