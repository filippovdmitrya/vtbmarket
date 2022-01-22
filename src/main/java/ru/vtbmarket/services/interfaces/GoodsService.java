package ru.vtbmarket.services.interfaces;

import ru.vtbmarket.entities.GoodsEntity;

public interface GoodsService {
    void print();
    void printDescription(int id);
    GoodsEntity get(Integer id);
}
