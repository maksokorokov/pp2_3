package spring_hub_mvc.dao;

import spring_hub_mvc.model.User;

import java.util.List;

public interface UserDAO {
    List<User> getAllUsers();
    void add(User user);
    void delete(Long id);
    void update(User user);
    User get(Long id);
}
