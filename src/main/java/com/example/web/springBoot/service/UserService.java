package com.example.web.springBoot.service;



import com.example.web.springBoot.model.User;

import java.util.List;

public interface UserService {
    public List<User> getUsers();

    public User showOneUser(int id);

    public void saveUser(User user);

    public void updateUser(User updatedUser);

    public void deleteUser(User user);

}
