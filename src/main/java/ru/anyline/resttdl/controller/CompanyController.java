package ru.anyline.resttdl.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.anyline.resttdl.DTO.CompanyDTO;
import ru.anyline.resttdl.service.CompanyServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {

    private final CompanyServiceImpl companyService;

    public CompanyController(CompanyServiceImpl companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public List<CompanyDTO> getAllComps() {
        return companyService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyDTO> getCompsById(@PathVariable Long id) {
        return companyService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public CompanyDTO createCompany(@RequestBody CompanyDTO companyDTO) {
        return companyService.save(companyDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CompanyDTO> updateCompany(@PathVariable Long id, @RequestBody CompanyDTO companyDTO) {
        return companyService.findById(id)
                .map(existingCompany -> {
                    existingCompany.setName(companyDTO.getName());
                    return ResponseEntity.ok(companyService.save(existingCompany));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompany(@PathVariable Long id) {
        if (companyService.findById(id).isPresent()) {
            companyService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
