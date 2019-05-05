package com.cagam.lock;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.zookeeper.KeeperException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

// Reentrant In JVM
public class ZkCuratorReentrantLock implements DistributedLock {
    private static final Logger logger = LoggerFactory.getLogger(ZkCuratorReentrantLock.class);
    public static final String ROOT_PATH = "/ROOT_LOCK/"; // Zk锁根目录
    private static final long delayTimeForClean = 1000; // 延迟清理时间
    private static final ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);

    private CuratorFramework client;
    private String lockPath;
    private InterProcessMutex interProcessMutex;

    public ZkCuratorReentrantLock(CuratorFramework client, String lockPath) {
        if (client == null || lockPath == null
                || "".equals(lockPath.trim()))
            throw new IllegalArgumentException("client and lockPath are not null...");

        this.client = client;
        this.lockPath = ROOT_PATH + lockPath;
        this.interProcessMutex = new InterProcessMutex(client, this.lockPath);
    }

    public boolean tryLock(long timeOut, TimeUnit timeUnit) throws Exception {
        return interProcessMutex.acquire(timeOut, timeUnit);
    }

    public void lock() throws Exception {
        interProcessMutex.acquire();
    }

    public void unlock() {
        try {
            interProcessMutex.release();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executorService.schedule(new Cleaner(client, lockPath), delayTimeForClean, TimeUnit.MILLISECONDS);
        }
    }

    private static class Cleaner implements Runnable {
        CuratorFramework client;
        String path;

        public Cleaner(CuratorFramework client, String path) {
            this.client = client;
            this.path = path;
        }

        public void run() {
            try {
                List list = client.getChildren().forPath(path);
                if (list == null || list.isEmpty()) {
                    client.delete().forPath(path);
                }
            } catch (KeeperException.NoNodeException e) {
                // do not anything
            } catch (KeeperException.NotEmptyException e1) {
                // do not anything
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            }
        }
    }
}
