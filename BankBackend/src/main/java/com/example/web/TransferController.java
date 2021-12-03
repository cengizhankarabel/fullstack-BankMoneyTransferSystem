package com.example.web;

import com.example.entity.Account;
import com.example.entity.Transfer;
import com.example.repository.AccountRepository;
import com.example.repository.JpaAccountRepository;
import com.example.repository.JpaTransferRepository;
import com.example.repository.TransferRepository;
import io.javalin.http.Handler;
import io.javalin.http.HttpCode;
import org.eclipse.jetty.http.HttpStatus;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.List;

public class TransferController {

    static EntityManagerFactory entityManagerFactory;

    static {
        entityManagerFactory = Persistence.createEntityManagerFactory("my-pu");
    }

    //---------------------------------------------
    static TransferRepository transferRepository = new JpaTransferRepository(entityManagerFactory);
    //---------------------------------------------

    public static Handler makeTransfer = ctx -> {
        Transfer transfer=ctx.bodyAsClass(Transfer.class);
        transferRepository.saveTransfer(transfer);
        ctx.status(HttpStatus.CREATED_201);
    };

    public static Handler findAllTransactions = ctx -> {
        List<Transfer> transfers = transferRepository.findAllTransactions();
        ctx.json(transfers);
    };

    public static Handler getMyTransactions = ctx -> {

        String id = ctx.pathParam("accountNumber");
//        int id=Integer.parseInt(ctx.pathParam("id"));
        List<Transfer> transfers = transferRepository.findMyTransactions(id);
        ctx.json(transfers);
    };
}