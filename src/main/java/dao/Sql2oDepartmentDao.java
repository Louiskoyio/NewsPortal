package dao;

import models.Department;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oDepartmentDao implements DepartmentDao{



    private final Sql2o sql2o;

    public Sql2oDepartmentDao(Sql2o sql2o) { this.sql2o = sql2o; }

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
    }

    @Override
    public List departmentNews(int department_id){
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM departments")
                    .throwOnMappingFailure(false)
                    .executeAndFetch(Department.class);
        }

    }

    @Override
    public void deleteDepartment(int department_id){

    }

    @Override
    public List<Department> getAll(){
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM departments")
                    .throwOnMappingFailure(false)
                    .executeAndFetch(Department.class);
        }

    }
}
