package in.ankitsaahariya.retailhub_pos.repository;

import in.ankitsaahariya.retailhub_pos.entity.UserEntity;
import in.ankitsaahariya.retailhub_pos.io.UserResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,Long> {

    Optional<UserEntity> findByEmail(String email);

    Optional<UserEntity> findByUserId(String userId);
}
