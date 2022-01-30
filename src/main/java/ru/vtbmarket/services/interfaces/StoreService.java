package ru.vtbmarket.services.interfaces;

import ru.vtbmarket.services.model.PricelistItem;

public interface StoreService {
    void print();
    void printPricelist();
    PricelistItem get(int id);
    void update(int id,int goods_id, int price, int balance, int qty);
}
