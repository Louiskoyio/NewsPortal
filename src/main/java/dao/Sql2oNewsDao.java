package dao;

import models.News;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oNewsDao implements NewsDao{


    private final Sql2o sql2o;

    public Sql2oNewsDao(Sql2o sql2o) { this.sql2o = sql2o; }

    @Override
    public void add(News news) {
        String sql = "INSERT INTO news (name,objective) VALUES (:name,:objective)";
        try(Connection con = sql2o.open()){
            int news_id = (int) con.createQuery(sql, true)
                    .bind(news)
                    .throwOnMappingFailure(false)
                    .executeUpdate()
                    .getKey();
            news.setNews_id(news_id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void editNews(int news_id){

    }

    @Override
    public void deleteNews(int news_id){

    }

    @Override
    public List<News> getAll(){
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM newss")
                    .throwOnMappingFailure(false)
                    .executeAndFetch(News.class);
        }

    }
}
