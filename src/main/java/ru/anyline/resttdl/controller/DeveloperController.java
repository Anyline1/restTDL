package ru.anyline.resttdl.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.anyline.resttdl.model.Developer;
import ru.anyline.resttdl.service.DeveloperService;

import java.util.List;

@RestController
@RequestMapping("/api/developers")
public class DeveloperController {

    private final DeveloperService developerService;

    public DeveloperController(DeveloperService developerService) {
        this.developerService = developerService;
    }

    @GetMapping
    public List<Developer> getAllAuthors() {
        return developerService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Developer> getAuthorById(@PathVariable Long id) {
        return developerService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Developer createAuthor(@RequestBody Developer author) {
        return developerService.save(author);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Developer> updateAuthor(@PathVariable Long id, @RequestBody Developer developer) {
        return developerService.findById(id)
                .map(existingAuthor -> {
                    existingAuthor.setName(developer.getName());
                    return ResponseEntity.ok(developerService.save(existingAuthor));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
        if (developerService.findById(id).isPresent()) {
            developerService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
