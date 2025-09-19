package com.mycompany.prog5121poepart1;


public class PROG5121POEPART1 {

    private String storedUsername;
    private String storedPassword;
    private final String firstName;
    private final String lastName;

   
    public PROG5121POEPART1(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public boolean checkUserName(String username) {
        return username != null && username.contains("_") && username.length() <= 5;
    }

    public boolean checkPasswordComplexity(String password) {
        if (password == null || password.length() < 8) return false;
        boolean hasUpper = false, hasDigit = false, hasSpecial = false;
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasUpper = true;
            else if (Character.isDigit(c)) hasDigit = true;
            else if (!Character.isLetterOrDigit(c)) hasSpecial = true;
        }
        return hasUpper && hasDigit && hasSpecial;
    }

    public boolean checkCellPhoneNumber(String cellNumber) {
        if (cellNumber == null) return false;
        String regex = "^\\+27\\d{9}$"; 
        return cellNumber.matches(regex);
    }

    public String registerUser(String username, String password, String cellNumber) {
        if (!checkUserName(username))
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.";
        if (!checkPasswordComplexity(password))
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        if (!checkCellPhoneNumber(cellNumber))
            return "Cell phone number incorrectly formatted or does not contain international code.";
        this.storedUsername = username;
        this.storedPassword = password;
        return "User successfully registered.";
    }

    public boolean loginUser(String username, String password) {
        return storedUsername != null && storedUsername.equals(username)
            && storedPassword != null && storedPassword.equals(password);
    }

    public String returnLoginStatus(String username, String password) {
        if (loginUser(username, password)) {
            return "Welcome " + firstName + " ," + lastName + " it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}
