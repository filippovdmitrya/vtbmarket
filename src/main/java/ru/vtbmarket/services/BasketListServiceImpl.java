package ru.vtbmarket.services;

import org.springframework.stereotype.Service;
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
}
