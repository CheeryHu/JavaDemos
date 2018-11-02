package com.cheeryhu.java.cache;

import com.cheeryhu.java.lockDemo.Cache;

public class UserService {

    private CacheManager<User> cacheManager;

    public UserService(){
        cacheManager = new CacheManager<>();
    }

    public User getUserById(String userId){
        User result = cacheManager.getValue(userId);
        if(null != result){
            System.out.println("get from cache..." + userId);
            return result;
        }

        result = getFromDB(userId);
        if(null != result){
            cacheManager.addOrUpdateCache(userId, result);
        }

        return result;
    }

    public void reload(){
        cacheManager.evictCache();
    }

    private User getFromDB(String userId){
        System.out.println("real querying db..." + userId);
        return new User(userId);
    }
}
