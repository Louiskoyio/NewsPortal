package models;


import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class News {
    private int news_id;
    private String posted_by;
    private String department;
    private String news_content;
    private Date posted_on;

    public News(int news_id, String posted_by, String department, String news_content, Date posted_on) {
        this.news_id = news_id;
        this.posted_by = posted_by;
        this.department = department;
        this.news_content = news_content;
        this.posted_on = posted_on;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getNews_content() {
        return news_content;
    }

    public void setNews_content(String news_content) {
        this.news_content = news_content;
    }

    public Date getPosted_on() {
        return posted_on;
    }

    public void setPosted_on(Date posted_on) {
        this.posted_on = Calendar.getInstance().getTime();;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        News news = (News) o;
        return news_id == news.news_id &&
                Objects.equals(posted_by, news.posted_by) &&
                Objects.equals(department, news.department) &&
                Objects.equals(news_content, news.news_content) &&
                Objects.equals(posted_on, news.posted_on);
    }

    @Override
    public int hashCode() {
        return Objects.hash(news_id, posted_by, department, news_content, posted_on);
    }
}
