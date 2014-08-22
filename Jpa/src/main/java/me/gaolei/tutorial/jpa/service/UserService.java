package me.gaolei.tutorial.jpa.service;


import com.google.common.base.Strings;
import me.gaolei.tutorial.jpa.dao.RoleDao;
import me.gaolei.tutorial.jpa.dao.UserDao;
import me.gaolei.tutorial.jpa.entity.Role;
import me.gaolei.tutorial.jpa.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    RoleDao roleDao;

    @Autowired
    UserDao userDao;

    public List<User> getAllUser() {
        return (List<User>) userDao.findAll();
    }

    public User getUser(Long id) {
        return userDao.findOne(id);
    }

    public void addUser(String userName, String password, Long roleId) {

        if (Strings.isNullOrEmpty(userName) || Strings.isNullOrEmpty(password) || roleId == null) {
            throw new RuntimeException("Please enter the required fields.");
        }

        User user = userDao.findByUserName(userName);
        if (user != null) {
            throw new RuntimeException("User is existing. Please use another name.");
        }

        user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        Role one = roleDao.findOne(roleId);
        List<Role> roles = new ArrayList<Role>();
        roles.add(one);
        user.setRoles(roles);
        userDao.save(user);
    }


}
