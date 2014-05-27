package me.gaolei.web.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DefaultController {

    @RequestMapping("/404")
    public String page404(ModelMap model) {


        return "login";
    }

    @RequestMapping("/test")
    public String test(ModelMap model) {


        return "test";
    }

}
