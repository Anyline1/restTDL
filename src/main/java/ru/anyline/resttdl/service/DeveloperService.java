package ru.anyline.resttdl.service;

import org.springframework.stereotype.Service;
import ru.anyline.resttdl.model.Developer;
import ru.anyline.resttdl.repository.DeveloperRepo;

import java.util.List;
import java.util.Optional;

@Service
public class DeveloperService {

    private final DeveloperRepo developerRepo;

    public DeveloperService(DeveloperRepo developerRepo) {
        this.developerRepo = developerRepo;
    }

    public List<Developer> findAll() {
        return developerRepo.findAll();
    }

    public Optional<Developer> findById(Long id) {
        return developerRepo.findById(id);
    }

    public Developer save(Developer developer) {
        return developerRepo.save(developer);
    }

    public void deleteById(Long id) {
        developerRepo.deleteById(id);
    }
}
