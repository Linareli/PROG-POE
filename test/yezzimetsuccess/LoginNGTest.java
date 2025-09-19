/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package yezzimetsuccess;

import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
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
    
   public void testCheckUsernamewrong(String usernamewrong) {
       Assert.assertTrue(login.checkUsername("kyle!!!!!!!!!!"));
       System.out.println("username is incorrectly formatted, please inclue an underscore"
               + "and ensure it is not longer than 5 characters long");
    }

    /**
     * Test of checkPasswordComplexity method, of class Login.
     */
    @Test
    public void testCheckPasswordComplexity() {
        Assert.assertTrue(login.checkPasswordComplexity("Ch&&sec@ke99!"));
        System.out.println("Password successfully captured");
    }
    
    @Test
    public void testCheckPasswordComplexitywrong(){
        Assert.assertTrue(login.checkPasswordComplexity("password"));
    System.out.println("password is incorrectly formatted, please ensure that it is 8"
               + " characters long, has a capital letter, a number and a special char");
    }
    /**
     * Test of checkCellPhoneNumber method, of class Login.
     */
    @Test
    public void testCheckCellPhoneNumber() {
    }

    /**
     * Test of registerUser method, of class Login.
     */
    @Test
    public void testRegisterUser() {
    }

    /**
     * Test of loginUser method, of class Login.
     */
    @Test
    public void testLoginUser() {
    }

    /**
     * Test of returnLoginStatus method, of class Login.
     */
    @Test
    public void testReturnLoginStatus() {
    }
    
}
