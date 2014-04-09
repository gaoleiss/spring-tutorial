package me.gaolei.tutorial.encache;

/**
 * Created by lei on 4/6/14.
 */

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EhcacheServiceTest {
    private static EhcacheService ehCacheService;

    @BeforeClass
    public static void setUp() {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
        ehCacheService = context.getBean(EhcacheService.class);

        Assert.assertNotNull(ehCacheService.getEhcache("gaolei_me"));
//        // Add a few employees
        ehCacheService.put("1", new Employee(1, "John", "Sander"));
        ehCacheService.put("2", new Employee(2, "Peter", "Sander"));
        ehCacheService.put("3", new Employee(3, "Emma", "Sander"));
    }

    @Test
    public void testRetrieve() {
        Employee employee = (Employee) ehCacheService.get("1");
        Assert.assertNotNull("The employee was not found in the cache", employee);
        Assert.assertEquals("Did not find the correct employee", "John", employee.getFirstName());
    }

    @Test
    public void testRetrieveNotFound() {
        Employee employee = (Employee) ehCacheService.get("5");
        Assert.assertNull("I did not expect find the employee in the cache but it was there", employee);
    }
}