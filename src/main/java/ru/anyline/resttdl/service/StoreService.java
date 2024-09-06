package ru.anyline.resttdl.service;

import ru.anyline.resttdl.DTO.ApplicationDTO;
import ru.anyline.resttdl.DTO.StoreDTO;

import java.util.List;
import java.util.Optional;

public interface StoreService {

    public List<StoreDTO> findAll();
    public Optional<StoreDTO> findById(Long id);
    public StoreDTO save(StoreDTO storeDTO);
    public void deleteById(Long id);
}
