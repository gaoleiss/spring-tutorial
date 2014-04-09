package me.gaolei.tutorial.encache;

/**
 * Created by lei on 4/6/14.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.stereotype.Service;

@Service
public class CacheService {
    /**
     * The CacheManager provides us access to individual Cache instances
     */
    @Autowired
    private org.springframework.cache.CacheManager cacheManager;

    private final static String cacheName = "gaolei_me";


    public org.springframework.cache.Cache getEhcache(String cacheName) {
        return cacheManager.getCache(cacheName);
    }

    /**
     * Adds a new Object to the Cache
     */
    public void put(String key, Object object) {

        // Add the element to the cache
        getEhcache(cacheName).put(key, object);
    }

    /**
     * Retrieves a Object from the cache
     */
    public Object get(String key) {
        // Retrieve the Object that contains the requested key
        Cache.ValueWrapper value = getEhcache(cacheName).get(key);
        if (value != null) {
            return value.get();
        } else {
            return null;
        }

    }
}