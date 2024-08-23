package ru.anyline.resttdl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.anyline.resttdl.model.Store;

public interface StoreRepo extends JpaRepository<Store, Long> {
}
