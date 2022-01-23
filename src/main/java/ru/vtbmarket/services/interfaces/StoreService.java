package ru.vtbmarket.services.interfaces;

import ru.vtbmarket.services.model.PricelistItem;

public interface StoreService {
    void print();
    void printPricelist();
    PricelistItem get(int n);
}
