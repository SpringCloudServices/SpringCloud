package pl.training.shop.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.training.shop.shop.model.ProductStore;

public interface ProductsStoreRepository extends JpaRepository<ProductStore, Long> {

}
