package ru.vtbmarket.services.interfaces;

public interface BasketListService {
    void print();
    void create(Integer basket_id, Integer goods_id, Integer qty, Integer price);
}
