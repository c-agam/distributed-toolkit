package com.czlt.reproduction.mgr.cache;

import lombok.Data;

@Data
public class ISession {
    /**
     * 过期时间
     */
    private long expireTime;
    /**
     * 创建时间
     */
    private long createTime;
    /**
     * 用户编号
     */
    private Integer userId;
    /**
     * 用户名
     */
    private String username;

    /**
     * 用户token
     */
    private String token;

    /**
     * 用户账户
     */
    private String account;
}
