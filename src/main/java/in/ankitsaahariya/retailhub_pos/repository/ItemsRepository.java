package in.ankitsaahariya.retailhub_pos.repository;

import in.ankitsaahariya.retailhub_pos.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ItemsRepository extends JpaRepository<ItemEntity,Long> {

    Optional<ItemEntity>  findByItemId(String id);

    Integer countByCategoryId(Long id);
}
