package com.example.service;

import com.example.entity.Transfer;
import com.example.exceptions.AccountNotFoundException;
import com.example.entity.Account;
import com.example.exceptions.BalanceException;
import com.example.repository.AccountRepository;


import com.example.repository.TransferRepository;
import com.example.repository.UserRepository;
import org.apache.log4j.Logger;

import java.util.Date;
import java.util.List;

public class TransferServiceImpl implements TransferService{

    private static final Logger logger = Logger.getLogger("mts");

    private TransferRepository transferRepository;


    public TransferServiceImpl(TransferRepository transferRepository) {
        this.transferRepository = transferRepository;
    }

    @Override
    public boolean transfer(double amount, String fromAccountNumber, String toAccountNumber) {
        return transferRepository.transfer(amount,fromAccountNumber,toAccountNumber);
//        // step-1: Load 'from' account , // SELECT
//        Account fromAccount = transferRepository.loadAccount(fromAccountNumber).orElseThrow(
//                () -> new AccountNotFoundException(fromAccountNumber)
//        );
//
//        // step-2: Load 'to' account // SELECT
//        Account toAccount = transferRepository.loadAccount(toAccountNumber).orElseThrow(
//                () -> new AccountNotFoundException(toAccountNumber)
//        );
//        if (fromAccount.getBalance() < amount) {
//            throw new BalanceException(fromAccount.getBalance());
//        }
//
//        // step-3: debit
//        fromAccount.setBalance(fromAccount.getBalance() - amount);
//        logger.debug("debited");
//
//        // step-4: credit
//        toAccount.setBalance(toAccount.getBalance() + amount);
//        logger.debug("credited");
//
//        // step-5: update 'from' account // UPDATE
//        transferRepository.updateAccountAmount(fromAccount);
//
//        // step-6: update 'to' account   // UPDATE
//        transferRepository.updateAccountAmount(toAccount);
//
//        logger.info("transfer completed...");
//
//        Transfer transfer=new Transfer(/*fromAccount.getAccountNumber(),amount,new Date(),fromAccount*/);
//
//
//        transfer.setReceiverAccountNumber(toAccount.getAccountNumber());
//        transfer.setAmount(amount);
//        transfer.setDob(new Date());
//        transfer.setAccount(fromAccount);
//
//        saveTransfer(transfer);
//        return false;
    }

    @Override
    public void saveTransfer(Transfer transfer) {
        transferRepository.saveTransfer(transfer);
    }

    @Override
    public List<Transfer> showMyTransactions(String senderAccNumber) {
        return transferRepository.findMyTransactions(senderAccNumber);
    }
}
