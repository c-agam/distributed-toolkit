package com.czlt.reproduction.mgr.cache;


public interface CacheManager<T> {

    void set(String key, T t);

    T get(String key);

    void remove(String key);

    boolean exist(String key);
}
