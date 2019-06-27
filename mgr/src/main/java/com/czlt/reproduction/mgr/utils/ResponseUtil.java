package com.czlt.reproduction.mgr.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.czlt.reproduction.mgr.protocol.ErrorCode;
import com.czlt.reproduction.mgr.protocol.ResponseData;

public class ResponseUtil {
    /**
     * 未知错误
     *
     * @param errorString
     * @return
     */
    public static String unknownError(String errorString) {
        JSONObject responseJson = new JSONObject();
        fail(responseJson, errorString);
        return responseJson.toString();
    }

    public static String getResponseString(ErrorCode errorCode){
        ResponseData responseData = new ResponseData();
        responseData.setErrorCode(errorCode.getValue());
        responseData.setMessage(errorCode.getMemo());
        return JSON.toJSONString(responseData);
    }

    /**
     * 成功
     *
     * @return
     */
    public static String success(JSONObject result, String message) {
        JSONObject responseJson = new JSONObject();
        responseJson.put(ApiConstants.result, result);
        responseJson.put(ApiConstants.errorCode, ErrorCode.success.getValue());
        responseJson.put(ApiConstants.message, message);
        return responseJson.toString();
    }

    /**
     * 失败
     *
     * @return
     */
    public static void fail(JSONObject responseJson, String message) {
        responseJson.put(ApiConstants.errorCode, ErrorCode.fail.getValue());
        responseJson.put(ApiConstants.message, message);
    }
}
