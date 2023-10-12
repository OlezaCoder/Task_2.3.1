package web.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import java.util.List;
@Component
public class UsersDaoImp implements UsersDAO {
    private final EntityManager entityManager;

    public UsersDaoImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Transactional(readOnly = true)
    @Override
    public List<User> findAll() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }
    @Transactional(readOnly = true)
    @Override
    public User findOne(int id) {
        return entityManager.find(User.class, id);
    }
    @Transactional
    @Override
    public void save(User user) {
        entityManager.merge(user);
    }
    @Transactional
    @Override
    public void update(int id, User updatedUser) {
        User userUpdate = entityManager.find(User.class, id);

        userUpdate.setName(updatedUser.getName());
        userUpdate.setLastName(updatedUser.getLastName());
        userUpdate.setAge(updatedUser.getAge());
    }
    @Transactional
    @Override
    public void delete(int id) {
        entityManager.remove(entityManager.find(User.class, id));
    }
}
