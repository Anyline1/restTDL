package ru.anyline.resttdl.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    public List<Store> getAllLibraries() {
        return storeService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Store> getLibraryById(@PathVariable Long id) {
        return storeService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Store createLibrary(@RequestBody Store store) {
        return storeService.save(store);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Store> updateLibrary(@PathVariable Long id, @RequestBody Store store) {
        return storeService.findById(id)
                .map(existingStore -> {
                    existingStore.setName(store.getName());
                    existingStore.setApplications(store.getApplications());
                    return ResponseEntity.ok(storeService.save(existingStore));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLibrary(@PathVariable Long id) {
        if (storeService.findById(id).isPresent()) {
            storeService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
