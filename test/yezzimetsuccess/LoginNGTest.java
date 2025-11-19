/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package yezzimetsuccess;

import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 **ST10478075
 * @author Nkanyezi
 */
public class LoginNGTest {
    String username;
    String password;
    String cellphoneNumber;
    
    public LoginNGTest() {
    }
    Login login = new Login(username, password, cellphoneNumber);
    
    /**
     * Test of checkUsername method, of class Login.
     */
    @Test
    public void testCheckUsername() {
        Assert.assertTrue(login.checkUsername("Kyl_1"));
        System.out.println("Welcome"+username+"it is great to see you");
    }
    
    //return false (Login failed)
   @Test 
   public void testCheckUsernamewrong(String usernamewrong) {
       Assert.assertFalse(login.checkUsername("kyle!!!!!!!!!!"));
       System.out.println("username is incorrectly formatted, please inclue an underscore"
               + "and ensure it is not longer than 5 characters long");
    }

    /**
     * Test of checkPasswordComplexity method, of class Login.
     * True
     */
    @Test
    public void testCheckPasswordComplexity() {
        Assert.assertTrue(login.checkPasswordComplexity("Ch&&sec@ke99!"));
        System.out.println("Password successfully captured");
    }
    
    //False return (Login failed)
    @Test
    public void testCheckPasswordComplexitywrong(){
        Assert.assertFalse(login.checkPasswordComplexity("password"));
    System.out.println("password is incorrectly formatted, please ensure that it is 8"
               + " characters long, has a capital letter, a number and a special char");
    }
    /**
     * Test of checkCellPhoneNumber method, of class Login.
     * Return true
     */
    @Test
    public void testCheckCellPhoneNumber() {
        Assert.assertTrue(login.checkCellPhoneNumber("+27838968976"));
        System.out.println("Cell number successfully captured");
    }
    
    //False return (Login failed)
    @Test
    public void testCheckCellPhoneNumberwrong() {
        Assert.assertFalse(login.checkCellPhoneNumber("0938968976"));
        System.out.println("Cell number is incorrectly formatted or does not contain"
                + " the internTational code, please correct the number na dtry again");
    }
    
    
    
    
}
