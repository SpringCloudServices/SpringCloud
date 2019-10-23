package pl.training.shop.shop.controller;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.training.shop.shop.dto.BasketDto;
import pl.training.shop.shop.dto.PageDto;
import pl.training.shop.shop.dto.PaymentDto;
import pl.training.shop.shop.model.Basket;
import pl.training.shop.shop.model.Mapper;
import pl.training.shop.shop.model.ResultPage;
import pl.training.shop.shop.service.BasketService;
import pl.training.shop.shop.service.PaymentService;

import java.net.URI;
import java.util.List;

@RequestMapping(value = "baskets")
@RestController
@RequiredArgsConstructor
public class BasketsController {

    @NonNull
    private BasketService basketService;

    @NonNull
    private PaymentService paymentService;

    @NonNull
    private Mapper mapper;
    private UriBuilder uriBuilder = new UriBuilder();

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity createUser(@RequestBody BasketDto basketDto) {
        Basket basket = mapper.map(basketDto, Basket.class);
        basketService.addBasket(basket);
        URI uri = uriBuilder.requestUriWithId(basket.getId());
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public PageDto<BasketDto> getBaskets(
            @RequestParam(required = false, defaultValue = "0", name = "pageNumber") int pageNumber,
            @RequestParam(required = false, defaultValue = "10", name = "pageSize") int pageSize) {
        PaymentDto pdto = new PaymentDto();
        ResultPage<Basket> resultPage = basketService.getBaskets(pageNumber, pageSize);
        List<BasketDto> basketDto = mapper.map(resultPage.getContent(), BasketDto.class);
        return new PageDto<>(basketDto, resultPage.getPageNumber(), resultPage.getTotalPages());
    }

    //:TODO Controller realise payment

}
