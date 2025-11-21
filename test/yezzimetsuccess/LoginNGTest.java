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
    
//    removed username, password, cellphoneNumber
    Login login = new Login();
    
    /**
     * Test of checkUsername method, of class Login.
     */
    
    @Test
    public void testCheckUserNameValid() {
        assertTrue(login.checkUserName());
        System.out.println("Welcome"+username+"it is great to see you");
    }

    @Test
    public void testCheckUserNameInvalid() {
        login.setUserDetails("kyle!!!!!!!", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");
        assertFalse(login.checkUserName());
         System.out.println("username is incorrectly formatted, please inclue an underscore"
               + "and ensure it is not longer than 5 characters long");
    }
    
     // Test of checkPasswordComplexity method, of class Login.
     //True
     
    @Test
    public void testCheckPasswordComplexity() {
        //"Ch&&sec@ke99!"
        Assert.assertTrue(login.checkPasswordComplexity());
        System.out.println("Password successfully captured");
    }
    
    //False return (Login failed)
    @Test
    public void testCheckPasswordComplexitywrong(){
        Assert.assertFalse(login.checkPasswordComplexity());
    System.out.println("password is incorrectly formatted, please ensure that it is 8"
               + " characters long, has a capital letter, a number and a special char");
    }
    /**
     * Test of checkCellPhoneNumber method, of class Login.
     * Return true
     */
    @Test
    public void testCheckCellPhoneNumber() {
        //"+27838968976"
        Assert.assertTrue(login.checkCellPhoneNumber());
        System.out.println("Cell number successfully captured");
    }
    
    //False return (Login failed)
    @Test
    public void testCheckCellPhoneNumberwrong() {
        //test "0938968976"
        login.setUserDetails("kyl_1", "Ch&&sec@ke99!", "08966553", "Kyle", "Smith");
        Assert.assertFalse(login.checkCellPhoneNumber());
        System.out.println("Cell number is incorrectly formatted or does not contain"
                + " the internTational code, please correct the number na dtry again");
    }


    @Test
    public void testPasswordComplexityInvalid() {
        login.setUserDetails("kyl_1", "password", "+27838968976", "Kyle", "Smith");
        assertFalse(login.checkPasswordComplexity());
    }

    
    @Test
    public void testLoginSuccess() {
        assertTrue(login.loginUser("kyl_1", "Ch&&sec@ke99!"));
    }

    @Test
    public void testLoginFail() {
        assertFalse(login.loginUser("wrong", "wrong"));
    }
}

