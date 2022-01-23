package ru.vtbmarket.services.model;

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
    public int getBasketSize() {
        return basket.size();
    }

    public double getBasketSum() {
        int s = 0;
        for (BasketItem basketItem : basket) {
            s = s + basketItem.getItemSum();
        }
        return s * 0.01; // перевод из копеек в рубли
    }

    public String getUsername() {
        return username;
    }
}
