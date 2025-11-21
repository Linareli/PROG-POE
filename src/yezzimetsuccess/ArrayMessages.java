package yezzimetsuccess;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import javax.swing.JOptionPane;

/**
 * @author Nkanyezi
 *
 */
import java.util.*;
import java.io.*;
import java.nio.file.*;

public class ArrayMessages {
    private List<String> sentMessages = new ArrayList<>();
    private List<String> disregardedMessages = new ArrayList<>();
    private List<String> storedMessages = new ArrayList<>();
    private List<String> messageHashes = new ArrayList<>();
    private List<String> messageIDs = new ArrayList<>();
    // store full Message objects for richer operations
    private List<Message> sentMessageObjects = new ArrayList<>();

    public ArrayMessages() {}

    public void addSentMessage(Message m) {
        sentMessages.add(m.getMessageText());
        messageHashes.add(m.getMessageHash());
        messageIDs.add(m.getMessageID());
        sentMessageObjects.add(m);
    }

    public void addDisregardedMessage(Message m) {
        disregardedMessages.add(m.getMessageText());
    }

    public void addStoredMessage(Message m) {
        storedMessages.add(m.getMessageText());
        // optionally save message object details if needed
    }

    // a) Display sender and recipient of all sent messages.
    // Here sender not implemented in POE, so show sender as stored cell (if you add sender field modify accordingly)
    public List<String> getSentSenderRecipientLines() {
        List<String> result = new ArrayList<>();
        for (Message m : sentMessageObjects) {
            result.add(String.format("Recipient: %s - Message: %s", m.getRecipient(), m.getMessageText()));
        }
        return result;
    }

    // b) Display the longest sent message
    public String getLongestSentMessage() {
        String longest = "";
        for (String m : sentMessages) {
            if (m != null && m.length() > longest.length()) longest = m;
        }
        return longest;
    }

    // c) Search for a message ID and display recipient + message (returns null if not found)
    public String findByMessageID(String id) {
        for (Message m : sentMessageObjects) {
            if (m.getMessageID().equals(id)) {
                return String.format("Recipient: %s, Message: %s", m.getRecipient(), m.getMessageText());
            }
        }
        return null;
    }

    // d) Search for all messages sent to a particular recipient
    public List<String> findByRecipient(String recipient) {
        List<String> matches = new ArrayList<>();
        for (Message m : sentMessageObjects) {
            if (m.getRecipient().equals(recipient)) matches.add(m.getMessageText());
        }
        return matches;
    }

    // e) Delete a message using the message hash
    public boolean deleteByHash(String hash) {
        for (int i = 0; i < sentMessageObjects.size(); i++) {
            if (sentMessageObjects.get(i).getMessageHash().equals(hash)) {
                sentMessageObjects.remove(i);
                sentMessages.remove(i);
                messageHashes.remove(i);
                messageIDs.remove(i);
                return true;
            }
        }
        return false;
    }

    // f) Display full details report of all sent messages
    public String getReport() {
        StringBuilder sb = new StringBuilder();
        for (Message m : sentMessageObjects) {
            sb.append(String.format("Message Hash: %s\nRecipient: %s\nMessage: %s\n\n",
                    m.getMessageHash(), m.getRecipient(), m.getMessageText()));
        }
        return sb.toString();
    }

    // ChatGPT instruction: store message(s) into JSON file
    public void saveStoredMessagesToJson(String jsonFilePath) throws IOException {
        // Simple JSON array of objects using manual construction
        StringBuilder sb = new StringBuilder();
        sb.append("[\n");
        for (int i = 0; i < storedMessages.size(); i++) {
            String m = storedMessages.get(i).replace("\"", "\\\"");
            sb.append(String.format("  { \"message\": \"%s\" }", m));
            if (i < storedMessages.size() - 1) sb.append(",\n");
            else sb.append("\n");
        }
        sb.append("]\n");
        Files.write(Paths.get(jsonFilePath), sb.toString().getBytes());
    }
    
    public List<String> getStoredMessages() {
    return storedMessages;
}

    public List<String> getSentMessages() {
    return sentMessages;
}


    public void loadStoredMessagesFromJson(String jsonFilePath) throws IOException {
        storedMessages.clear();
        String content = new String(Files.readAllBytes(Paths.get(jsonFilePath)));
        // very simple parsing assuming the saved format
        String[] lines = content.split("\n");
        for (String l : lines) {
            l = l.trim();
            if (l.startsWith("{") && l.contains("\"message\":")) {
                int first = l.indexOf(":");
                String part = l.substring(first + 1).trim();
                part = part.replace("{", "").replace("}", "").trim();
                // extract between quotes
                int q1 = part.indexOf("\"");
                int q2 = part.lastIndexOf("\"");
                if (q1 >= 0 && q2 > q1) {
                    String msg = part.substring(q1 + 1, q2);
                    storedMessages.add(msg);
                }
            }
        }
    }
}

