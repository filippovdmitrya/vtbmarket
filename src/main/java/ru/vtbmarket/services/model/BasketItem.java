package ru.vtbmarket.services.model;

public class BasketItem {
    private PricelistItem goods;
    private int qty;

    public BasketItem(PricelistItem goods, int qty) {
        this.goods = goods;
        this.qty = qty;
    }

    public int getItemSum() {
        return goods.getPrice() * qty;
    }

    public int getQty() {
        return qty;
    }

    public PricelistItem getGoods() {
        return goods;
    }
}
