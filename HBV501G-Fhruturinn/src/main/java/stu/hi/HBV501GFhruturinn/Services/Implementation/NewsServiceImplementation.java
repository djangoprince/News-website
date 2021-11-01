package stu.hi.HBV501GFhruturinn.Services.Implementation;

import org.springframework.stereotype.Service;
import stu.hi.HBV501GFhruturinn.Persistence.Entities.NewsExtract;
import stu.hi.HBV501GFhruturinn.Services.NewsService;

import java.util.List;

@Service
//this class is the middle man for contact between the Repository and the NewsContoller
public class NewsServiceImplementation implements NewsService {
    /*
    private List<NewsExtract> newsRepository = new ArrayList<>();
    private int idCounter = 0;

    @Autowired
    public NewsServiceImplementation() {
        // 3 random news items, to be removed when database is implemented
        newsRepository.add(new NewsExtract(title:"news1", description:"random1", link:"mbl.is", idNews:"0", tags:
        "icelandic west"));
        newsRepository.add(new NewsExtract(title:"news1", description:"random1", link:"mbl.is", idNews:"0", tags:
        "icelandic west"));
        newsRepository.add(new NewsExtract(title:"news1", description:"random1", link:"mbl.is", idNews:"0", tags:
        "icelandic west"));

    }

     */

    @Override
    public NewsExtract findByTitle(String title) {
        return null;
    }

    @Override
    public NewsExtract findByID(int idNews) {
        return null;
    }

    @Override
    public NewsExtract addNews(NewsExtract newsExtract) {
        return null;
    }

    @Override
    public List<NewsExtract> getAll() {
        return null;
    }

    @Override
    public void deleteNews(NewsExtract newsExtract) {

    }
}
