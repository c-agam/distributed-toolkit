package com.czlt.reproduction.mgr.protocol;

import lombok.Data;

@Data
public class ResponseData {
    private String errorCode;
    private String message;
    private Object result;
}
