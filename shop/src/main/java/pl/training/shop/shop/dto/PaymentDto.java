package pl.training.shop.shop.dto;

import lombok.Data;

@Data
public class PaymentDto {
    private String userLogin;
    private Double paymentAmount;
    private String paymentStatus;
}
