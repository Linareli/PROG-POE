/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yezzimetsuccess;

/**
 *
 * @author Nkanyezi
 */
public class Login {
      
    //declarations
    private String username;
    private String password;
    private String cellPhoneNumber;

    // this is here as my constructor
    public Login(String username, String password, String cellPhoneNumber) {
        this.username = username;
        this.password = password;
        this.cellPhoneNumber = cellPhoneNumber;
    }

    // Method to check username format
    public boolean checkUsername(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    // Method to check password complexity
    public boolean checkPasswordComplexity(String password) {
        return password.length() >= 8 &&
                //for complexity, the password must ALSO contain: 
               password.matches(".*[A-Z].*") && //atleast 1 capital letter
               password.matches(".*\\d.*") &&   //a number
               password.matches(".*[^a-zA-Z0-9].*");    //other characters
    }

    // Method to check cell phone number (assuming correct length and +27 for SA)
    //**using AI for regex code
    public boolean checkCellPhoneNumber(String cellphone) {
        String regex = "^\\+27\\d{9}$";
        return cellPhoneNumber.startsWith("+27") && cellPhoneNumber.length() == 12 && cellPhoneNumber.matches(regex);
    }

    // Method to register user
    
    public String registerUser(String username, String password, String cellPhoneNumber) {
        if (!this.checkUsername(username)) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.";
        } else if (!this.checkPasswordComplexity(password)) {
            return "Password does not meet complexity standards, please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        } else if (!this.checkCellPhoneNumber(cellPhoneNumber)) {
            return "Incorrect South African phone number, please start with +27 ";
        } else if (checkUsername(username) && checkPasswordComplexity(password) && checkCellPhoneNumber(cellPhoneNumber)) {
            return "User successfully registered."; //(:
        }
        return "Registration failed."; //):
    }

    // Method to login user
    public boolean loginUser(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    // Method to return login status
    public String returnLoginStatus(boolean loginSuccess) {
        if (loginSuccess) {
//            String parts = username.split("_");
//            String firstName = username;
//            String lastName =: "";
            return "Welcome, "+ username + " it is great to see you again.";
        } else {
            return "Login failed. "
                    + "Username or password incorrect, please try again.";
        }
    }//Methods end
} //end of class

