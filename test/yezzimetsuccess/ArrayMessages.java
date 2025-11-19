/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yezzimetsuccess;

import javax.swing.JOptionPane;

/**
 *
 * @author Nkanyezi
 * speak your feelings app
 * what up
 * introspection: focus sport, have a life and be hands on w anything 
 * that you want that requires the input of other people. Dink van dit 
 * as iets vir jou eie hou.
 */
public class ArrayMessages {
    String[] Sent_Messages;
    String[] Disregarded_Messages;
    String[] Stored_Messages;
    String[] Message_Hash;
    String[] Message_ID;
    int count = 0;
    
    //constructor
    
    public ArrayMessages(int messageCount){
       this.Sent_Messages = new String[messageCount];
       this.Disregarded_Messages = new String[messageCount];
       this.Stored_Messages = new String[messageCount];
       this.Message_Hash = new String[messageCount];
       this.Message_ID = new String[messageCount];
       this.count = messageCount;
       
    }
    
    public void DisregardedMessagesUsingHash(String Hash){
    boolean disregarded = false;
    for(int i = 0; i< this.count; i++){
    if (this.Message_Hash[i].equals(Hash)){
        
        this.Disregarded_Messages[i]= this.Sent_Messages[i];
        this.Sent_Messages[i]="";
        this.Message_ID[i] = "";
        this.Message_Hash[i] = "";
        disregarded = true;
        JOptionPane.showMessageDialog(null, "Message successful");
    this.DisplayReport();
    break;
    }}
    if(disregarded == false){
        JOptionPane.showMessageDialog(null, "Message not displayed");
    }
    }
    
    public void DisplayDisregardedMessage(){
        String message = "";
        for (int c=0; c< this.count; c++){
            if(!this.Disregarded_Messages[c].equals("")){
                message += "Disregareded Message: " + this.Disregarded_Messages[c];
            }
            
            JOptionPane.showMessageDialog(null, message);
        }
    }
    
}
