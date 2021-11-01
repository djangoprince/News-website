package stu.hi.HBV501GFhruturinn.Controllers;

import org.springframework.stereotype.Controller;
import stu.hi.HBV501GFhruturinn.Services.UserService;

//This controller will get and send the data of users, like then they log in, an accound gets created or deleted

@Controller
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //@Autowired
}

