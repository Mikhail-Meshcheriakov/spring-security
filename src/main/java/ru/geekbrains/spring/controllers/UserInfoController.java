package ru.geekbrains.spring.controllers;

import ru.geekbrains.spring.entities.User;
import ru.geekbrains.spring.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@Slf4j
@RequiredArgsConstructor
public class UserInfoController {
    private final UserService userService;

    @GetMapping("/dao")
    public String daoTestPage(Principal principal) {
        // Authentication a = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByUsername(principal.getName()).orElseThrow(() -> new RuntimeException("unable to fing user by username: " + principal.getName()));
        return "authenticated: " + user.getUsername() + " : " + user.getEmail();
    }
}
