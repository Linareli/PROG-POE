/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package yezzimetsuccess;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;
/**
 *ST10478075
 * @author Nkanyezi
 */
public class YezziMetSuccess {
private static ArrayList<Message> sentMessages = new ArrayList<>();

    private static int numMessagesSent = 0;
    private static int maxMessages;
    public static String messageID="";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ArrayMessages messageObject = new ArrayMessages(maxMessages);
        Scanner user = new Scanner(System.in);
        Login login = null; //class is a datatype for the oject
                
        System.out.println("                               A P P                               ");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("                   ++++++++++++++++++++++++++++                    ");
        System.out.println("                      hey, what is your name?                       ");
        String name = user.nextLine(); //Store user's name just for a better UX
        
        while (true) {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.println(name + " please choose an option from the menu above");
            int option = user.nextInt();
        user.nextLine();

        //menu for user to select from
            switch (option) {
                case 1:
                    login = register(user); //login object = register()method
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
                            System.out.println("[ Access To Message Feature Granted ]");
//                        }
//                    } else {
//                        System.out.println("You are already logged in."); //if user logs in twice
                    //part 2:JOption
                        JOptionPane.showMessageDialog(null, "WELCOME TO QUICKCHAT");
                        int choice;
                        do{
                            maxMessages = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the number of messages you wish to send:"));
                             choice = Integer.parseInt(JOptionPane.showInputDialog("1. Send Message\n2. Store Message\n3. Quit"));
                             switch(choice){
                                 case 1:
                                    for(int m=0; m < maxMessages; m++) {
                                        
                                        //call send message method
                                        //ok so I'm struggling to do that
                                        
                                        //show message results here
//                                       to happen in message method
                                    String recipient = JOptionPane.showInputDialog("Enter recipient's phone number (+27xxxxxxxxx)");
                                    String message = JOptionPane.showInputDialog("Enter message"); 
                                     if (message.length() <= 50 && message.length() > 0) { //if message meets character requirements
                                Message msg = new Message(recipient, message, numMessagesSent + 1); //code in class
                                sentMessages.add(msg);
                                numMessagesSent++; //add message to system
                                JOptionPane.showMessageDialog(null, "Verifying your message..");
                                     //show message details here:
             //MessadeID
             String messageID ="";
        int[] numbers = generateTenRandomIntegers(0,10); //the randomize procedure
        for(int i = 0; i < 10; i++){
          messageID += numbers[i];
        }
        JOptionPane.showMessageDialog(null, messageID);
  
    // Calculate message hash
    //substring 
            String[] words = message.split("\\s+");
            String messageHash = messageID + ":" + (m+1) + ":" + words[0].toUpperCase() + ":" + words[words.length - 1].toUpperCase();  
                                     
                        // Display message details
            String messageDetails = "Message ID: " + messageID + "\nRecipient: " + recipient + "\nMessage Hash: " + messageHash + "\nMessage Number: " + (m+1);
            JOptionPane.showMessageDialog(null, messageDetails);
            //display menu
            int menu = Integer.parseInt(JOptionPane.showInputDialog("I want to:\n 1. Send A Message\n2. Store  Message(opt 1 first)\n3. Delete The Message"));
            switch (menu) {
                case 1:
                    // Send message logic here
                    JOptionPane.showMessageDialog(null, "Message sent!");
                    break;
                    //***************************************************************** PART3
                case 2:
                    //updated feature
                    JOptionPane.showMessageDialog(null, "Message stored");
                   
                    break;
                case 3:
                    // Delete message logic here
                    JOptionPane.showMessageDialog(null, "Message deleted!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid option");}
            
                                   //from part1 neh?
                                    } else {
                                JOptionPane.showMessageDialog(null, "Message must be between 1 and 50 characters.");
                                     }
                                    }JOptionPane.showMessageDialog(null, "Message limit reached.");
                                   break; 
                                   //case 1 ends here
                                    
                                   //**************************************************************************** PART3 HERE:
                                 case 2:
                                    // JOptionPane.showMessageDialog(null, "Selected feature coming soon..."); 
                                      //use number to instantiate the number of messages sent(whatever the var is)
                    
                    //input message into msgObj
                    for (int counter = 0; counter < maxMessages; counter++){ //new for p3
                        int loopcount = counter + 1;
                        String maxMessages = JOptionPane.showInputDialog("Please Enter message number:" + loopcount);
                        messageObject.sendMessage(message, loopcount);
                        messageObject.saveHashMessage("#" + counter+ "#", loopcount);
                        messageObject.saveMessageID(counter + "ID", loopcount);
                    }
                        //display the message of the messageObject
                        for(int i = 0; i < maxMessages; i++){
                            JOptionPane.showMessageDialog(null, messageObject.getMessageInfoAtIndex(i));
                        
                    }
                        //call method
                        messageObject.getLongestMessage();
                        
                        //ask user for message ID
                        String prompt = JOptionPane.showInputDialog("Enter Message ID");
                        //use 
                        JOptionPane.showMessageDialog(null, messageObject.getMessageUsingID(prompt));
                        
                        //invoke Report method
                        messageObject.DisplayReport();
                        
                        //prompt user for message hash
                        String hash = JOptionPane.showInputDialog("Enter has to disregard message");
                        //invoke disregarded message using above method
                        messageObject.DisregardedMessagesUsingHash(hash);
                                   break;
                                 case 3:
                                     JOptionPane.showMessageDialog(null, "Goodbye " + name + "Closing app...");
                                            }
                            }while(choice != 3);
                        }}
                    break;
                case 3:
                    System.out.println("Exiting..."); //say bye to user if they choose to leave(terminate program)
                    return;
                default:
                    System.out.println("Invalid option. Please try again."); //if they pick any other number other than 1,2,3
            } //menu end
        } //end of loop
    } //main ends here

    //my pseudocode in code: 
    //same as PRLD (easier to seperate the methods from main program)
    
    //register mthod
    private static Login register(Scanner details) {
        System.out.println("Register");
        System.out.println("------------------");

        System.out.print("Enter username (with underscore and under 5 chars): ");
        String username = details.nextLine();

        System.out.print("Enter password (at least 8 chars, 1 capital, 1 number, 1 special char): ");
        String password = details.nextLine();

        System.out.print("Enter South African cellphone number: (please bwgin with +27) ");
        String cellphoneNumber = details.nextLine();

        Login login = new Login(username, password, cellphoneNumber);
        String registrationMessage;
        registrationMessage = login.registerUser(username, password, cellphoneNumber);
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
     private String generateUniqueID() {  
        Random messageID = new Random();
        StringBuilder id = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            id.append(messageID.nextInt(10));
            //return uniqueMessageID;
        }
        return messageID.toString();
    } //end of ID generator
     
   public static int[] generateTenRandomIntegers(int min, int max){ //creating a NEW number ig
        Random random = new Random();
        int[] numbers = new int[10];
        
        for(int i = 0; i < 10; i++){
            numbers[i] = random.nextInt(max - min + 1) + min;
        }
        return numbers;
   }  
    
}//end of class
//well done mama