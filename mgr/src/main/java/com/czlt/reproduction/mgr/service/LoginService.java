package com.czlt.reproduction.mgr.service;

import com.alibaba.fastjson.JSON;
import com.czlt.reproduction.mgr.protocol.ClientReq;
import com.czlt.reproduction.mgr.protocol.ErrorCode;
import com.czlt.reproduction.mgr.protocol.ResponseData;
import com.czlt.reproduction.mgr.utils.*;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginService {

    @Route("getAESKey")
    public String getAESKey(ClientReq clientReq){
        ResponseData responseData = new ResponseData();
        responseData.setErrorCode(ErrorCode.fail.getValue());
        responseData.setMessage(ErrorCode.fail.getMemo());
        try{
//            String securityToken = clientReq.getSecurityToken();
//            Map<String, Object> paramsMap = new HashMap<>();
//            paramsMap.put("token", securityToken);
//            Login login = loginDao.findByUnique(paramsMap);
//            String serverPrivateKey = login.getPrivatekey();
//            String clientPublicKey = new String(RSACoder.decryptByPrivateKey(
//                    BASE64.decode(clientReq.getParameter()), serverPrivateKey));
//            String aesEncryptKey = BASE64.encode(RSACoder.encryptByPublicKey(
//                    ApiConstants.AES_KEY.getBytes("utf-8"), clientPublicKey));
//            responseData.setErrorCode(ErrorCode.success.getValue());
//            responseData.setMessage(ErrorCode.success.getMemo());
//            responseData.setResult(aesEncryptKey);
        }catch (Exception e){
            Logging.error(e.getMessage(), e);
            responseData.setMessage(ErrorCode.server_error.getValue());
            responseData.setMessage(ErrorCode.server_error.getMemo());
        }
        return JSON.toJSONString(responseData);
    }
}
