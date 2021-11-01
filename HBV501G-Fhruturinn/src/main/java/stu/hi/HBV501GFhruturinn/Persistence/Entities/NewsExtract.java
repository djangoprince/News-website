package stu.hi.HBV501GFhruturinn.Persistence.Entities;


//@Entitiy
//This entity stores the news extracts requested from the database.
public class NewsExtract {
    private String title;
    private String description;
    private String link;
    private int idNews;
    private String[] tags;

    
    public NewsExtract(String title, String description, String link, int idNews, String[] tags) {
        this.title = title;
        this.description = description;
        this.link = link;
        this.idNews = idNews;
        this.tags = tags;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getIdNews() {
        return idNews;
    }

    public void setIdNews(int idNews) {
        this.idNews = idNews;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }
}
