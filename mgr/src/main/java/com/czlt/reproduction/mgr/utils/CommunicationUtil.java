package com.czlt.reproduction.mgr.utils;


import com.alibaba.fastjson.JSON;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

public class CommunicationUtil {

    private static boolean isEncrypt(HttpServletRequest req) {
        boolean isEncrypt = true;
        if("1".equals(req.getHeader(ApiConstants.API_CLIENT_NO_ENCRYPT))) {
            return false;
        }
        return  isEncrypt;
    }

    public static <T> T readJson(HttpServletRequest request, Class<T> clazz) throws Exception {
        byte[] b = IOUtils.readStreamAsByteArray(request.getInputStream());
        if(isEncrypt(request)) {
            b = AESUtil.decrypt(b, ApiConstants.AES_KEY);
        }
        String params = new String(b, ApiConstants.DEFAULT_CHARSET_NAME);
        return JSON.parseObject(params,clazz);
    }

    public static void responseClient(HttpServletRequest req, HttpServletResponse response, String returnString) throws IOException {
        Logging.info("RSP|" + (returnString.length() > 500 ? returnString.substring(0, 500) : returnString));
        byte[] b = returnString.getBytes(ApiConstants.DEFAULT_CHARSET_NAME);
        if (isEncrypt(req)) {
            b = AESUtil.encrypt(b, ApiConstants.AES_KEY);
        }
        response.setHeader("Content-Length", b.length + "");
        OutputStream outputStream = response.getOutputStream();
        outputStream.write(b);
    }
}
