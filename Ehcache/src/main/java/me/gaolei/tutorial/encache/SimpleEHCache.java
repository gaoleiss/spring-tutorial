package me.gaolei.tutorial.encache;

/**
 * Created by lei on 4/6/14.
 */

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;

import java.io.InputStream;

public class SimpleEHCache {
    /**
     * The CacheManager provides us access to individual Cache instances
     */
    private static final CacheManager cacheManager;

    static {

        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        InputStream resourceAsStream = contextClassLoader.getResourceAsStream("ehcache/ehcache.xml");
        cacheManager = CacheManager.create(resourceAsStream);
    }

    /**
     * A cache that we're designating to hold Employee instances
     */
    private Ehcache employeeCache;

    public SimpleEHCache() {
        // Load our employees cache:
        employeeCache = cacheManager.getEhcache("employees");
    }

    /**
     * Adds a new Employee to the Cache
     */
    public void addEmployee(Integer id, Employee employee) {
        // Create an EHCache Element to hold the Employee
        Element element = new Element(id, employee);

        // Add the element to the cache
        employeeCache.put(element);
    }

    /**
     * Retrieves a Employee from the cache
     */
    public Employee getEmployee(Integer id) {
        // Retrieve the element that contains the requested Employee
        Element element = employeeCache.get(id);
        if (element != null) {

            return (Employee) element.getValue();
        }

        return null;
    }
}