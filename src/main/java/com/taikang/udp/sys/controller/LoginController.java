package com.taikang.udp.sys.controller;


import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taikang.tkcow.usertk.action.IUserTkAction;
import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.udp.framework.common.datastructre.impl.BaseDto;
import com.taikang.udp.framework.core.web.BaseController;
import com.taikang.udp.sys.util.servlet.ValidateCodeServlet;

/**
 * 登录Controller
 * @author Johnny
 */
@Controller("loginController")
@RequestMapping(value="/loginT")
public class LoginController extends BaseController {
	@Resource(name=IUserTkAction.ACTION_ID)
	private IUserTkAction userTkAction;
	/**
	 * 登录
	 * @throws IOException 
	 */
	@RequestMapping(value = "/login",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String login(HttpServletResponse response, HttpServletRequest request,String login_username,String  login_password, String validatecodepro) throws IOException {
		ValidateCodeServlet validate = new ValidateCodeServlet(); 
		boolean yzm = validate.validate(request, validatecodepro);
		 Dto map = new BaseDto();
		String srt = "";
		if(!yzm){
			srt  = "验证码输入有误！";
			map.put("srt", srt);
			map.put("result",false);
		}else{
			Dto dto = new BaseDto();
			dto.put("username", login_username);
			dto.put("password", login_password);
			Dto param = userTkAction.findOne(dto);
			System.out.println(param);
			if(param.isAllEmpty()){
				srt  = "用户名或密码有误！";
				map.put("srt", srt);
				map.put("result",false);


			}else{
				map.put("result",true);
			}
		}
		return map.toJson();
	}
		
	/**
	 * 登录失败，真正登录的POST请求由Filter完成
	 */
//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	public String login(@RequestParam(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM) String username, HttpServletRequest request, HttpServletResponse response, Model model) {
//		LoginUser user = UserUtils.getUser();
//		// 如果已经登录，则跳转到管理首页
//		if(user.getUserId() != null){
//			return "redirect: /main";
//		}
//		model.addAttribute(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM, username);
//		
//		return "login";
//	}
}
