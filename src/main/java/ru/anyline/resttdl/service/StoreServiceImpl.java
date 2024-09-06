package ru.anyline.resttdl.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.anyline.resttdl.DTO.StoreDTO;
import ru.anyline.resttdl.mapper.StoreMapper;
import ru.anyline.resttdl.model.Store;
import ru.anyline.resttdl.repository.StoreRepo;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@AllArgsConstructor
@Service
public class StoreServiceImpl implements StoreService {

    private final StoreRepo storeRepo;

    @Override
    public List<StoreDTO> findAll() {
        return storeRepo.findAll()
                .stream()
                .map(StoreMapper.INSTANCE::toStoreDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<StoreDTO> findById(Long id) {
        return storeRepo.findById(id)
                .map(StoreMapper.INSTANCE::toStoreDTO);
    }


    @Override
    public StoreDTO save(StoreDTO storeDTO) {
        Store store = StoreMapper.INSTANCE.toStore(storeDTO);
        return StoreMapper.INSTANCE.toStoreDTO(storeRepo.save(store));
    }

    @Override
    public void deleteById(Long id) {
        storeRepo.deleteById(id);
    }

}