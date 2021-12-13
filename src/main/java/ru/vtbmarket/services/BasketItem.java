package ru.vtbmarket.services;

public class BasketItem {
    private PriceListItem goods;
    private int qty;

    public BasketItem(PriceListItem goods, int qty) {
        this.goods = goods;
        this.qty = qty;
    }
}
