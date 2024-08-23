package ru.anyline.resttdl.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.anyline.resttdl.DTO.StoreDTO;
import ru.anyline.resttdl.model.Store;

@Mapper
public interface StoreMapper {

    StoreMapper INSTANCE = Mappers.getMapper(StoreMapper.class);
    StoreDTO toStoreDTO(Store store);
    Store toStore(StoreDTO storeDTO);


}
