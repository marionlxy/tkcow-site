package com.taikang.tkcow.askforClaim.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
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

import com.taikang.tkcow.askforClaim.action.IAskforClaimAction;
import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.udp.framework.common.datastructre.impl.BaseDto;
import com.taikang.udp.framework.common.util.TKDateTimeUtils;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;
import com.taikang.udp.framework.core.web.BaseController;
import com.taikang.udp.sys.util.CommonUtil;


/**
  * AskforClaimController
  */
@Controller("askforClaimController")
@RequestMapping(value="/askforClaim")
public class AskforClaimController  extends BaseController  {
		
	@Resource(name=IAskforClaimAction.ACTION_ID)
	private IAskforClaimAction askforClaimAction;
		
	/**
	 * 打开主查询页面
	 * @return 页面地址
	 */
	@RequestMapping("")
	public String showAskforClaimIndexPage() {
		return "askforClaim/askforClaimIndex"; 
	}
	
	
	
	/**
	 * 查询信息列表
	 * @return 分页列表数据
	 */
	@RequestMapping("/list")
	@ResponseBody
	public Map<String,Object> getAskforClaimList(HttpServletRequest request,CurrentPage page){
		Map<String, Object> map = new HashMap<String, Object>();
		
		page.setParamObject(CommonUtil.getParamAsDto(request));
		CurrentPage currentPage = askforClaimAction.queryForPage(page);
		
		map.put("rows", currentPage.getPageItems());
		map.put("total", currentPage.getTotalRows());
		
		return map;
	}

	/**
	 * 打开新增或修改页面
	 * @return
	 */
	@RequestMapping("edit")
	public String showAskforClaimEditPage(String rowId,Model model) {
		
		if(rowId!=null && !rowId.equals(""))
		{
			model.addAttribute("rowId",rowId );
		}
		
		return "askforClaim/askforClaimEdit"; 
	}
	
	/**
	 * 获取一条记录详细信息，用来填充修改界面
	 * @return
	 */
	@RequestMapping("/getOne")
	@ResponseBody
	public Dto getAskforClaimById(@RequestParam("rowId")String rowId)
	{
		Dto param = new BaseDto();
		param.put("rowId", rowId);
		return askforClaimAction.findOne(param);
	}
	
	/**
	 * 保存新增或修改的记录，将其持久化到数据库中
	 * @return
	 * @throws UnknownHostException 
	 */
	@RequestMapping("/save")
	@ResponseBody
	private String saveAskforClaimInfo(HttpServletRequest request ,String means_name,String means_method,String means_email,String means_bak) throws UnknownHostException
	{
		Dto map=new BaseDto();
		Dto info = new BaseDto();
		if(means_name.length()>=1){
			String[] means_names=means_name.split(",");
			for(int i=0;i<means_names.length;i++){
				map.put("claimid", UUID.randomUUID().toString().replace("-", ""));
				map.put("meansName", means_names[i]);
				map.put("meansMethod", means_method);
				map.put("meansEmail", means_email);
				map.put("visitFrom", 1);
				map.put("meansBak", means_bak);
				map.put("createdTime",  TKDateTimeUtils.getTodayTimeStamp()); 
				map.put("version", 0);
				map.put("delflag", 0);
				String userIp = getRemortIP( request);
				map.put("userIp", userIp);

				map.put("result", "true");
				askforClaimAction.insertObject(map);
			};
			info.put("flag", "1");
		}else{
			info.put("flag", "0");
		}
		
		
		return info.toJson().toString();
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
	*删除一条或多条记录
	*/
	@RequestMapping(value="/del")
	@ResponseBody
	public Map<String, String> deleteAskforClaim(@RequestParam("rowId") String rowId) {
		Map<String, String> map = new HashMap<String, String>();
		Dto param = new BaseDto();
		param.put("rowId", rowId);
		askforClaimAction.deleteObject(param);
		
		map.put(RTN_RESULT, "true");
		map.put(MESSAGE_INFO, "操作成功！");
		
		return map;
	}
}

