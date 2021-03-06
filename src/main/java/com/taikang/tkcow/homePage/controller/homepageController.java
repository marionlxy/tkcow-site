package com.taikang.tkcow.homePage.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Map;
import java.util.List;

import org.baitanw.maomao.utils.PageBean;
import org.springframework.stereotype.Controller;

import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;
import com.taikang.udp.framework.common.datastructre.Dto;

import java.util.HashMap;

import com.taikang.udp.framework.common.datastructre.impl.BaseDto;

import javax.annotation.Resource;

import com.taikang.tkcow.banner.action.IBannerAction;
import com.taikang.tkcow.homePage.action.IhomepageAction;
import com.taikang.udp.framework.core.web.BaseController;
import com.taikang.udp.sys.util.CommonUtil;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;


/**
  * homepageController
  */
@Controller("homepageController")
@RequestMapping(value="/homepage")
public class homepageController  extends BaseController  {
		
	@Resource(name=IhomepageAction.ACTION_ID)
	private IhomepageAction homepageAction;
	
	@Resource(name=IBannerAction.ACTION_ID)
	private IBannerAction bannerAction;
		
	/**
	 * 打开主查询页面
	 * @return 页面地址
	 */
	@RequestMapping("")
	public String showhomepageIndexPage() {
		return "homepage/homepageIndex"; 
	}
	
	/**
	 * 查询信息列表
	 * @return 分页列表数据
	 */
	@RequestMapping("/list")
	@ResponseBody
	public Map<String,Object> gethomepageList(HttpServletRequest request,CurrentPage page){
		Map<String, Object> map = new HashMap<String, Object>();
		
		page.setParamObject(CommonUtil.getParamAsDto(request));
		CurrentPage currentPage = homepageAction.queryForPage(page);
		
		map.put("rows", currentPage.getPageItems());
		map.put("total", currentPage.getTotalRows());
		
		return map;
	}

	/**
	 * 打开新增或修改页面
	 * @return
	 */
	@RequestMapping("edit")
	public String showhomepageEditPage(String rowId,Model model) {
		
		if(rowId!=null && !rowId.equals(""))
		{
			model.addAttribute("rowId",rowId );
		}
		
		return "homepage/homepageEdit"; 
	}
	
	/**
	 * 获取一条记录详细信息，用来填充修改界面
	 * @return
	 */
	@RequestMapping("/getOne")
	@ResponseBody
	public Dto gethomepageById(@RequestParam("rowId")String rowId)
	{
		Dto param = new BaseDto();
		param.put("rowId", rowId);
		return homepageAction.findOne(param);
	}
	
