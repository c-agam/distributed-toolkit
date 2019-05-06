package com.cagam.lock;

import java.util.concurrent.TimeUnit;

public class RedisSingleReentrantLock implements DistributedLock {

    public boolean tryLock(long timeOut, TimeUnit timeUnit) throws Exception {
        return false;
    }

    public void lock() throws Exception {

    }

    public void unlock() {

    }
}
