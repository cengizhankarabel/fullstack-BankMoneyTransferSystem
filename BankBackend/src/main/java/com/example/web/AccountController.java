package com.example.web;


import com.example.entity.Account;
import com.example.entity.User;
import com.example.repository.AccountRepository;
import com.example.repository.JpaAccountRepository;
import com.sun.xml.bind.v2.TODO;
import io.javalin.http.Handler;
import org.eclipse.jetty.http.HttpStatus;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import java.util.List;


public class AccountController {

    static EntityManagerFactory entityManagerFactory;
    static {
        entityManagerFactory= Persistence.createEntityManagerFactory("my-pu");
    }
    //---------------------------------------------
    static AccountRepository accountRepository =new JpaAccountRepository(entityManagerFactory);
    //---------------------------------------------


    public static Handler postAccount=ctx->{
        // TODO: 11/28/2021 ask to NAG ASP
//        Account account=ctx.bodyAsClass(Account.class);
//        accountRepository.saveAccount(account);
//        ctx.status(HttpStatus.CREATED_201);
    };

    public static Handler findAllAccount= ctx->{
        List<Account> accounts = accountRepository.showAllAccounts();
        ctx.json(accounts);
    };

    public static Handler getMyAccount= ctx->{

//                String id=ctx.pathParam("id");
        int id=Integer.parseInt(ctx.pathParam("id"));
        Account account=accountRepository.findMyAccount(id);
        ctx.json(account);

    };

//    app.post("/users/{userId}/accounts",AccountController.saveAccount);
    public static Handler saveAccount = ctx->{
        String userId=ctx.pathParam("userId");
        System.out.println(userId);
        Account account = ctx.bodyAsClass(Account.class);
        User user=new User();
        user.setId(Integer.parseInt(userId));
        account.setUser(user);
        accountRepository.saveAccount(account);
        ctx.status(HttpStatus.CREATED_201);
    };

    public static Handler deleteAccount= ctx->{
        String id=(ctx.pathParam("accountNumber"));
        accountRepository.deleteAccount(id);
        ctx.status(HttpStatus.OK_200);
    };

}
