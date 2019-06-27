package com.czlt.reproduction.mgr.cache;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class SessionManager implements CacheManager<ISession>{
    private Map<String, ISession> cache = new ConcurrentHashMap<>();
    private ExecutorService executorService = Executors.newSingleThreadExecutor();

    public SessionManager() {
        executorService.execute(new ExpireHandler());
    }

    @Override
    public void set(String key, ISession iSession) {
        if(StringUtils.isNotBlank(key)){
            cache.put(key,iSession);
        }
    }

    @Override
    public ISession get(String key) {
        ISession iSession = null;
        if(StringUtils.isNotBlank(key)){
            iSession = cache.get(key);
        }
        return iSession;
    }

    @Override
    public void remove(String key) {
        if(StringUtils.isNotBlank(key)){
            cache.remove(key);
        }
    }

    @Override
    public boolean exist(String key) {
        return cache.containsKey(key);
    }

    private class ExpireHandler implements Runnable {
        @Override
        public void run() {
            try {
                for (;;) {
                    if(!cache.isEmpty()) {
                        List<String> expireSid = new ArrayList<>();
                        for(Iterator<String> iterator = cache.keySet().iterator(); iterator.hasNext();) {
                            String sid = iterator.next();
                            ISession isession = cache.get(sid);
                            if(System.currentTimeMillis() - isession.getCreateTime() > isession.getExpireTime()) {
                                expireSid.add(sid);
                            }
                        }
                        for(String sid : expireSid) {
                            cache.remove(sid);
                        }
                    }
                    Thread.sleep(5 * 60 * 60);
                }
            } catch (Exception e) {
                executorService.shutdown();
            }
        }
    }
}