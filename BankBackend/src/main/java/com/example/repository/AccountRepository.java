package com.example.repository;

import com.example.entity.Account;


import java.util.List;


public interface AccountRepository {

    // save acc
    // update acc ( email )
    // delete acc ( id )
    // find acc number ( id )


    void saveAccount(Account account);


    void deleteAccount(String id);

    String findMyAccountNumber(int userId);

    Account findMyAccount(int userId);

    List<Account> showMyAccount (int userId);

    List<Account> showAllAccounts ();




}
