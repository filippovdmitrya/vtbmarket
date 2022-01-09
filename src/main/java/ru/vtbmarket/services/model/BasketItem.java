package ru.vtbmarket.services.model;

public class BasketItem {
    private PriceListItem goods;
    private int qty;

    public BasketItem(PriceListItem goods, int qty) {
        this.goods = goods;
        this.qty = qty;
    }

    public double getItemSum() {
        return goods.getPrice() * (double) qty;
    }
}
