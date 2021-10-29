package stu.hi.HBV501GFhruturinn.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import stu.hi.HBV501GFhruturinn.Services.NewsService;

@Controller
public class NewsController {
    private NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @Autowired


    @RequestMapping("/")
    public String mainpage(Model model) {
        //call a method in service class
        return "mainpage";
    }
}
