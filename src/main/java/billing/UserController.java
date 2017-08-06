package billing;

import billing.mongo.Users;
import billing.mongo.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UsersRepository repository;
    
    @RequestMapping("/")
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
    }
    
}
