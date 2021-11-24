package stu.hi.HBV501GFhruturinn.Services;

import stu.hi.HBV501GFhruturinn.Persistence.Entities.NewsExtract;

import java.util.ArrayList;

public interface NewsService {
    NewsExtract findByTitle(String title) throws Exception;

    NewsExtract findByID(int idNews) throws Exception;

    Boolean addNews(NewsExtract newsExtract) throws Exception;

    ArrayList<NewsExtract> getAllNews() throws Exception;

    Boolean deleteNews(int idNews) throws Exception;
}
