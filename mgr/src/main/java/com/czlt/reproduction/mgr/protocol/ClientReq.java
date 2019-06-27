package com.czlt.reproduction.mgr.protocol;

import lombok.Data;

@Data
public class ClientReq {
    /*基础参数*/
    private String level1Router;//一级路由
    private String level2Router;//二级路由
    private String accessKeyId;//appId
    private String securityToken;//会话token

    /* 公共参数 */
    private String parameter;
}
