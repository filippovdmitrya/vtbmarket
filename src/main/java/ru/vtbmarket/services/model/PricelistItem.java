package ru.vtbmarket.services.model;

public class PricelistItem {
    private final String    name;
    private final String    description;
    private final int       price; // цена в копейках!
    private final int       balance;
    private final int       goods_id; //id товара
    private final int       store_id; //id записи в таблице store


    public PricelistItem(String name, String description, int price, int balance, int goods_id, int store_id) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.balance = balance;
        this.goods_id = goods_id;
        this.store_id = store_id;
    }

    public int getPrice() {
        return price;
    }

    public int getGoods_id() {
        return goods_id;
    }

    public int getBalance() {
        return balance;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public int getStore_id() {
        return store_id;
    }
    @Override
    public String toString() {
        return  "| " + "наименование ='" + name + '\'' +
                ", цена = " + (price * 0.01) + // перевод из копеек в рубли
                ", остаток = " + balance + '|';
    }
}
