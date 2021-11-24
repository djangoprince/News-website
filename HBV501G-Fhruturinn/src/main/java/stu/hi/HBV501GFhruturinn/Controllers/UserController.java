package stu.hi.HBV501GFhruturinn.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import stu.hi.HBV501GFhruturinn.Persistence.Entities.User;
import stu.hi.HBV501GFhruturinn.Services.UserService;

import javax.servlet.http.HttpSession;

//This controller will get and send the data of users, like then they log in, an accound gets created or deleted

@Controller
public class UserController {
    private UserService userService;
    private User user;
    private boolean error;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    // End points to add
    // Add a way to signup (GET, POST) using a form in html
    // login (GET, POST)
    // loggedin (GET) if not logged in -> redirect to homepage, otherwise it will display my username and possibly recipes?

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signupGET(User user) {
        return "signup";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signupPOST(User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "redirect:/signup";
        }

        User exists = userService.findByUsername(user.getUsername());


        if (exists == null) {
            userService.save(user);
        } else error = false;
        return "redirect:/error";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginGET(User user) {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginPOST(User user, BindingResult result, Model model, HttpSession session) {
        if (result.hasErrors()) {
            return "login";
        }
        User exists = userService.login(user);
        if (exists != null) {
            session.setAttribute("LoggedInUser", exists);
            model.addAttribute("LoggedInUser", exists);
            return "redirect:/userNews";
        }
        return "redirect:/userNews";
    }

    @RequestMapping(value = "/loggedin", method = RequestMethod.GET)
    public String loggedinGET(HttpSession session, Model model) {
        User sessionUser = (User) session.getAttribute("LoggedInUser");
        if (sessionUser != null) {
            model.addAttribute("LoggedInUser", sessionUser);
            return "loggedInUser";
        }
        return "redirect:/";
    }

    // logoutGET method

    // logoutPOST method

    @RequestMapping(value = {"/logout"}, method = RequestMethod.POST)
    public String logoutDo(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        SecurityContextHolder.clearContext();
        session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }

        return "logout";
    }

    @RequestMapping(value = "/loggedout", method = RequestMethod.GET)
    public String loggedoutGET(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout"; //redirect to login screen
    }

}
