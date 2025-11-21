/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yezzimetsuccess;
    
import java.util.Random;

public class Message {
    private String messageID;      // 10-digit string
    private int messageNumber;     // auto increment assigned externally (or by app)
    private String recipient;      // +27XXXXXXXXX format
    private String messageText;
    private String messageHash;    // format: firstTwoOfID:messageNumber:FIRSTLASTWORDS

    public Message() {}

    // Constructor used by app
    public Message(int msgNumber, String recipient, String messageText) {
        this.messageNumber = msgNumber;
        this.recipient = recipient;
        this.messageText = messageText;
        this.messageID = generateMessageID();
        this.messageHash = createMessageHash();
    }

    // Boolean: checkMessageID() -> no more than 10 characters
    public boolean checkMessageID() {
        return messageID != null && messageID.length() <= 10;
    }

    // Int: checkRecipientCell() -> ensures the recipient cell is no more than 12 characters with + and country code (+27#########)
    public boolean checkRecipientCell() {
        if (recipient == null) return false;
        return recipient.matches("^\\+27\\d{9}$");
    }

    // String: createMessageHash()
    // Message Hash: first two digits of messageID + ":" + messageNumber + ":" + FIRSTWORDLASTWORD (no spaces) all caps
    public String createMessageHash() {
        String idPart = (messageID != null && messageID.length() >= 2) ? messageID.substring(0,2) : "00";
        String words = "";
        if (messageText != null && messageText.trim().length() > 0) {
            String[] parts = messageText.trim().split("\\s+");
            String first = parts[0];
            String last = parts[parts.length - 1].replaceAll("[^a-zA-Z0-9]", "");
            words = (first + last).toUpperCase();
        }
        return String.format("%s:%d:%s", idPart, messageNumber, words);
    }

    // String: SentMessage() - returns a message to show the action selected (Send/Disregard/Store)
    public String SentMessage(String action) {
        switch(action.toLowerCase()) {
            case "send":
                return "Message successfully sent.";
            case "disregard":
                return "Press 0 to delete message.";
            case "store":
                return "Message successfully stored.";
            default:
                return "No action taken.";
        }
    }

    // String: printMessages() - returns details as requested: MessageID, Message Hash, Recipient, Message
    public String printMessages() {
        return String.format("MessageID: %s\nMessage Hash: %s\nRecipient: %s\nMessage: %s",
                messageID, messageHash, recipient, messageText);
    }

    // getters & setters
    public String getMessageID() { return messageID; }
    public int getMessageNumber() { return messageNumber; }
    public String getRecipient() { return recipient; }
    public String getMessageText() { return messageText; }
    public String getMessageHash() { return messageHash; }

    // Helper: generate random 10-digit message ID
    private String generateMessageID() {
        Random rnd = new Random();
        long number = (long)(rnd.nextDouble() * 1_000_000_0000L);
        String s = String.format("%010d", number);
        return s;
    }
}


