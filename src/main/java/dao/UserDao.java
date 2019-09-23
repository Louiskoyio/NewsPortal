package dao;
import models.User;

import java.util.List;

public interface UserDao {
    List<User> getAll();
    void addUser(User user);
    void editUser(int user_id);
    void deleteUser(int user_id);

}
