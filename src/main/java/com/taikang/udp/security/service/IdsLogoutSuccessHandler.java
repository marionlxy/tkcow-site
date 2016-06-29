package com.taikang.udp.security.service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import com.taikang.udp.sys.model.UserBO;


public class IdsLogoutSuccessHandler implements LogoutSuccessHandler{
	   
    /*
     * (non-Javadoc)
     * @see org.springframework.security.web.authentication.logout.LogoutSuccessHandler#onLogoutSuccess(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, org.springframework.security.core.Authentication)
     */
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {
           HttpSession session = request.getSession();
           if(session != null){
               saveLog(request);
           }
           RequestDispatcher dispatcher = request.getRequestDispatcher("/user/login.htm");
           dispatcher.forward(request, response);
           
    }
    
    public void saveLog(HttpServletRequest request) {
        UserBO u = SecurityUserHolder.getCurrentUser();
        if (u != null) {
            
            /*SysLog log = new SysLog();
            log.setAddTime(new Date());
            log.setContent(user.getTrueName() + "于"
                    + CommUtil.formatTime("yyyy-MM-dd HH:mm:ss", new Date())
                    + "退出系统");
            log.setTitle("用户退出");
            log.setType(0);
            log.setUser(user);
            log.setIp(WebUtil.getIpAddr(request));
            sysLogService.save(log);*/
        }
    }

}
