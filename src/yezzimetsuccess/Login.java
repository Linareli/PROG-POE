/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yezzimetsuccess;

/**
 **ST10478075
 * @author Nkanyezi
 */
public class Login {
      
   //declarations
    private String username;
    private String password;
    private String firstName = "";
    private String lastName = "";
    private String cellPhone;

    public Login() {}
    
    // this is here as my constructor
    public void setUserDetails(String username, String password, String cellPhone, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.cellPhone = cellPhone;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Boolean: checkUserName()
    public boolean checkUserName() {
        if (username == null) return false;
        return username.contains("_") && username.length() <= 5;
    }

    // Boolean: checkPasswordComplexity()
    public boolean checkPasswordComplexity() {
        if (password == null) return false;
        return password.length() >= 8
                && password.matches(".*[A-Z].*")
                && password.matches(".*\\d.*")
                && password.matches(".*[^a-zA-Z0-9].*");
    }

    // Boolean: checkCellPhoneNumber()
    // The POE wants an international format: +27XXXXXXXXX (total length 12 -> '+' + '27' + 9 digits)
    public boolean checkCellPhoneNumber() {
        if (cellPhone == null) return false;
        String regex = "^\\+27\\d{9}$";
        return cellPhone.matches(regex);
    }

    // String registerUser()
    public String registerUser() {
        boolean u = checkUserName();
        boolean p = checkPasswordComplexity();
        boolean c = checkCellPhoneNumber();

        if (!u)
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.";
        if (!p)
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        if (!c)
            return "Cell phone number incorrectly formatted or does not contain international code.";
        // Passed all checks
        return "User successfully registered.";
    }

    // Boolean loginUser(String attemptedUsername, String attemptedPassword)
    public boolean loginUser(String attemptedUsername, String attemptedPassword) {
        if (attemptedUsername == null || attemptedPassword == null) return false;
        return attemptedUsername.equals(this.username) && attemptedPassword.equals(this.password);
    }

    // String returnLoginStatus(boolean successful)
    public String returnLoginStatus(boolean successful) {
        if (successful)
            return String.format("Welcome %s ,%s it is great to see you again.", this.firstName, this.lastName);
        else
            return "Username or password incorrect, please try again.";
    
// getters (for tests)
//    public String getUsername() { return username; }
//    public String getCellPhone() { return cellPhone; }
//    public String getFirstName() { return firstName; }
//    public String getLastName() { return lastName; }

    }//Methods end
} //end of class

