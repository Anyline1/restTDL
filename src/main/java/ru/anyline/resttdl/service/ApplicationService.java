package ru.anyline.resttdl.service;


import org.springframework.stereotype.Service;
import ru.anyline.resttdl.model.Application;
import ru.anyline.resttdl.repository.ApplicationRepo;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicationService {

    private final ApplicationRepo applicationRepo;

    public ApplicationService(ApplicationRepo applicationRepo) {
        this.applicationRepo = applicationRepo;
    }

    public List<Application> findAll() {
        return applicationRepo.findAll();
    }

    public Optional<Application> findById(Long id) {
        return applicationRepo.findById(id);
    }

    public Application save(Application application) {
        return applicationRepo.save(application);
    }

    public void deleteById(Long id) {
        applicationRepo.deleteById(id);
    }
}
