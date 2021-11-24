package stu.hi.HBV501GFhruturinn.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import stu.hi.HBV501GFhruturinn.Persistence.Entities.NewsExtract;
import stu.hi.HBV501GFhruturinn.Services.NewsService;

import java.util.ArrayList;

// This controller will control the flow of all data about news items to the user as they get requested

@Controller
public class NewsController {
    private NewsService newsService;

    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @RequestMapping("/")
    public String mainpage(Model model) throws Exception {
        //call a method in service class
        //like calling news
        ArrayList<NewsExtract> extractList = newsService.getAllNews();
        model.addAttribute("News", extractList);
        return "mainpage";
    }
}
