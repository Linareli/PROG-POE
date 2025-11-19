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
    
    public MessageNGTest() {
    }
     Message msg = new Message(recipient, message,  numMessagesSent);

    /**
     * Test of checkrecipientCell method, of class Message.
     */
    
    
    @Test
    public void testCheckrecipientCell() {
     //success
    System.out.print("checkRecipientCell");
    String cell = "";
    int expResult =0 ;
    int result = msg.checkrecipientCell(cell);
    assertEquals(result, expResult);
    //if fail
    fail("the test case is a prototype");
    
    }

    /**
     * Test of checkMessageID method, of class Message.
     */
    @Test
    public void testCheckMessageID() {
          System.out.println("checkMessageID");
    String id = "";
    boolean expResult = false;
    boolean result = msg.checkMessageID(id);
    assertEquals(result, expResult);
   fail("The test case is a prototype."); 
        
    }

    /**
     * Test of createMessageHash method, of class Message.
     */
    @Test
    public void testCreateMessageHash() {
    System.out.println("createMessageHash");
    String messageID = "";
    String numMessagesSent = "";
    String message = "";
    String expResult = "";
    String result = msg.createMessageHash(messageID, numMessagesSent, message);
    assertEquals(result, expResult);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }

    /**
     * Test of sentMessage method, of class Message.
     */
    @Test
    public void testSentMessage() {
       System.out.print("SentMessage");
    String expResult = ""; 
    String result = msg.sendMessages(/* parameters not visible */);
    assertEquals(result, expResult);
    fail("The test case is a prototype.");
      
    }

    /**
     * Test of printMessage method, of class Message.
     */
    @Test
    public void testPrintMessage() {
    }

    /**
     * Test of returnTotalMessages method, of class Message.
     */
    @Test
    public void testReturnTotalMessages() {
        
    }

    /**
     * Test of storeMessage method, of class Message.
     */
    @Test
    public void testStoreMessage() {
        System.out.println("storeMessage");
        msg.storeMessage(message);
        fail("the test case is a prototype");
       
    }
    
    
}
