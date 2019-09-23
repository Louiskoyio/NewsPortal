package dao;

import models.Department;

import java.util.List;

public interface DepartmentDao {
    List<Department> getAll();
    void add(Department department);
    List departmentNews(int department_id);
    void deleteDepartment(int department_id);
}
