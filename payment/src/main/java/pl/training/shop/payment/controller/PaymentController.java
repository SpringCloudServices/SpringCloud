package pl.training.shop.payment.controller;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.training.shop.payment.dto.PaymentDto;
import pl.training.shop.payment.model.Mapper;



@RequestMapping(value = "payment")
@RestController
@RequiredArgsConstructor
public class PaymentController {

    @NonNull
    private Mapper mapper;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity paymentRealize(@RequestBody PaymentDto paymentDto) {

        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }

}
