package billing.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {


    @RequestMapping(value ="/", method = RequestMethod.GET)
    public ModelAndView index(ModelMap model) {



        return new ModelAndView("/public/index.html");
    }
    
}
