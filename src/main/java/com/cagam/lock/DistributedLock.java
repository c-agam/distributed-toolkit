package com.cagam.lock;

import java.util.concurrent.TimeUnit;

/**
 * 分布式锁
 *
 * @author zul
 * @version 0.0.1
 */
public interface DistributedLock {
    /**
     * 尝试获取锁
     *
     * @param timeOut  超时时间
     * @param timeUnit 超时时间单位
     * @return
     */
    boolean tryLock(long timeOut, TimeUnit timeUnit) throws Exception;

    /**
     * 获取锁
     */
    void lock() throws Exception;

    /**
     * 释放锁
     */
    void unlock();
}
