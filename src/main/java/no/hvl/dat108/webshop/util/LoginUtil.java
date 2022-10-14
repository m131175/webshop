package no.hvl.dat108.webshop.util;

import no.hvl.dat108.webshop.model.Cart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginUtil {

    private final static int MAX_INTERACTIVE_INTERVAL = 60;

    public static void logOutUser(HttpSession session) {session.invalidate();}

    public static void logInUser(HttpServletRequest request, String username) {

        logOutUser(request.getSession());

        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(MAX_INTERACTIVE_INTERVAL);
        session.setAttribute("username", username);
        session.setAttribute("cart", new Cart());
    }

    public static boolean isUserLoggedIn(HttpSession session) {

        return session != null
                && session.getAttribute("username") != null
                && session.getAttribute("cart") != null;
    }
}
