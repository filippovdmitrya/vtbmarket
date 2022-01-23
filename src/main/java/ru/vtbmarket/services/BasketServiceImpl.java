package ru.vtbmarket.services;

import org.springframework.stereotype.Service;
import ru.vtbmarket.entities.BasketEntity;
import ru.vtbmarket.repository.BasketRepository;
import ru.vtbmarket.services.interfaces.BasketService;

@Service
public class BasketServiceImpl implements BasketService {

    private BasketRepository basketRepository;

    public BasketServiceImpl(BasketRepository basketRepository) {
        this.basketRepository = basketRepository;
    }

    @Override
    public void print() {
        System.out.println(
                basketRepository.findAll());
    }

    @Override
    public BasketEntity create(String username) {
        return null;
    }
}
