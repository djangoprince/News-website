package stu.hi.HBV501GFhruturinn.Persistence.Repositories;

import stu.hi.HBV501GFhruturinn.Persistence.Entities.NewsExtract;
import stu.hi.HBV501GFhruturinn.Persistence.Entities.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

// The Repository is the program's contact with our MySQl database. It's been the most fleshed out of our classes so far
// and should be ready for use when the services and controllers are set up with functionality.
public class Repository {

    //This function gets a news extract by finding a matching title in the database
    public NewsExtract findByTitle(String title) throws Exception {

        NewsExtract news = new NewsExtract(" ", " ", " ", 0, new String[1]);
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fhruturdb", "root", "2021binniA");

            String stmt = "Select * From fhruturdb.newstable Where title = \"" + title + "\"";
            PreparedStatement getNews = conn.prepareStatement(stmt);
            ResultSet r = getNews.executeQuery();
            while (r.next()) {

                news.setIdNews(r.getInt("idnews"));
                news.setTitle(r.getString("title"));
                news.setDescription(r.getString("descriptions"));
                news.setLink(r.getString("link"));
                String str = r.getString("tags");
                int space = 0;
                for (int i = 0; i <= str.length(); i++) {
                    char ch = str.charAt(i);
                    if (ch == ' ') {
                        space++;
                    }
                }
                String[] tagsArray = str.split(" ", space);

                news.setTags(tagsArray);

            }
            r.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return news;
    }

    //This function gets a news extract by finding a matching ID in the database
    public NewsExtract findByID(int idnews) throws Exception {

        NewsExtract news = new NewsExtract(" ", " ", " ", 0, new String[1]);
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fhruturdb", "root", "2021binniA");

            String stmt = "Select * From fhruturdb.newstable Where idnews = " + idnews;
            PreparedStatement getNews = conn.prepareStatement(stmt);
            ResultSet r = getNews.executeQuery();
            while (r.next()) {

                news.setIdNews(r.getInt("idnews"));
                news.setTitle(r.getString("title"));
                news.setDescription(r.getString("descriptions"));
                news.setLink(r.getString("link"));
                String str = r.getString("tags");
                int space = 0;
                for (int i = 0; i <= str.length(); i++) {
                    char ch = str.charAt(i);
                    if (ch == ' ') {
                        space++;
                    }
                }
                String[] tagsArray = str.split(" ", space);

                news.setTags(tagsArray);
            }
            r.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return news;
    }

    //This function will add news to the database
    public boolean addNews(NewsExtract news) throws Exception {

        boolean isAdded = false;
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fhruturdb", "root", "2021binniA");
            String tagsSTR = "";
            String[] tagsarray = news.getTags();
            for (String i : tagsarray) {
                tagsSTR = tagsSTR.concat(i);
                tagsSTR = tagsSTR.concat(" ");
            }
            tagsSTR = tagsSTR.trim();
            String stmt = "INSERT INTO fhruturdb.newstable(`idnews`, `title`, `description`, `link`, `tags`) VALUES('" + news.getIdNews() + "', '" + news.getTitle() + "', '" + news.getDescription() + "', '" + news.getLink() + "', '" + tagsSTR + "')";
            PreparedStatement addNews = conn.prepareStatement(stmt);
            ResultSet r = addNews.executeQuery();
            while (r.next()) {

            }
            r.close();
            isAdded = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (isAdded) return true;
        else return false;
    }

    //this function will delete news from the database
    public boolean deleteNews(int idnews) throws Exception {
        boolean isdeleted = false;
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fhruturdb", "root", "2021binniA");

            String dstmt = "DELETE From fhruturdb.newstable Where idnews = " + idnews;
            PreparedStatement delete = conn.prepareStatement(dstmt);
            ResultSet r = delete.executeQuery();
            while (r.next()) {

            }
            r.close();
            isdeleted = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (isdeleted) return true;
        else return false;
    }

