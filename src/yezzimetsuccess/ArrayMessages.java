package yezzimetsuccess;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


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
    
    //setter
    //population? no, done during tests
    public void initializeArrays(){
        for (int i = 0; i < count; i++){
       this.Sent_Messages[i] = "";
       this.Disregarded_Messages[i] = "";
       this.Stored_Messages[i] = "";
       this.Message_Hash[i] = "";
       this.Message_ID[i] = "";
        }
    }
    
    //gettes
    
    //display longest message
    public void getLongestMessage(){
        int max = this.Sent_Messages[0].length(); //error
        int position = 0;
        //array
        for(int i = 1; i < this.count; i++){
            if (this.Sent_Messages[i].length() > max){
                //for the maximum:
                max = this.Sent_Messages[i].length();
                //update index
                position = i;
            }
        }
        JOptionPane.showMessageDialog(null, "Longest Message: " + this.Sent_Messages[position]);
    }
    
    //find message using ID
    public String getMessageUsingID(String ID){
        int index = 0;
        
        for (int i = 0; i < this.count; i++){
            if(this.Message_ID[i].equals(ID)){
                index = i;
                return this.Sent_Messages[index];
            }
        }
        return "Not found";
    }
    
    public void DisplayReport(){
        String message = "";
        for (int c = 0; c < this.count; c++){
            if(!this.Sent_Messages[c].equals("")){
                message += ("Sent Messages: " +  this.Sent_Messages[c] +
                        "\n Message Hash: " + this.Message_Hash[c] +
                        "\n Message ID: " + this.Message_ID[c] + '\n'
                        );
            }
        } JOptionPane.showMessageDialog(null, message);
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
        JOptionPane.showMessageDialog(null, "Message displayed successful");
    this.DisplayReport();
    break;
    }}
    if(disregarded == false){
        JOptionPane.showMessageDialog(null, "Message not displayed");
    }
    }
    
    public void DisplayDisregardedMessage(){
        String message = "";
        for (int c = 0; c < this.count; c++){
            if(!this.Disregarded_Messages[c].equals("")){
                message += "Disregareded Message: " + this.Disregarded_Messages[c];
            }            
            JOptionPane.showMessageDialog(null, message);
        }
    }  

    public void sendMessage(String sentMessage, int message_Number){
        this.Sent_Messages[message_Number - 1] = sentMessage;
        //program does this(not shown to user)
        this.Stored_Messages[message_Number - 1] = sentMessage;
        
    }
    
    public void saveHashMessage(String message_Hash, int message_Number){
        this.Message_Hash[message_Number - 1] = message_Hash;
    }
    
    public void saveMessageID(String message_ID, int message_Number){
        this.Message_ID[message_Number - 1] = message_ID;
    }
    
    //getters here
    public String[] getSentMessages(){
        return this.Sent_Messages;
    }
    
    public String[] getStoredMessages(){
        return this.Stored_Messages;
    }
    
    public String[] getMessagesHashes(){
        return this.Message_Hash;
    }
    
    public String[] getMessagesID(){
        return this.Message_ID;
    }
    
    public String getMessageInfoAtIndex(int index){
         return "Sent Message: " + this.Sent_Messages[index] + '\n'
                + "Message Hash: " + this.Message_Hash[index] + '\n' +
                "Message ID:" + this.Message_ID[index];
    }   
}
