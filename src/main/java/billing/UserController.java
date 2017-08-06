package billing;

import billing.mongo.Users;
import billing.mongo.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UsersRepository repository;
    
    /*@RequestMapping("/")
    public String index() {
        Users u = new Users();
        u.setFirstName("anoop");
        u.setLastName("krishnapillai");
        repository.save(u);
        List users = repository.findAll();
          if (!users.isEmpty()) {
              Users uu = (Users)users.get(0);
          return uu.getFirstName()+uu.getLastName();
          }

        return "blank";
    }*/

    @RequestMapping(value ="/", method = RequestMethod.GET)
    public ModelAndView index(ModelMap model) {
         List users = repository.findAll();

        ModelAndView modelAndView = new ModelAndView("index");

        modelAndView.addObject("users", users );

        return modelAndView;
    }
    
}
