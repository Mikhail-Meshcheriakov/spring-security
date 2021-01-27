package ru.geekbrains.spring.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "score")
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "value")
    private int value;
}
