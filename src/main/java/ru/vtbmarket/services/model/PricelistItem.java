package ru.vtbmarket.services.model;

public class PricelistItem {
    private final String    name;
    private final String    description;
    private final int       price; // цена в копейках!
    private final int       balance;
    private final int       goods_id; //id товара

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return  "| " + "наименование ='" + name + '\'' +
                ", цена = " + (price * 0.01) + // перевод из копеек в рубли
                ", остаток = " + balance + '|';
    }

    public String getDescription() {
        return description;
    }

    public PricelistItem(String name, String description, int price, int balance, int goods_id) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.balance = balance;
        this.goods_id = goods_id;
    }

}
