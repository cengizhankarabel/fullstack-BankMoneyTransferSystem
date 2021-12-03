package com.example.service;

import com.example.entity.Account;
import com.example.entity.User;

import java.util.List;

public interface AccountService {

    void setUser(User user);

    void addAccount(Account account);

    void deleteAccount(String id);

    List<Account> showAllAccounts();

    List<Account> showMyAccounts(int userId);

    String findMyAccountNumber(int userId);





}
