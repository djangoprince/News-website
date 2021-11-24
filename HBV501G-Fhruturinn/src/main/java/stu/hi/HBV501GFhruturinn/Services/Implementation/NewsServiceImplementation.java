package stu.hi.HBV501GFhruturinn.Services.Implementation;

import org.springframework.stereotype.Service;
import stu.hi.HBV501GFhruturinn.Persistence.Entities.NewsExtract;
import stu.hi.HBV501GFhruturinn.Persistence.Repositories.Repository;
import stu.hi.HBV501GFhruturinn.Services.NewsService;

import java.util.ArrayList;

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
    public NewsExtract findByTitle(String title) throws Exception {
        NewsExtract extract = Repository.findByTitle(title);
        return extract;
    }

    @Override
    public NewsExtract findByID(int idNews) throws Exception {
        NewsExtract extract = Repository.findByID(idNews);
        return extract;
    }

    @Override
    public Boolean addNews(NewsExtract newsExtract) throws Exception {
        if (Repository.addNews(newsExtract)) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public ArrayList<NewsExtract> getAllNews() throws Exception {
        ArrayList<NewsExtract> extractList = Repository.getAllNews();
        return extractList;
    }

    @Override
    public Boolean deleteNews(int idNews) throws Exception {
        if (Repository.deleteNews(idNews)) {
            return true;
        } else {
            return false;
        }
    }
}
