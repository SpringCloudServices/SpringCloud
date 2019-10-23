package pl.training.shop.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.training.shop.shop.model.User;

public interface UsersRepository extends JpaRepository<User, Long> {
}
