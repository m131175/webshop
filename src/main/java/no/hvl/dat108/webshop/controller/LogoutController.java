package no.hvl.dat108.webshop.controller;

import no.hvl.dat108.webshop.util.LoginUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/logout")
public class LogoutController {

    @Value("${app.message.loggedOut}") private String LOGGED_OUT_MESSAGE;
    @Value("${app.url.login}") private String LOGIN_URL;

    @PostMapping
    public String logOut(HttpSession session, RedirectAttributes ra) {

        if (LoginUtil.isUserLoggedIn(session)) {
            LoginUtil.logOutUser(session);
        }

        ra.addFlashAttribute("redirectMessage", LOGGED_OUT_MESSAGE);
        return "redirect:" + LOGIN_URL;
    }
}
