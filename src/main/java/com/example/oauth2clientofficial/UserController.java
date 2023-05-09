package com.example.oauth2clientofficial;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/user")
    public String user(Model model, @AuthenticationPrincipal OAuth2User user) {
        model.addAttribute("id", user.getAttribute("sub"));
        model.addAttribute("email", user.getAttribute("email"));
        return "user";
    }
}
