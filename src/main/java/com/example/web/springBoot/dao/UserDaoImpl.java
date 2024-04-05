package com.example.web.springBoot.dao;

import com.example.web.springBoot.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<User> getUsers() {
        return entityManager.createQuery("select p from User p", User.class)
                .getResultList();
    }

    @Override
    public User showOneUser(int id) {

        return entityManager.find(User.class, id);
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(User updatedUser) {
        entityManager.merge(updatedUser);
    }

    @Override
    public void deleteUser(User user) {
        User userDelete = entityManager.find(User.class, user.getId());
        entityManager.remove(userDelete);
    }
}
