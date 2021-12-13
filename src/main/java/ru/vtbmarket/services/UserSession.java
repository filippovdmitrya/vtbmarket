package ru.vtbmarket.services;

import java.util.ArrayList;
import java.util.List;

public class UserSession {
    private final String username;
    private List<BasketItem> basket = new ArrayList<>();


    public UserSession(String    username) {
        this.username = username;
    }
    public void putBasket(BasketItem i) {
        basket.add(i);
    }
}
