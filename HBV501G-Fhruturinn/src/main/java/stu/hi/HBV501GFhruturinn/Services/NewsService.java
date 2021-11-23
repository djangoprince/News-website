package stu.hi.HBV501GFhruturinn.Services;

import stu.hi.HBV501GFhruturinn.Persistence.Entities.NewsExtract;

import java.util.List;

public interface NewsService {
    NewsExtract findByTitle(String title);

    NewsExtract findByID(int idNews);

    NewsExtract addNews(NewsExtract newsExtract);

    List<NewsExtract> getAll();

    Boolean deleteNews(NewsExtract newsExtract);
}
