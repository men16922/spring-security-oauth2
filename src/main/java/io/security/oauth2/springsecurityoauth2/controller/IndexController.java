package io.security.oauth2.springsecurityoauth2.controller;

import io.security.oauth2.springsecurityoauth2.model.social.PrincipalUser;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(Model model, @AuthenticationPrincipal PrincipalUser principalUser) {

        String view = "index";

        if (principalUser != null) {

            String userName = principalUser.providerUser().getUsername();

            model.addAttribute("user", userName);
            model.addAttribute("provider", principalUser.providerUser().getProvider());
            if(!principalUser.providerUser().isCertificated()) view = "selfcert";
        }

        return view;
    }
}