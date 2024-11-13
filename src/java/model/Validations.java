package model;

/**
 *
 * @author rc007
 */
public class Validations {

    public static boolean isEmailValid(String mobile) {
        return mobile.matches("^(.+)@(\\S+)$");
    }
}
