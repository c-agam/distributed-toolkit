package com.czlt.reproduction.mgr.servlet;


import com.alibaba.fastjson.JSON;
import com.czlt.reproduction.mgr.protocol.ClientReq;
import com.czlt.reproduction.mgr.utils.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

public class ApiServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            SessionHolder.generateSessionId();
            ClientReq clientReq = CommunicationUtil.readJson(req, ClientReq.class);
            clientReq.setSecurityToken(req.getHeader("X-Auth-Token"));
            Logging.info("REQ|" + JSON.toJSONString(clientReq));
            String routeLevel1 = clientReq.getLevel1Router();
            String routeLevel2 = clientReq.getLevel2Router();
            Object service = SpringHelper.getBean(routeLevel1);
            Method method = service.getClass().getMethod(RouteProcessor.getMethodByRoute(routeLevel1, routeLevel2), ClientReq.class);
            String returnToClient = (String)method.invoke(service, clientReq);
            CommunicationUtil.responseClient(req, resp, returnToClient);
        } catch (Exception e) {
            CommunicationUtil.responseClient(req, resp, ResponseUtil.unknownError(e.getMessage()));
            Logging.error(e.getMessage(), e);
        }
    }
}
