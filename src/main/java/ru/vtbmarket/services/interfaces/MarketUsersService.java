package ru.vtbmarket.services.interfaces;

import ru.vtbmarket.entities.MarketUsersEntity;

import java.util.Collection;

public interface MarketUsersService {
    void print();
    Collection<MarketUsersEntity> getAll();
}
