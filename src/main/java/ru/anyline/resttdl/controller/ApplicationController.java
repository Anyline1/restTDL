package ru.anyline.resttdl.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.anyline.resttdl.model.Application;
import ru.anyline.resttdl.service.ApplicationService;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping
    public List<Application> getAllBooks() {
        return applicationService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Application> getBookById(@PathVariable Long id) {
        return applicationService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Application createBook(@RequestBody Application application) {
        return applicationService.save(application);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Application> updateBook(@PathVariable Long id, @RequestBody Application application) {
        return applicationService.findById(id)
                .map(existingApp -> {
                    existingApp.setName(application.getName());
                    existingApp.setDeveloper(application.getDeveloper());
                    existingApp.setCompanies(application.getCompanies());
                    return ResponseEntity.ok(applicationService.save(existingApp));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        if (applicationService.findById(id).isPresent()) {
            applicationService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
