create database bankdb;
use bankdb;
---------------------------------------------------------------

1 user has MANY accounts
1 accounts has MANY transactions
--------------------------------------------------------------
CREATE TABLE users(
                      id int PRIMARY KEY auto_increment,
                      firstName varchar(100) NOT NULL,
                      lastName varchar(100) NOT NULL,
                      email varchar(100) NOT NULL,
                      password varchar(100) NOT NULL
);

CREATE TABLE accounts(
                      id int PRIMARY KEY auto_increment,
                      accNumber varchar(100) NOT NULL,
                      balance DOUBLE(100) NOT NULL,
                      user_id int REFERENCES users
);

CREATE TABLE transactions(
                      id int PRIMARY KEY auto_increment,
                      senderId int NOT NULL,
                      senderAccountNumber varchar(100) NOT NULL,
                      receiverAccountNumber varchar(100) NOT NULL,
                      amount double NOT NULL,
                      account_id int REFERENCES accounts


)


insert into users()
