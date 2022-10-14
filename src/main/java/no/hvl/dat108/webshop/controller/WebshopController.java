package no.hvl.dat108.webshop.controller;

import no.hvl.dat108.webshop.model.Cart;
import no.hvl.dat108.webshop.model.CartItem;
import no.hvl.dat108.webshop.util.LoginUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/webshop")
public class WebshopController {

    @Value("${app.message.requiresLogin}") private String REQUIRES_LOGIN_MESSAGE;
    @Value("${app.url.login}") private String LOGIN_URL;
    @Value("${app.url.webshop}") private String WEBSHOP_URL;

    @GetMapping
    public String showWebshop(HttpSession session, RedirectAttributes ra) {

        if (!LoginUtil.isUserLoggedIn(session)) {
            ra.addFlashAttribute("redirectMessage", REQUIRES_LOGIN_MESSAGE);
            return "redirect:" + LOGIN_URL;
        }
        return "webshopView";
    }

    @PostMapping
    public String addItemsToCart(
            @RequestParam(name = "item", required = false) List<String> items,
             HttpSession session, RedirectAttributes ra) {

        if (!LoginUtil.isUserLoggedIn(session)) {
            ra.addFlashAttribute("redirectMessage", REQUIRES_LOGIN_MESSAGE);
            return "redirect:" + LOGIN_URL;
        }

        Cart cart = (Cart) session.getAttribute("cart");
        if (items != null && items.contains("pants")) {
            cart.addItems(new CartItem("Pants", 699));
        }
        if (items != null && items.contains("Sweater")) {
            cart.addItems(new CartItem("Sweater", 499));
        }

        return "redirect:" + WEBSHOP_URL;
    }
}
