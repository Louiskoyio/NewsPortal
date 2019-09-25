import com.google.gson.Gson;
import dao.Sql2oDepartmentDao;
import dao.Sql2oNewsDao;
import dao.Sql2oUserDao;
import models.Department;
import models.News;
import models.User;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        Sql2oDepartmentDao departmentDao;
        Sql2oUserDao userDao;
        Sql2oNewsDao newsDao;
        Connection conn;
        Gson gson = new Gson();
        String connectionString = "jdbc:h2:~/news_portal.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");

        departmentDao = new Sql2oDepartmentDao(sql2o);
        userDao = new Sql2oUserDao(sql2o);
        newsDao = new Sql2oNewsDao(sql2o);
        conn = sql2o.open();

        //works
        post("/users/new", "application/json", (req, res) -> {
            User user = gson.fromJson(req.body(), User.class);
            userDao.add(user);
            res.status(201);
            res.type("application/json");
            return gson.toJson(user);
        });

        //works
        post("/news/new", "application/json", (req, res) -> {
            News news = gson.fromJson(req.body(), News.class);
            newsDao.add(news);
            res.status(201);
            res.type("application/json");
            return gson.toJson(news);
        });

        //works
        post("/departments/new", "application/json", (req, res) -> {
            Department department = gson.fromJson(req.body(), Department.class);
            departmentDao.add(department);
            res.status(201);
            res.type("application/json");
            return gson.toJson(department);
        });

        get("/users", "application/json", (req, res) -> {
            res.type("application/json");
            return gson.toJson(userDao.getAll());
        });

        get("/news", "application/json", (req, res) -> {
            res.type("application/json");
            return gson.toJson(newsDao.getAll());
        });

        get("/users/:id", "application/json", (req, res) -> {
            res.type("application/json");
            int employee_id = Integer.parseInt(req.params("employee_id"));
            res.type("application/json");
            return gson.toJson(userDao.findById(employee_id));
        });

        get("/departments/:department_id/news", "application/json", (req, res) -> {
            res.type("application/json");
            int department_id = Integer.parseInt(req.params("department_id"));
            res.type("application/json");
            return gson.toJson(departmentDao.departmentNews(department_id));
        });

        get("/departments/:department_id/users", "application/json", (req, res) -> {
            res.type("application/json");
            int department_id = Integer.parseInt(req.params("department_id"));
            res.type("application/json");
            return gson.toJson(userDao.departmentEmployees(department_id));
        });


        post("/departments/:department_id/news/new", "application/json", (req, res) -> {
            int department_id = Integer.parseInt(req.params("department_id"));
            News news = gson.fromJson(req.body(), News.class);
            news.setDepartment(department_id);
            newsDao.add(news);
            res.status(201);
            return gson.toJson(news);
        });



        after((req, res) ->{
            res.type("application/json");
        });

    }
}
