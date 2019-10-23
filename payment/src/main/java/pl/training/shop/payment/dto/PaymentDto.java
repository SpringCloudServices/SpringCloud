package pl.training.shop.payment.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class PaymentDto {
    private String userLogin;
    private Double paymentAmount;
    private String paymentStatus;
}
