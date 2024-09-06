package ru.anyline.resttdl.service;

import ru.anyline.resttdl.DTO.ApplicationDTO;
import ru.anyline.resttdl.DTO.DeveloperDTO;

import java.util.List;
import java.util.Optional;

public interface DeveloperService {

    public List<DeveloperDTO> findAll();
    public Optional<DeveloperDTO> findById(Long id);
    public DeveloperDTO save(DeveloperDTO developerDTO);

    public void deleteAll();

    public void deleteById(Long id);
}
