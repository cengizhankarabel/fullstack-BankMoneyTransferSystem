package com.example.service;


import at.favre.lib.crypto.bcrypt.BCrypt;
import com.example.entity.User;
import com.example.exceptions.InvalidCredentialException;
import com.example.exceptions.UserNotFoundException;
import com.example.repository.UserRepository;

import java.util.List;

public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public void registerUser(User user) {
//        // hash the plain-text password
//        // ref: https://github.com/patrickfav/bcrypt
//        String bcryptHashString = BCrypt.withDefaults().hashToString(12, user.getPassword().toCharArray());
//        user.setPassword(bcryptHashString);
//        // save user in database
        userRepository.saveUser(user);
    }

    @Override
    public User loginUser(String email, String password) {
        return userRepository.login(email,password);
//        User user = userRepository.findUserByEmail(email);
//        if (user != null) {
//            BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), user.getPassword());
//            if (result.verified) {
//                return user;
//            } else {
//                throw new InvalidCredentialException("incorrect user/password");
//            }
//        } else {
//            throw new UserNotFoundException("No user found");
//        }
    }

    @Override
    public void editAccountEmail(int id, String newAccEmail) {
        userRepository.updateAccEmail(id, newAccEmail);
    }


}
