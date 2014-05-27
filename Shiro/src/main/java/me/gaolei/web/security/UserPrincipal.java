package me.gaolei.web.security;

import java.io.Serializable;
import java.util.Collection;

/**
 * 自定义Authentication对象，使得Subject除了携带用户的登录名外还可以携带更多信息.
 */
public class UserPrincipal implements Serializable {
    private static final long serialVersionUID = 1L;
    private String email;
    private Long id;
    private String userName;
    private Collection<String> roles;
    private Collection<Long> roleIds;
    private Collection<String> permissions;
    private String password;

    public UserPrincipal() {
    }

    public UserPrincipal(Long id, String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }


//    private <T> List<T> getListFromAttributes(Class<T> type, Map<String, Object> attributes, String key) {
//        Object valuesObj = attributes.get(key);
//        String[] valuesArr = null;
//        if (valuesObj instanceof String[]) {
//            valuesArr = (String[]) valuesObj;
//        } else if (valuesObj instanceof String) {
//            valuesArr = StringUtils.valueOf(valuesObj).split(",");
//        } else if (valuesObj instanceof List) {
//            return (List<T>) valuesObj;
//        }
//        if (valuesArr != null && valuesArr.length > 0) {
//            T[] roleIdsArray = (T[]) ConvertUtils.convert(valuesArr, type);
//            List<T> permissions = Arrays.asList(roleIdsArray);
//            return permissions;
//        }
//        return new ArrayList<T>();
//    }

    /**
     * 本函数输出将作为默认的<shiro:principal/>输出.
     */
    @Override
    public String toString() {
        return userName;
    }

    /**
     * 重载equals,只计算loginName;
     */
    @Override
    public int hashCode() {
        return this.email.hashCode();
    }

    public Long getId() {
        return this.id;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public Collection<String> getRoles() {
        return roles;
    }

    public Collection<String> getPermissions() {
        return permissions;
    }

    public Collection<Long> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(Collection<Long> roleIds) {
        this.roleIds = roleIds;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}