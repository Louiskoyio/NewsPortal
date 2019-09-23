package dao;

import models.News;

import java.util.List;

public interface NewsDao {

    List<News> getAll();
    void addNews(News news);
    void editNews(int news_id);
    void deleteNews(int news_id);
}
