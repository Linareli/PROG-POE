/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package yezzimetsuccess;

//import org.testng.Assert; this isn't nessecary neh
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author Nkanyezi
 *
 */
public class MessageNGTest {
     
     String messageID;
     int numMessagesSent;
     String recipient;
     String message;
     String messageHash;
     
      @Test
    public void testMessageLengthSuccess() {
        Message m = new Message(1, "+27718693002", "Hi Mike, can you join us for dinner tonight");
        assertTrue(m.getMessageText().length() <= 250);
    }

    @Test
    public void testRecipientFormat() {
        Message m = new Message(1, "+27718693002", "Hi Mike");
        assertTrue(m.checkRecipientCell());
    }

    @Test
    public void testMessageHashFormat() {
        Message m = new Message(1, "+27718693002", "Hi Mike, can you join us for dinner tonight");
        String hash = m.getMessageHash();
        assertNotNull(hash);
        assertTrue(hash.matches("^\\d{2}:\\d+:[A-Z0-9]+$"));
    }
    
   }
