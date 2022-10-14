package no.hvl.dat108.webshop.controller;

import no.hvl.dat108.webshop.util.InputValidator;
import no.hvl.dat108.webshop.util.LoginUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Value("${app.message.invalidUsername}") private String INVALID_USERNAME_MESSAGE;
    @Value("${app.url.login}") private String LOGIN_URL;
    @Value("${app.url.logout}") private String WEBSHOP_URL;

    @GetMapping
    public String getLoginView() { return "loginView"; }

    @PostMapping
    public String onLogin(@RequestParam String username,
          HttpServletRequest request, RedirectAttributes ra) {

        if (!InputValidator.isValidUsername(username)) {
            ra.addFlashAttribute("redirectMessage", INVALID_USERNAME_MESSAGE);
            return "redirect:" + LOGIN_URL;
        }

        LoginUtil.logInUser(request, username);
        return "redirect:" + WEBSHOP_URL;
    }
}
