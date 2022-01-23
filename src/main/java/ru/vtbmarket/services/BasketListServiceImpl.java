package ru.vtbmarket.services;

import org.springframework.stereotype.Service;
import ru.vtbmarket.entities.BasketListEntity;
import ru.vtbmarket.repository.BasketListRepository;
import ru.vtbmarket.services.interfaces.BasketListService;

@Service
public class BasketListServiceImpl implements BasketListService {

    private BasketListRepository basketListRepository;

    public BasketListServiceImpl(BasketListRepository basketListRepository) {
        this.basketListRepository = basketListRepository;
    }

    @Override
    public void print() {
        System.out.println(
                basketListRepository.findAll());
    }

    @Override
    public void create(Integer basket_id, Integer goods_id, Integer qty, Integer price) {
        basketListRepository.save(
            new BasketListEntity(basket_id, goods_id, qty, price) );
    }
}
