package ru.geekbrains.spring.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.spring.entities.User;
import ru.geekbrains.spring.services.ScoreService;
import ru.geekbrains.spring.services.UserService;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/score")
public class ScoreController {
    private final UserService userService;
    private final ScoreService scoreService;

    @GetMapping("/inc")
    public int increment(Principal principal) {
        return scoreService.change(principal, true);
    }

    @GetMapping("/dec")
    public int decrement(Principal principal) {
        return scoreService.change(principal, false);
    }

    @GetMapping("/get/current")
    public int findByCurrentUser(Principal principal) {
        User user = userService.findByUsername(principal.getName()).orElseThrow(() -> new RuntimeException("unable to fing user by username: " + principal.getName()));
        return scoreService.findByUser(user.getId());
    }

    @GetMapping("/get/{id}")
    public int findByUserId(@PathVariable Long id) {
        return scoreService.findByUser(id);
    }
}
