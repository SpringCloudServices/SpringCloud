package pl.training.shop.shop.dto;

import lombok.Data;

@Data
public class BasketDto {
    private String userLogin;
    private String productName;
    private Long prodQuantity;
    private double unitPrice;

}
