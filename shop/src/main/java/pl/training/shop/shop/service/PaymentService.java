package pl.training.shop.shop.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import pl.training.shop.shop.dto.PaymentDto;

import java.util.Optional;

@Primary
@Service
@Log
@RequiredArgsConstructor
public class PaymentService {

    @NonNull
    private PaymentClientI paymentClientI;

    @Cacheable(value = "payment", unless = "#result == null")
    public Optional<String> sendPayment(PaymentDto paymentDto) {
        try {
            log.info("Payment realisation -------->");
            ResponseEntity departmentDto = paymentClientI.getDepartmentName(paymentDto);
            if (departmentDto.getStatusCode().equals(HttpStatus.ACCEPTED)) {

                // delete user basket: TODO
                // update ProductsStore quantity: TODO

                return Optional.of("Payment was realised ------>");
            }
            else{
                return Optional.of("Payment wasn't realised ------>");
            }
        } catch (HttpClientErrorException ex) {
            log.warning("Error ----> (" + ex.getMessage() + ")");
        }
        return Optional.empty();
    }

    @CacheEvict(value = "departments", allEntries = true)
    @StreamListener(Sink.INPUT)
    public void onDepartmentChange(String message) {
        log.info("Cleaning departments cache...");
    }

}