	/**
	 * 保存新增或修改的记录，将其持久化到数据库中
	 * @return
	 */
	@RequestMapping("/save")
	@ResponseBody
	private Map<String,String> savehomepageInfo(HttpServletRequest request)
	{
		Map<String,String> map=new HashMap<String,String>();
		
		Dto param = CommonUtil.getParamAsDto(request);
		if(param.get("rowId") ==null ||"".equals(param.get("rowId")))
		{
			homepageAction.insertObject(param);
			map.put(MESSAGE_INFO, "新增成功！");
		}
		else
		{
			homepageAction.updateObject(param);
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
	public Map<String, String> deletehomepage(@RequestParam("rowId") String rowId) {
		Map<String, String> map = new HashMap<String, String>();
		Dto param = new BaseDto();
		param.put("rowId", rowId);
		homepageAction.deleteObject(param);
		
		map.put(RTN_RESULT, "true");
		map.put(MESSAGE_INFO, "操作成功！");
		
		return map;
	}
	
	/**
     * 查询首页二级菜单
     */
	@RequestMapping(value="/queryTwoMenu",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String queryTwoMenu(@RequestBody String json,HttpServletRequest request) {
		Dto param=new BaseDto();
		param.put("delflag", "0");
		param.put("modLevel", "2");
		List<Dto> Params=homepageAction.findAll(param);
		List<Dto> dtoList = new ArrayList<Dto>();
		Dto returnDto=new BaseDto();
		for(int i=0;i<Params.size();i++)
		{
			Dto menuParam = new BaseDto();
			menuParam.put("MOD_ID", Params.get(i).get("MOD_ID"));
			menuParam.put("MOD_NAME", Params.get(i).get("MOD_NAME"));
			menuParam.put("MOD_PARENT_ID", Params.get(i).get("MOD_PARENT_ID"));
			menuParam.put("MOD_ISLEAF", Params.get(i).get("MOD_ISLEAF"));
			menuParam.put("MOD_SQUENCE", Params.get(i).get("MOD_SQUENCE"));
			menuParam.put("MOD_LEVEL", Params.get(i).get("MOD_LEVEL"));
			menuParam.put("MOD_URL", Params.get(i).get("MOD_URL"));
			dtoList.add(menuParam);
		}
		returnDto.put("menuList", dtoList);
		return returnDto.toJson();
	} 
	
	/**
     * 查询首页九宫格模块信息
     */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/queryHomeModel",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String queryHomeModel(@RequestBody String json,HttpServletRequest request) {
		Dto param=new BaseDto();
		param.put("mod_parent_id", "22222222222222222222222222222222");
		param.put("delflag", "0");
		byte[] context = null;
		String str=null;
		List<Dto> Params=homepageAction.findAlLHexinMenu(param);
		List<Dto> dtoList = new ArrayList<Dto>();
		Dto returnDto=new BaseDto();
		for(int i=0;i<Params.size();i++)
		{
			Dto menuParam = new BaseDto();
			menuParam.put("AmodID", Params.get(i).get("AmodID"));
			menuParam.put("AmodUrl", Params.get(i).get("AmodUrl"));
			menuParam.put("AmodName", Params.get(i).get("AmodName"));
			menuParam.put("BmodId", Params.get(i).get("BmodId"));
			menuParam.put("Btitle", Params.get(i).get("Btitle"));
			menuParam.put("BmodUrl", Params.get(i).get("BmodUrl"));
			menuParam.put("Ccontent", Params.get(i).get("Ccontent"));
			menuParam.put("Bimg", Params.get(i).get("Bimg"));
			//static/tkcow/img/pic.png
			menuParam.put("Bico", Params.get(i).get("Bico"));
			dtoList.add(menuParam);
		}
		returnDto.put("jsonParam", dtoList);
		return returnDto.toJson();
	}
	
	/**
     * 查询首页banner列表
     */
	@RequestMapping(value="/queryBanner",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String queryHomeBanner(@RequestBody String json,HttpServletRequest request) {
		Dto param=new BaseDto();
		List<Dto> Params=bannerAction.findAllMapHomeBanner(param);
		List<Dto> dtoList = new ArrayList<Dto>();
		Dto returnDto=new BaseDto();
		for(int i=0;i<Params.size();i++)
		{
			Dto menuParam = new BaseDto();
			menuParam.put("BAN_IMG_ID", Params.get(i).get("BAN_IMG_ID"));
			menuParam.put("BAN_ID", Params.get(i).get("BAN_ID"));
			menuParam.put("BELONG_ID", Params.get(i).get("BELONG_ID"));
			menuParam.put("BAN_TYPE", Params.get(i).get("BAN_TYPE"));
			menuParam.put("BAN_IMG_URL", Params.get(i).get("BAN_IMG_URL"));
			menuParam.put("BAN_IMG_NAME", Params.get(i).get("BAN_IMG_NAME"));
			menuParam.put("BAN_IMG_DES", Params.get(i).get("BAN_IMG_DES"));
			menuParam.put("BAN_IMG_OUTSIDE", Params.get(i).get("BAN_IMG_OUTSIDE"));
			menuParam.put("BAN_IMG_NUM", Params.get(i).get("BAN_IMG_NUM"));
			dtoList.add(menuParam);
		}
		returnDto.put("bannerData", dtoList);
		return returnDto.toJson();
	}
	
	/**
     * 查询首页底部菜单
     */
	@RequestMapping(value="/BottomMenu",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String queryBottomMenu(@RequestBody String json,HttpServletRequest request) {
		Dto param=new BaseDto();
		List<Dto> Params=homepageAction.findAllMapBottomMenu(param);
		List<Dto> dtoList = new ArrayList<Dto>();
		Dto returnDto=new BaseDto();
		for(int i=0;i<Params.size();i++)
		{
			Dto menuParam = new BaseDto();
			menuParam.put("MOD_ID", Params.get(i).get("MOD_ID"));
			menuParam.put("MOD_NAME", Params.get(i).get("MOD_NAME"));
			menuParam.put("MOD_PARENT_ID", Params.get(i).get("MOD_PARENT_ID"));
			menuParam.put("MOD_ISLEAF", Params.get(i).get("MOD_ISLEAF"));
			menuParam.put("MOD_SQUENCE", Params.get(i).get("MOD_SQUENCE"));
			menuParam.put("MOD_LEVEL", Params.get(i).get("MOD_LEVEL"));
			menuParam.put("MOD_URL", Params.get(i).get("MOD_URL"));
			dtoList.add(menuParam);
		}
		returnDto.put("BottomMenu", dtoList);
		return returnDto.toJson();
	}
	
	/**
     * 查询首页一级菜单
     */
	@RequestMapping(value="/queryOneMenu",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String findAllMapOneMenu(@RequestBody String json,HttpServletRequest request) {
		Dto param=new BaseDto();
		List<Dto> Params=homepageAction.findAllMapOneMenu(param);
		List<Dto> dtoList = new ArrayList<Dto>();
		Dto returnDto=new BaseDto();
		for(int i=0;i<Params.size();i++)
		{
			Dto menuParam = new BaseDto();
			menuParam.put("MOD_ID", Params.get(i).get("MOD_ID"));
			menuParam.put("MOD_NAME", Params.get(i).get("MOD_NAME"));
			menuParam.put("MOD_PARENT_ID", Params.get(i).get("MOD_PARENT_ID"));
			menuParam.put("MOD_ISLEAF", Params.get(i).get("MOD_ISLEAF"));
			menuParam.put("MOD_SQUENCE", Params.get(i).get("MOD_SQUENCE"));
			menuParam.put("MOD_LEVEL", Params.get(i).get("MOD_LEVEL"));
			menuParam.put("MOD_URL", Params.get(i).get("MOD_URL"));
			dtoList.add(menuParam);
		}
		returnDto.put("menuList", dtoList);
		return returnDto.toJson();
	} 
	
	/**
     * 首页搜索功能获取搜索信息
	 * @param context 
     */
	@RequestMapping(value="/queryLikeInfor",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String findAllLikeinfor(@RequestBody String skey,HttpServletRequest request, byte[] context,Model model) {	
		String str=(String) request.getSession().getAttribute("param");
		Dto pagearam=new BaseDto();
		Dto param=new BaseDto();
		param.put("title", str);
		List<Dto> tatles=homepageAction.findAllPageTatle(param);
		PageBean pageBean=new PageBean();
		//总条数
		int countTotal=tatles.size();
		pageBean.setTotalCount(countTotal);
		//起始条数
		int pageNo = 1;
		int pageSize=15; //显示多少条
		pageBean.setPageCount(pageSize); //设置显示多少条
		int start = (pageNo - 1)* pageSize;
		pagearam.put("pageNo", start);
		pagearam.put("pageSize", pageSize);	
		pagearam.put("title", str);
//		model.addAttribute();
		List<Dto> Params=homepageAction.findAllLikeinfor(pagearam);
		List<Dto> dtoList = new ArrayList<Dto>();
		Dto returnDto=new BaseDto();
		for(int i=0;i<Params.size();i++)
		{
			Dto menuParam = new BaseDto();
			menuParam.put("title", Params.get(i).getAsString("title"));
			menuParam.put("create_time", Params.get(i).get("create_time"));
			menuParam.put("url", Params.get(i).get("url"));
//			menuParam.put("context", Params.get(i).get("context"));
			if(Params.get(i).get("context")!=null&&!"".equals(Params.get(i).get("context")))
			{
				context=(byte[]) Params.get(i).get("context");
				try {
					str = new String(context,"GBK");
					System.out.println(str);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			else
			{
				str = "";
			}
			menuParam.put("context", str);
			dtoList.add(menuParam);
		}
		returnDto.put("params", dtoList);
		returnDto.put("pageBean", pageBean);
		return returnDto.toJson();
	} 
		
	
	/**
	 * 首页点击搜索后页面跳转
	 */
	@RequestMapping("/toPage")
	public String toPage(@RequestParam("skey")String skey,HttpServletRequest request,Model model,PageBean pageBean) {
		String strParam="";
		Dto param=new BaseDto();
		if("".equals(skey)||skey==null)
		{		
			strParam=(String) request.getSession().getAttribute("skey");
			skey = strParam;
			param.put("title", strParam);
			
		}
		else
		{
			request.getSession().setAttribute("skey", skey);
			param.put("title", skey);
		}
		List<Dto> tatles=homepageAction.findAllPageTatle(param);
		Dto pagearam=new BaseDto();
		//总条数
		int countTotal=tatles.size();
		pageBean.setTotalCount(countTotal);
		//起始条数
		int pageNo = pageBean.getPageNo();
		int pageSize=12; //显示多少条
		pageBean.setPageCount(pageSize); //设置显示多少条
		int start = (pageNo - 1)* pageSize;
		pagearam.put("pageNo", start);
		pagearam.put("pageSize", pageSize);	
		String str=null;
		pagearam.put("title", skey);
//		model.addAttribute();
		List<Dto> Params=homepageAction.findAllLikeinfor(pagearam);
		List<Dto> dtoList = new ArrayList<Dto>();
		Dto returnDto=new BaseDto();
		for(int i=0;i<Params.size();i++)
		{
			Dto menuParam = new BaseDto();
			menuParam.put("title", Params.get(i).getAsString("title"));
			menuParam.put("create_time", Params.get(i).get("create_time"));
			menuParam.put("url", Params.get(i).get("url"));
//			menuParam.put("context", Params.get(i).get("context"));
			if(Params.get(i).get("context")!=null&&!"".equals(Params.get(i).get("context")))
			{
				byte[] context = (byte[]) Params.get(i).get("context");
				try {
					str = new String(context,"GBK");
					System.out.println(str);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			else
			{
				str = "";
			}
			menuParam.put("context", str);
			dtoList.add(menuParam);
		}
		returnDto.put("params", dtoList);
		model.addAttribute("params",returnDto.toJson());
		model.addAttribute("pageBean", pageBean);
		return "tkcontent/searchshj"; 
	}
	
}

