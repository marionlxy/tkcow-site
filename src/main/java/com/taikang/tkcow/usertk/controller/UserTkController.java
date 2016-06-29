package com.taikang.tkcow.usertk.controller;

import com.taikang.tkcow.usertk.action.IUserTkAction;
import java.util.Map;
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
  * UserTkController
  */
@Controller("userTkController")
@RequestMapping(value="/userTk")
public class UserTkController  extends BaseController  {
		
	@Resource(name=IUserTkAction.ACTION_ID)
	private IUserTkAction userTkAction;
		
	
	
	/**
	 * 保存新增
	 * @return
	 */
	@RequestMapping("/save")
//	@ResponseBody
	private String saveUserTkInfo(HttpServletRequest request)
	{
		Map<String,String> map=new HashMap<String,String>();
		
		Dto param = CommonUtil.getParamAsDto(request);
		
		Dto dto = new BaseDto();
//		dto.put("id", "0000011112");
		dto.put("truename", param.get("xm"));
		dto.put("mobile", param.get("tel"));
		dto.put("email", param.get("email"));
		dto.put("address", param.get("address"));
		dto.put("username", param.get("username"));
		dto.put("password", param.get("password"));

		
		
		
		dto.put("deletestatus","0");
		dto.put("gold", 0);
		dto.put("integral",0);
		dto.put("sex", 0);
		dto.put("userCredit",0);
		
		
		userTkAction.insertObject(dto);
//			map.put(MESSAGE_INFO, "新增成功！");
//			map.put(RTN_RESULT, "true");
		
		return"tkcow/index"; 
	}
	
	
	
	/**
	 * 打开主查询页面
	 * @return 页面地址
	 */
	@RequestMapping("")
	public String showUserTkIndexPage() {
		return "userTk/userTkIndex"; 
	}
	
	/**
	 * 查询信息列表
	 * @return 分页列表数据
	 */
	@RequestMapping("/list")
	@ResponseBody
	public Map<String,Object> getUserTkList(HttpServletRequest request,CurrentPage page){
		Map<String, Object> map = new HashMap<String, Object>();
		
		page.setParamObject(CommonUtil.getParamAsDto(request));
		CurrentPage currentPage = userTkAction.queryForPage(page);
		
		map.put("rows", currentPage.getPageItems());
		map.put("total", currentPage.getTotalRows());
		
		return map;
	}

	/**
	 * 打开新增或修改页面
	 * @return
	 */
	@RequestMapping("edit")
	public String showUserTkEditPage(String rowId,Model model) {
		
		if(rowId!=null && !rowId.equals(""))
		{
			model.addAttribute("rowId",rowId );
		}
		
		return "userTk/userTkEdit"; 
	}
	
	/**
	 * 获取一条记录详细信息，用来填充修改界面
	 * @return
	 */
	@RequestMapping("/getOne")
	@ResponseBody
	public Dto getUserTkById(@RequestParam("rowId")String rowId)
	{
		Dto param = new BaseDto();
		param.put("rowId", rowId);
		return userTkAction.findOne(param);
	}
	
	
	
	/**
	*删除一条或多条记录
	*/
	@RequestMapping(value="/del")
	@ResponseBody
	public Map<String, String> deleteUserTk(@RequestParam("rowId") String rowId) {
		Map<String, String> map = new HashMap<String, String>();
		Dto param = new BaseDto();
		param.put("rowId", rowId);
		userTkAction.deleteObject(param);
		
		map.put(RTN_RESULT, "true");
		map.put(MESSAGE_INFO, "操作成功！");
		
		return map;
	}
}

