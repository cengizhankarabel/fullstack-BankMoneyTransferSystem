package com.example;

import com.example.web.AccountController;
import com.example.web.TransferController;
import com.example.web.UserController;
import io.javalin.Javalin;
import io.javalin.http.Handler;

public class Application {


    public static void main(String[] args) {


//        Javalin app = Javalin.create().start(8080);

        Javalin app = Javalin.create(config -> {
            config.enableCorsForAllOrigins();
        }).start(8080);



        app.post("/users/{userId}/accounts",AccountController.saveAccount);

        app.post("/accounts",AccountController.postAccount);


        app.get("/users",UserController.findAllUser);
        app.get("/users/{email}", UserController.findUserByEmail);

        app.post("/transactions",TransferController.makeTransfer);
        app.get("/transactions",TransferController.findAllTransactions);
        app.get("/transactions/{accountNumber}",TransferController.getMyTransactions);

        app.get("/accounts",AccountController.findAllAccount);
        app.get("/accounts/{id}",AccountController.getMyAccount);
        app.delete("/accounts/{accountNumber}",AccountController.deleteAccount);
    }
}
