package com.cagam.lock;

import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessReadWriteLock;
import com.cagam.utils.SysConstants;


public class ZkCuratorReentrantReadWriteLock {  
  private String lockPath;
  private CuratorFramework client;
  private InterProcessReadWriteLock interProcessReadWriteLock;
  private InterProcessMutex readLock;
  private InterProcessMutex writeLock;

  public ZkCuratorReentrantReadWriteLock(CuratorFramework client, String lockPath) {
    this.client = client;
    this.lockPath = SysConstants.ZK_LOCK_ROOT_PATH + lockPath;
    this.interProcessReadWriteLock = new InterProcessReadWriteLock(this.client, this.lockPath);
    this.readLock = interProcessReadWriteLock.readLock();
    this.writeLock = interProcessReadWriteLock.writeLock();
  }

  public InterProcessMutex readLock() {
    return this.readLock;
  }

  public InterProcessMutex writeLock() {
    return this.writeLock;
  }
}
