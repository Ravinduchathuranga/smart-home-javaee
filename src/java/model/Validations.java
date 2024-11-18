package model;

/**
 *
 * @author rc007
 */
public class Validations {

    public static boolean isEmailValid(String mobile) {
        return mobile.matches("^(.+)@(\\S+)$");
    }
    public static boolean isPasswordValid(String password) {
        return password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=]).{8,}$");
    }
}
