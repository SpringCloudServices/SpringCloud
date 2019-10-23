package pl.training.shop.shop.service;


import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pl.training.shop.shop.model.ProductStore;
import pl.training.shop.shop.model.ResultPage;
import pl.training.shop.shop.repository.ProductsStoreRepository;

@RequiredArgsConstructor
@Service
public class ProductsStoreService {
    @NonNull
    private ProductsStoreRepository productsRepository;

    public void addProductsStorePosition(ProductStore productStorePosition) {

        productsRepository.saveAndFlush(productStorePosition);
    }

    public ResultPage<ProductStore> getProductsStore(int pageNumber, int pageSize) {
        Page<ProductStore> productsStore = productsRepository.findAll(PageRequest.of(pageNumber, pageSize));

        return new ResultPage<>(productsStore.getContent(), productsStore.getNumber(), productsStore.getTotalPages());
    }

}
