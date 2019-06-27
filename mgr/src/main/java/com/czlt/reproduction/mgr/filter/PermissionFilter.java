package com.czlt.reproduction.mgr.filter;
import com.czlt.reproduction.mgr.cache.ISession;
import com.czlt.reproduction.mgr.cache.SessionManager;
import com.czlt.reproduction.mgr.entity.MpLogin;
import com.czlt.reproduction.mgr.service.MpLoginService;
import com.czlt.reproduction.mgr.utils.ApiConstants;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class PermissionFilter implements Filter {

    @Autowired
    private MpLoginService mpLoginService;

    @Autowired
    private SessionManager sessionManager;

    @Override
    public void init(FilterConfig arg0) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse rep = (HttpServletResponse) response;
        String requestUrl = req.getRequestURI();
        if (!requestUrl.endsWith("apiServlet") && !requestUrl.endsWith("downloadServlet")) {
            chain.doFilter(req, rep);
            return;
        }

        String securityToken = req.getHeader("X-Auth-Token");
        if (StringUtils.isNotBlank(securityToken)) {
            String securityTokenKey = ApiConstants.TOKEN_CACHE + securityToken;
            if (sessionManager.exist(securityTokenKey)) {
                ISession isession = sessionManager.get(securityTokenKey);
                long currentTime = System.currentTimeMillis();
                if (currentTime - isession.getCreateTime() > ApiConstants.LOGIN_EXPIRE_TIME) {
                    //登陆过期
                    rep.setStatus(401);
                    return;
                } else {
                    isession.setCreateTime(currentTime);
                }
            } else {
                MpLogin login = mpLoginService.getLoginInfoByToken(securityToken);
                if (login != null) {
                    if(System.currentTimeMillis() - login.getLogintime().getTime() >= ApiConstants.LOGIN_EXPIRE_TIME){
                        rep.setStatus(401);
                        return;
                    }else{
                        ISession iSession = new ISession();
                        iSession.setAccount(login.getAccount());
                        iSession.setUsername(login.getUsername());
                        iSession.setToken(login.getToken());
                        iSession.setCreateTime(System.currentTimeMillis());
                        iSession.setUserId(login.getUserid());
                        iSession.setExpireTime(ApiConstants.TOKEN_EXPIRE_TIME);
                        sessionManager.set(securityTokenKey, iSession);
                    }
                }
            }
        }
        chain.doFilter(req, rep);
    }

    @Override
    public void destroy() {
    }
}