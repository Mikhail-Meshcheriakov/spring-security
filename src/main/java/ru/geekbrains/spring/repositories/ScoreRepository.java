package ru.geekbrains.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.spring.entities.Score;

@Repository
public interface ScoreRepository extends CrudRepository<Score, Long> {
}
