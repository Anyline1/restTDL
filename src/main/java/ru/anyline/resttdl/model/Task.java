package ru.anyline.resttdl.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false)
    private String title;
    private String description;

    @Column(nullable = false)
    private Boolean isCompleted = false;
}
