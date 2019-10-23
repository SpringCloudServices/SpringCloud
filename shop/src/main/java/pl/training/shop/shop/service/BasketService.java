package pl.training.shop.shop.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pl.training.shop.shop.model.Basket;
import pl.training.shop.shop.model.ResultPage;
import pl.training.shop.shop.repository.BasketsRepository;


@RequiredArgsConstructor
@Service
public class BasketService {

    @NonNull
    private BasketsRepository basketsRepository;

    public void addBasket(Basket basket) {

        basketsRepository.saveAndFlush(basket);
    }

    public ResultPage<Basket> getBaskets(int pageNumber, int pageSize) {
        Page<Basket> basketsPage = basketsRepository.findAll(PageRequest.of(pageNumber, pageSize));

        return new ResultPage<>(basketsPage.getContent(), basketsPage.getNumber(), basketsPage.getTotalPages());
    }

}
