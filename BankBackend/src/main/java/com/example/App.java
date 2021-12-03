package com.example;

import com.example.entity.Account;
import com.example.entity.Transfer;
import com.example.entity.User;
import com.example.exceptions.InvalidCredentialException;
import com.example.exceptions.UserNotFoundException;
import com.example.repository.*;
import com.example.service.*;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.Scanner;

public class App {

    static Scanner scanner = new Scanner(System.in);
    static EntityManagerFactory entityManagerFactory=null;

    static {
        entityManagerFactory= Persistence.createEntityManagerFactory("my-pu");
    }

    //------------------------------------------------------------------
    // Init
    //------------------------------------------------------------------

    static User currentUser = null;
    static Account currentAccount = null;

    static AccountRepository accountRepository = new JpaAccountRepository(entityManagerFactory); // dependency
    static AccountService accountService = new AccountServiceImpl(accountRepository); // dependent

    static TransferRepository transferRepository = new JpaTransferRepository(entityManagerFactory);
    static TransferService transferService = new TransferServiceImpl(transferRepository);


    static UserRepository userRepository = new JpaUserRepository(entityManagerFactory);
    static UserService userService = new UserServiceImpl(userRepository);



    //-------------------------------------------------------------------

    public static void main(String[] args) {


        //------------------------------------------------------------------
        // Use
        //------------------------------------------------------------------

        while (true) {
            System.out.println("\n select choice !");
            System.out.println("" +
                    "\n\n"+
                    "1- Register \n"+
                    "2- Login \n"+
                    "3- Add Account \n"+
                    "4- View My Account \n"+
                    "5- Update Account (email) \n"+
                    "6- Delete Account \n"+
                    "7- Make Transfer\n"+
                    "8- Show My Transaction \n"+
                    "9- Logout \n" +
                    "");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1: {
                    handleChoice1();
                    break;
                }
                case 2: {
                    handleChoice2();
                    break;
                }
                case 3: {
                    handleChoice3();
                    break;
                }
                case 4: {
                    handleChoice4();
                    break;
                }
                case 5: {
                    handleChoice5();
                    break;
                }
                case 6: {
                    handleChoice6();
                    break;
                }
                case 7: {
                    handleChoice7();
                    break;
                }
                case 8: {
                    handleChoice8();
                    break;
                }
                case 9: {
                    currentUser = null;
                    accountService.setUser(null);
                    break;
                }
            }
        }

        //-------------------------------------------------------------------


    }


    // Register
    private static void handleChoice1() {

        scanner.nextLine();

        System.out.println("First Name !");
        String firstName = scanner.nextLine();

        System.out.println("Last Name !");
        String lastName = scanner.nextLine();

        System.out.println("Email !");
        String email = scanner.nextLine();

        System.out.println("Password !");
        String password = scanner.nextLine();

        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setFirstName(firstName);
        user.setLastName(lastName);

        userService.registerUser(user);

    }

    // Login
    private static void handleChoice2() {
        scanner.nextLine();
        System.out.println("Enter Email");
        String email = scanner.nextLine();
        System.out.println("Enter Password");
        String password = scanner.nextLine();
        try {
            currentUser = userService.loginUser(email, password);
            accountService.setUser(currentUser);

            System.out.println("login successful");
        } catch (UserNotFoundException | InvalidCredentialException e) {
            System.out.println("exception: " + e.getMessage());
        }

    }

    // Add Account
    private static void handleChoice3() {

        System.out.println("Enter balance: ");
        scanner.nextLine();
        double newBalance= scanner.nextDouble();
        Account account = new Account(newBalance);
        account.setUser(currentUser);

        accountService.addAccount(account);
    }

    // View My Account
    private static void handleChoice4() {
        accountService.showMyAccounts(currentUser.getId())
                .forEach(System.out::println);
    }

    // Update Account
    private static void handleChoice5() {
        System.out.println("Enter account new-email");
        scanner.nextLine();
        String email = scanner.nextLine();


        userService.editAccountEmail(currentUser.getId(), email);
    }

    // Delete Account
    private static void handleChoice6() {
        System.out.println("Enter account number");
        String id = scanner.nextLine();
        accountService.deleteAccount(id);

    }

    // Make Transfer
    private static void handleChoice7() {
        scanner.nextLine();

        System.out.println("Enter toAccountNumber !");
        String toAccountNumber = scanner.nextLine();
        scanner.nextLine();

        System.out.println("Enter amount!");
        double amount = scanner.nextDouble();

        String fromAccountNumber=  accountService.findMyAccountNumber(currentUser.getId());

        transferService.transfer(amount,fromAccountNumber,toAccountNumber);
    }

    // Show My Transaction
    private static void handleChoice8() {
        transferService.showMyTransactions(accountRepository.
                        findMyAccountNumber(currentUser.getId()))
                .forEach(System.out::println);
    }

    // LogOut


/*





    private static void handleChoice1() {

        System.out.println("Enter balance: ");
        scanner.nextLine();
        double newBalance= scanner.nextDouble();

        accountService.addAccount(newBalance);
    }

    private static void handleChoice2() {
        accountService.showAllAccounts()
                .forEach(System.out::println);
    }

    private static void handleChoice3() {
        System.out.println("Enter account new-email");
        scanner.nextLine();
        String email = scanner.nextLine();

        System.out.println("Enter account id");
        int id = scanner.nextInt();
        accountService.editAccountEmail(id, email);
    }

    private static void handleChoice4() {
        System.out.println("Enter account id");
        int id = scanner.nextInt();
        accountService.deleteAccount(id);
    }

    private static void handleChoice5() {

        scanner.nextLine();

        System.out.println("First Name !");
        String firstName = scanner.nextLine();

        System.out.println("Last Name !");
        String lastName = scanner.nextLine();

        System.out.println("Email !");
        String email = scanner.nextLine();

        System.out.println("Password !");
        String password = scanner.nextLine();

        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setFirstName(firstName);
        user.setLastName(lastName);

        userService.registerUser(user);

    }

    private static void handleChoice6() {
        scanner.nextLine();
        System.out.println("Enter Email");
        String email = scanner.nextLine();
        System.out.println("Enter Password");
        String password = scanner.nextLine();
        try {
            currentUser = userService.loginUser(email, password);
            accountService.setUser(currentUser);

            System.out.println("login successful");
        } catch (UserNotFoundException | InvalidCredentialException e) {
            System.out.println("exception: " + e.getMessage());
        }

    }


    private static void handleChoice7() {
        scanner.nextLine();

        System.out.println("Enter toAccountNumber !");
        String toAccountNumber = scanner.nextLine();
        scanner.nextLine();

        System.out.println("Enter amount!");
        double amount = scanner.nextDouble();

        String fromAccountNumber=  accountService.findMyAccountNumber(currentUser.getId());

        transferService.transfer(amount,fromAccountNumber,toAccountNumber);
    }

    private static void handleChoice8() {
        scanner.nextLine();
        System.out.println("Enter amount!");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Enter toAccountNumber !");
        String toAccountNumber = scanner.nextLine();

//        Transfer transfer=new Transfer();
//        transfer.setSenderId(currentUser.getId());
//        transfer.setAmount(amount);
//        transfer.setReceiverAccountNumber(toAccountNumber);
//        transfer.setDob(new Date());


    }

*/


}
