package ru.anyline.resttdl.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.anyline.resttdl.DTO.StoreDTO;
import ru.anyline.resttdl.model.Store;
import ru.anyline.resttdl.service.StoreService;

import java.util.List;

@RestController
@RequestMapping("/api/store")
public class StoreController {

    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping
    public List<StoreDTO> getAllStores() {
        return storeService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StoreDTO> getStoreById(@PathVariable Long id) {
        return storeService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public StoreDTO createStore(@RequestBody StoreDTO storeDTO) {
        return storeService.save(storeDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StoreDTO> updateStore(@PathVariable Long id, @RequestBody StoreDTO storeDTO) {
        return storeService.findById(id)
                .map(existingStore -> {
                    existingStore.setName(storeDTO.getName());
                    existingStore.setApplications(storeDTO.getApplications());
                    return ResponseEntity.ok(storeService.save(existingStore));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSore(@PathVariable Long id) {
        if (storeService.findById(id).isPresent()) {
            storeService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
