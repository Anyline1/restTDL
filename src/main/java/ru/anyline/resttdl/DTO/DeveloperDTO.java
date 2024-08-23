package ru.anyline.resttdl.DTO;

import lombok.Getter;
import lombok.Setter;
import ru.anyline.resttdl.model.Application;

import java.util.Set;

@Setter
@Getter
public class DeveloperDTO {

    private Long id;
    private String name;
    private Set<Application> application;
}
