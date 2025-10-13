/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yezzimetsuccess;

import java.util.Random;

/**
 *
 * @author Bongi
 */
public class Message {
    
    private String uniqueMessageID;
    private int numMessagesSent;
    private String recipient;
    private String message;
    private String messageHash;

    //constructor
    public Message(String recipient, String message, int numMessagesSent) {
        this.uniqueMessageID = uniqueMessageID;//generateUniqueID();
        this.numMessagesSent = numMessagesSent;
        this.recipient = recipient;
        this.message = message;
        this.messageHash = messageHash;//generateMessageHash(message);
    }
    
     public int checkrecipientCell(String recipient) {
         //reference from part1
        String regex = "^\\+27\\d{9}$";
        return recipient.startsWith("+27") && recipient.length() == 12 && recipient.matches(regex);
    }

    public boolean checkMessageID(String uniqueMessageID){
        
    }
    
    public String createMessageHash(String messageHash){
        
    }
    
    public String sentMessage(){
        
    }
    public String printMssage(){
        
    } 
    public int returnTotalMessages(){
        
    }
    public int storeMessage(){
        
    }
    


   
}

