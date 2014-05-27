package me.gaolei.web.security;


import com.google.common.collect.Lists;
import me.gaolei.web.ApplicationContextHolder;
import me.gaolei.web.UserDao;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Sha1Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

import java.util.List;

/**
 * user authorizingRealm implementations
 *
 * @author gaolei
 */
public class UserDetailRealmImpl extends AuthorizingRealm {

    UserDao userDao;

    public UserDetailRealmImpl() {
        //设置认证token的实现类
        setAuthenticationTokenClass(UsernamePasswordToken.class);
        //设置加密算法
        setCredentialsMatcher(new HashedCredentialsMatcher(Sha1Hash.ALGORITHM_NAME));
    }

    /**
     * authenticate tokens of the users.
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        if (userDao == null) {
            userDao = ApplicationContextHolder.getBean(UserDao.class);
        }
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        UserPrincipal user = userDao.getUser(token.getUsername());
        if (user != null) {
            String userName = user.getUserName();
            return new SimpleAuthenticationInfo(user, user.getPassword(), userName);
        } else {
            return null;
        }
    }

    /**
     * get the user roles and authorization
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        UserPrincipal userInfo = (UserPrincipal) principals.getPrimaryPrincipal();
        return doGetAuthorizationInfo(userInfo);
    }

    private AuthorizationInfo doGetAuthorizationInfo(UserPrincipal user) {
        if (user == null) {
            return null;
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermissions(user.getPermissions());
        info.addRoles(user.getRoles());
        return info;
    }

    /**
     * check if the current user have this permission
     *
     * @param permission
     * @return
     */
    public boolean isPermitted(Permission permission) {
        return this.isPermitted(Lists.newArrayList(permission));
    }

    /**
     * check if the current user have this permission
     *
     * @param permission
     * @return
     */
    public boolean isPermitted(List<Permission> permission) {
        UserPrincipal user = this.getCurrentUser();
        AuthorizationInfo auth = doGetAuthorizationInfo(user);
        if (auth == null) {
            return false;
        }
        boolean[] permitted = this.isPermitted(permission, auth);
        if (permission != null) {
            for (int i = 0; i < permitted.length; i++) {
                if (permitted[i]) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * get the login user information
     */
    private UserPrincipal getCurrentUser() {
        Subject subject = SecurityUtils.getSubject();
        subject.getPrincipal();
        Object principal = subject.getPrincipal();
        if (principal == null) {
            return null;
        }
        if (principal instanceof UserPrincipal) {
            return (UserPrincipal) principal;
        } else {
            return null;
        }
    }

}
