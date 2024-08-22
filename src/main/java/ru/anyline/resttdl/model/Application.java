package ru.anyline.resttdl.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "developer_id")
    private Developer developer;
    @ManyToMany
    @JoinTable(
            name = "application_companies",
            joinColumns = @JoinColumn(name = "application_id"),
            inverseJoinColumns = @JoinColumn(name = "companies_id")
    )
    private Set<Company> companies;




}
