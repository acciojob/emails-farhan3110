package com.driver;

public class Email {

    private String emailId;
    private String password;

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword){
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character
        if (oldPassword.equals(this.password)) {
            if (newPassword.length() >= 8) {
                boolean hasUpperCase = false;
                boolean hasLowerCase = false;
                boolean hasDigit = false;
                boolean hasSpecial = false;

                for (int i = 0; i < newPassword.length(); i++) {
                    char c = newPassword.charAt(i);

                    if (Character.isUpperCase(c)) {
                        hasUpperCase = true;
                    } else if (Character.isLowerCase(c)) {
                        hasLowerCase = true;
                    } else if (Character.isDigit(c)) {
                        hasDigit = true;
                    } else if (!Character.isLetterOrDigit(c)) {
                        hasSpecial = true;
                    }
                }

                if (hasUpperCase && hasLowerCase && hasDigit && hasSpecial) {
                    this.password = newPassword;
                    System.out.println("Password changed successfully.");
                } else {
                    System.out.println("New password must contain at least one uppercase letter, one lowercase letter, one digit, and one special character.");
                }
            } else {
                System.out.println("New password must be at least 8 characters long.");
            }
        } else {
            System.out.println("Invalid old password.");
        }
    }
}