    //This function will get all news items from the database for the user to go through on the mainpage when it gets requested.
    //An idea for later date once basic functionality of the site/program is accomplished is to change this or make a similar function that fetches
    // news items only with certain tags in regards to a tag search or user place preference.
    public ArrayList<NewsExtract> getAll() throws Exception {
        ArrayList<NewsExtract> extractList = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fhruturdb", "root", "2021binniA");
            NewsExtract news = new NewsExtract(" ", " ", " ", 0, new String[1]);
            String stmt = "SELECT * FROM fhruturdb.newstable";
            PreparedStatement getAllNews = conn.prepareStatement(stmt);
            ResultSet r = getAllNews.executeQuery();
            while (r.next()) {

                news.setIdNews(r.getInt("idnews"));
                news.setTitle(r.getString("title"));
                news.setDescription(r.getString("descriptions"));
                news.setLink(r.getString("link"));
                String str = r.getString("tags");
                int space = 0;
                for (int i = 0; i <= str.length(); i++) {
                    char ch = str.charAt(i);
                    if (ch == ' ') {
                        space++;
                    }
                }
                String[] tagsArray = str.split(" ", space);
                news.setTags(tagsArray);
                extractList.add(news);

            }
            r.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return extractList;
    }

    // This function gets a user profile from the database by username search
    public User findByUsername(String userName) throws Exception {

        User user = new User(" ", " ", " ", true, 0);
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fhruturdb", "root", "2021binniA");

            String stmt = "Select * From fhruturdb.usertable Where username = \"" + userName + "\"";
            PreparedStatement getUser = conn.prepareStatement(stmt);
            ResultSet r = getUser.executeQuery();
            while (r.next()) {

                user.setUserName(r.getString("username"));
                user.setPassword(r.getString("password"));
                user.setEmailAddress(r.getString("emailaddress"));
                user.setAdminPrivilege(r.getBoolean("adminprivilege"));
                user.setIdUser(r.getInt("iduser"));

            }
            r.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }

    //This gets a user profile from the database by ID search
    public User findByUserID(int iduser) throws Exception {

        User user = new User(" ", " ", " ", true, 0);
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fhruturdb", "root", "2021binniA");
            String stmt = "Select * From fhruturdb.usertable Where iduser = " + iduser;
            PreparedStatement getUser = conn.prepareStatement(stmt);
            ResultSet r = getUser.executeQuery();
            while (r.next()) {

                user.setUserName(r.getString("username"));
                user.setPassword(r.getString("password"));
                user.setEmailAddress(r.getString("emailaddress"));
                user.setAdminPrivilege(r.getBoolean("adminprivilege"));
                user.setIdUser(r.getInt("iduser"));

            }
            r.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }

    //This function adds a user profile to the database
    public boolean addUser(User user) throws Exception {

        boolean isAdded = false;
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fhruturdb", "root", "2021binniA");

            String stmt = "INSERT INTO `fhruturdb`.`usertable` (`iduser`, `username`, `password`, `emailaddress`, `adminprivilege`) VALUES('" + user.getIdUser() + "', '" + user.getUserName() + "', '" + user.getPassword() + "', '" + user.getEmailAddress() + "', '" + user.getAdminPrivilege() + "')";
            PreparedStatement addNews = conn.prepareStatement(stmt);
            ResultSet r = addNews.executeQuery();
            while (r.next()) {

            }
            r.close();
            isAdded = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (isAdded) return true;
        else return false;
    }

    //This function deletes a user profile from the database
    public boolean deleteUser(String userName) throws Exception {

        boolean isdeleted = false;
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fhruturdb", "root", "2021binniA");

            String dstmt = "DELETE From fhruturdb.usertable Where username = \"" + userName + "\"";
            PreparedStatement delete = conn.prepareStatement(dstmt);
            ResultSet r = delete.executeQuery();
            while (r.next()) {

            }
            r.close();
            isdeleted = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (isdeleted) return true;
        else return false;
    }
}
