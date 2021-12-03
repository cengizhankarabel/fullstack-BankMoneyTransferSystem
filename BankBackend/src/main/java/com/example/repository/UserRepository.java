package com.example.repository;

import com.example.entity.Transfer;
import com.example.entity.User;

import java.util.List;

public interface UserRepository {

    void saveUser(User user);

    User login(String email, String password);

    User findUserByEmail(String email);

    void updateAccEmail(int id, String newAccEmail);

    List<User> showAllUser();
}
