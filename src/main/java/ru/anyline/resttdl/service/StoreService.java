package ru.anyline.resttdl.service;

import org.springframework.stereotype.Service;
import ru.anyline.resttdl.DTO.ApplicationDTO;
import ru.anyline.resttdl.DTO.StoreDTO;
import ru.anyline.resttdl.mapper.ApplicationMapper;
import ru.anyline.resttdl.mapper.StoreMapper;
import ru.anyline.resttdl.model.Application;
import ru.anyline.resttdl.model.Store;
import ru.anyline.resttdl.repository.StoreRepo;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StoreService {

    private final StoreRepo storeRepo;

    public StoreService(StoreRepo storeRepo) {
        this.storeRepo = storeRepo;
    }

    public List<StoreDTO> findAll() {
        return storeRepo.findAll()
                .stream()
                .map(StoreMapper.INSTANCE::toStoreDTO)
                .collect(Collectors.toList());
    }

    public Optional<StoreDTO> findById(Long id) {
        return storeRepo.findById(id)
                .map(StoreMapper.INSTANCE::toStoreDTO);
    }

    public StoreDTO save(StoreDTO storeDTO) {
        Store store = StoreMapper.INSTANCE.toStore(storeDTO);
        return StoreMapper.INSTANCE.toStoreDTO(storeRepo.save(store));
    }

    public void deleteById(Long id) {
        storeRepo.deleteById(id);
    }
}