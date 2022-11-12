package pl.coderslab.expenses.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.expenses.service.UserService;

@RequiredArgsConstructor
@Controller
@RequestMapping("/admin")
public class AdminController { //strefa chroniona skonfigurowana w SecurityConfig
    private final UserService service;
    @RequestMapping("")
    @PreAuthorize("hasRole('ADMIN')")
    public String index(@AuthenticationPrincipal UserDetails user, Model model){
        model.addAttribute("user",service.findByUsername(user.getUsername()));
        return "admin/index";
    }
}
