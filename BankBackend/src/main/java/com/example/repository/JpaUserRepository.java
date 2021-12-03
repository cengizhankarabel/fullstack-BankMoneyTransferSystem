package com.example.repository;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.example.entity.Account;
import com.example.entity.User;
import com.example.exceptions.InvalidCredentialException;
import com.example.exceptions.UserNotFoundException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

public class JpaUserRepository implements UserRepository{

    private EntityManagerFactory entityManagerFactory;
    private UserRepository userRepository;

    public JpaUserRepository(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    User user=new User();

    @Override
    public void saveUser(User user) {

        String bcryptHashString = BCrypt.withDefaults().hashToString(12, user.getPassword().toCharArray());
        user.setPassword(bcryptHashString);

        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(user);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public User login(String email, String password) {
        System.out.println("AT USER REPOSITORY");
        user = findUserByEmail(email);

        if (user != null) {
            BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), user.getPassword());
            if (result.verified) {
                return user;
            } else {
                throw new InvalidCredentialException("incorrect user/password");
            }
        } else {
            throw new UserNotFoundException("No user found");
        }
    }

    @Override
    public User findUserByEmail(String email) {
        System.out.println("AT USER findUserByEmail");
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        String jpql="from User where email=:email";
        Query query=entityManager.createQuery(jpql);
        query.setParameter("email",email);

        User user=(User)query.getSingleResult();



        entityManager.getTransaction().commit();
        entityManager.close();

        return  user;

    }

    @Override
    public void updateAccEmail(int id, String newAccEmail) {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.find(User.class,id).setEmail(newAccEmail);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public List<User> showAllUser() {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        String jpql="from User";
        Query query=entityManager.createQuery(jpql);
        List<User> users = query.getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();

        return  users;
    }

}

