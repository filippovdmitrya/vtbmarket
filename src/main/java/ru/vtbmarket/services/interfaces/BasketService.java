package ru.vtbmarket.services.interfaces;

import ru.vtbmarket.entities.BasketEntity;

public interface BasketService {
    void print();
    BasketEntity create(String username);
}
