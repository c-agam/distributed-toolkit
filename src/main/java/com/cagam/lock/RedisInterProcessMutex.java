package com.cagam.lock;

import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.JedisPool;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class RedisInterProcessMutex {
    private static final Logger logger = LoggerFactory.getLogger(RedisInterProcessMutex.class);
    private final ConcurrentMap<Thread, LockData> threadData = new ConcurrentHashMap<Thread, LockData>();
    private static final String LOCK_NAME = "lock-";

    // 锁超时时间
    private int lockTimeOut = 3000;

    private JedisPool jedisPool;

    public RedisInterProcessMutex(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }


    public boolean acquire(String lockName, long time, TimeUnit unit) {
        long startMillis = System.currentTimeMillis();
        Long millisToWait = unit != null ? unit.toMillis(time) : null;

        return false;
    }

    private static class LockData {
        final Thread owningThread;
        final String lockPath;
        final AtomicInteger lockCount;

        private LockData(Thread owningThread, String lockPath) {
            this.lockCount = new AtomicInteger(1);
            this.owningThread = owningThread;
            this.lockPath = lockPath;
        }
    }
}
