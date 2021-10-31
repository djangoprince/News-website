package stu.hi.HBV501GFhruturinn.Controllers;

import org.springframework.stereotype.Controller;
import stu.hi.HBV501GFhruturinn.Services.UserService;

@Controller
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //@Autowired
}

