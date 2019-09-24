package dao;
import models.User;

import java.util.List;

public interface UserDao {
    List<User> getAll();
    User findById(int employee_id);
    void add(User user);
    List<User> departmentEmployees(int department_id);
    void editUser(int user_id);
    void deleteUser(int user_id);

}
