package pl.training.shop.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.training.shop.shop.model.Basket;
import pl.training.shop.shop.model.User;

public interface BasketsRepository extends JpaRepository<Basket, Long> {
}
