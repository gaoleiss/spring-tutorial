package me.gaolei.web.mvc;

import me.gaolei.web.security.UserSecurityContextHolder;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class AuthController {

    /**
     * home page
     *
     * @return
     */
    @RequestMapping("/")
    public String index() {
        // append a parameter "m=t" which will lead the menu item be highlight in the page.
        return "home";
    }

    /**
     * login form
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        if (UserSecurityContextHolder.isLogin()) {
            return "redirect:/";
        }
        return "login";
    }

    /**
     * must there are some error when reach this method when login
     *
     * @param userName
     * @param model
     * @return
     * @throws java.io.IOException
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginFail(@RequestParam(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM) String userName, Model model, ServletRequest request,
                            HttpServletResponse response) throws IOException {
        if (UserSecurityContextHolder.isLogin()) {
            return "redirect:/";
        }
        model.addAttribute(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM, userName);
        model.addAttribute("error", "Invalid email or password. Please try again.");
        return "login";
    }

    /**
     * logout
     *
     * @return
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String showLoginPage() {
        SecurityUtils.getSubject().logout();
        return "redirect:user/summary";
    }
}
