package models;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class News {
    private int news_id;
    private String posted_by;
    private int department_id;
    private String news_content;


    public News(String posted_by, int department_id, String news_content) {
        this.posted_by = posted_by;
        this.department_id = department_id;
        this.news_content = news_content;

    }

    public int getNews_id() {
        return news_id;
    }

    public void setNews_id(int news_id) {
        this.news_id = news_id;
    }

    public String getPosted_by() {
        return posted_by;
    }

    public void setPosted_by(String posted_by) {
        this.posted_by = posted_by;
    }

    public int getDepartment() {
        return department_id;
    }

    public void setDepartment(int department_id) {
        this.department_id = department_id;
    }

    public String getNews_content() {
        return news_content;
    }

    public void setNews_content(String news_content) {
        this.news_content = news_content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        News news = (News) o;
        return news_id == news.news_id &&
                Objects.equals(posted_by, news.posted_by) &&
                Objects.equals(department_id, news.department_id) &&
                Objects.equals(news_content, news.news_content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(news_id, posted_by, department_id, news_content);
    }
}
