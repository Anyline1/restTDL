package ru.anyline.resttdl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.anyline.resttdl.model.Store;

@Repository
public interface StoreRepo extends JpaRepository<Store, Long> {
}
