package me.gaolei.web;

import me.gaolei.web.security.UserPrincipal;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lei on 27/05/14.
 */
@Service
public class UserDao {
    private Map<String, UserPrincipal> users = new HashMap<String, UserPrincipal>();

    public UserDao() {
        users.put("gao", new UserPrincipal(1L, "gao", DigestUtils.sha1Hex("i1")));
    }

    public UserPrincipal getUser(String userName) {
        return users.get(userName);
    }


}
