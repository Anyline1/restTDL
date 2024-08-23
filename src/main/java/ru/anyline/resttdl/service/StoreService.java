package ru.anyline.resttdl.service;

import org.springframework.stereotype.Service;
import ru.anyline.resttdl.model.Store;
import ru.anyline.resttdl.repository.StoreRepo;

import java.util.List;
import java.util.Optional;

@Service
public class StoreService {

    private final StoreRepo storeRepo;

    public StoreService(StoreRepo storeRepo) {
        this.storeRepo = storeRepo;
    }

    public List<Store> findAll() {
        return storeRepo.findAll();
    }

    public Optional<Store> findById(Long id) {
        return storeRepo.findById(id);
    }

    public Store save(Store library) {
        return storeRepo.save(library);
    }

    public void deleteById(Long id) {
        storeRepo.deleteById(id);
    }
}