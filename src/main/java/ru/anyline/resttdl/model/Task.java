package ru.anyline.resttdl.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;


@Entity
@Data
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false)
//    @NotBlank(message = "Title is mandatory")
    private String title;

    private String description;

    @Column(nullable = false)
    private Boolean completed = false;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
