package pl.training.shop.shop.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pl.training.shop.shop.dto.PaymentDto;

@FeignClient("payment")
public interface PaymentClientI {

    @PostMapping("payment")
    ResponseEntity getDepartmentName(@RequestBody PaymentDto paymentDto);

}
