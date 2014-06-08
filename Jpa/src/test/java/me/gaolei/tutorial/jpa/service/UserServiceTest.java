package me.gaolei.tutorial.jpa.service;

import me.gaolei.tutorial.jpa.dao.RoleDao;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceTest {
    UserService userService;
    RoleDao roleDao;
    long roleId = 1L;

    @Before
    public void setUp() {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
        userService = context.getBean(UserService.class);
        roleDao = context.getBean(RoleDao.class);

    }

//    @Test
//    public void addRools() {
//        Role role = new Role();
//        role.setName("student");
//        role.setId(roleId);
//        roleDao.save(role);
//    }

    @Test
    public void testUser() throws Exception {

        userService.addUser("guest", "guest", roleId);
        System.out.println(userService.getAllUser());

    }

//    @Test
//    public void testUser2() throws Exception {
//        userService.addUser("guest2", "guest2", roleId);
//        System.out.println(userService.getAllUser());
//
//    }
}