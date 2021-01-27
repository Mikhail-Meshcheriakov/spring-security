package ru.geekbrains.spring.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.spring.entities.Score;
import ru.geekbrains.spring.entities.User;
import ru.geekbrains.spring.repositories.ScoreRepository;

import java.security.Principal;

@Service
@RequiredArgsConstructor
public class ScoreService {
    private final ScoreRepository scoreRepository;
    private final UserService userService;

    public int change(Principal principal, boolean increment) {
        User user = userService.findByUsername(principal.getName()).orElseThrow(() -> new RuntimeException("unable to fing user by username: " + principal.getName()));
        Score score = user.getScore();
        if (increment) {
            score.setValue(score.getValue() + 1);
        } else {
            score.setValue(score.getValue() - 1);
        }
        scoreRepository.save(score);
        return score.getValue();
    }

    public int findByUser(Long id) {
        User user = userService.findById(id).orElseThrow(() -> new RuntimeException("unable to fing user by id: " + id));
        return user.getScore().getValue();
    }
}
