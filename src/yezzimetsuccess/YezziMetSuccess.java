/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package yezzimetsuccess;
import java.util.Scanner;
/**
 *
 * @author Nkanyezi
 */
public class YezziMetSuccess {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner user = new Scanner(System.in);
        Login login = null;
                
        System.out.println("                               A P P                               ");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("                   ++++++++++++++++++++++++++++                    ");
        System.out.println("                      hey, what is your name?                       ");
        String name = user.nextLine(); //Store user's name just for a better UX
        
        while (true) {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Please Choose an option: ");
            int option = user.nextInt();
            user.nextLine(); 

            switch (option) {
                case 1:
                    login = register(user);
                    if (login != null) {
                        System.out.println("You have successfully registered " +name+"."+ " Now use your details to login (2.Login).");
                        boolean loginSuccess = loginToAccount(user, login);
                        System.out.println(login.returnLoginStatus(loginSuccess));
                    }
                    break;
                case 2:
                    if (login == null) {
                        login = DirectLogin(user);
                        if (login != null) {
                            System.out.println("Welcome!");
                        }
                    } else {
                        System.out.println("You are already logged in.");
                    }
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            } //menu end
        } //end of loop
    } //main ends here

    private static Login register(Scanner details) {
        System.out.println("Register");
        System.out.println("------------------");

        System.out.print("Enter username (with underscore and under 5 chars): ");
        String username = details.nextLine();

        System.out.print("Enter password (at least 8 chars, 1 capital, 1 number, 1 special char): ");
        String password = details.nextLine();

        System.out.print("Enter South African cellphone number: ");
        String cellphoneNumber = details.nextLine();

        Login login = new Login(username, password, cellphoneNumber);
        String registrationMessage = login.registerUser();
        System.out.println(registrationMessage);

        if (registrationMessage.equals("User successfully registered.")) {
            return login;
        } else {
            return null;
        }
    }//end of method

    private static boolean loginToAccount(Scanner scanner, Login login) {
        System.out.println("Login to your account:");
        System.out.print("Enter username: ");
        String loginUsername = scanner.nextLine();
        System.out.print("Enter password: ");
        String loginPassword = scanner.nextLine();

        return login.loginUser(loginUsername, loginPassword);
    } //end of logToAcc

    private static Login DirectLogin(Scanner scanner) {
        System.out.println("Login to your account:");
        System.out.print("Enter username: ");
        String loginUsername = scanner.nextLine();
        System.out.print("Enter password: ");
        String loginPassword = scanner.nextLine();

        // In a real app, I would retrieve the Login object from a database or storage but we don't have that here, what now..
        // I'll just create a new Login object and check the credentials yeeeaa
        System.out.print("Enter cellphone number: ");
        String cellphoneNumber = scanner.nextLine();
        Login login = new Login(loginUsername, loginPassword, cellphoneNumber);

        if (login.loginUser(loginUsername, loginPassword)) {
            return login;
        } else {
            System.out.println("Invalid username or password.");
            return null;
        }
    } //end of DirectLog
}//end of class
