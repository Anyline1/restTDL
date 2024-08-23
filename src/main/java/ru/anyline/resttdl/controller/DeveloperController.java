package ru.anyline.resttdl.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.anyline.resttdl.DTO.DeveloperDTO;
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
    public List<DeveloperDTO> getAllDevs() {
        return developerService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeveloperDTO> getDevById(@PathVariable Long id) {
        return developerService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public DeveloperDTO createDev(@RequestBody DeveloperDTO developerDTO) {
        return developerService.save(developerDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DeveloperDTO> updateDev(@PathVariable Long id, @RequestBody DeveloperDTO developerDTO) {
        return developerService.findById(id)
                .map(existingAuthor -> {
                    existingAuthor.setName(developerDTO.getName());
                    return ResponseEntity.ok(developerService.save(existingAuthor));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDev(@PathVariable Long id) {
        if (developerService.findById(id).isPresent()) {
            developerService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
