# fullstack-BankMoneyTransferSystem

## Description

An rudimentary full stack web application that allows users to transfer funds between their own accounts, and have those transfer reflect appropirately.

## Technologies Used

* Webpack 5.64.1
* Webpack DevServer 4.5.0
* Webpack CLI 4.9.1
* Bootstrap 5.1
* TypeScript
* JPA with Hibernate Core 5.6.1.Final
* Javalin 4.1.1
* Slf4j 1.7.31
* Jackson Databind 2.12.4

## Features

* Single Page Application
* Robust Front-end UI logic for transfer to occur
* A user is able to view their funds.

## To-do list:
* Fix bug on obtaining transfers of a given user.
* View transfer history within date ranges
* Ability for user to export transfer history to PDF or XLSX
* Add memo to transfers

## Getting Started
In order to run this project, you will need certain techonologies installed:

For the back-end:
1) JRE 17
2) MySQL
3) Maven, as this builds and automatically managaes dependencies.

For the front-end
1) Webpack
2) Node JS + NPM
3) A modern web browser (preferably with V8 support)

After ensuring technologies are acquired and installed correctly. After navigating to your desired directory of cloning, using git:

```
git clone https://github.com/cengizhankarabel/fullstack-BankMoneyTransferSystem.git
```
After cloning:
1) From the root directory, navigate to ``{root}/back-end/``. Use the commands in ``sqlCommands.txt`` to initialize the database. 
2) Then setup your mySQL credientials and respective database name in ``{root}/back-end/src/main/back-end/src/main/resources/META-INF/persistence.xml``.
3) Run ``{root}/back-end/src/main/java/org/example/Application.java``
4) In your favorite front-end IDE or CMD, ensure the terminal is in dir:``{root}/front-end/``
5) Enter the command in the terminal, ``npm i`` to install the node_modules
6) To start the server, enter the command ``npm start``
7) Once, both applications are running, navigate in your web browser to `localhost:3000`
