# CPRG352 Lab 4
*Bryan Meyer*

## Goal

The goal of this lab is to demonstrate a knowledge of session management by creating a simple login page with Java servlets, services, beans, and JSP. The full lab assignment document can be found in the root folder, Lab4.docx.

## Technologies

For this lab, I used Netbeans 12.6, JDK 17, and Tomcat 9.

## Structure and Architecture

This lab uses a simple MVC architecture.
There are two servlets, LoginServlet and HomeServlet. The LoginServlet serves the login page, accepts and validates usernames and passwords (using a service class), creates the session and stores the username in the session. It also processes the logout of the user, destroying the session. The HomeServlet serves the home page with a customized message for each user based on the username in the session.

## How Do I Run It?

If you have the same versions of Netbeans, Java, and Tomcat as above, simply import the project into Netbeans and run it from there.
If your Netbeans doesn't open the browser automatically, open it and go to http://localhost:8080/lab4

## License

You're kidding, right?