package com.example.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="transactions")
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Transaction_Number")
    private int id;

    @Column(name = "Receiver_Account_Number", nullable = false)
    private String receiverAccountNumber;

    @Column(name = "Amount", nullable = false)
    private double amount;

    @Column(name = "Date",nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dob;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sender_account_number")
    private Account account;


//    @ManyToOne
//    @JoinColumn(name = "user_id", nullable = false)
//    private User user;



    public Transfer(String receiverAccountNumber, double amount, Date dob) {
        this.receiverAccountNumber = receiverAccountNumber;
        this.amount = amount;
        this.dob = dob;
    }

    public Transfer(String receiverAccountNumber, double amount, Date dob, Account account) {
        this.receiverAccountNumber = receiverAccountNumber;
        this.amount = amount;
        this.dob = dob;
        this.account = account;
    }

    public Transfer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReceiverAccountNumber() {
        return receiverAccountNumber;
    }

    public void setReceiverAccountNumber(String receiverAccountNumber) {
        this.receiverAccountNumber = receiverAccountNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Transfer{" +
                "id=" + id +
                ", receiverAccountNumber='" + receiverAccountNumber + '\'' +
                ", amount=" + amount +
                ", dob=" + dob +
                ", account=" + account +
                '}';
    }
}
