package pl.training.shop.shop.dto;

import lombok.Data;

@Data
public class ProductStoreDto {
    private String name;
    private String description;
    private Long quantity;
    private double unitPrice;
}
