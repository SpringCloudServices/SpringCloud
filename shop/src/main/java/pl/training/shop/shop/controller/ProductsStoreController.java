package pl.training.shop.shop.controller;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.training.shop.shop.dto.PageDto;
import pl.training.shop.shop.dto.ProductStoreDto;
import pl.training.shop.shop.model.Mapper;
import pl.training.shop.shop.model.ProductStore;
import pl.training.shop.shop.model.ResultPage;
import pl.training.shop.shop.service.ProductsStoreService;

import java.net.URI;
import java.util.List;


@RequestMapping(value = "products")
@RestController
@RequiredArgsConstructor
public class ProductsStoreController {


    @NonNull
    private ProductsStoreService productsStoreService;

    @NonNull
    private Mapper mapper;
    private UriBuilder uriBuilder = new UriBuilder();

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity createProductStorePosition(@RequestBody ProductStoreDto productStorePositionDto) {
        ProductStore productStorePosition = mapper.map(productStorePositionDto, ProductStore.class);
        productsStoreService.addProductsStorePosition(productStorePosition);
        URI uri = uriBuilder.requestUriWithId(productStorePosition.getId());
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public PageDto<ProductStoreDto> getUsers(
            @RequestParam(required = false, defaultValue = "0", name = "pageNumber") int pageNumber,
            @RequestParam(required = false, defaultValue = "10", name = "pageSize") int pageSize) {
        ResultPage<ProductStore> resultPage = productsStoreService.getProductsStore(pageNumber, pageSize);
        List<ProductStoreDto> productStoreDto = mapper.map(resultPage.getContent(), ProductStoreDto.class);
        return new PageDto<>(productStoreDto, resultPage.getPageNumber(), resultPage.getTotalPages());
    }
}
