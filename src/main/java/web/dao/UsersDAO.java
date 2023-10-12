package web.dao;

import web.model.User;

import java.util.List;

public interface UsersDAO {
    public List<User> findAll();
    public User findOne(int id);
    public void save(User user);
    public void update(int id, User updatedUser);
    public void delete(int id);
}
