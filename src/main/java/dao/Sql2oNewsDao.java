package dao;

import models.News;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oNewsDao implements NewsDao{


    private final Sql2o sql2o;

    public Sql2oNewsDao(Sql2o sql2o) { this.sql2o = sql2o; }
//news_id, String posted_by, int department_id, String news_content, Date posted_on


/*
    @Override
    public void add(Department department) {
        String sql = "INSERT INTO departments (department_name,description) VALUES (:department_name,:description)";
        try(Connection con = sql2o.open()){
            int department_id = (int) con.createQuery(sql, true)
                    .bind(department)
                    .throwOnMappingFailure(false)
                    .executeUpdate()
                    .getKey();
            department.setDepartment_id(department_id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }*/

    @Override
    public void add(News news) {
        String sql = "INSERT INTO news (posted_by,news_content) VALUES (:posted_by,:news_content)";
        try(Connection con = sql2o.open()){
            int news_id = (int) con.createQuery(sql, true)
                    .bind(news)
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
            return con.createQuery("SELECT * FROM news")
                    .throwOnMappingFailure(false)
                    .executeAndFetch(News.class);
        }

    }
}
