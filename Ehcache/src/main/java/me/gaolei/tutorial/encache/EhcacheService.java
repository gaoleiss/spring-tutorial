package me.gaolei.tutorial.encache;

/**
 * Created by lei on 4/6/14.
 */

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class EhcacheService {
    /**
     * The CacheManager provides us access to individual Cache instances
     */
    @Resource(name = "ehcacheManager")
    private CacheManager cacheManager;
//    @Autowired
//    private org.springframework.cache.CacheManager cacheManager;

    private final static String cacheName = "gaolei_me";


//    /**
//     * A cache that we're designating to hold Employee instances
//     */
//    private Ehcache cache;

    public Cache getEhcache(String cacheName) {
        return cacheManager.getCache(cacheName);
    }

    /**
     * Adds a new Object to the Cache
     */
    public void put(String key, Object object) {
        // Create an EHCache Element to hold the Object
        Element element = new Element(key, object);

        // Add the element to the cache
        cacheManager.getEhcache(cacheName).put(element);
    }

    /**
     * Retrieves a Object from the cache
     */
    public Object get(String key) {
        // Retrieve the Object that contains the requested key
        Element element = cacheManager.getEhcache(cacheName).get(key);
        if (element != null) {
            return element.getObjectValue();
        }

        return null;
    }
}