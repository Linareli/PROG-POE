/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package yezzimetsuccess;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
    private static final String JSON_PATH = "stored_messages.json"; // relative to project root

    public static void main(String[] args) {
              
        System.out.println("                               A P P                               ");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("                   ++++++++++++++++++++++++++++                    ");
        System.out.println("               ^_^ NEW AND IMPROVED USER INTERFACE ^_^            ");
       
       Login log = new Login();
        ArrayMessages arrays = new ArrayMessages();

        boolean isRegistered = false;
        boolean isLoggedIn = false;

        while (true) {
            String choice = JOptionPane.showInputDialog(
                "Welcome!\nPlease choose an option:\n1) Register\n2) Login\n3) Exit"
            );

            if (choice == null) { // User pressed Cancel
                JOptionPane.showMessageDialog(null, "Goodbye.");
                return;
            }

            switch (choice) {
                case "1": // Register
                    while (!isRegistered) {
                        String username = JOptionPane.showInputDialog("Register - Enter username (must contain '_' and be <= 5 chars):");
                        if (username == null) return;
                        String password = JOptionPane.showInputDialog("Register - Enter password (min8, 1 uppercase, 1 number, 1 special):");
                        if (password == null) return;
                        String cell = JOptionPane.showInputDialog("Register - Enter cell phone (+27XXXXXXXXX):");
                        if (cell == null) return;
                        String first = JOptionPane.showInputDialog("Enter first name:");
                        if (first == null) return;
                        String last = JOptionPane.showInputDialog("Enter last name:");
                        if (last == null) return;

                        log.setUserDetails(username, password, cell, first, last);
                        String regMsg = log.registerUser();
                        JOptionPane.showMessageDialog(null, regMsg);
                        if (regMsg.equals("User successfully registered.")) {
                            isRegistered = true;
                        } else {
                            int retry = JOptionPane.showConfirmDialog(null, "Registration failed. Retry?", "Retry", JOptionPane.YES_NO_OPTION);
                            if (retry != JOptionPane.YES_OPTION) {
                                JOptionPane.showMessageDialog(null, "Goodbye.");
                                return;
                            }
                        }
                    }
                    break;

                case "2": // Login
                    if (!isRegistered) {
                        JOptionPane.showMessageDialog(null, "You must register before logging in.");
                        break;
                    }
                    while (!isLoggedIn) {
                        String attemptUser = JOptionPane.showInputDialog("Login - enter username:");
                        if (attemptUser == null) return;
                        String attemptPass = JOptionPane.showInputDialog("Login - enter password:");
                        if (attemptPass == null) return;

                        isLoggedIn = log.loginUser(attemptUser, attemptPass);
                        JOptionPane.showMessageDialog(null, log.returnLoginStatus(isLoggedIn));
                        if (!isLoggedIn) {
                            int retry = JOptionPane.showConfirmDialog(null, "Login failed. Retry?", "Retry", JOptionPane.YES_NO_OPTION);
                            if (retry != JOptionPane.YES_OPTION) {
                                JOptionPane.showMessageDialog(null, "Goodbye.");
                                return;
                            }
                        }
                    }
                    break;

                case "3": // Exit
                    JOptionPane.showMessageDialog(null, "Goodbye.");
                    return;

                default:
                    JOptionPane.showMessageDialog(null, "Invalid option. Please choose 1, 2, or 3.");
            }

            if (isRegistered && isLoggedIn) {
                break; // exit the pre-login menu loop to enter QuickChat
            }
        }

        // Now the user is registered AND logged in, start QuickChat app
        JOptionPane.showMessageDialog(null, "Welcome to QuickChat, " + log.getFirstName() + "!");

        // ... Paste here the entire message sending, storing, and part 3 menu code from previous MessageApp version

        int maxMessages;
        while (true) {
            String nm = JOptionPane.showInputDialog("How many messages do you want to enter?");
            if (nm == null) return;
            try {
                maxMessages = Integer.parseInt(nm);
                if (maxMessages <= 0) {
                    JOptionPane.showMessageDialog(null, "Enter a positive integer.");
                    continue;
                }
                break;
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid number. Please enter an integer.");
            }
        }

        int enteredMessages = 0; // counts entries that result in send/disregard/store
        int loopMessageNumber = 1; // used for Message.messageNumber

        while (enteredMessages < maxMessages) {
            // main numeric menu for each message entry
            String menu = JOptionPane.showInputDialog(
                    "Choose an option:\n1) Send Message\n2) Show recently sent messages (Coming Soon)\n3) Quit application"
            );
            if (menu == null) { // user cancelled -> confirm exit
                int confirm = JOptionPane.showConfirmDialog(null, "Do you want to quit the application?", "Quit", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) break;
                else continue;
            }

            if (menu.equals("3")) {
                int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to quit?", "Quit", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) break;
                else continue;
            }

            if (menu.equals("2")) {
                JOptionPane.showMessageDialog(null, "Coming Soon.");
                continue; // does not count as an entered message
            }

            if (menu.equals("1")) {
                // collect recipient and message
                String recipient = JOptionPane.showInputDialog("Enter recipient cell (+27XXXXXXXXX):");
                if (recipient == null) continue; // allow retry, does not count
                String messageText = JOptionPane.showInputDialog("Enter message (max 250 chars):");
                if (messageText == null) continue;
                if (messageText.length() > 250) {
                    JOptionPane.showMessageDialog(null, "Please enter a message of less than 250 characters.");
                    continue; // does not count
                }

                Message m = new Message(loopMessageNumber, recipient, messageText);

                // numeric menu for action: Send / Discard / Store
                String action = JOptionPane.showInputDialog(
                        "Choose action:\n1) Send Message\n2) Discard Message\n3) Store Message"
                );
                if (action == null) continue; // user cancelled action, does not count

                switch (action) {
                    case "1": // send
                        arrays.addSentMessage(m);
                        enteredMessages++;
                        loopMessageNumber++;
                        JOptionPane.showMessageDialog(null, m.printMessages() + "\n\n" + m.SentMessage("send"));
                        break;
                    case "2": // discard
                        arrays.addDisregardedMessage(m);
                        enteredMessages++;
                        loopMessageNumber++;
                        JOptionPane.showMessageDialog(null, m.SentMessage("disregard"));
                        break;
                    case "3": // store -> auto-save to JSON immediately
                        arrays.addStoredMessage(m);
                        enteredMessages++;
                        loopMessageNumber++;
                        JOptionPane.showMessageDialog(null, m.SentMessage("store"));
                        // auto-save option (Option 1)
                        try {
                            arrays.saveStoredMessagesToJson(JSON_PATH);
                            JOptionPane.showMessageDialog(null, "Stored messages saved to JSON (" + JSON_PATH + ").");
                        } catch (IOException ioe) {
                            JOptionPane.showMessageDialog(null, "Error saving stored messages to JSON: " + ioe.getMessage());
                        }
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Invalid action selected. Please choose 1, 2 or 3.");
                        // do not increment enteredMessages so user can retry
                        break;
                }

                // if max reached after this action, notify and exit message-entry loop
                if (enteredMessages >= maxMessages) {
                    JOptionPane.showMessageDialog(null, "Message limit reached");
                    break;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Invalid menu choice. Please choose 1, 2 or 3.");
            }
        } // end message-entry loop

        JOptionPane.showMessageDialog(null, "Total messages sent: " + arrays.getSentMessages().size());

        // Part 3 menu: arrays operations + load JSON option (Option 3)
        String part3 = JOptionPane.showInputDialog(
                "Part 3 options:\n1) Show sent recipient/message list\n2) Show longest sent message\n3) Load Stored Messages from JSON\n4) Search message by ID\n5) Search messages by recipient\n6) Delete message by hash\n7) Display report\n8) Exit"
        );

        while (part3 != null && !part3.equals("8")) {
            switch (part3) {
                case "1":
                    List<String> lines = arrays.getSentSenderRecipientLines();
                    JOptionPane.showMessageDialog(null, lines.isEmpty() ? "No sent messages." : String.join("\n", lines));
                    break;
                case "2":
                    String longest = arrays.getLongestSentMessage();
                    JOptionPane.showMessageDialog(null, longest.isEmpty() ? "No sent messages." : longest);
                    break;
                case "3":
                    try {
                        arrays.loadStoredMessagesFromJson(JSON_PATH);
                        JOptionPane.showMessageDialog(null, "Loaded stored messages from JSON. Count: " + arrays.getStoredMessages().size());
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "Error loading JSON: " + ex.getMessage());
                    }
                    break;
                case "4":
                    String id = JOptionPane.showInputDialog("Enter message ID:");
                    if (id != null) {
                        String found = arrays.findByMessageID(id);
                        JOptionPane.showMessageDialog(null, found == null ? "Not found" : found);
                    }
                    break;
                case "5":
                    String r = JOptionPane.showInputDialog("Enter recipient phone (+27...):");
                    if (r != null) {
                        List<String> msgs = arrays.findByRecipient(r);
                        JOptionPane.showMessageDialog(null, msgs.isEmpty() ? "No messages" : String.join("\n", msgs));
                    }
                    break;
                case "6":
                    String hash = JOptionPane.showInputDialog("Enter message hash to delete:");
                    if (hash != null) {
                        boolean ok = arrays.deleteByHash(hash);
                        JOptionPane.showMessageDialog(null, ok ? "Message successfully deleted." : "Message not found.");
                    }
                    break;
                case "7":
                    String report = arrays.getReport();
                    JOptionPane.showMessageDialog(null, report.isEmpty() ? "No sent messages." : report);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid option. Please choose 1-8.");
            }

            part3 = JOptionPane.showInputDialog(
                    "Part 3 options:\n1) Show sent recipient/message list\n2) Show longest sent message\n3) Load Stored Messages from JSON\n4) Search message by ID\n5) Search messages by recipient\n6) Delete message by hash\n7) Display report\n8) Exit"
            );
        }

        JOptionPane.showMessageDialog(null, "Byeee " + log.getFirstName() + " Thank you for using QuickChat.");

    }//end of method  
}//end of class
//well done mama