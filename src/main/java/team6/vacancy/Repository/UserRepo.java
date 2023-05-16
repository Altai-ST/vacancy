package team6.vacancy.Repository;

import org.springframework.data.repository.CrudRepository;
import team6.vacancy.Entity.UserEntity;

import java.util.Optional;

public interface UserRepo extends CrudRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);
    Optional<UserEntity> findByEmail(String email);
    UserEntity findByNumberphone(String number);
}
