package ru.anyline.resttdl.DTO;

import lombok.Getter;
import lombok.Setter;
import ru.anyline.resttdl.model.Company;

import java.util.Set;

@Getter
@Setter
public class ApplicationDTO {

    private Long id;
    private String name;
    private DeveloperDTO developer;
    private Set<CompanyDTO> companies;
}
