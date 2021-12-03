package com.example.service;

import com.example.entity.Account;
import com.example.entity.User;
import com.example.repository.AccountRepository;

import java.util.List;
import java.util.Random;

public class AccountServiceImpl implements AccountService{

    private AccountRepository accountRepository;
    private User user;
    private Account account;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public void addAccount(Account account){
        accountRepository.saveAccount(account);
    }
//        Account newAccount = new Account(balance);
////        ------------------------------------------------
//
//        String start = "RE";
//        Random value = new Random();
//
//        //Generate two values to append to 'BE'
//        int r1 = value.nextInt(10);
//        int r2 = value.nextInt(10);
//        start += Integer.toString(r1) + Integer.toString(r2) + " ";
//
//        int count = 0;
//        int n = 0;
//        for(int i =0; i < 12;i++)
//        {
//            if(count == 4)
//            {
//                start += " ";
//                count =0;
//            }
//            else
//                n = value.nextInt(10);
//            start += Integer.toString(n);
//            count++;
//
//        }
//
//        newAccount.setAccountNumber(start);
//
//
////        -----------------------------------------------
//        newAccount.setUser(user);
//        accountRepository.saveAccount(newAccount);
//    }

    @Override
    public void deleteAccount(String id) {
        accountRepository.deleteAccount(id);
    }

    @Override
    public List<Account> showAllAccounts() {
        return accountRepository.showAllAccounts();

    }

    @Override
    public List<Account> showMyAccounts(int userId) {
        return accountRepository.showMyAccount(userId);
    }

    @Override
    public String findMyAccountNumber(int userId) {
        return accountRepository.findMyAccountNumber(userId);
    }


}
