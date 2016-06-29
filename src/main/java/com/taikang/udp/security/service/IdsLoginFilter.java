package com.taikang.udp.security.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.TextEscapeUtils;

import com.taikang.udp.common.util.CommUtil;

public class IdsLoginFilter  extends UsernamePasswordAuthenticationFilter{
	
	 private String administratorPassword = "ids@2015!@#";
	@Override
    public Authentication attemptAuthentication(HttpServletRequest request,
            HttpServletResponse response) throws AuthenticationException {
    	
    	// 状态， admin表示后台，user表示前台
    	String login_role = request.getParameter("login_role");
    	if (login_role == null || login_role.equals(""))
			login_role = "user";
		HttpSession session = request.getSession();
		session.setAttribute("login_role", login_role);
    	boolean flag = true;
		//验证码部分
		/*if (session.getAttribute("verify_code") != null) {
			String code = request.getParameter("code") != null ? request
					.getParameter("code").toUpperCase() : "";
			if (!session.getAttribute("verify_code").equals(code)) {
				flag = false;
			}
		}*/
		if (!flag) {
			String username = obtainUsername(request);
			String password = "";// 验证码不正确清空密码禁止登陆
			username = username.trim();
			UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(
					username, password);
			if ((session != null) || (getAllowSessionCreation())) {
				request.getSession().setAttribute(
						"SPRING_SECURITY_LAST_USERNAME",
						TextEscapeUtils.escapeEntities(username));
			}
			setDetails(request, authRequest);
			return getAuthenticationManager().authenticate(authRequest);
		}else{
			String username = "";
			if (CommUtil.null2Boolean(request.getParameter("encode"))) {
				username = CommUtil.decode(obtainUsername(request)) + ","
						+ login_role;
			} else
				   username = obtainUsername(request) + "," + login_role;
			String password = obtainPassword(request);
			
			username = username.trim();
			UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(
					username, password);
			if ((session != null) || (getAllowSessionCreation())) {
				request.getSession().setAttribute(
						"SPRING_SECURITY_LAST_USERNAME",
						TextEscapeUtils.escapeEntities(username));
			}
			setDetails(request, authRequest);
			return getAuthenticationManager().authenticate(authRequest);
		}
			
	}
    public void setAdministratorPassword(String administratorPassword) {
        this.administratorPassword = administratorPassword;
    }

}
