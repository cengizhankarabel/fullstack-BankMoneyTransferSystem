package com.example.service;

import com.example.entity.Account;
import com.example.entity.Transfer;

import java.util.List;

public interface TransferService {

    boolean transfer(double amount,String fromAccountNumber,String toAccountNumber);

    void saveTransfer(Transfer transfer);

    // show transfer
    List<Transfer> showMyTransactions(String senderAccNumber);
}
