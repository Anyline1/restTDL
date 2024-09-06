package ru.anyline.resttdl.service;

import ru.anyline.resttdl.DTO.ApplicationDTO;

import java.util.List;
import java.util.Optional;

public interface ApplicationService {
    public List<ApplicationDTO> findAll();
    public Optional<ApplicationDTO> findById(Long id);
    public ApplicationDTO save(ApplicationDTO application);
    public void deleteById(Long id);

}
