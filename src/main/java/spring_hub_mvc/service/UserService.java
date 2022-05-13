package spring_hub_mvc.service;

import spring_hub_mvc.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void add(User user);
    void delete(Long id);
    void update(User user);
    User get(Long id);
}
