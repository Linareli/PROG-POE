/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yezzimetsuccess;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Nkanyezi
 */
public class Message {
    
    private String messageID;
    private int numMessagesSent;
    private String recipient;
    private String message;
    private String messageHash;

    //constructor
    public Message(String recipient, String message, int numMessagesSent) {
        this.messageID = messageID;//generateUniqueID();
        this.numMessagesSent = numMessagesSent;
        this.recipient = recipient;
        this.message = message;
        this.messageHash = messageHash;//generateMessageHash(message);
    }
    
     public int checkrecipientCell(String recipient) {
         //reference from part1
        if(recipient.matches("^\\+27\\d{9}$")){
             //return true of false:
        return 1; //T
        }else{
        return 0; //F
    }}

    public boolean checkMessageID(String uniqueMessageID){
        return uniqueMessageID.matches("\\d[1,10]");
    }
    
    public String createMessageHash(String messageHash){
//      lastword.toUpperCase();  
        //substring ntoz
            String[] words = message.split("\\s+");
        int m = 0;
            messageHash = messageID + ":" + (m+1) + ":" + words[0].toUpperCase() + ":" + words[words.length - 1].toUpperCase();  
            return messageHash;
    }
    
    public String sentMessage(int numMessagesSent){
     return "Message sent";   
    }
    public String printMessage(String messageDetails){
       return messageDetails; 
    } 
    public int returnTotalMessages(int numMessagesSent ){
        int maxMessages = 0;
        
        for(int m=0; m < maxMessages; m++) {
        System.out.println("Total messages: " + m);
        }return numMessagesSent;   
}

    public void storeMessage(String msg){
    JSONObject jsonObject = new JSONObject();
    jsonObject.put("message", printMessage(message));

    // Save to file
    try (FileWriter file = new FileWriter("message.json")) {
        file.write(jsonObject.toString(4)); // pretty print with indent of 4
        JOptionPane.showMessageDialog(null, "Message saved to message.json");
    } catch (IOException e) {
        e.printStackTrace();
    }
}   
}

