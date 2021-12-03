package com.example.web;

import com.example.entity.Account;
import com.example.entity.Transfer;
import com.example.entity.User;
import com.example.repository.*;
import io.javalin.Javalin;
import io.javalin.http.Handler;
import org.eclipse.jetty.http.HttpStatus;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public class UserController {

    static EntityManagerFactory entityManagerFactory;
    static {
        entityManagerFactory= Persistence.createEntityManagerFactory("my-pu");
    }
    //---------------------------------------------
    static UserRepository userRepository =new JpaUserRepository(entityManagerFactory);
    //---------------------------------------------



    public static Handler findAllUser = ctx -> {
        List<User> users = userRepository.showAllUser();
        ctx.json(users);
    };



    public static Handler findUserByEmail= ctx->{
        String email= ctx.pathParam("email");
        User user=userRepository.findUserByEmail(email);
        ctx.json(user);
    };

    //    app.post("/users/{userId}/{firstName}",AccountController.saveAccount);
    public static Handler createNewUser= ctx->{
        String firstName= ctx.pathParam("First_Name");
        String lastName=ctx.pathParam("Last_Name");
        String email=ctx.pathParam("email");
        String password=ctx.pathParam("password");
        User user=new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(password);

        userRepository.saveUser(user);
        ctx.json(user);
    };


    //    app.post("/users/{userId}/accounts",AccountController.saveAccount);
//    public static Handler saveAccount = ctx->{
//        String userId=ctx.pathParam("userId");
//        System.out.println(userId);
//        Account account = ctx.bodyAsClass(Account.class);
//        User user=new User();
//        user.setId(Integer.parseInt(userId));
//        account.setUser(user);
//        accountRepository.saveAccount(account);
//        ctx.status(HttpStatus.CREATED_201);
//    };
}
