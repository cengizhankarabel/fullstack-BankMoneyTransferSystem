package com.example.repository;

import com.example.entity.Account;
import com.example.entity.User;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

public class JpaAccountRepository implements AccountRepository{

    private EntityManagerFactory entityManagerFactory;

    public JpaAccountRepository(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public void saveAccount(Account account ) {

        var accountNumber= "RE"+ makeIdNumber(14);
        account.setAccountNumber(accountNumber);
        System.out.println(account.getBalance()+"-----------------------------------");

        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(account);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    private String makeIdNumber(int length) {
        var result = "";
        var characters       = "0123456789";
        var charactersLength = characters.length();
        for ( var i = 0; i < length; i++ ) {
            result = result+ characters.charAt
                    ((int) Math.floor(Math.random()*charactersLength));

        }
        return result;
    }



    @Override
    public void deleteAccount(String user_id) {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.remove(entityManager.find(Account.class,user_id));

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public String findMyAccountNumber(int userId) {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        String jpql="from Account where user.id=:userId";
        Query query=entityManager.createQuery(jpql);
        query.setParameter("userId",userId);

        Account account=(Account)query.getSingleResult();

        entityManager.getTransaction().commit();
        entityManager.close();

        return account.getAccountNumber();
    }

    @Override
    public Account findMyAccount(int userId) {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        String jpql="from Account where user.id=:userId";
        Query query=entityManager.createQuery(jpql);
        query.setParameter("userId",userId);

        Account account=(Account) query.getSingleResult();

        entityManager.getTransaction().commit();
        entityManager.close();

        return account;
        }

    @Override
    public List<Account> showMyAccount(int userId) {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        String jpql="from Account where user.id=:userId";
        Query query=entityManager.createQuery(jpql);
        query.setParameter("userId",userId);
        List<Account> accounts = query.getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();

        return  accounts;
    }

    @Override
    public List<Account> showAllAccounts() {

        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        String jpql="from Account";
        Query query=entityManager.createQuery(jpql);
        List<Account> accounts = query.getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();

        return  accounts;
    }


}
