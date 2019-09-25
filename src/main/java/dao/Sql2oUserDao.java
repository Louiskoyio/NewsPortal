package dao;

import models.User;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oUserDao implements UserDao{

    private final Sql2o sql2o;

    public Sql2oUserDao(Sql2o sql2o) { this.sql2o = sql2o; }
//employee_id, String fname, String lname, String position, String employee_role, String department
    @Override
    public void add(User user) {
        String sql = "INSERT INTO users (fname,lname,position) VALUES (:fname,:lname,:position)";
        try(Connection con = sql2o.open()){
            int employee_id = (int) con.createQuery(sql, true)
                    .bind(user)
                    .throwOnMappingFailure(false)
                    .executeUpdate()
                    .getKey();
            user.setEmployee_id(employee_id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void editUser(int user_id){

    }

    @Override
    public void deleteUser(int user_id){

    }

    @Override
    public List<User> getAll(){
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM users")
                    .throwOnMappingFailure(false)
                    .executeAndFetch(User.class);
        }

    }
    @Override
    public User findById(int employee_id) {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM users WHERE employee_id = :employee_id")
                    .addParameter("employee_id", employee_id) //key/value pair, key must match above
                    .throwOnMappingFailure(false)
                    .executeAndFetchFirst(User.class); //fetch an individual item
        }
    }

    @Override
    public List<User> departmentEmployees(int department_id) {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM users WHERE department_id = :department_id ")
                    .throwOnMappingFailure(false)
                    .executeAndFetch(User.class);
        }
    }
}
