package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UsersDAO;
import web.model.User;

import java.util.List;

@Component
@Transactional(readOnly = true)
public class UsersServiceImp implements UsersService {
    private final UsersDAO usersDAO;

    @Autowired
    public UsersServiceImp(UsersDAO usersDAO) {

        this.usersDAO = usersDAO;
    }

    public List<User> findAll() {
        return usersDAO.findAll();
    }

    public User findOne(int id) {

        return usersDAO.findOne(id);
    }

    @Transactional
    public void save(User user) {

        usersDAO.save(user);
    }

    @Transactional
    public void update(int id, User updatedUser) {
        updatedUser.setId(id);
        usersDAO.save(updatedUser);
    }

    @Transactional
    public void delete(int id) {
        usersDAO.delete(id);
    }
}
