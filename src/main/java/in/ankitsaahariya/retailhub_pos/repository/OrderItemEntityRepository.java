package in.ankitsaahariya.retailhub_pos.repository;

import in.ankitsaahariya.retailhub_pos.entity.OrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemEntityRepository extends JpaRepository<OrderItemEntity,Long> {
}
