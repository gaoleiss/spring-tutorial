package me.gaolei.web.security;

import org.apache.shiro.SecurityUtils;

public class UserSecurityContextHolder {

    /**
     * get current login user id.
     */
    public static Long getCurrentUserId() {
        UserPrincipal user = (UserPrincipal) SecurityUtils.getSubject().getPrincipal();
        if (user == null) {
            throw new RuntimeException("please login.");
        }
        return user.getId();
    }

    /**
     * get current login user name
     *
     * @return
     */
    public static String getCurrentUserName() {
        UserPrincipal user = (UserPrincipal) SecurityUtils.getSubject().getPrincipal();
        if (user == null) {
            throw new RuntimeException("please login.");
        }
        return user.getUserName();
    }

    /**
     * check user login status
     *
     * @return
     */
    public static boolean isLogin() {
        UserPrincipal user = (UserPrincipal) SecurityUtils.getSubject().getPrincipal();
        if (user == null || user.getId() == null) {
            return false;
        } else {
            return true;
        }
    }
}
