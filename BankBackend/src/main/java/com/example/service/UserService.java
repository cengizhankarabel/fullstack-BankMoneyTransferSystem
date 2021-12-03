package com.example.service;

import com.example.entity.Transfer;
import com.example.entity.User;

import java.util.List;

public interface UserService {

    void registerUser(User user);

    User loginUser(String email, String password);

    void editAccountEmail(int id, String newAccEmail);


}
