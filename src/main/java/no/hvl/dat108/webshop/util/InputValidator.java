package no.hvl.dat108.webshop.util;

public class InputValidator {

    public static final String ANY_LETTER = "[a-zA-ZæøåÆØÅ]";
    public static final String ANY_LETTER_OR_DIGIT = "[a-zA-ZæøåÆØÅ0-9]";
    public static final String THREE_OR_MORE_TIMES = "{3,}";

    public static boolean isValidUsername(String username) {
        return username != null && username.matches("^" + ANY_LETTER
                + ANY_LETTER_OR_DIGIT + THREE_OR_MORE_TIMES);
        //return username != null && username.length() > 3;
    }
}
