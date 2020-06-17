package com.civil.userlocation.data;

import com.civil.userlocation.entity.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CacheMapClass {

    private static CacheMapClass instance = null;

    /**
     * cache map class to store computed results
     */
    private CacheMapClass() {
    }

    public static CacheMapClass getInstance() {
        if(instance == null) {
            instance = new CacheMapClass();
        }
        return instance;
    }
    Map<String, List<User>> cacheMap = new HashMap<>();

    public Map<String, List<User>> getCacheMap() {
        return cacheMap;

    }

}
