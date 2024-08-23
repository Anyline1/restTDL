package ru.anyline.resttdl.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.anyline.resttdl.DTO.ApplicationDTO;
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
    public List<ApplicationDTO> getAllApps() {
        return applicationService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApplicationDTO> getAppById(@PathVariable Long id) {
        return applicationService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ApplicationDTO createApp(@RequestBody ApplicationDTO applicationDTO) {
        return applicationService.save(applicationDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApplicationDTO> updateApp(@PathVariable Long id, @RequestBody ApplicationDTO applicationDTO) {
        return applicationService.findById(id)
                .map(existingApp -> {
                    existingApp.setName(applicationDTO.getName());
                    existingApp.setDeveloper(applicationDTO.getDeveloper());
                    existingApp.setCompanies(applicationDTO.getCompanies());
                    return ResponseEntity.ok(applicationService.save(existingApp));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApp(@PathVariable Long id) {
        if (applicationService.findById(id).isPresent()) {
            applicationService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
